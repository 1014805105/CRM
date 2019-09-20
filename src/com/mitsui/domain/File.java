package com.mitsui.domain;

public class File {
	private Integer file_id;
	 private Integer p_id;
	 private String  file_name;
	 private String file_abstract;
	 private String reward_note;
	 private String experience;
	 
	 public File() {
			super();
		}
	 
	public Integer getFile_id() {
		return file_id;
	}
	public void setFile_id(Integer fileId) {
		this.file_id = fileId;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer pId) {
		this.p_id = pId;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String fileName) {
		this.file_name = fileName;
	}
	public String getFile_abstract() {
		return file_abstract;
	}
	public void setFile_abstract(String fileAbstract) {
		this.file_abstract = fileAbstract;
	}
	public String getReward_note() {
		return reward_note;
	}
	public void setReward_note(String rewardNote) {
		this.reward_note = rewardNote;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	@Override

	public String toString() {
		return "File [file_id=" + file_id + ", p_id=" + p_id + ", file_name="
				+ file_name + ", file_abstract=" + file_abstract + ", reward_note=" + reward_note + ", experience="
				+ experience + "]";
	}
	public File(Integer fileId, Integer pId, String fileName, String fileAbstract,
			String rewardNote, String experience) {
		super();
		this.file_id = fileId;
		this.p_id = pId;
		this.file_name = fileName;
		this.file_abstract = fileAbstract;
		this.reward_note = rewardNote;
		this.experience = experience;
	}
	 	  
	
}
