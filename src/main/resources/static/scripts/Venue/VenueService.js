app.factory('VenueService', function ($http, $log, $q) {
    var savedData = {};
    return {
        
        addVenue: function (venueViewModel) {
            var deferred = $q.defer();
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
            /* var data = {
                 venue: venueViewModel
             };*/
            /*var data={
            		"name":"a",
            		"numOfHalls":2
            		};*/
            $http.post('/venue', venueViewModel, config)// replace it with the required URL
        .success(function (data, status, headers, config) {
            deferred.resolve(data);
        })
        .error(function (data, status, header, config) {
            deferred.reject(data);
        });

            return deferred.promise;
        },
        getVenues: function () {
            var deferred = $q.defer();
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
            /* var data = {
                 venue: venueViewModel
             };*/
            /*var data={
            		"name":"a",
            		"numOfHalls":2
            		};*/
            $http.get('/venue', config)// replace it with the required URL
        .success(function (data, status, headers, config) {
            deferred.resolve(data);
        })
        .error(function (data, status, header, config) {
            deferred.reject(data);
        });

            return deferred.promise;
        },
        getFullVenue: function (id) {
            var deferred = $q.defer();
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
            /* var data = {
                 venue: venueViewModel
             };*/
            /*var data={
            		"name":"a",
            		"numOfHalls":2
            		};*/
            $http.get('/venue/'+id, config)// replace it with the required URL
        .success(function (data, status, headers, config) {
            deferred.resolve(data);
        })
        .error(function (data, status, header, config) {
            deferred.reject(data);
            });
            //var data = JSON.parse('{"featureValues":[{"featureCategoryTitle":"Rentals","featureCategoryValues":[{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"Rental Notes","featureSubCategoryValue":"F&B prices are inclusive of rental charges."}]},{"featureCategoryTitle":"Corkage, DJ & Decorations","featureCategoryValues":[{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"Corkage costs if liquor allowed","featureSubCategoryValue":"Corkage does not apply"},{"subFeatureCategoryTitle":"","subFeatureCategoryValue":"","featureSubCategoryTitle":"DJ costs starts at","featureSubCategoryValue":"Rs.36000"}]}],"otherHighlights":[{"category":"Music Allowed Late","isAvailable":"1"},{"category":"Decor Provided by the Venue","isAvailable":"1"},{"category":"Halls are Air Conditioned","isAvailable":"1"},{"category":"Ample Parking","isAvailable":"1"}],"halls":[{"hallName":"Class 1","seating":"1000","floating":"2000","carCapacity":"100","bikeCapacity":"200","rooms":"5","vegPrice":"150","nonVegPrice":"350","shortDescription":"Class 1 Style Hall","detailDescription":"Class 1 Style Hall in Detail Lorem ipsum Dolor sit ame.asfr huif nfef afeg egww","ratings":"2","isAirConditioned":"0","isBuffetAvailable":"0"},{"hallName":"Class 2","seating":"2000","floating":"3000","carCapacity":"500","bikeCapacity":"1000","rooms":"10","vegPrice":"550","nonVegPrice":"850","shortDescription":"Class 2 Style Halls","detailDescription":"This has a greater and better ambience provided.","ratings":"5","isAirConditioned":"1","isBuffetAvailable":"1"}],"menus":[{"items":[{"itemName":"Soup","types":["Veg Sour","Tomato","Corn","Potato","Cauliflower"]},{"itemName":"Rice","types":["Veg Pulao","Sambhar Rice","Veg Biriyani","Brinje"]},{"itemName":"SideDishes","types":["Aloo masala","Cauliflower Aaloo","Paneer butter Masala"]}],"menuTitle":"Veg Tamil Nadu","price":"1000"},{"items":[{"itemName":"Biriyani","types":["Chicken","Mutton","Fish","Prawn"]},{"itemName":"Fry","types":["Chicken Tandoori","Mutton Chops","Fish Finger","Chicken Lollipop"]}],"menuTitle":"Non Veg TamilNadu","price":"2000"}],"shortVenueDetails":{"name":"Alexander odaya Mandapam","seating":"2000","floating":"3000","address":"23/8,10th Street Vinobhaji Nagar,Hasthinapuram,Chennai - 74","shortDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!!","otherHighlights":[{"category":"Music Allowed Late","isAvailable":"1"},{"category":"Decor Provided by the Venue","isAvailable":"1"},{"category":"Halls are Air Conditioned","isAvailable":"1"},{"category":"Ample Parking","isAvailable":"1"}],"vegPrice":"500","nonVegPrice":"800","state":"TamilNadu","city":"Chennai","area":"Hasthinapuram"},"name":"Alexander odaya Mandapam","seating":"2000","floating":"3000","numOfHalls":"1","venueRent":"100000","vegPrice":"500","nonVegPrice":"800","shortDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!!","detailDescr":"Mandapam Situated at Hasthinapuram With Good Ambience da ambii!!! Super Mandapam, Ac lam iruku","historyOfBooking":"10","budget":"high","state":"TamilNadu","city":"Chennai","area":"Hasthinapuram","featureTitle":"PRICING DETAILS AND NOTES","featureDescr":"Pricing details of all the features provided my namba Ambi oda mandapam","vendorName":"R Dhanasekars KD Services","vendorType":"Contractor","primaryMobile":"9884332369","secondaryMobile":"9962532369","percentageCommission":"100","overallRatings":"5","isUsingVendorApp":"1","address":"23/8,10th Street Vinobhaji Nagar,Hasthinapuram,Chennai - 74"}');
            //deferred.resolve(data);

            return deferred.promise;
        },
        submit: function (uploadViewModel) {
            var deferred = $q.defer();
            var config = {
                headers: {
                    'Content-Type': 'application/json',
                    'dataType': 'json'
                }
            }
            var data = {
                uploadViewModel: uploadViewModel,
            };
            $http.post('/Admission/SaveStudent', data, config)// replace it with the required URL
        .success(function (data, status, headers, config) {
            deferred.resolve(data);
        })
        .error(function (data, status, header, config) {
            deferred.reject(data);
        });

            return deferred.promise;
        },
        setSavedData: function (data) {
            savedData = data;
        },
        getSavedData: function () {
            return savedData;
        }
    }
});