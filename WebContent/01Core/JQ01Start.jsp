<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ01Start.jsp</title>
<script src="../common/jquery/jquery-3.5.1.js"></script>
<script>
	$(document).ready(function(){
		alert("jQuery 시작하기 1");
	});
	
	$().ready(function(){
		alert("jQuery 시작하기 2");
	});
	
	jQuery(function(){
		alert("jQuery 시작하기 3");
	});
	
	$(function(){
		alert("jQuery 시작하기 4");
	});
</script>
</head>
<body>
	
	<h2>jQuery 사용하기</h2>
	<script>
	alert("HTML 문서의 끝");	
	</script>

</body>
</html>