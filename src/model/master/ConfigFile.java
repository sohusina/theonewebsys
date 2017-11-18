package model.master;

import model.interfaces.InstanceClass;
import model.repository.RepoMaster;

public class ConfigFile {
	
	private String filepath="";
    private String filetype="xml";
	
	private static ConfigFile cf=null;
	
	public static ConfigFile getInstance(){
		cf=InstanceClass.getInstance(ConfigFile.class);
		return cf;
	}
	
	public void readConfig(){
		String usedom="dom";
		if(filetype.equals("txt")){
			System.out.println("we are reading txt config file");
			readtxt();
		}
		if(filetype.equals("xml")){
			System.out.println("we are reading xml config file");
			readxml();
		}
		
	}
	
	private void readtxt(){
		String use="txt";
		RepoMaster rm= RepoMaster.getInstance();
		rm.readFilefromRepository(use);
	}
	
	private void readxml(){
		String use="xml";
		RepoMaster rm =RepoMaster.getInstance();
		rm.readFilefromRepository(use);
	}
	
	
}
