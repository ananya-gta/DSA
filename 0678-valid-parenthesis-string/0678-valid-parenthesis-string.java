class Solution {
    public boolean checkValidString(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '*') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }

        cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '*') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }

        return true;
    }
}