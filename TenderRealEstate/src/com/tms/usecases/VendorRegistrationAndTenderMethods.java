package com.tms.usecases;

import com.tms.bean.Tender;
import com.tms.bean.TenderStatus;
import com.tms.bean.TenderBid;
import com.tms.bean.Vendor;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.BidException;
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


    // SignIn Vendor

//    public  static void signInVendorUseCase(){
//
//        Scanner scanner= new Scanner(System.in);
//
//        System.out.println("Please enter valid username to login: ||");
//        String username= scanner.next();
//
//        System.out.println("Please enter valid password to login: ||");
//        String password= scanner.next();
//
//        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();
//
//        try {
//            Vendor vendor= dao.signInVendor(username, password);
//            System.out.println("Welcome to vendors portal");
//
//        } catch (VendorException e) {
//            //throw new RuntimeException(e);
//            System.out.println(e.getMessage());
//        }
//
//    }

    // Add bid for tenders

    public static void addBidForAllTendersUseCase(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Please enter bid Id:");
        int bid= scanner.nextInt();

        System.out.println("Please enter tender Id for which bit is to be given:");
        int btid= scanner.nextInt();

        System.out.println("Please enter bid amount");
        int bamount=scanner.nextInt();

        System.out.println("Please enter bid status(Active/Expired):");
        String status= scanner.next();

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        //String result= null;
        try {
            String result = dao.addBidForAllTenders(bid, btid, bamount, status);
            System.out.println(result);

        } catch (TenderException e) {
            System.out.println(e.getMessage());
        }
    }

    // Tender Bid Status

    public static void TenderBidStatusUseCase(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter the Vendor Id");
        int vendorId =sc.nextInt();

        System.out.println("Please enter the Tender Id");
        int  tenderId= sc.nextInt();

        VendorAndTenderDao dao = new VendorAndTenderDaoImpl();

        try {
            List<TenderStatus>  fullStatus =  dao.TenderBidStatus(tenderId, vendorId);

            fullStatus.forEach(v->{

                System.out.println("===================================================");

                System.out.println("Vendor Id is "+v.getVenderiId());
                System.out.println("Vendor Name is "+v.getVenderName());
                System.out.println("Tender Id is "+v.getTenderId());
                System.out.println("Tender Name is " +v.getTenderName());
                System.out.println("Tender Amount is "+v.getTenderAmount());
                System.out.println("Tender Status is " +v.getStatusBid());

                System.out.println("====================================================");

            });

        } catch (TenderException e) {
            System.out.println(e.getMessage());
        }
    }

    // Show Tender History

    public static void TenderHistoryUseCase(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your vendor Id  to check the bid history against your acquired tender..! ");
        int tenderId = scanner.nextInt();

        VendorAndTenderDao dao = new VendorAndTenderDaoImpl();

        try {
            List<TenderStatus> vendorHistory =	dao.TenderHistory(tenderId);

            vendorHistory.forEach(v->{

                System.out.println("============================================================");

                System.out.println("Your vendor Id is "+v.getTenderId());
                System.out.println("Your vendor Name is "+v.getVenderName());
                System.out.println("Your tender Id is "+v.getTenderId());
                System.out.println("Your tender Name is " +v.getTenderName());
                System.out.println("Your tender Amount is "+v.getTenderAmount());
                System.out.println("Your tender Status is " +v.getStatusBid());

                System.out.println("============================================================");

            });

        } catch (VendorException e) {

            System.out.println(e.getMessage());
        }
    }

    // View tender bids

    public static void ViewTenderBidUseCase(){

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try{

            List<TenderBid> tenders= dao.ViewTenderBid();
            tenders.forEach(t -> {

                System.out.println("Tender Id is"+" "+t.getBid());
                System.out.println("Tender bid Id is"+" "+t.getBtid());
                System.out.println("Tender bid amount is"+" "+ t.getAmount());
                System.out.println("Tender status is"+" "+t.getStatus());
            });

        } catch (BidException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }


    // View minimum amount tender bid
    public static void viewMinimumAmountTenderBid(){

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try{

            List<TenderBid> minTenders= dao.viewMinimumAmountTenderBid();
            minTenders.forEach(t -> {

                System.out.println("Tender Id is"+" "+t.getBid());
                System.out.println("Tender bid Id is"+" "+t.getBtid());
                System.out.println("Tender bid amount is"+" "+ t.getAmount());
                System.out.println("Tender status is"+" "+t.getStatus());
            });

        } catch (TenderException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }

    // Show bid according to status

    public static void showBidAccordingToStatusUseCase(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter status of Tender bid__[ 1. Yes(if already assigned)  2. No(if yet to be assigned ]");
        System.out.println("If (Yes)..Give details of Vendor");
        System.out.println("If (No): No tender bid registered by admin recently");
        String status= scanner.next();

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try{

            List<TenderBid> minTenders= dao.showBidAccordingToStatus(status);
            minTenders.forEach(t -> {

                System.out.println("Tender Id is"+" "+t.getBid());
                System.out.println("Tender bid Id is"+" "+t.getBtid());
                System.out.println("Tender bid amount is"+" "+ t.getAmount());
                System.out.println("Tender status is"+" "+t.getStatus());
            });

        } catch (TenderException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }


    public static void assignTenderToVendors(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Please enter Bid Id");
        int bid = scanner.nextInt();

        System.out.println("Please enter assigned tender bid Id");
        int btid = scanner.nextInt();

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try {
            String msg= dao.assignTenderToVendors(bid, btid);
            System.out.println(msg);

        } catch (TenderException e) {
            e.printStackTrace();
        }

    }
}
