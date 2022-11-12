package com.tms.usecases;

import com.tms.bean.TenderBid;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.TenderException;

import java.util.List;
import java.util.Scanner;

public class ShowBidAccordingToStatusUseCase {

    public static void showBidAccordingToStatus(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter status of Tender bid__[ 1. Yes(if yet to be assigned)  2. No(if already assigned) ]");
        System.out.println("If (Yes): No tender bid registered by admin recently");
        System.out.println("If (No)..Give details of assigned bid");
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
}
