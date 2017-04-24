import java.awt.EventQueue;




import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

//import com.sun.prism.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.image.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
public class AddRemoveUpdate_products {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_price;
	private JTextField textField_quantity;
	private JPanel panel_shipment; 
	private JPanel Seller_Registration; 

	private static String product_name; 
	private static double price; 
	private static String size; 
	private static String color; 
	private static int quantity; 
	private static byte [] picture; 
	String s; 
	private JComboBox selectDep; 
	
	JTextField seller_username;
	private byte[] productImg =null; 

	/**
	 * Launch the application.
	 */
	//call the java connection class
	Connection connection;
	
	//	lbl_image.setBackground(Color.BLUE);
		Connection conn;

	/*	// to fetch the data from product_info2 
		public void fetch(){
			try{
				String g = "select * from Product_Info2"; 
				
				//prepared statement for which the query will be passed to
				PreparedStatement  pst = connection.prepareStatement(g);
				pst = conn.prepareStatement(g); 
				ResultSet rs = pst.executeQuery(); 
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}
		}
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRemoveUpdate_products window = new AddRemoveUpdate_products(product_name, price, size, color, quantity, picture);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	int pos= 0; 
	
     String ImgPath= null;
	private String p_product_name;
	private double p_price;
	private String p_size;
	private String p_color;
	private int p_quantity; 
	/**
	 * Create the application.
	 * @param picture2 
	 * @param quantity2 
	 * @param color2 
	 * @param size2 
	 * @param price2 
	 * @param product_name2 
	 */
	public AddRemoveUpdate_products(String product_name2, double price2, String size2, String color2, int quantity2, byte[] picture2 ) {
		this.product_name= p_product_name;
		this.price= p_price; 
		this.size= p_size; 
		this.color= p_color; 
		this.quantity= p_quantity; 
		
		initialize();
		connection = sqliteConnection.dbConnector();

}

	
	public AddRemoveUpdate_products() {
		// TODO Auto-generated constructor stub
	}

	public String getproductName(){
		return product_name; 	
	}
	public double getPrice(){
		return price; 
	}
	public String getSize(){
		return size; 
	}
	public String getColor(){
		return color; 
	}
	public int getQuantity(){
		return quantity; 
	}
	public byte[] getPicture(){
		return picture; 
	}

	
	// resize image 
	private JLabel lbl_image; 
	private JTextField textField_path;
	private JTextField textField_description;
	private JTextField Seller_C;
	private JTable table;
	protected PreparedStatement pst;
	private JTextField product_id;
	private JTextField textField_currentSName;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_seller_username;
	private JPasswordField Seller_password;
	private JTextField email2;
	private JTextField country2;
	private JTextField state2;
	private JTextField city2;
	private JTextField address2;
	private JTextField lastname2;
	private JTextField firstname2;
	private JPasswordField password2;
	private JTextField username2;
	private JTable table_3;
	private JTextField textField_id;
	// this method is not resizing, but helping to display the pic once user upload the image. :) 
	public ImageIcon ResizeImage(String imagePath, byte [] pic){
		ImageIcon myImage; 
		
		if(imagePath!=null){
			myImage = new ImageIcon(imagePath); 
		}
		else{
			myImage = new ImageIcon(pic); 
		}
	     java.awt.Image img =myImage.getImage(); 
      //  java.awt.Image img2= img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(), java.awt.Image.SCALE_SMOOTH); 
     //    Image img2= img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(), Image.SCALE_SMOOTH); 

	  ImageIcon image= new ImageIcon(img); 
		return image;  
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		connection= sqliteConnection.dbConnector();
		frame = new JFrame();
		frame.setBounds(80, 80, 2210, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panel_main = new JPanel();
		panel_main.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_main, "name_303424841876689");
		panel_main.setLayout(null);
		panel_main.setVisible(false);

		final JPanel panel_shipment = new JPanel();
		panel_shipment.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_shipment, "name_25500738434883");
		panel_shipment.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(22, 50, 429, 825);
		panel_shipment.add(panel_2);
		
		JPanel Regis2_Confirm = new JPanel();
		Regis2_Confirm.setLayout(null);
		Regis2_Confirm.setBackground(Color.WHITE);
		frame.getContentPane().add(Regis2_Confirm, "name_32018738051280");
		
		JLabel label_2 = new JLabel("Make Shipment");
		label_2.setFont(new Font("Dialog", Font.BOLD, 26));
		label_2.setBounds(121, 24, 211, 40);
		panel_2.add(label_2);
		
		JButton button = new JButton("New Orders");
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOrder();

			}

			private void viewOrder() {
			String CurrentSeller= textField_seller_username.getText(); 
			try{

			String g = "select rowid, firstname, lastname,email, address, city, zip, state , country , Seller, Product_Name,Department, Price, Units from Shipment_Info where Seller= '"+CurrentSeller+"'"; 
			//prepared statement for which the query will be passed to
			PreparedStatement pst = connection.prepareStatement(g);
			pst = connection.prepareStatement(g); 
			ResultSet rs = pst.executeQuery(); 

			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			table_2.setRowHeight(110);
		    table_2.getColumnModel().getColumn(5).setPreferredWidth(150);
		    table_2.setFont(new Font("",1,20));
		    table_2.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));

			}
			catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);

			} 
			}

			});
		button.setBounds(22, 155, 387, 64);
		panel_2.add(button);
		
		JButton btnConfirmShipment = new JButton("Shipped");
		btnConfirmShipment.setFont(new Font("Dialog", Font.BOLD, 20));
		btnConfirmShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rowid= textField_id.getText(); 
				try{

				String g = "select rowid, firstname, lastname,email, address, city, zip, state , country , Seller, Product_Name,Department, Price, Units from Shipment_Info where rowid= '"+rowid+"'"; 
				//prepared statement for which the query will be passed to
				PreparedStatement pst = connection.prepareStatement(g);
				pst = connection.prepareStatement(g); 
				ResultSet rs = pst.executeQuery(); 

				table_3.setModel(DbUtils.resultSetToTableModel(rs));
				table_3.setRowHeight(110);
			    table_3.getColumnModel().getColumn(5).setPreferredWidth(150);
			    table_3.setFont(new Font("",1,20));
			    table_3.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));

				}
				catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1);

				} 
				}

				});
				 

			
		btnConfirmShipment.setBounds(22, 514, 387, 64);
		panel_2.add(btnConfirmShipment);
		
		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setFont(new Font("Dialog", Font.BOLD, 21));
		lblEnterId.setBounds(22, 341, 111, 40);
		panel_2.add(lblEnterId);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("Dialog", Font.BOLD, 21));
		textField_id.setBounds(178, 324, 231, 69);
		panel_2.add(textField_id);
		textField_id.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Confirmed");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String rowid= textField_id.getText(); 

					String sql= "delete from Shipment_Info where rowid = '"+rowid+"'";
					pst =connection.prepareStatement(sql); 
					pst.execute(); 

					JOptionPane.showMessageDialog(null, "Confirmed");

					}

					catch(Exception e1){
					e1.printStackTrace(); }
					}
					});

		
		btnNewButton_2.setBounds(22, 635, 387, 64);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		lblNewLabel_2.setBounds(473, 50, 102, 97);
		panel_shipment.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\banner.jpg"));
		lblNewLabel_3.setBounds(1103, 50, 646, 97);
		panel_shipment.add(lblNewLabel_3);
		
		JButton button_4 = new JButton("< Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_main.setVisible(true);
				panel_shipment.setVisible(false);
				
			}
		});
		button_4.setBounds(22, 11, 122, 29);
		panel_shipment.add(button_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(473, 210, 1687, 281);
		panel_shipment.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			// add code here to view on click 
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblNewOrders = new JLabel("New Orders");
		lblNewOrders.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewOrders.setBounds(473, 145, 179, 41);
		panel_shipment.add(lblNewOrders);
		
		JLabel lblConfirmed = new JLabel("Shipped");
		lblConfirmed.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblConfirmed.setBounds(473, 507, 221, 41);
		panel_shipment.add(lblConfirmed);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(473, 559, 1687, 316);
		panel_shipment.add(scrollPane_2);
		
		table_3 = new JTable();
		scrollPane_2.setViewportView(table_3);
		table_3.addMouseListener(new MouseAdapter() {
			
			//// add code here to view on click  confirmed 
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_shipment.setVisible(false);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 11, 372, 842);
		panel_main.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name ");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblProductName.setBounds(16, 178, 119, 27);
		panel_1.add(lblProductName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPrice.setBounds(16, 217, 119, 27);
		panel_1.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblQuantity.setBounds(16, 268, 119, 27);
		panel_1.add(lblQuantity);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblImage.setBounds(147, 296, 108, 27);
		panel_1.add(lblImage);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_name.setBounds(137, 174, 197, 31);
		panel_1.add(textField_name);
		textField_name.setColumns(10);
		
		textField_price = new JTextField();
		textField_price.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_price.setColumns(10);
		textField_price.setBounds(137, 213, 197, 31);
		panel_1.add(textField_price);
		
		textField_quantity = new JTextField();
		textField_quantity.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_quantity.setColumns(10);
		textField_quantity.setBounds(137, 267, 197, 31);
		panel_1.add(textField_quantity);
		
		JLabel lbl_image = new JLabel("");
		lbl_image.setForeground(UIManager.getColor("Button.select"));
		lbl_image.setBackground(Color.WHITE);
		lbl_image.setBounds(16, 324, 344, 214);
		panel_1.add(lbl_image);
		
		JButton btn_Choose_Image = new JButton("Choose Image");
		btn_Choose_Image.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser chooser = new JFileChooser(); 
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
				    String imageName= f.getAbsolutePath(); 
				    textField_path.setText(imageName);	
                    lbl_image.setIcon(ResizeImage(imageName,null));		
                    
                    displayImage(f); 
				
			}

			private void displayImage(File f) {
				try{
					@SuppressWarnings("resource")
					FileInputStream fis= new FileInputStream(f);
					ByteArrayOutputStream bAOS= new ByteArrayOutputStream(); 
					byte [] buf = new byte [1024]; 
					
					for (int readNum; (readNum= fis.read(buf))!=-1;){
						bAOS.write(buf,0 , readNum); 
					}
					productImg= bAOS.toByteArray();
					
				}
				catch(Exception e1){
					
				}				
			}
			
			}
		
			);
		btn_Choose_Image.setBounds(163, 550, 197, 29);
		panel_1.add(btn_Choose_Image);
		
		textField_path = new JTextField();
		textField_path.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_path.setBounds(27, 550, 127, 26);
		panel_1.add(textField_path);
		textField_path.setColumns(10);
		
		JComboBox selectDep = new JComboBox();
		selectDep.setModel(new DefaultComboBoxModel(new String[] {"Departments", "Men", "Women", "Kids", "Electronics", "Books", "Home and Garden"}));
		selectDep.setBounds(137, 128, 197, 27);
		panel_1.add(selectDep);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDescription.setBounds(27, 601, 119, 31);
		panel_1.add(lblDescription);
		
		textField_description = new JTextField();
		textField_description.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_description.setBounds(147, 601, 211, 31);
		panel_1.add(textField_description);
		textField_description.setColumns(10);
		
		JLabel lblUserName = new JLabel("Seller Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblUserName.setBounds(16, 90, 119, 27);
		panel_1.add(lblUserName);
		
		Seller_C = new JTextField();
		Seller_C.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Seller_C.setColumns(10);
		Seller_C.setBounds(137, 88, 197, 31);
		panel_1.add(Seller_C);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(388, 210, 188, 63);
		panel_main.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			try{
				if(textField_name.getText().equals("") ||textField_price.getText().equals("")|| textField_quantity.getText().equals("") || selectDep.getSelectedItem().equals("")){
			           JOptionPane.showMessageDialog(null, "One or more fields are missing"); 
				}
				else{
                    sellerExist(); 
	
			}}
			catch(Exception e1){
			e1.printStackTrace(); 	
				
			}
			}

			private void sellerExist() {
				  String CurrentSeller= textField_currentSName.getText(); 

	                try{
	                	String query= "select username2 from Seller_Info where username2= '"+textField_currentSName.getText()+"'"; 
	                	pst= connection.prepareStatement(query); 
	                	ResultSet rs = pst.executeQuery(); 
	                    if(CurrentSeller.equals(rs.getString("username2"))){
	          
	        				//create query with database
	        		        pst = (PreparedStatement)connection.prepareStatement("insert into Product_Info2(Seller,Product_Name,Department,Price,Units,Image) values (?,?,?,?,?,?)");
	        				
	        				//making a prepared statement
	        		        
	        	     		pst.setString(1, Seller_C.getText()); 
	        				pst.setString(2, textField_name.getText()); 
	        				pst.setString(3, (String) selectDep.getSelectedItem()); 
	        				pst.setString(4, textField_price.getText()); 
	        				pst.setString(5, textField_quantity.getText()); 

	        				pst.setBytes(6, productImg);			  
	        				//pst.setString(7, textField_description.getText()); 
	        	
	        				pst.execute(); 
	        	   
	        	           JOptionPane.showMessageDialog(null, "Product added"); 
	        	   
	        		pst.close(); 
	        			
	        			}}
	        			catch(Exception e1){
	        			e1.printStackTrace(); 	
	        				
	        			}
	        			}

	        		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(); 

			}
			private void update() {
				try{
                    String value0= product_id.getText(); 
                	String value=  Seller_C.getText(); 
					String value1=  textField_name.getText(); 
					String value2=   (String) selectDep.getSelectedItem(); 
					String value3=   textField_price.getText(); 
					String value4=   textField_quantity.getText(); 
    			    byte[] value5= 	productImg; 
    			    		
    			    //		pst.setBytes(5, productImg);
					
    				String sql= "update Product_Info2 set Seller= '" +value+ "', Product_Name= '" +value1+ "', Department= '" +value2+ "' , Price='" +value3+ "', Units='" +value4+ "', Image='" +value5+ "' where ProductID= '" +value0+ "'"; 
			
    			//	define class for connection 
					Class.forName("org.sqlite.JDBC");
					// Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT/DMDdata.sqlite");	
    				
					PreparedStatement  pst6 = connection.prepareStatement(sql);
    				pst6.executeUpdate(); 
    	            
    				JOptionPane.showMessageDialog(null, "Product Updated");
				
    				pst6.execute(); 

				}
				
				catch(Exception e){
					e.printStackTrace();				}
			}
		});
		btnUpdate.setBounds(388, 564, 188, 64);
		panel_main.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
                    String value0= product_id.getText(); 
                
			         String sql= "delete from Product_Info2 where ProductID = '"+value0+"'";
    			     pst =connection.prepareStatement(sql); 
    			     pst.execute(); 
    			     
    			     JOptionPane.showMessageDialog(null, "Product Deleted");

				}
				
				catch(Exception e1){
					e1.printStackTrace();				}
			}
		});
		btnDelete.setBounds(388, 686, 188, 59);
		panel_main.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnMyProducts = new JButton("My Products");
		btnMyProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewProduct();
				
			}

			private void viewProduct() {
				  String CurrentSeller= textField_currentSName.getText(); 
				  
					try{

						String g = "select * from Product_Info2 where Seller= '"+textField_currentSName.getText()+"'"; 
						
						//prepared statement for which the query will be passed to
						PreparedStatement  pst = connection.prepareStatement(g);
						pst = connection.prepareStatement(g); 
						ResultSet rs = pst.executeQuery(); 
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						    table.setRowHeight(130);
						    table.getColumnModel().getColumn(5).setPreferredWidth(150);
						    table.setFont(new Font("",1,20));
						    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
						
					}
					catch(Exception e1){
					 	JOptionPane.showMessageDialog(null, e1);

					}				
			}
		
		});
		
		btnMyProducts.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnMyProducts.setBounds(388, 297, 186, 64);
		panel_main.add(btnMyProducts);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\bin\\images\\propiccici.jpg"));
		lblNewLabel.setBounds(388, 11, 163, 151);
		panel_main.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hello!");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(621, 59, 100, 48);
		panel_main.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\bin\\images\\btnlogo.jpg"));
		label.setBounds(1231, 11, 126, 99);
		panel_main.add(label);
		
		JLabel label_1 = new JLabel("Welcome to Your Seller Portal");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 31));
		label_1.setBounds(1036, 116, 477, 48);
		panel_main.add(label_1);
		
		JButton btnNewButton_1 = new JButton("logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);	
			}
		});
		btnNewButton_1.setBounds(2043, 11, 117, 36);
		panel_main.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(588, 210, 1572, 643);
		panel_main.add(scrollPane);
		
		
		JLabel lblUpdateProduct = new JLabel("Update or Delete ");
		lblUpdateProduct.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUpdateProduct.setBounds(404, 372, 172, 40);
		panel_main.add(lblUpdateProduct);
		
		product_id = new JTextField();
		product_id.setFont(new Font("Tahoma", Font.BOLD, 25));
		product_id.setText("  Enter ID");
		product_id.setBounds(388, 504, 188, 36);
		panel_main.add(product_id);
		product_id.setColumns(10);
		
	    textField_currentSName = new JTextField();
	    textField_currentSName.setFont(new Font("Tahoma", Font.BOLD, 28));
	    textField_currentSName.setBackground(Color.PINK);
	   	    
	    
		textField_currentSName.setBounds(588, 124, 163, 38);
		panel_main.add(textField_currentSName);
		textField_currentSName.setColumns(10);
	
		
		JLabel lblByProductId = new JLabel("By Product ID");
		lblByProductId.setFont(new Font("Dialog", Font.BOLD, 18));
		lblByProductId.setBounds(414, 411, 126, 40);
		panel_main.add(lblByProductId);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Shipment");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel_shipment.setVisible(true);
				panel_main.setVisible(false);	
		//		System.out.println(panel_ship);
               				
			}
		});
		btnNewButton.setBounds(388, 794, 188, 59);
		panel_main.add(btnNewButton);
		
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setBackground(Color.WHITE);
		frame.getContentPane().add(login, "name_30365863574318");
		login.setVisible(true);
		
		final JPanel Seller_Registration = new JPanel();
		Seller_Registration.setLayout(null);
		Seller_Registration.setBackground(Color.WHITE);
		frame.getContentPane().add(Seller_Registration, "name_31844831675860");
		
		JLabel label_3 = new JLabel("Seller Portal Login");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(1019, 188, 153, 29);
		login.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_4.setBounds(1041, 74, 110, 100);
		login.add(label_4);
		
		JLabel label_5 = new JLabel("Username:");
		label_5.setFont(new Font("Dialog", Font.BOLD, 22));
		label_5.setBounds(1029, 263, 124, 29);
		login.add(label_5);
		
		textField_seller_username = new JTextField();
		textField_seller_username.setFont(new Font("Dialog", Font.BOLD, 22));
		textField_seller_username.setColumns(10);
		textField_seller_username.setBounds(864, 302, 463, 47);
		login.add(textField_seller_username);
		
		JLabel label_6 = new JLabel("Password:");
		label_6.setFont(new Font("Dialog", Font.BOLD, 22));
		label_6.setBounds(1029, 355, 124, 29);
		login.add(label_6);
		
		Seller_password = new JPasswordField();
		Seller_password.setFont(new Font("Dialog", Font.BOLD, 22));
		Seller_password.setBounds(864, 396, 463, 56);
		login.add(Seller_password);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try{
					//create a query with the database 
					String query2 = "select * from Seller_Info where username2=? and password2=?";
					
					//prepared statement for which the query will be passed to
					PreparedStatement  pst2 = connection.prepareStatement(query2);
					
					//pass value from text box that the user will enter to the prepared statement
					pst2.setString(1, textField_seller_username.getText() );
					pst2.setString(2, Seller_password.getText() );
					
					//this result set execute the query 
					ResultSet rs2  = pst2.executeQuery();
					
					//loop that return value one by one 
					int count2 = 0;
					while (rs2.next()){
						count2 = count2+1;
						
					}if (count2 == 1){
						
						JOptionPane.showMessageDialog(null, "Login Successful!");
						login.setVisible(false);
						panel_main.setVisible(true);
						textField_currentSName.setText(textField_seller_username.getText());


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
		LoginBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		LoginBtn.setBackground(new Color(102, 102, 153));
		LoginBtn.setBounds(864, 476, 463, 56);
		login.add(LoginBtn);
		
		JLabel label_7 = new JLabel("Forgot your password?");
		label_7.setBounds(1011, 543, 253, 28);
		login.add(label_7);
		
		JButton button_6 = new JButton("Register");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_Registration.setVisible(true);
				login.setVisible(false);	
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_6.setBackground(new Color(102, 102, 153));
		button_6.setBounds(864, 595, 463, 56);
		login.add(button_6);
		
		JButton button_7 = new JButton("<<back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);	
			// 	frame.setVisible(false);

			}
		});
		button_7.setBounds(0, 0, 89, 23);
		login.add(button_7);	
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_8.setBounds(493, 22, 100, 89);
		Seller_Registration.add(label_8);
		
		JButton button_8 = new JButton("<<Back");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_Registration.setVisible(false);
				login.setVisible(true);
			}
		});
		button_8.setBounds(0, 0, 93, 29);
		Seller_Registration.add(button_8);
		
		JLabel label_9 = new JLabel("New Seller? Please complete the form below");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(453, 111, 274, 29);
		Seller_Registration.add(label_9);
		
		JLabel label_10 = new JLabel("Username:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_10.setBounds(228, 150, 123, 21);
		Seller_Registration.add(label_10);
		
		JLabel label_11 = new JLabel("Password:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_11.setBounds(228, 182, 123, 21);
		Seller_Registration.add(label_11);
		
		JLabel label_12 = new JLabel("First Name:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_12.setBounds(228, 221, 123, 21);
		Seller_Registration.add(label_12);
		
		JLabel label_13 = new JLabel("Last Name:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_13.setBounds(228, 253, 123, 21);
		Seller_Registration.add(label_13);
		
		JLabel label_14 = new JLabel("Address:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_14.setBounds(228, 285, 123, 21);
		Seller_Registration.add(label_14);
		
		JLabel label_15 = new JLabel("City:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(228, 336, 123, 21);
		Seller_Registration.add(label_15);
		
		JLabel label_16 = new JLabel("State/Province:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_16.setBounds(228, 368, 123, 21);
		Seller_Registration.add(label_16);
		
		JLabel label_17 = new JLabel("Country:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_17.setBounds(228, 400, 123, 21);
		Seller_Registration.add(label_17);
		
		JLabel label_18 = new JLabel("Email:");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_18.setBounds(228, 432, 123, 21);
		Seller_Registration.add(label_18);
		
		JCheckBox checkBox = new JCheckBox("I have read and agree to the terms and conditions specified in this agreement");
		checkBox.setForeground(Color.RED);
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox.setBounds(343, 457, 470, 23);
		Seller_Registration.add(checkBox);
		
		JButton button_9 = new JButton("Submit");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement statement=null;
				try{
					//define class for connection 
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\DMDdata.sqlite");			//JOptionPane.showMessageDialog(null, "Successfully Connected to DMD database!");	
					
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
		
		
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_19.setBounds(464, 11, 107, 113);
		Regis2_Confirm.add(label_19);
		
		JLabel label_20 = new JLabel("Congratulations Registration Completed");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_20.setBounds(280, 135, 409, 30);
		Regis2_Confirm.add(label_20);
		
		JLabel label_21 = new JLabel("Successfully!");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_21.setBounds(450, 176, 140, 38);
		Regis2_Confirm.add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\confirm.jpg"));
		label_22.setBounds(421, 225, 249, 231);
		Regis2_Confirm.add(label_22);
		
		JButton button_10 = new JButton("LOGIN");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				Regis2_Confirm.setVisible(false);
			}
		});
		button_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_10.setBounds(391, 467, 257, 46);
		Regis2_Confirm.add(button_10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				  int index = table.getSelectedRow();
			
				try{
	                DefaultTableModel model= (DefaultTableModel) table.getModel(); 
					int SelectedRowIndex= table.getSelectedRow();
					Seller_C.setText(model.getValueAt(SelectedRowIndex, 1).toString());
					selectDep.setToolTipText(model.getValueAt(SelectedRowIndex, 2).toString());
					textField_name.setText(model.getValueAt(SelectedRowIndex, 3).toString());
					textField_price.setText(model.getValueAt(SelectedRowIndex, 4).toString());
					textField_quantity.setText(model.getValueAt(SelectedRowIndex, 5).toString());
                //    lbl_image.setIcon((Icon) ResizeImage(ImgPath, productImg).getImage());
					
					//prepared statement for which the query will be passed to
			
					}
					catch(Exception e2){
						e2.printStackTrace();				

					}
			}
		});}
	
	   
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}