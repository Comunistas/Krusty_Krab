(function(app) {
    app.controller('orderCtrl', [
        '$scope', 'OrderService', 'CrudService',
        function($scope, OrderService, CrudService) {
            $scope.order = {}


        }
    ])
})(app)