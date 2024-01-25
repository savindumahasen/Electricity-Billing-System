package data;

import buisness.Payment;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PaymentDB implements IPayment {
	private MongoDatabase db;

	public PaymentDB() {
		// TODO Auto-generated constructor stub
		MongoClient client=new MongoClient("localhost",27017);
		JOptionPane.showMessageDialog(null, "Database is successfully  connected!");
		
		db = client.getDatabase("ElectrcityBillingDB");
        System.out.println("Get database is successful");
        
	}

	@Override
	public int add(Payment obj) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection=db.getCollection("Payment");
		
		Document doc=new Document("Account",obj.getAccount()).append("Amount",obj.getAmount()).append("Email",obj.getEmail());
		collection.insertOne(doc);
		return 1;
	}

}
