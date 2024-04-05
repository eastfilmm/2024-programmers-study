import java.util.*;

class Solution {
    class Node {
        int truck;
        int time;
        
        Node(int truck, int time) {
            this.truck = truck;
            this.time = time;
        }
        
        @Override
        public String toString() {
            return Integer.toString(truck);
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int bridgeWeight = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Node> bridge = new LinkedList<>();
        
        for (int truck: truck_weights) {
            queue.offer(truck);
        }
        
        int firstTruck = queue.poll();
        bridge.offer(new Node(firstTruck, time));
        bridgeWeight += firstTruck;
        
        while (!bridge.isEmpty()) {
            time += 1;
            if (time - bridge.peek().time == bridge_length) {
                Node node = bridge.poll();
                bridgeWeight -= node.truck;
            }
            if (!queue.isEmpty()) {
                int truck = queue.peek();
                if (bridge.size() < bridge_length && bridgeWeight + truck <= weight) {
                    bridge.offer(new Node(truck, time));
                    bridgeWeight += truck;
                    queue.poll();
                }
            }
        }
        
        return time;
    }
}