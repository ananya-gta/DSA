class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0, dir = 1;
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            if (currRow == 0) dir = 1;
            if (currRow == numRows - 1) dir = -1;

            currRow += dir;

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }
        return result.toString();
    }
}