import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookTester {

    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        // Add scores to g1
        g1.addScore(50);
        g1.addScore(75);

        // Add scores to g2
        g2.addScore(80);
        g2.addScore(60);
    }

    @After
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    // 1. Test addScore (toString + scoreSize)
    @Test
    public void testAddScore() {
        // Compare contents using toString
        assertTrue(g1.toString().equals("50.0 75.0"));
        assertTrue(g2.toString().equals("80.0 60.0"));

        // Compare scoreSize
        assertEquals(2, g1.getScoreSize());
        assertEquals(2, g2.getScoreSize());
    }

    // 2. Test sum()
    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.001); // 50 + 75
        assertEquals(140.0, g2.sum(), 0.001); // 80 + 60
    }

    // 3. Test minimum()
    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.001);
        assertEquals(60.0, g2.minimum(), 0.001);
    }

    // 4. Test finalScore()
    @Test
    public void testFinalScore() {
        // finalScore = sum - minimum
        assertEquals(75.0, g1.finalScore(), 0.001);  // 125 - 50
        assertEquals(80.0, g2.finalScore(), 0.001);  // 140 - 60
    }
}