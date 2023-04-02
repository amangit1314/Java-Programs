package greedy;

// Water Connection Problem
// Question From GFG
import java.util.*;

public class Problem_04 {

    static class House{
        int in;
        int out;
        int dia;

        House(int in,int out,int dia){
            this.in = in;
            this.out = out;
            this.dia = dia;
        }
    }

    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d) {
        HashMap<Integer,House> map = new HashMap<>();
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for(int i = 0; i < p; i++){
            out[a.get(i)] = 1;
            in[b.get(i)] = 1;
            map.put(a.get(i), new House(a.get(i), b.get(i), d.get(i)));
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(in[i] == 0 && out[i] == 1){
                House curr = map.get(i);
                int e = curr.out;
                int dia = curr.dia;

                while(map.containsKey(curr.out)) {
                    curr = map.get(curr.out);
                    e = curr.out;
                    dia = Math.min(dia,curr.dia);
                }

                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(e);
                arr.add(dia);
                ans.add(arr);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       // System.out.println(solve());
    }
}