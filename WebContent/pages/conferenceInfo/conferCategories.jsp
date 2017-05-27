<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <!-- 此页面为会议所有类别 -->
<body>
		<ul class="sidebar">
        	<h3><i class="fa fa-list"></i> 会议类别</h3>
        	<c:forEach items="${conCategoriesList}" var="Categories">
        	<li id="byCate"><a href="<%=request.getContextPath()%>/conferenceInfo/queryByCategories.action?categories_id=${Categories.categories_id}">${Categories.conference_class}</a></li>
        	</c:forEach> 
      	</ul>
</body>
</html>