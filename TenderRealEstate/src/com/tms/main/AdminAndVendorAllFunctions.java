package com.tms.main;

import com.tms.bean.Vendor;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.VendorException;
import com.tms.usecases.VendorRegistrationAndTenderMethods;

import java.util.Scanner;

public class AdminAndVendorAllFunctions {

    public static void loggedInByAdmin(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("[] ********* Welcome to Tender Management System ********* []"+"\n");

        System.out.println("Please enter your Username ");
        String name = scanner.next();
        System.out.println("Please enter your Password");
        String password = scanner.next();

        if (name.equals("admin") && password.equals("admin@123")) {

            System.out.println("LoggedIn successfully"+"\n");
            System.out.println("Entering into admin portal...Please wait.!"+"\n");

            System.out.println("Please choose one of the given options:");

            System.out.println("1 : For Registering Vendor");
            System.out.println("2 : For Sowing all the vendors registered");
            System.out.println("3 : For Adding new tenders");
            System.out.println("4 : For Showing all the tenders");
            System.out.println("5 : For Viewing all the bids for tenders");
            System.out.println("6 : For Assigning tender to a vendor");

            int option= scanner.nextInt();

            System.out.println("Enter");
            switch (option){

                case 1:
                    VendorRegistrationAndTenderMethods.vendorRegistrationUseCase();
                    break;

                case 2 :
                    VendorRegistrationAndTenderMethods.showAllVendorsUseCase();
                    break;

                case 3:
                    VendorRegistrationAndTenderMethods.addTendersUseCase();
                    break;

                case 4:
                    VendorRegistrationAndTenderMethods.showAllTendersUseCase();
                    break;

                case 5:
                    VendorRegistrationAndTenderMethods.ViewTenderBidUseCase();
                    break;

                case 6:
                    VendorRegistrationAndTenderMethods.assignTenderToVendors();
                    break;

                default:
                    System.out.println("Invalid choice..! Please enter a correct choice.");
                    break;
            }

        } else {

            System.out.println("Admin entered wrong credentials. Please try again..!");
        }
        scanner.close();
    }


    public static void loggedInByVendor(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Please enter your username provided by Admin");
        String vendorName= scanner.next();

        System.out.println("Please enter your password provided by admin");
        String vendorPass= scanner.next();

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try {
            Vendor vendor= dao.signInVendor(vendorName, vendorPass);
            System.out.println("LoggedIn successfully.!"+"\n");
            System.out.println("Entering inside vendors portal. Please wait..!");

        } catch (VendorException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

        System.out.println("Please choose one of the given options");
        System.out.println("1 : For Showing all the tenders");
        System.out.println("2 : For adding bit to a tender");
        System.out.println("3 : Showing bid according to present status");
        System.out.println("4 : Getting own tender history");

        int choice= scanner.nextInt();

        switch (choice){

            case 1:
                VendorRegistrationAndTenderMethods.showAllTendersUseCase();
                break;

            case 2:
                VendorRegistrationAndTenderMethods.addBidForAllTendersUseCase();
                break;

            case 3:
                VendorRegistrationAndTenderMethods.showBidAccordingToStatusUseCase();
                break;

            case 4:
                VendorRegistrationAndTenderMethods.TenderHistoryUseCase();
                break;

            default:
                System.out.println("Invalid choice..! Please enter a correct choice.");
                break;

        }
    }

}
