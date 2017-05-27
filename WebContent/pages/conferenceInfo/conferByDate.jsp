<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 此页面为最新发布会议 -->
<body>
	<ul class="sidebar">
        <h3><i class="fa fa-align-left"></i> 最新发布</h3>
        <c:forEach items="${conByDateList}"  var="conference">
        <li><a href="<%=request.getContextPath()%>/conferenceInfo/queryDetail.action?conference_id=${conference.conference_id}">${conference.conference_name}</a></li>
        </c:forEach>
	</ul>
</body>
</html>