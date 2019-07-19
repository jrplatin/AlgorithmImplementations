#include<iostream>
#include<vector>
#include <typeinfo>
#include<string>
using namespace std;

class Graph{
    public:
        Graph(int v);
    vector<vector<int>*> adj;
    void DFSUtil(vector<bool> visited, int v);
    void addEdge(int v, int b);
    vector<int>* getEdge(int v);
    
    
};

Graph::Graph(int v) : adj(v){
 
}

void Graph::addEdge(int v, int b){
    vector<int> currentList;
    currentList.push_back(b);
    adj[v] = &currentList;
    
}

vector<int>* Graph::getEdge(int v){
    cout << typeid(*adj[v]).name();
    return adj[v];
}

int main(){
    Graph g(5);
    g.addEdge(4,3);
    g.getEdge(4)[0][0];
}