import static org.junit.jupiter.api.Assertions.*;

class EvenOddTest {

    @org.junit.jupiter.api.Test
    void isEvenOdd() {
        EvenOdd n = new EvenOdd();
        assertEquals("Even",n.IsEvenOdd(2));
    }
    @org.junit.jupiter.api.Test
    void isEvenOdd1() {
        EvenOdd n = new EvenOdd();
        assertEquals("odd",n.IsEvenOdd(1));
    }
    @org.junit.jupiter.api.Test
    void isEvenOdd2() {
        EvenOdd n = new EvenOdd();
        assertEquals("Even",n.IsEvenOdd(0));
    }
    @org.junit.jupiter.api.Test
    void isEvenOdd3() {
        EvenOdd n = new EvenOdd();
        assertEquals("odd",n.IsEvenOdd(3));
    }
    @org.junit.jupiter.api.Test
    void isEvenOdd4() {
        EvenOdd n = new EvenOdd();
        assertEquals("Even",n.IsEvenOdd(8));
    }
    @org.junit.jupiter.api.Test
    void isEvenOdd5() {
        EvenOdd n = new EvenOdd();
        assertEquals("odd",n.IsEvenOdd(7));
    }
    @org.junit.jupiter.api.Test
    void isEvenOdd6() {
        EvenOdd n = new EvenOdd();
        assertThrows(IllegalArgumentException.class,() -> {n.IsEvenOdd(-6);});
    }
}