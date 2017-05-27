var query = location.search.slice(1).split('&').map(item => { // 自动截取链接搜索部分
	var r = {}
	var list = item.split('=');
	r[list[0]] = list[1];
	return r
}).reduce((prev, next) => { return Object.assign(prev, next) },{});

function printconfer(confer){ // 打印会议列表
	confer.map(function (item) {
	var temp='<h2 class = "list-item-title"><a href="">'+item.conferName+'</a></h2>';
	temp=temp+'<div>'
	temp=temp+'<span class = "list-item-span"><i class="fa fa-calendar"></i>'+item.conferDate.slice(0,item.conferDate.indexOf('T'))+'</span>';
	temp=temp+'<span class = "list-item-span"><i class="fa fa-map-marker"></i>'+item.conferLocation+'</span>';
	temp=temp+'<span class = "list-item-span list-item-right"><i class="fa fa-bars"></i>'+item.conferClassId+'</span>';
	temp=temp+'</div>';
	temp=temp+'<p class = "list-item-body">'+item.conferAbstract+'</p>';
	temp=temp+'<br/><br/>';
	$("#confer_list").append(temp);
	
})
} 

function getpagescode(pages,name,cpages){ // 拼接代码字符串，第一个是页数，第二个显示名称，最后一个标识是否是当前页
	if(cpages==0){
		return '<li><a href="?pages='+pages+'">'+name+'</a></li>';
	}
	else{
		return '<li><a style="background:gray;">'+name+'</a></li>';
	}
}

function printpages(allpages,atpages){ // 渲染分页插件，第一个输入总页数，第二个输入当前页
	if(atpages>1){ // 存在上一页则打印上一页
		$("#printpages").append(getpagescode(atpages-1,"上一页",0));
	}
	if(atpages>=3&&allpages>=atpages+2){ // 两边都能到达头
		for(i=atpages-2;i<=atpage+2;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(atpages==1&&allpages>=5){ // 在第一页且右侧至少五页
		for(i=1;i<=5;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(atpages==1&&allpages<5){ // 第一页右侧未能完全填充
		for(i=1;i<=allpages;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(atpages==2&&allpages>=5){ // 在第二页右侧至少四个
		for(i=1;i<=5;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(atpages==2&&allpages<5){ // 第二页右侧少于四个
		for(i=1;i<=allpages;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(allpages==atpages&&allpages>=5){
		for(i=allpages-4;i<=allpages;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(allpages==atpages&&allpages<5){
		for(i=1;i<=allpages;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(allpages==atpages+1&&allpages>=5){
		for(i=allpages-4;i<=allpages;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else if(allpages==atpages+1&&allpages<5){
		for(i=1;i<=allpages;i++){
			$("#printpages").append(getpagescode(i,i,i==atpages?1:0));
		}
	}
	else{
		console.log("error");
	}
	if(allpages!=atpages){
		$("#printpages").append(getpagescode(atpages+1,"下一页",0));
	}
	
}

$(document).ready(function(){ // 初始化
	// 假装这里已经检测过是否登录
	$.ajax({
		type:"post",
		url:"/ConferencePortal/userinfo/getconfer.action",
		data:{
			pages:query.pages==null?'1':query.pages,
			pagesend:1 // 用pagesend存储查询种类，1表示我参加的会议
		},
		dataType:"json",
		success:function(result){
			printconfer(result.map.my_confer);
			printpages(Math.ceil(result.map.count/5),query.pages==null?'1':query.pages);
		}
	})
})