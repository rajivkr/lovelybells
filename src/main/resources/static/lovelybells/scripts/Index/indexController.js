app.controller('indexController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {
	
$scope.intializePage = function(){
	
	tabModule.init();
		 $('#example3').gentleSelect({ 
          columns: 3,
          itemWidth: 100
      });
		 
		
}

/*VenueService.getVenues().then(function (data) {
    $scope.venues = data;
})*/


$scope.$on('ngRepeatFinished', function(ngRepeatFinishedEvent) {
        	appMaster.smoothScroll();

            appMaster.reviewsCarousel();

            appMaster.screensCarousel();

            appMaster.animateScript();

            appMaster.revSlider();

            appMaster.scrollMenu();

            appMaster.placeHold();
        });

var venues1=[
	{vname:"mani mandapam",varea:"porur",vcity:"chennai",imgPath:"images/gallery/g1.jpg",rating:4},
	{vname:"namitha mandapam",varea:"parrys",vcity:"chennai",imgPath:"images/gallery/g2.jpg",rating:4},
	{vname:"anushka rajiv mandapam",varea:"mount road",vcity:"chennai",imgPath:"images/gallery/g3.jpg",rating:4},
	{vname:"alex priya mandapam",varea:"m.k.b.nagar",vcity:"chennai",imgPath:"images/gallery/g4.jpg",rating:5},
	{vname:"aravind malu mandapam",varea:"thiruvanmiyur",vcity:"chennai",imgPath:"images/gallery/g5.jpg",rating:3},
	{vname:"nanda mahal",varea:"vadapalani",vcity:"chennai",imgPath:"images/gallery/g6.jpg",rating:3}
	];
	$scope.venues1=venues1;
	$scope.msg="nadna";
	$scope.vFilter="all";
	$scope.stars=function(nstars)
	{
		return new Array(nstars);
	};
	$scope.best=function(venue)
	{
		if($scope.vFilter=='all')
		return true;
		if(venue.rating >=4)
		return true;
	return false;
	
	};
	$scope.setVF=function(fil)
	{
		$scope.vFilter=fil;
	};
}])