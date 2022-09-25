package kr.bit.controller;

import kr.bit.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;

public class MemberDeleteController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = req.getContextPath();
        int num = Integer.parseInt(req.getParameter("num"));
        MemberDAO memberDAO = new MemberDAO();
       int cnt = memberDAO.memberDelete(num);
        if (cnt > 0) {
            // 삭제를 누르면 로그인 되어 있는 해당 세션은 invalidate 시킴
            req.getSession().invalidate();
            return "redirect:"+contextPath+"/memberList.do";
        } else {
            throw new ServletException("not deleted");
        }





    }
}
