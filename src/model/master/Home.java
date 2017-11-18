package model.master;

import model.interfaces.InstanceClass;

public class Home {
	
	private static Home instance=null;
	
	private void Initialize(){
		System.out.println("we are initializing");
	}
	
	private void run(){
		System.out.println("we are running");
	}
	
	private void readConfig(){
		System.out.println("we are reading master config");
		ConfigFile cf=ConfigFile.getInstance();
	    cf.readConfig();
	}
	
	public static Home getInstance(){
		instance=InstanceClass.getInstance(Home.class);
		return instance;
	}
	
	//for control class
	public Home interfacetoUp(){
		Home h= getInstance();
		return h;
	}
	
	public static void main(String[] args){
		Home home = Home.getInstance();
		home.Initialize();
		home.readConfig();
		home.run();
	}

}
