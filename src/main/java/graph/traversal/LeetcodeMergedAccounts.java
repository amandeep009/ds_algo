package graph.traversal;

import java.util.*;

public class LeetcodeMergedAccounts {
    static HashSet<String> visited = new HashSet<>();
    static Map<String, List<String>> adjacent = new HashMap<String, List<String>>();


    public static void main(String[] args) {
        ArrayList<ArrayList <String>> input = new ArrayList<ArrayList<String>>();
        input.add(new ArrayList<>(Arrays.asList("john","A1","A2")));
        input.add(new ArrayList<>(Arrays.asList("john","A2","A3")));
        input.add(new ArrayList<>(Arrays.asList("john","A4","A5","A1")));
        input.add(new ArrayList<>(Arrays.asList("Ejohn","E1","E2")));
        List<List<String>> lists = accountsMerge(input);
        for (int i = 0; i <lists.size() ; i++) {
            System.out.println(lists.get(i).toString());
        }
    }

    private static void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);

        if (!adjacent.containsKey(email)) {
            return;
        }

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }

    public static List<List<String>> accountsMerge(ArrayList<ArrayList<String>> accountList) {
        int accountListSize = accountList.size();

        for (List<String> account : accountList) {
            int accountSize = account.size();

            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);

                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);

                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }

        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }
}
