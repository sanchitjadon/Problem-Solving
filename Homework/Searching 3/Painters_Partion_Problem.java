import java.util.ArrayList;
import java.util.*;

public class Solution 
{
    public static int counting(ArrayList<Integer> boards, int time) {
        int n = boards.size();
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                boardsPainter += boards.get(i);
            } else {
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = counting(boards, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
