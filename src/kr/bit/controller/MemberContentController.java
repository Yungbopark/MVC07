package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberContentController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));

        MemberDAO memberDAO = new MemberDAO();
        MemberVO memberVO = memberDAO.memberContent(num);

        req.setAttribute("memberVO", memberVO);


        // view의 이름만 리턴

        //return "WEB-INF/member/memberContent.jsp";
        return "memberContent_jstl";
    }
}
