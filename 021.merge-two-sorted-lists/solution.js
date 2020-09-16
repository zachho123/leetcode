/**
 * Merges two sorted linked lists.
 * @param {ListNode} l1 - Sorted linked list.
 * @param {ListNode} l2 - Sorted linked list.
 * @return {ListNode} - Returns a new merged, sorted linked list.
 */
function mergeTwoLists(l1, l2) {
  if (!l1) { return l2; }
  if (!l2) { return l1; }

  let head = null;

  // Get head
  if (l2.val < l1.val) {
    head = l2;
    l2 = l2.next;
  } else {
    head = l1;
    l1 = l1.next;
  }

  // While l1 and l2 have nodes left, take the smaller of the two
  let curr = head;
  while (l1 && l2) {
    if (l2.val < l1.val) {
      curr.next = l2;
      l2 = l2.next;
    } else {
      curr.next = l1;
      l1 = l1.next;
    }
    curr = curr.next;
  }

  // If only l1 or l2 have nodes left, take from there
  curr.next = !l1 ? l2 : l1;

  return head;
}

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}

function createLL(nums) {
  let head = null;
  let last = null;

  for (let i = nums.length - 1; i >= 0; i--) {
    head = new ListNode(nums[i], last);
    last = head;
  }

  return head;
}

(function run() {
  let tests = [
    {
      l1: createLL([1, 2, 4]),
      l2: createLL([1, 3, 4]),
      output: createLL([1, 1, 2, 3, 4, 4])
    }
  ];

  tests.forEach(test => {
    console.log('\nrunning test...');
    let result = mergeTwoLists(test.l1, test.l2);
    let expected = test.output;
    let passed = true;

    while (result) {
      if (result.val !== expected.val) {
        passed = false;
        break;
      }
      result = result.next;
      expected = expected.next;
    }

    console.log(`test passed: ${passed}`);
  });
})();