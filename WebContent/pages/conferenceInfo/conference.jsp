<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 此页面用来   进入会议分类页面  显示会议的简略信息 -->
<body>
	<c:forEach items="${conList}"  var="conference">
    <h3 class="post_title"><a style="color: #333;" href="<%=request.getContextPath()%>/conferenceInfo/queryDetail.action?conference_id=${conference.conference_id}">${conference.conference_name}(${conference.confer_abbreviate})</a></h3>
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
      <%-- <a href="<%=request.getContextPath()%>/conferenceInfo/queryDetail.action?conference_id=${conference.conference_id}" class="blog_btn">查看会议详情</a>  --%>
      <br> </br> <br> </br>
	</c:forEach>
</body>
</html>