function addTwoNumbers(l1, l2) {
    let head = new ListNode();
    let curr = head;
    let carry = 0;

    while (l1 || l2 || carry) {
        let l1val = l1 ? l1.val : 0;
        let l2val = l2 ? l2.val : 0;
        let sum = l1val + l2val + carry;

        if (sum > 9) {
            sum = sum % 10;
            carry = 1;
        } else {
            carry = 0;
        }

        let node = new ListNode(sum, head);
        curr.next = node;
        curr = curr.next;

        l1 = l1 ? l1.next : l1;
        l2 = l2 ? l2.next : l2;
    }
    curr.next = null;

    return head.next;
}

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
}

function createLL(nums) {
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
            input: {
                l1: createLL([2, 4, 3]),
                l2: createLL([5, 6, 4])
            },
            output: createLL(8, 0, 7)
        }
    ];

    tests.forEach(test => {
        console.log('\nrunning test...');
        let result = addTwoNumbers(test.input.l1, test.input.l2);
        while (result) {
            console.log(result.val);
            result = result.next;
        }
    });
})();