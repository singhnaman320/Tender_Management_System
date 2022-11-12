package com.tms.usecases;

import com.tms.bean.Tender;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.TenderException;

import java.util.List;

public class ShowAllTendersUseCase {

    public static void showAllTenders(){

        VendorAndTenderDao dao= new VendorAndTenderDaoImpl();

        try{

            List<Tender> tenders= dao.showAllTenders();
            tenders.forEach(t -> {

                System.out.println("=========================================================");

                System.out.println("Tender Id is"+" "+t.getTenderId());
                System.out.println("Tender name is"+" "+t.getCategory());
                System.out.println("Tender deadline is"+" "+ t.getDeadline());
                System.out.println("Tender amount is"+" "+t.getAmount());

                System.out.println("===========================================================");
            });

        } catch (TenderException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
}
