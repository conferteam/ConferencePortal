<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Nova</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap/js/jquery.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
		});
	});
</script>
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<div class="header" style="background: url(<%=request.getContextPath()%>/images/bg-pattern),linear-gradient(to left,#7b4397,#dc2430);
    background-image: url(<%=request.getContextPath()%>/images/bg-pattern.png), linear-gradient(to left, rgb(123, 67, 151), rgb(220, 36, 48));">
  <div class="container">
    <!-- <div class="logo"> <a href="index2.jsp"> </div> -->
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      <ul class="nav" id="nav">
       
        <li class="current"><a href="pages/index2.jsp">个人主页</a></li>
        <li><a href="<%=request.getContextPath()%>/pages/conferenceInfo/callFpaper.jsp">会议发布</a></li>
        <li><a href="<%=request.getContextPath()%>/pages/conferenceInfo/categories.jsp">会议分类</a></li>    
        <li><a href="<%=request.getContextPath()%>/messages/queryAll.action">会议交友</a></li>
        <li><a href="about.html">关于我们</a></li>
        <div class="clear"></div>
      </ul>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script> 
    </div>
    <div class="clearfix"> </div>
  </div>
</div>
<div class="banner text-center">
  <div class="container">
    <div class="banner-info">
      <h1>Lorem ipsum dolor sit amet</h1>
      <p>nteger nec odio praesent libero. Sed cursus ante dapibus diamsed nisi.<br>
        Nulla quis sem at nibh elementum imperdiet</p>
      <label class="page-scroll"><a class="banner-btn class scroll" href="#feature"><i class="fa fa-angle-double-down fa-4x"></i></a></label>
    </div>
  </div>
</div>
<div class="main">
<div class="content_white">
  <h2>Welcome to our website!</h2>
  <p>Quisque cursus metus vitae pharetra auctor, sem massa mattis semat interdum magna.</p>
</div>
<div class="featured_content" id="feature">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-3 feature_grid1"> <i class="fa fa-cloud-download fa-3x"></i>
        <h3 class="m_1"><a href="#">Legimus graecis</a></h3>
        <p class="m_2">Lorem ipsum dolor sit amet, facilisis egestas sodales non luctus, sem quas potenti malesuada vel phasellus.</p>
        <a href="#" class="feature_btn">More</a> </div>
      <div class="col-md-3 feature_grid1"> <i class="fa fa-shield fa-3x"></i>
        <h3 class="m_1"><a href="#">Mazim minimum</a></h3>
        <p class="m_2">Lorem ipsum dolor sit amet, facilisis egestas sodales non luctus, sem quas potenti malesuada vel phasellus.</p>
        <a href="#" class="feature_btn">More</a> </div>
      <div class="col-md-3 feature_grid1"> <i class="fa fa-flask fa-3x"></i>
        <h3 class="m_1"><a href="#">Modus altera</a></h3>
        <p class="m_2">Lorem ipsum dolor sit amet, facilisis egestas sodales non luctus, sem quas potenti malesuada vel phasellus.</p>
        <a href="#" class="feature_btn">More</a> </div>
      <div class="col-md-3 feature_grid2"> <i class="fa fa-bar-chart fa-3x"></i>
        <h3 class="m_1"><a href="#">Melius eligendi</a></h3>
        <p class="m_2">Lorem ipsum dolor sit amet, facilisis egestas sodales non luctus, sem quas potenti malesuada vel phasellus.</p>
        <a href="#" class="feature_btn">More</a> </div>
    </div>
  </div>
</div>
<div class="container">
  <div class="content_white">
    <h2>Vel ad aliquid copiosae</h2>
    <p>No cum agam appareat vituperata ateum iusto paulo dignissim</p>
  </div>
  <div class="testimonial">
    <div class="row testimonial_top">
      <div class="col-md-6">
        <ul class="test_box">
          <li class="test_img"><img src="<%=request.getContextPath()%>/images/pic1.jpg" class="img-responsive" alt=""/> </li>
          <li class="test_desc">
            <h4><a href="#">Impetus tincidunt</a></h4>
            <p>Vel ad aliquid copiosae, cum id impetus tincidunt, solum option laoreet ei quo. No cum agam appareat vituperata ateum iusto paulo dignissim.</p>
          </li>
          <div class="clearfix"> </div>
        </ul>
      </div>
      <div class="col-md-6">
        <ul class="test_box">
          <li class="test_img"><img src="<%=request.getContextPath()%>/images/pic2.jpg" class="img-responsive" alt=""/> </li>
          <li class="test_desc">
            <h4><a href="#">Paulo dignissim</a></h4>
            <p>Vel ad aliquid copiosae, cum id impetus tincidunt, solum option laoreet ei quo. No cum agam appareat vituperata ateum iusto paulo dignissim.</p>
          </li>
          <div class="clearfix"> </div>
        </ul>
      </div>
    </div>
    <div class="row testimonial_bottom">
      <div class="col-md-6">
        <ul class="test_box">
          <li class="test_img"><img src="<%=request.getContextPath()%>/images/pic3.jpg" class="img-responsive" alt=""/> </li>
          <li class="test_desc">
            <h4><a href="#">Vituperata ateum</a></h4>
            <p>Vel ad aliquid copiosae, cum id impetus tincidunt, solum option laoreet ei quo. No cum agam appareat vituperata ateum iusto paulo dignissim.</p>
          </li>
          <div class="clearfix"> </div>
        </ul>
      </div>
      <div class="col-md-6">
        <ul class="test_box">
          <li class="test_img"><img src="<%=request.getContextPath()%>/images/pic4.jpg" class="img-responsive" alt=""/> </li>
          <li class="test_desc">
            <h4><a href="#">Appareat vituperat</a></h4>
            <p>Vel ad aliquid copiosae, cum id impetus tincidunt, solum option laoreet ei quo. No cum agam appareat vituperata ateum iusto paulo dignissim.</p>
          </li>
          <div class="clearfix"> </div>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="footer">
  <div class="footer_midle">
    <div class='container'>
      <div class="row">
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
      </div>
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
