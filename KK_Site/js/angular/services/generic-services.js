app.factory('serviceUrl', [function(){

	//Preferrable to be absolute
	var serviceHostUrl = 'http://localhost'

	//set -1 or minor if want to use a default port.
	var port = 8000;

	function serviceUrl(){
		if(port<0) {
			return serviceHostUrl + '/';
		}else{
			return serviceHostUrl + ":" + port + "/"
		}
	}

	return serviceUrl();
}]);

app.factory('TitleService', [function(){
	return {
		setTitle: function(newTitle){document.title = newTitle}
	};
}]);

app.factory('currentUserService', [function(){

	var user = null;

	function getCurrentUser(){
		return user;
	}

	function setCurrentUser(newUser){
		user = newUser;
	}

	return {
		getUser: getCurrentUser,
		setUser: setCurrentUser
	}
}]);

app.factory('LoginService', ['$resource', 'serviceUrl', function($resource, serviceUrl){
	return $resource(serviceUrl + 'v1/usuarios/login', {/*Default params*/}, 
		{'authenticate': {
			/*new type of method, just using another name, for better understanding*/
			method:'POST'
		}
	});
}]);