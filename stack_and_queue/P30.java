package stack_and_queue;

// Find the first circular tour that visits all Petrol Pumps

public class P30 {

    public int tour(int[] petrol, int[] distance) {
        int start = 0;
        int end = petrol.length -1 ;
        int i = start;

        int currPetrol = 0; int count = 0;

        while(i % (petrol.length) != end) {
            if(i == 0)
                count++;

            currPetrol += petrol[i];
            if(currPetrol < distance[i]) {
                if(count >= 2) return -1;
                start = (i + 1) % (petrol.length);

                if(start == 0) return  -1;
                currPetrol = 0;
                end = i % petrol.length;
            }

            else {
                currPetrol -= distance[i];
            }
            i++;
            i %= petrol.length;
        }

        currPetrol += petrol[end];
        if(currPetrol < distance[end])
            return -1;

        return start;
    }

    public static void main(String[] args) {

    }
}