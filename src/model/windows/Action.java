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
		List<String> ls = new ArrayList<>();
		return ls;
	}

	public boolean canuseScript(boolean usescript) {

		return usescript;
	}

	// run windows native script
	public void runNativeScript(String scriptname, boolean canuse) {
		List<String> ls = getScriptList();
		canuse = true;

		if (canuseScript(canuse)) {
			Iterator it = ls.iterator();
			while (it.hasNext()) {
				scriptname = (String) it.next();

				try {
					String[] cmds = { "c://ps ", "-c", scriptname };

					Process pro = Runtime.getRuntime().exec(cmds);
					pro.waitFor();
					InputStream in = pro.getInputStream();
					BufferedReader read = new BufferedReader(new InputStreamReader(in));

					String line = null;
					while ((line = read.readLine()) != null) {
						// System.out.println(line);
						writeToFile(line);
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}

		} else {

		}
	}

	public void writeToFile(String str) {
		FileOutputStream out = null;
		FileOutputStream outSTr = null;
		BufferedOutputStream Buff = null;
		FileWriter fw = null;
		int count = 1000;// write file line count

		try {
			out = new FileOutputStream(new File("./list.txt"));
			long begin = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				out.write("测试java 文件操作\r\n".getBytes());
			}
			out.close();
			long end = System.currentTimeMillis();
			System.out.println("FileOutputStream执行耗时:" + (end - begin) + "豪秒");
			outSTr = new FileOutputStream(new File("C:/add0.txt"));
			Buff = new BufferedOutputStream(outSTr);
			long begin0 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				Buff.write("测试java 文件操作\r\n".getBytes());
			}
			Buff.flush();
			Buff.close();
			long end0 = System.currentTimeMillis();
			System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 豪秒");
			fw = new FileWriter("C:/add2.txt");
			long begin3 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				fw.write("测试java 文件操作\r\n");
			}
			fw.close();
			long end3 = System.currentTimeMillis();
			System.out.println("FileWriter执行耗时:" + (end3 - begin3) + " 豪秒");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				Buff.close();
				outSTr.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}