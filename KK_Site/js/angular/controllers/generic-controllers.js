app.controller('bodyCtrl', 
	['$scope','TitleService', 
	function($scope, TitleService){
		TitleService.setTitle('ma New Title');

		//Service to change the title of the page
		$scope.setTitle = TitleService.setTitle;
	}]);

app.controller('navCtrl',
	['$scope', 
	function($scope){

		var pages = {
			'home': false,
			'about': false,
			'contact': false
		}

		pages['home'] = true;

		$scope.setActive = function(itemName){
			cleanPages();
			pages[itemName] = true;
		}

		function cleanPages(){
			for(var page in pages){
				pages[page] = false;
			}
		}

		$scope.pages = pages;

	}]);

app.controller('homeCtrl', [
	'$scope', '$routeParams',
	function($scope, $routeParams){
		$scope.err = $routeParams.err;
	}]);

app.controller('loginCtrl', 
	['$scope', '$location','LoginService', 'currentUserService',
	function($scope, $location, LoginService, currentUserService){
		$scope.user = {};
		var user = $scope.user;

		var err = "Error logging in."

		function success(userResponse){
			if(userResponse.authenticated){
				currentUserService.setUser(userResponse.usuario)
				$location.path('/authenticated');
			}else{
				$location.path('/').search({err: err});
			}
		}

		function error(data){
			$location.path('/').search({err: err});
		}

		function authenticate(){
			LoginService.authenticate({}, user, success, error);
		}

		$scope.validate = authenticate
	}]);

app.controller('welcomeCtrl', 
	['$route', 'currentUserService', 
	function($route, currentUserService){ 
		$route.user = currentUserService.getUser();
	}]);