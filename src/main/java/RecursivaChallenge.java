import java.util.List;

import model.Fan;
import model.Team;
import services.FanService;
import services.TeamService;
import utilsCSV.CsvUtil;

public class RecursivaChallenge {
	
	public static void main (String[] args) {
				
		CsvUtil csv = new CsvUtil();
		csv.readFile("socios.csv");
		
		FanService fanservice = new FanService();
		TeamService teamservice = new TeamService();
		System.out.println("==============================================================");
		System.out.println("Cantidad total de personas registradas");
		System.out.println(fanservice.getQuantityFans());
		
		System.out.println("==============================================================");
		System.out.println("Promedio de edad socios de Racing");
		System.out.println(teamservice.getAverageAgeFrom("River"));
		
		System.out.println("==============================================================");
		System.out.println("100 Personas casadas y con estudios universitarios");
		List<Fan> fans = fanservice.getFirst100fansMarriedAndWithUniversityStudies();
		fans.forEach((fan) -> System.out.println("Nombre: " + fan.getName() + " Edad: " + fan.getAge() + " Equipo: " + fan.getTeam().getName()));
		
		System.out.println("==============================================================");
		System.out.println("Nombres comunes de hinchas de River");
		List<String> riverFans = teamservice.getMostCommonsNamesOf("River");
		riverFans.forEach(name-> System.out.println(name));
		
		System.out.println("==============================================================");
		System.out.println("Listado de socios");
		List<Team> teams = teamservice.getBigestTeams();
		teams.forEach((team) -> System.out.println("Equipo: " + team.getName() + 
													" Promedio Edad: " + teamservice.getAverageAgeFrom(team.getName()) + 
													" Edad Minima: " + teamservice.getMinAgeFrom(team.getName()) + 
													" Edad Maxima " + teamservice.getMaxAgeFrom(team.getName())));
		
	}

}
