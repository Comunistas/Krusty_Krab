(function(app) {
    app.factory('OrderService', ['$resource', 'ServiceUrl', 'CurrentUserService',

        function($resource, ServiceUrl, CurrentUserService) {

            var url = ServiceUrl+'v1/order/'

            return {
                createOrder: function(tableId, callback){
                    var resource =  $resource(url+"new/:tableId/:employeeId", 
                    {employeeId:CurrentUserService.getEmployeeId()})
                    return resource.get({tableId}, callback);
                },
                
                addDishToOrder: function(tableId, dish, amount, callback){
                    return $resource(url+"add-dish/:tableId").save({tableId:tableId,amount:amount}, dish, callback)
                },

                removeDishFromOrder: function(tableId, dishId, amount, callback){
                    return $resource(url+"remove-dish/:tableId/:dishId").get({tableId:tableId, dishId:dishId, amount:amount}, callback)
                },
                
                saveOrder: function(tableId,callback) {
                    return $resource(url+"save/:tableId").get({tableId:tableId}, callback)
                },

                deleteOrder: function(tableId,callback){
                    return $resource(url+"delete/:tableId").query({tableId:tableId}, callback)
                },

                getOrderForTable: function(tableId,callback){
                    return $resource(url+"cart/:tableId").get({tableId:tableId})
                }
            };
        }
    ])
})(app)