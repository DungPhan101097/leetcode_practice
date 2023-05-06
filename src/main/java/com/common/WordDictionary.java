/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

/**
 *
 * @author dungptm2
 */
public class WordDictionary {
    
    private TrieNode root;
        
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        char[] charArray = word.toCharArray();
        TrieNode curNode = root;
        for (int i = 0; i <= charArray.length - 1; i++) {
            TrieNode nextNode = curNode.child[charArray[i] - 'a'];
            if (nextNode == null) {
                nextNode = new TrieNode();
                curNode.child[charArray[i] - 'a'] = nextNode;
            }
            if (i == charArray.length - 1) {
                nextNode.val = word;
            }
            curNode = nextNode;
        }
    }
    
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode curNode = root;
        for (int i = 0; i < charArray.length; i++) {
            TrieNode nextNode = null;
            if (charArray[i] != '.') {
                nextNode = curNode.child[charArray[i] - 'a'];
            } else {
               for (TrieNode child : curNode.child) {
                   if (child == null) continue;
                   boolean searchChild = searchChild(child, word.substring(i + 1));
                   if (searchChild) {
                       return searchChild;
                   }
               }
            }
            if (nextNode == null) {
                return false;
            }
            curNode = nextNode;
        }
        return curNode.val.equals(word);
        
    }
    
    private boolean searchChild(TrieNode curNode, String subWord) {
        if (subWord.isEmpty()) {
            return !curNode.val.isEmpty();
        }
        char[] charArray = subWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            TrieNode nextNode = null;
            if (charArray[i] != '.') {
                nextNode = curNode.child[charArray[i] - 'a'];
            } else {
                for (TrieNode child : curNode.child) {
                    if (child == null) {
                        continue;
                    }
                    boolean searchChild = searchChild(child, subWord.substring(i + 1));
                    if (searchChild) {
                        return searchChild;
                    }
                }
            }
            if (nextNode == null) {
                return false;
            }
            curNode = nextNode;
            
        }
        return !curNode.val.isEmpty();
        
    }
    
    class TrieNode {
        public String val;
        public TrieNode[] child;

        public TrieNode() {
            val = "";
            child = new TrieNode[27];
        }
        
        

    }
    
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
        System.exit(0);
    }
}
