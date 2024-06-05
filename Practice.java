import java.util.*;

class Practice {
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();

    arr.add(4);
    arr.add(5);
    arr.add(8);
    arr.add(9);
    arr.add(3);
    arr.add(7);

    int target = 4;

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) == target) {
        arr.remove(arr.get(i));
      }
    }

    int first = 0;
    int end = arr.size() - 1;
    int mid = (first + end) / 2;

    while (mid < end) {
      if (arr.get(first) < arr.get(mid)) {
        first++;
      }

      if (arr.get(first) > arr.get(mid)) {
        int temp = arr.get(first);
        arr.add(first, arr.get(mid));
        arr.add(mid, temp);

        first++;
      }

      if (arr.get(mid) < arr.get(end)) {
        end--;
      }

      if (arr.get(mid) > arr.get(end)) {
        int temp = arr.get(mid);
        arr.add(mid, arr.get(end));
        arr.add(end, temp);

        end--;
      }
    }

    System.out.println("List" + arr);
    System.out.println("Sorted List" + arr);
  }
}