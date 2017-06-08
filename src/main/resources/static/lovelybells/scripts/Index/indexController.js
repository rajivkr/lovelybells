app.controller('indexController', ['$scope', 'VenueService','$location', function ($scope, VenueService,$location) {
	
$scope.intializePage = function(){
	
	tabModule.init();
		 $('#example3').gentleSelect({ 
          columns: 3,
          itemWidth: 100
      });
		 
		 appMaster.smoothScroll();

		    appMaster.reviewsCarousel();

		    appMaster.screensCarousel();

		    appMaster.animateScript();

		    appMaster.revSlider();

		    appMaster.scrollMenu();

		    appMaster.placeHold();
}
	 
}])