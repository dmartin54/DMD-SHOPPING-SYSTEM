import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.CardLayout;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

//import com.toedter.calendar.JCalendar;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import com.toedter.calendar.JCalendar;

@SuppressWarnings("serial")
public class Admin_Login extends JFrame {

	private JPanel contentPane;
	public JTextField Admin_username;
	private JPasswordField Admin_password;
	public JTextField text;
 	
	String userName;
	
		
 	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//call the java connection class
		Connection connection = null;
		private JTable table;
		private JTextField sellerIDtxt;
		private JTextField custIDtxt;
		private JTextField prodIDtxt;
		private JTextField textFieldUser;
		
public void close(){
	WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
			
		}

	/**
	 * Create the frame.
	 */
	public Admin_Login() {
		connection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 80, 2210, 1210);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel Login = new JPanel();
		Login.setBackground(Color.WHITE);
		contentPane.add(Login, "name_458306185347277");
		Login.setLayout(null);
		
		 JPanel Admin_Menu = new JPanel();
		Admin_Menu.setBackground(Color.WHITE);
		contentPane.add(Admin_Menu, "name_459019565468683");
		Admin_Menu.setLayout(null);
		
		JLabel label = new JLabel("Admin Portal Login");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(979, 168, 216, 29);
		Login.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_1.setBounds(1037, 32, 100, 100);
		Login.add(label_1);
		
		JLabel label_2 = new JLabel("Username:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(1031, 248, 111, 21);
		Login.add(label_2);
		
		Admin_username = new JTextField();
		Admin_username.setFont(new Font("Tahoma", Font.PLAIN, 27));
		Admin_username.setColumns(10);
		Admin_username.setBounds(855, 271, 463, 35);
		Login.add(Admin_username);
				
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(1034, 327, 105, 21);
		Login.add(label_3);
		
		Admin_password = new JPasswordField();
		Admin_password.setFont(new Font("Tahoma", Font.PLAIN, 27));
		Admin_password.setBounds(855, 369, 463, 40);
		Login.add(Admin_password);
		
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
	
				try{
					//create a query with the database 
					String query = "select * from Admin_Info where Username=? and Password=? ";
					
					//prepared statement for which the query will be passed to
					PreparedStatement  pst = connection.prepareStatement(query);
					
					//pass value from text box that the suer will enter to the prepared statement
					pst.setString(1, Admin_username.getText() );
					pst.setString(2, Admin_password.getText() );
						
					
					//this result set execute the query 
					ResultSet rs  = pst.executeQuery();
					
					
					
					//loop that return value one by one 
					int count = 0;
					while (rs.next()){
						count = count+1;
						
					}if (count == 1){
						JOptionPane.showMessageDialog(null, "Login Successful!");
						
						//call Admin menu when login button is clicked
						
						Login.setVisible(false);
						Admin_Menu.setVisible(true);
						
						textFieldUser.setText(Admin_username.getText());
												
						
						//close connection with database after query is executed
						rs.close();
						pst.close();
						
					}
					else if (count > 1){
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password Try Again!");
					}
					
					
				}catch(Exception E){
						JOptionPane.showMessageDialog(null, E);
				
					} 
				//close connection
				finally {	
					try{
						
					}catch(Exception E){
						JOptionPane.showMessageDialog(null, e);
					}
					
					
				}
				}
				
			
		});
		
		
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(new Color(102, 102, 153));
		button.setBounds(855, 437, 463, 47);
		Login.add(button);
		
		JLabel label_4 = new JLabel("Forgot your password?");
		label_4.setFont(new Font("Dialog", Font.BOLD, 20));
		label_4.setBounds(971, 509, 232, 29);
		Login.add(label_4);
		
		JButton btnNewButton_2 = new JButton("<<back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_Menu.setVisible(false);
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);	
				close();
			}
		});
		btnNewButton_2.setBounds(0, 0, 85, 23);
		Login.add(btnNewButton_2);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\propiccici.jpg"));
		lblNewLabel.setBounds(21, 11, 154, 143);
		Admin_Menu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		lblNewLabel_1.setBounds(1036, 11, 102, 112);
		Admin_Menu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to your Admin Portal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_2.setBounds(864, 122, 470, 59);
		Admin_Menu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hello!");
		lblNewLabel_3.setForeground(new Color(0, 128, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setBounds(20, 189, 68, 33);
		Admin_Menu.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("VIEW SELLERS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT Seller_ID, username2, firstname2, lastname2, address2, city2, state2, country2, email2  FROM Seller_Info";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					table.setRowHeight(80);
				    table.getColumnModel().getColumn(5).setPreferredWidth(150);
				    table.setFont(new Font("",1,20));
				    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));

							
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(21, 323, 249, 59);
		Admin_Menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW CUSTOMER");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "SELECT customer_ID, username1, firstname1, lastname1, address1, city1, state1, country1, email  FROM Customer_Info";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					table.setRowHeight(40);
				    table.getColumnModel().getColumn(5).setPreferredWidth(150);
				    table.setFont(new Font("",1,20));
				    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));
							
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		btnNewButton_1.setBounds(21, 451, 249, 59);
		Admin_Menu.add(btnNewButton_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT sum(Purchaces) FROM total_sales ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				    table.setDefaultRenderer(String.class, centerRenderer);
							
					
					
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					table.setRowHeight(40);
				    table.setFont(new Font("",1,20));
				    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));
				    
				    
												
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
				
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\sssaaallleee.jpg"));
		button_2.setBounds(95, 731, 103, 82);
		Admin_Menu.add(button_2);
		
		JLabel lblNewLabel_5 = new JLabel("Total Sales");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_5.setBounds(51, 664, 167, 59);
		Admin_Menu.add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);	
			}
		});
		btnNewButton_3.setBounds(2041, 0, 109, 35);
		Admin_Menu.add(btnNewButton_3);
		
		JButton btnViewProducts = new JButton("VIEW PRODUCTS");
		btnViewProducts.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnViewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from Product_Info2";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setRowHeight(40);
				    table.getColumnModel().getColumn(5).setPreferredWidth(150);
				    table.setFont(new Font("",1,20));
				    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));
							
							
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
				
			}
		});
		btnViewProducts.setBounds(21, 575, 249, 65);
		Admin_Menu.add(btnViewProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 323, 1861, 490);
		Admin_Menu.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JButton rmSellerbtn = new JButton("REMOVE SELLER");
		rmSellerbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		rmSellerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String query = "Delete from Seller_Info where Seller_ID=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,sellerIDtxt.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"  Seller Deleted!");
					/*LEAVE OUT!!*ResultSet rs = pst.executeQuery();
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));*/
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
					
				}

			}
		});
		rmSellerbtn.setBounds(684, 240, 231, 59);
		Admin_Menu.add(rmSellerbtn);
		
		JButton rmCustbtn = new JButton("REMOVE CUSTOMER");
		rmCustbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		rmCustbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String query = "Delete from Customer_Info where customer_ID=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,custIDtxt.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"  Customer Deleted!");
					/*LEAVE OUT!!**ResultSet rs = pst.executeQuery();
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));*/
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
					
				}
			}
		});
		rmCustbtn.setBounds(1032, 240, 277, 59);
		Admin_Menu.add(rmCustbtn);
		
		sellerIDtxt = new JTextField();
		sellerIDtxt.setFont(new Font("Tahoma", Font.BOLD, 28));
		sellerIDtxt.setBounds(684, 194, 231, 33);
		Admin_Menu.add(sellerIDtxt);
		sellerIDtxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel(" SELLER ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_7.setBounds(538, 197, 137, 25);
		Admin_Menu.add(lblNewLabel_7);
		
		custIDtxt = new JTextField();
		custIDtxt.setFont(new Font("Tahoma", Font.BOLD, 28));
		custIDtxt.setBounds(1032, 192, 277, 37);
		Admin_Menu.add(custIDtxt);
		custIDtxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CUST ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6.setBounds(925, 197, 109, 30);
		Admin_Menu.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("PROD ID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_8.setBounds(1324, 202, 116, 20);
		Admin_Menu.add(lblNewLabel_8);
		
		prodIDtxt = new JTextField();
		prodIDtxt.setFont(new Font("Tahoma", Font.BOLD, 28));
		prodIDtxt.setBounds(1439, 192, 259, 38);
		Admin_Menu.add(prodIDtxt);
		prodIDtxt.setColumns(10);
		
		JButton rmProdbtn = new JButton("REMOVE PRODUCT");
		rmProdbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		rmProdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String query = "Delete from Product_Info2 where ProductID=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,prodIDtxt.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"  Product Deleted!");
					/*LEAVE OUT!!*ResultSet rs = pst.executeQuery();
					//take name of table
					table.setModel(DbUtils.resultSetToTableModel(rs));*/
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
					
				}
			}
		});
		rmProdbtn.setBounds(1439, 240, 259, 59);
		Admin_Menu.add(rmProdbtn);
		
		//JCalendar calendar = new JCalendar();
		//calendar.setBounds(758, 43, 257, 122);
		//Admin_Menu.add(calendar);
		
	 		
		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		textFieldUser.setBounds(94, 188, 126, 30);
		Admin_Menu.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(1765, 59, 385, 240);
		Admin_Menu.add(calendar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(105, 821, 82, 25);
		Admin_Menu.add(textArea);
		
		JPanel Mail_panel = new JPanel();
		Mail_panel.setBackground(Color.WHITE);
		contentPane.add(Mail_panel, "name_161265415816528");
		Mail_panel.setLayout(null);
		
	}
}
