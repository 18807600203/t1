var app = angular.module('index',['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.run(function($templateCache) { //表格看模板缓存
  $templateCache.put('template.html', 
    '<tr>'+
        '<td ng-repeat="n in [] | range:20">' +
            '<div class="progress progress-bar-vertical" uib-popover="the row is : 123" popover-trigger="&#39;mouseenter&#39;">'+
                '<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="height: 30%;">30%'+
                    '<span class="sr-only">30% Complete</span>'+
                '</div>'+
            '</div>'+
        '</td>'+
    '</tr>'
    );
});

app.directive('myHello',function(){
    return {
        restrict : 'E',
        replace : true,
        template : '<div>hello angular</div>'
    };
});

app.directive('myTd', function(){ //表格行模板
    return{  
        templateUrl : 'template.html'
    };
});

app.filter('range', function() { //循环输出
  return function(input, total) {
    total = parseInt(total);
    for (var i=0; i<total; i++)
      input.push(i);
    return input;
  };
});

app.controller('indexCtrl', function($scope){
    $scope.test = '1234';
    
});


