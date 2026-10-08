class Solution {
    public String removeOuterParentheses(String s) {
        // ( → keep it if the count before adding is greater than 0
        // ) → keep it if the count after subtracting is greater than 0
        int cnt = 0;
        String ans = "";
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (cnt > 0) ans += ch;
                cnt++;
            } else {
                cnt--;
                if (cnt > 0) ans += ch;
            }
        }
        return ans;
    }
}