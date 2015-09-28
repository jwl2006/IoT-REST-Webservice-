package com.youtube.rest.status;

import java.util.ArrayList;




public class Resource {
private String ID;
private ArrayList<String> Value = new ArrayList<String>();
 
    public Resource() 
    {
    	
    }
    
    public String getID()
    {
    	return this.ID;
    }
 
    public ArrayList<String> getValue()
    {
    	return Value;
    }
    
    public void setID(String id)
    {
    	this.ID=id;
    }
    
    public void setValue(String value)
    {
    	this.Value.add(value);
    }
    
    public String toString(){
    	
    	return "Resource[ID="+ID+",value="+Value+"]";
    			
    }
    }
    

