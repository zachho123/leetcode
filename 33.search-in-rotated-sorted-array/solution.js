/**
 * Returns the index of the target.
 * @param {number[]} nums - Rotated sorted array to search.
 * @param {number} target - Value to search for.
 */
function search(nums, target) {
    let start = 0
    let end = nums.length;
    let half = Math.floor(nums.length / 2);

    if (nums.length === 0) {
        return -1;
    }

    if (nums[half] === target) {
        return half;
    } 
    
    // If target < half, but target > start -> possible rotated
    // If target > half, but target > end -> possible rotated
    // Check front half
    if (target < nums[half] && target >= nums[start] ||
        target > nums[half] && target > nums[end - 1]) {
            end = half;
    // Else check back half
    } else {
        start = half + 1;
    }
    half = Math.floor((end - start) / 2) + start;

    while (start !== end) {
        if (nums[half] === target) {
            return half;
        } else if (target < nums[half]) {
            end = half;
        } else {
            start = half + 1;
        }
        half = Math.floor((end - start) / 2) + start;
    }

    return -1;
}

(function runTests() {
    let tests = [
        {
            input: {
                nums: [4, 5, 6, 7, 0, 1, 2], // size 7
                target: 0
            },
            output: 4
        },
        {
            input: {
                nums: [4, 5, 6, 7, 0, 1, 2],
                target: 3
            },
            output: -1
        },
        {
            input: {
                nums: [2, 3, 4, 5, 6, 7, 0, 1], // size 8
                target: 3
            },
            output: 1
        },
        {
            input: {
                nums: [2, 0, 1], // size 3
                target: 2
            },
            output: 0
        },
        {
            input: {
                nums: [1, 2],
                target: 1
            },
            output: 0
        },
        {
            input: {
                nums: [7, 8, 1, 2, 3, 4, 5, 6],
                target: 2
            },
            output: 3
        }
    ];

    tests.forEach(test => {
        const result = search(test.input.nums, test.input.target);
        const passed = result === test.output;

        console.log(`Ran test... test passed : ${passed}`);
        console.log(`Expected: ${test.output}, Got: ${result}\n`);
    });
})();