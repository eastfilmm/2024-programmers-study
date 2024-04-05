import java.util.*;

class Solution {
    
    public int toSeconds(int h, int m, int s) {
        return h * 60 * 60 + m * 60 + s;
    }
    
    static double[] diff = {
        6f, 1f / 10f, 1f / 120f    
    };
    
    static double EPSILON = 0.0001f;
    static int PRECISION = 10000;
    
    // h1:m1:s1부터 h2:m2:s2까지 초침과 시침/분침이 겹치는 횟수
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 시침은 43200초마다, 분침은 3600초마다, 초침은 60초마다 시계를 한 바퀴 돈다.
        // 초침이 h1:m1:s1부터 h2:m2:s2까지 이동하면서 겹침 유무를 판단
        // 초침은 1초에 6도, 분침은 1초에 1/10도, 시침은 1초에 1/120도
        
        Set<Long> answer = new HashSet<>();
        
        double start = toSeconds(h1, m1, s1);
        double end = toSeconds(h2, m2, s2);
        
        for (double k = 0f; 360 * k / (diff[0] - diff[1]) <= end + EPSILON; k++) {
            double t = 360 * k / (diff[0] - diff[1]);
            if (t >= start) {
                answer.add((long) (t * PRECISION));   
            }
        }
        
        for (double k = 0f; 360 * k / (diff[0] - diff[2]) <= end + EPSILON; k++) {
            double t = 360 * k / (diff[0] - diff[2]);
            if (t >= start) {
                answer.add((long) (t * PRECISION));  
            }
        }
        
        return answer.size();
    }
}