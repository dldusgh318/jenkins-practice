package teacher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacherTest {

    Teacher teacher;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("김선생");
    }

    // 수업 주제 출력 확인
    @Test
    void testTeach() {
        assertEquals("김선생 선생님이 자바을(를) 가르칩니다.", teacher.teach("자바"));
    }

    // 다른 주제 출력 확인
    @Test
    void testTeachDifferentTopic() {
        assertEquals("김선생 선생님이 파이썬을(를) 가르칩니다.", teacher.teach("파이썬"));
    }

    // 다른 선생님 이름 출력 확인
    @Test
    void testTeachWithDifferentTeacherName() {
        Teacher anotherTeacher = new Teacher("이선생");

        assertEquals("이선생 선생님이 자료구조을(를) 가르칩니다.", anotherTeacher.teach("자료구조"));
    }
}
