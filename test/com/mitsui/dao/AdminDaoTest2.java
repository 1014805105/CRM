package com.mitsui.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mitsui.domain.Admin;

public class AdminDaoTest2 {

	@Test
	public void test() {
		Admin c = new Admin();
		Admin b=new Admin(1,"admin","12345");
		Admin result=new AdminDao().queryAdmin(b);
		assertEquals(b.getAdmin_id(), result.getAdmin_id());
		assertEquals(b.getAdmin_password(), result.getAdmin_password());
		assertEquals(b.getAdmin_username(), result.getAdmin_username());
	}
		
}


