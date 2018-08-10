package com.environment;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.environment.service.EnvironmentResource;
import com.environment.service.ProductResource;

@ApplicationPath("environment-management")
public class EnvironmentApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	   private Set<Class<?>> empty = new HashSet<Class<?>>();
	  
	 public EnvironmentApplication(){
		 singletons.add(new EnvironmentResource());
		 singletons.add(new ProductResource());
	 }
	 @Override
	   public Set<Class<?>> getClasses() {
	      return empty;
	   }
	 
	   @Override
	   public Set<Object> getSingletons() {
	      return singletons;
	   }
}
