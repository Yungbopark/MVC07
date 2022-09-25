<%--
  Created by IntelliJ IDEA.
  User: Jungwoo Park
  Date: 9/3/2022
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>번호</td>
        <td>아이디</td>
        <td>이름</td>
        <td>나이</td>
        <td>이메일</td>
        <td>전화번호</td>
        <td>삭제</td>
    </tr>
<c:forEach var="memberVO" items = "${list}">
    <%--${list}는 MemberListController 에서 setAttribute 했던 VO들이 들어있음--%>
    <tr>
        <td>${memberVO.num}</td>
        <td>${memberVO.id}</td>
        <td>${memberVO.pass}</td>
        <td>${memberVO.name}</td>
        <td>${memberVO.email}</td>
        <td>${memberVO.phone}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
