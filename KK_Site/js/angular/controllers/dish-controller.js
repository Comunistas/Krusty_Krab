(function (app) {
	app.controller('dishesCtrl', 
		['$scope', 'DishService',
		function($scope, DishService) {
			var Dish = DishService.Dish

			$scope.$on('$viewContentLoaded', () => {
				$scope.dishes = Dish.query()
			})
	}])

	app.controller('dishCtrl',
		['$scope', '$routeParams','DishService',
		function($scope, $routeParams, DishService){

			var Dish = DishService.Dish
			var id

			$scope.$on('$viewContentLoaded', () => {
				console.log('I\'m in viewContentLoaded')
				id = $routeParams.id
				getDish(id)
				console.log('This is the id: '+id)
			})

			var shit = function(data){
					console.log('Response is an instance of Dish : ' + (data instanceof Dish))
					DishService.setCurrentDish(data)
					$scope.dish = DishService.getCurrentDish()
				}

			var getDish = function(id) {
				Dish.get({id:id}, shit)
			}

			var saveDish = function() {

				var success = function(data) {
					$scope.message = 'Yuppy!'
					$scope.dish = data
				}

				var error = function(err) {
					$scope.err = 'Damn'
				}

				$scope.dish.$save({id:0}).then(success, error)
			}
	}])
})(app);