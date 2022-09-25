package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberInsertController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = req.getContextPath();
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPass(pass);
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        MemberDAO memberDAO = new MemberDAO();

        int cnt = memberDAO.memberInsert(vo);

        if (cnt > 0) {
         return "redirect:"+contextPath+"/memberList.do";
        } else {
            throw new ServletException("not Inserted");
        }
    }
}
