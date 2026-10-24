class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceA = helper(arriveAlice);
        int aliceL = helper(leaveAlice);
        int bobA = helper(arriveBob);
        int bobL = helper(leaveBob);
        int common = Math.min(aliceL, bobL) - Math.max(aliceA, bobA) + 1;
        if (common < 0) {
            return 0;
        }
        return common;
    }

    public int helper(String leaveAlice) {
        String DD_MMA[] = leaveAlice.split("-");
        int leaveAlicei = 0;
        int leaveAliceInt = (DD_MMA[0].charAt(0) - '0') * 10 + (DD_MMA[0].charAt(1) - '0');
        for (int i = 0; i < leaveAliceInt - 1; i++) {
            if (i == 1) {
                leaveAlicei += 28;

            } else if (i >= 7) {
                leaveAlicei += 30 + i % 2;
            } else {
                leaveAlicei += 30 + (i + 1) % 2;
            }
        }
        leaveAlicei += Integer.parseInt(DD_MMA[1]);
        return leaveAlicei;
    }
}