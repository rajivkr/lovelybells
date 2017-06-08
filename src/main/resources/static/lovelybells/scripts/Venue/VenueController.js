app.controller('VenueController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {
	
	$scope.venueList=[]; 
	$scope.order="-added";
	console.log($scope.order);
	$scope.regionFilter=function(region){
		$scope.regionOnly=region;
	}; 
	VenueService.getVenues().then(function (data) {
	        $scope.venueList = data;
	        $scope.states = _.uniqBy($scope.venueList, function (venue) {
	    	    return venue.state;
	        });
	    })
	    /*$scope.states = _.uniqBy($scope.venueList, function (venue) {
	    return venue.state;
        });*/
	    
		$scope.setVenueID=function(venueId)
		{
		
		VenueService.setVenueId(venueId);
		$location.path('/VenueDetails');
		};
	   
	 
}])