app.controller('VenueController', ['$scope', 'VenueService','$location','$timeout',function ($scope, VenueService,$location,$timeout) {
	
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
		
		$scope.venueCompare=[];
		$scope.checkValue=function(venue,val)
		{
			if(!val)
			{
				
				var index=$scope.venueCompare.indexOf(venue);
				
				$scope.venueCompare.splice(index,1);
			}
			else
			{
			$scope.venueCompare.push(venue);
			
			}
			
			
		}
		
		
		 var s3 = $("#ranged-value").freshslider({
		        range: true,
		        step:1,
		        value:[0, 100],
		       onchange:function(low, high){
		    	   $scope.minValue=low;
		    	   $scope.maxValue=high;
		    	   $timeout(function() {
		    		   $scope.minValue=low;
			    	   $scope.maxValue=high;
		    		 }, 200);
		    	  console.log($scope.minValue+" "+$scope.maxValue);
		    	   
		           
		        }
		    });
		 $scope.budgetFilter=function(venue)
		 {
			 console.log(venue.venueRent);	
			 
			 return true;
			
			 
		 }
		 
}])
 

