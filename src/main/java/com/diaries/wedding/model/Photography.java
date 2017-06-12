package com.diaries.wedding.model;

public class Photography {
    private String budget;

    private String fullAddress;

    private String packageStartingPrice;

    private String primaryContact;

    private String historyOfBooking;

    private Portfolio[] portfolio;

    private String isOnlineBookingAvailable;

    private Package[] packages;

    private String[] availableCities;

    private String percentageCommission;

    private String detailDescription;

    private String businessModel;

    private String id;

    private String secondaryContact;

    private String reviewRating;

    private String shortDescription;

    private String name;

    private String isReadyToTravel;

    private String packageFinalPrice;

    private Review[] review;
    
    private String state;

   	private String city;

    private String area;

    public String getBudget ()
    {
        return budget;
    }

    public void setBudget (String budget)
    {
        this.budget = budget;
    }

    public String getFullAddress ()
    {
        return fullAddress;
    }

    public void setFullAddress (String fullAddress)
    {
        this.fullAddress = fullAddress;
    }

    public String getPackageStartingPrice ()
    {
        return packageStartingPrice;
    }

    public void setPackageStartingPrice (String packageStartingPrice)
    {
        this.packageStartingPrice = packageStartingPrice;
    }

    public String getPrimaryContact ()
    {
        return primaryContact;
    }

    public void setPrimaryContact (String primaryContact)
    {
        this.primaryContact = primaryContact;
    }

    public String getHistoryOfBooking ()
    {
        return historyOfBooking;
    }

    public void setHistoryOfBooking (String historyOfBooking)
    {
        this.historyOfBooking = historyOfBooking;
    }

    public Portfolio[] getPortfolio ()
    {
        return portfolio;
    }

    public void setPortfolio (Portfolio[] portfolio)
    {
        this.portfolio = portfolio;
    }

    public String getIsOnlineBookingAvailable ()
    {
        return isOnlineBookingAvailable;
    }

    public void setIsOnlineBookingAvailable (String isOnlineBookingAvailable)
    {
        this.isOnlineBookingAvailable = isOnlineBookingAvailable;
    }

    public Package[] getPackages ()
    {
        return packages;
    }

    public void setPackages (Package[] packages)
    {
        this.packages = packages;
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



    public String[] getAvailableCities ()
    {
        return availableCities;
    }

    public void setAvailableCities (String[] availableCities)
    {
        this.availableCities = availableCities;
    }

    public String getPercentageCommission ()
    {
        return percentageCommission;
    }

    public void setPercentageCommission (String percentageCommission)
    {
        this.percentageCommission = percentageCommission;
    }

    public String getDetailDescription ()
    {
        return detailDescription;
    }

    public void setDetailDescription (String detailDescription)
    {
        this.detailDescription = detailDescription;
    }

    public String getBusinessModel ()
    {
        return businessModel;
    }

    public void setBusinessModel (String businessModel)
    {
        this.businessModel = businessModel;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSecondaryContact ()
    {
        return secondaryContact;
    }

    public void setSecondaryContact (String secondaryContact)
    {
        this.secondaryContact = secondaryContact;
    }

    public String getReviewRating ()
    {
        return reviewRating;
    }

    public void setReviewRating (String reviewRating)
    {
        this.reviewRating = reviewRating;
    }

    public String getShortDescription ()
    {
        return shortDescription;
    }

    public void setShortDescription (String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getIsReadyToTravel ()
    {
        return isReadyToTravel;
    }

    public void setIsReadyToTravel (String isReadyToTravel)
    {
        this.isReadyToTravel = isReadyToTravel;
    }

    public String getPackageFinalPrice ()
    {
        return packageFinalPrice;
    }

    public void setPackageFinalPrice (String packageFinalPrice)
    {
        this.packageFinalPrice = packageFinalPrice;
    }

    public Review[] getReview ()
    {
        return review;
    }

    public void setReview (Review[] review)
    {
        this.review = review;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [budget = "+budget+", fullAddress = "+fullAddress+", packageStartingPrice = "+packageStartingPrice+", primaryContact = "+primaryContact+", historyOfBooking = "+historyOfBooking+", portfolio = "+portfolio+", isOnlineBookingAvailable = "+isOnlineBookingAvailable+", packages = "+packages+", availableCities = "+availableCities+", percentageCommission = "+percentageCommission+", detailDescription = "+detailDescription+", businessModel = "+businessModel+", id = "+id+", secondaryContact = "+secondaryContact+", reviewRating = "+reviewRating+", shortDescription = "+shortDescription+", name = "+name+", isReadyToTravel = "+isReadyToTravel+", packageFinalPrice = "+packageFinalPrice+", review = "+review+"]";
    }
}
