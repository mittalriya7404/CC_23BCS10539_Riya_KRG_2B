import java.util.*;

public class Main {

    static int[] in = new int[26];
    static List<Integer>[] g = new ArrayList[26];
    static Queue<Integer> q = new LinkedList<>();
    static String[] s = new String[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Initialize adjacency list
        for (int i = 0; i < 26; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        for (int i = 0; i + 1 < n; i++) {
            int mn = Math.min(s[i].length(), s[i + 1].length());

            int x = -1, y = -1;

            for (int j = 0; j < mn; j++) {
                if (s[i].charAt(j) != s[i + 1].charAt(j)) {
                    x = s[i].charAt(j);
                    y = s[i + 1].charAt(j);
                    break;
                }
            }

            if (x == -1) {
                if (s[i].length() > s[i + 1].length()) {
                    System.out.println("Impossible");
                    return;
                }
                continue;
            }

            x -= 'a';
            y -= 'a';

            g[x].add(y);
            in[y]++;
        }

        // Push all nodes with in-degree 0
        for (int i = 0; i < 26; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()) {
            int fr = q.poll();
            res.append((char) (fr + 'a'));

            for (int neighbor : g[fr]) {
                in[neighbor]--;
                if (in[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (res.length() == 26) {
            System.out.println(res.toString());
        } else {
            System.out.println("Impossible");
        }

        sc.close();
    }
}