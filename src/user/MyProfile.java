package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import buisness.Customer;
import data.CustomerDB;
import buisness.Customer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private CustomerDB customer;
	private JTextField txtLastName;
    private CustomerDB custDB;
    private JButton btnUpdatePassword;
    private JTextField txtMobileNumber;
    private JTextField txtLandNumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfile frame = new MyProfile();
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
	public MyProfile() {
		setTitle("My Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		custDB=new CustomerDB();
		
		customer=new CustomerDB();
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(181, 77, 280, 28);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		ArrayList<Customer> custList1=custDB.getAll();
		for(Customer customerList:custList1) {
		txtFirstName.setText(customerList.getFirstName());
		}
	
		
		txtLastName = new JTextField();
		txtLastName.setBounds(181, 142, 274, 28);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		ArrayList<Customer> custList2=custDB.getAll();
		for(Customer customerList1:custList2) {
		txtLastName.setText(customerList1.getLastName());
		}
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBounds(181, 205, 274, 28);
		contentPane.add(txtMobileNumber);
		ArrayList<Customer> custList3=custDB.getAll();
		for(Customer customerList2:custList3 ) {
			txtMobileNumber.setText(customerList2.getLastName());
			
		}
		
		txtLandNumber = new JTextField();
		txtLandNumber.setColumns(10);
		txtLandNumber.setBounds(181, 274, 274, 28);
		contentPane.add(txtLandNumber);
		ArrayList<Customer> custList4=custDB.getAll();
		for(Customer customerList3:custList4) {
			txtLandNumber.setText(customerList3.getLandNumber());
		}
		setLocationRelativeTo(this);
		
		JButton btnUpdate = new JButton("Edit Profile");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID=0;
				String accountNumber="";
				String userName="";
				String password="";
				String mobileNumber="";
				String landNumber="";
				
				String firstName=txtFirstName.getText();
				String lastName=txtLastName.getText();
				ArrayList<Customer> custList2=custDB.getAll();
				for(Customer custList4:custList2) {
					ID=custList4.getID();
				    accountNumber=custList4.getAccountNumber();
				    userName=custList4.getUserName();
				    password=custList4.getPassword();
				    mobileNumber=custList4.getMobileNumber();
				    landNumber=custList4.getLandNumber();
				    
				}
				Customer customer=new Customer(ID,firstName,lastName,accountNumber,userName,password,mobileNumber,landNumber);
				int result=custDB.update(customer);
				if(result>0) {
					JOptionPane.showMessageDialog(null, "Customer data updated is successfully  confirmed");
				}else {
					JOptionPane.showMessageDialog(null, "Customer data updated is not successfully  confirmed");
				}
			}
		});
		btnUpdate.setBounds(70, 360, 510, 21);
		contentPane.add(btnUpdate);
		
		btnUpdatePassword = new JButton("Change Password");
		btnUpdatePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdatePassword.setBounds(70, 402, 510, 21);
		contentPane.add(btnUpdatePassword);
		
		
	}
}
