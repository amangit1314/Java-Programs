package greedy;

// Program for Least Recently Used (LRU) page replacement algorithm

public class Problem_22 {
    static int pageFaults(int pages[], int n, int capacity) {
        java.util.Set<Integer> s = new java.util.HashSet<>(capacity);
        java.util.Map<Integer, Integer> indexes = new java.util.HashMap<>();
        int page_faults = 0;

        for (int i = 0; i < n; i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);
                    page_faults++;
                }
                indexes.put(pages[i], i);
            } else {
                if (!s.contains(pages[i])) {
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
                    for (Integer page : s) {
                        if (indexes.get(page) < lru) {
                            lru = indexes.get(page);
                            val = page;
                        }
                    }
                    s.remove(val);
                    s.add(pages[i]);
                    page_faults++;
                }
                indexes.put(pages[i], i);
            }
        }
        return page_faults;
    }

    public static void main(String args[]) {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;
        int n = pages.length;

        System.out.println("Total page faults: " + pageFaults(pages, n, capacity));
    }
}
