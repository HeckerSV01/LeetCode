class Solution {
    public String solveEquation(String eqn) {
        int idx = eqn.indexOf('=');
        String leq = eqn.substring(0, idx);
        String req = eqn.substring(idx + 1);
        List<Character> signl = new ArrayList<>();
        List<Character> signr = new ArrayList<>();
        if (leq.charAt(0) == '-') {
            signl.add('-');
        } else {
            signl.add('+');
        }
        for (int i = 1; i < leq.length(); i++) {
            if (leq.charAt(i) == '+') {
                signl.add('+');
            } else if (leq.charAt(i) == '-') {
                signl.add('-');
            }
        }
        if (req.charAt(0) == '-') {
            signr.add('-');
        } else {
            signr.add('+');
        }
        for (int i = 1; i < req.length(); i++) {
            if (req.charAt(i) == '+') {
                signr.add('+');
            } else if (req.charAt(i) == '-') {
                signr.add('-');
            }
        }
        if (leq.charAt(0) == '+' || leq.charAt(0) == '-') {
            leq = leq.substring(1);
        }

        if (req.charAt(0) == '+' || req.charAt(0) == '-') {
            req = req.substring(1);
        }
        String arr1[] = leq.split("[\\+-]");
        String arr2[] = req.split("[\\+-]");
        int xcountl = 0;
        int lsum = 0;
        int xcountr = 0;
        int rsum = 0;
        for (int i = 0; i < arr1.length; i++) {
            String s = arr1[i];
            if (s.charAt(s.length() - 1) == 'x') {
                int coeff;
                if (s.length() == 1) {
                    coeff = 1;
                } else {
                    coeff = Integer.parseInt(s.substring(0, s.length() - 1));
                }
                if (signl.get(i) == '+') {
                    xcountl += coeff;
                } else {
                    xcountl -= coeff;
                }
            } else {
                if (signl.get(i) == '+') {
                    lsum += Integer.parseInt(s);
                } else {
                    lsum -= Integer.parseInt(s);
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            String s = arr2[i];
            if (s.charAt(s.length() - 1) == 'x') {
                int coeff;
                if (s.length() == 1) {
                    coeff = 1;
                } else {
                    coeff = Integer.parseInt(s.substring(0, s.length() - 1));
                }
                if (signr.get(i) == '+') {
                    xcountr += coeff;
                } else {
                    xcountr -= coeff;
                }
            } else {
                if (signr.get(i) == '+') {
                    rsum += Integer.parseInt(s);
                } else {
                    rsum -= Integer.parseInt(s);
                }
            }
        }
        if (lsum == rsum && xcountl == xcountr) {
            return "Infinite solutions";
        }
        if (xcountl == xcountr && lsum != rsum) {
            return "No solution";
        }
        int xcoeff = xcountl - xcountr;
        int val = rsum - lsum;
        int res = (int) (val / xcoeff);
        return new String("x=" + String.valueOf(res));
    }
}