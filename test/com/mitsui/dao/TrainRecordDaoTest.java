package com.mitsui.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mitsui.domain.TrainRecord;

public class TrainRecordDaoTest {
	

	@Test
	public void testAddTrainRecord() {
		
		TrainRecord t= new TrainRecord();
		TrainRecord t1=new TrainRecord(4,"12","4","01","1","1","1","1","1");
		boolean result=new  TrainRecordDao().addTrainRecord(t1);
		
		assertEquals(true,result);
		
		
	}


}
