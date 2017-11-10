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
				out.write("����java �ļ�����\r\n".getBytes());
			}
			out.close();
			long end = System.currentTimeMillis();
			System.out.println("FileOutputStreamִ�к�ʱ:" + (end - begin) + "����");
			outSTr = new FileOutputStream(new File("C:/add0.txt"));
			Buff = new BufferedOutputStream(outSTr);
			long begin0 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				Buff.write("����java �ļ�����\r\n".getBytes());
			}
			Buff.flush();
			Buff.close();
			long end0 = System.currentTimeMillis();
			System.out.println("BufferedOutputStreamִ�к�ʱ:" + (end0 - begin0) + " ����");
			fw = new FileWriter("C:/add2.txt");
			long begin3 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				fw.write("����java �ļ�����\r\n");
			}
			fw.close();
			long end3 = System.currentTimeMillis();
			System.out.println("FileWriterִ�к�ʱ:" + (end3 - begin3) + " ����");
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
