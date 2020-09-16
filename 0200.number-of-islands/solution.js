/**
 * Counts the number of distinct islands.
 * @description An island is surrounded by ocean, and is formed by connecting
 * adjacent (vertical/horizontal) lands. It is assumed all four edged of the
 * input grid are surrounded by water.
 * @param {string[][]} grid - Input grid of 1's (land) and 0's (ocean).
 * @returns {number} The number of islands in the grid.
 */
function numIslands(grid) {
    let numIslands = 0;

    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[0].length; col++) {
            if (grid[row][col] === '1') {
                numIslands++;
                // dfs(grid, row, col);
                bfs(grid, row, col);
            }
        }
    }

    return numIslands;
}

function dfs(grid, row, col) {
    // stack way
    // let stack = [];
    // stack.push([row, col]);

    // while (stack.length > 0) {
    //     const curr = stack.pop();

    //     if (withinBounds(grid, curr[0], curr[1])) {
    //         if (grid[curr[0]][curr[1]] === '1') {
    //             grid[curr[0]][curr[1]] = '0';

    //             stack.push([curr[0] - 1, curr[1]]);
    //             stack.push([curr[0] + 1, curr[1]]);
    //             stack.push([curr[0], curr[1] - 1]);
    //             stack.push([curr[0], curr[1] + 1]);
    //         }
    //     }
    // }

    // recursive way
    if (withinBounds(grid, row, col)) {
        if (grid[row][col] === '1') {
            grid[row][col] = '0';
            dfs(grid, row - 1, col); // check up
            dfs(grid, row, col - 1); // check left
            dfs(grid, row, col + 1); // check right
            dfs(grid, row + 1, col); // check down
        }
    }
}

function bfs(grid, row, col) {
    let queue = [];
    queue.push([row, col]);

    while (queue.length > 0) {
        const curr = queue.shift();

        if (withinBounds(grid, curr[0], curr[1])) {
            if (grid[curr[0]][curr[1]] === '1') {
                grid[curr[0]][curr[1]] = '0';

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

(function runTests() {
    let tests = [
        {
            grid: [
                '11110'.split(''),
                '11010'.split(''),
                '11000'.split(''),
                '00000'.split(''),
            ],
            expected: 1
        },
        {
            grid: [
                '11000'.split(''),
                '11000'.split(''),
                '00100'.split(''),
                '00011'.split(''),
            ],
            expected: 3
        }
    ];

    tests.forEach((test) => {
        let result = numIslands(test.grid);
        let testPassed = result === test.expected ? 'Passed' : 'Failed';

        console.log(`Running test... - ${testPassed}`);
        console.log(`Expected: ${test.expected}, Got: ${result}`);
    });
})();