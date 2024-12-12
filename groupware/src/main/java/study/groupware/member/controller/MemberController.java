package study.groupware.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.groupware.member.repository.MemberRepository;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/member/memberList")
    public String memberList(Model model, HttpServletRequest request) {
        model.addAttribute("uri", request.getRequestURI());
        model.addAttribute("members", memberRepository.memberList());
        return "member/memberList";
    }
}
