app.factory('TitleService', [function(){
	return {
		setTitle: function(newTitle){document.title = newTitle}
	};
}]);

app.factory('LoginService', ['$resource', function($resource){
	return $resource('v1/usuarios/login', {}, 
		{'authenticate': {
			method:'POST'
		}
	});
}]);