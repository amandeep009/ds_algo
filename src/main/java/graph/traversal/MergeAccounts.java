package graph.traversal;

import java.util.*;

public class MergeAccounts {

    public static void main(String[] args) {
        ArrayList<ArrayList <String>> input = new ArrayList<ArrayList<String>>();
        input.add(new ArrayList<>(Arrays.asList("john","A1","A2","B1")));
        input.add(new ArrayList<>(Arrays.asList("john","A4","A2","A3")));
        input.add(new ArrayList<>(Arrays.asList("john","A4","A5","A1")));
        input.add(new ArrayList<>(Arrays.asList("Ejohn","E1","E2")));
        ArrayList<ArrayList> arrayLists = mergeAccounts(input);
        for (int i = 0; i <arrayLists.size() ; i++) {
            System.out.println(arrayLists.get(i).toString());
        }
    }

    /*
    Create adjacency list with first email bidirectional...
       {
       A1=[A2, B1, A4],
       A2=[A1, A4],
       A3=[A4],
       A4=[A2, A3, A5, A1],
       A5=[A4],
       E1=[E2],
       E2=[E1],
       B1=[A1]
       }
       Iterate each node and run DFS, whenever DFS is non-empty then it found new account.
       Important point is send same visited HashSet.
     */

    static ArrayList<ArrayList> mergeAccounts(ArrayList<ArrayList <String>> input){
        ArrayList<ArrayList> mergedAccounts = new ArrayList<>();
        HashMap<String, ArrayList<String>> adjacency = new HashMap ();
        for(int i=0;i<input.size();i++){
            String firstEmail = input.get(i).get(1);
            for (int j = 2; j < input.get(i).size() ; j++) {
                //Important both way edges...
                String accountEmail = input.get(i).get(j);
                if(adjacency.containsKey(firstEmail)){
                    adjacency.get(firstEmail).add(accountEmail);
                } else{
                    adjacency.put(firstEmail,new ArrayList<>(Arrays.asList(accountEmail)));
                }
                if(adjacency.containsKey(accountEmail)){
                    adjacency.get(accountEmail).add(firstEmail);
                } else{
                    adjacency.put(accountEmail,new ArrayList<>(Arrays.asList(firstEmail)));
                }
            }
        }
        Iterator<String> iterator = adjacency.keySet().iterator();
        HashSet<String> visited = new HashSet<>();
        while (iterator.hasNext()){
            String accountFirstEmail = iterator.next();
            if(!visited.contains(accountFirstEmail)) {
                ArrayList<String> output = new ArrayList<String>();
                dfs(adjacency, accountFirstEmail, visited, output);
                if (!output.isEmpty()){
                    Collections.sort(output);
                    mergedAccounts.add(output);
                }
            }
        }

        return mergedAccounts;

    }

    private static void dfs(HashMap<String, ArrayList<String>> adjacency, String root, HashSet<String> visited,ArrayList<String> output) {
        if(visited.contains(root)){
            return;
        }
        visited.add(root);
        output.add(root);
        if(adjacency.containsKey(root)){
            for (int i = 0; i <adjacency.get(root).size() ; i++) {
                dfs(adjacency,adjacency.get(root).get(i),visited,output);
            }
        }
    }
}