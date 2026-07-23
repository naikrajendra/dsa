package com.rpk.dsa;

/**
 * A PrefixTrie (also known as Trie) is a tree-like data structure that stores a dynamic set of strings, 
 * where each node represents a single character of a string. It provides efficient methods for 
 * inserting words, searching for exact words, checking for prefixes, and deleting words.
 *  The `PrefixTrie` class includes the following methods:
 *  - `insert(String word)`: Inserts a word into the trie.
 *  - `search(String word)`: Searches for an exact word in the trie and returns true if found, false otherwise.
 *  - `startsWith(String prefix)`: Checks if there is any word in the trie that starts with the given prefix.
 *  - `delete(String word)`: Deletes a word from the trie if it exists.
 * This data structure is particularly useful for applications involving prefix-based searches, 
 * such as autocomplete and spell-checking.
 * 
 * PrefixTrie
 */

public class PrefixTrie {

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // Assuming only lowercase letters a-z
            isEndOfWord = false;
        }
    }

    private final TrieNode root;
    public PrefixTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int depth) {
        if (current == null) {
            return false;
        }

        if (depth == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Word not found
            }
            current.isEndOfWord = false; // Unmark the end of word
            return isEmpty(current); // If no children, this node can be deleted
        }

        int index = word.charAt(depth) - 'a';
        if (delete(current.children[index], word, depth + 1)) {
            current.children[index] = null; // Delete the child node
            return !current.isEndOfWord && isEmpty(current); // Check if current node can be deleted
        }
        return false;
    }
    
    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // returns false
    }


}
