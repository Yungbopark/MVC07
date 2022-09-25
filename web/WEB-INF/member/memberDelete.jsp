
<%@ page import="kr.bit.model.MemberDAO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("memberDelete.jsp");
    int num = Integer.parseInt(request.getParameter("num"));

    MemberDAO memberDAO = new MemberDAO();
    int cnt = memberDAO.memberDelete(num);

    if (cnt > 0) {
        response.sendRedirect("/MVC04/memberList.do");
    } else {
        throw new Exception("not deleted");
    }

%>
