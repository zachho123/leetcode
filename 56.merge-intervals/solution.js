/**
 * Merges all overlapping intervals.
 * @param {number[][]} intervals - Collection of intervals.
 * @returns {number[][]} Collection of merged intervals.
 */
function merge(intervals) {
    let merged = [];

    // Sort intervals based on starting index then combine as necessary
    intervals.sort((a, b) => a[0] - b[0]);
    let lastStart = null;
    let lastEnd = null;

    for (let i = 0; i < intervals.length; i++) {
        let start = intervals[i][0];
        let end = intervals[i][1];

        // If merged is empty or current interval doesn't overlap with last
        if (merged.length === 0 || start > lastEnd) {
            merged.push([start, end]);
        } else {
            end = Math.max(lastEnd, end);
            merged[merged.length-1][1] = end;
        }

        lastEnd = end;
    }

    return merged;
}

(function runTests() {
    let tests = [
        {
            input: [ [1,3],[2,6],[8,10],[15,18] ],
            output: [ [1,6],[8,10],[15,18] ]
        },
        {
            input: [ [1, 4],[4, 5] ],
            output: [ [1,5] ]
        },
        {
            input: [ [2,6],[1,3] ],
            output: [ [1,6] ]
        },
        {
            input: [ [1,4],[2,3] ],
            output: [ [1,4] ]
        }
    ];

    tests.forEach(test => {
        const result = merge(test.input);

        const passed = result.every((interval,index) => {
            const expectedInterval = test.output[index];

            return interval.every((value,index) => {
                return value === expectedInterval[index];
            });
        });

        console.log(`Test ran, passed = ${passed}`);
    });
})();