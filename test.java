public class test{
	public static void main(String[] args){
		
		System.out.println("----------------------");
		// test the item class
		System.out.println("test the getters in item class");
		item item1 = new item(2, true, "book", 2.4);
		System.out.println(item1.getQuantity());
		System.out.println(item1.getCategory());
		System.out.println(item1.getIsImported());
		System.out.println(item1.getPrice());
		System.out.println(item1.getTotal());
		System.out.println("----------------------");
		System.out.println("test the setters in item class");
		item1.setQuantity(4);
		item1.setIsImported(false);
		item1.setCategory("music CD");
		item1.setPrice(3.2);
		item1.setTotal( item1.returnTotal(3.2*4, false, "music CD") );

		System.out.println(item1.getQuantity());
		System.out.println(item1.getIsImported());
		System.out.println(item1.getPrice());
		System.out.println(item1.getTotal());

		System.out.println("----------------------");

		System.out.println("test the getters in the parser class");
		parser parse1 = new parser("1 book at 12.49");
		System.out.println(parse1.getOriginalInput());
		System.out.println(parse1.getIsValid());
		System.out.println(parse1.getPrice());
		System.out.println(parse1.getQuantity());
		System.out.println(parse1.getCategory());
		System.out.println(parse1.getIsImported());

		System.out.println("----------------------");

		System.out.println("test out the cart class");
		cart cart1 = new cart("input/input1.txt");
		System.out.println(cart1.itemArrayList.get(2).getCategory());
	}
}