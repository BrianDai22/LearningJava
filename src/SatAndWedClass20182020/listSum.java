package SatAndWedClass20182020;
// Input: (1 -> 2 -> 3) + (6 -> 2 -> 7)  1's -> 10's -> 100's
// Output: 7 -> 4 -> 0 -> 1


// Explanation: 321 + 726 = 1047.
// No Leading 0 exist

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class listSum {

        // l1, l2 are head of list1 and list2
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode originalHead = new ListNode(0);
            ListNode fakeHead = originalHead;
            int carry = 0;

            while(l1 != null || l2 != null || carry != 0) {

                if(l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }

                originalHead.next = new ListNode(carry%10);
                carry /= 10;
                originalHead = originalHead.next;

            }
            return fakeHead.next;
        }


        public static void main(String[] args){
            // dummy test

            ListNode a1 = new ListNode(1);
            ListNode a2 = new ListNode(2);
            ListNode a3 = new ListNode(3);
            ListNode a4 = new ListNode(4);
            a1.next=a2;
            a2.next=a3;
            a3.next=a4;
            a4.next = null;

            ListNode b1=new ListNode(6);
            ListNode b2 = new ListNode(2);
            b1.next=b2;
            b2.next=null;

            ListNode result = addTwoNumbers(a1, b1);

            while(result != null) {
                System.out.println(result.val);
                result = result.next;
            }

        }

    }
