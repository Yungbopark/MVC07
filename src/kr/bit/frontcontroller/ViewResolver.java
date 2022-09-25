package kr.bit.frontcontroller;

public class ViewResolver {

    // viewResolver는 경로를 받아서,

    public static String makeView(String nextPage) {

        return "/WEB-INF/member/"+nextPage+".jsp";
    }
}
