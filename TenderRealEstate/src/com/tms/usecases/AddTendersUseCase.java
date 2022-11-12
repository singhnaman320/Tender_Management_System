package com.tms.usecases;

import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;

import java.util.Scanner;

public class AddTendersUseCase {

    public static void addTenders(){

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
}
