var app = angular.module('bells', ['ngRoute']);
app.config(['$routeProvider','$locationProvider',
    function ($routeProvider,$locationProvider) {
        $routeProvider.
            when('/Venue', {
                templateUrl: 'Venue.html',
            }).
         when('/VenueList', {
         templateUrl: 'venues.html'
         }).
         when('/ViewVenue', {
             templateUrl: 'ViewVenue.html'
         }).
         when('/VenueDetails', {
             templateUrl: 'venueDetails.html',
             css: 'css/camera.css'
         }).
         when('/', {
             templateUrl: 'index.html',
         })
        // otherwise({
        // redirectTo: '/Custome////rs/AddNewCustomer'
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