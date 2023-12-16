// Problem link: https://www.codingninjas.com/codestudio/problems/implement-queue-using-arrays_8390825?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Solution {
    class Queue {
        int front, rear;
        int []arr;
        int cnt;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
            cnt=0;
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            int n=arr.length;
            if(cnt==n) return;
            arr[rear%n]=e;
            rear++;
            cnt++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            int n=arr.length;
            if(cnt==0) return -1;
            int x=arr[front%n];
            front++;
            cnt--;
            return x;
        }
    }
}