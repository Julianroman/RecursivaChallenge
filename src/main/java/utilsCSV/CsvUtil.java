package utilsCSV;

import java.io.*;

import model.Fan;
import model.Team;
import services.FanService;
import services.TeamService;

public class CsvUtil {
	
	TeamService teamService = new TeamService();
	FanService fanService = new FanService();
	
	public void readFile(String file) {
		
		BufferedReader csvReader = null;
		String row, DELIMETER = ";";
		try {
			
			csvReader = new BufferedReader(new FileReader(file));
			while((row = csvReader.readLine()) != null) {
				String[] data = row.split(DELIMETER);
				this.parseData(data);
			}
				
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				csvReader.close();
			} 
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

	private void parseData(String[] data) {

		String name = data[0];
		int age = Integer.parseInt(data[1]);
		String teamName = data[2];
		String civilStatus = data[3];
		String study = data[4];
		
		Team team = teamService.getTeamByName(teamName);
		if(team != null) {
			Fan newFan = fanService.newFan(name, age, team, civilStatus, study);
			team.getFans().add(newFan);
		}
		
	}

}
