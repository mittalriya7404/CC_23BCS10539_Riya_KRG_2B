class Pair{
    int first;
    int second;
    public Pair( int first, int second){
        this.first=first;
        this.second= second;
    }
}
class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first, int second, int third){
        this.first= first;
        this.second= second;
        this.third=third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        Queue<Tuple> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<flights.length;i++){
           adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dist=new int[n];
        q.add(new Tuple(0,src,0));
        for(int i=0;i<dist.length;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        while(!q.isEmpty()){
            int stops=q.peek().first;
            int node= q.peek().second;
            int dis=q.peek().third;
            q.remove();
            if(stops>k)continue;

            for(Pair it: adj.get(node)){
                int adjNode=it.first;
                int newdis=it.second;
                if(dis+newdis<dist[adjNode] && stops<=k){
                    dist[adjNode]=dis+newdis;
                    q.add(new Tuple(stops+1, adjNode, dis+newdis));
                }
            }
        
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==(int)1e9){
                dist[i]=-1;
            }
        }
        return dist[dst];

        
    }
}