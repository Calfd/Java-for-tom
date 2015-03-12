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


public class PA3(2)
{
   public static void main(String[] args)throws IOException
   {
   
   
   //create scanner and ask user for file name
   Scanner myscan = new Scanner(System.in);//Declare the scanner to read in the user's choice of file name.
   System.out.print("What is the name of the file? (add .txt at the end of it)");// Ask the user for the name of the file.
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
   int MAX = 0;
   
   //convert lat and long from degrees to radians
    double userlatitudeRadians= Math.toRadians(userlatitude);
    double userlongitudeRadians=Math.toRadians(userlongitude);
    
    //make sure scanner reads in comma in file
    filescan.useDelimiter("[,\n\r]+"); //tells the Scanner to read until a space, newline, or comma
    
    //create while loop
    while(filescan.hasNext())
    {
    
    //read in information from file
    String time= filescan.next();
    double latitude= filescan.nextDouble();
    double longitude= filescan.nextDouble();
    double depthIn= filescan.nextDouble();
    double magnitude= filescan.nextDouble();
    String place= filescan.next();
    counter ++;
    
    //calculate earthquakes in a state or country
    String description = filescan.nextLine();
    String userCountryState = userscan.nextLine();
    boolean isItThere = description.contains(userCountryState);
    
    //calculate amount of earthquakes in certain radius
     double dist= Math.arccos(Math.sin(latitude) * Math.sin(userlatitude) + Math.cos(latitude)* Math.cos(userlatitude) * Math.cos(longitude-userlongitude)) * 6371;
     
    //calculate the largest depth
   if(depthIn>depth)
      depth +=depthIn;
   
   if(depthIn>MAX)
      MAX+=depthIn;
      
    }
    
    //calculate average
    double average= sum/(double)counter;
    
    
    //output calculations 
    System.out.print("The average earthquake is " + average + ".");
    System.out.print("The amount of earthquakes in " +userRadius + " is " + dist + ".");
    System.out.print("The number of earthquakes in " + userCountry + " is " + isItThere + ".");
    System.out.print("The largest depth of all earthquakes is " + MAX + ".");
    System.out.print("The number of earthquakes in total is " + counter + ".");
   
      
   }
}