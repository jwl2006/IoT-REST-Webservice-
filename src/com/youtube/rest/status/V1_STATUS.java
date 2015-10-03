package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;



/**
 * This is the root path for our restful api service
 * In the web.xml file, we specified that /api/* need to be in the URL to
 * get to this class.
 * 
 * We are versioning the class in the URL path.  This is the first version v1.
 * Example how to get to the root of this api resource:
 * http://localhost:7001/com.youtube.rest/api/v1/status
 * 
 * @author 308tube
 *
 */
@Path("/v1/status") //removed * wildcard to make this more compatible with tomcat
public class V1_STATUS {

	//private static final String api_version = "00.02.00"; //version of the api
	
	/**
	 * This method sits at the root of the api.  It will return the name
	 * of this api.
	 * 
	 * @return String - Title of the api
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service</p>";
	}
}
