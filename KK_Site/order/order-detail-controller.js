(function(app){
    app.controller('orderDetailCtrl',['$scope', '$location', 'CrudService',
    function($scope,$location,CrudService){
        var id = $location.search().id

        $scope.order = CrudService.Entity('order').get({id:id})

        $scope.dishOrders = CrudService.Entity('dishes-orders').query({id:id})

    }])
})(app)