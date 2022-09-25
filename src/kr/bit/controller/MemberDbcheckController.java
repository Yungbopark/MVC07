package kr.bit.controller;

import kr.bit.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberDbcheckController implements Controller {
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        MemberDAO dao = new MemberDAO();
        String isDouble = dao.memberDbcheck(id);

        resp.getWriter().print(isDouble);

        return null;
    }
}
