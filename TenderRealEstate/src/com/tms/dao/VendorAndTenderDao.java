package com.tms.dao;

import com.tms.bean.TenderBid;
import com.tms.bean.Tender;
import com.tms.bean.TenderStatus;
import com.tms.bean.Vendor;
import com.tms.exceptions.BidException;
import com.tms.exceptions.TenderException;
import com.tms.exceptions.VendorException;

import java.util.List;

public interface VendorAndTenderDao {

    public String VendorRegistration(String name, String email, String password, int mobile, String address);

    public Vendor signInVendor(String username, String password) throws VendorException;

    public List<Vendor> showAllVendors() throws VendorException;

    public String addTenders(String tname, String tdeadline, int tamount);

    public List<Tender> showAllTenders() throws TenderException;

    public String addBidForAllTenders(int bid, int btid, int bamount, String status)throws TenderException;

    public List<TenderStatus> TenderBidStatus(int vendorId, int tenderId) throws TenderException;

    public List<TenderStatus> TenderHistory(int vendorId) throws VendorException;

    public List<TenderBid> ViewTenderBid() throws BidException;

    public List<TenderBid> viewMinimumAmountTenderBid() throws TenderException; //=============================

    public List<TenderBid> showBidAccordingToStatus(String stat) throws TenderException;

    public String assignTenderToVendors(int bid, int btid) throws TenderException;
}
