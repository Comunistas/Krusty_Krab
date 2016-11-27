(function(app){
	app.controller('crudCtrl',
		['$scope', '$routeParams', 'CrudService',
		function($scope,$routeParams, CrudService){
			
			var Entity = CrudService.Entity
			var entityType = $scope.entityType
			var current = $scope.currentEntity

			$scope.$on('$viewContentLoaded', () => {
				$scope.entities = Entity(entityType).query()
			})

``
			var success = function(data){
					console.log('Response is an instance of : ' + entityType + (data instanceof Entity))
					EntityService.setCurrentEntity(data)
					current = Service.getCurrentEntity()
			}

			var getEntity = function(id) {
				Entity.get({id:id}, success)
			}

			var saveEntity = function() {

				var success = function(data) {
					$scope.message = entityType + ' saved!'
					$scope.Entity = data
				}

				var error = function(err) {
					$scope.err = 'An error ocurred trying to save an entity of type ' + entityType
				}

				$scope.Entity.$save({id:0}).then(success, error)
			}

		}])

})(app)