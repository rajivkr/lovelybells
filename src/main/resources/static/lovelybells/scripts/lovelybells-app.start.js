var app = angular.module('bells', ['ngRoute']);
app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/Venue', {
                templateUrl: 'Venue.html',
                controller: 'VenueController'
            }).
         when('/VenueList', {
         templateUrl: 'venues.html',
         controller: 'VenueController'
         }).
         when('/ViewVenue', {
             templateUrl: 'ViewVenue.html',
             controller: 'VenueController'
         })
        // otherwise({
        // redirectTo: '/Customers/AddNewCustomer'
        //})
        ;
    }]);