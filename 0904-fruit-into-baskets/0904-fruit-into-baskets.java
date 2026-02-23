class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, max = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int j = 0; j < fruits.length; j++) {
            m.put(fruits[j], m.getOrDefault(fruits[j], 0) + 1);

            while (m.size() > 2) {
                int left = fruits[i];
                m.put(left, m.get(left) - 1);
                if (m.get(left) == 0) m.remove(left);
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}