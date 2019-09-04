public class item{
	// vars
	public int quantity;
	public boolean isImported;
	public String category;
	public double price; 
	public double total;
	// constructor
	public item(int quan, boolean is, String cat, double pri){
		quantity = quan;
		isImported = is;
		category= cat;
		price = pri; 
		total = returnTotal(pri*quan, is, cat);
	}
	// methods
	public double returnTotal(double subTotal, boolean is, String cat){
		double total = subTotal;
		double tax = 0.0;
		if(is){
			tax+= subTotal*.05;
		}
		// hardcode in things that are not food, books, and medical products based on given inputs
		if(cat == "music CD" || cat == "bottle of perfume" || cat == "headache pills" ){
			tax+= subTotal*.1;
		}
		return tax + subTotal;
	}

	// // test
	// public static void main(String[] args){
	// 	item item1 = new item(2, true, "book", 2.4);
	// 	System.out.println(item1.total);
	// } 
}
