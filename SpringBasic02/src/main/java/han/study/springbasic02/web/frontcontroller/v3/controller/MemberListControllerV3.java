package han.study.springbasic02.web.frontcontroller.v3.controller;

import han.study.springbasic02.basic.domain.member.Member;
import han.study.springbasic02.basic.domain.member.MemberRepository;
import han.study.springbasic02.web.frontcontroller.ModelView;
import han.study.springbasic02.web.frontcontroller.MyView;
import han.study.springbasic02.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
