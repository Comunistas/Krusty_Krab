var app = angular.module('appModule', ['ui.bootstrap', 'ngRoute', 'ngResource']);

app.config(routeConfig);

function routeConfig($routeProvider){
	$routeProvider
		.when('/', {
			templateUrl: 'views/home.html'
		})
		.when('/authenticated',{
			templateUrl: 'views/welcome.html'
		});
}