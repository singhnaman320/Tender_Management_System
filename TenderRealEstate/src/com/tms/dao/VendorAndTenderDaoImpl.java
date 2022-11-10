package com.tms.dao;

import com.tms.bean.Tender;
import com.tms.bean.Vendor;
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

}
