public class Cycle {

    private boolean[] marked;
    private boolean isAcyclic;

    public  Cycle(EdgeWeightedGraph ewg) {
        /* 是否有图的判断方法
        1. 对所有的V，如果没有访问过，做DFS
        2. DFS中如果到了访问过的点，并且不是自环的话，则有环
         */
        isAcyclic = true;

        marked = new boolean[ewg.V()];
        for (int s = 0; s < ewg.V(); s++) {
            if (!marked[s])
                dfs(ewg,s,s);
        }

    }

    private void dfs(EdgeWeightedGraph ewg, int v, int u) {
        marked[v] = true;
        for (Edge e : ewg.adj(v)) {
            int w = e.either();
            if (w == v)
                w = e.other(w);
            if (!marked[w])
                dfs(ewg, w, v);
            else if(w != u)
                isAcyclic = false;
        }
    }

    public boolean isAcyclic() {
        return isAcyclic;
    }
}
