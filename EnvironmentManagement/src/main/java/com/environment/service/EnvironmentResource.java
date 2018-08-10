package com.environment.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.environment.common.Message;
import com.environment.dao.EnvironmentDB;
import com.environment.manage.Environment;
import com.environment.manage.Environments;

/**
 * This REST resource has common path "/environments" and
 * represents environments collection resource as well as individual environment resources.
 *
 * Default MIME type for this resource is "application/XML"
 * */

@Path("/environments")
@Produces("application/xml")
public class EnvironmentResource {
	/**
     * Use uriInfo to get current context path and to build HATEOAS links
     * */
    @Context
    UriInfo uriInfo;
    
    /**
     * Get environments collection resource mapped at path "HTTP GET /environments"
     * */
    @GET
    public Environments getEnvironments(){
    	List<Environment> list = EnvironmentDB.getAllEnvironments();
    	Environments environments = new Environments();
    	environments.setEnvironments(list);
    	environments.setSize(list.size());
    	//set link for primary collection
    	
    	Link link = Link.fromUri(uriInfo.getPath()).rel("uri").build();
    	environments.setLink(link);
    	//Set links in environment item
    	for(Environment e: list){
    		Link lnk = Link.fromUri(uriInfo.getPath()+"/"+e.getId()).rel("self").build();
    		e.setLink(lnk);
    	}
    	return environments;
    }
    
    @GET
    @Path("/{id}")
    public Response getEnvironmentById(@PathParam("id") Integer id){
    	Environment env = EnvironmentDB.getEnvironment(id);
    	if(env == null){
    		return Response.status(Status.NOT_FOUND).build();
    	}
    	if(env !=null){
    		UriBuilder builder = UriBuilder.fromResource(EnvironmentResource.class)
    				.path(EnvironmentResource.class, "getEnvironmentById");
    		Link link = Link.fromUri(builder.build(id)).rel("self").build();
    		env.setLink(link);
    	}
    	return Response.status(javax.ws.rs.core.Response.Status.OK).entity(env).build();
    }
    
    @POST
    @Consumes("application/xml")
    public Response createEnvironment(Environment env){
    	if(env.getEnvName() == null){
    		return Response.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
                    .entity(new Message("Environment name not found"))
                    .build();
    	}
    	
    	Integer id = EnvironmentDB.createEnvironments(env.getEnvName(), env.getAppServer(), 
    			env.getDbServer(), env.getFileServer(), env.getStatus());
    	Link lnk = Link.fromUri(uriInfo.getPath()+"/"+id).rel("self").build();
    	env.setLink(lnk);
    	return Response.status(javax.ws.rs.core.Response.Status.CREATED).location(lnk.getUri()).build();
    }
    
    @PUT
    @Path("{/id}")
    @Consumes("application/xml")
    public Response updateEnvironment(@PathParam("Id") Integer id, Environment env){
    	Environment orig = EnvironmentDB.getEnvironment(id);
    	if(orig == null){
    		return Response.status(Status.NOT_FOUND).build();
    	}
    	if(env.getEnvName() == null){
    		return Response.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
                    .entity(new Message("Environment name not found"))
                    .build();
    	}
    	EnvironmentDB.updateEnvironment(id, env);
    	return Response.status(javax.ws.rs.core.Response.Status.OK).
    			entity(new Message("Environment Updated Successfully")).build();
    }
    
    /**
     * Delete environment resource by it's "id" at path "/environments/{id}"
     * */
    @DELETE
    @Path("/{id}")
    public Response deleteEnvironment(@PathParam("id") Integer id){
    	Environment origEnv = EnvironmentDB.getEnvironment(id);
    	if(origEnv == null){
    		return Response.status(Status.NOT_FOUND).build();
    	}
    	EnvironmentDB.removeEnvironment(id);
    	return Response.status(javax.ws.rs.core.Response.Status.OK).build();
    }
    
    /**
     * Initialize the application with these two default configurations
     * */
    static {
        EnvironmentDB.createEnvironments("BATA1", "LGHBDV122", "LGHBDV125", "LGHBDV103", "Active");
        EnvironmentDB.createEnvironments("BATB2", "LGHBDV122", "LGHBDV125", "LGHBDV103", "Active");
        EnvironmentDB.createEnvironments("BATC3", "LGHBDV122", "LGHBDV125", "LGHBDV103", "Active");
    }
}
