package com.tms.usecases;

import com.tms.bean.TenderBid;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.BidException;

import java.util.List;

public class ViewTenderBidUseCase {

    public static void ViewTenderBid(){

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
}
