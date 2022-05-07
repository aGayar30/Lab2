import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Nested
    class EdgeCoverage {
        State mainObj;

        @BeforeEach
        public void setup() {
            mainObj = new State();
        }

        @Test
        public void ECtest1() {
            String[] res = mainObj.alarm('a');
            assertEquals("normal", res[0]);
            assertEquals("date", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void ECtest2() {
            mainObj.alarm('a');
            String[] res = mainObj.alarm('a');
            assertEquals("normal", res[0]);
            assertEquals("time", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void ECtest3() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('c');
            assertEquals("update", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void ECtest4() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void ECtest5() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void ECtest6() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest7() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest8() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest9() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("month", res[1]);
            assertEquals("2000-1-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest10() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("month", res[1]);
            assertEquals("2000-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest11() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2000-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest12() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest13() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("normal", res[0]);
            assertEquals("time", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest14() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('c');
            assertEquals("update", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest15() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('c');
            String[] res = mainObj.alarm('d');
            assertEquals("normal", res[0]);
            assertEquals("time", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void ECtest16() {
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('d');
            String[] res = mainObj.alarm('b');
            assertEquals("alarm", res[0]);
            assertEquals("alarm", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }
        @Test
        public void ECtest17(){
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('d');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("alarm", res[0]);
            assertEquals("chime", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }
        @Test
        public void ECtest18(){
            mainObj.alarm('a');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('c');
            mainObj.alarm('d');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('d');
            assertEquals("normal", res[0]);
            assertEquals("time", res[1]);
            assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

    }
    @Nested
    class ADUP {
        State mainObj;

        @BeforeEach
        public void setup() {
            mainObj = new State();
        }

        @Test
        public void ADUPTest1() {
            String[] res = mainObj.alarm('c');
            assertEquals("update", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void ADUPTest2() {
            mainObj.alarm('c');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void ADUPTest3() {
            mainObj.alarm('c');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:2", res[3]);
        }

        @Test
        public void ADUPTest4() {
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:2", res[3]);
        }
        @Test
        public void ADUPTest5(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("1:2", res[3]);
        }
        @Test
        public void ADUPTest6(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest7(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPtest8(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-2", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest9(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-3", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest10(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("month", res[1]);
            assertEquals("2000-1-3", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest11(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("month", res[1]);
            assertEquals("2000-2-3", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest12(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("month", res[1]);
            assertEquals("2000-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest13(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('a');
            assertEquals("update", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2000-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest14(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2001-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }
        @Test
        public void ADUPTest15(){
            mainObj.alarm('c');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            mainObj.alarm('b');
            mainObj.alarm('a');
            mainObj.alarm('b');
            String[] res = mainObj.alarm('b');
            assertEquals("update", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2002-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }

    }
}