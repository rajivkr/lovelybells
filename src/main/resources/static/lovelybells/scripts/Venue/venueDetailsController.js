/**
 * 
 */
app.controller('VenueDetailsController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {


	$scope.venue1="nanda";
	VenueService.getFullVenue(VenueService.getVenueId()).then(function (data) {
        $scope.venue= data;
       
        
      console.log($scope.venue);
        
    });
	
	
	
	
	   
	 
}])