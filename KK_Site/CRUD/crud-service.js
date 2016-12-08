(function(app){
	app.service('CrudService',
		['$resource', 'ServiceUrl',
		function($resource, ServiceUrl){
			/* This is a CRUD object, created to get 
			 * an array of entities or a single entity:
			 * .get({}, successCb, errorCb) for all the entities,
			 * .query({id: @id}, successCb, errorCb) for a single entity
			 * .save() or aDish.$save(successCb, errorCb) for a save
			 * .update() or aDish.$update(successCb, errorCb) for an update
			 */

			var Entity = function (entity) {
				return $resource(
					ServiceUrl + 'v1/' + entity + '/:id', {id:'@id'}, 
					{
						'update': {method:'POST'},
					})
			}
			
			var currentEntity = null

			return {
				Entity:Entity,
				getCurrentEntity: function() { return currentEntity },
				setCurrentEntity: function(entity) { currentEntity = entity },
				removeCurrentEntity: function() { currentEntity = null },
				hasEntity: function() { return !(currentEntity === null) }
			}
	}])

})(app);