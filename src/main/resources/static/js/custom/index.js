// var app = angular.module('index',['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

// app.run(function($templateCache){
//     $templateCache.put('tabletemplate.html',
//         '<div ng-class="$index%2==0?&#39;doorA&#39;:&#39;doorB&#39;"><strong>{{doors[$index]}}</strong></div>'+  
//             '<table>'+
//                '<tr my-td ng-repeat="n in [] | range:8"></tr>'+
//         '</table>'
//     );
// })

// app.run(function($templateCache) { //表格看模板缓存
//     $templateCache.put('template.html', 
//         '<tr>'+
//             '<td ng-repeat="n in [] | range:20">' +
//                 '<div class="progress progress-bar-vertical"'+
//                     'uib-tooltip-html= "&#39;<strong>{{doors[$parent.$parent.$index]}}</strong><br><strong>行号:</strong>{{$parent.$index + 1}}<br><strong>列号:</strong>{{$index + 1}}<br>&#39;">'+
//                     '<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="height: 30%;">30%'+
//                         '<span class="sr-only">30% Complete</span>'+
//                     '</div>'+
//                 '</div>'+
//             '</td>'+
//         '</tr>'
//     );
// });
//     $http({
//         method: 'GET',
//         url: '/index/left'
//     }).then(function successCallback(response) {
//             console.log(response.data);
//         }, function errorCallback(response) {
//             // 请求失败执行代码
//     });

// });

Vue.component('my-table', {
    template: '\
        <div>\
            <div :class = "[tableindex % 2 == 0 ? \'doorA\' : \'doorB\']"><strong>{{door}}</strong></div>\
            <table>\
                <my-tr v-for="(n,index) in 8" :key="index" :rowindex="index"></my-tr>\
            </table>\
        </div>\
        ',
    props:['door','tableindex'],
})
Vue.component('my-tr', {
    template: '\
    <tr>\
        <td v-for="(n,index) in 20" :key="index">\
            <div class="progress progress-bar-vertical" data-toggle="tooltip" data-placement="top" title="Tooltip on top">\
                <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="height: 30%;">30%\
                    <span class="sr-only">30% Complete</span>\
                </div>\
            </div>\
        </td>\
    </tr>\
    ',
    props:['rowindex'],
})

new Vue({
    el: '#index',
    data:{
         doors:['A门', 'B门', 'C门', 'D门'],
    }
});
