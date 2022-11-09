package com.tms.usecases;

import java.util.Scanner;

public class AdminLogAndMethods {

    public static int net=0;

    public static void ShowAllChoices(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Please select your choice: ");
        System.out.println("Select 1 for login as Admin");
        System.out.println("Select 2 for login as Vendor");
        System.out.println("Select 3 to exit from the system");

        int option= scanner.nextInt();
        boolean flag= true;

        while(flag){

            if(option ==1){

                flag= true;

                while(flag){

                    System.out.println("You are inside Admin access portal..!");
                    System.out.println("Please enter your Username..");
                    String name= scanner.next();
                    System.out.println("Please enter your Password..");
                    String password= scanner.next();

                    if(name.equals("admin") && password.equals("admin000")){

                    }
                }
            }

        }

    }


}
