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
		$scope.err = $routeParams.err == 'undefined' ? '': $routeParams.err;
	}]);

app.controller('loginCtrl', 
	['$scope', '$location','LoginService',
	function($scope, $location, LoginService){
		$scope.user = {};
		var user = $scope.user;

		var err = "Error logging in."

		function success(){
			$location.path('/authenticated');
		}

		function error(){
			console.log('I\'m on error.')
			$location.path('/').search({err: err});
		}

		function authenticate(){
			LoginService.authenticate({}, user, success, error);
		}

		$scope.validate = authenticate
	}]);