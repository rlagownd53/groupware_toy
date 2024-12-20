package study.groupware.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.groupware.member.domain.Address;
import study.groupware.member.domain.Member;
import study.groupware.member.domain.MemberStatus;
import study.groupware.member.dto.MemberDTO;
import study.groupware.member.repository.MemberRepository;
import study.groupware.member.service.MemberService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/memberList")
    public String memberList(Model model, HttpServletRequest request) {
        model.addAttribute("uri", request.getRequestURI());
        List<Member> memberList = memberService.memberList();
        model.addAttribute("members", memberList);
        return "member/memberList";
    }

    @GetMapping("/member/joinMemberForm")
    public String joinMemberForm(Model model, HttpServletRequest request) {
        model.addAttribute("uri", request.getRequestURI());
        return "member/joinMemberForm";
    }

    @PostMapping("/member/joinMemberForm")
    public String joinMemberAdmin(@ModelAttribute("form") MemberDTO dto) {
        Member member = new Member();

        member.setName(dto.getName());
        member.setLoginId(dto.getLoginId());
        member.setPhone(dto.getPhone());
        member.setEmail(dto.getEmail());
        member.setGender(dto.getGender());
        member.setAddr(new Address(dto.getZipCode(), dto.getAddr(), dto.getAddr_dtl()));
        member.setRegDate(LocalDateTime.now());
        member.setStatus(MemberStatus.APPROVE);

        int memberId = memberService.saveMember(member);

        return "redirect:/member/memberList";
    }

    @GetMapping("/member/{memberId}/memberEdit")
    public String memberDtl(@PathVariable("memberId") int memberId, Model model, HttpServletRequest request) {
        model.addAttribute("uri", request.getRequestURI());

        Member member = memberService.findByMember(memberId);

        String[] phone = member.getPhone().split("-");

        String phone1 = phone.length > 0 ? phone[0] : "";
        String phone2 = phone.length > 1 ? phone[1] : "";
        String phone3 = phone.length > 2 ? phone[2] : "";

        model.addAttribute("info", member);

        model.addAttribute("phone1", phone1);
        model.addAttribute("phone2", phone2);
        model.addAttribute("phone3", phone3);


        return "/member/memberDtl";
    }

    @PostMapping("/member/{memberId}/memberEdit")
    public String updateMember(@ModelAttribute("form") MemberDTO dto, @PathVariable("memberId") int memberId, Model model, HttpServletRequest request) {

        dto.setUpdateDate(LocalDateTime.now());

        int id = memberService.updateMember(memberId, dto);

        return "redirect:/member/memberList";
    }
}
