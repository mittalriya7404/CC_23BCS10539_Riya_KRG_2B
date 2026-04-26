import java.util.*;

class CountSmaller {
    int[] tree;
    int size;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : sorted) {
            if (!map.containsKey(num))
                map.put(num, rank++);
        }

        size = rank;
        tree = new int[4 * size];

        Integer[] result = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int r = map.get(nums[i]);

            result[i] = query(1, 1, size, 1, r - 1);

            update(1, 1, size, r);
        }

        return Arrays.asList(result);
    }

    private void update(int node, int start, int end, int idx) {
        if (start == end) {
            tree[node]++;
            return;
        }

        int mid = (start + end) / 2;
        if (idx <= mid)
            update(2 * node, start, mid, idx);
        else
            update(2 * node + 1, mid + 1, end, idx);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        return query(2 * node, start, mid, l, r)
             + query(2 * node + 1, mid + 1, end, l, r);
    }
}

public class CountSmallerTest {
    public static void main(String[] args) {
        CountSmaller cs = new CountSmaller();

        int[] nums = {5, 2, 6, 1};
        System.out.println(cs.countSmaller(nums));

        int[] nums2 = {-1};
        System.out.println(cs.countSmaller(nums2));

        int[] nums3 = {-1, -1};
        System.out.println(cs.countSmaller(nums3));
    }
}