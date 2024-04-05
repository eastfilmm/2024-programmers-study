class Solution {
    int SIZE = 11; // 과녁 크기
    int diff = 0; // 라이언과 어피치의 점수 차이
    
    int[] answer = { -1 }; // 정답
    int[] apeach; // 어피치의 기록
    
    boolean[] visited;
    
    // 라이언이 이길 과녁 점수를 선택한다.
    public void combination(int arrow, int r, int start, int depth) {
        if (depth >= r) {
            int my = 0; // 라이언의 점수
            int enemy = 0; // 어피치의 점수
            int[] rion = new int[SIZE]; // 라이언의 기록
            
            // 라이언이 화살을 쏜다.
            // 라이언이 이길 과녁인 경우 어피치보다 한 발만 많이 쏜다.
            // 어피치가 이길 과녁인 경우 라이언은 쏘지 않는다.
            // 둘 다 아닌 경우 라이언은 쏘지 않는다.
            for (int i = 0; i < SIZE; i++) {
                if (visited[i]) { // 라이언이 이길 과녁인 경우
                    my += 10 - i;
                    if (arrow < apeach[i] + 1) { // 라이언이 쏠 화살이 부족한 경우
                        return ;
                    }
                    arrow -= apeach[i] + 1;
                    rion[i] = apeach[i] + 1;
                } else if (apeach[i] > 0) { // 어피치가 이길 과녁인 경우
                    enemy += 10 - i;
                }
            }
            
            // 나머지 화살은 0점에 쏜다.
            if (arrow > 0) { 
                rion[SIZE - 1] += arrow;
            }
            
            if (my > enemy && my - enemy >= diff) {
                diff = my - enemy;
                answer = rion;
            }
            
            return ;
        }
        
        for (int i = start; i < SIZE; i++) {
            visited[i] = true;
            combination(arrow, r, i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        for (int i = 1; i < SIZE; i++) {
            visited = new boolean[SIZE]; // 라이언이 이길 과녁 점수
            combination(n, i, 0, 0);
        }
        return answer;
    }
}