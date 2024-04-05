import java.util.*;

class Solution {
    public static int[] rates = {
        10, 20, 30, 40
    };
    
    int[] result;
    int[] answer = new int[2]; 
    
    public void permutation(int[][] users, int[] emoticons, int r, int depth) {
        if (depth >= r) {
            int subscribers = 0;
            int sales = 0;
            
            for (int[] user: users) {
                int price = 0;
                int rateThd = user[0];
                int priceThd = user[1];
                for (int i = 0; i < emoticons.length; i++) {
                    if (result[i] >= rateThd) {
                        price += (int) (emoticons[i] * (100 - result[i]) / 100f);
                    }
                }
                if (price >= priceThd) {
                    subscribers += 1;
                } else {
                    sales += price;
                }
            }
            
            if (subscribers > answer[0]) {
                answer[0] = subscribers;
                answer[1] = sales;
            } else if (subscribers == answer[0]) {
                answer[1] = Math.max(answer[1], sales);
            }
            
            return ;
        }
        
        for (int i = 0; i < rates.length; i++) {
            result[depth] = rates[i];
            permutation(users, emoticons, r, depth + 1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int n = users.length;
        int m = emoticons.length;
        result = new int[m];
        
        permutation(users, emoticons, m, 0);
    
        return answer;
    }
}