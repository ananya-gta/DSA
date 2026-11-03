class Solution {
    public boolean isArraySpecial(int[] arr) {
        boolean check = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] & 1) == (arr[i+1] & 1 )) return false;
           
        }
        return true;
    }
}