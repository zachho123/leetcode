/**
 * Finds if there exists two numbers in the input array that sum to target.
 * @param {*} nums - Array of integers.
 * @param {*} target - Target sum.
 * @return {number[]} - Indices of numbers which sum to target.
 */
function twoSum(nums, target) {
  let map = new Map();

  for (let i = 0; i < nums.length; i++) {
    const curr = nums[i];
    const temp = target - curr;

    if (map.has(temp)) {
      return [map.get(temp), i];
    }

    map.set(curr, i);
  }
}

(function run() {
  let tests = [
    { nums: [2, 7, 11, 15], target: 9, expected: [0, 1] },
    { nums: [3, 2, 4], target: 6, expected: [1, 2] },
    { nums: [3, 3], target: 6, expected: [0, 1] }
  ];

  tests.forEach(test => {
    console.log('Running test...');
    const result = twoSum(test.nums, test.target);
    const passed = result.every((value, index) => {
      return value === test.expected[index];
    });
    console.log(`Test passed? : ${passed}`);
  });
})();