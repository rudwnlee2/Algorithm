//https://hoehen-flug.tistory.com/48#google_vignette 참고
//다시 풀어봐야함

import java.io.*;
import java.util.*;

class Node {
	char value;
	Node left;
	Node right;

	public Node(char value) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

class Main {

	static Node[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n + 1];
		
		StringTokenizer st;
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char value = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if(tree[value - 'A'] == null) {
				tree[value - 'A'] = new Node(value);
			}

			if(left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[value - 'A'].left = tree[left - 'A'];
			}

			if(right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[value - 'A'].right = tree[right - 'A'];
			}
		
		}

		//전위
		preorder(tree[0]);
		System.out.println();

		//중위
		inorder(tree[0]);
		System.out.println();

		//후위
		postorder(tree[0]);
		System.out.println();
	}

	private static void preorder(Node node) {
		if (node == null) return;
		System.out.print(node.value);
		preorder(node.left);
		preorder(node.right);
	}

	private static void inorder(Node node) {
		if (node == null) return;
		inorder(node.left);
		System.out.print(node.value);
		inorder(node.right);
	}

	private static void postorder(Node node) {
		if (node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value);
	}
}