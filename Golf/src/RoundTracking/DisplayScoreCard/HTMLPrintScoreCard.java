package RoundTracking.DisplayScoreCard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

import javax.swing.text.html.StyleSheet;

import PlayerData.Player;
import RoundTracking.GolfRound;
import RoundTracking.PlayerScore;

public class HTMLPrintScoreCard extends PrintScoreCard {

	String htmlString;
	private static final String HTML_BEGIN = "<td style=\"text-align: center;\">"; 
	String HTML_END = "</td>\n";

	@Override
	public void print(GolfRound round) {
		this.round = round;

		JEditorPane jEditorPane = new JEditorPane();
		jEditorPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jEditorPane);
		HTMLEditorKit kit = new HTMLEditorKit();
		jEditorPane.setEditorKit(kit);
		StyleSheet styleSheet = kit.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		styleSheet.addRule("h1 {color: blue;}");
		styleSheet.addRule("h2 {color: #ff0000;}");
		styleSheet.addRule("pre {font : 14px monaco; color : black; background-color : #fafafa; }");

		// create some simple html as a string
		htmlString = "<html>\n"
				+"<head>\n"
				+"<title>circle</title>\n"
				+"<style type=\"text/css\">.circle_green {\n" 
				+ "width:1%;\n"
				+"padding:10px 11px;\n"
				+"margin:0 auto;\n"
				+"border-radius:20px;\n"
				+"border: 1px solid #B5A4A4;\n"
				+"width:20px;\n"
				+"height:20px;\n"
				+"}"
				+"</style>\n"
				+"</head>\n"
				+ "<body>\n"
				+ "<h1>" + round.getCourseName() + "</h1>\n"
				+ "<h2>" + round.getDateOfRound() + "</h2>\n"
				+ "<p>This is some sample text</p>\n"
				+ "<tr class=\"top bordertop\">"
				+ "<table style=\"text-align: left; width: 100%;\" border=\"2\" cellpadding=\"4\"cellspacing=\"0\">";


		//add hole numbers to table.
		this.addHoleNumbers();

		//add par to scorecard
		this.addPar();

		//add stroke index
		this.addStrokeIndex();

		//add net score
		this.addNetScore();

		//add gross score to scorecard
		this.addGrossScore();

		this.addPutts();

		//this.addGIR();


		htmlString += "</body>\n";

		// create a document, set it on the jeditorpane, then add the html
		Document doc = kit.createDefaultDocument();
		jEditorPane.setDocument(doc);
		jEditorPane.setText(htmlString);	
		JFrame j = new JFrame("HtmlEditorKit Test");
		j.getContentPane().add(scrollPane, BorderLayout.CENTER);
		// make it easy to close the application
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the frame
		//j.setSize(new Dimension(900,800));

		// pack it, if you prefer
		j.pack();

		// center the jframe, then make it visible
		j.setLocationRelativeTo(null);
		j.setVisible(true);

		System.out.println(htmlString);
	}


	public void addHoleNumbers(){
		this.addRow("Hole", true, false);

		for(int i=1 ; i<=round.getNumberOfHoles() ; i++){
			this.addRow(i, false, false);
			if(i%9 == 0){
				//print the totals after 9 holes
				if(i == 9){
					this.addRow("out", false, false);
				}
				else if(i == 18){
					this.addRow("in", false, false);
				}
				else{
					this.addRow("previous 9", false, false);
				}
			}
		}
		this.addRow("TOT", false, true);

	}
	public void addPar() {
		htmlString += "<tr>"
				+ "<td style=\"text-align: center;\">par</td>\n";
		int total = 0;
		for(int i=1 ; i<=round.getNumberOfHoles() ; i++){
			htmlString += "<td style=\"text-align: center;\">" + round.getParForHole(i) + "</td>\n";
			total += round.getParForHole(i);
			if(i%9 == 0) {
				htmlString += "<td style=\"text-align: center;\">" + total + "</td>\n";
				total=0;
			}
		}
		total = 0;
		for(int i=1 ; i<=round.getNumberOfHoles(); i++ ){
			total += round.getParForHole(i);
		}
		htmlString += "<td style=\"text-align: center;\">" + total + "</td>\n";
	}

	public void addStrokeIndex() {
		this.addRow("SI", true, false);
		for(int i=1 ; i<=round.getNumberOfHoles() ; i++){
			this.addRow(round.getGolfCourse().getStrokeIndexForHole(i), false, false);
			if(i%9 == 0) {
				this.addRow("", false, false);;
			}
		}
		this.addRow("", false, true);
	}


	public void addNetScore(){

		for(PlayerScore playerScore : round.getPlayersScores()){
			int grandTotal = 0;
			int total=0;

			this.addRow(playerScore.getPlayerName(), true, false);

			for(int hole=1 ; hole<=round.getNumberOfHoles() ; hole++){
				total += playerScore.getNetScoreForHole(hole);
				this.addRow(playerScore.getNetScoreForHole(hole), false, false);
				if(hole%9 ==0) {
					grandTotal += total;
					this.addRow(total, false, false);
					total=0;
				}
			}
			this.addRow(grandTotal, false, true);
		}
	}

	public void addGrossScore(){

		int total=0;
		int grandTotal=0;

		for(PlayerScore playerScore : round.getPlayersScores()){
			addRow(playerScore.getPlayerName(),true,false);
			for(int hole=1 ; hole<=round.getNumberOfHoles() ; hole++){
				total += playerScore.getGrossScoreForHole(hole);
				addRow(playerScore.getGrossScoreForHole(hole),false,false);
				if(hole%9 ==0) {
					addRow(Integer.toString(total),false,false);
					grandTotal+=total;
					total=0;
				}
			}
			addRow(grandTotal,false,true);
			total=0;
			grandTotal=0;
		}
	}

	public void addPutts(){

		for(PlayerScore playerScore : round.getPlayersScores()){

			this.addRow("putts", true, false);

			int total=0;
			int grandTotal=0;

			for(int hole=1 ; hole<=round.getNumberOfHoles() ; hole++){
				total += playerScore.getPuttsForHole(hole);
				this.addBirdyRow(playerScore.getPuttsForHole(hole));
				if(hole%9 ==0) {
					grandTotal += total;
					this.addRow(total, false, false);
					total=0;
				}
			}
			this.addRow(grandTotal, false, true);
		}
	}
	public void addGIR(){
		htmlString += "<tr>";
		htmlString += "<td style=\"text-align: center;\">GIR</td>\n";

		int total=0;
		for(int i=1 ; i<=round.getNumberOfHoles() ; i++){
			if(round.getGIRBoolForHole(i)) {total +=1;}
			htmlString += "<td style=\"text-align: center;\">" + round.getGIRforHole(i) + "</td>\n";
			if(i%9 ==0) {
				htmlString += "<td style=\"text-align: center;\">" + total + "</td>\n";
				total=0;
			}
		}
		total=0;
		for(int i=1 ; i<=round.getNumberOfHoles(); i++ ){
			if(round.getGIRBoolForHole(i)) {total +=1;}
		}
		htmlString += "<td style=\"text-align: center;\">" + total + "</td>\n";
	}
	public void addRow(String string, boolean startOfRow, boolean endOfRow){
		if(startOfRow){
			htmlString += "<tr>\n";
		}
		htmlString += HTML_BEGIN + string + HTML_END;

		if(endOfRow){
			htmlString += "</tr>\n";
		}
	}
	public void addRow(int string, boolean startOfRow, boolean endOfRow){
		addRow(Integer.toString(string),startOfRow,endOfRow);
	}
	
	public void addBirdyRow(int string){
		htmlString += HTML_BEGIN;
		htmlString += "<div class=\"circle_green\">" + string + "</div>";
		htmlString += HTML_END;
	}

}



