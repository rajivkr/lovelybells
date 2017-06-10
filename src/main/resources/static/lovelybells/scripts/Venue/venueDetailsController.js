/**
 * 
 */
app.controller('VenueDetailsController', ['$scope', 'VenueService','$location','$timeout', function ($scope, VenueService,$location,$timeout) {
	

	
	$scope.intializePage = function(){
    	
		console.log('testme');
		 $timeout(function(){
			 jQuery('#camera_wrap_1').camera({
		  			thumbnails: true
		  	      });
		      	
		  		jQuery('#camera_wrap_2').camera({
		  			height: '400px',
		  			loader: 'bar',
		  			pagination: false,
		  			thumbnails: true
		  		});
			 
		 }, 500);
   	 
		
    
    };
    VenueService.getFullVenue(VenueService.getVenueId()).then(function (data) {
        $scope.venue= data;
    });
	   
	 
}])