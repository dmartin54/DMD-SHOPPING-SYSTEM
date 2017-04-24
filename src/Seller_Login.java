import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;

public class Seller_Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection connection1 = null;
	PreparedStatement pst =null;
	ResultSet rs =null;
	
	private JPanel contentPane;
	//private JPanel Seller_Registration;
	private JTextField seller_username;
	private JPasswordField Seller_password;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller_Login frame = new Seller_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
	}
	
	//method to close window
		public void close(){
			WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
					
				}
	
	//call the java connection class
			Connection connection = null;
			private JTextField email2;
			private JTextField country2;
			private JTextField state2;
			private JTextField city2;
			private JTextField address2;
			private JTextField lastname2;
			private JTextField firstname2;
			private JPasswordField password2;
			private JTextField username2;
			private JTextField Seller_name;
			/**
	 * Create the frame.
	 */
	public Seller_Login() {
		
		connection1 = sqliteConnection.dbConnector();
		
		
	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1491, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
	
		
		//panels
		final JPanel login = new JPanel();
		login.setBackground(SystemColor.text);
		contentPane.add(login, "name_356458617514423");
		login.setLayout(null);
		
		final JPanel Seller_Registration = new JPanel();
		Seller_Registration.setBackground(SystemColor.text);
		contentPane.add(Seller_Registration, "name_361260527207681");
		Seller_Registration.setLayout(null);
		
		final JPanel Regis2_Confirm = new JPanel();
		Regis2_Confirm.setBackground(SystemColor.text);
		contentPane.add(Regis2_Confirm, "name_361762882568968");
		Regis2_Confirm.setLayout(null);
		
		
		

		
		JLabel label = new JLabel("Seller Portal Login");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(656, 141, 153, 29);
		login.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Dwight\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_1.setBounds(677, 27, 110, 100);
		login.add(label_1);
		
		JLabel label_2 = new JLabel("Username:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(690, 198, 85, 21);
		login.add(label_2);
		
		seller_username = new JTextField();
		seller_username.setColumns(10);
		seller_username.setBounds(501, 221, 463, 29);
		login.add(seller_username);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(690, 283, 85, 14);
		login.add(label_3);
		
		Seller_password = new JPasswordField();
		Seller_password.setBounds(501, 308, 463, 29);
		login.add(Seller_password);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try{
					//create a query with the database 
					String query2 = "select * from Seller_Info where username2=? and password2=?";
					
					//prepared statement for which the query will be passed to
					PreparedStatement  pst2 = connection1.prepareStatement(query2);
					
					//pass value from text box that the user will enter to the prepared statement
					pst2.setString(1, seller_username.getText() );
					pst2.setString(2, Seller_password.getText() );
					
					//this result set execute the query 
					ResultSet rs2  = pst2.executeQuery();
					
					//loop that return value one by one 
					int count2 = 0;
					while (rs2.next()){
						count2 = count2+1;
						
					}if (count2 == 1){
						
						JOptionPane.showMessageDialog(null, "Login Successful!");
						//call Admin menu when login button is clicked
						//close();
						AddRemoveUpdate_products Seller_Home = new AddRemoveUpdate_products();
						Seller_Home.setVisible(true);
						
					}
					else if (count2 > 1){
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password Try Again!");
					}
					//close connection with database after query is executed
					rs2.close();
					pst2.close();
					
				}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
				
					} 
				//close connection
				finally {	
					try{
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				}
				}
				
			
		});
		LoginBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		LoginBtn.setBackground(new Color(102, 102, 153));
		LoginBtn.setBounds(501, 375, 463, 29);
		login.add(LoginBtn);
		
		JLabel label_4 = new JLabel("Forgot your password?");
		label_4.setBounds(666, 415, 133, 14);
		login.add(label_4);
		
		JButton button_1 = new JButton("Register");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Seller_Registration.setVisible(true);
				login.setVisible(false);
					
				
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(new Color(102, 102, 153));
		button_1.setBounds(666, 449, 133, 29);
		login.add(button_1);
		
		JButton button_10 = new JButton("<<back");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);	
			}
		});
		button_10.setBounds(0, 0, 89, 23);
		login.add(button_10);
		
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon("C:\\Users\\Dwight\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_13.setBounds(493, 22, 100, 89);
		Seller_Registration.add(label_13);
		
		JButton button_8 = new JButton("<<Back");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_Registration.setVisible(false);
				login.setVisible(true);
			}
		});
		button_8.setBounds(0, 0, 93, 29);
		Seller_Registration.add(button_8);
		
		JLabel label_14 = new JLabel("New Seller? Please complete the form below");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(453, 111, 274, 29);
		Seller_Registration.add(label_14);
		
		JLabel label_15 = new JLabel("Username:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(228, 150, 123, 21);
		Seller_Registration.add(label_15);
		
		JLabel label_16 = new JLabel("Password:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_16.setBounds(228, 182, 123, 21);
		Seller_Registration.add(label_16);
		
		JLabel label_17 = new JLabel("First Name:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_17.setBounds(228, 221, 123, 21);
		Seller_Registration.add(label_17);
		
		JLabel label_18 = new JLabel("Last Name:");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_18.setBounds(228, 253, 123, 21);
		Seller_Registration.add(label_18);
		
		JLabel label_19 = new JLabel("Address:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_19.setBounds(228, 285, 123, 21);
		Seller_Registration.add(label_19);
		
		JLabel label_20 = new JLabel("City:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_20.setBounds(228, 336, 123, 21);
		Seller_Registration.add(label_20);
		
		JLabel label_21 = new JLabel("State/Province:");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_21.setBounds(228, 368, 123, 21);
		Seller_Registration.add(label_21);
		
		JLabel label_22 = new JLabel("Country:");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_22.setBounds(228, 400, 123, 21);
		Seller_Registration.add(label_22);
		
		JLabel label_23 = new JLabel("Email:");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_23.setBounds(228, 432, 123, 21);
		Seller_Registration.add(label_23);
		
		JCheckBox checkBox = new JCheckBox("I have read and agree to the terms and conditions specified in this agreement");
		checkBox.setForeground(new Color(255, 0, 0));
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox.setBounds(343, 457, 470, 23);
		Seller_Registration.add(checkBox);
		
		JButton button_9 = new JButton("Submit");
		button_9.addActionListener(new ActionListener() {
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
				
				PreparedStatement statement=null;
				try{
					//define class for connection 
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dwight\\Desktop\\ECLIPSE\\SE PROJECT\\DMDdata.sqlite\\");
					
					//store customer registration info to database table
					statement = (PreparedStatement) connection.prepareStatement("insert into Seller_Info(username2,password2,firstname2,lastname2,address2,city2,state2,country2,email2) values (?,?,?,?,?,?,?,?,?)");
					if (username2.getText().equals(""))
                        JOptionPane.showMessageDialog(username2,
                                    "Please provide username");
                  else if(password2.getText().equals(""))
                        JOptionPane.showMessageDialog(password2,
                                    "Please provide a password2");
					
					
					
                  else{
					
					statement.setString(1, username2.getText() );
					statement.setString(2, password2.getText());
					statement.setString(3, firstname2.getText());
					statement.setString(4, lastname2.getText());
					statement.setString(5, address2.getText());
					statement.setString(6, city2.getText());
					statement.setString(7, state2.getText());
					statement.setString(8, country2.getText());
					statement.setString(9, email2.getText());
					statement.execute();
					
					//call customer login panel when login button is clicked
					Regis2_Confirm.setVisible(true);
					Seller_Registration.setVisible(false);	
                  }
				}catch(Exception ex){
					ex.printStackTrace();
				}
			
				
				
				
			}
		});
		
		
		
		button_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_9.setBackground(new Color(102, 102, 153));
		button_9.setBounds(507, 487, 133, 29);
		Seller_Registration.add(button_9);
		
		email2 = new JTextField();
		email2.setColumns(10);
		email2.setBounds(453, 432, 229, 21);
		Seller_Registration.add(email2);
		
		country2 = new JTextField();
		country2.setColumns(10);
		country2.setBounds(453, 402, 229, 21);
		Seller_Registration.add(country2);
		
		state2 = new JTextField();
		state2.setColumns(10);
		state2.setBounds(453, 370, 229, 21);
		Seller_Registration.add(state2);
		
		city2 = new JTextField();
		city2.setColumns(10);
		city2.setBounds(453, 338, 229, 21);
		Seller_Registration.add(city2);
		
		address2 = new JTextField();
		address2.setColumns(10);
		address2.setBounds(453, 287, 229, 40);
		Seller_Registration.add(address2);
		
		lastname2 = new JTextField();
		lastname2.setColumns(10);
		lastname2.setBounds(453, 244, 229, 21);
		Seller_Registration.add(lastname2);
		
		firstname2 = new JTextField();
		firstname2.setColumns(10);
		firstname2.setBounds(453, 212, 229, 21);
		Seller_Registration.add(firstname2);
		
		password2 = new JPasswordField();
		password2.setBounds(453, 180, 229, 21);
		Seller_Registration.add(password2);
		
		username2 = new JTextField();
		username2.setColumns(10);
		username2.setBounds(453, 150, 229, 21);
		Seller_Registration.add(username2);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dwight\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		lblNewLabel.setBounds(464, 11, 107, 113);
		Regis2_Confirm.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Congratulations Registration Completed");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(280, 135, 409, 30);
		Regis2_Confirm.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Successfully!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(450, 176, 140, 38);
		Regis2_Confirm.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dwight\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\confirm.jpg"));
		lblNewLabel_3.setBounds(421, 225, 249, 231);
		Regis2_Confirm.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				Regis2_Confirm.setVisible(false);
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(391, 467, 257, 46);
		Regis2_Confirm.add(btnNewButton);
		
		Seller_name = new JTextField();
		Seller_name.setColumns(10);
		Seller_name.setBounds(422, 158, 333, 31);

		
	}
}
