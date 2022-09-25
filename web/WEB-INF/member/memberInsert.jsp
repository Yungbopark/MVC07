<%@ page import="kr.bit.model.MemberVO" %>
<%@ page import="kr.bit.model.MemberDAO" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Jungwoo Park
  Date: 8/28/2022
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 파라메터 수집(VO)
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    MemberVO vo = new MemberVO();
    vo.setId(id);
    vo.setPass(pass);
    vo.setName(name);
    vo.setAge(age);
    vo.setEmail(email);
    vo.setPhone(phone);

    MemberDAO dao = new MemberDAO();
    int cnt = dao.memberInsert(vo);

    if (cnt > 0) {
        // 가입성공
        response.sendRedirect("/member/memberList.jsp");

    } else {
        throw new Exception("not inserted");
    }


%>