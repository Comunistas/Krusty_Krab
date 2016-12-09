(function(app) {
    app.controller('orderCtrl', [
        '$scope', 'OrderService', 'CrudService',
        function($scope, OrderService, CrudService) {
            $scope.order = {}
            $scope.tableId = 0
            $scope.newOrder = true

            var tableId
            
            
            $scope.setTableIdForNewOrder = function(){
                tableId = $scope.tableId
                OrderService.createOrder(tableId, function(data){
                    if(data.success===true){
                        $scope.newOrder = false
                        $scope.err = false
                    }else{
                        $scope.err = "That table has already an order in progress."
                    }
                })
            }

            $scope.dishes = CrudService.Entity('dishes').query()

            


        }
    ])
})(app)
