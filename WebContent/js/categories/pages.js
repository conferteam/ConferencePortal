function getpagescode(pages,name,cpages){ // 拼接代码字符串，第一个是页数，第二个显示名称
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