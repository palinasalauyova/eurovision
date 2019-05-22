package org.json.simple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadVotes {

	static Scanner sc = new Scanner(System.in);
	static String country;

	public static void main(String[] args) {
		askCountry(args);
		Vote v;
		ArrayList<Vote> votes = new ArrayList<Vote>();

//		to parse read file
		JSONParser jsonParser = new JSONParser();

		FileReader reader = null;
		try {
			reader = new FileReader(args[1]);

//			read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray votesList = (JSONArray) obj;
			int n = votesList.size();

//			iterate votes array
			votesList.forEach(vote -> parseVoteObject((JSONObject) vote, votes));


			countFreq(votes, n);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	-----------------------------------------------------------------------------
	public static void askCountry(String[] args) {
		country = args[0];
	}
//		-----------------------------------------------------------------------------

	public static void countFreq(ArrayList<Vote> votes, int n) {
		boolean visited[] = new boolean[n];
		ArrayList<Integer> countArray = new ArrayList<Integer>();
		ArrayList<Vote> filterVotes = new ArrayList<Vote>();

		Arrays.fill(visited, false);

		for (int i = 0; i < votes.size(); i++) {

			String countryI = votes.get(i).getCountry();
			String votesForI = votes.get(i).getVoteFor();
//				skip if processed
			if (visited[i] == true) {
				continue;
			}

//				count frequency
			int count = 1;
			for (int j = i + 1; j < votes.size(); j++) {
				String countryJ = votes.get(j).getCountry();
				String votesForJ = votes.get(j).getVoteFor();
				if (countryI.equals(countryJ) && votesForI.equals(votesForJ)) {
					visited[j] = true;
					count++;
				}
			}
			countArray.add(count);
			filterVotes.add(new Vote(countryI, votesForI, count));
		}

		givePoints(countArray, filterVotes);
	}

//		-----------------------------------------------------------------------------
	public static void givePoints(ArrayList<Integer> countArray, ArrayList<Vote> filterVotes) {
		int maxPoints = 12;
		int maxValue = 0;
		int index = 0;
		for (int l = 0; l < filterVotes.size();) {
			maxValue = 0;
			for (int k = 0; k < filterVotes.size(); k++) {
				if (maxValue < filterVotes.get(k).getCount()) {
					maxValue = filterVotes.get(k).getCount();
					index = k;
				}
			}
			String voteCountry = filterVotes.get(index).getCountry();
			String votesForL = filterVotes.get(index).getVoteFor();
			if (voteCountry.equals(country)) {
				System.out.println(votesForL + " points: " + maxPoints);
				if (maxPoints > 8) {
					maxPoints = maxPoints - 2;
				} else {
					maxPoints--;
				}
				filterVotes.remove(index);
			}
		}
	}

//		-----------------------------------------------------------------------------

	private static void parseVoteObject(JSONObject vote, ArrayList votes) {
//			get object from list
		JSONObject votesObject = (JSONObject) vote.get("vote");

//			voting country
		String votingCountry = (String) votesObject.get("Country");
		if (votingCountry.equals(country)) {


//			votes for
			String votesFor = (String) votesObject.get("VotesFor");

			votes.add(new Vote(votingCountry, votesFor));
		}
	}
}

