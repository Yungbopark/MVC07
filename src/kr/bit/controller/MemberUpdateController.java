package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberUpdateController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();

        int num = Integer.parseInt(req.getParameter("num"));
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        MemberVO memberVO = new MemberVO();

        memberVO.setNum(num);
        memberVO.setAge(age);
        memberVO.setPhone(phone);
        memberVO.setEmail(email);

        MemberDAO memberDAO = new MemberDAO();

       int cnt = memberDAO.memberUpdate(memberVO);

        if (cnt > 0) {

            return "redirect:"+contextPath+"/memberList.do";
        } else {
            throw new ServletException("not updated");
        }




    }
}
