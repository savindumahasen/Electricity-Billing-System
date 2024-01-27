package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI frame = new HomeUI();
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
	public HomeUI() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setBounds(0, 0, 757, 376);
		contentPane.add(lbl1);
		setLocationRelativeTo(this);
		Image homeImage = new ImageIcon(this.getClass().getResource("/HomeImage1.jpg")).getImage();
		lbl1.setIcon(new ImageIcon(homeImage));
		
		JButton btnClick = new JButton("Click Me");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUI customerReg=new CustomerUI();
				customerReg.setVisible(true);
				setVisible(false);
			}
		});
		btnClick.setBounds(337, 414, 85, 21);
		contentPane.add(btnClick);
		
		
	}
}
