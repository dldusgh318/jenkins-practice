package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class StudentManagerTest {

    static StudentManager sm;

    @BeforeAll
    static void setUp() {
        sm = new StudentManager();
        sm.addStudent("이연호");
    }

    // 학생 추가 확인
    @Test
    @Order(1)
    void testAddStudent() {

        assertTrue(sm.hasStudent("이연호"));
    }

    // 학생 조회
    @Test
    @Order(2)
    void testHasStudent() {

        assertTrue(sm.hasStudent("이연호"));
    }

    // 중복 추가 예외 처리
    @Test
    @Order(3)
    void testDuplicateAddStudent() {

        assertThrows(IllegalArgumentException.class, () -> {
            sm.addStudent("이연호");
        });
    }

    // 존재하지 않는 학생 제거 예외 처리
    @Test
    @Order(4)
    void testRemoveNonExistingStudent() {

        assertThrows(IllegalArgumentException.class, () -> {
            sm.removeStudent("홍길동");
        });
    }

    // 학생 제거
    @Test
    @Order(5)
    void testRemoveStudent() {

        sm.removeStudent("이연호");

        assertFalse(sm.hasStudent("이연호"));
    }
}