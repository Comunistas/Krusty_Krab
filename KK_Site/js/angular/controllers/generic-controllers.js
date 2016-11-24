app.controller('bodyCtrl', 
	['$scope','TitleService', 
	function ($scope, TitleService) {
		TitleService.setTitle('ma New Title')

		//Service to change the title of the page
		$scope.setTitle = TitleService.setTitle
	}])

app.controller('navCtrl',
	['$scope','$rootScope','TitleService',
	function ($scope, $rootScope, TitleService) {

		// 'v' - visitor, 'e' - employee, 'c' - client
		$rootScope.role = 'v'

		$rootScope.$watch('role', function (newVal, oldVal) {
			setDefaultActive(newVal)
		})

		var pages = {
			'v_home': [false, 'Home'],
			'v_about': [false, 'About Us'],
			'v_contact': [false, 'Contact Us'],
			'e_home': [false, 'Home'],
			'e_dishes': [false, 'Meals'],
			'e_dish_input': [false, 'Dish inputs'],
			'e_buy_order': [false, 'Buy Order'],
			'e_provider': [false, 'Providers']
		}

		$scope.setActive = function(itemName){
			cleanPages()
			pages[itemName][0] = true
			TitleService.setTitle(pages[itemName][1])
		}

		function cleanPages(){
			for(var page in pages){
				pages[page][0] = false
			}
		}

		function setDefaultActive(role){

			cleanPages()
			
			//TODO client-side
			if(role=='v'){
				pages['v_home'][0] = true
			}else{
				pages['e_home'][0] = true
			}
		}

		function clickLogo(){
			//TODO redirect to home page, based on role.
		}

		$scope.pages = pages
	}])

app.controller('homeCtrl', [
	'$scope', '$routeParams',
	function ($scope, $routeParams) {
		$scope.err = $routeParams.err
	}])

app.controller('loginCtrl', 
	['$scope', '$location','LoginService', 'CurrentUserService', '$rootScope',
	function ($scope, $location, LoginService, CurrentUserService, $rootScope) {
		$scope.user = {}
		var user = $scope.user

		var err = "Error logging in."

		var success = function (userResponse) {
			if(userResponse.authenticated){
				var user = userResponse.user
				user.authenticated = true

				CurrentUserService.setUser(user)
				$rootScope.role = 'e'

				$location.path('/home')
			}else{
				$location.path('/').search({err: err})
			}
		}

		var error = function (data) {
			$location.path('/').search({err: err})
		}

		var logOut = function () {
			CurrentUserService.setUser(null)
			$rootScope.role = 'v'
			$location.path('/')
		}

		// Service methods
		var authenticate = function (){
			LoginService.authenticate(user, success, error)
		}

		$scope.validate = authenticate
		$scope.logOut = logOut
	}])

app.controller('welcomeCtrl', 
	['$scope', '$location', 'CurrentUserService', 
	function ($scope, $location, CurrentUserService) {

		$scope.$on('$viewContentLoaded', ()=>{
			var user = CurrentUserService.getUser()
			if(user === null){
				goHome()
			}else if(user.authenticated){
				$scope.user = user
			} else {
				goHome()
			}
			
		})

		function goHome(){
			$location.path('/')
		}

	}])