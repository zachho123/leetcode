/***
 * Notes:
 * - Please solve without division and in O(n)
 * - Could you solve in constant space? (output array doesn't count).
 */

/**
 * Outputs an array where the value at each index i is equal to the product of
 * all the elements of the input array except input[i].
 * @param {number[]} nums - Input array of positive integers.
 * @return {number[]} - "Product except self" array of positive integers.
 */
function productExceptSelf(nums) {
  // The product of all elements except the element at i = product of elements
  // left of i * product of elements right of i. Using this fact, we construct
  // an array where each element i = product of elements left of i. We then
  // iterate backwards over the input keeping track of the product of elements
  // to the right of i. We update the output array with the product of left
  // product and right product to get final answer.
  let output = [];

  output[0] = 1;
  for (let i = 1; i < nums.length; i++) {
    output[i] = output[i - 1] * nums[i - 1];
  }

  let rightProduct = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    output[i] = output[i] * rightProduct;
    rightProduct *= nums[i];
  }

  return output;
}

(function run() {
  const tests = [
    {
      input: [1, 2, 3, 4],
      output: [24, 12, 8, 6]
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test');
    const result = productExceptSelf(test.input);
    const lenEqual = result.length === test.output.length;
    const valEqual = result.every((val, index) => {
      return val === test.output[index];
    });
    const passed = lenEqual && valEqual;
    console.log(`test passed : ${passed}`);
  });
})();

// problems to try after
// 238, 273, 121, 973, 56, 692, 139