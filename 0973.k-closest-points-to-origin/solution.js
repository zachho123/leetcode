/**
 * Returns the k closest points to the origin.
 * @param {number[][]} points 
 * @param {number} K
 * @return {number[][]} 
 */
function kClosest(points, K) {
  const origin = [0, 0];
  console.log(distance(origin, [2, 2]));
}

function distance(p1, p2) {
  return Math.sqrt((p2[1] - p1[1]) + (p2[0] - p1[0]));
}

class MinHeap {
  constructor() {
    this.heap = [null];
  }

  getMin() {
    return this.heap[1];
  }

  insert(node) {
    this.heap.push(node);

    if (this.heap.length > 2) {

    }
  }
}

(function run() {
  const tests = [
    {
      input: {
        points: [[1, 3], [-2, 2]],
        k: 1
      },
      output: [[-2, 2]]
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test...');
    const result = kClosest(test.input);
    console.log(result);
  });
})();