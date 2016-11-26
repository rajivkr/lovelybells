package  com.diaries.wedding.model;
import java.util.*;

public class Halls {

private String hallName;

private int seating;

private int floating;

private int carCapacity;

private int bikeCapacity;

private int rooms;

private int vegPrice;

private int nonVegPrice;

private String shortDescription;

private String detailDescription;

private List<String> hallImages;

private int ratings;

private String isAirConditioned;

private String isBuffetAvailable;


public void setHallName(String HallName){
	this.hallName = HallName;
}
public String getHallName(){
	return this.hallName;
}
public void setSeating(int Seating){
	this.seating = Seating;
}
public int getSeating(){
	return this.seating;
}
public void setFloating(int Floating){
	this.floating = Floating;
}
public int getFloating(){
	return this.floating;
}
public void setCarCapacity(int CarCapacity){
	this.carCapacity = CarCapacity;
}
public int getCarCapacity(){
	return this.carCapacity;
}
public void setBikeCapacity(int BikeCapacity){
	this.bikeCapacity = BikeCapacity;
}
public int getBikeCapacity(){
	return this.bikeCapacity;
}
public void setRooms(int Rooms){
	this.rooms = Rooms;
}
public int getRooms(){
	return this.rooms;
}
public void setVegPrice(int VegPrice){
	this.vegPrice = VegPrice;
}
public int getVegPrice(){
	return this.vegPrice;
}
public void setNonVegPrice(int NonVegPrice){
	this.nonVegPrice = NonVegPrice;
}
public int getNonVegPrice(){
	return this.nonVegPrice;
}
public void setShortDescription(String ShortDescription){
	this.shortDescription = ShortDescription;
}
public String getShortDescription(){
	return this.shortDescription;
}
public void setDetailDescription(String DetailDescription){
	this.detailDescription = DetailDescription;
}
public String getDetailDescription(){
	return this.detailDescription;
}
public void setHallImages(List<String> HallImages){
	this.hallImages = HallImages;
}
public List<String> getHallImages(){
	return this.hallImages;
}
public void setRatings(int Ratings){
	this.ratings = Ratings;
}
public int getRatings(){
	return this.ratings;
}
public void setIsAirConditioned(String IsAirConditioned){
	this.isAirConditioned = IsAirConditioned;
}
public String getIsAirConditioned(){
	return this.isAirConditioned;
}
public void setIsBuffetAvailable(String IsBuffetAvailable){
	this.isBuffetAvailable = IsBuffetAvailable;
}
public String getIsBuffetAvailable(){
	return this.isBuffetAvailable;
}

}
