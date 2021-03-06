package t5;

import java.util.Arrays;
import java.util.List;


public class cricket4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<criccountry> table = Arrays.asList(
		        new criccountry(1, "Sri lanka", 10,7,1,1,7.9,2,9),
		        new criccountry(2, "Australia", 10,6,3,1,8.6,5,8),
		        new criccountry(3, "India", 10,7,0,3,7.3,6,8),
		        new criccountry(4, "England", 10,6,0,4,7.0,4,7),
		        new criccountry(5, "S. Africa", 10,5,1,4,6.5,1,6),
		        new criccountry(6, "Pakistan", 10,3,4,3,6.0,6,5));
	
		System.out.println("Several clubs have 8 points");
	    table.stream().filter(criccountry -> criccountry.getPoints() == 8)
	        .forEach(System.out::println);

	    System.out.println();
	    System.out.println("Clubs with less than 6 points");
	    table.stream().filter(criccountry -> criccountry.getPoints() <= 6)
	        .forEach(System.out::println);
	

	}
}
