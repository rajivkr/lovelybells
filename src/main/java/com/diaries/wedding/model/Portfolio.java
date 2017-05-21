package com.diaries.wedding.model;

public class Portfolio {
	   private String categoryName;

	    private String[] img;

	    private String[] video;

	    public String getCategoryName ()
	    {
	        return categoryName;
	    }

	    public void setCategoryName (String categoryName)
	    {
	        this.categoryName = categoryName;
	    }

	    public String[] getImg ()
	    {
	        return img;
	    }

	    public void setImg (String[] img)
	    {
	        this.img = img;
	    }

	    public String[] getVideo ()
	    {
	        return video;
	    }

	    public void setVideo (String[] video)
	    {
	        this.video = video;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [categoryName = "+categoryName+", img = "+img+", video = "+video+"]";
	    }
}
