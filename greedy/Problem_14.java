package greedy;

// Find max meetings in one room

public class Problem_14{
    static int maxMeetings(int start[], int end[], int n) {
        // Create an array of meetings
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        // Sort meetings based on their end times
        java.util.Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1; // First meeting is always selected
        int lastEndTime = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }

        return count;
    }

    static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        int maxMeetingsCount = maxMeetings(start, end, n);
        System.out.println("Maximum number of meetings that can be held: " + maxMeetingsCount);
    }
}