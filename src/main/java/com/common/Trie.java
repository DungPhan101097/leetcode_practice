package com.common;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.leetcode;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Stack;
//
///**
// *
// * @author dungptm2
// */
//public class Trie {
//    
//    public Node root;
//     static int SHIFT = 97;
//    
//    class Node {
//        String value;
//        Node[] childrens;
//
//        public Node() {
//            this.value = "";
//            childrens = new Node[26];
//        }
//        
//        
//    }
//
//    public Trie() {
//        root = new Node();
//    }
//
//    public void insert(String word) { 
//        Node curNode = root;
//        boolean isEnd = false;
//        byte[] bytesWord = word.getBytes();
//        for (int i = 0; i < bytesWord.length; i++) {
//            isEnd = i == bytesWord.length -1 ;
//            int index = bytesWord[i] - SHIFT;
//            Node nextNode = curNode.childrens[index];
//            if (nextNode == null) {
//                nextNode = new Node();
//                curNode.childrens[index] = nextNode;
//            }
//            if (isEnd) {
//                nextNode.value = word;
//            } 
//            curNode = nextNode;
//        }
//        
//    }
//
//    public boolean search(String word) {
//        Node curNode = root;
//        boolean isEnd = false;
//        byte[] bytesWord = word.getBytes();
//        for (int i = 0; i < bytesWord.length; i++) {
//            isEnd = i == bytesWord.length - 1;
//            int index = bytesWord[i] - SHIFT;
//            Node nextNode = curNode.childrens[index];
//            
//            if (nextNode == null) {
//                return false;
//            }
//            if (isEnd && !nextNode.value.isEmpty()) {
//                return false;
//            }
//            if (isEnd && nextNode.isEnd) {
//                return true;
//            }
//            curNode = nextNode;
//        }
//        return false;
//    }
//
//    public boolean startsWith(String prefix) {
//        Node curNode = root;
//        boolean isEnd = false;
//        byte[] bytesWord = prefix.getBytes();
//        for (int i = 0; i < bytesWord.length; i++) {
//            isEnd = i == bytesWord.length - 1;
//            int index = bytesWord[i] - SHIFT;
//            Node nextNode = curNode.childrens[index];
//
//            if (nextNode == null) {
//                return false;
//            }
//            if (isEnd) {
//                return true;
//            }
//            curNode = nextNode;
//        }
//        return false;
//    }
//    
//    public static void main(String[] args) {
////        Trie obj = new Trie();
////         obj.insert("apple");
////         boolean param_2 = obj.search("apple");
////         boolean param_3 = obj.search("app");
////         boolean param_4 = obj.startsWith("app");
////         obj.insert("app");
////         boolean param_5 = obj.search("app");
////        boolean param_6 = obj.startsWith("apb");
////         
////         
////        System.out.println("param_2 " + param_2);
////        System.out.println("param_2 " + param_3);
////        System.out.println("param_2 " + param_4);
////        System.out.println("param_2 " + param_5);
////        System.out.println("param_2 " + param_6);
//
//        Stack<Byte> a = new Stack<>();
//        a.add((byte)'a');
//        a.add((byte) 'b');
//        
////        Object[] toArray =  a.toArray();
//        List<Object> asList = Arrays.asList(a.toArray());
//        System.exit(0);
//    }
//}
