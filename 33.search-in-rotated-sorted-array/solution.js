/**
 * Returns the index of the target.
 * @param {number[]} nums - Rotated sorted array to search.
 * @param {number} target - Value to search for.
 */
function search(nums, target) {
    let start = 0
    let end = nums.length;
    let half = Math.floor(nums.length / 2);

    console.log('start half ' + half);

    if (nums[half] === target) {
        return half;
    // if target < half, answer should be in first half
    } else if (target < nums[half]) {
        // if target < start, answer might be rotated, check 2nd half
        if (target < nums[start]) {
            start = half + 1;
            half = Math.floor((end - start) / 2) + start;
        // check first half
        } else {
            end = half;
            half = Math.floor((end - start) / 2) + start;
        }
    // if target > half, answer should be in 2nd half
    } else {
        console.log('beeger');
        // if target > end, answer might be rotated, check 1st half
        if (target > nums[end]) {
            end = half;
            half = Math.floor((end - start) / 2) + start;
        // check 2nd half
        } else {
            start = half + 1;
            half = Math.floor((end - start) / 2) + start;
        }
    }

    while (start !== end) {
        console.log('start ' + start);
        console.log('end ' + end);
        console.log('half ' + half);
        if (nums[half] === target) {
            return half;
        } else if (target < nums[half]) {
            end = half;
            half = Math.floor((end - start) / 2) + start;
        } else {
            start = half + 1;
            half = Math.floor((end - start) / 2) + start;
        }
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
        }
    ];

    tests.forEach(test => {
        const result = search(test.input.nums, test.input.target);
        const passed = result === test.output;

        console.log(`Ran test... test passed : ${passed}`);
        console.log(`Expected: ${test.output}, Got: ${result}\n`);
    });
})();