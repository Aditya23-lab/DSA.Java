import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int[] result = new int[2];
        int idx = 0;

        for (int x : nums) {
            if (!seen.add(x)) { // add() returns false if already present
                result[idx++] = x;
                if (idx == 2) break;
            }
        }
        return result;
    }
}
