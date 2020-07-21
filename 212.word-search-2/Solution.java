/*
https://leetcode.com/problems/word-search-ii/

Given a 2D board of characters and a list of words from the dictionary, 
find all words in the board.

Each word must be constructed from letters of a sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.
*/

import java.util.List;
import java.util.ArrayList;

public class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> res = new ArrayList<>();
        TrieNode root = createTrie(words);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(row, col, board, root, res);
            }
        }

        for (String s : res) {
            System.out.println(s);
        }

        return res;
    }

    private void dfs(int row, int col, char[][] board, TrieNode root, List<String> res) {
        TrieNode currNode = root;
        char currChar = board[row][col];
        int charIdx = currChar - 'a';

        if (currChar == '#' || currNode.next[charIdx] == null) { return; }

        currNode = currNode.next[charIdx];
        if (currNode.word != null) {
            res.add(currNode.word);
            currNode.word = null;
        }

        board[row][col] = '#';
        if (row > 0) { dfs(row-1, col, board, currNode, res); }
        if (col > 0) { dfs(row, col-1, board, currNode, res); }
        if (row < board.length - 1) { dfs(row+1, col, board, currNode, res); }
        if (col < board[0].length - 1) { dfs(row, col+1, board, currNode, res); }
        board[row][col] = currChar;
    }

    private TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode temp = root;

        for (String s : words) {
            for (char c : s.toCharArray()) {
                int charIdx = c - 'a';
                if (temp.next[charIdx] == null) {
                    temp.next[charIdx] = new TrieNode();
                }
                temp = temp.next[charIdx];
            }
            temp.word = s;
            temp = root;
        }

        return root;
    }

    public class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        sol.findWords(board, words);
    }
}