/**
 * Return all critical connections (critical = without which, some server
 * would be unable to reach some other server).
 * @param {number} n - Number of servers (vertices).
 * @param {number[][]} connections - List of connections (edges).
 * @return {number[][]} - List of critical connections.
 */
function criticalConnections(n, connections) {
  let graph = [];
  for (let i = 0; i < n; i++) {
    graph.push([]);
  }

  for (let i = 0; i < n; i++) {
    const con = connections[i];
    graph[con[0]].push(con[1]);
    graph[con[1]].push(con[0]);
  }

  console.log(graph);

  let timer = [0];
  let results = [];
  let visited = new Array(n);
  let timeStamp = new Array(n);

  dfs(graph, -1, 0, timer, visited, results, timeStamp);

  return results;
}

function dfs(graph, parent, node, timer, visited, results, timeStamp) {
  console.log('looking at node ' + node);
  visited[node] = true;
  timeStamp[node] = timer[0]++;
  let curr = timeStamp[node];

  for (let i = 0; i < graph[node].length; i++) {
    const neighbor = graph[node][i];
  // for (const neighbor of graph[node]) {
    if (neighbor === parent) { continue; }
    if (!visited[neighbor]) {
      dfs(graph, node, neighbor, timer, visited, results, timeStamp);
    }
    timeStamp[node] = Math.min(timeStamp[node], timeStamp[neighbor]);
    if (curr < timeStamp[neighbor]) {
      console.log('found an answer');
      results.push([node, neighbor]);
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