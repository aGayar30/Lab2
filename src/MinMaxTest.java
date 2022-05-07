import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxTest {

    @Test
    void min() {
        MinMax e = new MinMax();
        int[] a = {2,8,6,7,20,30,-1,0,5};
        assertEquals(-1,e.Min(a));
        assertEquals(30, e.Max(a));
    }

    @Test
    void max() {
        MinMax e = new MinMax();
        int[] a = {-2,-10,-20,-5,-7,-9};
        assertEquals(-20,e.Min(a));
        assertEquals(-2, e.Max(a));
    }
    @Test
    void m1() {
        MinMax e = new MinMax();
        int[] a = {3,6,8,10,9,11,2};
        assertEquals(2,e.Min(a));
        assertEquals(11, e.Max(a));
    }
    @Test
    void m2() {
        MinMax e = new MinMax();
        int[] a = {-2,-10,-20,-5,-7,-9};
        assertEquals(-20,e.Min(a));
        assertEquals(-2, e.Max(a));
    }
}