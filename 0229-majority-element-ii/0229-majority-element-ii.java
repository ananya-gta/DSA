class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = 0, ele2 = 0, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (ele1 == num)
                cnt1++;
            else if (ele2 == num)
                cnt2++;
            else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) cnt1++;
            else if (num == ele2) cnt2++;
        }

        List<Integer> list = new ArrayList<>();

        if (cnt1 > nums.length / 3) list.add(ele1);
        if (cnt2 > nums.length / 3) list.add(ele2);

        return list;
    }
}