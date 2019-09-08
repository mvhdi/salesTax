import java.math.RoundingMode;
import java.math.BigDecimal;

public class item{
	// vars
	private int quantity;
	private boolean isImported;
	private String category;
	private double price; 
	private double total;
	// constructor
	public item(int quan, boolean is, String cat, double pri){
		this.quantity = quan;
		this.isImported = is;
		this.category = cat;
		this.price = pri; 
		this.total = returnTotal(pri*quan, is, cat);
	}

	// getters
		public int getQuantity(){return this.quantity; }
		public boolean getIsImported(){return this.isImported; }
		public String getCategory(){return this.category; }
		public double getPrice(){return this.price; }
		public double getTotal(){return this.total; }


	// setters
		public void setQuantity(int newQuantity){this.quantity = newQuantity; }
		public void setIsImported(boolean newIsImported){this.isImported = newIsImported; }
		public void setCategory(String newCategory){this.category = newCategory; }
		public void setPrice(double newPrice){this.price = newPrice; }
		public void setTotal(double newTotal){this.total = newTotal; }


	// calcuates the cost + tax
	public double returnTotal(double subTotal, boolean is, String cat){
		double total = subTotal;
		double tax = 0.0;
		if(is){
		
			tax+= subTotal*.05;
		}
		// System.out.println(cat);
		// hardcode in things that are not food, books, and medical products based on given inputs
		if(cat.contains("music")  || cat.contains("perfume")  ){

			tax+= subTotal*.1;
		}
		tax =  nearest5Percent(tax);
		return tax + subTotal;
	}

	public double nearest5Percent(double amount) {

		return new BigDecimal(Math.ceil(amount * 20)/20).setScale(2,RoundingMode.HALF_UP).doubleValue();

	}


}
