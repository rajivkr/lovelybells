package com.diaries.wedding.model;
import java.util.*;

import org.springframework.data.annotation.Id;

public class Venue {

@Id
private String id;

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

private int numOfHalls;

private int venueRent;

private String detailDescr;

private int historyOfBooking;

private String budget;



private String featureTitle;

private String featureDescr;

private List<FeatureValue> featureValue;


private String vendorName;

private String vendorType;

private int primaryMobile;

private int secondaryMobile;

private int percentageCommission;

private int overallRatings;

private String isUsingVendorApp;

private List<Halls> halls;

private List<Menus> menus;

public String getId() {
	return id;
}

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



public int getNumOfHalls() {
	return numOfHalls;
}

public void setNumOfHalls(int numOfHalls) {
	this.numOfHalls = numOfHalls;
}

public int getVenueRent() {
	return venueRent;
}

public void setVenueRent(int venueRent) {
	this.venueRent = venueRent;
}

public String getDetailDescr() {
	return detailDescr;
}

public void setDetailDescr(String detailDescr) {
	this.detailDescr = detailDescr;
}

public int getHistoryOfBooking() {
	return historyOfBooking;
}

public void setHistoryOfBooking(int historyOfBooking) {
	this.historyOfBooking = historyOfBooking;
}

public String getBudget() {
	return budget;
}

public void setBudget(String budget) {
	this.budget = budget;
}

public String getFeatureTitle() {
	return featureTitle;
}

public void setFeatureTitle(String featureTitle) {
	this.featureTitle = featureTitle;
}

public String getFeatureDescr() {
	return featureDescr;
}

public void setFeatureDescr(String featureDescr) {
	this.featureDescr = featureDescr;
}

public List<FeatureValue> getFeatureValue() {
	return featureValue;
}

public void setFeatureValue(List<FeatureValue> featureValue) {
	this.featureValue = featureValue;
}

public String getVendorName() {
	return vendorName;
}

public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}

public String getVendorType() {
	return vendorType;
}

public void setVendorType(String vendorType) {
	this.vendorType = vendorType;
}

public int getPrimaryMobile() {
	return primaryMobile;
}

public void setPrimaryMobile(int primaryMobile) {
	this.primaryMobile = primaryMobile;
}

public int getSecondaryMobile() {
	return secondaryMobile;
}

public void setSecondaryMobile(int secondaryMobile) {
	this.secondaryMobile = secondaryMobile;
}

public int getPercentageCommission() {
	return percentageCommission;
}

public void setPercentageCommission(int percentageCommission) {
	this.percentageCommission = percentageCommission;
}

public int getOverallRatings() {
	return overallRatings;
}

public void setOverallRatings(int overallRatings) {
	this.overallRatings = overallRatings;
}

public String getIsUsingVendorApp() {
	return isUsingVendorApp;
}

public void setIsUsingVendorApp(String isUsingVendorApp) {
	this.isUsingVendorApp = isUsingVendorApp;
}

public List<Halls> getHalls() {
	return halls;
}

public void setHalls(List<Halls> halls) {
	this.halls = halls;
}

public List<Menus> getMenus() {
	return menus;
}

public void setMenus(List<Menus> menus) {
	this.menus = menus;
}




}
