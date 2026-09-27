class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();

        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(curr);
                curr = new StringBuilder();
            } else if (ch == ')') {
                curr.reverse();
                StringBuilder prev = st.pop();
                prev.append(curr);
                curr = prev;
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
