(function(){
	
	var orderController = function($scope, $routeParams, customersFactory) {
		var customerId = $routeParams.customerId;
		$scope.customer = null;
		
		function init() {
			// search the customers for the customerId
			customersFactory.getCustomer(customerId)
				.then(function(customer) {
					$scope.customer = customer.data;
				}, function(error) {
					//handling error
				})
		}
		
		init();
	};
	
	orderController.$inject = ['$scope', '$routeParams', 'customersFactory'];
	
	angular.module('customersApp').controller('orderController', orderController);
	
}());