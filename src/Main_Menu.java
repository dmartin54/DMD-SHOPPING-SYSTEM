import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Main_Menu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu frame = new Main_Menu();
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
	public Main_Menu() {
		initialize();
	}
	
	//method to close window
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
				
			}
	
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 80, 2210, 1210);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//panels
		
		JPanel Main_Menu = new JPanel();
		Main_Menu.setBackground(Color.WHITE);
		contentPane.add(Main_Menu, "name_365540731384606");
		Main_Menu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\OFFICIAL LOGO.jpg"));
		lblNewLabel.setBounds(886, 11, 402, 354);
		Main_Menu.add(lblNewLabel);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				Customer_Login customer = new Customer_Login();
				customer.setVisible(true);	
				
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnCustomer.setBounds(847, 396, 224, 53);
		Main_Menu.add(btnCustomer);
		
		JButton btnSeller = new JButton("SELLER");
		btnSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddRemoveUpdate_products window = new AddRemoveUpdate_products(); 
				 //seller.setVisible(true);
			  // dispose();	
			
			}
		});
		btnSeller.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSeller.setBounds(1090, 492, 224, 53);
		Main_Menu.add(btnSeller);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				Admin_Login admin = new Admin_Login();
				admin.setVisible(true);
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnAdmin.setBounds(847, 492, 224, 53);
		Main_Menu.add(btnAdmin);
		
		JButton Guest = new JButton("Guest");
		Guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				HomePage home = new HomePage();
				home.setVisible(true);
				
				
				
			}
		});
		Guest.setFont(new Font("Tahoma", Font.BOLD, 21));
		Guest.setBounds(1090, 395, 224, 54);
		Main_Menu.add(Guest);
	}
}
