app.controller('LoginController', ['$scope', 'LoginService', function ($scope, LoginService) {
     $scope.SubmitLogin = function () {
        LoginService.submitLogin($scope.loginViewModel).then(function (data) {
            alert(data);
        })

    };
}])