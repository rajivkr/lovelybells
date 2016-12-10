app.controller('VenueController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {
    $scope.AddVenue = function () {
    };
    $scope.venueViewModel = {};
    $scope.venueViewModel.featureValues = [];
    $scope.featureValue = {};
    $scope.featureCategoryValue = {};
    $scope.venueViewModel.otherHighlights = [];
    $scope.otherHighlightItem = {};
    $scope.hall = {};
    $scope.venueViewModel.halls = [];
    $scope.venueViewModel.menus = [];
    $scope.menu = {};
    $scope.menuItem = {};
    $scope.menuItemType = {};
    $scope.venueViewModel.shortVenueDetails = {};
    var maxSeating = 0;
    var maxFloating = 0;
    $scope.AddFeature = function () {
        $scope.featureValue = {};
        $scope.featureValue.featureCategoryTitle = "";
        $scope.featureValue.featureCategoryValues = [];
        $scope.featureCategoryValue = {};
        $scope.featureCategoryValue.subFeatureCategoryTitle = "";
        $scope.featureCategoryValue.subFeatureCategoryValue = "";
        $scope.featureValue.featureCategoryValues.push($scope.featureCategoryValue);
        $scope.venueViewModel.featureValues.push($scope.featureValue);
    };
    $scope.AddFeatureCategory = function (featureValue) {
        $scope.featureCategoryValue = {};
        $scope.featureCategoryValue.subFeatureCategoryTitle = "";
        $scope.featureCategoryValue.subFeatureCategoryValue = "";
        var featureindex = $scope.venueViewModel.featureValues.indexOf(featureValue);
        $scope.venueViewModel.featureValues[featureindex].featureCategoryValues.push($scope.featureCategoryValue);
    };
    $scope.DeleteFeature = function (item) {
        var index = $scope.venueViewModel.featureValues.indexOf(item);
        $scope.venueViewModel.featureValues.splice(index, 1);
    }
    $scope.DeleteFeatureCategory = function (categoryitem, featureitem) {
        var featureindex = $scope.venueViewModel.featureValues.indexOf(featureitem);
        var categoryindex = $scope.venueViewModel.featureValues[featureindex].featureCategoryValues.indexOf(categoryitem);
        $scope.venueViewModel.featureValues[featureindex].featureCategoryValues.splice(categoryindex, 1);
    }
    $scope.AddOtherHighlights = function () {
        $scope.otherHighlightItem = {};
        $scope.venueViewModel.otherHighlights.push($scope.otherHighlightItem);
    }
    $scope.DeleteHighlight = function (highlightItem) {
        var highlightItemIndex = $scope.venueViewModel.otherHighlights.indexOf(highlightItem);
        $scope.venueViewModel.otherHighlights.splice(highlightItemIndex, 1);
    }
    $scope.AddHall = function () {
        $scope.hall = {};
        $scope.venueViewModel.halls.push($scope.hall);
    }
    $scope.DeleteHall = function (hallItem) {
        var hallIndex = $scope.venueViewModel.halls.indexOf(hallItem);
        $scope.venueViewModel.halls.splice(hallIndex, 1);
    }
    $scope.AddMenu = function () {
        $scope.menu = {};
        $scope.menu.items = [];
        $scope.menuItem = {};
        $scope.menuItemType = {};
        $scope.menuItemType.name = "";
        $scope.menu.items.push($scope.menuItem);
        $scope.venueViewModel.menus.push($scope.menu);
    }
    $scope.DeleteMenu = function (menu) {
        var menuIndex = $scope.venueViewModel.menus.indexOf(menu);
        $scope.venueViewModel.menus.splice(menuIndex, 1);
    }
    $scope.AddMenuItem = function (menu) {
        $scope.menuItem = {};
        var menuIndex = $scope.venueViewModel.menus.indexOf(menu);
        $scope.venueViewModel.menus[menuIndex].items.push($scope.menuItem);
    }
    $scope.DeleteMenuItem = function (menuItem, menu) {
        var menuIndex = $scope.venueViewModel.menus.indexOf(menu);
        var menuItemIndex = $scope.venueViewModel.menus[menuIndex].items.indexOf(menuItem);
        $scope.venueViewModel.menus[menuIndex].items.splice(menuItemIndex, 1);
    }
    $scope.submit = function () {
        VenueService.submit($scope.uploadViewModel).then(function (data) {
            alert(data);
        })
    };
    $scope.AddVenue = function () {
        $scope.venueViewModel.shortVenueDetails = {};
        $scope.venueViewModel.shortVenueDetails.name = $scope.venueViewModel.name;
        $scope.venueViewModel.shortVenueDetails.address = $scope.venueViewModel.address;
        $scope.venueViewModel.shortVenueDetails.shortDescr = $scope.venueViewModel.shortDescr;
        $scope.venueViewModel.shortVenueDetails.otherHighlights = [];
        _.forEach($scope.venueViewModel.otherHighlights, function (otherHighlightItem) {
            $scope.venueViewModel.shortVenueDetails.otherHighlights.push(otherHighlightItem);
        })
        $scope.venueViewModel.shortVenueDetails.vegPrice = $scope.venueViewModel.vegPrice;
        $scope.venueViewModel.shortVenueDetails.nonVegPrice = $scope.venueViewModel.nonVegPrice;
        $scope.venueViewModel.shortVenueDetails.state = $scope.venueViewModel.state;
        $scope.venueViewModel.shortVenueDetails.city = $scope.venueViewModel.city;
        $scope.venueViewModel.shortVenueDetails.area = $scope.venueViewModel.area;
         validate();
        if ($scope.validationPassed)
        {
         alert("Validation Passed")
          VenueService.addVenue($scope.venueViewModel).then(function (data) {
              alert("Value Submitted")
              $location.path('/VenueList');
          })
          }
        else
            alert("Validation failed")
       

    };
    var listOfVenues = JSON.parse('{ "featureValues": [], "otherHighlights": [{ "category": "Sarakku", "isAvailable": "0" }, { "category": "Dabaanguthu", "isAvailable": "1" }, { "category": "Gaana paatu", "isAvailable": "1" }], "halls": [], "menus": [], "shortVenueDetails": { "name": "Alexanders Hall", "address": "23/8,10th Street Vinbhaji Nagar, Hasthinapuram,Chennai - 64", "shortDescr": "Superb Hall with Good Ambience", "otherHighlights": [{ "category": "Sarakku", "isAvailable": "1" }, { "category": "Dabaanguthu", "isAvailable": "1" }, { "category": "Gaana paatu", "isAvailable": "1" }], "vegPrice": "2", "nonVegPrice": "2", "state": "TamilNadu", "city": "Chennai", "area": "Hasthinapuram" }, "name": "Alexanders Hall", "numOfHalls": "1", "venueRent": "2", "vegPrice": "2", "nonVegPrice": "2", "shortDescr": "Superb Hall with Good Ambience", "detailDescr": "Adhe dhaan", "historyOfBooking": "10", "budget": "High", "state": "TamilNadu", "city": "Chennai", "area": "Hasthinapuram", "featureTitle": "sdgsg", "featureDescr": "sdgsdg", "vendorName": "Alexander Immanuel D", "vendorType": "Marriage halls", "primaryMobile": "9940479677", "secondaryMobile": "9940479677", "percentageCommission": "10", "overallRatings": "5", "isUsingVendorApp": "1", "address": "23/8,10th Street Vinbhaji Nagar, Hasthinapuram,Chennai - 64" }');
    $scope.venueList = [];
    //$scope.venueList.push(listOfVenues);

    VenueService.getVenues().then(function (data) {
        $scope.venueList = data;
    })
    $scope.venueView = {};
    $scope.venueView = VenueService.getSavedData();
    //$scope.venueView = JSON.parse('{"featureValues":[{"featureCategoryTitle":"Rentals","featureCategoryValues":[{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"Rental Notes","featureSubCategoryValue":"F&B prices are inclusive of rental charges."}]},{"featureCategoryTitle":"Corkage, DJ & Decorations","featureCategoryValues":[{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"Corkage costs if liquor allowed","featureSubCategoryValue":"Corkage does not apply"},{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"DJ costs starts at","featureSubCategoryValue":"Rs.36000"}]}],"otherHighlights":[{"category":"Music Allowed Late","isAvailable":"1"},{"category":"Decor Provided by the Venue","isAvailable":"1"},{"category":"Halls are Air Conditioned","isAvailable":"1"},{"category":"Ample Parking","isAvailable":"1"}],"halls":[{"hallName":"Class 1","seating":"1000","floating":"2000","carCapacity":"100","bikeCapacity":"200","rooms":"5","vegPrice":"150","nonVegPrice":"350","shortDescription":"Class 1 Style Hall","detailDescription":"Class 1 Style Hall in Detail Lorem ipsum Dolor sit ame.asfr huif nfef afeg egww","ratings":"2","isAirConditioned":"0","isBuffetAvailable":"0"},{"hallName":"Class 2","seating":"2000","floating":"3000","carCapacity":"500","bikeCapacity":"1000","rooms":"10","vegPrice":"550","nonVegPrice":"850","shortDescription":"Class 2 Style Halls","detailDescription":"This has a greater and better ambience provided.","ratings":"5","isAirConditioned":"1","isBuffetAvailable":"1"}],"menus":[{"items":[{"itemName":"Soup","types":["Veg Sour","Tomato","Corn","Potato","Cauliflower"]},{"itemName":"Rice","types":["Veg Pulao","Sambhar Rice","Veg Biriyani","Brinje"]},{"itemName":"SideDishes","types":["Aloo masala","Cauliflower Aaloo","Paneer butter Masala"]}],"menuTitle":"Veg Tamil Nadu","price":"1000"},{"items":[{"itemName":"Biriyani","types":["Chicken","Mutton","Fish","Prawn"]},{"itemName":"Fry","types":["Chicken Tandoori","Mutton Chops","Fish Finger","Chicken Lollipop"]}],"menuTitle":"Non Veg TamilNadu","price":"2000"}],"shortVenueDetails":{"name":"Alexander odaya Mandapam","seating":"2000","floating":"3000","address":"23/8,10th Street Vinobhaji Nagar,Hasthinapuram,Chennai - 74","shortDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!!","otherHighlights":[{"category":"Music Allowed Late","isAvailable":"1"},{"category":"Decor Provided by the Venue","isAvailable":"1"},{"category":"Halls are Air Conditioned","isAvailable":"1"},{"category":"Ample Parking","isAvailable":"1"}],"vegPrice":"500","nonVegPrice":"800","state":"TamilNadu","city":"Chennai","area":"Hasthinapuram"},"name":"Alexander odaya Mandapam","seating":"2000","floating":"3000","numOfHalls":"1","venueRent":"100000","vegPrice":"500","nonVegPrice":"800","shortDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!!","detailDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!! Super Mandapam, Ac lam iruku","historyOfBooking":"10","budget":"high","state":"TamilNadu","city":"Chennai","area":"Hasthinapuram","featureTitle":"PRICING DETAILS AND NOTES","featureDescr":"Pricing details of all the features provided my namba Ambi oda mandapam","vendorName":"R Dhanasekars KD Services","vendorType":"Contractor","primaryMobile":"9884332369","secondaryMobile":"9962532369","percentageCommission":"100","overallRatings":"5","isUsingVendorApp":"1","address":"23/8,10th Street Vinobhaji Nagar,Hasthinapuram,Chennai - 74"}');
    
    $scope.getFullVenue = function (id) {
        var maxSeating = 0, maxFloating = 0;

        VenueService.getFullVenue(id).then(function (data) {
            $scope.venueView = data;
            
            _.forEach($scope.venueView.halls, function (hallItem) {
                if (parseInt(hallItem.seating) > parseInt(maxSeating))
                    maxSeating = hallItem.seating;
                if (parseInt(hallItem.floating) > parseInt(maxFloating))
                    maxFloating = hallItem.floating;
            })
            $scope.venueView.seating = maxSeating;
            $scope.venueView.floating = maxFloating;
            VenueService.setSavedData(data);

            //$scope.venueView = JSON.parse('{"featureValues":[{"featureCategoryTitle":"Rentals","featureCategoryValues":[{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"Rental Notes","featureSubCategoryValue":"F&B prices are inclusive of rental charges."}]},{"featureCategoryTitle":"Corkage, DJ & Decorations","featureCategoryValues":[{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"Corkage costs if liquor allowed","featureSubCategoryValue":"Corkage does not apply"},{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"DJ costs starts at","featureSubCategoryValue":"Rs.36000"}]}],"otherHighlights":[{"category":"Music Allowed Late","isAvailable":"1"},{"category":"Decor Provided by the Venue","isAvailable":"1"},{"category":"Halls are Air Conditioned","isAvailable":"1"},{"category":"Ample Parking","isAvailable":"1"}],"halls":[{"hallName":"Class 1","seating":"1000","floating":"2000","carCapacity":"100","bikeCapacity":"200","rooms":"5","vegPrice":"150","nonVegPrice":"350","shortDescription":"Class 1 Style Hall","detailDescription":"Class 1 Style Hall in Detail Lorem ipsum Dolor sit ame.asfr huif nfef afeg egww","ratings":"2","isAirConditioned":"0","isBuffetAvailable":"0"},{"hallName":"Class 2","seating":"2000","floating":"3000","carCapacity":"500","bikeCapacity":"1000","rooms":"10","vegPrice":"550","nonVegPrice":"850","shortDescription":"Class 2 Style Halls","detailDescription":"This has a greater and better ambience provided.","ratings":"5","isAirConditioned":"1","isBuffetAvailable":"1"}],"menus":[{"items":[{"itemName":"Soup","types":["Veg Sour","Tomato","Corn","Potato","Cauliflower"]},{"itemName":"Rice","types":["Veg Pulao","Sambhar Rice","Veg Biriyani","Brinje"]},{"itemName":"SideDishes","types":["Aloo masala","Cauliflower Aaloo","Paneer butter Masala"]}],"menuTitle":"Veg Tamil Nadu","price":"1000"},{"items":[{"itemName":"Biriyani","types":["Chicken","Mutton","Fish","Prawn"]},{"itemName":"Fry","types":["Chicken Tandoori","Mutton Chops","Fish Finger","Chicken Lollipop"]}],"menuTitle":"Non Veg TamilNadu","price":"2000"}],"shortVenueDetails":{"name":"Alexander odaya Mandapam","address":"23/8,10th Street Vinobhaji Nagar,Hasthinapuram,Chennai - 74","shortDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!!","seating":"2000","floating":"3000","otherHighlights":[{"category":"Music Allowed Late","isAvailable":"1"},{"category":"Decor Provided by the Venue","isAvailable":"1"},{"category":"Halls are Air Conditioned","isAvailable":"1"},{"category":"Ample Parking","isAvailable":"1"}],"vegPrice":"500","nonVegPrice":"800","state":"TamilNadu","city":"Chennai","area":"Hasthinapuram"},"name":"Alexander odaya Mandapam","numOfHalls":"1","venueRent":"100000","vegPrice":"500","nonVegPrice":"800","shortDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!!","detailDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!! Super Mandapam, Ac lam iruku","historyOfBooking":"10","budget":"high","state":"TamilNadu","city":"Chennai","area":"Hasthinapuram","featureTitle":"PRICING DETAILS AND NOTES","featureDescr":"Pricing details of all the features provided my namba Ambi oda mandapam","vendorName":"R Dhanasekars KD Services","vendorType":"Contractor","primaryMobile":"9884332369","secondaryMobile":"9962532369","percentageCommission":"100","overallRatings":"5","isUsingVendorApp":"1","address":"23/8,10th Street Vinobhaji Nagar,Hasthinapuram,Chennai - 74"}');
            //_.forEach($scope.venueView.hall, function (hallItem) {
            //    if (parseInt(hallItem.seating) > parseInt(maxSeating))
            //        maxSeating = hallItem.seating;
            //    if (parseInt(hallItem.floating) > parseInt(maxFloating))
            //        maxFloating = hallItem.floating;
            //})
            $location.path('/ViewVenue');
       
        }
        )}


    function validate()
    {
        $scope.validationPassed = true;
        var alphaNumericRegex = /^[a-zA-Z0-9 ',.\-]+$/;
        var numericRegex = /^[0-9]+$/;
        var alphabeticRegex = /^[a-zA-Z ',.\-]+$/;
        var prevValPassed = false;
        $('[lb-required]').each(function () {
            if ($(this).val().trim() == "") {
                $(this).addClass('requiredErrorBorder')
                $(this).parent().find('.required').text("This field is required");
                $(this).parent().find('.required').show();
                $scope.validationPassed = $scope.validationPassed && false;

            }
            else {
                $(this).removeClass('requiredErrorBorder')
                $(this).parent().find('.required').text("");
                $(this).parent().find('.required').hide();
                $scope.validationPassed = $scope.validationPassed && true;
            }
        })
        $('[lb-alphanumeric]').each(function () {
            if (!alphaNumericRegex.test($(this).val().trim()) && !$(this).val().trim() == "") {
                $(this).addClass('alphanumericErrorBorder')
                $(this).parent().find('.alphanumeric').text("This field should contain only alphanumeric characters");
                $(this).parent().find('.alphanumeric').show();
                $scope.validationPassed = $scope.validationPassed && false;

            }
            else {
                $(this).removeClass('alphanumericErrorBorder')
                $(this).parent().find('.alphanumeric').text("");
                $(this).parent().find('.alphanumeric').hide();
                $scope.validationPassed = $scope.validationPassed && true;
            }
        })
        $('[lb-numeric]').each(function () {
            if (!numericRegex.test($(this).val().trim()) && !$(this).val().trim() == "") {
                $(this).addClass('numericErrorBorder')
                $(this).parent().find('.numeric').text("This field should contain only numeric characters");
                $(this).parent().find('.numeric').show();
                $scope.validationPassed = $scope.validationPassed && false;

            }
            else {
                $(this).removeClass('numericErrorBorder')
                $(this).parent().find('.numeric').text("");
                $(this).parent().find('.numeric').hide();
                $scope.validationPassed = $scope.validationPassed && true;
            }
        })
        $('[lb-alphabetic]').each(function () {
            if (!alphabeticRegex.test($(this).val().trim()) && !$(this).val().trim() == "") {
                $(this).addClass('alphabeticErrorBorder')
                $(this).parent().find('.alphabetic').text("This field should contain only alphabetic characters");
                $(this).parent().find('.alphabetic').show();
                $scope.validationPassed = $scope.validationPassed && false;

            }
            else {
                $(this).removeClass('alphabeticErrorBorder')
                $(this).parent().find('.alphabetic').text("");
                $(this).parent().find('.alphabetic').hide();
                $scope.validationPassed = $scope.validationPassed && true;
            }
        })
    }




}])