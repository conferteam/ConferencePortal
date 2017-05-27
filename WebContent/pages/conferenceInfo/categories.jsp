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
<script src="<%=request.getContextPath()%>/js/categories/categoriesInit.js"></script>
<script src="<%=request.getContextPath()%>/js/categories/pages.js"></script>
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
</script>	
</head>

<body>
<div class="header">
  <div class="container">
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      <ul class="nav" id="nav">
      	<li><a href="callFpaper.jsp">会议发布</a></li>
        <li><a href="../index2.jsp">会议交友</a></li>
        <li class="current"><a href="categories.jsp">会议分类</a></li>       
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
<div class="container" >
  <div class="row">
    <div class="col-md-8 blog_grid">
		<div id="divCon"> 
		<!-- 此div内3容对应conference.jsp，为会议的简略信息 -->
	 	</div>
       
     	<div class="pagination pagination__posts">
        <ul id="printpages" class="pagination">
          <li class="active"><a style="color: #db2432;" href="#">1</a></li>
          <li><a style="color: #db2432;" href="#" class="inactive">2</a></li>
          <li><a style="color: #db2432;" href="#" class="inactive">3</a></li>
          <li><a style="color: #db2432;" href="#" class="inactive">4</a></li>
          <li class="next"><a style="color: #db2432;" href="#">下一页</a></li>
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
