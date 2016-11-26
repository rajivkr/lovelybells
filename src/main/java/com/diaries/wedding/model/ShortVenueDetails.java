package  com.diaries.wedding.model;

import java.util.List;

public class ShortVenueDetails {
	private String name;
	
	private String address;
	
	private String shortDescr;
	
	private List<String> venueImages;
	
	private List<OtherHighlights> otherHighlights;
	
	private int vegPrice;

	private int nonVegPrice;
	
	private String state;

	private String city;

	private String area;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShortDescr() {
		return shortDescr;
	}

	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}

	public List<String> getVenueImages() {
		return venueImages;
	}

	public void setVenueImages(List<String> venueImages) {
		this.venueImages = venueImages;
	}

	public List<OtherHighlights> getOtherHighlights() {
		return otherHighlights;
	}

	public void setOtherHighlights(List<OtherHighlights> otherHighlights) {
		this.otherHighlights = otherHighlights;
	}

	public int getVegPrice() {
		return vegPrice;
	}

	public void setVegPrice(int vegPrice) {
		this.vegPrice = vegPrice;
	}

	public int getNonVegPrice() {
		return nonVegPrice;
	}

	public void setNonVegPrice(int nonVegPrice) {
		this.nonVegPrice = nonVegPrice;
	}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

}
