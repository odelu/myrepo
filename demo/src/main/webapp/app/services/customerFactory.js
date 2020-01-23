(function() {
	
	var customerFactory = function($http) {
			
		var factory = {};
		factory.getCustomers = function() {
			return $http.get('http://localhost:2020/demo/customers');
		}
		
		factory.getCustomer = function(customerId) {
			return $http.get('http://localhost:2020/demo/customer/'+customerId);
		}
		
		return factory;
	}
	
	customerFactory.$inject = ['$http'];
	
	angular.module("customersApp").factory('customersFactory', customerFactory);
	
}());