package data;

import buisness.Customer;
import buisness.Payment;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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

	@Override
	public ArrayList<Payment> getAll() {
		// TODO Auto-generated method stub
		 ArrayList<Payment> paymentList = new ArrayList<Payment>();
	     MongoCollection<Document> collection = db.getCollection("Payment");
	     FindIterable<Document> documents = collection.find();
         MongoCursor<Document> cursor = documents.iterator();
         while (cursor.hasNext()) {
             Document document = cursor.next();
             Payment payment = new Payment(
                     document.getString("Account"),
                     document.getDouble("Amount"),
                     document.getString("Email")
                   
             );
             paymentList.add(payment);
		
	
	}
     	return paymentList;
	}

	

}
