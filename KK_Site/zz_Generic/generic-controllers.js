(function(app) {
    app.controller('navCtrl', ['$scope', '$rootScope',
        function($scope, $rootScope) {

            $rootScope.$watch('role', function(newVal, oldVal) {
                setDefaultActive(newVal)
            })

            var pages = {
                'm_home': false,
                'm_about': false,
                'm_contact': false,
                'a_home': false,
                'a_dishes': false,
                'a_dish_input': false,
                'a_buy_order': false,
                'a_provider': false
            }

            $scope.setActive = function(itemName) {
                cleanPages()
                pages[itemName] = true
            }

            function cleanPages() {
                for (var page in pages) {
                    pages[page] = false
                }
            }

            function setDefaultActive(role) {

                cleanPages()

                //TODO client-side
                if (role == 'm') {
                    pages['m_home'] = true
                } else {
                    pages['a_home'] = true
                }
            }

            function clickLogo() {
                //TODO redirect to home page, based on role.
            }

            $scope.pages = pages
        }
    ])

    app.controller('homeCtrl', [
        '$scope', '$routeParams',
        function($scope, $routeParams) {
            $scope.err = $routeParams.err
        }
    ])

    app.controller('loginCtrl', ['$scope', '$location', 'LoginService', 'CurrentUserService', '$rootScope',
        function($scope, $location, LoginService, CurrentUserService, $rootScope) {
            document.getElementById('txtUser').focus();
            $scope.user = {}
            $scope.err = $location.search().err
            var user = $scope.user

            var err = "Error logging in."

            var success = function(userResponse) {
                if (userResponse.authenticated) {
                    var user = userResponse.user
                    user.authenticated = true

                    CurrentUserService.setUser(user)

                    $rootScope.role = CurrentUserService.getRole()
                    $rootScope.authenticated = true

                    $location.path('/home')
                } else {
                    $rootScope.authenticated = true
                    $location.path('/').search({ err: err })
                }
            }

            var error = function(data) {
                $location.path('/').search({ err: err })
            }

            var logOut = function() {
                CurrentUserService.setUser(null)
                $rootScope.role = undefined
                $rootScope.authenticated = false
                $location.path('/')
            }

            // Service methods
            var authenticate = function() {
                LoginService.authenticate(user, success, error)
            }

            $scope.validate = authenticate
            $scope.logOut = logOut
        }
    ])

    app.controller('welcomeCtrl', ['$scope', '$location', 'CurrentUserService',
        function($scope, $location, CurrentUserService) {

            $scope.$on('$viewContentLoaded', () => {
                var user = CurrentUserService.getUser()
                if (user === null) {
                    goHome()
                } else if (user.authenticated) {
                    $scope.user = user
                } else {
                    goHome()
                }
            })

            function goHome() {
                $location.path('/')
            }
        }
    ])
})(app);