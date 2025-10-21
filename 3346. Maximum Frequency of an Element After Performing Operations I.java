class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
       int max = 0, min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] freq = new int[max + 1];
        int[] prefix = new int[max + 1];
        for (int i : nums) {
            freq[i]++;
        }
        for (int i = min; i <= max; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        int ans = 0;
        for (int i = min; i <= max; i++) {
            int low = 0;
            if (i - k - 1 > 0) {
                low = prefix[i - k - 1];
            }
            int high = 0;
            if (i + k <= max) {
                high = prefix[i + k];
            } else {
                high = prefix[max];
            }
            int toChange = high - low - freq[i];
            ans = Math.max(ans, freq[i] + (toChange >= numOperations ? numOperations : toChange));
        }
        return ans;
    }
}
class Solution_v1 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int ans = 1;
        int adjustable = 0;
        Map<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> line = new TreeMap<>();
        TreeSet<Integer> candidates = new TreeSet<>();

        for (final int num : nums) {
            count.merge(num, 1, Integer::sum);
            line.merge(num - k, 1, Integer::sum);
            line.merge(num + k + 1, -1, Integer::sum);
            candidates.add(num);
            candidates.add(num - k);
            candidates.add(num + k + 1);
        }

        for (final int num : candidates) {
            adjustable += line.getOrDefault(num, 0);
            final int countNum = count.getOrDefault(num, 0);
            final int adjusted = adjustable - countNum;
            ans = Math.max(ans, countNum + Math.min(numOperations, adjusted));
        }

        return ans;
    }
}