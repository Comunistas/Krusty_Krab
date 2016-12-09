(function(app){
    app.controller('orderCtrl',['$scope', '$location', 'CrudService', 'CartService', 'OrderService',
    function($scope,$location,CrudService,CartService, OrderService){
        $scope.msg = $location.search().msg

        $scope.carts = CartService.getAllCarts()
        $scope.orders = OrderService.getAllOrders()

        $scope.deleteCartAndRefresh = function(tableId){
            CartService.deleteCart(tableId, function(data){
                $scope.carts = data
            })
        }

    }])
})(app)