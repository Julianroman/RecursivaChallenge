package repository;

import java.util.ArrayList;
import java.util.List;

import model.Fan;

public class FanRepository {
	
	private static FanRepository instance;
	private List<Fan> fans = new ArrayList<>();
	
	public static FanRepository getInstance(){
		if(instance == null) {
			instance = new FanRepository();
		}
		return instance;
	}
		
	
	public void addMember(Fan fan) {
		this.fans.add(fan);
	}
	
	public List<Fan> getFans(){
		return this.fans;
	}

	public int getQuantityMembers() {
		return this.fans.size();
	}
}
