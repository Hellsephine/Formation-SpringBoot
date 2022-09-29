package m2i.spring.exercices.templates.controller;



public class Army {

	private int totalHealth;
	
	private int count;
	
	private String leaderName;

	public int getTotalHealth() {
		return totalHealth;
	}

	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public Army(int totalHealth, int count, String leaderName) {
		super();
		this.totalHealth = totalHealth;
		this.count = count;
		this.leaderName = leaderName;
	}
	
	protected Army()
	{
		
	}
}
