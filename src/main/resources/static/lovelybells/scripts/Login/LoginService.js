app.factory('LoginService', function ($http, $log, $q) {
    return {
        
        submitLogin: function (loginViewModel) {
            var deferred = $q.defer();
            var config = {
                headers: {
                    'Content-Type': 'application/json',
                     'dataType'   : 'json'
                }
            }
            var data = {
                loginViewModel: loginViewModel,
            };
            $http.post(root + '/Admission/SaveStudent', data, config)// replace it with the required URL
        .success(function (data, status, headers, config) {
            deferred.resolve(data);
        })
        .error(function (data, status, header, config) {
            deferred.reject(data);
        });

            return deferred.promise;
        }
    }
});