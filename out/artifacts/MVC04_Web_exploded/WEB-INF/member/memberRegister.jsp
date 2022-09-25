<%--
  Created by IntelliJ IDEA.
  User: Jungwoo Park
  Date: 9/10/2022
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function doublecheck() {
            if ($("#id").val() == '') {
                alert("ID를 입력하세요");
                $("#id").focus();
                return;
            }
            let id = $("#id").val();
            // ajax : jquery 함수 안에서 쓸 수 있는 속성들?
            // 서버와 통신? -> 서버에 요청 한다.
            $.ajax({
                url : "<c:url value='/memberDbcheck.do'/> ",
                type : "POST",
                data : {"id" : id},
                success : dbCheck,       // 함수 (callback)
                error : function () { alert("error"); }
            });
        }

        function dbCheck(data) {
            alert("dbCheck");
            // 응답된 데이터는 parameter 로 받음
            if (data != "NO") {
                alert("중복된 ID 입니다.");
                $("#id").focus();
            } else {
                alert("사용가능한 ID 입니다.");
                $("#id").focus();
            }
        }
    </script>


</head>
<body>
<form action="${ctx}/memberInsert.do" method="post">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id" id="id"/></td>
            <td><input type="button" value="중복체크" onclick="doublecheck()" class="btn btn-warning"></td>
        </tr>
        <tr>
            <td>패스워드</td>
            <td><input type="password" name="pass" /></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="text" name="age" /></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" /></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="가입" />
                <input type="reset" value="취소">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
