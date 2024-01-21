package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("CustomerLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(101, 109, 68, 13);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(236, 108, 134, 19);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(101, 171, 68, 13);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(236, 170, 134, 19);
		contentPane.add(txtPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(101, 234, 114, 13);
		contentPane.add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 234, 134, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(64, 315, 85, 21);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(352, 315, 85, 21);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(204, 29, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHeading = new JLabel("Login");
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeading.setBounds(214, 29, 134, 30);
		contentPane.add(lblHeading);
		
		setLocationRelativeTo(this);
	}
}
