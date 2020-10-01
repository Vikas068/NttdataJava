package com.lic_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testInsert {

	@Test
	void test() {
		//checking the operation.
		int check=Lic.Insert();
		assertEquals(check, 1);
	}

}
