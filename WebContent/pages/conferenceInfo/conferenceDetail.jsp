<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会议详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap/js/jquery.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/categories/conferenceDetail.js"></script> --%>
<script src="<%=request.getContextPath()%>/js/categories/categoriesInit.js"></script>
<link href="<%=request.getContextPath()%>/css/myStyle.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' media="all"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> 
	addEventListener("load", function() { 
		setTimeout(hideURLbar, 0); 
		}, false); 
	function hideURLbar(){ 
		window.scrollTo(0,1); 
		} 
</script>
</head>
<body>
<div class="header">
  <div class="container">
    <%-- <div class="logo"> 
		<a href="../"><img src="<%=request.getContextPath()%>/images/logo.png" alt="Nova"></a> 
	</div> --%>
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      <ul class="nav" id="nav">
       <!--  <li><a href="../">首页</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="services.html">Services</a></li>
        <li><a href="../pages/conferenceInfo/categories.jsp">会议类别</a></li>
        <li><a href="../pages/conferenceInfo/callFpaper.jsp">发布会议</a></li> -->
        
        <li><a href="../pages/conferenceInfo/callFpaper.jsp">会议发布</a></li>
        <li><a href="../index2.jsp">会议交友</a></li>
        <li><a href="../pages/conferenceInfo/categories.jsp">会议分类</a></li>       
        <li><a href="../index2.jsp">个人主页</a></li>
        <li><a href="services.html">关于我们</a></li>
        <div class="clearfix"></div>
      </ul>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
    </div>
    <div class="clearfix"> </div>
  </div>
  <div class="about">
  	<div class="container">
    	<section class="title-section">
      	<h1 class="title-header">会议详情</h1>
    	</section>
  	</div>
  </div>
</div>
<div style="margin-bottom: 4em;">
</div>
<div class="container">
	<div class="row">
		<article class="col-md-8">
			<c:forEach items="${conDetailList}" var="conDetail">
			 <h3 class="post_title">${conDetail.conference_name}(${conDetail.confer_abbreviate})</h3>
				<div class="row">
					<div class="col-md-12">
						<div class="entry-meta">
							<ul class="links">
								<li><i class="fa fa-calendar"></i> <fmt:formatDate type="date" value="${conDetail.conference_date}"/></li>
								<li><i class="fa fa-map-marker"></i> <a href="#">${conDetail.conference_location}</a></li>
								<!-- <li><i class="fa fa-link"></i></li> -->
								<li class="last"><i class="fa fa-bars"></i> ${conDetail.conference_class}</li>
							</ul>
						</div>
					</div>
				</div>
				<br></br>
				<p>
					${conDetail.conference_abstract}
				</p>
				<br></br>
				<div class="row">
					<div class="col-md-12">
						
							<a class="blog_btn myBtn" href="${conDetail.conference_link}">前往会议网站 »</a>
							<a href="<%=request.getContextPath()%>/conferenceInfo/queryById.action?conference_id=${conDetail.conference_id}">修改信息</a>
						<!-- <div class="entry-meta">
							<ul class="links">
								<li class="last"><i class="fa fa-bars"></i>xiugai</li>
							</ul>
						</div> -->
					</div>
				</div>
				</c:forEach>
				
 				<!-- Comments -->
			    <div class="comments1">
					<h3 style="color:#DF1728;font-size: 1.5em;margin:2em 0;"> 评 论 </h3>
						<div class="media">
							<a class="pull-left" href="#">
							 	<img class="media-object" style="max-width: 60px;" src="<%=request.getContextPath()%>/images/pic2.jpg" alt="">
							</a>
							<div class="media-body">
								<h4 class="media-heading">李华
									<small>2017-05-09 14:08:52</small>
								</h4>
								会议并做精彩报告和高端学术论坛，引领时代前沿。此番齐聚国家“千人计划”专2017年4月21-23日在昆明举行。 
								本次大会将就大数据领域内的热门议题和高新技术，邀请海内外知名学界代表出席会议并做精彩报告和高端学术论坛，
								引领时代前沿。此番齐聚国家“千人计划”专家，高校科研院所等
							</div>
						</div>
					<div class="media">
						<a class="pull-left" href="#">
							 <img class="media-object" style="max-width: 60px;" src="<%=request.getContextPath()%>/images/pic3.jpg" alt="">
						</a>
						<div class="media-body">
							<h4 class="media-heading">李华
								<small>2017-05-09 14:08:52</small>
							</h4>
								会议并做精彩报告和高端学术论坛，引领时代前沿。此番齐聚国家“千人计划”专2017年4月21-23日在昆明举行。 
								本次大会将就大数据领域内的热门议题和高新技术，邀请海内外知名学界代表出席会议并做精彩报告和高端学术论坛，
								引领时代前沿。此番齐聚国家“千人计划”专家，高校科研院所等
						</div>
					</div>
					<div class="media">
						<a class="pull-left" href="#">
							 <img class="media-object" style="max-width: 60px;" src="<%=request.getContextPath()%>/images/pic1.jpg" alt="">
						</a>
						<div class="media-body">
							<h4 class="media-heading">李华
								<small>2017-05-09 14:08:52</small>
							</h4>
								会议并做精彩报告和高端学术论坛，引领时代前沿。此番齐聚国家“千人计划”专
						</div>
					</div>
			      </div>
	</article>
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
            <div class="clearfix"> </div>
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

<%-- <div align="center">
	<form action="<%=request.getContextPath()%>/conference/queryCFP.action" method="post">
	<c:forEach items="${conList }" var="conference" varStatus="status">
		<input value="${conference.conference_name}" />
        <input value="${conference.conference_date}" />
        <input value="${conference.conference_class}" />
    </c:forEach>
		<button type="submit">添加</button>
	</form>
</div> --%>
</body>
</html>