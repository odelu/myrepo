
//option 1 
/*app.controller('CustomerController', function($scope){
		$scope.sortBy = 'name';
		$scope.reverse = false;

		$scope.customers= [
			{name:'odelu', joined:'2018-12-01', city:'karimnagar', orderTotal:100.25},
			{name:'kumar', joined:'2019-11-01', city:'karimnagar', orderTotal:120.25},
			{name:'chary', joined:'2019-12-01', city:'warangal', orderTotal:152.26},
			{name:'Anil Kumar', joined:'2020-01-01', city:'Hanamkonda', orderTotal:102.25}
		];

		$scope.doSort = function(propName) {
			$scope.sortBy = propName;
			$scope.reverse = !$scope.reverse;
		}
	});*/

	//option 2
/*(function() {
    console.log('odelu:::');
    // console.log(app);
	angular.module('customersApp').controller('CustomerController', function($scope){
		$scope.sortBy = 'name';
		$scope.reverse = false;

		$scope.customers= [
			{name:'odelu', joined:'2018-12-01', city:'karimnagar', orderTotal:100.25},
			{name:'kumar', joined:'2019-11-01', city:'karimnagar', orderTotal:120.25},
			{name:'chary', joined:'2019-12-01', city:'warangal', orderTotal:152.26},
			{name:'Anil Kumar', joined:'2020-01-01', city:'Hanamkonda', orderTotal:102.25}
		];

		$scope.doSort = function(propName) {
			$scope.sortBy = propName;
			$scope.reverse = !$scope.reverse;
		}
	});
}());*/


//option 3 (which is recomended)

(function() {

	var CustomerController = function(s, customersFactory, appSettings) {
		s.sortBy = 'name';
		s.reverse = false;
        s.customers = [];
        s.appSettings = appSettings;
        
        function init() {
        	customersFactory.getCustomers()
        		.then(function(customers) {
        			s.customers = customers.data;
        		}, function(error) {
        			//error handling
        		})
        }
        
        init();
        
		/*s.customers= [
			{name:'odelu', joined:'2018-12-01', city:'karimnagar', orderTotal:100.25},
			{name:'kumar', joined:'2019-11-01', city:'karimnagar', orderTotal:120.25},
			{name:'chary', joined:'2019-12-01', city:'warangal', orderTotal:152.26},
			{name:'Anil Kumar', joined:'2020-01-01', city:'Hanamkonda', orderTotal:102.25}
		];*/
		
		s.doSort = function(propName) {
			s.sortBy = propName;
			s.reverse = !s.reverse;
		}
	};

	CustomerController.$inject = ['$scope', 'customersFactory', 'appSettings'];
    
	angular.module('customersApp').controller('CustomerController', CustomerController);
	// angular.module('customersApp').controller('CustomerController', ['$scope', CustomerController]);

}());