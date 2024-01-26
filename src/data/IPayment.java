package data;

import java.util.ArrayList;

import buisness.Payment;

public interface IPayment {
	
	int add(Payment obj);
	
	ArrayList<Payment> getAll();

}
