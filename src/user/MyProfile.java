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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class MyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private CustomerDB customer;
	private JTextField txtLastName;
    private CustomerDB custDB;
    private JButton btnBack;
    private JTextField txtMobileNumber;
    private JTextField txtLandNumber;
    private JTextField txtID;
    private JButton btnUpdatePassword_1;
    private JButton btnNewButton_1;
    private JButton btnSearch;
    private JButton btnNewButton;
    private JButton btnNewButton_2;
    private JButton btnFind;
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
		setBounds(100, 100, 654, 618);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		custDB=new CustomerDB();
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(181, 45, 280, 28);
		contentPane.add(txtID);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(181, 102, 280, 28);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		
		txtLastName = new JTextField();
		txtLastName.setBounds(181, 164, 274, 28);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBounds(181, 226, 274, 28);
		contentPane.add(txtMobileNumber);
		
		txtLandNumber = new JTextField();
		txtLandNumber.setColumns(10);
		txtLandNumber.setBounds(181, 295, 274, 28);
		contentPane.add(txtLandNumber);
		
		setLocationRelativeTo(this);
		

		btnFind = new JButton("Search\r\n");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID= Integer.valueOf(JOptionPane.showInputDialog("",txtID.getText()));
				Customer customer=custDB.get(ID);
				txtID.setText(String.valueOf(customer.getID()));
				txtFirstName.setText(customer.getFirstName());
				txtLastName.setText(customer.getLastName());
				txtMobileNumber.setText(customer.getMobileNumber());
				txtLandNumber.setText(customer.getLandNumber());
				
			}
		});
		
		JButton btnUpdate = new JButton("Edit Profile");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String accountNumber="";
				String userName="";
				String password="";
				String mobileNumber="";
				String landNumber="";
				int ID=Integer.valueOf(txtID.getText());
				String firstName=txtFirstName.getText();
				String lastName=txtLastName.getText();
				Customer custList2=custDB.get(ID);
				    
				    accountNumber=custList2.getAccountNumber();
				    userName=custList2.getUserName();
				    password=custList2.getPassword();
				    mobileNumber=txtMobileNumber.getText();
				    landNumber=txtLandNumber.getText();
				    
			
				Customer customer=new Customer(ID,firstName,lastName,accountNumber,userName,password,mobileNumber,landNumber);
				int result=custDB.update(customer);
				if(result>0) {
					JOptionPane.showMessageDialog(null, "Customer data updated is successfully  confirmed");
				}else {
					JOptionPane.showMessageDialog(null, "Customer data updated is not successfully  confirmed");
				}
			}
		});
		btnUpdate.setBounds(70, 425, 510, 21);
		contentPane.add(btnUpdate);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				MainUI mainUI=new MainUI();
				mainUI.setVisible(true);
			}
		});
		btnBack.setBounds(70, 490, 510, 21);
		contentPane.add(btnBack);
		
		btnUpdatePassword_1 = new JButton("Change Password");
		btnUpdatePassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword changePassword=new ChangePassword();
				changePassword.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdatePassword_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdatePassword_1.setBounds(70, 456, 510, 21);
		contentPane.add(btnUpdatePassword_1);
		
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(70, 394, 510, 21);
		contentPane.add(btnFind);
		
		JLabel lbl10 = new JLabel("New label");
		lbl10.setBounds(0, 0, 640, 581);
		contentPane.add(lbl10);
		Image myProfileImage = new ImageIcon(this.getClass().getResource("/MyProfile.png")).getImage();
		lbl10.setIcon(new ImageIcon(myProfileImage));
		
		
	

	
	
		
		
		
	}
}
