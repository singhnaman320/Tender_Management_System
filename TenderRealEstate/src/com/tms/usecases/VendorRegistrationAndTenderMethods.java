package com.tms.usecases;

import com.tms.bean.Tender;
import com.tms.bean.Vendor;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.TenderException;
import com.tms.exceptions.VendorException;

import java.util.List;
import java.util.Scanner;

public class VendorRegistrationAndTenderMethods {

    public static void vendorRegistrationUseCase(){

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

    // [] Show all vendors []

    public static void showAllVendorsUseCase(){

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try{

            List<Vendor> vendors= dao.showAllVendors();
            vendors.forEach(v -> {

                System.out.println("Vendor Id is"+" "+ v.getvId());
                System.out.println("Vendor name is"+" "+ v.getvName());
                System.out.println("Vendor email is"+" "+v.getvEmail());
                System.out.println("Vendor password is"+" "+ v.getvPassword());
                System.out.println("Vendor mobile number is"+" "+ v.getVmobile());
                System.out.println("Vendor address is"+" "+ v.getVaddress());
            });

        } catch (VendorException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

    }

    // [] Add tenders []
    public static void addTendersUseCase(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter name of tender to be provided:");
        String tname= scanner.next();

        System.out.println("Enter tender deadline date:");
        String tdeadline= scanner.next();

        System.out.println("Enter tender tender amount: ");
        int tamount=scanner.nextInt();

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        String result= dao.addTenders(tname,tdeadline,tamount);

        System.out.println(result);

        scanner.close();

    }

    // [] Show all tenders []

    public static void showAllTendersUseCase(){

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try{

            List<Tender> tenders= dao.showAllTenders();
            tenders.forEach(t -> {

                System.out.println("Tender Id is"+" "+t.getTenderId());
                System.out.println("Tender name is"+" "+t.getCategory());
                System.out.println("Tender deadline is"+" "+ t.getDeadline());
                System.out.println("Tender amount is"+" "+t.getAmount());
            });

        } catch (TenderException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }


}
