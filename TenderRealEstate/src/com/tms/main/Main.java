package com.tms.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        System.out.println("Please type [Admin] to enter into Admin portal");
        System.out.println("Please type [Vendor] to enter into Vendor Portal");
        System.out.println("Please type [Exit] to exit out from Tender Management System");

        String option = scanner.next();

        if(option.equals("Admin")){

            AdminAndVendorAllFunctions.loggedInByAdmin();

        } else if (option.equals("Vendor")) {

            AdminAndVendorAllFunctions.loggedInByVendor();

        }else{

            System.out.println("Exiting from the system. Please wait...!"+"\n");
            System.out.println("Thank you for choosing us.!"+"\n");
            System.out.println("Please provide your valuable feedback below.");

            String feedback = scanner.nextLine();
            System.out.println("Feedback saved. Thank you !");

        }
    }
}
