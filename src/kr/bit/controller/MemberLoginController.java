package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberLoginController implements Controller {
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("user_id");
        String password = req.getParameter("password");
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberId);
        memberVO.setPass(password);

        MemberDAO memberDAO = new MemberDAO();

        String memberName = memberDAO.memberLogin(memberVO);
        System.out.println("memberName = " + memberName);

        // memberName의 값이 있으면 인증 성공, 없으면 회원 인증이 실패한 경우

        if (memberName != null && !memberName.equals("")) {
            // 로그인 성공
            // 성공했다는 건 모두가 알아야 하기 때문에 session으로 보관
            // session 객체를 생성한다.
            HttpSession session = req.getSession();
            // 세션을 가져오는걸 시도한다
            // 없으면 새로 만듦
            session.setAttribute("memberId", memberId);
            session.setAttribute("memberName", memberName);
            // 다른 페이지들이 인증에 성공했다는 걸 알아야 하기 때문에
            // 만들어진 세션에 객체바인딩


            // 서버에 있는 메모리 공간에 객체 바인딩을 하는 것
            // 다른 페이지에서 인증이 성곻했는지 알아보려면 getAttribute해서 보면 됩

        } else {
            // 실패

            req.getSession().setAttribute("memberId", "");
            req.getSession().setAttribute("memberName", "");

            req.getSession().setAttribute("msg", "사용자 정보가 올바르지 않습니다.");
        }
        String contextPath = req.getContextPath();

        return "redirect:"+contextPath+"/memberList.do";
    }
}
