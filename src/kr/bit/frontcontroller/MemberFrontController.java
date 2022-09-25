package kr.bit.frontcontroller;

import kr.bit.controller.*;
import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;

@WebServlet(name = "MemberFrontController", value = "*.do")
public class MemberFrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("MemberFrontController.service");
        //프론트 컨트롤러는 클라이언트가 어떤 요청을 했는지 파악하기
        //req.setCharacterEncoding("euc-kr");
        req.setCharacterEncoding("utf-8");
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);
        //클라이언트의 요청 경로도 req에 저장된다

        //실제로 요청한 명령이 무엇인지 파악
        String command = requestURI.substring(contextPath.length());
        System.out.println("command = " + command);

        Controller controller = null;
        String nextUrl = null;
        // url 요청이 들오면 하나하나 if, else if 로 처리해줬는데,
        // HandlerMapping 사용
        /*
        //요청에 따른 분기 작업
        if (command.equals("/memberList.do")) {

            Controller memberListController = new MemberListController();
            nextUrl = memberListController.requestHandler(req, resp);

        } else if (command.equals("/memberInsert.do")) {

            Controller memberInsertController = new MemberInsertController();
            nextUrl = memberInsertController.requestHandler(req, resp);

        } else if (command.equals("/memberRegister.do")) { //회원 가입 화면으로 이동

            Controller memberRegisterController = new MemberRegisterController();
            nextUrl = memberRegisterController.requestHandler(req, resp);

        } else if (command.equals("/memberContent.do")) {

            Controller memberContentController = new MemberContentController();
            nextUrl = memberContentController.requestHandler(req, resp);

        } else if (command.equals("/memberUpdate.do")) {

            Controller memberUpdateController = new MemberUpdateController();
            nextUrl = memberUpdateController.requestHandler(req, resp);

        } else if (command.equals("/memberDelete.do")) {

            Controller memberDeleteController = new MemberDeleteController();
            nextUrl = memberDeleteController.requestHandler(req, resp);

        } else {
            System.out.println("찾는 페이지가 없다");
        } // if end
*/

        // HandlerMapping 시작
        // .do 경로로 미리 HandlerMapping에 .put으로 경로 넣어둔 것 호출
        // HashMap은 key,value 형태, command는 value를 찾기 위한 key값
        // key값은 .get으로 가져옴
        HandlerMapping handlerMapping = new HandlerMapping();
        controller = handlerMapping.getController(command);
        nextUrl = controller.requestHandler(req, resp);
        // forward, redirect
        if (nextUrl != null) {
            if (nextUrl.indexOf("redirect:")!= -1) {
                resp.sendRedirect(nextUrl.split(":")[1]);
            }else {
                RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextUrl));
                // static 이니까 class명.method 바로 실행
                rd.forward(req, resp);
            }

        }
    }

}
