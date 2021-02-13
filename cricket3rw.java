package t5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class cricket3rw {

	

		public static void main(String[] args) {
			readAndWrite();
		}

		public static void readAndWrite() {
			List<criccountry> table = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader("cricdata.csv"))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] values = line.split(",");
			        table.add(new criccountry(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]),Integer.parseInt(values[4]),Integer.parseInt(values[5]),Double.parseDouble(values[6]),Integer.parseInt(values[7]),Integer.parseInt(values[8])));
			    }
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			

			OptionalInt min = table.stream().mapToInt(criccountry::getPoints).min();
		    if (min.isPresent()) {
		      System.out.printf("\nLowest number of points is %d\n", min.getAsInt());
		    } else {
		      System.out.println("min failed");
		    }

		    System.out.print("Number of matches won: ");
		    Integer result = table.stream().map(criccountry::getWon).reduce(0, (a, b) -> a + b);
		    System.out.println(result);
		    

		    List<String> s = table.stream()
		    	    .filter(p -> p.getWon() < 5)
		    	    .map(criccountry::getcname)
		    	    .collect(Collectors.toList());
		    	                   
		    	System.out.println("Team with less than 5 wins: " +
		    	    s.toString());
		    	
			    
	    	try {
			      FileWriter writer = new FileWriter("cric3R.txt");
			      writer.write("Lowest number of points is " + min.getAsInt() + "\n");
			      writer.write("Number of matches won: " + result + "\n");
			      writer.write("Team with less than 5 wins: " + s + "\n");
			      writer.close();
			      System.out.println("Created : " + writer +  " and updated it.");
			    } catch (IOException e) {
			      System.out.println("An exception occurred.");
			      e.printStackTrace();
			    }
		}
		
	}

