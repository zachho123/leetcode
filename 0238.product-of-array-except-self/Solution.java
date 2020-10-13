import java.util.*;

/***
 * Given an array of n integers where n > 1, return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // We can use the fact that the product of all elements except the
        // element at i, will be = product of elements left of i * product of
        // elements right of i.
        int[] output = new int[nums.length];

        // We use our output array in interim to calc the product of all
        // elements to the left of i.
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // We run through the input array backwards, keeping track of the
        // running product of elements right of i, while also updating output
        // array with the product except self.
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {1, 2, 3, 4};
        System.out.println(Arrays.toString(s.productExceptSelf(input)));
    }
}