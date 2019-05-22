package org.json.simple;

public class Vote {

	public String country;
	public String voteFor;
	public int count;
	
	public Vote (String country, String voteFor) {
		this.country = country;
		this.voteFor = voteFor;
	}
	
	public Vote (String country, String voteFor, int count ) {
		this.country = country;
		this.voteFor = voteFor;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVoteFor() {
		return voteFor;
	}

	public void setVoteFor(String voteFor) {
		this.voteFor = voteFor;
	}
	
}
