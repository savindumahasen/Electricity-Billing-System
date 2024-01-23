package data;

import buisness.Customer;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mongodb.MongoClient;

public class CustomerDB implements ICustomer {
	
	ArrayList<Customer> cust;

	public CustomerDB() {
		// TODO Auto-generated constructor stub
		MongoClient mongoClient=new MongoClient("localhost",27017);
        JOptionPane.showMessageDialog(null, "Database is successfully  connected");
	}

	@Override
	public int add(Customer obj) {
		// TODO Auto-generated method stub
		cust.add(obj);
		return 1;
	}

	@Override
	public Customer get(int ID) {
		// TODO Auto-generated method stub
		for(Customer c:cust) {
			if(c.getID()==ID) {
				return c;
			}
		}
		return null;
	}
	

	@Override
	public ArrayList<Customer> getAll() { // retrieve the all student details
		// TODO Auto-generated method stub
		
		return cust;
	}


   

}
