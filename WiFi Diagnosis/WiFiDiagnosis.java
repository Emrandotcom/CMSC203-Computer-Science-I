/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek 
 * Description: Build an application that will step through some possible problems to restore internet connectivity.  
 *              Assume that your computer uses wi-fi to connect to a router which connects to an Internet Service Provider (ISP) which connects to the Internet.
 * Due: 06/15/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emran Abbamacha
*/

import java.util.Scanner;
public class WiFiDiagnosis{

     public static void main(String []args){
        System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
        Scanner keyboard = new Scanner(System.in);
        																																		// Step 1
        System.out.println("First step: reboot your computer");                                                                                 
        System.out.println("Are you able to connect with the internet? (yes or no)");
        String userInput = keyboard.nextLine();
        
        if(userInput.equals("yes"))
            System.out.println("Rebooting your computer seemed to work");
        else{ 																																	// Step 2
            System.out.println("Second step: reboot your router");                                                                                  
            System.out.println("Now are you able to connect with the internet? (yes or no)");
            userInput = keyboard.nextLine();
        
            if(userInput.equals("yes"))
                System.out.println("Rebooting your router seemed to work");
            else { 																																// Step 3
                System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");       
                System.out.println("Are you able to connect with the internet? (yes or no)");
                userInput = keyboard.nextLine();
                if(userInput.equals("yes"))
                    System.out.println("Checking the router's cables seemed to work");
                else { 																															// Step 4
                    System.out.println("Fourth step: move your computer closer to your router");                                                      
                    System.out.println("Are you able to connect with the internet? (yes or no)");
                    userInput = keyboard.nextLine();
                    if(userInput.equals("yes"))
                        System.out.println("Moving your computer closer to your router seemed to work");
                    else if(userInput.equals("no")){																							// Step 5
                        System.out.println("Fifth step: contact your ISP");
                        System.out.println("Make sure your ISP is hooked up to your router.");
                    }
                }
            }
        }
        System.out.println("Made by Emran Abbamacha");
     }
     
}