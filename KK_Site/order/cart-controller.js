(function(app) {
    app.controller('cartCtrl', [
        '$scope', 'CartService', 'CrudService', '$location',
        function($scope, CartService, CrudService, $location) {
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
            }

            $scope.setTableIdForCart = function(){
                tableId = $scope.tableId
                if(isNaN(parseInt(tableId))){
                    $scope.err = 'Please, enter a valid number.'
                    return
                }
                if(tableId<1){
                    $scope.err = 'Please, enter a valid number.'
                    return
                }
                CartService.createCart(tableId, function(data){
                    if(data.success===true){
                        
                    }else{
                        $scope.cart = CartService.getCartForTable(tableId, function(data){
                            
                        })
                    }
                    $scope.selecting = false
                    $scope.err = false
                    reloadCart()

                })
            }

            $scope.dishes = CrudService.Entity('dishes').query()

            $scope.addToCart = function(dish){

                var amount = getAmountAndClean(dish)

                $scope.cart = CartService.addDishToCart($scope.tableId, dish, amount, function(data){
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

            var reloadCart = function(){
                $scope.cart = CartService.getCartForTable($scope.tableId)
            }

            $scope.cart = (function(){
                if($scope.tableId!==0){
                    reloadCart()
                }
            })()

            

            $scope.removeFromCart = function(dishOrder){
                $scope.cart = CartService.removeDishFromCart($scope.tableId, dishOrder.dish.id, dishOrder.removeAmount,
                function(data){

                })
            }

            $scope.cancelCart = function(){
                $scope.cart = undefined
                $scope.selecting = true
                CartService.deleteCart($scope.tableId, function(){
                    $scope.orderMsg = 'You have cancelled an order.'
                })
            }
            
            $scope.saveCart = function(){
                CartService.saveCart($scope.tableId, function(){
                    $location.path('/order-all').search({msg:'Cart saved succesfully'})
                })
            }

            $scope.$on('$viewContentLoaded', () => {
                reloadCart()
            })

        }
    ])
})(app)
