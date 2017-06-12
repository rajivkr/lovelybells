package com.diaries.wedding.model;

public class Review {
    private String rating;

    private String comments;

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getComments ()
    {
        return comments;
    }

    public void setComments (String comments)
    {
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rating = "+rating+", comments = "+comments+"]";
    }
}
