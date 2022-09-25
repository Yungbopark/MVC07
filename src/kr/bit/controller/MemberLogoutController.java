package kr.bit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberLogoutController implements Controller {
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = req.getContextPath();
        //세션을 가져와서 세션 제거
        //세션을 제거하는 방법
        //1. 강제로
        req.getSession().invalidate();
        //2. 브라우저 종료(Jsessionid 브라우저 쿠키에 저장)
        //3. 세션이 종료될 때 까지 기다리는 것  (세션타임아웃 - default 30분)

        return "redirect:" + contextPath + "/memberList.do";
    }
}
