/**
 * Return all critical connections (critical = without which, some server
 * would be unable to reach some other server).
 * @param {number} n - Number of servers (vertices).
 * @param {number[][]} connections - List of connections (edges).
 * @return {number[][]} - List of critical connections.
 */
function criticalConnections(n, connections) {
  // Create map of connections
  let edges = new Map();
  for (let i = 0; i < n; i++) {
    edges.set(i, []);
  }
  for (let i = 0; i < connections.length; i++) {
    const v1 = connections[i][0];
    const v2 = connections[i][1];
    edges.get(v1).push(v2);
    edges.get(v2).push(v1);
  }

  let critical = [];
  let visited = new Array(n).fill(-1);
  // Each node will be assigned a "visited" value based on when it's visited
  // This value is an array so that the value passed to dfs is a reference
  // (ie: changes within the function will reflect outside)
  let visitedCounter = [0];

  // DFS the graph, critical connections will not be a part of a cycle
  dfs(-1, 0, edges, visited, visitedCounter, critical);

  return critical;
}

function dfs(parent, node, edges, visited, visitedCounter, critical) {
  // Mark current node as visited, and save the time visited
  visited[node] = visitedCounter[0]++;
  const timeVisited = visited[node];

  // DFS for every neightbor (skipping parent)
  for (const neighbor of edges.get(node)) {
    if (neighbor === parent) {
      continue;
    }
    if (visited[neighbor] === -1) {
      dfs(node, neighbor, edges, visited, visitedCounter, critical);
    }
    // Make the visited value for the current node, the min between itself and
    // its neighbor. A lower value indicates cycles.
    visited[node] = Math.min(visited[node], visited[neighbor]);
    // If the inital visited time for this node is less than that of its
    // neighbor, then it's a critical edge
    if (timeVisited < visited[neighbor]) {
      critical.push([node, neighbor]);
    }
  }
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