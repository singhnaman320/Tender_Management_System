package com.tms.usecases;

import com.tms.bean.TenderStatus;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.TenderException;

import java.util.List;
import java.util.Scanner;

public class TenderBidStatusUseCase {

    public static void TenderBidStatus(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter the Vendor Id");
        int vendorId =sc.nextInt();

        System.out.println("Please enter the Tender Id");
        int  tenderId= sc.nextInt();

        VendorAndTenderDao dao = new VendorAndTenderDaoImpl();

        try {
            List<TenderStatus> fullStatus =  dao.TenderBidStatus(tenderId, vendorId);

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

}
