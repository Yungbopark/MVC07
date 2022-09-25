package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberListController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        MemberDAO memberDAO = new MemberDAO();
        List<MemberVO> list = memberDAO.memberList();

        req.setAttribute("list", list);

//        return "WEB-INF/member/memberList.jsp";
        return "memberList";
    }
}
