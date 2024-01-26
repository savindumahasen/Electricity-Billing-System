package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import buisness.Customer;
import data.CustomerDB;
import javax.swing.JPasswordField;
import java.awt.Color;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtCurrentPassword;
	private JTextField txtNewPassword;
	private JTextField txtConfirmNewPassword;
	private CustomerDB custDB;
	private JTextField txtID;
	private JTextField textFirstName;
	private JTextField txtLastName;
	private JTextField txtAccountNumber;
	private JPasswordField txtPassword;
	private JTextField txtMobileNumber;
	private JTextField txtLandNumber;
	private JTextField txtFirstName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		txtID = new JTextField();
		txtID.setBounds(255, 123, 141, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(484, 123, 168, 19);
		contentPane.add(txtFirstName);
		txtFirstName.setVisible(false);

		custDB=new CustomerDB();
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(484, 167, 168, 19);
		contentPane.add(txtLastName);
		txtLastName.setVisible(false);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(484, 235, 168, 19);
		contentPane.add(txtAccountNumber);
		txtAccountNumber.setVisible(false);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(497, 281, 168, 19);
		contentPane.add(txtPassword);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setBounds(484, 343, 168, 19);
		contentPane.add(txtMobileNumber);
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setVisible(false);
		
		txtLandNumber = new JTextField();
		txtLandNumber.setColumns(10);
		txtLandNumber.setBounds(484, 396, 168, 19);
		contentPane.add(txtLandNumber);
		txtLandNumber.setVisible(false);
		
		txtCurrentPassword = new JTextField();
		txtCurrentPassword.setBounds(255, 187, 141, 19);
		contentPane.add(txtCurrentPassword);
		txtCurrentPassword.setColumns(10);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(255, 255, 141, 19);
		contentPane.add(txtNewPassword);
		txtPassword.setVisible(false);

		
		txtConfirmNewPassword = new JTextField();
		txtConfirmNewPassword.setColumns(10);
		txtConfirmNewPassword.setBounds(254, 331, 142, 19);
		contentPane.add(txtConfirmNewPassword);

		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName="";
				String lastName="";
				String accountNumber="";
				String userName="";
				String password="";
				String mobileNumber="";
				String landNumber="";
				
				int ID=Integer.valueOf(txtID.getText());
				String currentPassword=txtCurrentPassword.getText();
				String newPassword=txtNewPassword.getText();
				String confirmNewPassword=txtConfirmNewPassword.getText();
				
				ArrayList<Customer>custList=custDB.getAll();
				System.out.println(custList);
			    
				for(Customer custList1:custList) {
					if(ID==custList1.getID())
						firstName=custList1.getFirstName();
					    lastName=custList1.getLastName();
					    accountNumber=custList1.getAccountNumber();
					    userName=custList1.getUserName();
					    mobileNumber=custList1.getMobileNumber();
					    landNumber=custList1.getLandNumber();
					if(currentPassword.equals(custList1.getPassword())){
						if(newPassword.equals(confirmNewPassword)) {
							Customer customer=new Customer(ID, firstName,lastName,accountNumber,userName,newPassword, mobileNumber,landNumber);
							int result=custDB.update(customer);
							if(result>0) {
								JOptionPane.showMessageDialog(null, "Pasword is update successfully  confirmed");
							}else {
								JOptionPane.showMessageDialog(null,"Password is not update successfully  confirmed");
							}
							
						}
						
					}
					
				}
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChange.setBounds(127, 469, 100, 21);
		contentPane.add(btnChange);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(418, 469, 100, 21);
		contentPane.add(btnBack);
		
		JLabel lblCurrentPassword = new JLabel("Password\r\n");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPassword.setBounds(127, 188, 117, 13);
		contentPane.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPassword.setBounds(95, 269, 117, 13);
		contentPane.add(lblNewPassword);
		
		JLabel lblNewConfirmPassword = new JLabel("Confirm New Password");
		lblNewConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewConfirmPassword.setBounds(59, 332, 168, 13);
		contentPane.add(lblNewConfirmPassword);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setBounds(152, 124, 45, 13);
		contentPane.add(lblID);
		
	
		
	}
}
