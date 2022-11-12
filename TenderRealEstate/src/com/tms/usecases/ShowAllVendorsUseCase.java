package com.tms.usecases;

import com.tms.bean.Vendor;
import com.tms.dao.VendorAndTenderDao;
import com.tms.dao.VendorAndTenderDaoImpl;
import com.tms.exceptions.VendorException;

import java.util.List;

public class ShowAllVendorsUseCase {

    public static void showAllVendors(){

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
}
