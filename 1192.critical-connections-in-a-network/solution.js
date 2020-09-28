/**
 * Return all critical connections (critical = without which, some server
 * would be unable to reach some other server).
 * @param {number} n - Number of servers (vertices).
 * @param {number[][]} connections - List of connections (edges).
 * @return {number[][]} - List of critical connections.
 */
function criticalConnections(n, connections) {
  // Create map of connections
  let edges = mapConnections(n, connections);
  let critical = [];
  let visited = new Array(n).fill(-1);
  let visitedCounter = [0]; // value is array so changes in dfs reflect out here

  // DFS the graph, critical connections will not be a part of a cycle
  dfs(-1, 0, edges, visited, visitedCounter, critical);

  return critical;
}

function mapConnections(n, connections) {
  const map = new Map();

  for (let i = 0; i < n; i++) {
    map.set(i, []);
  }

  for (let i = 0; i < connections.length; i++) {
    const v1 = connections[i][0];
    const v2 = connections[i][1];
    map.get(v1).push(v2);
    map.get(v2).push(v1);
  }

  return map;
}

/**
 * Performs a dfs of the network graph. As we traverse nodes, we mark them with
 * a rank based on the order visited. After each neighbor is visited, we
 * update the rank of the node to the minimum observed rank between its current
 * rank, and the rank of its neighbor in order to determine cycles. A critical
 * edge will not be a part of a cycle.
 * 
 * Explanation: If we're traversing, and run into a neighbor rank which is 
 * <= current rank, we know that we've hit a cycle (as we know that node has
 * already been visited, and will lead back to the current node). On the
 * contrary, if we hit a rank which is greater than the current, we've hit a
 * "bridge" (critical edge).
 * @param {number} parent 
 * @param {number} node 
 * @param {Map} edges 
 * @param {number[]} visited 
 * @param {number[]} visitedCounter 
 * @param {Array<number[]>} critical 
 */
function dfs(parent, node, edges, visited, visitedCounter, critical) {
  // Mark current node as visited, and save the time visited
  visited[node] = visitedCounter[0]++;
  const timeVisited = visited[node];

  for (const neighbor of edges.get(node)) {
    // Skip over parent node that was just visited
    if (neighbor === parent) {
      continue;
    }

    // If not visited, continue dfs
    if (visited[neighbor] === -1) {
      dfs(node, neighbor, edges, visited, visitedCounter, critical);
    }

    // Update current node with least
    visited[node] = Math.min(visited[node], visited[neighbor]);

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