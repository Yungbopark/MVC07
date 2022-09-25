package kr.bit.frontcontroller;

import kr.bit.controller.*;

import java.util.HashMap;

public class HandlerMapping {

    private HashMap<String, Controller> mappings;

    public HandlerMapping() {

        System.out.println("HandlerMapping.HandlerMapping");
        mappings = new HashMap<String, Controller>();
        mappings.put("/memberList.do", new MemberListController());
        mappings.put("/memberInsert.do", new MemberInsertController());
        mappings.put("/memberRegister.do", new MemberRegisterController());
        mappings.put("/memberContent.do", new MemberContentController());
        mappings.put("/memberUpdate.do", new MemberUpdateController());
        mappings.put("/memberDelete.do", new MemberDeleteController());
        mappings.put("/memberLogin.do", new MemberLoginController());
        mappings.put("/memberLogout.do", new MemberLogoutController());
        mappings.put("/memberDbcheck.do", new MemberDbcheckController());
        mappings.put("/memberAjaxList.do", new MemberAjaxListController());
    }


    public Controller getController(String key) {

        return mappings.get(key);
    }
}
