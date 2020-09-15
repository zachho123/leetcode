/**
 * Reorders logs such that letter-logs come before digit-logs.
 * @param {string[]} logs - Array of logs (space delimited string of words).
 * @return {string[]} - Returns ordered logs.
 */
function reorderLogFiles(logs) {
  let letterLogs = [];
  let digitLogs = [];

  for (const log of logs) {
    if (isDigit(body(log).charAt(0))) {
      digitLogs.push(log);
    } else {
      letterLogs.push(log);
    }
  }

  return [...letterLogs.sort(compareLogs), ...digitLogs];
}

function compareLogs(a, b) {
  const compare = body(a).localeCompare(body(b));
  if (compare !== 0) {
    return compare;
  }
  return a.localeCompare(b);
}

function isDigit(char) {
  return char >= '0' && char <= '9';
}

function body(log) {
  return log.slice(log.indexOf(' ') + 1);
}

(function run() {
  let tests = [
    {
      input: [
        'dig1 8 1 5 1',
        'let1 art can',
        'dig2 3 6',
        'let2 own kit dig',
        'let3 art zero'
      ],
      output: [
        'let1 art can',
        'let3 art zero',
        'let2 own kit dig',
        'dig1 8 1 5 1',
        'dig2 3 6'
      ]
    }
  ];

  tests.forEach(test => {
    console.log('running test...');
    const results = reorderLogFiles(test.input);
    const passed = test.output.every((val, index) => {
      return val === results[index];
    });
    console.log(`test passed: ${passed}`);
  });
})();