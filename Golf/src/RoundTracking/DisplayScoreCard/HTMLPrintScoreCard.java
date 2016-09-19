package RoundTracking.DisplayScoreCard;

import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import RoundTracking.GolfRound;
import RoundTracking.PlayerScore;
import RoundTracking.PrintScoreCard;

public class HTMLPrintScoreCard extends PrintScoreCard {

	String htmlString;

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
		//TODO need to work out how to display css code.
		// this works on this site http://www.w3schools.com/html/tryit.asp?filename=tryhtml_classes_span
		htmlString = "<html>\n"
				+"<head>\n"
				+"<title>circle_birdy</title>\n"
				+"<style type=\"text/css\">div.circle_birdy {\n" 
				+ "width:1%;\n"
				+"padding:10px 11px;\n"
				+"margin:0 auto;\n"
				+"border-radius:20px;\n"
				+"border: 1px solid #B5A4A4;\n"
				+"width:20px;\n"
				+"height:20px;\n"
				+"}"
				+"div.circle_bogey {\n" 
				+ "width:1%;\n"
				+"padding:10px 11px;\n"
				+"margin:0 auto;\n"
				+"border-radius:0px;\n"
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
		AddRowToScoreCard HTMLScoreCard = new AddRowToScoreCardHoleNumber(round.getGolfCourse(),"Hole");
		htmlString += HTMLScoreCard.getRow();
		//this.addHoleNumbers();

		//add par to scorecard
		HTMLScoreCard = new AddRowToScoreCardPar(round.getGolfCourse(),"Par");
		htmlString += HTMLScoreCard.getRow();

		//add stroke index
		HTMLScoreCard = new AddRowToScoreCardSI(round.getGolfCourse(),"SI");
		htmlString += HTMLScoreCard.getRow();

		//add net score
		for(PlayerScore playerScore : round.getPlayersScores()){

			HTMLScoreCard = new AddRowToScoreCardGross(playerScore,round.getGolfCourse());
			htmlString += HTMLScoreCard.getRow();
			HTMLScoreCard = new AddRowToScoreCardNet(playerScore,round.getGolfCourse());
			htmlString += HTMLScoreCard.getRow();
			HTMLScoreCard = new AddRowToScoreCardPutts(playerScore);
			htmlString += HTMLScoreCard.getRow();
			HTMLScoreCard = new AddRowToScoreCardGIR(playerScore);
			htmlString += HTMLScoreCard.getRow();
			HTMLScoreCard = new AddRowToScoreCardFIR(playerScore);
			htmlString += HTMLScoreCard.getRow();
		}

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
}



