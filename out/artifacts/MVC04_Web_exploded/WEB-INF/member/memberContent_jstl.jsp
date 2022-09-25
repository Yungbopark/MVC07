<%@ page import="kr.bit.model.MemberDAO" %>
<%@ page import="kr.bit.model.MemberVO" %><%--
  Created by IntelliJ IDEA.
  User: Jungwoo Park
  Date: 8/30/2022
  Time: 8:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Title</title>
    <script type="text/javascript">
    function frmreset() {
            document.form1.reset();
    }

    function update() {
            document.form1.action = "<c:url value="/memberUpdate.do"/> ";
            document.form1.submit();
        }
    </script>
</head>
<body>
<div class="container">
    <h2>회원관리시스템</h2>
    <div class="panel panel-default">
        <div class="panel-heading">
            <c:if test="${sessionScope.memberId != null && sessionScope.memberId != ''}">
                <h2>${sessionScope.memberName}님 방문을 환영합니다.</h2>
            </c:if>
            <c:if test="${sessionScope.memberId == null || sessionScope.memberId == ''}">
                <h2>안녕하세요.</h2>
            </c:if>
        </div>
        <div class="panel-body">
            <form id="form1" name="form1" class="form-horizontal" method="post">
                <input type="hidden" name="num" value="${memberVO.num}">
                <div class="form-group">
                    <label class="control-label col-sm-2">번호:</label>
                    <div class="col-sm-10">
                        <c:out value="${memberVO.num}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">아이디:</label>
                    <div class="col-sm-10">
                        <c:out value="${memberVO.id}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">비밀번호:</label>
                    <div class="col-sm-10">
                        <c:out value="${memberVO.pass}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">이름:</label>
                    <div class="col-sm-10">
                        <c:out value="${memberVO.name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">나이:</label>
                    <div class="col-sm-10">
                        <input type="text" name="age" id="age" class="form-control" value="${memberVO.age}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">이메일:</label>
                    <div class="col-sm-10">
                        <input type="text" name="email" id="email" class="form-control" value="${memberVO.email}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">전화번호:</label>
                    <div class="col-sm-10">
                        <input type="text" name="phone" id="phone" class="form-control" value="${memberVO.phone}">
                    </div>
                </div>
            </form>
        </div>
        <div class="panel-footer">
            <c:if test="${!empty sessionScope.memberId}">
<%--                일단 로그인 하면 수정하기는 나와야 되고,--%>
                <c:if test="${sessionScope.memberId == memberVO.id}">
                    <input type="button" value="수정하기" class="btn btn-primary" onclick="update()"/>
                </c:if>
                <c:if test="${sessionScope.memberId != memberVO.id}">
                <input type="button" value="수정하기" class="btn btn-primary" onclick="update()" disabled="disabled"/>
                </c:if>
            </c:if>
            <input type="button" value="취소" class="btn btn-warning" onclick="frmreset()"/>
            <input type="button" value="리스트" onclick="location.href='memberList.do'"/>
        </div>
    </div>
</div>
</body>
</html>
