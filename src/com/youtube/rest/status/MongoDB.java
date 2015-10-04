package com.youtube.rest.status;


import java.net.UnknownHostException;

//import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;



public class MongoDB {

	private static DBCollection table;
	private static MongoClient mongo;
	private static DB db;
    public MongoDB(String dbName) 
    {
    	System.out.println("in Mongo Constructor");
    	try{
    	mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB(dbName);
		table = db.getCollection("user");
		}
    	catch(UnknownHostException e1){
    		System.err.println("Failure during host name resolution: " + e1);
    	}
    }

    
    public void insertObject(JSONObject obj)
    {
    	BasicDBObject document = new BasicDBObject();
		document.put("ID", obj.optString("ID"));
		document.put("VALUE",obj.optString("VALUE"));
		table.insert(document);
    }

    public String findObject (String name)
    {
    	System.out.println("IN FIND OBJECT");
    	System.out.println(name+"***");
    	BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("ID", name);

        StringBuilder result=new StringBuilder();
    
    	DBCursor cursor = table.find(searchQuery);

    	while (cursor.hasNext()) {
    		result.append(cursor.next());
    	}

    	String ret = result.toString();
    	System.out.println(ret);
    	return ret;
    	}
    	
    

}



