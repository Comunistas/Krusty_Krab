(function(app) {
    app.controller('orderCtrl', [
        '$scope', 'OrderService', 'CrudService', '$location',
        function($scope, OrderService, CrudService, $location) {
            console.log($location.search().tableId)
            console.log($location.search().tableId!==undefined)
            if($location.search().tableId!==undefined){
                $scope.tableId = $location.search().tableId
                $scope.selecting = false
            }else{
                $scope.selecting = true
                $scope.tableId = 0
            }

            $scope.order = {}
            

            var tableId
            
            $scope.enableSelectionForTable = function(){
                $scope.selecting = true
                console.log('Hi')
            }

            $scope.setTableIdForOrder = function(){
                console.log('Hi fromhere')
                tableId = $scope.tableId
                OrderService.createOrder(tableId, function(data){
                    if(data.success===true){
                        
                    }else{
                        $scope.cart = OrderService.getOrderForTable(tableId, function(data){
                            
                        })
                    }
                    $scope.selecting = false
                    $scope.err = false
                })
            }

            $scope.dishes = CrudService.Entity('dishes').query()

            $scope.addToCart = function(dish){

                var amount = getAmountAndClean(dish)

                $scope.cart = OrderService.addDishToOrder($scope.tableId, dish, amount, function(data){
                    $scope.msg = "Dish added succesfully"
                    dish.amount = 1
                })
            }
            
            var getAmountAndClean = function(dish){
                    var amount = dish.amount
                    dish.amount = undefined
                    dish.dailyStock = undefined
                    dish.description = undefined
                return (function(){
                    return amount
                })()
            }

            $scope.cart = (function(){
                if($scope.tableId!==0){
                    OrderService.getOrderForTable($scope.tableId)
                }
            })()

            $scope.removeFromOrder = function(dishOrder){
                $scope.cart = OrderService.removeDishFromOrder($scope.tableId, dishOrder.dish.id, dishOrder.removeAmount,
                function(data){

                })
            }

            $scope.cancelOrder = function(){
                $scope.cart = undefined
                $scope.selecting = true
                OrderService.deleteOrder($scope.tableId, function(){
                    $scope.orderMsg = 'You have cancelled an order.'
                })
            }
            
            $scope.saveOrder = function(){
                OrderService.saveOrder($scope.tableId, function(){
                    $location.path('/order-all').search({msg:'Order saved succesfully'})
                })
            }

        }
    ])
})(app)
