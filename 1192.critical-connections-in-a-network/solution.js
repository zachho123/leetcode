/**
 * Return all critical connections (critical = without which, some server
 * would be unable to reach some other server).
 * @param {number} n - Number of servers (vertices).
 * @param {number[][]} connections - List of connections (edges).
 * @return {number[][]} - List of critical connections.
 */
function criticalConnections(n, connections) {
  // Create map of connections
  let map = new Map();
  for (let i = 0; i < n; i++) {
    map.set(i, []);
  }
  for (let i = 0; i < connections.length; i++) {
    const v1 = connections[i][0];
    const v2 = connections[i][1];
    map.get(v1).push(v2);
    map.get(v2).push(v1);
  }

  
}

function dfs() {
  
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
    const result = criticalConnections(test.input.n, test.input.connections);
    console.log(result);
  });
})();