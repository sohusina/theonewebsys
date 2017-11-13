package model.script.linux;

import java.util.ArrayList;
import java.util.List;

import model.script.ScriptDetail;
import model.script.detail.Others;
import model.script.detail.Perl;
import model.script.detail.PowerShell;
import model.script.detail.Python;

public class ScriptAtLinux {

    private List<ScriptDetail> especialatlinux;
    
    public ScriptAtLinux(){
    	especialatlinux=new ArrayList<ScriptDetail>();
    }
	
	
	public List<ScriptDetail> getLinuxScript(){
		List<ScriptDetail> ls = new ArrayList<ScriptDetail>();
		ls.add(new Perl());
		ls.add(new Python());
		ls.add(new PowerShell());
		ls.add(new Others());
		especialatlinux=ls;
		return especialatlinux;
	}
}
