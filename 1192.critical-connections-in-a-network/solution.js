/**
 * Return all critical connections (critical = without which, some server
 * would be unable to reach some other server).
 * @param {number} n - Number of servers.
 * @param {number[][]} connections - List of connections.
 * @return {number[][]} - List of critical connections.
 */
function criticalConnections(n, connections) {

}

(function run() {
  const tests = [
    {
      input: {
        n: 4,
        connections: [[0, 1], [1, 2], [2, 0], [1,3]]
      },
      output: [[1, 3]]
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test..');
    const result = criticalConnections(test.input);
    const passed = result === test.output;
    console.log(`test passed: ${passed}`);
  });
})();