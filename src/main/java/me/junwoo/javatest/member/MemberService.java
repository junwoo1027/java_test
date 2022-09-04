package me.junwoo.javatest.member;

import me.junwoo.javatest.domain.Member;
import me.junwoo.javatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);

    void notify(Member member);
}
