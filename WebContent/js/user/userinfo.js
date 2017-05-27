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

$(document).ready(function(){
	var pages=query.pages==null?'1':query.pages;
	$.ajax({
		type:"post",
		url:"/ConferencePortal/userinfo/getpages.action",
		data:{
			pages:pages
		},
		dataType:"json",
		success:function(result){
			console.log(result.map.confer);
			printconfer(result.map.confer);
			printpages(Math.ceil(result.map.count/5),query.pages==null?'1':query.pages);
			if(result.map.my_confer.length==0){
				$("#my_confer").append("<h2>未参与会议</h2>");
			}
			else{
				result.map.my_confer.map(function(item){
					var temp='<h2 class="side-confer-title"><a href="">'+item.conferName+'</a></h2>';
					temp=temp+'<span class="side-confer-date">'+item.conferDate.slice(0,item.conferDate.indexOf('T'))+'</span>';
					temp=temp+'<span class="side-confer-jian">'+item.conferAbbreviate+'</span>';
					$("#my_confer").append(temp);
				})
				if(result.map.my_confer.length==2){
					$(".side-confer-jian:first").css("border-bottom","1px solid red");
				}
			}
			if(result.map.my_subscribe.length==0){
				$("#my_subscribe").append("<h2>未订阅会议</h2>");
			}
			else{
				result.map.my_subscribe.map(function(item){
					var temp='<h2 class="side-confer-title"><a href="">'+item.conferName+'</a></h2>';
					temp=temp+'<span class="side-confer-date">'+item.conferDate.slice(0,item.conferDate.indexOf('T'))+'</span>';
					temp=temp+'<span class="side-confer-jian side-subscribe-jian">'+item.conferAbbreviate+'</span>';
					$("#my_subscribe").append(temp);
				})
				if(result.map.my_subscribe.length==2){
					$(".side-subscribe-jian:first").css("border-bottom","1px solid red");
				}
			}
			$("#avatar").attr("src",result.map.avatar==null?"/ConferencePortal/images/T/inquire.png":result.map.avatar);
			$("#username").text(result.map.username);
			$("#email").text(result.map.email);
			$("#points").text("积分："+result.map.points);
		}
	})
})