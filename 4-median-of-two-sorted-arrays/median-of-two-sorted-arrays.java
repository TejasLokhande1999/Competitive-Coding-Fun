class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> arr = new ArrayList<>();
        int totalLgt = m + n;
        int index = totalLgt / 2;
        boolean isOdd = (totalLgt % 2 != 0);

        int count = 0;
        int i = 0, j = 0;

        // Merge until we reach index (or index+1 in case of even)
        while (i < n && j < m && count <= index) {
            if (nums1[i] <= nums2[j]) {
                arr.add(nums1[i++]);
            } else {
                arr.add(nums2[j++]);
            }
            count++;
        }

        while (i < n && count <= index) {
            arr.add(nums1[i++]);
            count++;
        }

        while (j < m && count <= index) {
            arr.add(nums2[j++]);
            count++;
        }

        double ans = 0;
        if (isOdd) {
            ans = arr.get(index);
        } else {
            ans = (arr.get(index - 1) + arr.get(index)) / 2.0;
        }

        return ans;
    }
}
