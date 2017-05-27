<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>群组聊天</title>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="format-detection" content="telephone=no">
	<!-- Set render engine for 360 browser -->
	<meta name="renderer" content="webkit">
	
	<!-- No Baidu Siteapp-->
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	
	<link rel="alternate icon" href="<%=request.getContextPath()%>/assets/i/favicon.ico">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.min.css">
	
	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/amazeui.min.js"></script>
	
	<!-- umeditor css -->
	<link href="<%=request.getContextPath()%>/umeditor/themes/default/css/umeditor.css" rel="stylesheet">
	<!-- umeditor js -->
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/umeditor/lang/zh-cn/zh-cn.js"></script>
	
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

	<script type="application/x-javascript"> 
		addEventListener("load", function() { 
			setTimeout(hideURLbar, 0); }, false); 
			function hideURLbar(){ 
				window.scrollTo(0,1); } 
	</script>
  
    <script src="<%=request.getContextPath()%>/js/friendship/groupChat.js"></script>
<style>
.aPoint:hover{
	color:#000!important;
}
</style>
</head>
<body>

<!-- 悬浮窗开始 -->
<div  id="Layer2" style="display:none;position: fixed; z-index: 1001;padding-top:100px;padding-left:30%;">

  <div class="content_white">
    <table width="540px"  align="center" style="background-color:#fff;">

	<!-- title start -->
	<div style="background-color: #fff;height:45px;align-items: center;border-bottom: 1px solid #e6ecf0;box-sizing: border-box;display: flex;flex-shrink: 0;color: #657786;">
	<div style="justify-content: center;align-items: center;display: inline-flex;flex: 1 1 auto;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;min-width: 0;">
   		<div style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;    display: block;    color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px">
   		<div style="display: block;white-space: nowrap!important;word-wrap: normal!important;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
   		<span style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
   		添加好友
   		</span>
   		</div>
   		</div>
	</div>
	</div>
	<!-- title end -->	    
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
     	<button style="height:30px;width:60px;display: inline-block;   background-color: #f43059;background: rgb(244, 48, 89);border: 1px solid transparent;text-align: center;" 
     		align="right" name="Close" ><a style="color: #fff;" href="">关闭</a></button>
         <button style="height:30px;width:60px;display: inline-block;   background-color: #f43059;background: rgb(244, 48, 89);border: 1px solid transparent;text-align: center;" 
     		align="right" name="Submit" ><a onclick="submit()" style="color: #fff;" href="">提交</a></button>
    	</td>
    </tr>
  </table>
  </div>
 </div>
 <!-- 悬浮窗结束 -->
 
<!-- 覆盖层 -->
<div id="ly" style="width:100%;height:1690px; position: absolute; top: 0px;     background: rgba(41,47,51,0.9);
z-index: 1000; left: 0px; display: none;">
</div>

<!-- 主要部分 -->
<div class="header" style="padding:1em 0; background: url(<%=request.getContextPath()%>/images/bg-pattern),linear-gradient(to left,#7b4397,#dc2430);
    background-image: url(<%=request.getContextPath()%>/images/bg-pattern.png), linear-gradient(to left, rgb(123, 67, 151), rgb(220, 36, 48));">
  <div class="container">
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>        
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
   
<div class="container">
<div class="row" style="display:flex;">
<!-- 群组聊天框 -->
<div class="col-md-12" style="flex-grow:1;padding-right:0px;">
<div class="am-g am-g-fixed" style="margin-right:0px;border-radius: 10px;padding-top:10px; width:650px; transform: none!important;position: relative;display: flex;flex-direction: column;color: #14171a;font-size: 14px;line-height: 18px;">
       
	<!-- title start -->
	<div style="background-color: #fff;min-height:45px;align-items: center;border-bottom: 1px solid #e6ecf0;box-sizing: border-box;display: flex;flex-shrink: 0;color: #657786;">
	<div style="justify-content: center;align-items: center;display: inline-flex;flex: 1 1 auto;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;min-width: 0;">
	
    <!-- 会议名字 -->
	<div style="word-wrap: normal!important;    display: block;    color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px">
		<div style="padding-left:10px;padding-right:10px;text-align:center;display: block;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
		<span style="color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
		${conference.confer_name}</span>
		</div>
	</div>
	</div>
	</div>
	<!-- title end -->
	
	<!-- ChatBox start-->
	<div id="ChatBox"  style="background-color: #fff;">
	  <div class="am-u-lg-12" style="height:400px;overflow-y:auto; ">
		<ul id="chatContent" class="am-comments-list ">
			<li id="msgtmp" class="am-comment" style="display:none;">
			    <a ff="img">头像</a>
			    <div style="background-color: #fffaf0;border-radius: 4px;display: block;" class="am-comment-main">
					<div style="padding: 8px 12px;">
					<div style="display:flex;">
					<p ff="username" style="color: #666!important;white-space: pre-wrap;word-wrap: break-word;font-size: 14px;line-height: 20px;margin: 0;-webkit-locale: auto;   -webkit-margin-before: 0em; -webkit-margin-after: 0em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">
				    	名字</p>
			    	<p ff="date" style="padding-left:5px;color: #666!important;white-space: pre-wrap;word-wrap: break-word;font-size: 14px;line-height: 20px;margin: 0;-webkit-locale: auto;   -webkit-margin-before: 0em; -webkit-margin-after: 0em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">
			    	时间</p>
			    	</div>
					<p ff="text" style="color: #333!important;white-space: pre-wrap; word-wrap: break-word;font-size: 14px;line-height: 20px;margin: 0;-webkit-locale: auto;    display: block;-webkit-margin-before: 0em;-webkit-margin-after: 0em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">
						消息内容</p>
					</div>
				</div>
			</li>
		</ul>
	  </div>
	</div>
	<!-- ChatBox end-->
	
	<!-- EditBox start-->
	<div style="flex-shrink: 0;display: block;height:300px;">
	<div style="background-color: #fff !important;display: block;box-sizing: border-box;width: 100%;padding: 10px;border-top: 1px solid #e6ecf0;">
	<div style="margin-top: 0em;" >
	
	<!-- message input start -->
	<div id="EditBox" style="width:100%;">
	    <!--style给定宽度可以影响编辑器的最终宽度-->
	    <script type="text/plain" id="myEditor" style="background-color: #fff;margin:0px;padding-left:10px;padding-right:0px;border-color: #C6E7FB !important;border-radius: 3px;border-style: solid;box-sizing: border-box;max-height:100px;min-height: 70px!important;position: relative;width: 646px;"></script>
    </div>
    <div  style="text-align:right;padding-top: 10px;">
    	<!-- action="<%=request.getContextPath()%>/groupChat/insertGroupChat.action" -->
    	<!--  <input id="text" type="hidden" value="" name="text">
	   	<input type="hidden" value="${conference.confer_id}" name="confer_id">-->
    	
    	<button id="close"  style="height:30px;width:60px;display: inline-block;   background: rgb(244, 48, 89);border: 1px solid transparent;color: #fff;text-align: center;" >
   		<a style="color:#fff;" href="<%=request.getContextPath()%>/messages/queryAll.action">关闭</a>
   		</button>
	    <button  style="height:30px;width:60px;display: inline-block;   background: rgb(244, 48, 89);border: 1px solid transparent;color: #fff;text-align: center;" >
	    <a id="send" style="color:#fff;"  href="" >发送</a>
	    </button>
    </div>
    <!-- message input end -->
    
    </div>
    </div>
    </div>  
    <!-- EditBox end-->

</div>
</div>
<!-- 参会人员列表 -->
<div class="col-md-2 blog_sidebar" style="width:400px;padding-top:10px;padding-left:20px;">
<ul class="sidebar" style="background-color: #fff;padding-left:30px;padding-top:10px;">
  <h3 style="color:#f43059;">参会人员</h3>
  <div style="margin:0px;PADDING:0px; width:350px; height:560px; LINE-HEIGHT: 0px; OVERFLOW: auto;">

   	<ul class="list_styled custon-list" style="padding:0px;">
	
   	<c:forEach items="${userList}" var="user">
   	<ul class="test_box" style="margin:0px;padding:0px;border:0px;display:flex;">
     		
	  <li class="test_img" ><img src="${user.avatar}" style="border-radius:50%;width:75%;height:90%;" class="img-responsive" alt="profilePicture"/></li>
	  
	  <li style="width:45%;"><h5>${user.username}</h5><h5>${user.email}</h5></li>
		<li>
		  <div class="dropdown" >
			  <button type="button" id="btn1" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color: transparent;color: #000;padding: 0px;font-size: 6px;border: none;cursor: pointer;">
			  <span class="caret"></span>
	  			</button>
			  <ul class="dropdown-menu" aria-labelledby="btn1"  role="menu" style="right:0;position: absolute;background-color: #fdfdfd;min-width: 100px;box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);z-index: 200;">
				    <li role="presentation">
				    	<a class="aPoint" role="menuitem" tabindex="-1" style="cursor:pointer;" onclick=locking("${user.avatar}","${user.username}","${user.email}","${user.user_id}")>添加好友</a>
					</li>
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

		</div>
    <div class="clearfix"> </div>
  </div>
</div>

<script>
$(function(){
	//实例化编辑器
    var um = UM.getEditor('myEditor',{
    	initialContent:"",
    	autoHeightEnabled:false,
    });
    
    $("#send").click(function(){
    	if (!um.hasContents()) {  // 判断消息输入框是否为空
            // 消息输入框获取焦点
            um.focus();
            // 添加抖动效果
            $('.edui-container').addClass('am-animation-shake');
            setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
        } else {
        	//获取输入框的内容
        	var txt = um.getContent();
        	$.ajax({
        		url:"<%=request.getContextPath()%>/groupChat/insertGroupChat.action",
        		data:{
        			confer_id:"${conference.confer_id}",
        			text:txt
        		},
        		success:function(result){
        			document.write(result);
        		}
        	});
        }
    
    });
});
</script>

<!-- 更新历史聊天记录 -->
<c:forEach items="${groupChatList}" var="groupChat">
	<script type="text/javascript">	
	var msg = new Object();
   		msg.username="${groupChat.username}";
   		msg.avatar="${groupChat.avatar}";
   		msg.date="${groupChat.date}";
   		msg.text="${groupChat.text}";
   		msg.isSelf="${groupChat.user_id}"=="${user.user_id}"? 1:0;

		var objj = JSON.stringify(msg);
		addMessage(eval('('+objj.toString()+')'));
	</script>	
</c:forEach> 
</body>
</html>