var app = angular.module('bells', ['ngRoute']);
app.config(['$routeProvider','$locationProvider',
    function ($routeProvider,$locationProvider) {
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
         }).
         when('/VenueDetails', {
             templateUrl: 'venueDetails.html',
             controller: 'VenueDetailsController',
             css: 'css/camera.css'
         }).
         when('/', {
             templateUrl: 'index.html',
             controller: 'indexController'
         })
        // otherwise({
        // redirectTo: '/Customers/AddNewCustomer'
        //})
         $locationProvider.html5Mode(false);
    }]);
app.directive('onFinishRender', function ($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
                    scope.$emit(attr.onFinishRender);
                    appMaster.smoothScroll();

                    appMaster.reviewsCarousel();

                    appMaster.screensCarousel();

                    appMaster.animateScript();

                    appMaster.revSlider();

                    appMaster.scrollMenu();

                    appMaster.placeHold();
                },500);
            }
        }
    }
})