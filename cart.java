import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// takes in text file path and returns an array of item objects
public class cart{
	// var
	//initlizae an ArrayList
	//public item[] itemArray = new item[10];
	public ArrayList<item> itemArrayList = new ArrayList<item>();
	// consturctor
	public cart(String filepath){	
    	// create item objects from input and add them to the itemArrayList
    	addToItemArrayList(filepath);

	}

	// methods

	// loops throught the text file line by
	// for each line uses regex to create an item object
	// adds item objects to itemArray
	public void addToItemArrayList(String filepath){
		item item1 = new item(2, true, "book", 2.4);
		itemArrayList.add(item1);

		// loop through text file line by line
		try {
			Scanner scanner = new Scanner(new File(filepath));
			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				createAndAddItem(temp);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}





	}
	// call helper function to do regex and create a new item object.
	// append to item
	public void createAndAddItem(String line){
		System.out.println(line);
		// itemArrayList.add(new item(2, true, temp, 2.4));
	}

	//main
	public static void main(String[] args){
		
		// System.out.println(item1.total);
		cart cart1 = new cart("input/input1.txt");
		System.out.println(cart1.itemArrayList.get(0).category);
	}
}