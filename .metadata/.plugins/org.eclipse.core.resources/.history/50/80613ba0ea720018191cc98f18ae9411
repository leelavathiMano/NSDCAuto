package com.nsdc.testConfig;

import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class DatabaseConnection
{
    protected DatabaseConnection dbConnection;
    
    public static void deleteUserFromDB(String collectionName, String fieldName, String fieldValue)
    {
        try
        {      	
        	MongoCredential credential = MongoCredential.createCredential("SDMSTestUser", "ekaushalnsdc", "Sd04Ms#10^Te5#sT".toCharArray());
        	@SuppressWarnings({ "deprecation", "resource" })
			MongoClient mongo = new MongoClient(new ServerAddress("13.232.9.250", 27017), Arrays.asList(credential));
        	
            @SuppressWarnings("deprecation")
            DB db = mongo.getDB("ekaushalnsdc");
            
            DBCollection collection = db.getCollection(collectionName);
            BasicDBObject query = new BasicDBObject();
            query.append(fieldName, fieldValue);
            collection.remove(query);
        }
        
        catch(Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void deleteTrainingPartner(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("trainingpartner", "email", fieldValue);
    }
    
    public static void deleteTrainer(String fieldValue)
    {
        DatabaseConnection.deleteUserFromDB("users", "email", fieldValue);
        DatabaseConnection.deleteUserFromDB("trainer", "email", fieldValue);
    }
}

