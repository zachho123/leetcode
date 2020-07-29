/**
 * Finds length of longest substring without repeat characters
 * @param {*} s - The input string.
 * @return {number} The length of longest substring without repeat characters.
 */
function lengthOfLongestSubstring(s) {

}

/**
 * Runs a specified number of test cases.
 * @param {number} n - The number of test cases to run.
 */
function runTests(n) {
    let tests = [
        {
            testcase: 'abcabcbb',
            expected: 3
        },
        {
            testcase: 'bbbbb',
            expected: 1
        },
        {
            testcase: 'pwwkew',
            expected: 3
        }
    ];

    for (let i = 0; i <= tests.length && i < n; i++) {
        let testcase = tests[i].testcase;
        let expected = tests[i].expected;
        let result = lengthOfLongestSubstring(testcase) === expected 
            ? 'Passed' : 'Failed';

        console.log(`Running test case ${i+1}: ${testcase} - ${result}`);
    }
}

runTests(1);

