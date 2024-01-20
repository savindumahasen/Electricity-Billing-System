package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAccountNumber;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

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
		setTitle("Customer Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 551);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(216, 123, 107, 19);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(405, 125, 153, 19);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(216, 184, 66, 13);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(405, 183, 153, 19);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("AccountNumber");
		lblAccountNumber.setForeground(Color.DARK_GRAY);
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNumber.setBounds(216, 241, 107, 27);
		contentPane.add(lblAccountNumber);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(405, 247, 153, 19);
		contentPane.add(txtAccountNumber);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setForeground(Color.DARK_GRAY);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(216, 308, 91, 13);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(405, 307, 153, 19);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(216, 367, 91, 13);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtPassword.setBounds(405, 366, 153, 19);
		contentPane.add(txtPassword);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName=txtFirstName.getText();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(216, 454, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(405, 454, 85, 21);
		contentPane.add(btnCancel);
		
		JLabel lblHeading = new JLabel("Customer Registration");
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeading.setBounds(243, 23, 291, 36);
		contentPane.add(lblHeading);
	}
}
