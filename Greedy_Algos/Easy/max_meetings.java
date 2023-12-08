package Greedy_Algos.Easy;

import java.util.Comparator;
import java.util.*;
// Problem link: https://www.codingninjas.com/studio/problems/maximum-meetings_1062658?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Solution {
    public static class meeting{
        int start;
        int end;
        int pos;
        
        meeting(int start,int end,int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }

    public static class meetingcomparator implements Comparator<meeting>{
        @Override
        public int compare(meeting o1, meeting o2){
            if(o1.end<o2.end) return -1;
            else if(o1.end>o2.end) return 1;
            else if(o1.pos<o2.pos) return -1;
            else return 1;
        }
    }
    public static int maximumMeetings(int []start, int []end) {
        // Optimal - tc: O(n+nlogn+n) sc: O(n)
       ArrayList<meeting> meet=new ArrayList<>();
       for(int i=0;i<start.length;i++){
           meet.add(new meeting(start[i], end[i], i+1));
       }
       meetingcomparator mc=new meetingcomparator();
       Collections.sort(meet,mc);
       ArrayList<Integer> ans=new ArrayList<>();
       ans.add(meet.get(0).pos);
       int limit=meet.get(0).end;

       for(int i=1;i<start.length;i++){
           if(meet.get(i).start>limit){
               limit=meet.get(i).end;
               ans.add(meet.get(i).start);
           }
       }
       return ans.size();
    }
}
