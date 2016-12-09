var app = (function() {
    app = angular.module('appModule', ['ui.bootstrap', 'ngRoute', 'ngResource']);
    app.config(function($routeProvider) {
        $routeProvider
            .when('/', {
                title: 'Login',
                templateUrl: 'zz_Generic/home.html',
                controller: 'homeCtrl'
            })
            .when('/home', {
                title: 'Home',
                templateUrl: 'zz_Generic/welcome.html',
                controller: 'welcomeCtrl',
            })
            .when('/dishes', {
                title: 'Dishes',
                templateUrl: 'dish/dish-all.html',
                controller: 'dishesCtrl'
            })
            .when('/dish', {
                title: 'Dish',
                templateUrl: 'dish/dish-detail.html',
                controller: 'dishCtrl',
            })
            .when('/order-new', {
                title: 'New Order',
                templateUrl: 'order/order-register.html',
                controller: 'orderCtrl',
            })
            .otherwise({
                redirectTo: '/'
            })
    })

    app.run(['$rootScope', '$route',
        function($rootScope, $route) {
            $rootScope.$on('$routeChangeSuccess', function() {
                document.title = $route.current.title
            });
        }
    ])


    return app
})()