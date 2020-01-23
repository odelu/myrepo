(function() {
 	var app = angular.module('customersApp', ['ngRoute']);

 	app.config(function($routeProvider) {
 		$routeProvider
 			.when('/', {
 				controller:'CustomerController',
 				templateUrl: 'app/views/customer.html'
 			})
 			.when('/order/:customerId', {
 				controller: 'orderController',
 				templateUrl: 'app/views/order.html'
 			})
 			.when('/upload', {
 				controller: 'fileUploadCtrl',
 				templateUrl: 'app/views/fileUpload.html'
 			})
 			.otherwise({ redirectTo : '/'});
 	});

}());