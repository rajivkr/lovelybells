package app.model;
import java.util.*;

public class Menus {
	
private String menuTitle;

private int price;

private List<Items> items;


public void setMenuTitle(String MenuTitle){
    this.menuTitle = MenuTitle;
}
public String getMenuTitle(){
    return this.menuTitle;
}
public void setPrice(int Price){
    this.price = Price;
}
public int getPrice(){
    return this.price;
}
public void setItems(List<Items> Items){
    this.items = Items;
}
public List<Items> getItems(){
    return this.items;
}
}
