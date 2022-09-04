package me.junwoo.javatest.study;

import lombok.RequiredArgsConstructor;
import me.junwoo.javatest.domain.Study;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyController {

    private final StudyRepository studyRepository;

    @GetMapping("/{id}")
    public Study getStudy(@PathVariable Long id) {
        return studyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Study not found"));
    }

    @PostMapping
    public Study createStudy(@RequestBody Study study) {
        return  studyRepository.save(study);
    }
}
