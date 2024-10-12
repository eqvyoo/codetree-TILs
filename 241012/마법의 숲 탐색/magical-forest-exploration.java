import java.io.*;
import java.util.*;

public class Main{
	private static int MAXN = 70;
	private static int R, C, K;
	private static int answer = 0;
	private static int[][] forest = new int[MAXN + 3][MAXN];
	private static int[] dy = {-1,0,1,0};
	private static int[] dx = {0,1,0,-1};
	private static boolean[][] isExit = new boolean[MAXN + 3][MAXN];
	
	//1. (x,y)가 숲 안에 들었는 지 확인하는 함수
	
	private static boolean inRange(int y, int x) {
		return y >= 3 && y < R + 3 && x >= 0 && x < C;
	}
	
	// 2. 초기화 함수 - 골렘이 모두 숲을 빠져나감, isExit, forest 모두 초기화
	private static void reset() {
		for (int i = 0; i < R+3; i++) {
			for (int j = 0; j < C; j++) {
				forest[i][j] = 0;
				isExit[i][j] = false;
			}
		}
	}
	// 3. 골렘 자리랑 양 옆 위가 비었는지 확인하는 함수
	
	private static boolean canGo(int y, int x) {
		if(y -1 < 0 || y + 1 >= R+3 || x -1 < 0 || x + 1 >= C)
			return false;
		return forest[y-1][x-1] == 0 && forest[y-1][x] == 0 && forest[y-1][x+1] == 0
				&& forest[y][x-1] == 0 && forest[y][x] == 0 && forest[y][x+1] == 0
				&& forest[y+1][x] == 0;
	}
	
	// 4. bfs로 모든 경로를 탐색하는 함수
	
	private static int bfs(int y, int x) {
		int result = y;
		Queue<int[]> q = new LinkedList<>();
		boolean [][] visited = new boolean[MAXN + 3][MAXN];
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = curr[0] + dy[k];
				int nx = curr[1] + dx[k];
				
				if (inRange(ny,nx) && !visited[ny][nx] && (forest[ny][nx] == forest[curr[0]][curr[1]] || (forest[ny][nx] != 0 && isExit[curr[0]][curr[1]]))) {
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = true;
					result = Math.max(result, ny);
				}
			}
		}
		
		return result;
	}
	
	// 5. 골렘이 내려가는 함수 
	
	private static void down(int y, int x, int d, int id) {
		if (canGo(y+1, x))
			down (y+1, x, d, id);
		else if (canGo (y+1, x -1))
			down (y+1, x-1, (d + 3) % 4, id);
		else if (canGo (y+1, x+1))
			down (y+1, x+1, (d + 1) % 4, id);
		else {
			if (!inRange(y-1, x-1) || !inRange(y+1, x+1))
				reset();
			else {
				forest[y][x] = id;
				for (int k = 0; k < 4; k++) {
					forest[y+dy[k]][x + dx[k]] = id;
				}
				isExit[y + dy[d]][x + dx[d]] = true;
				
				answer += bfs(y,x) - 3 + 1;
			}
		}
		
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		R = scanner.nextInt();
		C = scanner.nextInt();
		K = scanner.nextInt();
		
		for (int i = 1; i <= K; i++) {
			int x = scanner.nextInt() -1;
			int d = scanner.nextInt();
			down(0,x,d,i);
			}
		System.out.println(answer);
	}
	
}