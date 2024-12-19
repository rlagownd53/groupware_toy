package study.groupware.member.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.groupware.member.domain.Member;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public List<Member> memberList() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

//    public int joinMember(Member member) {
//
//    }

}
