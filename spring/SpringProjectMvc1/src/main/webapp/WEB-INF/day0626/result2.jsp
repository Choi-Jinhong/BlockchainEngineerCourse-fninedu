<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<h1>result2 로부터 받은 파일입니다</h1>
<h2>HelloConteroller로부터 포워드</h2>
<b>상품명: ${sangpum }</b><br>
<b>가격: <fmt:formatNumber value="${price }" pattern="#,##0"></fmt:formatNumber> </b><br>

</body>
</html>