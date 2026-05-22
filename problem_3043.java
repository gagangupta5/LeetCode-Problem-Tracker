class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        Trie trie = new Trie();
        for(int i = 0 ;i <arr2.length ;i++){
            trie.insert(arr2[i]);
        }

        int max = 0;
        for(int i = 0 ;i < arr1.length ;i++){
            int curr = arr1[i];
            int res = trie.isPrefix(curr);
            max = Math.max(res , max);
        }

        return max;

    }
}
class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    TrieNode()
    {
        children = new TrieNode[10];
        isLeaf = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a key into the Trie
    public void insert(int key) {
        TrieNode curr = root;
        int divisor = (int)Math.pow(10 , (int)Math.log10(key));

        while(divisor > 0){
            int digit = key / divisor;

            if(curr.children[digit] == null){
                curr.children[digit] = new TrieNode();
            }
            curr = curr.children[digit];

            key = key % divisor;
            divisor = divisor /10;
        }

        curr.isLeaf = true;
    }

  

    // Method to check if a prefix exists in the Trie
    public int isPrefix(int prefix)
    {
        TrieNode curr = root;
        int len = 0;

        int divisor = (int)Math.pow(10 , (int)Math.log10(prefix));
        while(divisor > 0){
            int digit = prefix / divisor;

            if(curr.children[digit] == null){
               return len;
            }

            len++;
            curr = curr.children[digit];

            prefix = prefix % divisor;
            divisor = divisor /10;
        }


        return len;
    }

}abx