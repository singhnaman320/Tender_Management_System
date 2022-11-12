package com.tms.usecases;

import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;

import java.util.Scanner;

public class VendorRegistrationUseCase {
    public static void vendorRegistration(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Please enter vendor name: || ");
        String name= scanner.next();

        System.out.println("Please enter vendor email: || ");
        String email= scanner.next();

        System.out.println("Please enter vendor password: || ");
        String password= scanner.next();

        System.out.println("Please enter vendor mobile number: || ");
        int mobile= scanner.nextInt();

        System.out.println("Please enter vendor address: || ");
        String address= scanner.next();

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        String result= dao.VendorRegistration(name, email, password, mobile, address);

        System.out.println(result);

        scanner.close();
    }
}
