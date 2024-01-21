package data;

import buisness.Customer;

import java.util.ArrayList;

public class CustomerDB implements ICustomer {
	
	ArrayList<Customer> cust;

	public CustomerDB() {
		// TODO Auto-generated constructor stub
		cust=new ArrayList<Customer>();
	}

	@Override
	public int add(Customer obj) {
		// TODO Auto-generated method stub
		cust.add(obj);
		return 1;
	}

	@Override
	public Customer get(String userName) {
		// TODO Auto-generated method stub
		for (Customer c : cust) {
			if(c.getUserName()==userName) {
				return c;
			}
			
			
		}
		return null;
	}

}
