public class State {
    public String state = "normal";
    public String state2 = "time";
    public int m=0, h=0, D=1, M=1, Y=2000;
    public String[] alarm(char x){
        if(state.equals("normal")) {
            if (x == 'c') {
                state = "update";
                state2 = "min";
            }
            if (x == 'b') {
                state = "alarm";
                state2 = "alarm";
            }
            if (x == 'a') {
                if (state2.equals("time")) {
                    state2 = "date";
                } else {
                    state2 = "time";
                }
            }
        }
        if(state.equals("update")) {
            if (x == 'd') {
                state = "normal";
                state2 = "time";
            }
            if (x == 'a') {
                if (state2.equals("year")) {
                    state = "normal";
                    state2 = "time";
                }
                if (state2.equals("month")) {
                    state2 = "year";
                }
                if (state2.equals("day")) {
                    state2 = "month";
                }
                if (state2.equals("hour")) {
                    state2 = "day";
                }
                if (state2.equals("min") ) {
                    state2 = "hour";
                }
            }
            if (x == 'b') {
                if (state2.equals("min")) {
                    m++;
                    if (m >= 60) {
                        m = 0;
                    }
                }
                if (state2.equals("hour")) {
                    h++;
                    if (h >= 24) {
                        h = 0;
                    }
                }
                if (state2.equals("day")) {
                    D++;
                    if (D > 31) {
                        D = 1;
                    }
                }
                if (state2.equals("month")) {
                    M++;
                    if (M > 12) {
                        M = 1;
                    }
                }
                if (state2.equals("year")) {
                    Y++;
                    if (Y > 2100) {
                        Y = 2000;
                    }
                }
            }
        }
        if(state.equals("alarm")){
            if (x == 'd') {
                state = "normal";
                state2 = "time";
            }
            if (x == 'a') {
                state2 = "chime";
            }
        }
        return new String[]{state, state2, String.valueOf(Y) + "-" +
                String.valueOf(M) + "-" + String.valueOf(D), String.valueOf(h) + ":" +
                String.valueOf(m) };
    }

}
