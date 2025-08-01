package solutions.container_most_water;

public class Solution {
    protected static int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length-1;
        int maxArea = -1;

        if(height.length == 2) {
            return Integer.min(height[leftPtr], height[rightPtr]);  // only 2 heights in the array, therefore area is the smallest height (height * 1)
        }

        // iterate each ptr through array until they point to same element or have passed each other
        // i.e. left ptr moves towards right side of array and right ptr moves toward left side of array
        // 
        // exit loop when leftPtr >= rightPtr

        while(leftPtr < rightPtr) { 
            int area = Integer.min(height[leftPtr], height[rightPtr]) * (rightPtr - leftPtr);
            if(area > maxArea)
                maxArea = area;
            
            if(height[leftPtr] < height[rightPtr]){
                leftPtr++;
            } else {
                rightPtr--;
            } 
        }

        return maxArea; 
    }
}
