package t5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;



public class cricket3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				List<criccountry> table = Arrays.asList(
		        new criccountry(1, "Sri lanka", 10,7,1,1,7.9,2,9),
		        new criccountry(2, "Australia", 10,6,3,1,8.6,5,8),
		        new criccountry(3, "India", 10,7,0,3,7.3,6,8),
		        new criccountry(4, "England", 10,6,0,4,7.0,4,7),
		        new criccountry(5, "S. Africa", 10,5,1,4,6.5,1,6),
		        new criccountry(6, "Pakistan", 10,3,4,3,6.0,6,5));
	
	

			    OptionalInt min = table.stream().mapToInt(criccountry::getPoints).min();
			    if (min.isPresent()) {
			      System.out.printf("Lowest number of points is %d\n", min.getAsInt());
			    } else {
			      System.out.println("min failed");
			    }
	}


}
