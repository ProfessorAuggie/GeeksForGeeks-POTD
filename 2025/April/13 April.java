//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int val;
    ArrayList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class GFG {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        Integer nextInt() { return Integer.parseInt(next()); }
    }

    static ArrayList<Node> bfs(Node src) {
        ArrayList<Node> ans = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(src);
        visited.add(src);

        while (!q.isEmpty()) {
            Node u = q.poll();
            ans.add(u);
            ArrayList<Node> v = u.neighbors;
            for (Node x : v) {
                if (!visited.contains(x)) {
                    visited.add(x);
                    q.add(x);
                }
            }
        }

        return ans;
    }

    static boolean checkedClone(Node prev, Node new1) {
        ArrayList<Node> prevAns = bfs(prev);
        ArrayList<Node> newAns = bfs(new1);
        for (int i = 0; i < prevAns.size(); i++) {
            if (prevAns.get(i) == newAns.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            Node v[] = new Node[n];
            for (int i = 0; i < n; i++) v[i] = new Node(i);
            Solution ob = new Solution();
            for (int i = 0; i < n; i++) {
                ArrayList<Node> li = new ArrayList<>();
                String arr[] = sc.nextLine().split(" ");
                for (String s : arr) {
                    li.add(v[Integer.parseInt(s)]);
                }
                v[i].neighbors = li;
            }
            ArrayList<Node> prev = bfs(v[0]);
            Node ans = ob.cloneGraph(v[0]);
            ArrayList<Node> now = bfs(ans);
            out.println(checkedClone(v[0], ans) ? "true" : "false");

            out.println("~");
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> A) {
        HashMap<String, String> p = new HashMap<>(), n = new HashMap<>();
        for (ArrayList<String> a : A) {
            String name = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                p.putIfAbsent(a.get(i), a.get(i));
                n.putIfAbsent(a.get(i), name);
                p.put(find(p, a.get(i)), find(p, a.get(1)));
            }
        }
        HashMap<String, TreeSet<String>> m = new HashMap<>();
        for (String mail : p.keySet()) m.computeIfAbsent(find(p, mail), k -> new TreeSet<>()).add(mail);
        ArrayList<ArrayList<String>> r = new ArrayList<>();
        for (String root : m.keySet()) {
            ArrayList<String> t = new ArrayList<>();
            t.add(n.get(root));
            t.addAll(m.get(root));
            r.add(t);
        }
        return r;
    }

    static String find(HashMap<String, String> p, String s) {
        if (!p.get(s).equals(s)) p.put(s, find(p, p.get(s)));
        return p.get(s);
    }
}
