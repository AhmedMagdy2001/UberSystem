package com.example.demo;

public class FavouriteArea {
	private String driverName;
	private String source;

	public FavouriteArea(String source , String driverName){
		this.driverName = driverName;
		this.source = source;
	}
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
