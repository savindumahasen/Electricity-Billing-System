package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import buisness.Payment;
import data.PaymentDB;
import data.CustomerDB;
import buisness.Customer;
import java.time.LocalDate;

public class ViewPaymentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtAccount;
	private PaymentDB paymentDB;
	private CustomerDB customerDB;
	private JTextField txtFirstName1;
	private JTextField txtLastName;
	private JTextField txtAccountNumber;
	private JTextField txtAmount;
	private JTextField txtDate;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPaymentDetails frame = new ViewPaymentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewPaymentDetails() {
		setTitle("Payment Reciet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		paymentDB=new PaymentDB();
		customerDB=new CustomerDB();
	    LocalDate currentDate = LocalDate.now();
		
		JLabel lblHeading = new JLabel("Payment successfully  completed");
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeading.setBounds(125, 59, 308, 22);
		contentPane.add(lblHeading);
		
		ArrayList<Customer> custList=customerDB.getAll();
		for(Customer customers:custList) {
		txtFirstName1 = new JTextField();
		txtFirstName1.setBounds(210, 122, 96, 19);
		contentPane.add(txtFirstName1);
		txtFirstName1.setColumns(10);
		txtFirstName1.setText(customers.getFirstName());
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(210, 178, 96, 19);
		contentPane.add(txtLastName);
		txtLastName.setText(customers.getLastName());
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(210, 238, 96, 19);
		contentPane.add(txtAccountNumber);
		txtAccountNumber.setText(customers.getAccountNumber());
		}
		
		ArrayList<Payment> paymentList=paymentDB.getAll();
		
		for(Payment payments:paymentList) {
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(210, 303, 96, 19);
		contentPane.add(txtAmount);
		txtAmount.setText(String.valueOf(payments.getAmount()));
		}
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(210, 353, 96, 19);
		contentPane.add(txtDate);
		txtDate.setText(String.valueOf(currentDate));
		
	
		
	
		
		setLocationRelativeTo(this);
	}
}
