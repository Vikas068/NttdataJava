package com.lic_application;

import java.util.*;

public class LicMain {
	static int ch=0,result;
	//Scanning to get from user input.
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		
	//Handeling the eception.
	try {
		do {
			//Operations.
			System.out.println("-------Choose below one---------");
			System.out.println("1.Insert Details");
			System.out.println("2.Fetch Details");
			System.out.println("3.Delete Details");
			System.out.println("4.Update details");
			
			System.out.println("Please choose any one opertaion to perform.");
			ch=scan.nextInt();
			//switch statement for selecting the Choices.  
			switch(ch)
			{
			case 1:
				//Insert method.
				result=Lic.Insert();
				break;
			case 2:
				//Fetch method.
				Lic.Fetch();
				break;
			case 3:
				//Delete method.
				Lic.Delete();
				break;
			case 4:
				//Update method.
				Lic.Update();
				break;
			}
			
		}while(ch != 0);
		//If choice is wrong.
		System.out.println("Wrong selection...");
	}
	//Handling the exception.
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
