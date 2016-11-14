var app = angular.module('appModule', ['ui.bootstrap', 'ngRoute', 'ngResource']);

app.config(routeConfig);

function routeConfig($routeProvider){
	$routeProvider
		.when('/', {
			templateUrl: 'views/home.html',
			controller: 'homeCtrl'
		})
		.when('/authenticated',{
			templateUrl: 'views/welcome.html',
			controller: 'welcomeCtrl'
		});
}