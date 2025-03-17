import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        int max = array[array.length - 1];
        int[] index = new int[max + 1];
        int maxCnt = 0;
        int answer = 0;
        
        for(int i = 0; i < array.length; i++) {
            index[array[i]] ++;
        }       
        
        for(int j = 0; j < index.length; j++) {
            if(maxCnt < index[j]) {
                maxCnt = index[j];
                answer = j;
            } else if(maxCnt == index[j]) {
                answer = -1;
            }
        }
        
        return answer;
    }
    
    public int solution2(int[] array) {
        int maxCnt = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int number : array) {
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCnt) {
                maxCnt = count;
                answer = number;
            } else if (count == maxCnt) {
                answer = -1;
            }
            
            map.put(number, count);
        }
        
        return answer;
    }
}