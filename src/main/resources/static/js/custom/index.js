Vue.component('my-table', {
    template: '\
        <div>\
            <div :class = "[tableindex % 2 == 0 ? \'doorA\' : \'doorB\']"><strong>{{door}}</strong></div>\
            <table>\
                <my-tr v-for="index in 8" :key="index" :rowindex="index" :door="door"></my-tr>\
            </table>\
        </div>\
        ',
    props:['door','tableindex'],
});
Vue.component('my-tr', {
    template: '\
    <tr>\
        <td v-for="index in 20" :key="index" :door="door" :rowindex="rowindex">\
            <Tooltip  placement="top" :delay="300">\
                <div slot="content">\
                    <p>机框_{{$route.params.id}}</p>\
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
});

const Chassis = {
  template : '<div>{{$route.params.id}}<my-table class="layout-content-main" v-for="(door,index) in doors" :key="index" :door="door" :tableindex="index"></my-table></div>',
  data (){
    return {
        doors:['A门', 'B门', 'C门', 'D门'],
    }
  },
};

const routes = [
  { path: '/chassis/:id', components: {view : Chassis} }
];

const router = new VueRouter({
    mode: 'history',
    routes // （缩写）相当于 routes: routes
});

new Vue({
    router,
    el: '#container',
    data: {
        num: '',
        //curchassisno : '0', 
        lasttime : new Date(), 
        isfristload : true, 
    },
    methods: {
        showChassis (key) {
           // /**/ this.$Message.info(key);
            
           // setTimeout(() => {
           //      this.$Message.info("测试");
           //  }, 2000);
           var curtime = new Date();
           if(this.isfristload){
                this.$router.push({ path: '/chassis/' + key })
                this.isfristload = false;
           }else{
                if((curtime - this.lasttime) / 1000 > 10){ //间隔10s才能提交切换
                    this.lasttime = new Date();
                    this.$router.push({ path: '/chassis/' + key })
                }else{
                    this.$Message.error('两次切换的时间需间隔10秒');
                }
           }
           
        },
        getNum (){
            var resource = this.$resource('/index/left');
            vm = this;
            resource.get()
            .then((response) => {
               this.num = response.data;
            })
            // .catch(function(response) {
            //     console.log(response)
            // }) /*调试*/
        } ,  
    },
    created(){
        this.getNum();        
    }
});

