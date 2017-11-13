package model.script;

import java.util.ArrayList;
import java.util.List;

import model.script.linux.ScriptAtLinux;
import model.script.windows.ScriptAtWindows;

public class ScriptType {

	public ScriptAtWindows winscript;
	
	public ScriptAtLinux linuxscript;
	
	public List<ScriptDetail> listscript;
	
	
	private ScriptAtWindows getWinScriptType(){
		winscript = new ScriptAtWindows();
		return winscript;
	}
	
	private ScriptAtLinux getLinuxScriptType(){
		linuxscript = new ScriptAtLinux();
		return linuxscript;
	}
	
	public List<ScriptDetail> getScriptList(String osname){
		//List<ScriptDetail> ls = new ArrayList<ScriptDetail>();
	//equals method shall replace regex
		if((model.sys.common.SysUtil.getSysName(osname)).equalsIgnoreCase("windows 7")){
			winscript=getWinScriptType();
			listscript = winscript.getWinScript();
		
	}else{
		linuxscript=getLinuxScriptType();
		listscript=linuxscript.getLinuxScript();
		
	}
		
		return listscript;
	}
}
