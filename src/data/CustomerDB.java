package data;

import buisness.Customer;
import buisness.Student;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class CustomerDB implements ICustomer {
	private MongoDatabase db;
	
	ArrayList<Customer> cust;

	public CustomerDB() {
		// TODO Auto-generated constructor stub
		MongoClient mongoClient=new MongoClient("localhost",27017);
        JOptionPane.showMessageDialog(null, "Database is successfully  connected");
        
	    db = mongoClient.getDatabase("ElectrcityBillingDB");
        System.out.println("Get database is successful");
        
     // listing all databases in mongoDB 
        System.out.println("Below are list of databases present in MongoDB");
       // To get all database names        
        MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
          while(dbsCursor.hasNext()) {
                 System.out.println(dbsCursor.next());
             }
		
	}

	@Override
	public int add(Customer obj) {
		// TODO Auto-generated method stub
		//Inserting sample record by creating collection and document.
				MongoCollection<Document>  collection= db.getCollection("Customer");
				 Document doc =new Document("ID",obj.getID()).append("FirstName",obj.getFirstName()).append("LastName",obj.getLastName()).append("AccountNumber",obj.getAccountNumber()).append("UserName",obj.getUserName()).append("Password",obj.getPassword());
				collection.insertOne(doc);
				JOptionPane.showMessageDialog(null, "Data is added successfully  confirmed");
				
				return 1;
	}

	@Override
	public Customer get(int ID) {
		// TODO Auto-generated method stub
		 MongoCollection<Document> collection = db.getCollection("Customer"); // Replace with your collection name
		    Document document = collection.find(new Document("ID",ID)).first();
		    Customer customerObject = new Customer(
		            document.getInteger("ID"),  // Use the correct field name here
		            document.getString("FirstName"),
		            document.getString("LastName"),
		            document.getString("AccountNumber"),
		            document.getString("UserName"),
		            document.getString("Password")
		    );

		    return customerObject;
	}
	@Override
	public ArrayList<Customer> getAll() { // retrieve the all student details
		// TODO Auto-generated method stub
		
		return cust;
	}


   

}
