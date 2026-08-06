class Solution {
    public int smallestNumber(int n, int t) {
        while (product(n) % t != 0) {
            n++;
        }
        return n;
    }
    public int product(int n) {
        int product = 1;
        while ( n > 0) {
            product *= n%10;
            n = n / 10;
        }
        return product;
    }
}