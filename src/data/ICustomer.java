package data;

import java.util.ArrayList;

import buisness.Customer;

public interface ICustomer {
	
	public int add(Customer obj);
	public Customer get(int ID);
	public ArrayList<Customer >getAll();

}
