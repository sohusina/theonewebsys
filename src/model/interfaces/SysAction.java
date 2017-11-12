/**
 * 
 */
package model.interfaces;

import java.util.List;

/**
 * @author Administrator
 *
 */
public abstract class SysAction {
	
	public abstract String getSysname();
	
	public abstract List<String> getScriptList();
	
	public abstract void runNativeScript(String scriptname,boolean canuse);
	
	public abstract void writeToFile(List<String> strlist,String scriptname);

}
