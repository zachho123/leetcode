/**
 * Problem: Implement a basic elimination algorithm for candy crush.
 * 
 * - Given 2-D integer array representing board.
 * - Diff positive integers represent diff types of candy.
 * - Value of 0 indicates empty cell.
 * - Given board represents board state following a player's move.
 * 
 * Restore the board to a stable state by:
 * 1. "Crush" candy clusters of size 3+ (touchong adjacent vertical/horizontal)
 * 2. After crushing, drop candy from above to fill in empty space
 * 3. If new candy clusters formed, repeats steps 1 & 2
 * 4. Return stable board (no many candy clusters to crush)
 * 
 * Constraints:
 * Board - # rows in range 3-50.
 * Board - # cols in range 3-50.
 * Candy integers range from 1-2000.
*/

/**
 * Returns the board to a stable state.
 * @param {number[][]} board - The board state following a player's move.
 * @returns {number[][]} The stable board state.
*/
function stabilize(board) {

}

(function runTests() {
    let tests = [
        {
            input: [
                [110,5,112,113,114],
                [210,211,5,213,214],
                [310,311,3,313,314],
                [410,411,412,5,414],
                [5,1,512,3,3],
                [610,4,1,613,614],
                [710,1,1,713,714],
                [810,1,2,1,1],
                [1,1,2,2,2],
                [4,1,4,4,1014]
            ],
            output: [
                [0,0,0,0,0],
                [0,0,0,0,0],
                [110,0,0,0,114],
                [210,0,0,0,214],
                [310,0,0,113,314],
                [410,0,0,213,414],
                [610,211,112,313,614],
                [710,311,412,613,714],
                [810,411,512,713,1014]
            ]
        }
    ];

    tests.forEach( (test) => {
        const result = stabilize(test.input);

        const passed = result.length === test.output.length &&
            result[0].length === test.output[0].length &&
            result.every( (row, rowIndex) => {
                const expectedRow = test.output[rowIndex];

                row.every( (value, colIndex) => {
                    value === expectedRow[colIndex];
                });
            });

        console.log(`Test passed? : ${passed}`);
    });
})();