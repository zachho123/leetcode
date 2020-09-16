/**
 * Finds length of longest substring without repeat characters
 * @param {*} s - The input string.
 * @return {number} The length of longest substring without repeat characters.
 */
function lengthOfLongestSubstring(s) {
    if (!s) {
        return 0;
    } else if (s.length === 1) {
        return 1;
    }

    let maxLength = 0;
    let front = 0;
    let back = 0;
    let map = new Map(); // Keeps track of seen chars and their positions

    while (back < s.length) {
        let currChar = s.charAt(back);
        if (map.has(currChar) && map.get(currChar) >= front) {
            maxLength = Math.max(back - front, maxLength);
            front = map.get(currChar) + 1;
            map.set(currChar, back);
        }
        map.set(currChar, back);
        back++;
    }
    maxLength = Math.max(back - front, maxLength);

    return maxLength;
}

/**
 * Runs "n" testcases or all if "n" not specified.
 * @param {number} n - The number of test cases to run.
 */
function runTests(n) {
    const tests = [
        { testcase: null, expected: 0 },
        { testcase: '', expected: 0 },
        { testcase: 'a', expected: 1 },
        { testcase: 'aa', expected: 1 },
        { testcase: 'ab', expected: 2 },
        { testcase: 'abcabcbb', expected: 3 },
        { testcase: 'bbbbb', expected: 1 },
        { testcase: 'pwwkew', expected: 3 },
        { testcase: 'abcdbalkm', expected: 7 }
    ];

    if (!n) { n = tests.length; }

    for (let i = 0; i < tests.length && i <= n; i++) {
        let testcase = tests[i].testcase;
        let expected = tests[i].expected;
        let result = lengthOfLongestSubstring(testcase);
        let isPassed = result === expected ? 'Passed' : 'Failed';

        console.log(`Running test case ${i+1}: ${testcase} - ${isPassed}`);
        console.log(`\texpected: ${expected}, got: ${result}\n`);
    }
}

runTests();