package t5;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class criccountry  implements Comparable<criccountry>
{
	private int position;
	private String cname;
	private int played;
	private int won;
	private int drawn;
	private int lost;
	private double runrate;
	private int wcupswon;
	private int points;
	
	public criccountry(int position, String cname, int played, int won,int drawn, int lost,double runrate,int wcupswon, int points)
	{
		this.position=position;
		this.cname=cname;
		this.played=played;
		this.won=won;
		this.drawn=drawn;
		this.lost=lost;
		this.runrate=runrate;
		this.wcupswon=wcupswon;
		this.points=points;
		
		
	}
	
	public criccountry() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		
		return String.format(cname, cname,played,won, lost, runrate, wcupswon, points);
	}
	
	 public int getPosition() 
	 {
		    return position;
		  }
	 
	

	  public void setPosition(int position) 
	  {
	    this.position = position;
	  }

	  
	  	public String getcname() 
	  	{
		    return cname;
		  }

		  public void setClub(String club) 
		  {
		    this.cname = club;
		  }
		  
		  public int getPlayed() 
		  {
			    return played;
			  }

		  public void setPlayed(int played)
		  {
			    this.played = played;
		 }

		  public int getWon() {
			    return won;
			  }

			  public void setWon(int won) {
			    this.won = won;
			  }
			  

			  public int getDrawn() {
			    return drawn;
			  }

			  public void setDrawn(int drawn) {
			    this.drawn = drawn;
			  }

			  public int getLost() {
			    return lost;
			  }

			  public void setLost(int lost) {
			    this.lost = lost;
			  }
			  public int getPoints() {
				    return points;
				  }

				  public void setPoints(int points) { 
				    this.points = points;
				  }
				  
				  public int getwcupswon() {
					    return wcupswon;
					  }

					  public void setwcupswon(int wcupswon) {
					    this.wcupswon = wcupswon;
					  }
					  
					  public int getrunrate() {
						    return points;
						  }

						  public void getrunrate(int runrate) {
						    this.runrate = runrate;
						  }
						  
						  public int compareTo(criccountry cc) {
							    return ((Integer)cc.getwcupswon()).compareTo(cc.getwcupswon());
							  }
		
			
			public List<criccountry> readcricinfocsv(String filename){
				List<criccountry> table = new ArrayList<>();
				Path pathtofile=Paths.get(filename);
				
				try(BufferedReader br= Files.newBufferedReader(pathtofile,StandardCharsets.US_ASCII)){
					String line= br.readLine();
					
					while(line!=null) {
						String[] attributes = line.split("	");
						criccountry cc= createrec(attributes);
						table.add(cc);
						line=br.readLine();
					}
				}

			         catch (IOException ioe) 
			        {
			            ioe.printStackTrace();
			        }
				return table;
				
			}
				
			public static criccountry createrec(String[] metadata) {
				
				int Position= Integer.parseInt(metadata[0]);
				String cname=metadata[1];
				int played= Integer.parseInt(metadata[2]);
				int won= Integer.parseInt(metadata[3]);
				int drawn= Integer.parseInt(metadata[4]);
				int lost= Integer.parseInt(metadata[5]);
				double runrate= Double.parseDouble(metadata[6]);
				int wcupswon= Integer.parseInt(metadata[7]);
				int points= Integer.parseInt(metadata[8]);
				
				
				return new criccountry(Position,cname, played, won, drawn, lost, runrate, wcupswon, points);
				
				
			}
		  
}
