/* Your algorithm should run in O(n) time and use constant extra space */

/**
 * Finds the smallest missing positive integer.
 * @param {number[]} nums - Unsorted integer array.
 * @returns {number} - Smallest missing positive integer. 
 */
function firstMissingPositive(nums) {
    

    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];
        
    }

    return min - (min - 1);
}

(function runTests() {
    let tests = [
        { case: [1, 2, 0], expected: 3 },
        { case: [3, 4, -1, 1], expected: 2 },
        { case: [7, 8, 9, 11, 12], expected: 1 },
    ];

    tests.forEach( (test) => {
        let result = firstMissingPositive(test.case);
        let passed = result === test.expected;
        console.log(`Ran test... - Passed? = ${passed}`);
        console.log(`Expected: ${test.expected}, Got: ${result}`);
    });
})();