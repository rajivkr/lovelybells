app.controller('VenueController', ['$scope', 'VenueService','$location','$timeout',function ($scope, VenueService,$location,$timeout) {
	
	$scope.venueList=[]; 
	$scope.order="-added";
	$scope.start=0;
	$scope.end=3;
	$scope.regionFilter=function(region){
		$scope.regionOnly=region;
	}; 
	VenueService.getVenues().then(function (data) {
	        $scope.venueList = data;	      
	        $scope.pageArray=new Array(Math.ceil($scope.venueList.length/3));
			$scope.pageValue=function(num){
			 $scope.end=num*3;
			 $scope.start=$scope.end-3;
			
			}
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
		
		
		
		 $scope.budgetFilter=function(venue)
		 {
			 
			 
			 return true;
			
			 
		 }
		
		 
}])
 

