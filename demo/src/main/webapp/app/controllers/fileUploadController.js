(function() {
	var fileUploadController = function($scope, fileUpload){
	    
	    $scope.uploadFile = function(){
	        var file = $scope.myFile;
	        console.log('file is ' );
	        console.dir(file);
	        var uploadUrl = "http://localhost:2020/demo/uploadFile/2";
	        fileUpload.uploadFileToUrl(file, uploadUrl);
	    };
	    
	}
	
	fileUploadController.$inject = ['$scope', 'fileUpload'];
	
	angular.module('customersApp').controller('fileUploadCtrl', fileUploadController);
		
})