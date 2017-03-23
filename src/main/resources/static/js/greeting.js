var app = angular.module('app', ['ngResource', 'ngTouch', 'ui.grid', 'ui.grid.resizeColumns', 'ui.grid.moveColumns', 'ui.grid.pagination']);

app.controller('MainCtrl', function($scope, $http, i18nService, $resource) {

		i18nService.setCurrentLang("zh-cn"); //国际化
		var batinfo = $resource('/serch/greeting/:id', { id: '@id'});

		$scope.gridOptions = {

			showGridFooter: false,
			showColumnFooter: false,
			enableFiltering: true,
			enableColumnResizing: true,
			enableGridMenu: true,
			// flatEntityAccess: true,
			//fastWatch: true,
			//pagination
			paginationPageSizes: [25, 50, 75],
			paginationPageSize: 25,
		};

		$scope.gridOptions.columnDefs = [
		{
			name: 'id',
			width: 80,
			displayName: 'ID'
		}, {
			name: 'no',
			width: 150,
			displayName: '编号'
		}, {
			name: 'chassis',
			width: 80,
			displayName: '机框'
		}, {
			name: 'channel',
			width: 80,
			displayName: '通道'
		}, {
			name: 'module',
			width: 80,
			displayName: '模块'
		}, {
			name: 'isformat',
			width: 100,
			type: 'booelean',
			displayName: '分容',
			cellFilter: 'status',
			enableSorting: false
		}, {
			name: 'ifgrad',
			width: 100,
			type: 'booelean',
			displayName: '分选',
			cellFilter: 'status',
			enableSorting: false
		}, {
			name: 'ismatch',
			width: 100,
			trpe: 'boolean',
			displayName: '配对',
			cellFilter: 'status',
			enableSorting: false
		}, {
			name: 'ismastop',
			width: 100,
			trpe: 'boolean',
			displayName: '停止',
			cellFilter: 'status',
			enableSorting: false
		}];

		$scope.serchById = function(){

			var serchid = $scope.id;
			if(angular.isNumber(serchid)){
				batinfo.get(
					{id: serchid }, 
					function(bi){
						bi.$save;
					
					},
					function(error){
						
					}
				);
			}else{
				
			}	
		}
})
.filter('status', function() {

	var statusMap = ['是', '否'];

	return function(code) {
		if (code) {
			return statusMap[0];
		} else {
			return statusMap[1];
		}
	};
});
