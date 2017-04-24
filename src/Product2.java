
public class Product2 {

	private int ProductID;
    private String Seller;
    private String Product_Name;
    private String Department;
    private double Price;
    private int Units;
    
    private byte[] Image;
    
    public Product2(){}
    
    public Product2(int ProductID, String Seller, String Product_Name, String Department, double Price, int Units, byte[] image ){
    
    	this.ProductID = ProductID;
    	this.Seller = Seller;
        this.Product_Name = Product_Name;
        this.Department = Department;
        this.Units = Units;
        this.Price = Price;
        this.Image = image;
        
       
    }
    
    public int getProductID(){
        return ProductID;
    }
    
    public void setProductID(int ProductID){
        this.ProductID = ProductID;
    }
    
    public String getSeller(){
        return Seller;
    }
    
    public void setQte(String Seller){
        this.Seller = Seller;
    }
    
    public String getProduct_Name(){
        return Product_Name;
    }
    
    public void setProduct_Name(String Product_Name){
        this.Product_Name = Product_Name;
    }
    
    public String getDepartment(){
        return Department;
    }
    
    public void setDepartment(String Department){
        this.Department = Department;
    }
    
    public double getPrice(){
        return Price;
    }
    
    public void setPrice(double Price){
        this.Price = Price;
    }
    
    public int getUnits(){
        return Units;
    }
    
    public void setUnits(int Units){
        this.Units = Units;
    }
    
    public byte[] getImage(){
        return Image;
    }
}