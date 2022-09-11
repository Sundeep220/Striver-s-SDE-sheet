package com.Sundeep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class N_meetings_in_a_room {
    static class meeting {
        int start;
        int end;
        int pos;

        meeting(int start, int end, int pos)
        {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    static class meetingComparator implements Comparator<meeting>
    {
        @Override
        public int compare(meeting o1, meeting o2)
        {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if(o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<meeting> meet = new ArrayList<>();

        for(int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i+1));

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for(int i = 1;i<start.length;i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        return answer.size();

    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);
    }
}
