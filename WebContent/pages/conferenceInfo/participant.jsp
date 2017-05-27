<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>参会启事</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome/css/font-awesome.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap/js/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' media="all"/>
<link href="<%=request.getContextPath()%>/css/myStyle.css" rel='stylesheet' type='text/css'/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script>
/* function myCheck(){  
	   var name=document.forms["myForm"]["conference_name"].value;
	   if (name==null || name==""){
	     alert("会议名称必须填写");
	     return false;
	   }
	   var id=document.forms["myForm"]["conference_id"].value;
	   if (id==null || id==""){
	     alert("会议缩写必须填写");
	     return false;
	   }
	   var date=document.forms["myForm"]["conference_date"].value;
	   if (date==null || date==""){
	     alert("会议开始日期必须填写");
	     return false;
	   }
	   var loc=document.forms["myForm"]["conference_location"].value;
	   if (loc==null || loc==""){
	     alert("会议地点必须填写");
	     return false;
	   }
	   var fare=document.forms["myForm"]["conference_fare"].value;
	   console.log(fare+"---------------------");
	   if (fare==null || fare==""){
	     alert("会议价格必须填写");
	     if(isNaN(fare)){
	    	 alert("请输入数字!")
	    	 document.myForm.conference_fare.focus();
	    	 return false;
	     }
	     return false;
	   }  
	   var link=document.forms["myForm"]["conference_link"].value;
	   if (link==null || link==""){
	     alert("会议网址必须填写");
	     return false;
	   }	  
} */
</script>
</head>
<body>
<div class="header">		
  <div class="container">
    <%-- <div class="logo"> 
		<a href="../index2.jsp"><img src="<%=request.getContextPath()%>/images/logo.png" alt="Nova"></a> </div> --%>
    <div class="menu"> <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav_icon.png" alt="" /> </a>
      <ul class="nav" id="nav">
        <li><a href="callFpaper.jsp">会议发布</a></li>
        <li><a href="../index2.jsp">会议交友</a></li>
        <li><a href="categories.jsp">会议分类</a></li>       
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
      		<h1 class="title-header">发布参会启事</h1>
    	</section>
  	</div>
   </div>
</div>
<div style="margin-bottom: 4em;"></div>
<div class="participant">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form name="myForm" class="form-horizontal" onsubmit="return myCheck()" method="post" action="<%=request.getContextPath()%>/conferenceInfo/insertParticipant.action">
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceName" class="col-sm-2 control-label" style="width: 19.66666667%;">会议名称
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_name" style="height:39px;" type="text" class="form-control" id="conferenceName" autofocus required placeholder="请输入会议名称"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceNameAbbreviation" class="col-sm-2 control-label" style="width: 19.66666667%;">会议缩写
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="confer_abbreviate" style="height:39px;" type="text" class="form-control" id="conferenceNameAbbreviation" required placeholder="请输入会议缩写名称，如CSAM2017"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceClass" class="col-sm-2 control-label" style="width: 19.66666667%;">会议类别
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<select name="conference_class" style="height:39px;" class="form-control">
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
							<input name="conference_date" style="height:39px;" type="date" class="form-control" id="conferenceStartDate" required placeholder="请选择会议开始日期"  />
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceLocation" class="col-sm-2 control-label" style="width: 19.66666667%;">会议地点
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_location" style="height:39px;" type="text" class="form-control" id="conferenceLocation" required placeholder="请输入会议地点"  />
							<!-- <textarea name="conference_location" class="form-control" id="conferenceLocation" rows="2" placeholder="请输入会议地点"></textarea> -->
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceFare" class="col-sm-2 control-label" style="width: 19.66666667%;">会议门票价格
							<strong class="star">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">	
							<input name="conference_fare" type="text" style="height:39px;" class="form-control" id="conferenceFare" required placeholder="请填写门票价格(必填)"/>
						</div>
					</div>
					<div class="form-group" style="margin-bottom: 25px;">
						<label for="conferenceLink" class="col-sm-2 control-label" style="width: 19.66666667%;">会议链接
							<strong style="margin-left: 4px;color: #fff;">*</strong>
						</label>
						<div class="col-sm-10" style="width: 80.33333333%;">
							<input name="conference_link" type="text" style="height:39px;" class="form-control" id="conferenceLink" placeholder="请填写会议网站"/>
						</div>
					</div>
					 <!-- <input type="submit" value="发布"/> -->
					<!-- <div style="text-align:center; display:inline"> -->
					
						<!-- <span><input type="submit" class="btn btn-default btn-info">取消</button></span> -->
					<div class="pagination pagination__posts">
						<a class="blog_btn myBtn" href="<%=request.getContextPath()%>/pages/index2.jsp"> 取 消 </a>			
						<button type="submit" class="blog_btn myBtn" > 发 布 </button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="contact">
  <div class="container">
    <!-- <div class="row contact_top">
      <div class="col-md-4 contact_details">
        <h5>Mailing address:</h5>
        <div class="contact_address"> 321 Laoreet quis risus nec, Donec eget</div>
      </div>
      <div class="col-md-4 contact_details">
        <h5>Call us:</h5>
        <div class="contact_address"> +1 800 123 1234<br>
        </div>
      </div>
      <div class="col-md-4 contact_details">
        <h5>Email us:</h5>
        <div class="contact_mail"> info@companyname.com</div>
      </div>
    </div> -->
    <!-- <div class="contact_bottom">
      <h3>Contact Form</h3>
      <p>Mauris a vulputate lectus at blandit nisi. Donec eleifend vel felis vitae auctor aenean rhoncus sapien sollicitudin leo interdum.</p>
      <form method="post" action="contact-post.html">
        <div class="contact-to">
          <input type="text" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
          <input type="text" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" style="margin-left: 10px">
          <input type="text" class="text" value="Subject" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Subject';}" style="margin-left: 10px">
        </div>
        <div class="text2">
          <textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message..</textarea>
        </div>
        <div> <a href="#" class="submit">Send Message</a> </div>
      </form> -->
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