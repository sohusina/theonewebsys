/**
 * 
 */
package model.windows;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.interfaces.SysAction;
import model.script.ScriptDetail;
import model.script.detail.*;

/**
 * @author Administrator
 *
 */
public class Action extends SysAction {
	// get windows os name
	public String getSysname() {
		String sysname = System.getProperty("os.name");
		if (!(sysname.equalsIgnoreCase("windows XP") || sysname.equalsIgnoreCase("windows 7"))
				|| sysname.equalsIgnoreCase("windows 8") || sysname.equalsIgnoreCase("windows 10")) {
			System.out.println("you must use windows system!");
		}
		return sysname;
	}

	// use script which created by us from os native
	public List<String> getScriptList() {
		//test start
		//String str1="1.bat";
		//String str2="2.bat";
		//test end
		List<String> ls =new ArrayList<String>();
		model.script.ScriptType st = new model.script.ScriptType();
		List<ScriptDetail> lsd = st.getScriptList(getSysname());
		Iterator i = lsd.iterator();
		while(i.hasNext()){
			//test perl
			ScriptDetail sd = (ScriptDetail)i.next();
		  if(sd instanceof Bat){
			  System.out.println(sd+"is Bat!");
      		 ls= ((Bat)sd).getBatScript();
      		 System.out.println("Bat is ok!");
		     return ls;
		  }
		}
		return ls;
		
	}

	public boolean canuseScript(boolean usescript) {

		return usescript;
	}

	
	// run windows native script
	public void runNativeScript(String scriptnames, boolean canuse) {
		List<String> ls = getScriptList();
		//canuse = true;
		String scriptname="";
		if (canuseScript(canuse)) {
			Iterator it = ls.iterator();
			while (it.hasNext()) {
				scriptname = (String) it.next();

				try {
					//String[] cmds = { "c://", scriptname };
                    //String cmds="c://"+scriptname;
					String cmds=scriptname;
					System.out.println("cmds is "+cmds);
					String[] strs={""};
					Process pro = Runtime.getRuntime().exec(cmds,strs,new File(System.getProperty("user.dir")+"\\repositoryfortest"));
					pro.waitFor();
					InputStream in = pro.getInputStream();
					BufferedReader read = new BufferedReader(new InputStreamReader(in,"GBK"));//windows local encode

					String line = null;
					List<String> ls2 =new ArrayList<String>();
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
        int methods =3;
        
		try {
			
			switch(methods){
			case 1:
			out = new FileOutputStream(new File(scriptname+".txt"));
			//the 1 way
			long begin = System.currentTimeMillis();
			Iterator i=strlist.iterator();
			while(i.hasNext()){
				out.write(((String)i.next()+"\r\n").getBytes());
			}
			out.close();
			long end = System.currentTimeMillis();
			System.out.println("the script "+scriptname+" FileOutputStream spend time:" + (end - begin) + "����");
			break;
			
			//the 2 way
			case 2:
			outSTr = new FileOutputStream(new File(scriptname+".txt"));
			Buff = new BufferedOutputStream(outSTr);
			long begin0 = System.currentTimeMillis();
			Iterator i2=strlist.iterator();
			while(i2.hasNext()){
				Buff.write(((String)i2.next()+"\r\n").getBytes());
			}
			Buff.flush();
			Buff.close();
			long end0 = System.currentTimeMillis();
			System.out.println("the script "+scriptname+" BufferedOutputStream spend time:" + (end0 - begin0) + " ����");
			break;
			
			//the 3 way
			case 3:
			fw = new FileWriter(scriptname+".txt");
			long begin3 = System.currentTimeMillis();
			Iterator i3= strlist.iterator();
			while(i3.hasNext()){
				fw.write((String)i3.next()+"\r\n");
			}
			fw.close();
			long end3 = System.currentTimeMillis();
			System.out.println("the script "+scriptname+" FileWriter spend time:" + (end3 - begin3) + " ����");
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