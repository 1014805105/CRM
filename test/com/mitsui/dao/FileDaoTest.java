package com.mitsui.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mitsui.domain.File;

public class FileDaoTest extends FileDao {

//	
//
//	@Test
//	public void testDeleteFile() {
//		FileDao f=new FileDao();
//		boolean result = deleteFile(1);
//		assertEquals(true,result);
//	}
//	public void testAddfile() {
//		File f=new File();
//		
//		f.setFile_id(2);
//		f.setFile_abstract("abcde嘻嘻嘻");
//		f.setFile_name("入职档案");
//		f.setExperience("无");
//		f.setReward_note("一只98K");
//		f.setP_id(10);
//		boolean result= addFile(f);
//		
//		
//		
//		assertEquals(true, result);
//	}
//
//	
	@Test
	public void testupdateFile() {
File f=new File();
		
		f.setFile_id(2);
		f.setFile_abstract("abcde嘻嘻嘻");
		f.setFile_name("入职档案");
		f.setExperience("无");
		f.setReward_note("2只98K");
		f.setP_id(10);
		boolean result= updateFile(f);
		assertEquals(true, result);
	}
}
