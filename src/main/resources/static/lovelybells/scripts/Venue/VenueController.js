app.controller('VenueController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {
	
	 VenueService.getVenues().then(function (data) {
	        $scope.venueList = data;
	        console.log(data)
	    })
}])