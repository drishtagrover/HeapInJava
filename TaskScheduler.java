class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char t : tasks) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : countMap.values()) {
            maxHeap.add(freq);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            for (int i = 0; i < cycle && !maxHeap.isEmpty(); i++) {
                temp.add(maxHeap.poll());
            }

            for (int remaining : temp) {
                if (remaining - 1 > 0) {
                    maxHeap.add(remaining - 1);
                }
            }

            time += maxHeap.isEmpty() ? temp.size() : cycle;
        }

        return time;
    }
}
