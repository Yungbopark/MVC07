<%@ page import="kr.bit.model.MemberDAO" %>
<%@ page import="kr.bit.model.MemberVO" %><%--
  Created by IntelliJ IDEA.
  User: Jungwoo Park
  Date: 8/30/2022
  Time: 8:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/memberUpdate.do" method="post">
    <table>
        <%
            if (memberVO != null) {
        %>
        <tr>
            <td colspan="2"><%=memberVO.getName()%> 회원 정보 상세보기</td>
        </tr>
        <tr>
            <td>번호</td>
            <td><%=memberVO.getNum()%></td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><%=memberVO.getId()%></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><%=memberVO.getPass()%></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><%=memberVO.getName()%></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="text" name="age" id="age" value="<%=memberVO.getAge()%>"></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="text" name="email" id="email" value="<%=memberVO.getEmail()%>"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" id="phone" value="<%=memberVO.getPhone()%>"></td>
        </tr>
        <input type="hidden" name="num" value="<%=memberVO.getNum()%>">
        <% } else{  %>
        <tr>
            <td>일치하는 회원이 없습니다.</td>
        </tr>
<% } %>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="수정하기" />
                <input type="reset" value="취소" />
                <input type="button" value="리스트" onclick="location.href='${ctx}/memberList.do'" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
