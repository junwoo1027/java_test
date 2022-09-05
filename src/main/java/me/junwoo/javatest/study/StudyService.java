package me.junwoo.javatest.study;

import me.junwoo.javatest.domain.Member;
import me.junwoo.javatest.domain.Study;
import me.junwoo.javatest.member.MemberService;

import java.util.Optional;

public class StudyService {
    private final MemberService memberService;
    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member doesn't exist");
        }
        study.setOwnerId(memberId);
        Study newStudy = studyRepository.save(study);
        memberService.notify(newStudy);
        memberService.notify(member.get());
        return newStudy;
    }
}
