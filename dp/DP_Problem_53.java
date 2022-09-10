package dp;

/*
 * <------------------------------------------------------------------------------------------------------------------->
 * Problem Title :-  Mobile Numeric Keypad Problem.
 *  <------------------------------------------------------------------------------------------------------------------>
 * Given :- Given the mobile numeric keypad. You can only press buttons that are up, left, right,
 *          or down to the current button or the current button itself (like 00,11, etc.).
 *          You are not allowed to press the bottom row corner buttons (i.e. * and # ).
 *  <------------------------------------------------------------------------------------------------------------------>
 * Need To Do :- Given a number N, the task is to find out the number of possible numbers of the given length.
 * <------------------------------------------------------------------------------------------------------------------->
 * */

// Problem Title =>
public class DP_Problem_53 {

    static int[] row = {0, 0,-1, 0, 1};
    static int[] col = {0, 0,-1, 0, 1};

    static int getCountUtil(char[][] keypad, int i, int j, int n){
        if(keypad == null || n <= 0)
            return 0;
        if(n == 1)  return 1;
        int move, ro, co, totalCount = 0;
        for(move = 0; move < 5; move++){
            ro = i + row[move];
            co = j + col[move];
            if(ro >= 0 && ro <= 3 && co >= 0 && co <= 2 && keypad[ro][co] != '*' && keypad[ro][co] != '#')
                totalCount += getCountUtil(keypad, ro, co, n-1);
        }
        return totalCount;
    }

    static int getCount(char[][] keypad, int n){
        if(keypad == null || n <= 0)    return 0;
        if(n == 1)  return 10;
        int i, j, totalCount = 0;
        for(i = 0; i < 4; i++){
            for(j = 0; j < 3; j++){
                if(keypad[i][j] != '*' && keypad[i][j] != '#'){
                    totalCount += getCountUtil(keypad, i, j, n);
                }
            }
        }
        return totalCount;
    }
    public static void main(String[] args) {
        char[][] keypad = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}
        };
        System.out.printf("Count for numbers of"+ " length %d: %d", 1, getCount(keypad, 1));
        System.out.printf("\nCount for numbers of" + "length %d: %d", 2, getCount(keypad, 2));
        System.out.printf("\nCount for numbers of" + "length %d: %d", 3, getCount(keypad, 3));
        System.out.printf("\nCount for numbers of" + "length %d: %d", 4, getCount(keypad, 4));
        System.out.printf("\nCount for numbers of" + "length %d: %d", 5, getCount(keypad, 5));
    }
}