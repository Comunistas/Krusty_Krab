(function (app) {
	app.service('DishService', 
		['$resource','ServiceUrl', 
		function($resource, ServiceUrl) {
			/* This is a Dish query object, created to get 
			 * an array of dishes or a single dish:
			 * .get({}, successCb, errorCb) for all the dishes,
			 * .query({id: @id}, successCb, errorCb) for a single dish
			 * .save() or aDish.$save(successCb, errorCb) for a save
			 * .update() or aDish.$update(successCb, errorCb) for an update
			 */
			var Dish = $resource(ServiceUrl + 'v1/dishes/:id', {id:'@id'},
				{
				 	'update': {method: 'POST'},
				})
			
			var currentDish = null

			return {
				Dish:Dish,
				getCurrentDish: function() { return currentDish },
				setCurrentDish: function(dish) { currentDish = dish },
				removeCurrentDish: function() { currentDish = null },
				hasDish: function() { return !currentDish===null }
			}
	}])
})(app)