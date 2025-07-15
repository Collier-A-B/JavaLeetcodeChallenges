package solutions.mediantwoarrays;

public class MedianTwoSortedArraysDriver {
    public static void main(String[] args) {
        // Test 1
        int[] test1Nums1 = {1, 3};
        int[] test1Nums2 = {2};
        double expected = 2;
        test(1, test1Nums1, test1Nums2, expected);

        // Test 2
        int[] test2Nums1 = {1, 2};
        int[] test2Nums2 = {3, 4};
        expected = 2.5;
        test(2, test2Nums1, test2Nums2, expected);

    }

    public static void test(int testNum, int[] nums1, int[] nums2, double expected){
        System.out.println("\n*****************Test " + testNum + " *****************");

        double result = Solution.findMedianSortedArray(nums1, nums2);

        System.out.println("\nExpected result: " + expected);
        System.out.println("Returned result: " + result);

        if (result != expected)
        {
            System.out.println("\nTest Failed");
        }
        else
        {
            System.out.println("\nTest Passed");
        }

        System.out.println("\n**********************************\n");
    }
}
