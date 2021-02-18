package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.Fan;
import model.Team;
import repository.TeamRepository;

public class TeamService {

	public Team getTeamByName(String teamName) {
		
		TeamRepository teamRepository = TeamRepository.getInstance();
		
		//Team team = teamRepository.getTeamByName(teamName);
		List<Team> repoTeams = teamRepository.getTeams();
		List<Team> teams = repoTeams.stream().filter(t -> t.getName().equals(teamName)).collect(Collectors.toList());
		if (teams.isEmpty()) {
			return new Team(teamName);
		}
		return teams.get(0);
	}
	
	public double getAverageAgeFrom(String teamName) {
		Team unTeam = this.getTeamByName(teamName);
		List<Fan> fans = getFansByTeam(unTeam);
		int fansSize = fans.size();
		int ageSum = fans.stream().map(Fan::getAge).mapToInt(Integer::intValue).sum();
		
		if (fansSize != 0) {
			return ageSum/fansSize;
		}
		return 0;
	}

	private List<Fan> getFansByTeam(Team team) {
		return team.getFans();
	}

	public List<String> getMostCommonsNamesOf(String teamName) {
		List<Fan> fans = getFansByTeam(this.getTeamByName(teamName));
		List<String> teamFansName = fans.stream().map(fan -> fan.getName()).collect(Collectors.toList());
		teamFansName.sort((fanName1, fanName2) -> Collections.frequency(teamFansName, fanName1) > Collections.frequency(teamFansName, fanName2) ? 0 : 1);
		
		Set<String> fansUniques = new LinkedHashSet<>(teamFansName);
        List<String> finalFans = new ArrayList<>(fansUniques);
        
		return finalFans.subList(0, 5);
	}

	public List<Team> getBigestTeams() {
		List<Team> teams = TeamRepository.getInstance().getTeams();

        teams.sort((team1, team2) -> team1.getQuantityMembers() > team2.getQuantityMembers() ? -1 : team1.getQuantityMembers() == team2.getQuantityMembers() ? 0 : 1);

        return teams;
	}
	
	
	public int getMinAgeFrom(String teamName) {
        List<Fan> fans = getFansByTeam(this.getTeamByName(teamName));

        return fans.stream().min((fan1, fan2) -> Integer.compare(fan1.getAge(), fan2.getAge())).get().getAge();
    }

    public int getMaxAgeFrom(String teamName) {
        List<Fan> fans = getFansByTeam(this.getTeamByName(teamName));

        return fans.stream().max((fan1, fan2) -> Integer.compare(fan1.getAge(), fan2.getAge())).get().getAge();
    }

}
