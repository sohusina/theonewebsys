package model.linux;

import java.io.*;
import java.util.*;

import model.interfaces.SysAction;

/**
 * @author Administrator
 *
 */
public class Action extends SysAction {
	
	// get linux os name
	public String getSysname() {
		String sysname = System.getProperty("os.name");
		if (!sysname.equalsIgnoreCase("linux")) {
			System.out.println("you must use linux system!");
		}
		return sysname;
	}

	// use script which created by us from os native
	public List<String> getScriptList() {
		List<String> ls = new ArrayList<>();
		return ls;
	}

	public boolean canuseScript(boolean usescript) {

		return usescript;
	}

	// run linux native script
	public void runNativeScript(String scriptname, boolean canuse) {
		List<String> ls = getScriptList();
		canuse = true;

		if (canuseScript(canuse)) {
			Iterator it = ls.iterator();
			while (it.hasNext()) {
				scriptname = (String) it.next();

				try {
					String[] cmds = { "/bin/sh", "-c", scriptname };

					Process pro = Runtime.getRuntime().exec(cmds);
					pro.waitFor();
					InputStream in = pro.getInputStream();
					BufferedReader read = new BufferedReader(new InputStreamReader(in));

					List<String> ls2=new ArrayList<String>();
					String line = null;
					while ((line = read.readLine()) != null) {
						// System.out.println(line);
						ls2.add(line);
					}
					writeToFile(ls2,scriptname);
				} catch (Exception e) {
					e.getMessage();
				}

			}
		} else {

		}
	}

	 // use 3 ways to write to file
	public void writeToFile(List<String> strlist,String scriptname) {
		FileOutputStream out = null;
		FileOutputStream outSTr = null;
		BufferedOutputStream Buff = null;
		FileWriter fw = null;
        int methods =1;
        
		try {
			
			switch(methods){
			case 1:
			out = new FileOutputStream(new File("./list"+scriptname+".txt"));
			//the 1 way
			long begin = System.currentTimeMillis();
			Iterator i=strlist.iterator();
			while(i.hasNext()){
				out.write(((String)i.next()).getBytes());
			}
			out.close();
			long end = System.currentTimeMillis();
			System.out.println("the script "+scriptname+" FileOutputStream spend time:" + (end - begin) + "∫¿√Î");
			break;
			
			//the 2 way
			case 2:
			outSTr = new FileOutputStream(new File("./list"+scriptname+".txt"));
			Buff = new BufferedOutputStream(outSTr);
			long begin0 = System.currentTimeMillis();
			Iterator i2=strlist.iterator();
			while(i2.hasNext()){
				Buff.write(((String)i2.next()).getBytes());
			}
			Buff.flush();
			Buff.close();
			long end0 = System.currentTimeMillis();
			System.out.println("the script "+scriptname+" BufferedOutputStream spend time:" + (end0 - begin0) + " ∫¿√Î");
			break;
			
			//the 3 way
			case 3:
			fw = new FileWriter("./list"+scriptname+".txt");
			long begin3 = System.currentTimeMillis();
			Iterator i3= strlist.iterator();
			while(i3.hasNext()){
				fw.write((String)i3.next());
			}
			fw.close();
			long end3 = System.currentTimeMillis();
			System.out.println("the script "+scriptname+" FileWriter spend time:" + (end3 - begin3) + " ∫¿√Î");
			break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw!=null){
				fw.close();}else if(Buff!=null){
				Buff.close();}else if(outSTr!=null){
				outSTr.close();}else if(out!=null){
				out.close();}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
