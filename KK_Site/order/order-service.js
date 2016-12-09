(function(app) {
    app.factory('OrderService', ['$resource', 'ServiceUrl', 'CurrentUserService',

        function($resource, ServiceUrl, CurrentUserService) {

            var url = ServiceUrl+'v1/order/'

            return {
                createOrder: function(tableId, callback){
                    var resource =  $resource(url+"new/:tableId/:employeeId", 
                    {tableId:tableId,employeeId:CurrentUserService.getEmployeeId()})
                    return resource.get({}, callback);
                },
                
                addDishToOrder: function(dish, tableId, callback){
                    return $resource(url+"add-dish/:tableId").save({}, dish, callback)
                },
                
                saveOrder: function(tableId) {
                    return $resource(url+"save/:tableId").get({},callback)
                },

                deleteOrder: function(tableId){
                    return $resource(url+"delete/:tableId").query({},callback)
                }
            };
        }
    ])
})(app)