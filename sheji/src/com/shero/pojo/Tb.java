package com.shero.pojo;

import java.util.Date;

public class Tb {
	private int tid;
	private int uid;
	private String tsp;
	private String tbt;
	private Date tdate;
	private String tzw;
//	private String twj;
	/**
	 * @return the tzw
	 */
	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTzw() {
		return tzw;
	}
	/**
	 * @param tzw the tzw to set
	 */
	public void setTzw(String tzw) {
		this.tzw = tzw;
	}
	/**
	 * @return the ttp
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the tsp
	 */
	public String getTsp() {
		return tsp;
	}
	/**
	 * @param tsp the tsp to set
	 */
	public void setTsp(String tsp) {
		this.tsp = tsp;
	}
	/**
	 * @return the tbt
	 */
	public String getTbt() {
		return tbt;
	}
	/**
	 * @param tbt the tbt to set
	 */
	public void setTbt(String tbt) {
		this.tbt = tbt;
	}
	/**
	 * @return the tdate
	 */
	public Date getTdate() {
		return tdate;
	}
	/**
	 * @param tdate the tdate to set
	 */
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tb [tid=" + tid + ", uid=" + uid + ", tsp=" + tsp + ", tbt=" + tbt + ", tdate=" + tdate + ", tzw=" + tzw
				+ "]";
	}


}
