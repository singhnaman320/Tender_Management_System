package com.tms.dao;

import com.tms.bean.Tender;
import com.tms.bean.Vendor;
import com.tms.exceptions.TenderException;
import com.tms.exceptions.VendorException;

import java.sql.Date;
import java.util.List;

public interface VendorAndTenderDao {

    public String VendorRegistration(String name, String email, String password, int mobile, String address);

    public List<Vendor> showAllVendors() throws VendorException;

    public String addTenders(String tname, String tdeadline, int tamount);

    public List<Tender> showAllTenders() throws TenderException;
}
