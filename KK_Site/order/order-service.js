(function(app) {
    app.factory('OrderService', ['$resource', 'ServiceUrl',

        function($resource, ServiceUrl) {

            var temporalResource = $resource(ServiceUrl + 'order/:id')
            var resource

            var saveDishForOrder = function() {

            }
            return null;
        }
    ])
})(app)