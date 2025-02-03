class DetectSquares {

    Map<List<Integer>, Integer> map;
    List<List<Integer>> list;
    public DetectSquares() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(point[0]);
        l1.add(point[1]);
        list.add(l1);
        map.put(l1, map.getOrDefault(l1,0)+1);
    }

    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res=0;
        for(List<Integer> l : list){
            int x = l.get(0);
            int y = l.get(1);
            if(Math.abs(px-x) == Math.abs(py-y) && x!=px && y!=py){
                List<Integer> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                l1.add(x);
                l1.add(py);
                l2.add(px);
                l2.add(y);
                res+=map.getOrDefault(l1,0)*map.getOrDefault(l2,0);
            }
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