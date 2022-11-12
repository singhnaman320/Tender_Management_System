package com.tms.usecases;

import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.TenderException;

import java.util.Scanner;

public class AssignTenderToVendorsUseCase {

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
