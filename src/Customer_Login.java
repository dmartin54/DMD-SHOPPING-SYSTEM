import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Customer_Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Login frame = new Customer_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//call the java connection class
	Connection connection = null;
	private JTextField username1;
	private JPasswordField password1;
	private JTextField firstname1;
	private JTextField lastname1;
	private JTextField address1;
	private JTextField city1;
	private JTextField state1;
	private JTextField country1;
	private JTextField email1;

	/**
	 * Create the frame.
	 */
	
	public Customer_Login() {
		initialize();
	}
		
	//method to close window
			public void close(){
				WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
						
					}
		
	private void initialize() {
		connection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 2210, 1210);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		login.setBackground(Color.WHITE);
		contentPane.add(login, "name_369047147735130");
		login.setLayout(null);
		
		JPanel Customer_Registration = new JPanel();
		Customer_Registration.setBackground(Color.WHITE);
		contentPane.add(Customer_Registration, "name_369900260264302");
		Customer_Registration.setLayout(null);
		
		JPanel Regis2_Confirm = new JPanel();
		Regis2_Confirm.setBackground(Color.WHITE);
		contentPane.add(Regis2_Confirm, "name_371359442393921");
		Regis2_Confirm.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label.setBounds(1037, 64, 100, 100);
		login.add(label);
		
		JLabel label_1 = new JLabel("Customer Portal Login");
		label_1.setFont(new Font("Dialog", Font.BOLD, 27));
		label_1.setBounds(928, 181, 318, 29);
		login.add(label_1);
		
		JLabel label_2 = new JLabel("Username:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 19));
		label_2.setBounds(1037, 257, 110, 29);
		login.add(label_2);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 27));
		username.setColumns(10);
		username.setBounds(855, 291, 463, 44);
		login.add(username);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 19));
		label_3.setBounds(1037, 356, 110, 21);
		login.add(label_3);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 27));
		password.setBounds(855, 398, 463, 47);
		login.add(password);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					//create a query with the database 
					String query = "select * from Customer_Info where username1=? and password1=?";
					
					//prepared statement for which the query will be passed to
					PreparedStatement  pst = connection.prepareStatement(query);
					
					//pass value from text box that the suer will enter to the prepared statement
					pst.setString(1, username.getText() );
					pst.setString(2, password.getText() );
					
					//this result set execute the query 
					ResultSet rs  = pst.executeQuery();
					
					//loop that return value one by one 
					int count = 0;
					while (rs.next()){
						count = count+1;
						
					}if (count == 1){
						JOptionPane.showMessageDialog(null, "Login Successful!");
						//call homepage  menu when login button is clicked
						dispose();
						contentPane.setVisible(false);
						HomePage home = new HomePage();
						home.setVisible(true);
						
						
					}
					else if (count > 1){
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password Try Again!");
					}
					//close connection with database after query is executed
					rs.close();
					pst.close();
					
				}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
				
					} 
				//close connection
				finally {	
					try{
						
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
					
					
				}
				}
				
			
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBackground(new Color(102, 102, 153));
		button.setBounds(855, 496, 463, 44);
		login.add(button);
		
		JLabel label_4 = new JLabel("Forgot your password?");
		label_4.setFont(new Font("Dialog", Font.BOLD, 19));
		label_4.setBounds(979, 561, 230, 29);
		login.add(label_4);
		
		JButton button_1 = new JButton("Register");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//go to register panel when button is clicked
				Customer_Registration.setVisible(true);
				login.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBackground(new Color(102, 102, 153));
		button_1.setBounds(855, 604, 463, 44);
		login.add(button_1);
		
		JButton button_2 = new JButton("<Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				contentPane.setVisible(false);
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);	
	
				
			}
		});
		button_2.setForeground(new Color(102, 102, 153));
		button_2.setBounds(0, 0, 85, 19);
		login.add(button_2);
		
		
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_5.setBounds(1034, 0, 105, 100);
		Customer_Registration.add(label_5);
		
		JButton button_3 = new JButton("<<Back");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Registration.setVisible(false);
				login.setVisible(true);
				
				
			}
		});
		button_3.setForeground(new Color(102, 102, 153));
		button_3.setBounds(0, 0, 128, 40);
		Customer_Registration.add(button_3);
		
		JLabel label_6 = new JLabel("Username:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(881, 146, 123, 21);
		Customer_Registration.add(label_6);
		
		JLabel label_7 = new JLabel("New Customer? Please complete the form below");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(937, 96, 299, 29);
		Customer_Registration.add(label_7);
		
		username1 = new JTextField();
		username1.setColumns(10);
		username1.setBounds(972, 143, 229, 21);
		Customer_Registration.add(username1);
		
		JLabel label_8 = new JLabel("Password:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_8.setBounds(881, 178, 123, 21);
		Customer_Registration.add(label_8);
		
		password1 = new JPasswordField();
		password1.setBounds(972, 175, 229, 21);
		Customer_Registration.add(password1);
		
		firstname1 = new JTextField();
		firstname1.setColumns(10);
		firstname1.setBounds(972, 214, 229, 21);
		Customer_Registration.add(firstname1);
		
		JLabel label_9 = new JLabel("First Name:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_9.setBounds(881, 217, 123, 21);
		Customer_Registration.add(label_9);
		
		lastname1 = new JTextField();
		lastname1.setColumns(10);
		lastname1.setBounds(972, 240, 229, 21);
		Customer_Registration.add(lastname1);
		
		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(972, 282, 229, 40);
		Customer_Registration.add(address1);
		
		JLabel label_10 = new JLabel("Address:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_10.setBounds(881, 294, 123, 21);
		Customer_Registration.add(label_10);
		
		city1 = new JTextField();
		city1.setColumns(10);
		city1.setBounds(972, 343, 229, 29);
		Customer_Registration.add(city1);
		
		JLabel label_11 = new JLabel("City:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_11.setBounds(881, 350, 123, 21);
		Customer_Registration.add(label_11);
		
		state1 = new JTextField();
		state1.setColumns(10);
		state1.setBounds(972, 397, 229, 32);
		Customer_Registration.add(state1);
		
		JLabel label_12 = new JLabel("State/Province:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_12.setBounds(881, 405, 87, 21);
		Customer_Registration.add(label_12);
		
		country1 = new JTextField();
		country1.setColumns(10);
		country1.setBounds(972, 450, 229, 29);
		Customer_Registration.add(country1);
		
		JLabel label_13 = new JLabel("Country:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_13.setBounds(881, 457, 123, 21);
		Customer_Registration.add(label_13);
		
		email1 = new JTextField();
		email1.setColumns(10);
		email1.setBounds(972, 500, 229, 32);
		Customer_Registration.add(email1);
		
		JLabel label_14 = new JLabel("Email:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_14.setBounds(881, 508, 123, 21);
		Customer_Registration.add(label_14);
		
		JCheckBox checkBox = new JCheckBox("I have read and agree to the terms and conditions specified in this agreement");
		checkBox.setForeground(Color.RED);
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkBox.setBounds(780, 616, 613, 23);
		Customer_Registration.add(checkBox);
		
		JButton button_4 = new JButton("Submit");
		button_4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
				
				PreparedStatement statement=null;
				try{
					//define class for connection 
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\DMDdata.sqlite\\");
									
					//store customer registration info to database table
					statement = (PreparedStatement) connection.prepareStatement("insert into Customer_Info(username1,password1,firstname1,lastname1,address1,city1,state1,country1,email) values (?,?,?,?,?,?,?,?,?)");
					
					if (username1.getText().equals(""))
                        JOptionPane.showMessageDialog(username1,
                                    "Please provide username");
                  else if(password1.getText().equals(""))
                        JOptionPane.showMessageDialog(password1,
                                    "Please provide a password");
                  else if(firstname1.getText().equals(""))
                      JOptionPane.showMessageDialog(firstname1,
                                  "Please provide firstname");
                  else if(lastname1.getText().equals(""))
                      JOptionPane.showMessageDialog(lastname1,
                                  "Please provide firstname");
                  else if(address1.getText().equals(""))
                      JOptionPane.showMessageDialog(address1,
                                  "Please provide address");
                  else if(city1.getText().equals(""))
                      JOptionPane.showMessageDialog(city1,
                                  "Please provide city");
                  else if(state1.getText().equals(""))
                      JOptionPane.showMessageDialog(state1,
                                  "Please provide State");
                  else if(state1.getText().equals(""))
                      JOptionPane.showMessageDialog(state1,
                                  "Please provide State");
                  else if(country1.getText().equals(""))
                      JOptionPane.showMessageDialog(country1,
                                  "Please provide country");
                  else if(email1.getText().equals(""))
                      JOptionPane.showMessageDialog(email1,
                                  "Please provide email");
                  else{
					statement.setString(1, username1.getText() );
					statement.setString(2, password1.getText());
					statement.setString(3, firstname1.getText());
					statement.setString(4, lastname1.getText());
					statement.setString(5, address1.getText());
					statement.setString(6, city1.getText());
					statement.setString(7, state1.getText());
					statement.setString(8, country1.getText());
					statement.setString(9, email1.getText());
					
					statement.execute();
					
					//call customer login panel when login button is clicked
					Regis2_Confirm.setVisible(true);
					Customer_Registration.setVisible(false);	
					
                  }
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		button_4.setBackground(new Color(102, 102, 153));
		button_4.setBounds(918, 678, 337, 53);
		Customer_Registration.add(button_4);
		
		JLabel label_15 = new JLabel("Last Name:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(881, 243, 123, 21);
		Customer_Registration.add(label_15);
		
		
		
		JLabel label_16 = new JLabel("Congratulations Registration Completed");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_16.setBounds(882, 135, 409, 30);
		Regis2_Confirm.add(label_16);
		
		JLabel label_17 = new JLabel("Successfully!");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_17.setBounds(1017, 176, 140, 38);
		Regis2_Confirm.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_18.setBounds(1033, 11, 107, 113);
		Regis2_Confirm.add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\confirm.jpg"));
		label_19.setBounds(962, 225, 249, 231);
		Regis2_Confirm.add(label_19);
		
		JButton button_5 = new JButton("LOGIN");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				Regis2_Confirm.setVisible(false);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_5.setBounds(958, 467, 257, 46);
		Regis2_Confirm.add(button_5);
	}
}
