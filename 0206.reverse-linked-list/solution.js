/**
 * Reverses a linked list.
 * @param {*} head 
 */
function reverseList(head) {
  let newHead = null;
  let curr = head;

  while (curr) {
    let temp = curr.next;
    curr.next = newHead;
    newHead = curr;
    curr = temp;
  }

  return newHead;
}

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}

function makeLL(nums) {
  let head = null;

  for (let i = nums.length - 1; i >= 0; i--) {
    const node = new ListNode(nums[i], head);
    head = node;
  }

  return head;
}

(function run() {
  const tests = [
    {
      input: makeLL([1, 2, 3]),
      output: makeLL([3, 2, 1])
    }
  ];

  tests.forEach(test => {
    console.log('running test...');
    let result = reverseList(test.input);
    let expected = test.output;
    let passed = true;

    while (result || expected) {
      if (result.val !== expected.val) {
        passed = false;
        break;
      }
      result = result.next;
      expected = expected.next;
    }

    console.log('test passed: ' + passed);
  });
})();