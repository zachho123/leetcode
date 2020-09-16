/**
 * Finds the longest palindromic substring in the input string.
 * @param {string} s - Input string.
 * @return {string} - Longest palindromic substring.
 */
function longestPalindrome(s) {
  // Because each half of a palindrome is a mirror of the other, we can check
  // for palindromes from the center outwards. For a string of size n, there are
  // 2n-1 possible "centers" (every character, plus every space between two
  // characters).
  if (!s || s.length === 0) {
    return '';
  }

  let maxLen = 0;
  let start = 0;

  for (let i = 0; i < s.length; i++) {
    // Check for palindrome with char at i as center
    const p1 = checkPalindrome(s, i, i);
    // Check for palindrome with center between char at i and i+1
    const p2 = checkPalindrome(s, i, i + 1);
    
    if (p1.length > maxLen) {
      maxLen = p1.length;
      start = p1.start;
    }

    if (p2.length > maxLen) {
      maxLen = p2.length;
      start = p2.start;
    }
  }

  return s.substring(start, start + maxLen);
}

function checkPalindrome(s, left, right) {
  let palindrome = {
    start: 0,
    length: 0
  };

  // While left and right indices are within bounds and the chars are equal
  // expand the palindrome
  while (left >= 0 && right < s.length && s.charAt(left) === s.charAt(right)) {
    palindrome.start = left;
    palindrome.length = right - left + 1;
    left--;
    right++;
  }

  return palindrome;
}

(function run() {
  const tests = [
    { input: 'babad', output: 'bab' },
    { input: 'cbbd', output: 'bb' },
    { input: 'a', output: 'a' }
  ];

  tests.forEach(test => {
    console.log('\nrunning test');
    const result = longestPalindrome(test.input);
    console.log(result);
    const passed = result === test.output;
    console.log(`test passed: ${passed}\n`);
  });
})();