public class circleQueue {
    static class MyCircularQueue {
        public int[] q;
        public int front;
        public int length;
        public int back;


        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            q = new int[k];
            int front = 0;
            int back = -1;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            back = (back + 1) % (q.length);
            q[back] = value;
            length++;
            return true;

        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty()) {
                return false;
            }
            front = (front + 1) % (q.length);
            length--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return isEmpty() ? -1 : q[front];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return isEmpty() ? -1 : q[back];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return q.length == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return q.length == length;
        }
    }

/*
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
