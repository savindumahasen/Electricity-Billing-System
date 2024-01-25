package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setTitle("Electricity Billing Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 604);
	
		
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
			}
		});
		mntmHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mnHome.add(mntmHome);
		
		JMenu mnPayment = new JMenu("Payment");
		menuBar.add(mnPayment);
		
		JMenuItem mntmBillPayment = new JMenuItem("Bill Payment");
		mntmBillPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillPaymentUI payment=new BillPaymentUI();
				payment.setVisible(true);
				setVisible(false);
				
			}
		});
		mntmBillPayment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		mnPayment.add(mntmBillPayment);
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		
		JMenuItem mntmLogOut = new JMenuItem("LogOut");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginUI login=new CustomerLoginUI();
				login.setVisible(true);
				setVisible(false);
			}
		});
		mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mnLogout.add(mntmLogOut);
		
		JMenu mnProfile = new JMenu("Profile");
		menuBar.add(mnProfile);
		
		JMenuItem mntmMyProfile = new JMenuItem("My Profile");
		mntmMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyProfile myProfile=new MyProfile();
				myProfile.setVisible(true);
				setVisible(false);
			}
		});
		mntmMyProfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnProfile.add(mntmMyProfile);
	}
}
