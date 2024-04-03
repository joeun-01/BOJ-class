package BOJ;

/*
문자열 S의 접두사란 S의 가장 앞에서부터 부분 문자열을 의미한다. 
예를 들어, S = "codeplus"의 접두사는 "code", "co", "codepl", "codeplus"가 있고, "plus", "s", "cude", "crud"는 접두사가 아니다.

총 N개의 문자열로 이루어진 집합 S가 주어진다.
입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 문자열 중 적어도 하나의 접두사인 것의 개수를 구하는 프로그램을 작성하시오.

첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
다음 N개의 줄에는 집합 S에 포함되어 있는 문자열이 주어진다.
다음 M개의 줄에는 검사해야 하는 문자열이 주어진다.

입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 
집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

첫째 줄에 M개의 문자열 중에 총 몇 개가 포함되어 있는 문자열 중 적어도 하나의 접두사인지 출력한다.

5 10
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
star
start
code
sunday
coding
cod
online
judge
plus

7
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N14426 {
    public static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    static TrieNode root;
 
    static void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c);
        }
        currentNode.isEndOfWord = true;
    }
 
    static boolean searchPrefix(String prefix) {
        TrieNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());
 
        root = new TrieNode();
        for (int i = 0; i < N; i++) {
            String string = read.readLine();
            insert(string);
        }
 
        int count = 0;
        for (int i = 0; i < M; i++) {
            String query = read.readLine();
            if (searchPrefix(query)) {
                count++;
            }
        }
 
        System.out.println(count);
    }
}