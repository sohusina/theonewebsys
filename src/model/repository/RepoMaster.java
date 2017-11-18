package model.repository;

import model.interfaces.InstanceClass;

public class RepoMaster {
	
	private RepoAgent agent;
	
    private static RepoMaster instance=null;
	
	public static RepoMaster getInstance(){
		instance=InstanceClass.getInstance(RepoMaster.class);
		return instance;
	}
	
	public void readFilefromRepository(String filetype){
		System.out.println("we are reading file from master repository filetype is "+filetype);
	}

}
