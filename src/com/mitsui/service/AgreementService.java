package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.AgreementDao;
import com.mitsui.dao.FileDao;
import com.mitsui.domain.Agreement;
import com.mitsui.domain.File;

public class AgreementService {
static	private AgreementDao agreementDao = new AgreementDao();
	
	public boolean addAgreement(Agreement agreement){
		try{
			agreementDao.addAgreement(agreement);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public  List<Agreement> queryAllAgreement(){
		try{
			List<Agreement> Agreements = agreementDao.queryAllAgreement();
			return Agreements;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean deleteAgreement(Integer p_id){
		try{
			agreementDao.deleteAgreement(p_id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public Agreement queryAgreement(Integer id){
		try{
			Agreement u = agreementDao.queryAgreement(id);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean updateAgreement(Agreement Agreement){
		try{
			return agreementDao.updateAgreement(Agreement);
		}catch (Exception e) {
			return false;
		}
	}
	public List<Agreement> queryOneAgreement(int id) {
		try{
			List<Agreement> Agreements =AgreementDao.queryOneAgreement(id);
			return Agreements;
		}catch (Exception e) {
			return null;
		}
	}
}



