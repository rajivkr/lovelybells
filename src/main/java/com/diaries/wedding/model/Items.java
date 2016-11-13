package app.model;
import java.util.*;

public class Items {

private String itemName;


private List<String> types;


public void setItemName(String ItemName){
	this.itemName = ItemName;
}
public String getItemName(){
	return this.itemName;
}

public void setTypes(List<String> Types){
	this.types = Types;
}
public List<String> getTypes(){
	return this.types;
}

}
