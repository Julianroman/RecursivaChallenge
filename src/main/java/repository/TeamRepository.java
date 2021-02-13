package repository;

import java.util.ArrayList;
import java.util.List;

import model.Team;

public class TeamRepository {

	private static TeamRepository instance;
	private List<Team> team = new ArrayList<>();
	
	public static TeamRepository getInstance(){
		if(instance == null) {
			instance = new TeamRepository();
		}
		return instance;
	}
	
	public void addTeam(Team team) {
		this.team.add(team);
	}
	
	public List<Team> getTeams(){
		return this.team;
	}

	public int getQuantityTeams() {
		return this.team.size();
	}
}
