/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;

public class SampleQuery {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static void main(String args[]) {
        try {
            
            MongoCredential credential =
            MongoCredential.createCredential("administrator",
            "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new
            ServerAddress("localhost"), Arrays.asList(credential));
            
//            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
//            DBObject query = new BasicDBObject("name", "owen");
            DBObject query = new BasicDBObject("name", new BasicDBObject("$ne","frank")).append("age", new BasicDBObject("$gt", 36)); //ne= not equal

            DBCursor cursor = coll.find();
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    System.out.println(object);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
}
