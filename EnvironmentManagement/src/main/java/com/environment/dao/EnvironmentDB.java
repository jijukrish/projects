package com.environment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.environment.manage.Environment;



public class EnvironmentDB {
	private static Map<Integer, Environment> environmentDB = new ConcurrentHashMap<Integer, Environment>();
    private static AtomicInteger idCounter = new AtomicInteger();
    
    public static Integer createEnvironments(String envName,String appServer,
    		String dbServer,String fileServer,String status){
    	Environment aspEnv = new Environment();
    	aspEnv.setId(idCounter.incrementAndGet());
    	aspEnv.setAppServer(appServer);
    	aspEnv.setDbServer(dbServer);
    	aspEnv.setFileServer(fileServer);
    	aspEnv.setStatus(status);
    	environmentDB.put(aspEnv.getId(), aspEnv);
    	return aspEnv.getId();
    }
    
    public static Environment getEnvironment(Integer id){
    	return environmentDB.get(id);
    }
    
    public static List<Environment> getAllEnvironments(){
    	return new ArrayList<Environment>(environmentDB.values());
    }
    public static Environment removeEnvironment(Integer id){
    	return environmentDB.remove(id);
    }
    public static Environment updateEnvironment(Integer id,Environment env){
    	return environmentDB.put(id, env);
    }
}
