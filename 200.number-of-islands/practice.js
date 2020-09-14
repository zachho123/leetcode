function numIslands(grid) {
  let numIslands = 0;

  for(let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      if (grid[row][col] === 1) {
        console.log('entering');
        numIslands += 1;
        // dfs(grid, row, col);
        bfs(grid, row, col);
      }
    }
  }

  return numIslands;
}

function dfs(grid, row, col) {
  // stack way
  let stack = [];
  stack.push([row, col]);

  while (stack.length > 0) {
    const curr = stack.pop();

    if (withinBounds(grid, curr[0], curr[1])) {
      if (grid[curr[0]][curr[1]] === 1) {
        grid[curr[0]][curr[1]] = 0;

        console.log('=====');
        console.log(grid);
        console.log('=====');


        stack.push([curr[0] - 1, curr[1]]);
        stack.push([curr[0] + 1, curr[1]]);
        stack.push([curr[0], curr[1] - 1]);
        stack.push([curr[0], curr[1] + 1]);
      }
    }
  }

  // recursive way
  // if (withinBounds(grid, row, col)) {
  //   if (grid[row][col] === 1) {
  //     grid[row][col] = 0;

  //     console.log('=====');
  //     console.log(grid);
  //     console.log('=====');

  //     dfs(grid, row - 1, col); // up
  //     dfs(grid, row + 1, col); // down
  //     dfs(grid, row, col - 1); // left
  //     dfs(grid, row, col + 1); // right
  //   }
  // }
}

function bfs(grid, row, col) {
  let queue = [];
  queue.push([row, col]);

  while (queue.length > 0) {
    const curr = queue.shift();

    if (withinBounds(grid, curr[0], curr[1])) {
      if (grid[curr[0]][curr[1]] === 1) {
        grid[curr[0]][curr[1]] = 0;

        console.log('=====');
        console.log(grid);
        console.log('=====');


        queue.push([curr[0] - 1, curr[1]]); // up
        queue.push([curr[0] + 1, curr[1]]); // down
        queue.push([curr[0], curr[1] - 1]); // left
        queue.push([curr[0], curr[1] + 1]); // right
      }
    }
  }
}

function withinBounds(grid, row, col) {
  return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
}

(function run() {
  let test = {
    grid: [
      [1, 1, 0, 0, 0],
      [1, 1, 0, 0, 0],
      [0, 0, 1, 0, 0],
      [0, 0, 0, 1, 1]
    ],
    output: 3
  };

  const result = numIslands(test.grid);
  const passed = test.output === result;
  console.log(`Test passed : ${passed}`);
})();