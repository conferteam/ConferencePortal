<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会议分类</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/categories/conferenceDetail.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/categories/categoriesInit.js"></script> --%>
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/css/myStyle.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script>
<%-- $(document).ready(function(){
	$.ajax({
		url: "<%=request.getContextPath()%>/pages/conferenceInfo/queryCategories.action",
		success: function (data){ 
			console.log(data, "ccc");
			document.getElementById("Categories").innerHTML=data;
			/* $("#byCategories").html(data);  */
			}
	});
}); --%>
</script>
<script type="text/javascript">
/* function ajaxfresh(url){
	$.ajax({
		type : "get",
		async : false,
		url : url,
		data : '{type:1}',
		success : function(page){
			$("#divCon").html(page);
		},
		error : function(){
				console.log("faild");
		}
	});
} */
<%-- $.ajax({
	url: "<%=request.getContextPath()%>/pages/conferenceInfo/queryByDate.action",
	success: function (data){ 
		console.log(data, "bbb");
		/* document.getElementById("byDate").innerHTML=data; */
		$("#byDate").html(data); 
		}
}); --%>
<%-- $.ajax({
	url: "<%=request.getContextPath()%>/conference/queryByCategories.action",
	success: function (data){ 
		console.log(data, "ddd");
		document.getElementById("divCon").innerHTML=data;
		}
}); --%>
<%-- $.ajax({
	url: "<%=request.getContextPath()%>/conference/queryCategories.action",
	success: function (data){ 
		console.log(data, "ccc");
		document.getElementById("byCategories").innerHTML=data;
		/* $("#byCategories").html(data);  */
		}
}); --%>

 <%-- function onCCC(){
		$.ajax({
			url: "<%=request.getContextPath()%>/conference/queryByCategories.action",
			success: function (data){ 
				console.log(data, "ddd");
				document.getElementById("divCon").innerHTML=data;
				}
		});
}
 --%>

</script>	
</head>

<body>
<div class="header">
  <div class="container">
    <%-- <div class="logo"> <a href="../"><img src="<%=request.getContextPath()%>/images/logo.png" alt="Nova"></a> </div> --%>
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      <ul class="nav" id="nav">
        <!-- <li><a href="../">首页</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="services.html">Services</a></li>
        <li class="current"><a href="../pages/conferenceInfo/categories.jsp">会议类别</a></li>
        <li><a href="../pages/conferenceInfo/callFpaper.jsp">发布会议</a></li> -->
        
        <li><a href="../pages/conferenceInfo/callFpaper.jsp">会议发布</a></li>
        <li><a href="../index2.jsp">会议交友</a></li>
        <li class="current"><a href="../pages/conferenceInfo/categories.jsp">会议分类</a></li>       
        <li><a href="../index2.jsp">个人主页</a></li>
        <li><a href="about.html">关于我们</a></li>
        <div class="clearfix"></div>
      </ul>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
    </div>
    <div class="clearfix"> </div>
  </div>
</div>
<div class="about">
</div>
<div style="margin-bottom: 4em;">
</div>
<div class="container">
  <div class="row">
    <div class="col-md-8 blog_grid">
		<div id="divCon"> 
		<!-- 此div内容对应conference.jsp，为会议的简略信息 -->
		<c:forEach items="${conByCategoriesList}"  var="conference">
    	<h2 class="post_title">${conference.conference_name}(${conference.confer_abbreviate})</h2>
    	<ul class="links">
          <li><i class="fa fa-calendar"></i> <fmt:formatDate type="date" value="${conference.conference_date}"/></li>
          <li><i class="fa fa-map-marker"></i> ${conference.conference_location} </li>
          <li class="last"><i class="fa fa-bars"></i> ${conference.conference_class}</li>
    	</ul>
     	<p style="overflow: hidden;
   					text-overflow: ellipsis;
   					display: -webkit-box;
   					-webkit-box-orient: vertical;
   					-webkit-line-clamp:3;">
   					${conference.conference_abstract}</p>
      <a href="<%=request.getContextPath()%>/conferenceInfo/queryDetail.action?conference_id=${conference.conference_id}" class="blog_btn myBtn">查看会议详情</a> 
      <br> </br> <br> </br>
	</c:forEach>
	 	</div>
       
     	<div class="pagination pagination__posts">
        <ul>
          <li class="active"><a href="#">1</a></li>
          <!-- <li><a href="#" class="inactive">2</a></li>
          <li><a href="#" class="inactive">3</a></li>
          <li><a href="#" class="inactive">4</a></li>
          <li class="next"><a href="#">下一页</a></li> -->
        </ul>
      </div>
    </div>
    <div class="col-md-4 blog_sidebar">
      <div id="Categories">
      <!-- 此div内容对应conferCategories.jsp，为会议的所有类别 -->
      </div>
      <div id="byDate">
       <!-- 此div内容对应conferByDate.jsp，为最新发布的会议 -->
      </div>
      <ul class="sidebar">
        <h3>最受欢迎</h3>
        <li><a href="#">Mirum est notare quam littera</a></li>
        <li><a href="#">Vivamus efficitur gravida mi</a></li>
        <li><a href="#">Mauris lacinia fringilla lacus</a></li>
        <li><a href="#">Curabitur consequat vel nisl et eleifend</a></li>
        <li><a href="#">Suspendisse laoreet luctus</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="footer">
  <div class="footer_midle">
    <div class='container'>
      <!-- <div class="row">
        <div class="col-md-3">
          <ul class="social_left">
            <li class="facebook"><a href="#"><i class="fa fa-facebook-square fa-3x"></i></a></li>
            <li class="fb_text">
              <h4><a href="#">Follow us on Facebook</a></h4>
            </li>
            <div class="clearfix"> </div>
          </ul>
        </div>
        <div class="col-md-3">
          <ul class="social_left">
            <li class="facebook"><a href="#"><i class="fa fa-twitter-square fa-3x"></i></a></li>
            <li class="fb_text">
              <h4><a href="#">Follow us on Twitter</a></h4>
            </li>
            <div class="clearfix"> </div>
          </ul>
        </div>
        <div class="col-md-3">
          <ul class="social_left">
            <li class="facebook"><a href="#"><i class="fa fa-google-plus-square fa-3x"></i></a></li>
            <li class="fb_text">
              <h4><a href="#">Follow us on Google +</a></h4>
            </li>
            <div class="clearfix"> </div>
          </ul>
        </div>
        <div class="col-md-3">
          <ul class="social_left">
            <li class="facebook"><a href="#"><i class="fa fa-linkedin-square fa-3x"></i></a></li>
            <li class="fb_text">
              <h4><a href="#">Follow us on LinkedIn</a></h4>
            </li>
            <div class="clearfix"> 
            </div>
          </ul>
        </div>
      </div> -->
    </div>
  </div>
  <div class="footer_bottom">
    <div class="copy">
      <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
    </div>
  </div>
</div>
</body>
</html>
