class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;

}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }

        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode root) {
        if (i == word.length()) return root.isEndOfWord;
        
        char c = word.charAt(i);

        if (c == '.') {
            for (TrieNode child : root.children.values()) {
                if (child != null && dfs(word, i+1, child)) return true;
            }
            return false;
        }

        TrieNode next = root.children.get(c);
        if (next == null) return false;
        return dfs(word, i+1, next);

        




    }
}
