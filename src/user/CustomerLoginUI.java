package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import buisness.Customer;
import data.CustomerDB;

public class CustomerLoginUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private CustomerDB custDB;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginUI frame = new CustomerLoginUI();
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
	public CustomerLoginUI() {
		setTitle("CustomerLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		custDB=new CustomerDB();
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setBounds(104, 98, 45, 13);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(253, 97, 134, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setToolTipText("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(101, 171, 99, 13);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(253, 170, 134, 19);
		contentPane.add(txtPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPassword.setBounds(101, 234, 142, 13);
		contentPane.add(lblConfirmPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(253, 233, 134, 19);
		contentPane.add(txtConfirmPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidation()) {
				int ID=Integer.valueOf(txtID.getText());
				String password=txtPassword.getText();
				String confirmPassword=txtConfirmPassword.getText();
				System.out.println(ID);
				System.out.println(password);
				System.out.println(confirmPassword);
				Customer customer=custDB.get(ID);
				if(ID==customer.getID() & password.equals(customer.getPassword())) {
					if(password.equals(confirmPassword)) {
					 JOptionPane.showMessageDialog(null, "Login  is  successfully  confirmed");
					 MainUI mainUI=new MainUI();
					 mainUI.setVisible(true);
					 setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,"Your confirm password and password shuld be mactch");
						JOptionPane.showMessageDialog(null,"Check your confirm password and password");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Login is not successfully  confirmed ");
				}
				
			}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(64, 315, 85, 21);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(352, 315, 85, 21);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(204, 29, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHeading = new JLabel("Login");
		lblHeading.setForeground(Color.ORANGE);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeading.setBounds(214, 29, 134, 30);
		contentPane.add(lblHeading);
		
		JLabel lbl4 = new JLabel("New label");
		lbl4.setBounds(0, 0, 514, 398);
		contentPane.add(lbl4);
		Image loginImage = new ImageIcon(this.getClass().getResource("/Login.jpg")).getImage();
		lbl4.setIcon(new ImageIcon(loginImage));
	
		
		setLocationRelativeTo(this);
	}
	private boolean checkValidation() {
		
		if(txtID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"ID cannot be blank");
			return false;
		}
		try {
			int ID=Integer.valueOf(txtID.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"ID must be numeric");
			return false;
		}
		if(txtPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Password cannot be blank");
			return false;
		}
		if(txtConfirmPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Confirm Password cannot be blank");
			return false;
		}
		
		return true;
	}
}
