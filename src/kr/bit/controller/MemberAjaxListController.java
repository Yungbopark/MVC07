package kr.bit.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberAjaxListController implements Controller {
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberAjaxListController.requestHandler");
        MemberDAO memberDAO = new MemberDAO();
        List<MemberVO> memberVO = memberDAO.memberList();

        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(memberVO);

        System.out.println("s = " + s);



        // $.ajax() --> json 으로 응답해줌
        resp.setContentType("text/json;charset=utf-8");
        return null;
    }
}
