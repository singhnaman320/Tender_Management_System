package com.tms.usecases;

import com.tms.bean.TenderStatus;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.VendorException;

import java.util.List;
import java.util.Scanner;

public class TenderHistoryUseCase {

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

}
