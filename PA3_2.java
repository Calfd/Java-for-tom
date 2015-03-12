/*
Programmer:Cal
Course: CS201.02, Dr.Olsen
Date: 3/13/15
Programming Assignment: 3
Problem Statement: Read in information from file and do claculations to learn about earthquakes. 
Data In: Time of earthquake, latitidue, longitude, dept, magnitude and place.
Data Out: Average of earthquakes, amount within specific radius, number of earthquakes in a certain state or country, largest depth of all of them, number of earthquakes.
Other classes need to compile this code: none
Credits: based on chapter 4.10
*/

import java.util.Scanner;//Import scanner class.
import java.io.*;//Needed for File and IOException.


public class PA3_2
{
   public static void main(String[] args)throws IOException
   {
   
   
   //create scanner and ask user for file name
   Scanner myscan = new Scanner(System.in);//Declare the scanner to read in the user's choice of file name.
   System.out.print("What is the name of the file? (add .csv at the end of it)");// Ask the user for the name of the file.
   File inputFile = new File(myscan.nextLine());//Input the file used throughout the program. 
   
   //if file doesnt exist end program
   if(!inputFile.exists())
      {
      System.out.print("The file does not exist.");
      System.exit(1);
      }
      
  
     //scanner for file input
   Scanner filescan = new Scanner(inputFile);
   
   //ask user for state or country
   Scanner userscan = new Scanner(System.in);
   System.out.print("Please choose a state or country to find more info about");
   String userCountry = userscan.next();
   
   //ask user for latitude, longitude and radius for specific location 
   Scanner userscan2 = new Scanner(System.in);
   System.out.print("Please input latitdue to find earthquakes within that location.");
   double userlatitude = userscan2.nextDouble();
   
   //ask user for longitude for specific location 
   Scanner userscan3 = new Scanner(System.in);
   System.out.print("Please input longitude to find earthquakes within that location.");
   double userlongitude = userscan3.nextDouble();
   
   //ask user for radius for specific location 
   Scanner userscan4 = new Scanner(System.in);
   System.out.print("Please input radius to find earthquakes within that location.");
   double userRadius = userscan4.nextDouble();
   
   //declare variables
   int counter = 0;
   String earthquakesinLocation;
   double depth = 0;
   int sum = 0;
   double MAX = 0;
   
   //convert lat and long from degrees to radians
    double userlatitudeRadians= Math.toRadians(userlatitude);
    double userlongitudeRadians=Math.toRadians(userlongitude);
    
   
    
    //make sure scanner reads in comma in file
    filescan.useDelimiter("[,\n\r]+"); //tells the Scanner to read until a space, newline, or comma
    
    //declare variables
    double latitude=0;
    double longitude=0;
    double magnitude=0;
    String time = " ";
    String place = " ";
    double depthIn=0;
   
    
    //create while loop
    while(filescan.hasNext())
    {
    
    //read in information from file
     time= filescan.next();
     System.out.println("1 " + time);
     latitude= filescan.nextDouble();
     System.out.println("2 " + latitude);
     longitude= filescan.nextDouble();
    
    
     depthIn= filescan.nextDouble();
   
    
     magnitude= filescan.nextDouble();
    
    
     place= filescan.next();
    
    
    counter ++;
    sum +=magnitude;
    
    }
    //calculate earthquakes in a state or country
    //String description = filescan.nextLine();
    String userCountryState = userscan.nextLine();
    boolean isItThere = place.contains(userCountryState);
     System.out.print("The number of earthquakes in " + userCountry + " is " + counter + ".");
     
    //calculate amount of earthquakes in certain radius
     double dist= Math.acos(Math.sin(latitude) * Math.sin(userlatitude) + Math.cos(latitude)* Math.cos(userlatitude) * Math.cos(longitude-userlongitude)) * 6371;
      System.out.print("The amount of earthquakes in " +userRadius + " is " + dist + ".");
      
    //calculate the largest depth
   // if(depthIn>depth)
//       depth +=depthIn;
   
   if(depthIn>MAX)
      MAX=depthIn;
     
     double average= sum/(double)counter;
     
     
      System.out.print("The average earthquake is " + average + ".");
    System.out.print("The largest depth of all earthquakes is " + MAX + ".");
    System.out.print("The number of earthquakes in total is " + counter + ".");

      
    
    
    //calculate average
    
    
    
    //output calculations 
      
      
   }
}