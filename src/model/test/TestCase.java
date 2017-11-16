/**
 * 
 */
package model.test;

/**
 * @author Administrator
 *
 */
public class TestCase {

	public String str="iswindows";
	
	public String str2="islinux";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCase tc = new TestCase();
		if(tc.str.equals("iswindows")){
			model.windows.Action winaction= new model.windows.Action();
			System.out.println("the os name is "+winaction.getSysname());
			
			winaction.runNativeScript("", true);
			
		}
		
		if(tc.str2.equals("islinux")){
			model.linux.Action linuxaction= new model.linux.Action();
			System.out.println("the os name is "+linuxaction.getSysname());
		}

	}

}
