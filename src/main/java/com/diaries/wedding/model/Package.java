package com.diaries.wedding.model;

public class Package {
	   private String price;

	    private String shortDescription;

	    private String dayDuration;

	    private String name;

	    private String numOfPhotographer;

	    private String moreInfo;

	    private String detailDescription;

	    private String advanceAmount;

	    public String getPrice ()
	    {
	        return price;
	    }

	    public void setPrice (String price)
	    {
	        this.price = price;
	    }

	    public String getShortDescription ()
	    {
	        return shortDescription;
	    }

	    public void setShortDescription (String shortDescription)
	    {
	        this.shortDescription = shortDescription;
	    }

	    public String getDayDuration ()
	    {
	        return dayDuration;
	    }

	    public void setDayDuration (String dayDuration)
	    {
	        this.dayDuration = dayDuration;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getNumOfPhotographer ()
	    {
	        return numOfPhotographer;
	    }

	    public void setNumOfPhotographer (String numOfPhotographer)
	    {
	        this.numOfPhotographer = numOfPhotographer;
	    }

	    public String getMoreInfo ()
	    {
	        return moreInfo;
	    }

	    public void setMoreInfo (String moreInfo)
	    {
	        this.moreInfo = moreInfo;
	    }

	    public String getDetailDescription ()
	    {
	        return detailDescription;
	    }

	    public void setDetailDescription (String detailDescription)
	    {
	        this.detailDescription = detailDescription;
	    }

	    public String getAdvanceAmount ()
	    {
	        return advanceAmount;
	    }

	    public void setAdvanceAmount (String advanceAmount)
	    {
	        this.advanceAmount = advanceAmount;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [price = "+price+", shortDescription = "+shortDescription+", dayDuration = "+dayDuration+", name = "+name+", numOfPhotographer = "+numOfPhotographer+", moreInfo = "+moreInfo+", detailDescription = "+detailDescription+", advanceAmount = "+advanceAmount+"]";
	    }
}
