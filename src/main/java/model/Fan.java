package model;

import repository.FanRepository;

public class Fan {
	
	private String name;
	private int age;
	private Team team;
	private String civilStatus;
	private String study;
	private FanRepository fanRepository;

	public Fan(String name, int age, Team team, String civilStatus, String study) {
		this.setName(name);
		this.setAge(age);
		this.setTeam(team);
		this.setCivilStatus(civilStatus);
		this.setStudy(study);
		
		FanRepository.getInstance().addMember(this);
	}

	
	//Getters - setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}
	

}
