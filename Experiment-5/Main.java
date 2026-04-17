import java.util.*;

class Trie {
    boolean isEnd;
    Trie[] next;

    Trie() {
        isEnd = false;
        next = new Trie[3];
    }
}

public class Main {
    static Trie root = new Trie();
    static String s;

    // Insert function
    static void insert(String str) {
        Trie cursor = root;

        for (int i = 0; i < str.length(); i++) {
            int number = str.charAt(i) - 'a';

            if (cursor.next[number] == null) {
                cursor.next[number] = new Trie();
            }

            cursor = cursor.next[number];
        }

        cursor.isEnd = true;
    }

    // Find function (checks if exactly 1 char differs)
    static int find(Trie tmp, int cur, int diff) {
        if (diff > 1 || cur > s.length())
            return 0;

        if (cur == s.length())
            return (diff == 1 && tmp.isEnd) ? 1 : 0;

        int number = s.charAt(cur) - 'a';
        int res = 0;

        for (int i = 0; i < 3; i++) {
            if (tmp.next[i] != null) {
                res = Math.max(res,
                        find(tmp.next[i], cur + 1, diff + (number != i ? 1 : 0)));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String in = sc.next();
            insert(in);
        }

        for (int i = 0; i < m; i++) {
            s = sc.next();

            if (find(root, 0, 0) == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}