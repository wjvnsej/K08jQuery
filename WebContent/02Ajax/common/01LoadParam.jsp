<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 01LoadParam.jsp --%>

<%
String params = request.getParameter("params");
if(params.equals("good")){
%>
	<h3 style="color: red;">Good! 오늘은 좋은날~</h3>
<%
}
else if(params.equals("bad")) {
%>
	<h3 style="color: red;">Bad! 운수나쁜날ㅜ</h3>
<%
}
%>