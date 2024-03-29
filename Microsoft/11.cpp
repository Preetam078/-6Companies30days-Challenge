#define ll long long
const int mod = 1e9+7;
class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        //First create an adjacency list
        vector<vector<pair<int,int>>> adj(n);
        for(int i = 0; i < roads.size(); i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj[u].push_back({v,w});
            adj[v].push_back({u,w});
        }
        
        vector<ll> time(n,LONG_MAX);
        time[0] = 0;
        
        vector<ll> way(n,0);
        way[0] = 1;
        
        priority_queue <pair<ll,int>, vector<pair<ll,int>>, greater<pair<ll,int>> > pq;//{time,node}
        pq.push({0,0});
        while(!pq.empty()){
            ll currTime = pq.top().first;
            int node = pq.top().second;
            pq.pop();
            for(auto it: adj[node]){
                int adjNode = it.first;
                ll timeTotravel = it.second;
            
                if(currTime + timeTotravel < time[adjNode]){
                    time[adjNode] = currTime + timeTotravel;
                    pq.push({time[adjNode],adjNode});
                    way[adjNode] = way[node]%mod;
                }
               
                else if(currTime + timeTotravel == time[adjNode])
                    way[adjNode] = (way[adjNode]+way[node])%mod;
            }
        }
        return way[n-1];
    }
};