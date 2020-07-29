/**
 * Finds the sum of unique characters for every substring of the input string.
 * @param {string} s - The input string.
 * @returns {number} The sum of unique characters per substring % (10 ^ 9 + 7);
 */
function uniqueLetterString(s) {
    const moduloNumber = Math.pow(10, 7) + 7;
    let sum = 0;

    if (s.length === 1) {
        return 1;
    }

    // Generate every substring, and call countUniqueChars() on them
    for (let i = 0; i < s.length; i++) {
        for (let j = i + 1; j < s.length; j++) {
            console.log(`current string: ${s.substring(i, j)}`);
            sum += countUniqueChars(s.substring(i, j));
            console.log(`sum is now: ${sum}`);
        }
    }

    return sum % moduloNumber;
}

/**
 * Counts the number of unique characters in the string.
 * @param {string} s - The input string.
 * @returns {number} Number of unique characters in the string.
 */
function countUniqueChars(s) {
    let unique = new Set();
    let notUnique = new Set();

    for (let i = 0; i < s.length; i++) {
        const currChar = s.charAt(i);

        // If we know the current letter isn't unique, skip it
        if (notUnique.has(currChar)) {
            continue;
        }
        
        // If we've already seen the current letter, mark it as not unique
        // and remove it from the unique set
        if (unique.has(currChar)) {
            notUnique.add(currChar);
            unique.delete(currChar);
        } else {
            unique.add(currChar);
        }
    }

    return unique.size;
}

(function runCountUniqueCharsTests() {
    const tests = [
        { s: 'A', expected: 1 },
        { s: 'AA', expected: 0 },
        { s: 'AB', expected: 2 },
        { s: 'ABA', expected: 1 }
    ];

    console.log('RUNNING countUniqueChars() TESTS...');

    tests.forEach( (test) => {
        let result = countUniqueChars(test.s);
        let testPassed = result === test.expected ? 'Passed' : 'Failed';

        console.log(`Running test: ${test.s}... - ${testPassed}`);
        console.log(`\tExpected: ${test.expected}, Got: ${result}`);
    });

    console.log();
})();

(function runUniqueLetterStringTests() {
    const tests = [
        { s: 'A', expected: 1 },
        { s: 'AB', expected: 4 },
        { s: 'ABC', expected: 10 }
    ];

    console.log('RUNNING uniqueLetterString() TESTS...');

    tests.forEach( (test) => {
        console.log(`Running test: ${test.s}...`);

        let result = uniqueLetterString(test.s);
        let testPassed = result === test.expected ? 'Passed' : 'False';

        console.log(`\t${testPassed} - Expected: ${test.expected}, Got: ${result}`);
    });

    console.log();
})();
