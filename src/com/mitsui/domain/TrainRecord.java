package com.mitsui.domain;

public class TrainRecord {
	
    private Integer train_id;
    private String train_name;

	private String type_code;
    private String train_btime;
    private String train_etime;
    private String train_expense;
	private String train_location;
    private String train_host;
    private String train_master;

	public TrainRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
    public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String trainName) {
		train_name = trainName;
	}
	public TrainRecord(Integer trainId, String trainName, String typeCode,
			String trainBtime, String trainEtime, String trainExpense,
			String trainLocation, String trainHost, String trainMaster) {
		super();
		train_id = trainId;
		train_name = trainName;
		type_code = typeCode;
		train_btime = trainBtime;
		train_etime = trainEtime;
		train_expense = trainExpense;
		train_location = trainLocation;
		train_host = trainHost;
		train_master = trainMaster;
	}
	@Override
	public String toString() {
		return "TrainRecord [train_btime=" + train_btime + ", train_etime="
				+ train_etime + ", train_expense=" + train_expense
				+ ", train_host=" + train_host + ", train_id=" + train_id
				+ ", train_location=" + train_location + ", train_master="
				+ train_master + ", train_name=" + train_name + ", type_code="
				+ type_code + "]";
	}
	public Integer getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Integer trainId) {
		train_id = trainId;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String typeCode) {
		type_code = typeCode;
	}
	public String getTrain_btime() {
		return train_btime;
	}
	public void setTrain_btime(String trainBtime) {
		train_btime = trainBtime;
	}
	public String getTrain_etime() {
		return train_etime;
	}
	public void setTrain_etime(String trainEtime) {
		train_etime = trainEtime;
	}
	public String getTrain_expense() {
		return train_expense;
	}
	public void setTrain_expense(String trainExpense) {
		train_expense = trainExpense;
	}
	public String getTrain_location() {
		return train_location;
	}
	public void setTrain_location(String trainLocation) {
		train_location = trainLocation;
	}
	public String getTrain_host() {
		return train_host;
	}
	public void setTrain_host(String trainHost) {
		train_host = trainHost;
	}
	public String getTrain_master() {
		return train_master;
	}
	public void setTrain_master(String trainMaster) {
		train_master = trainMaster;
	}


}
