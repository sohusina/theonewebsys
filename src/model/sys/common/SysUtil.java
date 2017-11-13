package model.sys.common;

public class SysUtil {

	public static String getSysName(String osname){
		if(osname.equals("windows")){
			model.windows.Action wa = new model.windows.Action();
			return wa.getSysname();
		}else{
			
			model.linux.Action la= new model.linux.Action();
			return la.getSysname();
		}
	}
}
