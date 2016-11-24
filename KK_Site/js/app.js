var app = (function(){
	app = angular.module('appModule', ['ui.bootstrap', 'ngRoute', 'ngResource']);
	var routeConfig = function($routeProvider){
		$routeProvider
			.when('/', {
				templateUrl: 'views/home.html',
				controller: 'homeCtrl'
			})
			.when('/home',{
				templateUrl: 'views/welcome.html',
				controller: 'welcomeCtrl'
			})
			.when('/dishes',{
				templateUrl: 'views/dish-all.html',
				controller: 'dishesCtrl'
			})
			.when('/dish',{
				templateUrl: 'views/dish-detail.html',
				controller: 'dishCtrl'
			})
			.otherwise({
				redirectTo: '/'
			});
	}
	app.config(routeConfig);
	return app
})()

