package rmi_db;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.*;

class BankImpl extends UnicastRemoteObject implements Bank {

    BankImpl()throws RemoteException{}

    public List<Customer> getCustomers(){
        List<Customer> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:3306:xe","root","aman4Git");
            PreparedStatement ps = con.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Customer c = new Customer();
                    c.setAcc_no(rs.getInt(1));
                    c.setFirstname(rs.getString(2));
                    c.setLastname(rs.getString(3));
                    c.setEmail(rs.getString(4));
                    c.setAmount(rs.getInt(5));
                    list.add(c);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
}