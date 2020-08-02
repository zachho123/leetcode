/* Your algorithm should run in O(n) time and use O(1) extra space */

/**
 * Finds the smallest missing positive integer.
 * @param {number[]} nums - Unsorted integer array.
 * @returns {number} - Smallest missing positive integer. 
 */
function firstMissingPositive(nums) {
    const n = nums.length;

    // If there is a *missing* integer, we know it must be in the
    // range 1...n. Therefore, any negative number or number 
    // greater than n, we can mark as a "dud". We will do this by giving it a
    // positive value outside of our 1...n solution range -> n + 1 works.
    for (let i = 0; i < n; i++) {
        const num = nums[i];
        if (num <= 0 || num > n) {
            nums[i] = n + 1;
        }
    }

    // We now have an array with all positive integers between 1...n+1.
    // Make another pass to indicate which integers are present by marking
    // the array at index = value - 1. We mark the index by flipping the
    // value to negative.
    for (let i = 0; i < n; i++) {
        const num = Math.abs(nums[i]);
        const indexToMark = num - 1;

        // Only multiply by -1 if number is positive
        if (num <= n && nums[indexToMark] > 0) {
            nums[indexToMark] = -1 * nums[indexToMark];
        }
    }

    // Iterate through one more time to figure out which number is missing.
    for (let i = 0; i < n; i++) {
        const num = nums[i];
        if (num > 0) {
            return i + 1;
        }
    }

    // If nothing was found and returned in the previous step, it means the
    // array 
    return n + 1;
}

(function runTests() {
    let tests = [
        { case: [1, 2, 0], expected: 3 },
        { case: [3, 4, -1, 1], expected: 2 },
        { case: [7, 8, 9, 11, 12], expected: 1 },
        { case: [6, 2, 4, 9, 1], expected: 3 },
        { case: [2, 1], expected: 3 },
        { case: [1, 2, 3, 4, 5], expected: 6 },
        { case: [1, 2, 3, 4, -1], expected: 5},
        { case: [1, 1], expected: 2 }
    ];

    tests.forEach( (test) => {
        console.log(`Running test: ${test.case}`);
        let result = firstMissingPositive(test.case);
        let passed = result === test.expected;
        console.log(`\tTest passed: ${passed}`);
        console.log(`\tExpected: ${test.expected}, Got: ${result}\n`);
    });
})();