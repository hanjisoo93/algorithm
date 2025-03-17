import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {       
        int[] array = new int[n/2 + n%2];
        int index = 0;
        
        for(int i = 1; i <= n; i += 2) {
            array[index++] = i;
        }
            
        return array;
    }
    
    public int[] solution2 (int n) {
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
}