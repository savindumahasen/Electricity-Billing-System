package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import  buisness.Customer;
import data.CustomerDB;

public class CustomerUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAccountNumber;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private CustomerDB custDB;
	private JTextField txtID;
	private JTextField txtMobileNumber;
	private JTextField txtLandNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUI frame = new CustomerUI();
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
	public CustomerUI() {
		setResizable(false);
		setTitle("Customer Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 716);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(this);
		
		custDB=new CustomerDB();
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setBounds(216, 86, 45, 13);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(405, 85, 153, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(216, 123, 107, 19);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(405, 125, 153, 19);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(216, 184, 91, 13);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(405, 183, 153, 19);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("AccountNumber");
		lblAccountNumber.setForeground(Color.WHITE);
		lblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccountNumber.setBounds(216, 241, 124, 27);
		contentPane.add(lblAccountNumber);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(405, 247, 153, 19);
		contentPane.add(txtAccountNumber);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(216, 308, 91, 13);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(405, 307, 153, 19);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(216, 367, 91, 13);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtPassword.setBounds(405, 366, 153, 19);
		contentPane.add(txtPassword);
		
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setBounds(405, 416, 153, 19);
		contentPane.add(txtMobileNumber);
		txtMobileNumber.setColumns(10);
		
		JLabel lblLandNumber = new JLabel("Land Number");
		lblLandNumber.setForeground(Color.WHITE);
		lblLandNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLandNumber.setBounds(216, 475, 124, 13);
		contentPane.add(lblLandNumber);
		
		txtLandNumber = new JTextField();
		txtLandNumber.setColumns(10);
		txtLandNumber.setBounds(405, 474, 153, 19);
		contentPane.add(txtLandNumber);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidation()) {
				int ID=Integer.valueOf(txtID.getText());
				String firstName=txtFirstName.getText();
				String lastName=txtLastName.getText();
				String accountNumber=txtAccountNumber.getText();
				String userName=txtUserName.getText();
				String password=txtPassword.getText();
				String mobileNumber=txtMobileNumber.getText();
				String landNumber=txtLandNumber.getText();

				Customer cust=new Customer( ID,firstName, lastName, accountNumber, userName,password,mobileNumber,landNumber);
				int result=custDB.add(cust);
				if(result>0) {
					JOptionPane.showMessageDialog(null,"Customer Registration is successfully confirmed");
					CustomerLoginUI log=new CustomerLoginUI();
					log.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Customer Registration is not successfully confirmed");
				}
				
				}else {
					
				}
				
				
				
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(222, 620, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);  // exit the system
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(432, 620, 85, 21);
		contentPane.add(btnCancel);
		
		JLabel lblHeading = new JLabel("Customer Registration");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeading.setBounds(226, 23, 291, 36);
		contentPane.add(lblHeading);
		
		JLabel lblMobilNumber = new JLabel("Mobile Number");
		lblMobilNumber.setForeground(Color.WHITE);
		lblMobilNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobilNumber.setBounds(216, 419, 124, 13);
		contentPane.add(lblMobilNumber);
		
		JButton btnRegisterAlready = new JButton("Login");
		btnRegisterAlready.setForeground(Color.BLACK);
		btnRegisterAlready.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegisterAlready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerLoginUI login=new CustomerLoginUI(); //create the CustomerLoginUI obeject
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnRegisterAlready.setBounds(301, 546, 187, 21);
		contentPane.add(btnRegisterAlready);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setBounds(0, 0, 673, 679);
		contentPane.add(lbl3);
		
		// Insert the image
		Image registerImage = new ImageIcon(this.getClass().getResource("/Registration.jpg")).getImage();
		lbl3.setIcon(new ImageIcon(registerImage));
	
	
	
	}
	
	private boolean checkValidation() {
		
		if(txtID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"ID cannot be blank");
			return false;
		}
		try {
			
			int ID=Integer.valueOf(txtID.getText());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ID should be numberic");
		}
		if(txtFirstName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"FirstName cannot be blank");
			return false;
			
		}
		if(txtLastName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"LastName cannot be blank");
			return false;
			
		}
		if(txtAccountNumber.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"AccountNumber cannot be blank");
			return false;
			
		}
		if(txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"UserName cannot be blank");
			return false;
		}
	
		if(txtPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Password cannot be blank");
			return false;
			
		}
		if(txtMobileNumber.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Mobile Number cannot be blank");
			return false;
		}
		if(txtLandNumber.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Land Number cannot be blank");
			return false;
		}
		
		return true;
	}
}
