package com.lic_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Lic {
	//Scanner for taking input from the users.
	static Scanner scan=new Scanner(System.in);
	
	//JDBC driver name and driver url.
	static final String Driver="com.mysql.jdbc.Driver";
	static final String Url="jdbc:mysql://localhost:3306/trdb";
	
	//Database user name and password.
	static final String USER="root";
	static final String PASS="root";
	
	//Establishing the connection and statement.
	static Connection con=null;
	static PreparedStatement pst=null;
	
	//Insert operation method.
	public static int Insert() throws ClassNotFoundException
	{
		int rowInsert=0;
      try {
			String Policyname,Policyholdername,Preimiumtype;
			float Premiumamount;
			String Policystartdate;
			
			//Register database.
			Class.forName(Driver);
			
			//Open a connection.
			System.out.println("Establishing connection...");
			con=DriverManager.getConnection(Url,USER,PASS);
			
			//Taking input operation from user.
			System.out.println("Enter the Policy name.");
			Policyname=scan.next();
			System.out.println("Enter the Holder name.");
			Policyholdername=scan.next();
			System.out.println("Enter the Start date.(in YYYY_MM_DD)");
			Policystartdate=scan.next();
			System.out.println("Enter the Premium amount.");
			Premiumamount=scan.nextFloat();
			System.out.println("Enter the premium type.(In Yearly/half/Quarteyly Year)");
			Preimiumtype=scan.next();
			
			//Queury for insert operation.
			String sql="insert into LIC(Policyname,Policyholdername,Policystartdate,Premiumamount,Premiumtype) values(?,?,?,?,?)";
			
			//creating statement.
			pst=con.prepareStatement(sql);
			
			//setting values to column.
			pst.setString(1, Policyname);
			pst.setString(2, Policyholdername);
			pst.setString(3, Policystartdate);
			pst.setFloat(4, Premiumamount);
			pst.setString(5, Preimiumtype);
			
			//Updating the operation.
			rowInsert=pst.executeUpdate();
			
			//Condition statement to check insertion is done or not.  
			if(rowInsert>0)
			{
				System.out.println("Data inserted sucessfully...");
			}
			
			//"If" statement is not executed means, else will execute.
			else
				
			{
				System.out.println("Failed to insert the data....Please try again.");
			}
			//Clean up enviorment.
			con.close();
			pst.close();
			
		}
		catch(SQLException e)
		{
			//Handling the JDBC Exception.
			System.out.println(e);
		}
		return rowInsert;
	}
	//Method for fetching the details.
	public static int Fetch() throws ClassNotFoundException
	{
		//adding policynumber to fetch the data.
		int Policynumber,rowDelete=0;
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(Url,USER,PASS);
			System.out.println("Enter the policy number to fetch");
			Policynumber=scan.nextInt();
			
			//Query to fetch the data using policy.
			String sql="select * from LIC where Policynumber=?";
			PreparedStatement pst=con.prepareStatement(sql);
			
			//setting the value to column.
			pst.setInt(1, Policynumber);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				//Retrieve by column name.
				int policyno=rs.getInt(1);
				String pname=rs.getString(2);
				String phname=rs.getString(3);
				String sdate=rs.getString(4);
				float amount=rs.getFloat(5);
				String ptype=rs.getString(6);
				
				//Display by name.
				System.out.println("Booking details..");
				System.out.println("Policy number: "+policyno);
				System.out.println("Policy name: "+pname+"\nPolicy holder name is : "+phname);
				System.out.println("Policy Start date is: "+sdate );
				System.out.println("Policy Type:"+ptype+"\nPolicy Amount: "+amount );
				//Exiting the display state.
				System.exit(0);
			}
			System.out.println("No data is found....try with other policy number.");
			
			//Clean-up environment.
			con.close();
			pst.close();
		}
		catch(SQLException e)
		{
			//Handling exception occured.
			System.out.println(e);
		}
		return rowDelete;
		
	}
	//Method for Deleting the details.
	public static int Delete() throws ClassNotFoundException
	{
		//Adding policynumber to delete the data by using Policynumber.
		int rowDelete=0,Policynumber;
		//Exception handler.
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(Url,USER,PASS);
			
			//Getting policy number to delete.
			System.out.println("Enter the policy number to delete the details");
			Policynumber=scan.nextInt();
			
			//Query for delete operation.
			String sql="delete from LIC where Policynumber=?";
			//Creating prepared statement.
			PreparedStatement pst=con.prepareStatement(sql);
			//deleting the value by Policynumber.
			pst.setInt(1, Policynumber);
			rowDelete=pst.executeUpdate();
			//Checking condition for deletion is done or not.
			if(rowDelete>0)
			{
				System.out.println("Data is deleted successfully....");
			}
			else
			{
				System.out.println("Enterd policynumber is not Exist..Failed to delete!!!!....");
			}
			
		}
		//Handling the Exception by catch clause.  
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return rowDelete;
	}
	//method for updating the data.
	public static int Update() throws ClassNotFoundException
	{
		//update using by Policynumber,Premiumamount.
		int Policynumber,rowupdate=0;
		float Premiumamount;
		try {
			Class.forName(Driver);
			//Establishing the connection.
			con=DriverManager.getConnection(Url,USER,PASS);
			//Updating the details.
			System.out.println("Enter the policy number you want to update");
			Policynumber=scan.nextInt();
			System.out.println("Re-enter the premium amount ");
			Premiumamount=scan.nextFloat();
			String sql="update LIC set Premiumamount=? where Policynumber=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setFloat(1,Premiumamount);
			pst.setInt(2, Policynumber);
			
		
			rowupdate=pst.executeUpdate();
			//Condition to check the data is updated or not.
			if(rowupdate>0)
			{
				System.out.println("Details are updated successfully!!!!!");
			}
			else	
			{
				System.out.println("Details are failed to update....");
			}
		}
		//Handling the sqlException.
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return rowupdate;
	}	
}
