package model.network;

public abstract class NetCommon implements Runnable{
	
	public String[] protocol={"tcp","udp","http","ftp","ssh"};
	
	public String[] ipaddress={"myip","peerip"};
	
	public int[] portnumber={};
	
	//the net technology we used
	public String nettech="netty";

	public String[] iomethods={"io","nio"};
	
	public String[] getProtocol(){
		return protocol;
	}
	
	public String[] getIpaddress(){
		return ipaddress;
	}
	
	public int[] getPortnumber(){
		return portnumber;
	}
	
	public String getNettech(){
		return nettech;
	}
	
	public String[] getIomethods(){
		return iomethods;
	}
	
	
}
