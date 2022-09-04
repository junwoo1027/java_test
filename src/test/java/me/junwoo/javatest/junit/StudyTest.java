package me.junwoo.javatest.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudyTest {

//    @BeforeAll
//    static void BeforeAll_test() {
//        System.out.println("BeforeAll");
//    }
//
//    @DisplayName("fighting")
//    @Test
//    public void study_test() {
//        Study study = new Study();
//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."),
//                () -> assertTrue(study.getLimit() > 0, "스터디 참석 가능 인원은 0보다 커야한다.")
//        );
//        System.out.println("study_test");
//    }
//
//    @Test
//    public void study_test2() {
//        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
//            Thread.sleep(300);
//            new Study(10);
//        });
//    }
//
//    @Test
//    public void study_test3() {
//        String test_env = System.getenv("TEST_ENV");
//        System.out.println(test_env);
//        assumeTrue("LOCAL".equalsIgnoreCase(test_env));
//
//        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
//            System.out.println("assumingThat: local");
//            Study study = new Study(100);
//            assertThat(study.getLimit()).isGreaterThan(0);
//        });
//
//        assumingThat("JUNWOO".equalsIgnoreCase(test_env), () -> {
//            System.out.println("assumingThat: junwoo");
//            Study study = new Study(10);
//            assertThat(study.getLimit()).isGreaterThan(0);
//        });
//    }
//
//    @EnabledOnOs({OS.MAC, OS.LINUX, OS.WINDOWS})
//    @Test
//    public void study_test4() {
//        String test_env = System.getenv("TEST_ENV");
//        System.out.println(test_env);
//        Study study = new Study(10);
//        assertThat(study.getLimit()).isGreaterThan(0);
//    }
//
//    @DisabledOnOs({OS.MAC, OS.LINUX, OS.WINDOWS})
//    @Test
//    public void test5() {
//        System.out.println("test");
//    }
//
//    @EnabledOnJre({JRE.JAVA_17})
//    @Test
//    public void 테스트() {
//        System.out.println("Enable on JRE");
//        Study study = new Study(10);
//        assertThat(study.getLimit()).isGreaterThan(0);
//    }
//
//    @DisabledOnJre({JRE.JAVA_11})
//    @Test
//    public void test1() {
//        System.out.println("TT");
//    }
//
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
//    @Test
//    public void test2() {
//        System.out.println("TEST");
//    }
//
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "MAIN")
//    @DisplayName("sd")
//    @Test
//    public void test3() {
//        System.out.println("TEST");
//    }
//
//    @FastTest
//    public void 메인_테스트() {
//        Study study = new Study(10);
//        assertThat(study.getLimit()).isGreaterThan(0);
//    }
//
//    @Tag("slow")
//    @Test
//    public void 서브_테스트() {
//        System.out.println("서브 테스트");
//    }
//
//    @RepeatedTest(10)
//    void repeatedTest() {
//        System.out.println("test");
//    }
//
//    @DisplayName("파타미터 테스트")
//    @ParameterizedTest(name = "{index} {displayName} {0}")
//    @ValueSource(strings = {"하하", "호호", "키키"})
//    @NullAndEmptySource
//    void parameterTest(String message) {
//        System.out.println(message);
//    }
//
//    @DisplayName("파타미터 테스트2")
//    @ParameterizedTest(name = "{index} {displayName} {0}")
//    @ValueSource(strings = {"10", "20", "30"})
//    void parameterTest2(int message) {
//        System.out.println(new Study(message).getLimit());
//    }
//
//    @DisplayName("파라미터_테스트3")
//    @ParameterizedTest(name = "{index} {displayName} {0}")
//    @CsvSource({"10, 'java'", "20, 'spring'"})
//    void parameterTest3(Integer limit, String name) {
//        System.out.println(new Study(limit, name));
//    }
//
//    @DisplayName("파라미터_테스트4")
//    @ParameterizedTest(name = "{index} {displayName} {0}")
//    @CsvSource({"10, 'java'", "20, 'spring'"})
//    void parameterTest4(ArgumentsAccessor argumentsAccessor) {
//        System.out.println(new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1)));
//    }

    int value = 0;

    @Order(2)
    @FastTest
    @DisplayName("test fast")
    void fastTest() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
        System.out.println("fast test");
        System.out.println(this);
        System.out.println(++value);
        System.out.println();
    }

    @Order(1)
    @SlowTest
    @DisplayName("test slow")
    void slowTest() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
        System.out.println("slow test");
        System.out.println(this);
        System.out.println(++value);
        System.out.println();
    }

    @Order(3)
    @SlowTest
    @DisplayName("test slow2")
    void slowTest2() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
        System.out.println("slow test2");
        System.out.println(this);
        System.out.println(++value);
        System.out.println();
    }

    @Disabled
    @Test
    void disabledTest() {
        System.out.println("disabled");
    }
}