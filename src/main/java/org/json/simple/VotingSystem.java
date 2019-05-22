package org.json.simple;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VotingSystem {

	public static void main(String[] args) {
		
//		Vote
		JSONObject VoteDetail = new JSONObject();
		VoteDetail.put("Country", "Netherlands");
		VoteDetail.put("VotesFor", "Belgium");
		
		JSONObject VoteObject = new JSONObject();
		VoteObject.put("vote", VoteDetail);
		
//		2nd Vote
		JSONObject VoteDetail2 = new JSONObject();
		VoteDetail2.put("Country", "Italy");
		VoteDetail2.put("VotesFor", "Germany");
		
		JSONObject VoteObject2 = new JSONObject();
		VoteObject2.put("vote", VoteDetail2);
		
//		3rd Vote
		JSONObject VoteDetail3 = new JSONObject();
		VoteDetail3.put("Country", "Netherlands");
		VoteDetail3.put("VotesFor", "Germany");
		
		JSONObject VoteObject3 = new JSONObject();
		VoteObject3.put("vote", VoteDetail3);

//		4th Vote
		JSONObject VoteDetail4 = new JSONObject();
		VoteDetail4.put("Country", "Netherlands");
		VoteDetail4.put("VotesFor", "Belgium");
		
		JSONObject VoteObject4 = new JSONObject();
		VoteObject4.put("vote", VoteDetail4);

//		5th Vote
		JSONObject VoteDetail5 = new JSONObject();
		VoteDetail5.put("Country", "Netherlands");
		VoteDetail5.put("VotesFor", "Italy");
		
		JSONObject VoteObject5 = new JSONObject();
		VoteObject5.put("vote", VoteDetail5);
		
//		6th Vote
		JSONObject VoteDetail6 = new JSONObject();
		VoteDetail6.put("Country", "Netherlands");
		VoteDetail6.put("VotesFor", "Belgium");
		
		JSONObject VoteObject6 = new JSONObject();
		VoteObject6.put("vote", VoteDetail6);
		
//		7th Vote
		JSONObject VoteDetail7 = new JSONObject();
		VoteDetail7.put("Country", "Netherlands");
		VoteDetail7.put("VotesFor", "Belgium");
		
		JSONObject VoteObject7 = new JSONObject();
		VoteObject7.put("vote", VoteDetail7);
		
//		8th Vote
		JSONObject VoteDetail8 = new JSONObject();
		VoteDetail8.put("Country", "Netherlands");
		VoteDetail8.put("VotesFor", "Spain");
		
		JSONObject VoteObject8 = new JSONObject();
		VoteObject8.put("vote", VoteDetail8);
		
//		9th Vote
		JSONObject VoteDetail9 = new JSONObject();
		VoteDetail9.put("Country", "Netherlands");
		VoteDetail9.put("VotesFor", "Denmark");
		
		JSONObject VoteObject9 = new JSONObject();
		VoteObject9.put("vote", VoteDetail9);
		
//		10th Vote
		JSONObject VoteDetail10 = new JSONObject();
		VoteDetail10.put("Country", "Netherlands");
		VoteDetail10.put("VotesFor", "Belgium");
		
		JSONObject VoteObject10 = new JSONObject();
		VoteObject10.put("vote", VoteDetail10);
		
//		11th Vote
		JSONObject VoteDetail11 = new JSONObject();
		VoteDetail11.put("Country", "Netherlands");
		VoteDetail11.put("VotesFor", "Denmark");
		
		JSONObject VoteObject11 = new JSONObject();
		VoteObject11.put("vote", VoteDetail11);
		
//		12th Vote
		JSONObject VoteDetail12 = new JSONObject();
		VoteDetail12.put("Country", "Netherlands");
		VoteDetail12.put("VotesFor", "Denmark");
		
		JSONObject VoteObject12 = new JSONObject();
		VoteObject12.put("vote", VoteDetail12);
		
//		add votes to list
		JSONArray votesList = new JSONArray();
		votesList.add(VoteObject);
		votesList.add(VoteObject2);
		votesList.add(VoteObject3);
		votesList.add(VoteObject4);
		votesList.add(VoteObject5);
		votesList.add(VoteObject5);
		votesList.add(VoteObject6);
		votesList.add(VoteObject7);
		votesList.add(VoteObject8);
		votesList.add(VoteObject9);
		votesList.add(VoteObject10);
		votesList.add(VoteObject11);
		
//		write JSON file
		try(FileWriter file = new FileWriter("votes.json")) {
			file.write(votesList.toString());			
			file.flush();
			System.out.println(votesList.toString());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}

}
