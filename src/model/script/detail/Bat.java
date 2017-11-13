package model.script.detail;

import java.util.ArrayList;
import java.util.List;

import model.script.ScriptDetail;

public class Bat extends ScriptDetail{

	private String str1="1.bat";
	private String str2="2.bat";
	
	public List<String> getBatScript(){
		List<String> ls = new ArrayList<String>();
		ls.add(str1);
		ls.add(str2);
		return ls;
 	}
}
