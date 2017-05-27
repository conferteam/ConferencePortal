<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>征稿启事</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap/js/layer.js"></script>
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' media="all"/>
<link href="<%=request.getContextPath()%>/css/myStyle.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/layer.css" media="all">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> 
	addEventListener("load", function() 
		{ setTimeout(hideURLbar, 0); }, false); 
	function hideURLbar(){ 
			window.scrollTo(0,1); 
		} 
</script>
<script>
   /*  $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
       */
    /*   function onSubmit () {
    	  $("#myForm").ajaxSubmit(function (message) {
    		  console.log(message);
    		  return false;
    	  });
    	  return false;
      } */
      
/* $('#post').on("click",function(){
	var url = getRootPath() + '/pages/index2.jsp';
	layer.open({
		type:2,
		title:'发布成功',
		area:['750px','346px'],
		maxmin:false,
		shadeClose:true,
		scrollbar:true,
		shift:Math.floor(Math.random()*6),
		content:url
	});
}); */
$('#post').on("click",function(){
	 layer.open({
		  type: 1,
		  area: ['600px', '360px'],
		  shadeClose: true, //点击遮罩关闭
		  content: '\<\div style="padding:20px;">自定义内容\<\/div>'
		  });
});
</script>
</head>
<body>
<div class="header">
  <div class="container">
    <%-- <div class="logo"> 
		<a href="../index2.jsp"><img src="<%=request.getContextPath()%>/images/logo.png" alt="Nova"></a> </div> --%>
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      <ul class="nav" id="nav" >
        <!-- <li><a href="../index2.jsp">首页</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="services.html">Services</a></li>
        <li><a href="categories.jsp">会议类别</a></li>
        <li class="current"><a href="callFpaper.jsp">发布会议</a></li> -->
        <li class="current myPadding"><a href="callFpaper.jsp">会议发布</a></li>
        <li class="myPadding"><a href="../index2.jsp">会议交友</a></li>
        <li class="myPadding"><a href="categories.jsp">会议分类</a></li>       
        <li class="myPadding"><a href="../index2.jsp">个人主页</a></li>
        <li class="myPadding"><a href="about.html">关于我们</a></li>
        <div class="clearfix"></div>
      </ul>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
    </div>
    <div class="clearfix"> </div>
  </div>
  <div class="about">
  	<div class="container">
    	<section class="title-section">
     	 	<h1 class="title-header">发布征稿和会议</h1>
    	</section>
  	</div>
   </div>
</div>
<!-- <div class="about">
  <div class="container">
    <section class="title-section">
      <h1 class="title-header">发布征稿和会议</h1>
    </section>
  </div>
</div> -->
<div style="margin-bottom: 4em;">
</div>
<div>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" >
				<form name="myForm" class="form-horizontal" onsubmit="return myCheck()" method="post" action="<%=request.getContextPath()%>/conferenceInfo/insert.action">
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceName" class="col-sm-2 control-label" style="width: 19.66666667%;">会议名称
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_name" type="text" class="form-control myInput" id="conferenceName" style="height:39px;" required autofocus placeholder="请输入会议名称"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceNameAbbreviation" class="col-sm-2 control-label" style="width: 19.66666667%;">会议英文缩写
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="confer_abbreviate" type="text" class="form-control myInput" id="conferenceNameAbbreviation" required style="height:39px;" placeholder="请输入会议英文缩写名称，如IEEE2017"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceClass" class="col-sm-2 control-label" style="width: 19.66666667%;">会议类别
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<select name="conference_class" class="form-control myInput" style="height:39px;">
								<option>电子与通信</option>
								<option>物理，化学与环境科学</option>
								<option>农业，生物与地球科学</option>
								<option>临床医学</option>
								<option>工程技术</option>
								<option>生命科学</option>
								<option>艺术与人文</option>
								<option>社会与行为科学</option>
								<option>工商与金融</option>
							</select>
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceStartDate" class="col-sm-2 control-label" style="width: 19.66666667%;">会议开始日期
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_date" type="date" class="form-control myInput" style="height:39px;" required id="conferenceStartDate" placeholder="请输入会议开始日期"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="CFPEndDate" class="col-sm-2 control-label" style="width: 19.66666667%;">征稿截止日期
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="paper_due" type="date" class="form-control myInput" id="CFPEndDate" style="height:39px;" required placeholder="请输入征稿截止日期"  />
						</div>
					</div>
					<!-- div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceLocation" class="col-sm-2 control-label">会议地点
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10">
							<textarea name="conference_location" class="form-control" id="conferenceLocation" rows="1" placeholder="请输入会议地点"  ></textarea>
						</div>
					</div> -->
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceLocation" class="col-sm-2 control-label" style="width: 19.66666667%;">会议地点
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_location" style="height:39px;" type="text" class="form-control myInput"  required id="conferenceLocation" placeholder="请输入会议地点"  />
							<!-- <textarea name="conference_location" class="form-control" id="conferenceLocation" rows="2" placeholder="请输入会议地点"></textarea> -->
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceLink" class="col-sm-2 control-label" style="width: 19.66666667%;">会议网站
							<strong style="margin-left: 4px;color: #fff;">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_link" type="text" class="form-control myInput" id="conferenceLink" style="height:39px;" placeholder="请填写会议网址"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceLocation" class="col-sm-2 control-label" style="width: 19.66666667%;">会议简介
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<textarea name="conference_abstract" class="form-control myInput" id="conferenceLocation" rows="3"  required  placeholder="请输入会议简介"  ></textarea>
						</div>
					</div>
					 <!-- <input type="submit" value="发布"/> -->
					<!-- <div style="text-align:center; display:inline"> -->
					
						<!-- <span><input type="submit" class="btn btn-default btn-info">取消</button></span> -->
					<div class="pagination pagination__posts">
						<!-- <button class="blog_btn" onsubmit = "return false"> 取 消 </button>	 -->
						<a class="blog_btn myBtn" href="<%=request.getContextPath()%>/pages/index2.jsp"> 取 消 </a>			
						<button id="post" type="submit" class="blog_btn myBtn" > 发 布 </button>
						<!-- <button id="postBtn" class="blog_btn" > 发 布 </button> -->
					</div>
				</form>
			</div>
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