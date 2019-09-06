import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parser{
	// var
	private String REGEX_PATTERN = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";
	private String originalInput;
	private boolean isValid;
	private int quantity;
	private boolean isImported;
	private String category;
	private double price;

	// constructor
	public parser(String input){
		this.originalInput = input;
		parseAndSet(input);

	}

	// methods
	private void parseAndSet(String input){
		// check if input matches regex pattern and set isValid
		this.isValid = parseIsValid(input); 
		if(isValid){
				this.quantity = parseQuantity(input);
				this.isImported = parseIsImported(input);
				this.category = parseCategory(input);
				this.price = parsePrice(input);
		}
		else{
			// default values
				this.quantity = 0;
				this.isImported = false;
				this.category = "default";
				this.price = 0.0;
		}
	}

	// parse methods
	public Matcher extractValue(String input){
		Pattern patternObject = Pattern.compile(REGEX_PATTERN);
		Matcher matcherObject = patternObject.matcher(input);
		matcherObject.find();
		return matcherObject;
	}

	public boolean parseIsValid(String input){
		return Pattern.matches(REGEX_PATTERN, input);
	}

	public int parseQuantity(String input){
		String quantityString = extractValue(input).group(1).trim();
		return Integer.valueOf(quantityString);	
	}

	public boolean parseIsImported(String input){
		String isImportedString = extractValue(input).group(2).trim();
		if(isImportedString.contains("imported")){
			return true;
		}
		else{
			return false;
		}
	}

	public String parseCategory(String input){
		String categoryString = extractValue(input).group(2).trim();
		if(categoryString.contains("imported")){
			categoryString =  extractValue(input).group(3).trim();
		}
		return categoryString;
	}

	public double parsePrice(String input){
		String priceString = extractValue(input).group(4).trim();
		return Double.valueOf(priceString);	
	}

	// getters
	public String getOriginalInput(){return this.originalInput; }
	public boolean getIsValid(){return this.isValid; }
	public int getQuantity(){return this.quantity; }
	public boolean getIsImported(){return this.isImported; }
	public String getCategory(){return this.category; }
	public double getPrice(){return this.price; }
	
}