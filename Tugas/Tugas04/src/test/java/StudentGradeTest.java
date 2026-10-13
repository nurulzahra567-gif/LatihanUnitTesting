import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    private final StudentGrade studentGrade = new StudentGrade();

    @Test
    public void testGradeA() {
        assertEquals("A", studentGrade.calculateGrade(85));
    }

    @Test
    public void testGradeB() {
        assertEquals("B", studentGrade.calculateGrade(75));
    }

    @Test
    public void testGradeC() {
        assertEquals("C", studentGrade.calculateGrade(65));
    }

    @Test
    public void testGradeD() {
        assertEquals("D", studentGrade.calculateGrade(55));
    }

    @Test
    public void testGradeE() {
        assertEquals("E", studentGrade.calculateGrade(40));
    }

    @Test
    public void testScoreDiBawahNol() {
        assertThrows(IllegalArgumentException.class,
                () -> studentGrade.calculateGrade(-1));
    }

    @Test
    public void testScoreDiAtas100() {
        assertThrows(IllegalArgumentException.class,
                () -> studentGrade.calculateGrade(101));
    }

    @Test
    public void testLulus() {
        assertTrue(studentGrade.isPassed(60));
    }

    @Test
    public void testTidakLulus() {
        assertFalse(studentGrade.isPassed(50));
    }

    @Test
    public void testIsPassedScoreTidakValid() {
        assertThrows(IllegalArgumentException.class,
                () -> studentGrade.isPassed(-1));
    }
    @Test
    public void testGradeMaksimal100() {
        assertEquals("A", studentGrade.calculateGrade(100));
    }
}