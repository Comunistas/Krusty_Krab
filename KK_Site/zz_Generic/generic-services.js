app.factory('ServiceUrl', [function() {

    //Preferrable to be absolute
    var serviceHostUrl = 'http://localhost'

    //set -1 or minor if want to use a default port.
    var port = 8000;

    function serviceUrl() {
        if (port < 0) {
            return serviceHostUrl + '/';
        } else {
            return serviceHostUrl + ":" + port + "/"
        }
    }

    return serviceUrl();
}]);

app.factory('CurrentUserService', [function() {

    var user = null;

    return {
        getUser: function() { return user },
        getEmployeeId: function(){ return user.employee.id },
        setUser: function(newUser) { user = newUser },
        getRole: function() { return user.userType }
    }
}]);

app.factory('LoginService', ['$resource', 'ServiceUrl', function($resource, ServiceUrl) {

    var resource = $resource(ServiceUrl + 'v1/usuarios/login', { /*Default params*/ }, {
        'authenticate': {
            /*new type of method, just using another name, for better understanding*/
            method: 'POST'
        }
    })

    return {
        authenticate: function(user, successCb, errorCb) {
            resource.authenticate({}, user, successCb, errorCb)
        }
    }
}]);