package com.mitsui.dao;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mitsui.domain.Admin;


class AdminDaoTest {

	@Test
	public void testQueryAdmin() {
		Admin c = new Admin();
		c.setAdmin_id(1);
		c.setAdmin_password("123456");
		c.setAdmin_username("admin");
		Admin b=new Admin(1,"admin","123456");
		Admin result=new AdminDao().queryAdmin(c);
		if (c.getAdmin_id()==result.getAdmin_id()) {
			System.out.println("id校验通过");
			
		}
	}

}
