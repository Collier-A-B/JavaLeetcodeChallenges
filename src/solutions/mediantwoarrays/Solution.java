package solutions.mediantwoarrays;

// Non optimal runtime solution

public class Solution {
    private static int[] mergeArrays(int[] nums1, int[] nums2){
        int[] mergedArray = new int[nums1.length+nums2.length];

        for (int i = 0, j = 0, k = 0; k < mergedArray.length; k++)
        {
            // if all numbers from nums1 have been added
            // Or
            // element from nums2 is less than element from nums1
            if (i == nums1.length || (j != nums2.length && nums2[j] < nums1[i]))
            {
                mergedArray[k] = nums2[j];
                j++;
            }
            // if all numbers from nums2 have been added
            // Or
            // element from nums1 is less than element from nums2
            else if(j == nums2.length || nums1[i] < nums2[j])
            {
                mergedArray[k] = nums1[i];
                i++;
            }
            // if nums1[i] == nums2[j]
            else 
            {
                mergedArray[k] = nums1[i];
                k++;
                mergedArray[k] = nums2[j];
                i++;
                j++;
            }
        }

        return mergedArray;
    }

    public static double findMedianSortedArray(int[] nums1, int[] nums2){
        int[] mergedArray = mergeArrays(nums1, nums2);

        // calculate the median index: Index = (arr.length-1)/2
        // if arr.length - 1 is even, this value is correct
        // if arr.length - 1 is odd, it will be the avg of this indx and the next

        // The left indx of the averaged median case
        // otherwise, it is the median indx
        int leftIndx = (mergedArray.length-1) / 2;
        
        // if arr.length - 1 is even
        if ((mergedArray.length-1) % 2 == 0)
        {
            // left indx is the median indx
            return mergedArray[leftIndx];
        }
        // else
        
        return (mergedArray[leftIndx] + mergedArray[leftIndx+1]) / 2.0;
    }
}
