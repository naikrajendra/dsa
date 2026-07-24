package com.rpk.dsa;

/**
 * This class implements an AutoSuggestionTrie (also known as Trie) data structure that supports insertion, searching, prefix checking, deletion, and auto-completion of words. The `AutoSuggestionTrie` class includes the following methods:
 * - `insert(String word)`: Inserts a word into the trie.
 * - `search(String word)`: Searches for a word in the trie and returns `true` if the word exists, otherwise `false`.
 * - `startsWith(String prefix)`: Checks if there is any word in the trie that starts with the given prefix and returns `true` if such a word exists, otherwise `false`.
 * - `delete(String word)`: Deletes a word from the trie if it exists.
 * - `autoComplete(String prefix)`: Prints all words in the trie that start with the given prefix.
 * This data structure is particularly useful for implementing features like auto-suggestions in search engines, autocomplete in text editors, and spell checkers.
 * Example usage:
 * AutoSuggestionTrie trie = new AutoSuggestionTrie();
 * trie.insert("apple");
 * trie.insert("app");
 * System.out.println(trie.search("apple")); // true
 * System.out.println(trie.startsWith("ap")); // true
 * trie.autoComplete("ap"); // prints "apple" and "app"
 * trie.autoComplete(""); // prints all words in the trie
 * System.out.println(trie.search("banana")); // false
 * trie.delete("app");
 * System.out.println(trie.search("app")); // false
 * After deleting "app", only "apple" remains in the trie.
 * This example demonstrates the basic functionality of the `AutoSuggestionTrie` including insertion, searching, prefix checking, auto-completion, and deletion of words.
 * Note: This implementation assumes that the words consist of lowercase letters a-z only.
 * AutoSuggestionTrie is a trie-based data structure that provides efficient insertion, searching, prefix checking, deletion, and auto-completion of words.
 * It is particularly useful in applications where quick lookups of words and prefixes are required, such as search engines, text editors, and spell checkers.
 * It provides a foundation for building efficient auto-suggestion and autocomplete features in various applications.
 * Overall, the `AutoSuggestionTrie` class provides a comprehensive and efficient implementation of a trie data structure with essential operations for managing and querying words and prefixes.
 * This class can be extended or modified to support additional features such as case-insensitive searches, support for non-alphabetic characters, and more advanced auto-suggestion algorithms.
 * The `AutoSuggestionTrie` class serves as a valuable tool for developers looking to implement efficient word and prefix management in their applications, providing a solid foundation for building advanced text processing features.
 * Example usage and detailed explanation are provided above to help understand how to utilize the `AutoSuggestionTrie` class effectively in various scenarios.
 * AutoSuggestionTrie is a trie-based data structure that provides efficient insertion, searching, prefix checking, deletion, and auto-completion of words.
 * It is particularly useful in applications where quick lookups of words and prefixes are required, such as search engines, text editors, and spell checkers.
 * It provides a foundation for building efficient auto-suggestion and autocomplete features in various applications.   
 * 
 */

public class AutoSuggestionTrie {

    TrieNode root;
    public AutoSuggestionTrie() {
        root = new TrieNode();
    }
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // Assuming only lowercase letters a-z
            isEndOfWord = false;
        }
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
                return false;
            }
            current.isEndOfWord = false;
            return current.children.length == 0;
        }

        int index = word.charAt(depth) - 'a';
        if (delete(current.children[index], word, depth + 1)) {
            current.children[index] = null;
            return !current.isEndOfWord && noChildren(current);
        }
        return false;
    }

    private boolean noChildren(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    
    public void autoComplete(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return;
            }
            current = current.children[index];
        }
        autoCompleteHelper(current, prefix);
    }

    private void autoCompleteHelper(TrieNode current, String prefix) {
        if (current.isEndOfWord) {
            System.out.println(prefix);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            if (current.children[index] != null) {
                autoCompleteHelper(current.children[index], prefix + ch);
            }
        }
    }

    //main method to test the AutoSuggestionTrie class
    public static void main(String[] args) {    
        AutoSuggestionTrie trie = new AutoSuggestionTrie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");
        trie.insert("bat");
        trie.insert("ball");
        
        System.out.println("Auto-complete suggestions for 'ap':");
        trie.autoComplete("ap");
        
        System.out.println("Auto-complete suggestions for 'ba':");
        trie.autoComplete("ba");
        System.out.println("Auto-complete suggestions for 'b':");
        trie.autoComplete("b"); 
        System.out.println("Auto-complete suggestions for 'a':");
        trie.autoComplete("a");             
        System.out.println("Auto-complete suggestions for '':");
        trie.autoComplete("");  // Auto-complete for an empty prefix    
    }
    
}
