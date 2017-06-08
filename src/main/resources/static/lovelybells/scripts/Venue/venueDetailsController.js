/**
 * 
 */
app.controller('VenueDetailsController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {
	

	VenueService.getFullVenue(VenueService.getVenueId()).then(function (data) {
        $scope.venue= data;
        $scope.intializePage = function(){
        	
        	$(document).ready(function() {
        		 tabModule.init();
                $('#example1').gentleSelect({ 
                    columns: 3,
                    itemWidth: 100,
                    title: "Select a fruit",
        	    hideOnMouseOut: true
                });
        		 $('#example3').gentleSelect({ 
                    columns: 3,
                    itemWidth: 100
                });
        		 
              });
        
        
        	
        
        };
        
      
        
    })
	   
	 
}])