(function(app){
    app.factory('OrderService', ['$resource','ServiceUrl',
    function($resource, ServiceUrl){
        var url = ServiceUrl+'v1/order/'
        
        return {
            getAllOrders: function(){
                return $resource(url).query()
            },
            getOrder: function(id, callback){
                return $resource(url+':id').get({id:id}, callback)
            }
        }

    }])
})(app)