package me.junwoo.javatest.study;

import me.junwoo.javatest.domain.Member;
import me.junwoo.javatest.domain.Study;
import me.junwoo.javatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createStudyService(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("junwoo1027@naver.com");

        Study study = new Study(10, "테스트");

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.createStudy(1L, study);

        // Then
        assertNotNull(studyService);
        assertEquals(member.getId(), study.getOwnerId());
        then(memberService).should(times(1)).notify(study);
        then(memberService).should(times(1)).notify(member);
        then(memberService).should(never()).validate(any());
        then(memberService).shouldHaveNoMoreInteractions();

        System.out.println("성공");
    }
}