import java.awt.Image;
import java.util.ArrayList;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;

public class HomePage extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField Search_item;
	private JTable table;
	private JTextField cart_Sum;
	private JTable table_1;
	private JTextField item_amount;
	private JTable table_2;
	private JTextField check_out_sum;
	private JTextField firstname;
	private JTextField txtLastname;
	private JTextField txtEmail;
	private JTextField txtEmail_1;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtZip;
	private JTextField txtState;
	private JTextField txtCountry;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField amount_paid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**jst 
	 * Create the frame.
	 */
	
	public void ShowInfo() {

		try{
		    String query="SELECT firstname1 From Customer_info Where firstname1=?";
		    PreparedStatement ps=connection.prepareStatement(query);
		    ps.setString(1, "firstName");
		    ResultSet rs= ps.executeQuery();
		    if(rs.next()) {
		    cart_Sum.setText(rs.getString(1));
		    //System.out.print(""+textField_1); //you are getting data
		    }ps.close();
		    connection.close();
		    } catch ( Exception ex)
		    {
		        JOptionPane.showMessageDialog(null,ex); //you have a error
		}
		}
	
	
	public HomePage() {
		
		
		
		connection = sqliteConnection.dbConnector();
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 2210, 1200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "name_372352548514078");
		panel.setLayout(null);
		
		JPanel cart_panel = new JPanel();
		cart_panel.setForeground(Color.WHITE);
		cart_panel.setBackground(Color.WHITE);
		contentPane.add(cart_panel, "name_396865181751468");
		cart_panel.setLayout(null);
		
		final JPanel Order_Form = new JPanel();
		Order_Form.setBackground(Color.WHITE);
		contentPane.add(Order_Form, "name_14227399049070");
		Order_Form.setLayout(null);
		

		final JPanel payment_confirmation = new JPanel();
		payment_confirmation.setBackground(Color.WHITE);
		contentPane.add(payment_confirmation, "name_45657688901312");
		payment_confirmation.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2153, 41);
		panel.add(menuBar);
		
		JMenu Departments = new JMenu("Departments");
		Departments.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		menuBar.add(Departments);
		
		JMenuItem Women = new JMenuItem("Women");
		Departments.add(Women);
		
		JSeparator separator_2 = new JSeparator();
		Departments.add(separator_2);
		
		JMenuItem Men = new JMenuItem("Men");
		Departments.add(Men);
		
		JSeparator separator_1 = new JSeparator();
		Departments.add(separator_1);
		
		JMenuItem Kids = new JMenuItem("Kids");
		Departments.add(Kids);
		
		JSeparator separator = new JSeparator();
		Departments.add(separator);
		
		JMenuItem Electronics = new JMenuItem("Electronis");
		Departments.add(Electronics);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Orders");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Accounts");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Specials");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Contact Us");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Most Viewed Products");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		menuBar.add(mntmNewMenuItem_4);
		
		//method that allow user to search for a particular item
		Search_item = new JTextField();
		Search_item.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					
					
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		Search_item.setText("search here");
		menuBar.add(Search_item);
		Search_item.setColumns(10);
		
		JButton Search = new JButton("Search");
		Search.setFont(new Font("Tahoma", Font.BOLD, 25));
		Search.setBackground(new Color(153, 51, 0));
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		Search.setForeground(new Color(0, 0, 0));
		menuBar.add(Search);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				panel.setVisible(false);
				Main_Menu mainmenu = new Main_Menu();
				mainmenu.setVisible(true);
				
				//close();
			
				
				
				
			}
		});
		menuBar.add(btnLogout);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 44, 96, 100);
		label.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(569, 47, 1035, 122);
		label_1.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\banner2.jpg"));
		panel.add(label_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				cart_panel.setVisible(true);
				 table_1.setFont(new Font("",1,20));
				    table_1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 25));
				    table_1.setRowHeight(80);
			}
		});
		btnNewButton.setBounds(2038, 39, 115, 105);
		btnNewButton.setBackground(Color.WHITE);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\CARTICOO.png"));
		
		JLabel lblMyCart = new JLabel("My Cart ");
		lblMyCart.setBounds(2038, 146, 115, 23);
		lblMyCart.setFont(new Font("Dialog", Font.BOLD, 26));
		panel.add(lblMyCart);
		
		
		JButton VIEWPRODUCTS = new JButton("VEIW PRODUCTS");
		VIEWPRODUCTS.setFont(new Font("Dialog", Font.BOLD, 26));
		VIEWPRODUCTS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					MyQuery mq = new MyQuery();
					    ArrayList<Product2> list = mq.BindTable();
					    String[] columnName = {"SELLER","PRODUCT NAME","DEPARTMENT","PRICE","UNITS IN STOCK","IMAGE"};
					    Object[][] rows = new Object[list.size()][100];
					    for(int i = 0; i < list.size(); i++){
					        //rows[i][0] = list.get(i).getProductID();
					        rows[i][0] = list.get(i).getSeller();
					        rows[i][1] = list.get(i).getProduct_Name();
					        rows[i][2] = list.get(i).getDepartment();
					        rows[i][3] = list.get(i).getPrice();
					        rows[i][4] = list.get(i).getUnits();
					        
					        if(list.get(i).getImage() != null){
					            
					         ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
					         .getScaledInstance(180, 180, Image.SCALE_SMOOTH) );   
					            
					        rows[i][5] = image;
					        }
					        else{
					            rows[i][5] = null;
					        }
					      
					    }
					    
					    TheModel model = new TheModel(rows, columnName);
					    table.setModel(model);
					    table.setRowHeight(180);
					    table.getColumnModel().getColumn(5).setPreferredWidth(150);
					    table.setFont(new Font("",1,20));
					    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 28));
						
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
				
				
			
			}});
		VIEWPRODUCTS.setBounds(1032, 176, 273, 54);
		panel.add(VIEWPRODUCTS);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		scrollPane.setBounds(10, 262, 2130, 616);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton transfer_rows = new JButton("");
		transfer_rows.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\add to cart2.jpg"));
		transfer_rows.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				 try{
			
					    TableModel model1 = table.getModel();

				        int[] indexs = table.getSelectedRows();

				        Object[] row = new Object[100];

				        DefaultTableModel model2 = (DefaultTableModel) table_1.getModel();

				        for(int i = 0; i < indexs.length; i++)
				        {
				            row[0] = model1.getValueAt(indexs[i], 0);

				            row[1] = model1.getValueAt(indexs[i], 1);

				            row[2] = model1.getValueAt(indexs[i], 2);

				            row[3] = model1.getValueAt(indexs[i], 3);
				            
				           row[4] = model1.getValueAt(indexs [i], 4);
				       	
				          
				            model2.addRow(row);
				            
				            
					 
					 JOptionPane.showMessageDialog(null, "Add this item to cart");
					 item_amount.setText(Integer.toString(sum_of_items()));
					 cart_Sum.setText(Double.toString(getSum()));
					
			
				        }		        	
				 } catch (Exception e1) {
						e1.printStackTrace();
					}	
			
		}});
		transfer_rows.setBounds(1080, 899, 163, 41);
		panel.add(transfer_rows);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\paymenicon1.jpg"));
		lblNewLabel_5.setBounds(899, 961, 523, 69);
		panel.add(lblNewLabel_5);
		
		item_amount = new JTextField();
		item_amount.setFont(new Font("Tahoma", Font.BOLD, 26));
		item_amount.setBounds(2079, 173, 43, 35);
		panel.add(item_amount);
		item_amount.setColumns(10);
		
		
		
		JButton btnNewButton_1 = new JButton("Remove From cart");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   DefaultTableModel model = (DefaultTableModel) table_1.getModel();

			       // get selected row index

			       try{
			       int SelectedRowIndex = table_1.getSelectedRow();
			       model.removeRow(SelectedRowIndex);
			       
			       cart_Sum.setText(Double.toString(getSum()));
			         sum_of_items();  
			         item_amount.setText(Integer.toString(sum_of_items()));
			       }catch(Exception ex)
			       {
			           JOptionPane.showMessageDialog(null, "Cart is already Empty");
			        
			          
			       }
			    }                                  
			
		});
		btnNewButton_1.setBounds(1868, 573, 274, 68);
		cart_panel.add(btnNewButton_1);
		
		JButton btnUpdateCart = new JButton("Update Cart");
		btnUpdateCart.setFont(new Font("Dialog", Font.BOLD, 26));
		btnUpdateCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
				
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				
				int selectedRowIndex = table_1.getSelectedRow();
				
				String Units = model.getValueAt(selectedRowIndex, 4).toString();
				
				String newUnits = JOptionPane.showInputDialog(null, "Enter Amout you wish to Order", Units);
				
				model.setValueAt(newUnits, selectedRowIndex, 4);
				
				 cart_Sum.setText(Double.toString(getSum()));
		           item_amount.setText(Integer.toString(sum_of_items()));
				
				 } catch (Exception ex) {
					 JOptionPane.showMessageDialog(null, "Select an Item to Update! if cart is not empty");
					}	
				
				
			}
		});
		btnUpdateCart.setBounds(1868, 662, 274, 62);
		cart_panel.add(btnUpdateCart);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\runningcart.png"));
		lblNewLabel.setBounds(1868, 262, 285, 269);
		cart_panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("My Shopping Cart");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_1.setBounds(966, 207, 241, 40);
		cart_panel.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
					 
					   TableModel model1 = table_1.getModel();
					   
					   table_1.selectAll();
					   
					   int[] indexs = table_1.getSelectedRows();
					   
					   Object[] row = new Object[5];

				        DefaultTableModel model2 = (DefaultTableModel) table_2.getModel();

				        for(int i = 0; i < indexs.length; i++)
				        {
				            row[0] = model1.getValueAt(indexs[i], 0);

				            row[1] = model1.getValueAt(indexs[i], 1);

				            row[2] = model1.getValueAt(indexs[i], 2);

				            row[3] = model1.getValueAt(indexs[i], 3);

				            row[4] = model1.getValueAt(indexs[i], 4);
				            model2.addRow(row);
				            table_2.setFont(new Font("",1,18));
						    table_2.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 25));
						    table_2.setRowHeight(50);
						    
				        }
				       
					 item_amount.setText(Integer.toString(sum_of_items()));
					 check_out_sum.setText(Double.toString(getSum()));
			
				        
				        cart_panel.setVisible(false);
						 Order_Form.setVisible(true);
				        
				 } catch (Exception e1) {
						e1.printStackTrace();
					}	
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\checkme out.png"));
		btnNewButton_2.setBounds(1916, 745, 193, 40);
		cart_panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		lblNewLabel_2.setBounds(1029, 114, 115, 95);
		cart_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total: $");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(961, 901, 105, 26);
		cart_panel.add(lblNewLabel_3);
		
		cart_Sum = new JTextField();
		cart_Sum.setFont(new Font("Tahoma", Font.BOLD, 23));
		cart_Sum.setBounds(1069, 902, 105, 26);
		cart_panel.add(cart_Sum);
		cart_Sum.setColumns(10);
		
		JButton button = new JButton("<<back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart_panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		button.setBounds(0, 0, 115, 30);
		cart_panel.add(button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 262, 1826, 538);
		cart_panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Seller", "Product_Name", "Department", "Price", "Units"
			}
		));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\banner2.jpg"));
		label_2.setBounds(598, 4, 977, 107);
		cart_panel.add(label_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sum_of_items();
				 cart_Sum.setText(Double.toString(getSum()));
		           item_amount.setText(Integer.toString(sum_of_items()));
				
				cart_panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\Continue Shopping Button.png"));
		btnNewButton_3.setBounds(1859, 0, 250, 50);
		cart_panel.add(btnNewButton_3);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\paymenicon1.jpg"));
		label_7.setBounds(825, 821, 523, 69);
		cart_panel.add(label_7);
		
		
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\checkout banner1.jpg"));
		label_3.setBounds(430, 11, 1313, 115);
		Order_Form.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_4.setBounds(10, 34, 127, 92);
		Order_Form.add(label_4);
		
		JButton btnNewButton_4 = new JButton("Order Details:");
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		btnNewButton_4.setBounds(20, 137, 2133, 57);
		Order_Form.add(btnNewButton_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(21, 215, 2132, 163);
		Order_Form.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Seller", "Product_Name", "Department", "Price", "Units"
			}
		));
		table_2.setBackground(SystemColor.control);
		
		JLabel lblNewLabel_7 = new JLabel("TOTALS: $");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(989, 486, 96, 28);
		Order_Form.add(lblNewLabel_7);
		
		check_out_sum = new JTextField();
		check_out_sum.setFont(new Font("Tahoma", Font.BOLD, 18));
		check_out_sum.setBounds(1081, 488, 105, 23);
		Order_Form.add(check_out_sum);
		check_out_sum.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("<<back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged(); // notifies the JTable that the model has changed
				
				Order_Form.setVisible(false);
				cart_panel.setVisible(true);
				
			}
		});
		btnNewButton_5.setBounds(10, 11, 113, 23);
		Order_Form.add(btnNewButton_5);
		
		JLabel lblBillingInformation = new JLabel("Billing Information:");
		lblBillingInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBillingInformation.setBounds(644, 548, 207, 28);
		Order_Form.add(lblBillingInformation);
		
		JLabel lblFirstName = new JLabel("First Name *");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFirstName.setBounds(644, 617, 145, 22);
		Order_Form.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name *");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(644, 689, 142, 20);
		Order_Form.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(644, 748, 142, 20);
		Order_Form.add(lblEmail);
		
		JLabel lblConfirmEmail = new JLabel("Confirm email*");
		lblConfirmEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmEmail.setBounds(644, 818, 160, 21);
		Order_Form.add(lblConfirmEmail);
		
		firstname = new JTextField();
		firstname.setBounds(644, 643, 184, 28);
		Order_Form.add(firstname);
		firstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(644, 715, 184, 28);
		Order_Form.add(txtLastname);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(644, 769, 184, 28);
		Order_Form.add(txtEmail);
		
		txtEmail_1 = new JTextField();
		txtEmail_1.setColumns(10);
		txtEmail_1.setBounds(644, 841, 184, 28);
		Order_Form.add(txtEmail_1);
		
		JLabel lblAddress = new JLabel("Address*");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(941, 616, 106, 24);
		Order_Form.add(lblAddress);
		
		JLabel lblCity = new JLabel("City*");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCity.setBounds(941, 680, 106, 24);
		Order_Form.add(lblCity);
		
		JLabel lblZipOrPostal = new JLabel("Zip or postal code*");
		lblZipOrPostal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblZipOrPostal.setBounds(941, 744, 204, 21);
		Order_Form.add(lblZipOrPostal);
		
		JLabel lblStateOrProvince = new JLabel("State or province*");
		lblStateOrProvince.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStateOrProvince.setBounds(941, 805, 217, 26);
		Order_Form.add(lblStateOrProvince);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(941, 644, 288, 28);
		Order_Form.add(txtAddress);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(941, 707, 288, 28);
		Order_Form.add(txtCity);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		txtZip.setBounds(941, 771, 288, 28);
		Order_Form.add(txtZip);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(941, 835, 288, 27);
		Order_Form.add(txtState);
		
		JLabel lblPaymentOptions = new JLabel("Payment Options:");
		lblPaymentOptions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPaymentOptions.setBounds(1323, 552, 196, 28);
		Order_Form.add(lblPaymentOptions);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCountry.setBounds(941, 869, 106, 24);
		Order_Form.add(lblCountry);
		
		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(941, 901, 288, 28);
		Order_Form.add(txtCountry);
		
		JLabel lblCardNumber = new JLabel("Card Number*");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCardNumber.setBounds(1322, 621, 186, 22);
		Order_Form.add(lblCardNumber);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(1321, 646, 372, 28);
		Order_Form.add(textField_10);
		
		JLabel lblCardExpirationDate = new JLabel("Card expiration date*");
		lblCardExpirationDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCardExpirationDate.setBounds(1326, 689, 229, 26);
		Order_Form.add(lblCardExpirationDate);
		
		JComboBox Selec_Month = new JComboBox();
		Selec_Month.setModel(new DefaultComboBoxModel(new String[] {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		Selec_Month.setBounds(1326, 724, 74, 24);
		Order_Form.add(Selec_Month);
		
		JComboBox Select_year = new JComboBox();
		Select_year.setModel(new DefaultComboBoxModel(new String[] {"Year", "2017", "2018","2019","2020","2021","2022","2023"}));
		Select_year.setBounds(1410, 724, 60, 24);
		Order_Form.add(Select_year);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(1572, 719, 124, 23);
		Order_Form.add(textField_11);
		
		JLabel lblCvvcvc = new JLabel("CVV2/CVC2");
		lblCvvcvc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCvvcvc.setBounds(1574, 688, 138, 22);
		Order_Form.add(lblCvvcvc);
		
		JLabel lblCardHolderName = new JLabel("Card holder Name*");
		lblCardHolderName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCardHolderName.setBounds(1326, 767, 350, 24);
		Order_Form.add(lblCardHolderName);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(1326, 803, 373, 28);
		Order_Form.add(textField_12);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PreparedStatement statement=null;
				try{
					int rows =table_2.getRowCount();
					
					//define class for connection 
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\DMDdata.sqlite\\");
									
					//store customer registration info to database table
					statement = (PreparedStatement) connection.prepareStatement("insert into Shipment_Info(firstname,lastname,email,address,city,zip,state,country,Seller,Product_Name,Department,Price,Units) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					if (firstname.getText().equals(""))
                        JOptionPane.showMessageDialog(firstname,
                                    "Please provide firstname");
                  else if(txtLastname.getText().equals(""))
                        JOptionPane.showMessageDialog(txtLastname,
                                    "Please provide a Lastname");
                  else if(txtEmail.getText().equals(""))
                      JOptionPane.showMessageDialog(txtEmail,
                                  "Please provide email");
                  else if(txtAddress.getText().equals(""))
                      JOptionPane.showMessageDialog(txtAddress,
                                  "Please provide Address");
                  
                  else if(txtCity.getText().equals(""))
                      JOptionPane.showMessageDialog(txtCity,
                                  "Please provide city");
                  else if(txtZip.getText().equals(""))
                      JOptionPane.showMessageDialog(txtZip,
                                  "Please provide zip or postal code");
                
                  else if(txtState.getText().equals(""))
                      JOptionPane.showMessageDialog(txtState,
                                  "Please provide State");
					
                  else if(txtCountry.getText().equals(""))
                      JOptionPane.showMessageDialog(txtCountry,
                                  "Please provide Country");
                 
                 
                  else{
					statement.setString(1, firstname.getText() );
					statement.setString(2, txtLastname.getText());
					statement.setString(3, txtEmail.getText());
					statement.setString(4, txtAddress.getText());
					statement.setString(5, txtCity.getText());
					statement.setString(6, txtZip.getText());
					statement.setString(7, txtState.getText());
					statement.setString(8, txtCountry.getText());
					
					for(int row = 0; row<rows; row++)
					{
					    String Seller = (String)table_2.getValueAt(row, 0);
					    String Product_Name = (String)table_2.getValueAt(row, 1);
					    String Department = (String)table_2.getValueAt(row, 2);
					    double Price = (double)table_2.getValueAt(row, 3);
					    int Units = (int)table_2.getValueAt(row, 4);
					
					//from cart table  
					statement.setString(9, Seller);
					statement.setString(10, Product_Name);
					statement.setString(11, Department);
					statement.setDouble(12, Price);
					statement.setInt(13, Units);
					//statement.addBatch();
					}
					statement.execute();
					
					
					Order_Form.setVisible(false);
					 payment_confirmation.setVisible(true);
					amount_paid.setText(Double.toString(getSum()));	
					
                  }
					connection.close();
				}catch(Exception ex){
					ex.printStackTrace();
				
				}
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\paynow.jpg"));
		btnNewButton_6.setBounds(1326, 838, 203, 51);
		Order_Form.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Please fill out the missing fields to complete your order");
		btnNewButton_7.setForeground(new Color(255, 0, 0));
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_7.setBackground(SystemColor.inactiveCaption);
		btnNewButton_7.setBounds(21, 387, 2132, 63);
		Order_Form.add(btnNewButton_7);
		
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\banner2.jpg"));
		label_5.setBounds(605, 14, 964, 122);
		payment_confirmation.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\btnlogo.jpg"));
		label_6.setBounds(10, 11, 125, 125);
		payment_confirmation.add(label_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\src\\images\\confirm.jpg"));
		lblNewLabel_8.setBounds(956, 162, 261, 256);
		payment_confirmation.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Payment Successful ! ");
		lblNewLabel_9.setForeground(new Color(34, 139, 34));
		lblNewLabel_9.setBackground(new Color(34, 139, 34));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_9.setBounds(923, 408, 328, 45);
		payment_confirmation.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Your payment has been processed. Here are the details of this transaction for your reference-");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(760, 463, 654, 32);
		payment_confirmation.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Invoice Number: #INV:00005457888123");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11.setBounds(902, 507, 370, 23);
		payment_confirmation.add(lblNewLabel_11);
		
		JLabel lblAmountPaid = new JLabel("Amount Paid: $");
		lblAmountPaid.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAmountPaid.setBounds(954, 544, 138, 33);
		payment_confirmation.add(lblAmountPaid);
		
		amount_paid = new JTextField();
		amount_paid.setFont(new Font("Tahoma", Font.BOLD, 17));
		amount_paid.setBounds(1093, 545, 125, 32);
		payment_confirmation.add(amount_paid);
		amount_paid.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Return to Store");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				PreparedStatement statement2=null;
				try{
				//define class for connection 
				Class.forName("org.sqlite.JDBC");
				Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\DMDdata.sqlite\\");
				statement2 = (PreparedStatement) connection.prepareStatement("insert into total_sales(Purchaces) values (?)");
				
				statement2.setString(1, amount_paid.getText() );
				statement2.execute();
				
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged(); // notifies the JTable that the model has changed
			
				
				Clear_Shopping_Cart();
				
				payment_confirmation.setVisible(false);
				panel.setVisible(true);
				 
				       
				       cart_Sum.setText(Double.toString(getSum()));
				         sum_of_items();  
				         item_amount.setText(Integer.toString(sum_of_items()));
				      connection.close();

				}catch(Exception ex){
					ex.printStackTrace();
				
				}
				         
			
			}
		});
		btnNewButton_8.setForeground(SystemColor.controlLtHighlight);
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_8.setBackground(new Color(0, 128, 0));
		btnNewButton_8.setBounds(941, 590, 291, 45);
		payment_confirmation.add(btnNewButton_8);
		
	}
	
		//function that get the total cost of all item added in the cart
		    public double getSum(){ 
		    	
		        double price = 0;
		        double quantity= 0;
		        double total_price = 0.00;
		        
		        for(int i = 0; i < table_1.getRowCount(); i++)
		        {
		            price =  Double.parseDouble(table_1.getValueAt(i, 3).toString());
		            quantity =  Double.parseDouble(table_1.getValueAt(i, 4).toString());
		           
		            total_price += price * quantity;
		            total_price = Math.round(total_price * 100);
		            total_price = total_price/100;
		            
		        
		        }   
		        return total_price;
		      
		    }
		    
		    
		    //function that gets the total amount of items in the cart
		    public int sum_of_items(){
		    	
			     	int rows = table_1.getRowCount();
			     	//System.out.println(rows);
			     	return rows;
			      
		    }
		  
			public void Clear_Shopping_Cart(){
				 DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged(); // notifies the JTable that the model has changed
				
				
			}
			//method to close window
			public void close(){
				WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
						
					}
			
}

