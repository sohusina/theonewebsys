package model.interfaces;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InstanceClass<T> {
	
    private static final ConcurrentMap<Class,Object> map= new ConcurrentHashMap<>();
	
    //type is class name, Object is class instance
	public static<T> T getInstance(Class<T> type){
		Object ob=map.get(type);
		
		try{
		
		if(ob==null){
			
			synchronized(map){
				if(ob==null){
					ob=type.newInstance();
					map.put(type, ob);
				}
			}
		}
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		return (T)ob;
		
	}

}
