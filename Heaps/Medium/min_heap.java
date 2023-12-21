// Problem link: https://www.codingninjas.com/codestudio/problems/min-heap_4691801?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
class Solution {
    // tc: O(nlogn) sc: O(n)
    static int left(int k){
        return 2*k+1;
    }
    static int right(int k){
        return 2*k+2;
    }
    static int parent(int k){
        return (k-1)/2;
    }

    static void heapify(int [] heap, int k, int size){
        int l=left(k);
        int r=right(k);
        int smallest=k;

        if(l<size && heap[l]<heap[k]){
            smallest=l;
        }
        if(r<size && heap[r]<heap[smallest]){
            smallest=r;
        }
        if(smallest!=k){
            int temp=heap[k];
            heap[k]=heap[smallest];
            heap[smallest]=temp;

            heapify(heap,smallest,size);
        }
    }

    static int siz;

    static void insert(int [] heap, int val){
        heap[siz]=val;
        int i=siz;
        siz+=1;
        while(i!=0 && heap[parent(i)]>heap[i]){
            int temp=heap[i];
            heap[i]=heap[parent(i)];
            heap[parent(i)]=temp;

            i=parent(i);
        }
    }

    static int extractmin(int[] heap){
        if(siz==1){
            siz-=1;
            return heap[0];
        }

        int val=heap[0];
        heap[0]=heap[siz-1];
        siz-=1;

        heapify(heap,0,siz);
        return val;
    }

    static int[] minHeap(int n, int[][] q) {
        int size=0;
        int[] heap=new int[n];
        int total=0;
        for(int i=0;i<n;i++){
            if(q[i][0]==1)total++;
        }

        int[] ans = new int[total];
        int id = 0;
        for (int i = 0; i < n; i++) {

            if (q[i][0] == 0) {
                siz = size;
                insert(heap, q[i][1]);
                size = siz;
            } else {
                siz = size;
                ans[id++] = extractmin(heap);
                size = siz;
            }
        }

        return ans;

    }
}