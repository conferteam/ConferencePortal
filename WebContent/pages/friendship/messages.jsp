<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>消息</title>

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/js/bootstrap.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome/css/font-awesome.min.css">
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="application/x-javascript"> 
		addEventListener("load", function() { 
			setTimeout(hideURLbar, 0); }, false); 
			function hideURLbar(){ 
				window.scrollTo(0,1); } 
	</script>
	
    <!-- umeditor css -->
	<link href="<%=request.getContextPath()%>/umeditor/themes/default/css/umeditor.css" rel="stylesheet">
	<!-- umeditor js -->
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/umeditor/lang/zh-cn/zh-cn.js"></script>

	<script src="<%=request.getContextPath()%>/js/friendship/messages.js"></script>
	
	<style>
	.aPoint:hover{
	color:#000!important;
	}
	</style>
</head>
<body>	
<script>
//如果没有关注的人参加的会议则不显示，如果没有好友验证则不显示
$(function(){
	if("${friendNotice.notice_id}"=="")
	{
		var traget=document.getElementById("friendNotice");
	 	traget.style.display="none";
	}
	if("${followConference.user_id}"=="")
	{
		var traget=document.getElementById("followConference");
	 	traget.style.display="none";
	}
});
</script>



<!-- 关注的人会议悬浮窗开始 -->
<div  id="Layer3" style="display:none;position: fixed; z-index: 301;padding-top:5%;padding-left:28%;">
<div class=" content_white" style="border-radius:5px;OVERFLOW: auto;max-width: 750px;min-width: 500px;position: relative;
    width: 45vw;min-height:500px;background-color: #fff;padding-top:0px;padding-bottom:10px;">

<!-- title start -->
<div style="background-color:rgba(244, 48, 89, 0.53);;height:50px;align-items: center;border-bottom: 1px solid #e6ecf0;box-sizing: border-box;display: flex;flex-shrink: 0;">
	<div style="padding-bottom:0px;border-color:transparent;background: transparent;justify-content: flex-end;"class="alert alert-success alert-dismissable" >
		
	</div>
	<div style="justify-content: center;align-items: center;display: inline-flex;flex: 1 1 auto;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;min-width: 0;">
		<div style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;    display: block;    color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px">
		<div style="display: block;white-space: nowrap!important;word-wrap: normal!important;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
		<span style="color:#66757f;max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;font-size: 21px;font-weight: 300;line-height: 28px;">
		关注的人参加了哪些会议
		</span>
		</div>
		</div>
	</div>
	<div style="padding-bottom:0px;border-color:transparent;background: transparent;justify-content: flex-end;"class="alert alert-success alert-dismissable" >
		<button class="close"><a href="<%=request.getContextPath()%>/messages/queryAll.action">&times;</a></button>
	</div>
</div>
<!-- title end -->

<div style="height:500px;OVERFLOW: auto;">
<c:forEach items="${followConferenceList}" var="followConference">
	
      <div class="blog_grid" style="border-bottom: 1px solid #e6ecf0;margin:0px;min-height: 80px;padding-right:30px;padding-bottom:0px;">
      	<ul class="test_box" style="margin-top:1em;margin-bottom:0em;text-align:left;display:flex;background: transparent;" >
		  
		  <li style="padding-left: 30px;padding-right: 20px;">
		  	<img src="${followConference.avatar}" class="img-responsive" style="border-right:0px;margin-right:0px;border-radius:50%;width:50px;height:50px;" alt="profilePicture"/>
		  </li>
		  <li class="test_desc" style="flex-grow:1;">
			  <div style="display:flex;">
			  	<div style="flex-grow:1;text-align:left;">
				 	<b style="color: #999;font-size: 14px;font-weight: bold;">${followConference.username}</b>
				 	<b style="font-weight: normal;font-size: 14px;color: #999;">${followConference.email}</b>
				</div>
				<p class="last" style="margin:0px;text-align:right;width:300px;color: #657786;font-size: 14px;"><fmt:formatDate type="date" value="${followConference.confer_date}" /></p>
			  </div>
			  <div style="display:flex;">
				<b style="font-weight: 300;font-size: 1rem;color: #14171a;flex-grow:1;margin:0px;">${followConference.confer_name}</b>
			  </div>
		  </li>
		  
		  <div class="clearfix"> </div>
		</ul>
       </div>  
</c:forEach>
</div>

</div>
</div>
<!-- 关注的人会议悬浮窗结束-->

<!-- 添加好友悬浮窗开始 -->
<div  id="Layer2" style="display:none;position: fixed; z-index: 301;padding-top:100px;padding-left:30%;">

  <div class="content_white" style="border-radius:5px;OVERFLOW: auto;position: relative;
    background-color: #fff;padding-top:0px;padding-bottom:10px;">
  <!-- title start -->
	<div style="background: #fff;height:45px;align-items: center;border-bottom: 1px solid #e6ecf0;box-sizing: border-box;display: flex;flex-shrink: 0;">
	<div style="justify-content: center;align-items: center;display: inline-flex;flex: 1 1 auto;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;min-width: 0;">
  		<div style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;    display: block; ">
  		<div style="display: block;white-space: nowrap!important;word-wrap: normal!important;line-height: 28px;">
  		<span style="color:#66757f;max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;font-size: 21px;font-weight: 300;line-height: 28px;">
  		添加好友
  		</span>
  		</div>
  		</div>
	</div>
	</div>
	<!-- title end -->	    
    <table width="540px"  align="center" style="background-color: #fff;">
    <tr>
        <td height="130" align="center" style="">
        	<ul class="links" style="border:0px;margin:0;display:flex;padding-left:120px;">
        		<li class="test_img" id="avatar" style="width:100px;"></li>
  				<li class="test_desc" id="usernameEmail" style="text-align:left;padding-top:15px;"></li>
        	</ul>
        	<input id="user_id" style="display:none;" value="">
        	<textarea style="WIDTH: 400px" rows="3" id="text" ></textarea>
        </td>
    </tr>
    <tr>
    	<td style="text-align:right;padding-top:10px; padding-right:13%;padding-bottom:10px;">
     	<button  style="height:30px;width:60px;display: inline-block;   background-color: #f43059;background: rgb(244, 48, 89);border: 1px solid transparent;text-align: center;" 
     		align="right" name="Close" ><a style="color: #fff;" href="<%=request.getContextPath()%>/messages/queryAll.action">关闭</a></button>
         <button style="height:30px;width:60px;display: inline-block;   background-color: #f43059;background: rgb(244, 48, 89);border: 1px solid transparent;text-align: center;" 
     		align="right" name="Submit" ><a onclick="submit()" style="color: #fff;" href="">提交</a></button>
    	</td>
    </tr>
  </table>
  </div>
 </div>
<!-- 添加好友悬浮窗结束 -->

<!-- 验证消息悬浮窗开始 -->
<div  id="Layer1" style="display:none;position: fixed; z-index: 301;padding-top:5%;padding-left:28%;">
<div class=" content_white" style="border-radius:5px;OVERFLOW: auto;max-width: 750px;min-width: 500px;position: relative;
    width: 45vw;min-height:500px;background-color: #fff;padding-top:0px;padding-bottom:10px;">

<!-- title start -->
<div style="height:45px;align-items: center;border-bottom: 1px solid #e6ecf0;box-sizing: border-box;display: flex;flex-shrink: 0;color: #657786;">
	<div style="padding-bottom:0px;border-color:transparent;background: transparent;justify-content: flex-end;"class="alert alert-success alert-dismissable" >
		
	</div>
	<div style="justify-content: center;align-items: center;display: inline-flex;flex: 1 1 auto;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;min-width: 0;">
		<div style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;    display: block;    color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px">
		<div style="display: block;white-space: nowrap!important;word-wrap: normal!important;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
		<span style="color:#66757f;max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;font-size: 21px;font-weight: 300;line-height: 28px;">
		好友验证
		</span>
		</div>
		</div>
	</div>
	<div style="padding-bottom:0px;border-color:transparent;background: transparent;justify-content: flex-end;"class="alert alert-success alert-dismissable" >
		<button class="close" ><a href="<%=request.getContextPath()%>/messages/queryAll.action">&times;</a></button>
	</div>
</div>
<!-- title end -->

<div style="height:500px;OVERFLOW: auto;">
<c:forEach items="${friendNoticeList}" var="messages">
	
      <div id="${messages.notice_id}" class="blog_grid" style="height:50px;padding-right:24px;padding-bottom:0px;">
      	<ul class="test_box" style="margin-top:1em;margin-bottom:2em;text-align:left;display:flex;background: transparent;" >
		  
		  <li class="test_img" style="padding-left: 40px;">
		  	<img src="${messages.avatar}" class="img-responsive" style="border-radius:50%;width:50px;height:50px;" alt="profilePicture"/>
		  </li>
		  <li class="test_desc" style="flex-grow:1;">
		  <div style="display:flex;">
		  	<div style="flex-grow:1;text-align:left;">
		 	<b style="color: #14171a;font-size: 14px;font-weight: bold;">${messages.username}</b>
		 	<b style="font-weight: normal;font-size: 14px;color: #657786;">${messages.email}</b>
			</div>
			<p class="last" style="margin:0px;text-align:right;width:300px;color: #657786;font-size: 14px;"><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${messages.date}" /></p>
		  </div>
		  <div style="display:flex;">
			<b style="font-weight: normal;font-size: 14px;color: #657786;flex-grow:1;margin:0px;">附加消息：${messages.text}</b>
	  		<div>
	     	<button  style="height:30px;width:60px;display: inline-block;   background-color: #f43059;background: rgb(244, 48, 89);border: 1px solid transparent;text-align: center;">
	     	<a style="color: #fff;font-size:14px;" onclick="accept(${messages.user_id},${messages.notice_id})">接受</a></button>
	        <button style="height:30px;width:60px;display: inline-block;   background-color: #f43059;background: rgb(244, 48, 89);border: 1px solid transparent;text-align: center;">
	        <a style="color: #fff;font-size:14px;" onclick="refuse(${messages.notice_id})" >拒绝</a></button>
			</div>
		  </div>
		  </li>
		  
		  <div class="clearfix"> </div>
		</ul>
       </div>  
       
</c:forEach>
</div>

</div>
</div>
<!-- 验证消息悬浮窗结束 -->

<!-- 覆盖层开始 -->
<div id="ly" style="width:100%;height:1690px; position: absolute; top: 0px;     background: rgba(41,47,51,0.9);
z-index: 300; left: 0px; display: none;">
</div>
<!-- 覆盖层结束 -->
<!-- 菜单栏开始 -->
<div class="header" style="height:150px; background: url(<%=request.getContextPath()%>/images/bg-pattern),linear-gradient(to left,#7b4397,#dc2430);
    background-image: url(<%=request.getContextPath()%>/images/bg-pattern.png), linear-gradient(to left, rgb(123, 67, 151), rgb(220, 36, 48));">
  <div class="container" style="display:flex;">
  	<p style="flex-grow:1;font-size:40px;color:#fff;">会议门户</p>
    <div class="menu" > 
    	<a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      	
      	<div style="margin-left:280px;">
	      	<div style="display:flex;">
	  			<p style="color:#e1c0d2;">wqq_angel@outlook.com</p>
	  			<a style="color:#e1c0d2;width:80px;padding-left:10px;">退出系统</a>
	  		</div>
		</div>
	      <ul class="nav" id="nav">
	        <li><a href="<%=request.getContextPath()%>/pages/index2.jsp">个人主页</a></li>
	        <li><a href="<%=request.getContextPath()%>/pages/conferenceInfo/callFpaper.jsp">会议发布</a></li>
	        <li><a href="<%=request.getContextPath()%>/pages/conferenceInfo/categories.jsp">会议分类</a></li>    
	        <li class="current"><a href="<%=request.getContextPath()%>/messages/queryAll.action">会议交友</a></li>
	        <li><a href="about.html">关于我们</a></li>
	      </ul>
      	  
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
    </div>
    
  </div>
</div>
<div class="about" >
</div>
<!-- 菜单栏结束 -->
<div style="margin-bottom: 4em;">
</div>
<div class="container">
  <div class="row">
    <div class="col-md-8" id="messages" style="margin:0px;border:0px;padding-left:10px;width:65%;">
    <div style='LINE-HEIGHT: 0px; OVERFLOW: auto; '>
    <!-- 关注的人参加的会议通知 -->
    <div id="followConference" style="margin-bottom:1em;border-bottom:1px solid #e6ecf0;line-height:1px;height:100px;overflow:hidden;">
      	<ul class="test_box" style="display:flex;" >
		  
		  <li class="test_img" style="text-align:right;padding-left:50px;">
		  	<a onclick="followConference() "><img src="../images/s1.jpg" class="img-responsive" style="cursor:pointer;border-radius:50%;width:70px;height:70px;" alt="profilePicture"/></a>
		  </li>
		  <li class="test_desc" style="flex-grow:1;">
		  <div style="display:flex;">
		  	<div style="flex-grow:1;">
		 	<h4><a onclick="followConference()" style="font-weight:500; cursor:pointer;">关注的人参加了哪些会议</a></h4>
		 	<h5><a onclick="followConference()" style="color: #888;cursor:pointer;">我的关注：${followConference.username}</a></h5>
			</div>
			<p class="last" style="text-align:right;width:150px;"><fmt:formatDate type="date" value="${followConference.confer_date}"/></p>
		  </div>
			<p style="margin:0px;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;">参加了会议：${followConference.confer_name}</p>
		  </li>
		  
		  <div class="clearfix"> </div>
		</ul>
    </div>
 	<!-- 好友申请通知 -->
	<div id="friendNotice" style="margin-bottom:1em;border-bottom:1px solid #e6ecf0;line-height:1px;height:100px;overflow:auto;">
      	<ul class="test_box" style="display:flex;" >
		  
		  <li class="test_img" style="text-align:right;padding-left:50px;">
		  	<a onclick="friendNotice()"><img src="../images/s2.jpg" class="img-responsive" style="cursor:pointer;border-radius:50%;width:70px;height:70px;" alt="profilePicture"/></a>
		  </li>
		  <li class="test_desc" style="flex-grow:1;">
		  <div style="display:flex;">
		  	<div style="flex-grow:1;">
		 	<h4><a onclick="friendNotice()" style="font-weight:500;cursor:pointer;">验证消息</a></h4>
		 	<h5><a onclick="friendNotice()" style="color: #888;cursor:pointer;">${friendNotice.username}申请添加你为好友</a></h5>
			</div>
			<p class="last" style="text-align:right;width:150px;"><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${friendNotice.date}"/></p>
		  </div>
			<p style="margin:0px;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;">附加消息：${friendNotice.text}</p>
		  </li>
		  
		  <div class="clearfix"> </div>
		</ul>
    </div>
    <!-- 私信列表 -->
	<c:forEach items="${messagesList}" var="messages">
	
      <div style="margin-bottom:1em;border-bottom:1px solid #e6ecf0;line-height:1px;height:100px;overflow:hidden;">
      	<ul class="test_box" style="display:flex;" >
		  
		  <li class="test_img" style="text-align:right;padding-left:50px;">
		  	<a href="<%=request.getContextPath()%>/chat/queryChat.action?get_user_id=${messages.user_id}"><img src="${messages.avatar}" class="img-responsive" style="border-radius:50%;width:70px;height:70px;" alt="profilePicture"/></a>
		  </li>
		  <li class="test_desc" style="flex-grow:1;">
		  <div style="display:flex;">
		  	<div style="flex-grow:1;">
		 	<h4><a style="font-weight:500;" href="<%=request.getContextPath()%>/chat/queryChat.action?get_user_id=${messages.user_id}">${messages.username}</a></h4>
		 	<h5><a style="color: #888;" href="<%=request.getContextPath()%>/chat/queryChat.action?get_user_id=${messages.user_id}" >${messages.email}</a></h5>
			</div>
			<p class="last" style="text-align:right;width:150px;"><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${messages.date}" /></p>
		  </div>
			<p style="margin:0px;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;">${messages.text}</p>
		  </li>
		  
		  <div class="clearfix"> </div>
		</ul>
       </div>       
	</c:forEach>

  	</div>
    </div>
    
    <div class="col-md-4 blog_sidebar" >
      <ul class="sidebar" >
        <h3 style="color: #d92534;">好友</h3>
        <div style='margin:0px;PADDING:0px; width:350px; max-height:400px; LINE-HEIGHT: 0px; OVERFLOW: auto; '>
        
      	<ul class="list_styled custon-list" style="padding:0px;">
  		
      	<c:forEach items="${friendsList}" var="user">
      	
      	<ul class="test_box" style="margin:0px;padding:0px;border:0px;display:flex;">
      		
		  <li class="test_img" style="margin:0px;"><img src="${user.avatar}" style="border-radius:50%;width:75%;height:90%;" class="img-responsive" alt="profilePicture"/></li>
		  
		  <li style="width:49%;"><h5>${user.username}</h5><h5>${user.email}</h5></li>
			<li>
				  <div class="dropdown" >
					  <button type="button" id="btn1" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color: transparent;color: #000;padding-top: 5px;font-size: 6px;border: none;cursor: pointer;">
					  <span class="caret"></span>
			  			</button>
					  <ul class="dropdown-menu" aria-labelledby="btn1"  role="menu" style="z-index:299;right:0;position: absolute;background-color: #fdfdfd;min-width: 100px;box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);z-index: 100;">
						    <li role="presentation">
							<a class="aPoint" role="menuitem" tabindex="-1" href="<%=request.getContextPath()%>/chat/queryChat.action?get_user_id=${user.user_id}">私信好友</a>
							</li>
							<li role="presentation" class="divider"></li>
							<li role="presentation">
								<a class="aPoint" role="menuitem" tabindex="-1" onclick="insertFollow(${user.user_id})" href="">关注他</a>
							</li>
							<li role="presentation" class="divider"></li>
							<li role="presentation">
								<a class="aPoint" role="menuitem" tabindex="-1" href="<%=request.getContextPath()%>/friendship/deleteFriend.action?user1_id=${user.user_id}">删除好友</a>
							</li>
					  </ul>
					</div>
			</li>				
		 </ul>
		 </c:forEach>
	
		</ul>
		</div>
      </ul>

      <ul class="sidebar">
        <h3 style="color: #d92534;">我的关注</h3>
        <div style='margin:0px;PADDING:0px; width:350px; max-height:250px; LINE-HEIGHT: 0px; OVERFLOW: auto; '>
        
      	<ul class="list_styled custon-list" style="padding:0px;">  
      	<c:forEach items="${followList}" var="user">
      	<ul class="test_box" style="margin:0px;padding:0px;border:0px;display:flex;">
      		<li class="test_img" style="margin:0px;"><img src="${user.avatar}" style="border-radius:50%;width:75%;height:90%;" class="img-responsive" alt="profilePicture"/></li>
		  
		  	<li style="width:49%;"><h5>${user.username}</h5><h5>${user.email}</h5></li>
		  	
      		<li>
      			<div class="dropdown">
			  	<button type="button" id="btn1" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color: transparent;color: #000;padding-top: 5px;font-size: 6px;border: none;cursor: pointer;">
					  <span class="caret"></span>
			  	</button>
				<ul class="dropdown-menu" aria-labelledby="btn1"  role="menu" style="right:0;position: absolute;background-color: #fdfdfd;min-width: 100px;box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);z-index: 100;">
					
					<li role="presentation"><a class="aPoint" role="menuitem" tabindex="-1" style="cursor:pointer;" onclick=addFriend("${user.avatar}","${user.username}","${user.email}","${user.user_id}")>添加好友</a></li>

					<li role="presentation" class="divider"></li>
					<li role="presentation">
						<a class="aPoint" role="menuitem" tabindex="-1" href="<%=request.getContextPath()%>/friendship/deleteFollow.action?user1_id=${user.user_id}">取消关注</a>
					</li>
				</ul>
				</div>
			</li>		  
		 </ul>
		 </c:forEach>
	
		</ul>
       </div>
      </ul>
         
      <ul class="sidebar">
        <h3 style="color: #d92534;">谁关注了我</h3>
        <div style='margin:0px;PADDING:0px; width:350px; height:300px; LINE-HEIGHT: 0px; OVERFLOW: auto; '>
        
      	<ul class="list_styled custon-list" style="padding:0px;">
  
      	<c:forEach items="${beFollowedList}" var="user">
      	<ul class="test_box" style="margin:0px;padding:0px;border:0px;display:flex;">
      		<li class="test_img" style="margin:0px;"><img src="${user.avatar}" style="border-radius:50%;width:75%;height:90%;" class="img-responsive" alt="profilePicture"/></li>
		  
		  	<li style="width:49%;"><h5>${user.username}</h5><h5>${user.email}</h5></li>
      		
      		<li>
     		<div class="dropdown" >
			  <button type="button" id="btn1" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color: transparent;color: #000;padding-top: 5px;font-size: 6px;border: none;cursor: pointer;">
				<span class="caret"></span>
	  			</button>
			  <ul class="dropdown-menu" aria-labelledby="btn1"  role="menu" style="right:0;position: absolute;background-color: #fdfdfd;min-width: 100px;box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);">
				
				<li role="presentation"><a class="aPoint" role="menuitem" tabindex="-1" style="cursor:pointer;" onclick=addFriend("${user.avatar}","${user.username}","${user.email}","${user.user_id}")>添加好友</a></li>
				<li role="presentation" class="divider"></li>
				<li role="presentation">
					<a class="aPoint" role="menuitem" tabindex="-1" onclick="insertFollow(${user.user_id})" href="">关注他</a>
				</li>
				</ul>
			</div>
			</li>
		  
		 </ul>
		 </c:forEach>
	
		</ul>
       </div>
      </ul>
    </div>
  </div>
</div>

<div class="footer_bottom" style="background-color:#333;">
  <div class="copy">
    <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
  </div>
</div>

</body>
</html>