import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//@SuppressWarnings("serial")
public class JTableWithImage extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	
	/**
	 * Launch the application.
	 * @return 
	 */
	
	
	 
	
	public static void main(String[] args) {
		
		
		populateJTable();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableWithImage frame = new JTableWithImage();
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
	public JTableWithImage() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1225, 596);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 49, 935, 390);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

public static void populateJTable(){
	try {
    MyQuery mq = new MyQuery();
    ArrayList<Product2> list = mq.BindTable();
    String[] columnName = {"ProductID","Seller","Product_Name","Department","Price","Image","Units"};
    Object[][] rows = new Object[list.size()][7];
    for(int i = 0; i < list.size(); i++){
        rows[i][0] = list.get(i).getProductID();
        rows[i][1] = list.get(i).getSeller();
        rows[i][2] = list.get(i).getProduct_Name();
        rows[i][3] = list.get(i).getDepartment();
        rows[i][4] = list.get(i).getPrice();
        rows[i][5] = list.get(i).getUnits();
        
        if(list.get(i).getImage() != null){
            
         ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
         .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
            
        rows[i][6] = image;
        }
        else{
            rows[i][6] = null;
        }
        rows[i][6] = list.get(i).getImage();
    }
    
    TheModel model = new TheModel(rows, columnName);
    
    
    table.setModel(model);
    table.setRowHeight(120);
    table.getColumnModel().getColumn(6).setPreferredWidth(150);
    
    
	} catch (Exception e) {
		e.printStackTrace();
	}	
	
	

};
  
}


