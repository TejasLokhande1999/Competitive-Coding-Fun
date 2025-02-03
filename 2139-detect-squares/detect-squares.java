class DetectSquares {

    private Map<List<Integer>, Integer> ptsCount;
    private List<List<Integer>> pts;

    public DetectSquares() {
                ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
                List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
        pts.add(p);

    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for (List<Integer> pt : pts) {
            int x = pt.get(0), y = pt.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            res += ptsCount.getOrDefault(Arrays.asList(x, py), 0) * 
                   ptsCount.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */