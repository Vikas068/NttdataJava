package com.lic_application;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class Testunit {
	//Test for inserting thee details.
       @Test
	void testInsert() throws ClassNotFoundException {
		//checking the operation.
		int check=Lic.Insert();
		assertEquals(check, 1);
	}
	//Test for deleting the details.
	@Test
	void testDelete() throws ClassNotFoundException
	{
		int check=Lic.Delete();
		assertEquals(check, 1);
	}
	//Test for fetching the details.
	@Test
	void testFetch() 
	{
		Collection<Object> col=new ArrayList<Object>();
		assertEquals(0,col.size());
	}
	//Test for updating the details.
	@Test
	void testUpdate() throws ClassNotFoundException
	{
		int check=Lic.Update();
		assertEquals(check, 1);
	}
}
