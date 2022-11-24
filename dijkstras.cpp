#include<bits/stdc++.h>
using namespace std;
void bfs(vector<pair<int,int>>adj[],int n){
	priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
	vector<int>dis(n+1,INT_MAX);
	pq.push({0,1});
	dis[1]=0;
	while(!pq.empty()){
		int p=pq.top().second;
		pq.pop();
		for(auto it:adj[p]){
			if(dis[p]+it.second<=dis[it.first]){
				dis[it.first]=dis[p]+it.second;
				pq.push({dis[it.first],it.first});
			}
		}
	}
	for(auto it:dis)
		cout<<it<<" ";
}
int main(){
	int n,m; cin>>n>>m;
	vector<pair<int,int>>adj[n+1];
	int u,v,w;
	for(int i=0;i<m;i++){
		cin>>u>>v>>w;
		adj[u].push_back({v,w});
		adj[v].push_back({u,w});
	}
	bfs(adj,n);
}
