package com.youtube.rest.status;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/bootstrap")
public class BootMain {
    private static boolean [] repo={false,false};
  
    @GET
    @Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject bootstrapInfo() throws JSONException 
    {
    	
    		JSONObject jobj = new JSONObject();
	       
    		if (repo[0]==false)
    		{
    			jobj.put("ID", "client1");
    			jobj.put("VALUE", "Bootstrap Done");
    			repo[0]=true;
    			
    		}
    		else if (repo[1]==false)
    		{
    			jobj.put("ID", "client2");
    			jobj.put("VALUE", "Bootstrap Done");
    			repo[1] = true;
    		}
    		else
    		{
    			jobj.put("ID", "no more client");
    			jobj.put("VALUE", "Bootstrap Done");
    		}
    		
    		// pass the information to registration server.
    		
    		
    		return jobj;
    		
    	}
    	
	
    	
    }
    


