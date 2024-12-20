package study.groupware.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.groupware.member.domain.Address;
import study.groupware.member.domain.Member;
import study.groupware.member.dto.MemberDTO;
import study.groupware.member.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> memberList() {
        return memberRepository.memberList();
    }

    @Transactional
    public int saveMember(Member member) {
        memberRepository.saveMember(member);
        return member.getMemberId();
    }

    public Member findByMember(int memberId) {
        return memberRepository.findById(memberId);
    }

    @Transactional
    public int updateMember(int memberId, MemberDTO dto) {
        Member member = memberRepository.findById(memberId);

        member.setName(dto.getName());
        member.setLoginId(dto.getLoginId());
        member.setPhone(dto.getPhone());
        member.setEmail(dto.getEmail());
        member.setGender(dto.getGender());
        System.out.println("updateMember ::: "+dto.getZipCode()+", "+dto.getAddr()+", "+dto.getAddr_dtl());
        Address address = new Address(dto.getZipCode(), dto.getAddr(), dto.getAddr_dtl());
        member.setAddr(address);
        member.setUpdateDate(dto.getUpdateDate());

        return member.getMemberId();
    }
}
