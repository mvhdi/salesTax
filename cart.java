import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// takes in text file path and returns an array of item objects
public class cart{
	// var
	public ArrayList<item> itemArrayList = new ArrayList<item>();

	// consturctor
	public cart(String filepath){	
    	// create item objects from input and add them to the itemArrayList
    	addToItemArrayList(filepath);

	}

	// methods
	public void addToItemArrayList(String filepath){
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

	public void createAndAddItem(String line){
		// first turn string into parser object
		parser parsedLine = new parser(line);
		// if it can be parsed create a item object from it and add it to the itemArrayList
		if(parsedLine.getIsValid()){
			itemArrayList.add(new item(parsedLine.getQuantity(), parsedLine.getIsImported(), parsedLine.getCategory(), parsedLine.getPrice()));
		}
	}

	// getter
	

}