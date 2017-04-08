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
			<my-progress :door="door" :rowindex="rowindex" :colindex="index"></my-progress>\
		</td>\
	</tr>\
	',
	props:['door','rowindex'],
});

Vue.component('my-progress', {
    template: '\
       <Tooltip  placement="top" :delay="300">\
			<div slot="content">\
				<p>机框_{{$route.params.id}}</p>\
				<p>{{door}}</p>\
				<p><i>行号:{{rowindex}}</i></p>\
				<p><i>列号:{{colindex}}</i></p>\
			</div>\
			<div class="progress progress-bar-vertical" data-toggle="tooltip" data-placement="top">\
				<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="height: 30%;">30%\
					<span class="sr-only">30% Complete</span>\
				</div>\
			</div>\
		</Tooltip>\
    	',
    props:['door','rowindex','colindex'],
    
})

const Chassis = { //定义组件
  template : '<div>{{$route.params.id}}<my-table class="layout-content-main" v-for="(door,index) in doors" :key="index" :door="door" :tableindex="index"></my-table></div>',
  data (){
	return {
		doors:['A门', 'B门', 'C门', 'D门'],
	}
  },
};

const routes = [ //定义动态路由
  { path: '/chassis/:id', components: {view : Chassis} }
];

const router = new VueRouter({ //设置路由
	mode: 'history',
	routes // （缩写）相当于 routes: routes
});

var vm = new Vue({
	router, //使用路由
	el: '#container',
	data: {
		num : v.$data.vnum, //机框数量,利用另外一个vue实例,将java 模板上的值回传
		lasttime : new Date(), //记录左侧菜单点击的时间点,防止恶意点击
		isfristload : true, //是否第一次加载
		curchassisno: '', //记录点击后当前的机框号,防止显示后重复点击
	},

	methods: {
		showChassis (key) { //菜单项点击事件
		   var curtime = new Date();
		   if(this.isfristload){ //第一次加载不用等10s的间隔时间
				this.$router.push({ path: '/chassis/' + key });
				this.isfristload = false;
				this.curchassisno = key;
		   }else{
				if( this.curchassisno == key){ //如果选中的key 与 上一次相同则无需切换
					this.$Message.error('当前机框已显示,无需切换');
				}else{
					if((curtime - this.lasttime) / 1000 > 10){ //间隔10s才能提交切换
						this.lasttime = new Date();
						this.$router.push({ path: '/chassis/' + key })
						this.curchassisno = key;
					}else{
						this.$Message.error('两次切换的时间需间隔10秒');
					}
				}           
		   }        
		},
		// getNum (){ //获得左侧sidebar的机框数量
		// 	var resource = this.$resource('/index/left');
		// 	vm = this;
		// 	resource.get()
		// 	.then((response) => {
		// 	   this.num = response.data;
		// 	})
		// 	// .catch(function(response) {
		// 	//     console.log(response)
		// 	// }) /*调试*/
		// } ,  
	},
	// created(){//实例化后的运行方法
	// 	// this.getNum();
	// 	this.num = v.$data.vnum; //
	// }
});



