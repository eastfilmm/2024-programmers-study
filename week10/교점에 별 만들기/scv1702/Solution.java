import java.util.*;

class Pair {
    long x;
    long y;
    
    public Pair(double x, double y) {
        this.x = (long) x;
        this.y = (long) y;
    }
    
    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }
}

class Solution {
    public boolean isInteger(double num) {
        return num % 1 == 0.0;
    }
    
    public String[] solution(int[][] line) {
        Set<Pair> pairs = new HashSet<>();
        
        for (int i = 0; i < line.length; i++) {
            double A = line[i][0];
            double B = line[i][1];
            double E = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                double C = line[j][0];
                double D = line[j][1];
                double F = line[j][2];
                if (A * D != B * C) {
                    double x = (B * F - E * D) / (A * D - B * C);
                    double y = (E * C - A * F) / (A * D - B * C);
                    if (isInteger(x) && isInteger(y)) {
                        pairs.add(new Pair(x, y));
                    }
                }
            }
        }

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        for (Pair pair: pairs) {
            maxX = Math.max(maxX, pair.x);
            maxY = Math.max(maxY, pair.y);
            minX = Math.min(minX, pair.x);
            minY = Math.min(minY, pair.y);
        }
        
        int row = (int) Math.abs(maxY - minY);
        int col = (int) Math.abs(maxX - minX);
        
        char[][] answer = new char[row + 1][col + 1];
        Arrays.stream(answer)
            .forEach(ans -> Arrays.fill(ans, '.'));
        
        // (minX, maxY)와 (pair.x, pair.y)의 거리
        for (Pair pair: pairs) {
            int y = (int) Math.abs(maxY - pair.y);
            int x = (int) Math.abs(minX - pair.x);
            answer[y][x] = '*';
        }
        
        return Arrays.stream(answer)
            .map(String::new)
            .toArray(String[]::new);
    }
}