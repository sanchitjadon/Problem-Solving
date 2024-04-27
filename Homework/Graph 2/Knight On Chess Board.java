import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>(A + 1);
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<>(A + 1);

        for (int i = 0; i <= A; i++) {
            grid.add(new ArrayList<>(B + 1));
            visited.add(new ArrayList<>(B + 1));
            for (int j = 0; j <= B; j++) {
                grid.get(i).add(0);
                visited.get(i).add(false);
            }
        }

        Queue<Pair<Integer, Pair<Integer, Integer>>> q = new LinkedList<>();
        visited.get(C).set(D, true);

        q.add(new Pair<>(0, new Pair<>(C, D)));

        while (!q.isEmpty()) {
            int dist = q.peek().getKey();
            int ci = q.peek().getValue().getKey();
            int cj = q.peek().getValue().getValue();

            if (ci == E && cj == F) {
                return dist;
            }
            q.poll();

            int[] di = {-2, -2, 2, 2, -1, 1, -1, 1};
            int[] dj = {-1, 1, -1, 1, 2, 2, -2, -2};

            for (int k = 0; k < 8; k++) {
                int ni = ci + di[k];
                int nj = cj + dj[k];

                if (ni >= 1 && nj >= 1 && ni <= A && nj <= B && !visited.get(ni).get(nj)) {
                    visited.get(ni).set(nj, true);
                    q.add(new Pair<>(dist + 1, new Pair<>(ni, nj)));
                }
            }
        }

        return -1;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
