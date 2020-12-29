package com.donate.domain;

public class InsVO {

	private int ino;
	private String iname;
	private String loc;
	private int ipeople;
	private String icnt;
	private String imgfile;
	private String thumb;
	private String represent;
	public InsVO() {}
	
	public InsVO(String iname, String loc, int ipeople, String icnt, String imgfile,String thumb,String represent) {

		this.iname = iname;
		this.loc = loc;
		this.ipeople = ipeople;
		this.icnt = icnt;
		this.imgfile = imgfile;
		this.thumb = thumb;
		this.represent = represent;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getIpeople() {
		return ipeople;
	}

	public void setIpeople(int ipeople) {
		this.ipeople = ipeople;
	}

	public String getIcnt() {
		return icnt;
	}

	public void setIcnt(String icnt) {
		this.icnt = icnt;
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getRepresent() {
		return represent;
	}

	public void setRepresent(String represent) {
		this.represent = represent;
	}
	
	
}
