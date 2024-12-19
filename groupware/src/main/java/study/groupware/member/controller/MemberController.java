package study.groupware.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.groupware.member.domain.Member;
import study.groupware.member.dto.MemberDTO;
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

    @GetMapping("/member/joinMemberForm")
    public String joinMemberForm(Model model, HttpServletRequest request) {
        model.addAttribute("uri", request.getRequestURI());
        return "member/joinMemberForm";
    }

    @PostMapping("/member/joinMemberForm")
    public String joinMember(@Valid MemberDTO dto) {
        Member member = new Member();
        member.setName(dto.getName());

        return "/member/memberList";
    }
}
