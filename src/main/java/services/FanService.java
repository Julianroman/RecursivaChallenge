package services;

import java.util.List;
import java.util.stream.Collectors;

import model.Fan;
import model.Team;
import repository.FanRepository;


public class FanService {

	public Fan newFan(String name, int age, Team team, String study, String civilStatus) {
		
		return new Fan(name, age, team, study, civilStatus);
		
	}
	
	public int getQuantityFans() {
		return FanRepository.getInstance().getQuantityMembers();
	}

	public List<Fan> getFirst100fansMarriedAndWithUniversityStudies() {
		List<Fan> studentMarrieds = FanRepository.getInstance().
				getFans().stream().
				filter((fan) -> fan.getStudies().equals("Universitario") && fan.getCivilStatus().equals("Casado")).
				collect(Collectors.toList());
		
		studentMarrieds.sort((fan1, fan2) -> fan1.getAge() < fan2.getAge() ? -1 : fan1.getAge() == fan2.getAge() ? 0 : 1);
		
		return studentMarrieds.subList(0,  100);
	}

}
