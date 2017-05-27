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
	<title>私信</title>
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
	
	<script src="<%=request.getContextPath()%>/js/friendship/chat.js"></script>
</head>
<body>

<div class="header" style=" background: url(<%=request.getContextPath()%>/images/bg-pattern),linear-gradient(to left,#7b4397,#dc2430);
    background-image: url(<%=request.getContextPath()%>/images/bg-pattern.png), linear-gradient(to left, rgb(123, 67, 151), rgb(220, 36, 48));">
  <div class="container">
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>        
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
      
<div id="main">
<div class="am-g am-g-fixed" style="border-radius: 10px;padding-top:30px; width:650px; transform: none!important;position: relative;display: flex;flex-direction: column;color: #14171a;font-size: 14px;line-height: 18px;">

    <!-- title start -->
	<div style="background-color: #fff;height:45px;align-items: center;border-bottom: 1px solid #e6ecf0;box-sizing: border-box;display: flex;flex-shrink: 0;color: #657786;">
	<div style="justify-content: center;align-items: center;display: inline-flex;flex: 1 1 auto;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;min-width: 0;">
		<div aria-haspopup="true" data-has-custom-avatar="false" style="margin-right: 10px;    position: relative;    text-align: center;display: block;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px;">
		<div style="display: block;text-align: center;color: #66757f;    font-size: 21px;font-weight: 300;line-height: 28px">
		<div style="width: 38px;height: 38px;border-radius: 100%;display: block;cursor: default;text-transform: none;color: inherit;text-align: center;text-rendering: auto;letter-spacing: normal;word-spacing: normal;text-indent: 0px;text-shadow: none;-webkit-writing-mode: horizontal-tb;">
   		<div style="border-radius: 100%;font-size: 0;height: 100%;line-height: 0;overflow: hidden;position: relative;width: 100%; transform: none!important;display: block;cursor: default;">
			<span style="box-sizing:border-box;overflow:hidden;font-size:0;line-height:0;">
	   		<img src="${friendsUser.avatar}">
	   		</span>	
		</div>
		</div>
		</div>
   		</div>
   		<div style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;    display: block;    color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px">
   		<div style="display: block;white-space: nowrap!important;word-wrap: normal!important;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
	   		<span style="max-width: 100%;overflow: hidden!important;text-overflow: ellipsis!important;white-space: nowrap!important;word-wrap: normal!important;color: #66757f;font-size: 21px;font-weight: 300;line-height: 28px;">
	   		${friendsUser.username}
	   		</span>
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
					<p ff="text" style="color: #333!important;white-space: pre-wrap; word-wrap: break-word;font-size: 14px;line-height: 20px;margin: 0;-webkit-locale: auto;    display: block;-webkit-margin-before: 0em;-webkit-margin-after: 0em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">消息内容</p>
				    <p ff="date" style="color: #666!important;white-space: pre-wrap;word-wrap: break-word;font-size: 14px;line-height: 20px;margin: 0;-webkit-locale: auto;    display: flex;-webkit-margin-before: 0em; -webkit-margin-after: 0em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">时间</p>
					</div>
				</div>
			</li>
		</ul>
	  </div>
	</div>
	<!-- ChatBox end-->
	
	<!-- EditBox start-->
	<div style="flex-shrink: 0;display: block;height:300px;">
	<div style="background-color: #fff;display: block;box-sizing: border-box;width: 100%;padding: 10px;border-top: 1px solid #e6ecf0;">
	<div style="margin-top: 0em;" >
	
	<!-- message input start -->
	<div id="EditBox" style="width:100%;">
	    <!--style给定宽度可以影响编辑器的最终宽度-->
	    <script type="text/plain" id="myEditor" style="background-color: #fff;z-index:100;margin:0px;padding-left:10px;padding-right:0px;border-color: #C6E7FB !important;border-radius: 3px;border-style: solid;box-sizing: border-box;max-height:100px;min-height: 70px!important;position: relative;width: 646px;"></script>
    </div>
    <div style="text-align:right;padding-top: 10px;">
    	<button id="close"  style="height:30px;width:60px;display: inline-block;  background: rgb(244, 48, 89);border: 1px solid transparent;color: #fff;text-align: center;" >
   		<a style="color:#fff;" href="<%=request.getContextPath()%>/messages/queryAll.action">关闭</a>
   		</button>
	    <button  style="height:30px;width:60px;display: inline-block;  background: rgb(244, 48, 89);border: 1px solid transparent;color: #fff;text-align: center;" >
	    <a id="send" style="color:#fff;" href="">发送</a>
	    </button>
    </div>
    <!-- message input end -->
    
    </div>
    </div>
    </div>  
    <!-- EditBox end-->
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
        		url:"<%=request.getContextPath()%>/chat/insertChat.action",
        		data:{
        			get_user_id:"${friendsUser.user_id}",
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
<c:forEach items="${chatList}" var="messages">
	<script type="text/javascript">	
	var msg = new Object();
   		msg.send_user_id="${messages.send_user_id}";
   		msg.username="${messages.username}";
   		msg.avatar="${messages.avatar}";
   		msg.date="${messages.date}";
   		msg.text="${messages.text}";
   		msg.get_user_id="${messages.get_user_id}";
   		msg.isSelf="${messages.send_user_id}"=="${user.user_id}"? 1:0;

		var objj = JSON.stringify(msg);
		addMessage(eval('('+objj.toString()+')'));
	</script>	
</c:forEach> 


</body>
</html>