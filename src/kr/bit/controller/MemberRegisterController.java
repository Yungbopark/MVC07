package kr.bit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberRegisterController implements Controller{

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        return "WEB-INF/member/memberRegister.html";
        return "memberRegister";
    }
}
