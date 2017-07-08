/**
 * 
 */
app.controller('VenueDetailsController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {


	$scope.venue1="nanda";
	VenueService.getFullVenue(VenueService.getVenueId()).then(function (data) {
        $scope.venue= data;
       
        
      console.log($scope.venue);
        
    });
	$scope.intializePage = function(){
		
		tabModule.init();
		
		$(document).scrollTop(0);
			
			 
			
	}
	
	
	$scope.locationValue="pooju";
	$scope.locationChange=function(event)
	{
		
		console.log(event.target.innerHTML);
		$scope.locationValue=event.target.innerHTML;
	}
	   
	 
}])