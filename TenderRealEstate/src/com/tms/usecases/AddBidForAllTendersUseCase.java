package com.tms.usecases;

import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.TenderException;

import java.util.Scanner;

public class AddBidForAllTendersUseCase {

    public static void addBidForAllTenders(){

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

}
