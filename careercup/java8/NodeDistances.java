import java.util.*;

public class NodeDistances {
    static final class Node implements Comparable<Node> {
        public int index;
        public long distance;
        @Override
        public int compareTo(Node m)
        {
            if (m.distance > this.distance)
                return 1;
            if (m.distance < this.distance)
                return -1;
            return 0;
        }
        public Node(int index, long distance)
        {
            this.index = index;
            this.distance = distance;
        }
    }

    public static List<long[]> closestToOrigin(long[][] points, int k) {
        List<long[]> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }

        Queue<Node> distances = new PriorityQueue<>();
        for (int i=0; i<points.length; i++) {
            long distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (distances.size() == k && distances.peek().distance > distance) {
                distances.poll();
                distances.add(new Node(i, distance));
            } else if (distances.size() < k) {
                distances.add(new Node(i, distance));
            }
        }
        while (!distances.isEmpty()) {
            Node n = distances.poll();
            result.add(points[n.index]);
        }
        return result;
    }

    public static void main(String args[]){
        long[][] points = {{1,1}, {1,2}, {1,5}, {1,-3}, {-1,2}};
        List<long[]> result = closestToOrigin(points, 3);
        result.forEach(i -> {
            System.out.println(Arrays.toString(i));
        });
    }
}

