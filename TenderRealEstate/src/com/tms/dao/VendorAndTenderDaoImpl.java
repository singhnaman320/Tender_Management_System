package com.tms.dao;

import com.tms.bean.TenderBid;
import com.tms.bean.Tender;
import com.tms.bean.TenderStatus;
import com.tms.bean.Vendor;
import com.tms.exceptions.BidException;
import com.tms.exceptions.TenderException;
import com.tms.exceptions.VendorException;
import com.tms.utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorAndTenderDaoImpl implements VendorAndTenderDao{

    // [] Vendor Registration []
    @Override
    public String VendorRegistration(String name, String email, String password, int mobile, String address) {

        String message= "Unable to add vendor..!";

        try(Connection connect= DBUtil.provideConnection()){

            PreparedStatement ps= connect.prepareStatement("insert into Vendor(vname, vemail,vpassword, vmobile, vaddress)" +
                    "values(?, ?, ?, ?, ?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, mobile);
            ps.setString(5, address);

            int values= ps.executeUpdate();

            if(values>0){
                System.out.println("Vendor registered successfully");
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            message= e.getMessage();
        }

        return message;
    }

    // [] SignIn vendor
    @Override
    public Vendor signInVendor(String username, String password) throws VendorException {

        Vendor vendor= null;

        try(Connection connect= DBUtil.provideConnection()){

            PreparedStatement ps= connect.prepareStatement("select * from vendor where vemail= ? AND vpassword= ?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){

                int vid= rs.getInt("vid");
                String vname= rs.getString("vname");
                String vemail= rs.getString("vemail");
                String vpassword= rs.getString("vpassword");
                int vmobile= rs.getInt("vmobile");
                String vaddress= rs.getString("vaddress");

            }else {

                throw new VendorException("Unable to SignIn. Please check your username or password.!");
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new VendorException(e.getMessage());
        }

        return vendor;
    }


    // [] Show all vendors []

    @Override
    public List<Vendor> showAllVendors() throws VendorException {

        List<Vendor> allVendors= new ArrayList<>();

        try(Connection connect= DBUtil.provideConnection()){

            PreparedStatement ps= connect.prepareStatement("select * from vendor");
            ResultSet rs= ps.executeQuery();

            while (rs.next()){

                int vid= rs.getInt("vid");
                String name= rs.getString("vname");
                String email= rs.getString("vemail");
                String password= rs.getString("vpassword");
                int mobile= rs.getInt("vmobile");
                String address= rs.getString("vaddress");

                Vendor theseVendors= new Vendor(vid, name, email, password, mobile, address);

                allVendors.add(theseVendors);
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);

            throw new VendorException(e.getMessage());
        }

        if(allVendors.size() == 0){

            throw new VendorException("Sorry..! No vendor found...");
        }

        return allVendors;
    }

    // [] Add tenders []
    @Override
    public String addTenders(String tname, String tdeadline, int tamount){

        String message= "Tender not added..!";

        try(Connection connect= DBUtil.provideConnection()){

            PreparedStatement ps= connect.prepareStatement("insert into tender(tname, tdeadline, tamount) values(?, ?, ?)");
            ps.setString(1, tname);
            ps.setString(2, tdeadline);
            ps.setInt(3, tamount);

            int values= ps.executeUpdate();

            if(values > 0){
                message= "Tender added successfully..!";
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            message= e.getMessage();
        }

        return message;
    }

    // [] Show all tenders []
    @Override
    public List<Tender> showAllTenders() throws TenderException {

        List<Tender> allTenders= new ArrayList<>();

        try(Connection connect= DBUtil.provideConnection()){

            PreparedStatement ps= connect.prepareStatement("select * from tender");
            ResultSet rs= ps.executeQuery();

            while (rs.next()){

                int tid= rs.getInt("tid");
                String tname= rs.getString("tname");
                String tdeadline= rs.getString("tdeadline");
                int tamount= rs.getInt("tamount");

                Tender theseTenders= new Tender(tid, tname, tdeadline, tamount);

                allTenders.add(theseTenders);

            }


        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new TenderException(e.getMessage());
        }

        if(allTenders.size() == 0){

            throw new TenderException("Sorry..! No  new tender issued..!");
        }
        return allTenders;
    }

    @Override
    public String addBidForAllTenders(int bid, int btid, int bamount, String status) throws TenderException{

        String message= "No bid added recently. Please visit later";

        try(Connection connect= DBUtil.provideConnection()){

            PreparedStatement ps= connect.prepareStatement("insert into TenderBid(bid, btid, bamount, status) values(?, ?, ?, ?)");
            ps.setInt(1, bid);
            ps.setInt(2, btid);
            ps.setInt(3, bamount);
            ps.setString(4, status);

            int value= ps.executeUpdate();

            if(value > 0){

                message= "Tender bid registered successfully";
            } else{
                throw new TenderException("Please enter correct details to register a bid");

            }
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            message= e.getMessage();
        }

        return message;
    }

    @Override
    public List<TenderStatus> TenderBidStatus(int vendorId, int tenderId) throws TenderException {


        ArrayList<TenderStatus> tstatus = new ArrayList<>();

        try (Connection connect = DBUtil.provideConnection()) {

            PreparedStatement ps = connect.prepareStatement(
                    " select v.vid,v.vname,t.tid,t.tname,b.bamount,b.status from  vendor v inner join tender t inner " +
                            "join TenderBid b on v.vid=b.bid AND t.tid=b.btid AND b.bid=? AND b.btid=?" );

            ps.setInt(1, vendorId);
            ps.setInt(2, tenderId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int vid = rs.getInt("vid");
                String name = rs.getString("vname");
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                int amount = rs.getInt("bamount");
                String status = rs.getString("status");

                if (status.equals("Yes")) {

                    tstatus.add(new TenderStatus(vid, name, tid, tname, amount, "Open to acquire"));

                } else {

                    tstatus.add(new TenderStatus(vid, name, tid, tname, amount, "Already acquired"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (tstatus.size() == 0) {
            throw new TenderException("Please check your info again");
        }

        return tstatus;
    }

    // Get own Tender History
    @Override
    public List<TenderStatus> TenderHistory(int vendorId) throws VendorException {

        List<TenderStatus> vendorHistory = new ArrayList<>();

        try (Connection connect = DBUtil.provideConnection()) {

            PreparedStatement ps = connect.prepareStatement(
                    "select v.vid,v.vname,t.tid,t.tname,b.bamount,b.status from  vendor v inner join tender t inner" +
                            " join TenderBid b on v.vid=b.bid AND t.tid=b.btid AND v.vid=?");

            ps.setInt(1, vendorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int vid = rs.getInt("vid");
                String name = rs.getString("vname");
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                int amount = rs.getInt("bamount");
                String status = rs.getString("status");

                if (status.equals("Yes")){

                    vendorHistory.add(new TenderStatus(vid, name, tid, tname, amount, "Ready to acquire"));

                } else {

                    vendorHistory.add(new TenderStatus(vid, name, tid, tname, amount, "Already acquired"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (vendorHistory.size() == 0) {
            throw new VendorException("Please check your info again");
        }
        return vendorHistory;
    }

    // View all Tender bids
    @Override
    public List<TenderBid> ViewTenderBid() throws BidException {

        List<TenderBid> allBids= new ArrayList<>();

        try (Connection connect = DBUtil.provideConnection()) {

            PreparedStatement ps = connect.prepareStatement("select * from TenderBid");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int bid = rs.getInt("bid");
                int btid = rs.getInt("btid");
                int bamount = rs.getInt("bamount");
                String status = rs.getString("status");

                if (status.equals("Yes")) {

                    allBids.add(new TenderBid(bid, btid, bamount, "Yet to be issued"));

                }else {
                    allBids.add(new TenderBid(bid, btid, bamount, "Already issued"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (allBids.size() == 0) {
            throw new BidException("Bid not found");
        }
        return allBids;
    }

    // View Bid according to status

    @Override
    public List<TenderBid> showBidAccordingToStatus(String stat) throws TenderException {

        List<TenderBid> bids = new ArrayList<>();

        try (Connection conn = DBUtil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from TenderBid where status=?");

            ps.setString(1, stat);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int bid = rs.getInt("bid");
                int btid = rs.getInt("btid");
                int bamount = rs.getInt("bamount");
                String status = rs.getString("status");

                if (status.equals("Yes")) {

                    bids.add(new TenderBid(bid, btid, bamount, "Yet to Assign"));
                }else {
                    bids.add(new TenderBid(bid, btid, bamount, "Already Assigned"));
                }
            }

        } catch (Exception e) {
            throw new TenderException(e.getMessage());
        }
        if (bids.size() == 0) {
            throw new TenderException("No Tender Bid Found");
        }
        return bids;
    }

    @Override
    public String assignTenderToVendors(int bid, int btid) throws TenderException {

        String message = "Tender not assigned to any vendor";

        try (Connection conn = DBUtil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("update TenderBid set status='No' where Status='Yes' AND bid=? AND btid=? ");

            ps.setInt(1, bid);
            ps.setInt(2, btid);

            int value = ps.executeUpdate();

            if (value > 0) {
                message = "Tender assigned to vendor";

            }else{
                throw new TenderException("Tender is Already assign Please Recheck it");
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

}

