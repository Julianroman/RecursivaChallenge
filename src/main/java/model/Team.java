package model;

import java.util.ArrayList;
import java.util.List;

import repository.TeamRepository;

public class Team {
	
	private String name;
	private List<Fan> fans = new ArrayList<>();
	
	public Team (String name) {
		this.setName(name);
		
		TeamRepository.getInstance().addTeam(this);
	}
	
	//Getters - Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
