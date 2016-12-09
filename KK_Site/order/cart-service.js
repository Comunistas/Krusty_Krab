(function(app) {
    app.factory('CartService', ['$resource', 'ServiceUrl', 'CurrentUserService',

        function($resource, ServiceUrl, CurrentUserService) {

            var url = ServiceUrl+'v1/order/'

            return {
                createCart: function(tableId, callback){
                    var resource =  $resource(url+"cart/new/:tableId/:employeeId", 
                    {employeeId:CurrentUserService.getEmployeeId()})
                    return resource.get({tableId}, callback);
                },

                getCartForTable: function(tableId,callback){
                    return $resource(url+"cart/:tableId").get({tableId:tableId})
                },
                
                addDishToCart: function(tableId, dish, amount, callback){
                    return $resource(url+"cart/add-dish/:tableId").save({tableId:tableId,amount:amount}, dish, callback)
                },

                removeDishFromCart: function(tableId, dishId, amount, callback){
                    return $resource(url+"cart/remove-dish/:tableId/:dishId").get({tableId:tableId, dishId:dishId, amount:amount}, callback)
                },
                
                saveCart: function(tableId,callback) {
                    return $resource(url+"cart/save/:tableId").get({tableId:tableId}, callback)
                },

                deleteCart: function(tableId,callback){
                    return $resource(url+"cart/delete/:tableId").query({tableId:tableId}, callback)
                },

                getAllCarts: function(){
                    return $resource(url+"cart/all").query()
                }
            };
        }
    ])
})(app)