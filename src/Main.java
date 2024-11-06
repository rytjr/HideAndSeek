import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] isVisited = new int[100001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        System.out.print(bfs(N));
    }

    public static int bfs(int N) {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        Arrays.fill(isVisited, -1);
        isVisited[N] = 0;

        while(!que.isEmpty()) {
            int start = que.poll();

            if(start == M) {
                return isVisited[start];
            }

            int[] num = {start -1, start + 1, start * 2};
            for(int i : num) {
                if(i >= 0 && i < 100001 && isVisited[i] == -1) {
                    que.add(i);
                    isVisited[i] = isVisited[start] + 1;
                }
            }
        }
        return -1;
    }

}
