package recursion;
import java.util.*;

/*
<---------------------------------------------------------------------------------------------------------------------->
Given - Level and Position(pos) of a person in above ancestor tree.
NTD   - Find profession of the person.
<---------------------------------------------------------------------------------------------------------------------->
Scenario  -
      Consider a special family of Engineers and Doctors with following rules :
      1. Everybody has two children.
      2. First child of an Engineer is an Engineer and second child is a Doctor.
      3. First child of a Doctor is a Doctor and second child is a Engineer.
      4. All generations of Doctors and Engineers start with Engineer.
<---------------------------------------------------------------------------------------------------------------------->
Recursive Tree -
                                        E               <- level 1
                                      /   \
                                     E      D           <- level 2
                                    /  \   /  \
                                   E    D  D   E        <- level 3
                                  /\    /\ /\  /\
                                  E D  D E E D D E      <- level 4
<---------------------------------------------------------------------------------------------------------------------->
Example -
      input -> level = 4, pos = 2.
      output -> Doctor.
      explanation -> Already, it is shown in given tree in the question.
<---------------------------------------------------------------------------------------------------------------------->
* */

public class Finding_Profession {
    public static char profession(int level, int pos){
        if(pos == 1)
            return 'e';

        char par = profession(level-1, (pos+1)/2);

        if(pos % 2 != 0)
            return par;

        if(par == 'e')
            return 'd';

        else
            return 'e';
    }

    public static void main(String[] args) {

    }
}

/*
<---------------------------------------------------------------------------------------------------------------------->
| Time Complexity ->  | O(n)
| Auxiliary Space ->  | O(n)
<---------------------------------------------------------------------------------------------------------------------->
 */