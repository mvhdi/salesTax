import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.ArrayList;
public class recepit{
	// vars


	private double itemTotal;
	private double taxtotal;
	private double total;
	private String output;


	// constructor
	public recepit(ArrayList<item> itemArrayList){
		
		// iterate through arrayList of items and build output string
		for (int i = 0; i < itemArrayList.size(); i++) {
			// System.out.println(itemArrayList.get(i).getIsImported());
			
			this.total += itemArrayList.get(i).getTotal();
			// System.out.println(itemArrayList.get(i).getTotal());
		}
		System.out.println(roundPrice(this.total));


	}

	//methods

	public  double roundPrice(double amount) {

		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

	public static void main(String[] args){
		cart cart1 = new cart("input/input2.txt");
		recepit recepit1 = new recepit(cart1.itemArrayList);


	}
}