var app = angular.module('index',[]);

app.run(function($templateCache) { //表格看模板缓存
  $templateCache.put('template.html', 
    '<tr>'+
        '<td ng-repeat="n in [] | range:20">' +
            '123'+
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


