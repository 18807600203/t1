Vue.component('my-table', {
    template: '\
        <div>\
            <div :class = "[tableindex % 2 == 0 ? \'doorA\' : \'doorB\']" v-once><strong>{{door}}</strong></div>\
            <table>\
                <my-tr v-for="index in 8" :key="index" :rowindex="index" :door="door"></my-tr>\
            </table>\
        </div>\
        ',
    props:['door','tableindex'],
})
Vue.component('my-tr', {
    template: '\
    <tr>\
        <td v-for="index in 20" :key="index" :door="door" :rowindex="rowindex">\
            <Tooltip  placement="top" :delay="300">\
                <div slot="content" v-once>\
                    <p>{{door}}</p>\
                    <p><i>行号:{{rowindex}}</i></p>\
                    <p><i>列号:{{index}}</i></p>\
                </div>\
                <div class="progress progress-bar-vertical" data-toggle="tooltip" data-placement="top">\
                    <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="height: 30%;">30%\
                        <span class="sr-only">30% Complete</span>\
                    </div>\
                </div>\
            </Tooltip>\
        </td>\
    </tr>\
    ',
    props:['door','rowindex'],
})

new Vue({
    el: '#container',
    data:{
         doors:['A门', 'B门', 'C门', 'D门'],
    },
    methods: {
        todo: function (index) {
            alert(index);
        }
    }
});


