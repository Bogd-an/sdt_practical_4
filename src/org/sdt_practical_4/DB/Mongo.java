package org.sdt_practical_4.DB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.util.logging.Level;
import static java.util.logging.Logger.*;

public class Mongo {
        static MongoClient  client;
        static MongoCollection<Document> receiptsDB;
        static MongoCollection<Document> tokensDB;
        public static void connect(){
            getLogger("org.mongodb.driver").setLevel(Level.OFF);
            try {
                client = new MongoClient("localhost", 27017);
                MongoDatabase database = client.getDatabase("railwayTransportation");
                receiptsDB = database.getCollection("receipts");
                tokensDB = database.getCollection("tokens");

            } catch(Exception e){ System.out.println(e); }
        }

        public static void disconnect(){ client.close(); }

}
