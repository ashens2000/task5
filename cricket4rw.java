package t5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cricket4rw {
	
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
			
			System.out.println("\nSeveral teams have 8 points");
		    table.stream().filter(team -> team.getPoints() == 8)
		        .forEach(System.out::println);

		    System.out.println();
		    System.out.println("Teams with 16 points");
		    table.stream().filter(team -> team.getPoints() == 16)
		        .forEach(System.out::println);
		    
		    try {
			      FileWriter writer = new FileWriter("cric4R.txt");
			      writer.write("Several teams have 8 points\n");
			      table.stream().filter(team -> team.getPoints() == 8)
			        .forEach(str -> {
			        	try {
							writer.write(str.toString() + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
			        });
			      
			      writer.write("\nTeams with 16 points\n");
			      table.stream().filter(team -> team.getPoints() == 16)
			        .forEach(str -> {
			        	try {
							writer.write(str.toString() + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
			        });
			      writer.close();
			      System.out.println("Created : " + writer +  " and updated it.");
			    } catch (IOException e) {
			      System.out.println("An exception occurred.");
			      e.printStackTrace();
			    }
		}
		
	}
	

