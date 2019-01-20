package com.shero.pojo;

import java.util.Date;

public class Goods {

	private int gid;
	private String gphoto;
	private String gname;
	private Date pdate;
	private String gzt;
	/**
	 * @return the gid
	 */
	public int getGid() {
		return gid;
	}
	/**
	 * @param gid the gid to set
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}
	/**
	 * @return the gphoto
	 */
	public String getGphoto() {
		return gphoto;
	}
	/**
	 * @param gphoto the gphoto to set
	 */
	public void setGphoto(String gphoto) {
		this.gphoto = gphoto;
	}
	/**
	 * @return the gname
	 */
	public String getGname() {
		return gname;
	}
	/**
	 * @param gname the gname to set
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}
	/**
	 * @return the pdate
	 */
	public Date getPdate() {
		return pdate;
	}
	/**
	 * @param pdate the pdate to set
	 */
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	/**
	 * @return the gzt
	 */
	public String getGzt() {
		return gzt;
	}
	/**
	 * @param gzt the gzt to set
	 */
	public void setGzt(String gzt) {
		this.gzt = gzt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gphoto=" + gphoto + ", gname=" + gname + ", pdate=" + pdate + ", gzt=" + gzt
				+ "]";
	}
	

}
