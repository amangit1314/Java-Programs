package graphs;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    static class DSU{
        private final int[] parent;
        private final int[] size;

        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if(parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }

        public void union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv)
                return;

            if(size[pu] >= size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }

        public int getSize(int idx){
            return size[idx];
        }
    }
    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        DSU dsu = new DSU(n);
        for(List<Integer> list: astronaut)
            dsu.union(list.get(0), list.get(1));

        Set<Integer> set = new HashSet<>();
        long ans = 0;
        int prevComponent = 0;
        for(int i = 0; i < n; i++){
            int pi = dsu.findParent(i);
            if(set.contains(pi))
                continue;
            set.add(pi);
            int size = dsu.getSize(pi);
            ans += (long) size *(Math.max(n-size-prevComponent,0));
            prevComponent += size;
        }
        return ans;
    }

}

public class Journey_Two_Moon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}