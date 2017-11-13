package model.script.windows;

import java.util.ArrayList;
import java.util.List;

import model.script.ScriptDetail;
import model.script.ScriptType;
import model.script.detail.*;

//script type support by windows

public class ScriptAtWindows {
	
	private List<ScriptDetail> especialatwin;
	
	public ScriptAtWindows(){
		especialatwin=new ArrayList<ScriptDetail>();
	}
	
	public List<ScriptDetail> getWinScript(){
		List<ScriptDetail> ls = new ArrayList<ScriptDetail>();
		ls.add(new Perl());
		ls.add(new Python());
		ls.add(new PowerShell());
		ls.add(new Bat());
		ls.add(new Others());
		
		especialatwin=ls;
		return especialatwin;
	}
}
