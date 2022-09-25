<%@ page import="kr.bit.model.MemberVO" %>
<%@ page import="java.lang.reflect.Member" %>
<%@ page import="kr.bit.model.MemberDAO" %><%--
  Created by IntelliJ IDEA.
  User: Jungwoo Park
  Date: 8/30/2022
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    int age = Integer.parseInt(request.getParameter("age"));
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");



    MemberDAO memberDAO = new MemberDAO();


    MemberVO memberVO = memberDAO.memberContent(num);

    memberVO.setAge(age);
    memberVO.setPhone(phone);
    memberVO.setEmail(email);

    int cnt = memberDAO.memberUpdate(memberVO);

    if (cnt > 0) {
        response.sendRedirect("/member/memberList.jsp");
    } else {
        throw new ServletException("not updated");
    }


%>