
function CustomerController(){
		this.sortBy = 'name';
		this.reverse = false;

		this.customers= [
			{name:'odelu', joined:'2018-12-01', city:'karimnagar', orderTotal:100.25},
			{name:'kumar', joined:'2019-11-01', city:'karimnagar', orderTotal:120.25},
			{name:'chary', joined:'2019-12-01', city:'warangal', orderTotal:152.26},
			{name:'Anil Kumar', joined:'2020-01-01', city:'Hanamkonda', orderTotal:102.25}
		];

		this.doSort = function(propName) {
			this.sortBy = propName;
			this.reverse = !this.reverse;
		}
	}