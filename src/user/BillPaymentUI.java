package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import buisness.Customer;
import data.CustomerDB;
import data.PaymentDB;
import buisness.Payment;

public class BillPaymentUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;
	private JTextField txtEmail;
	private CustomerDB customerDB;
	private PaymentDB paymentDB;
	private JTextField txtAccount;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillPaymentUI frame = new BillPaymentUI();
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
	public BillPaymentUI() {
		setTitle("Online Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccount = new JLabel("Account to be paid");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAccount.setToolTipText("");
		lblAccount.setBounds(70, 112, 159, 17);
		contentPane.add(lblAccount);
		
		txtAccount = new JTextField();
		txtAccount.setBounds(428, 113, 198, 19);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);
		
		customerDB=new CustomerDB();
		paymentDB=new PaymentDB();
		ArrayList<Customer> cust1=customerDB.getAll();
		for(Customer custList1:cust1) {
			txtAccount.setText(custList1.getAccountNumber()+" "+custList1.getFirstName()+" "+custList1.getLastName());
		}
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setToolTipText("");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(70, 202, 159, 17);
		contentPane.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(425, 203, 201, 19);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(70, 309, 132, 13);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(425, 306, 201, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account="";
				ArrayList<Customer> custList=customerDB.getAll();
				   account=txtAccount.getText();
				   double amount=Double.valueOf(txtAmount.getText());
				   String email=txtEmail.getText();
				   Payment payment=new Payment(account,amount,email);
				   int result=paymentDB.add(payment);
				   if(result==1) {
					   JOptionPane.showMessageDialog(null,"Payment transaction is sucessfully  completed");
				   }else {
					   JOptionPane.showMessageDialog(null,"Payment transaction is not sucessfully  completed");
				   }
				
				
			}
		});
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProceed.setBounds(362, 424, 108, 21);
		contentPane.add(btnProceed);
		
		btnBack = new JButton("Back\r\n");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUI mainUI=new MainUI();
				mainUI.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(163, 424, 108, 21);
		contentPane.add(btnBack);
		
	
	}
}
