package com.nsdc.testConfig;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class DatabaseConnection
{
    protected DatabaseConnection dbConnection;
    
    public static void deleteUserFromDB(String collectionName, String fieldName, String fieldValue)
    {
        try
        {
            @SuppressWarnings("deprecation")
            Mongo mongo = new Mongo("13.232.9.250", 27017);
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
}

