/*
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrefixTree {
	
	public static void main(String[] args)
	{
		PrefixTree o = new PrefixTree();
		ArrayList<String> a = new ArrayList<>();
		a.addAll(Arrays.asList("bearcat", "bert" ));
		o.prefix(a);
	}
	
	private Node root;
	public ArrayList<String> prefix(ArrayList<String> a) {
         ArrayList<String> res = new ArrayList<>();
	    
	    for (String str : a) {
	        put(str);
	    }
	    
	    for (String str : a) {
	        String prefix = getPrefix(str);
	        res.add(prefix);
	    }
	    
	    return res;
	    
	}
	
	public String getPrefix(String str) {
	    StringBuilder strB = new StringBuilder();
	    return get(root, str, 0, strB);
	}
	
	
	public String get(Node node, String str, int index, StringBuilder strB) {
	    
	    char c = str.charAt(index);
	    
	    if (c < node.c) {
	        return get(node.left, str, index, strB);
	    } else if (c > node.c) {
	        return get(node.right, str, index, strB);
	    } else if (node.val == 1) {
	        strB.append(node.c);
	        return strB.toString();
	    } else {
	        strB.append(node.c);
	        return get(node.mid, str, index + 1, strB);
	    }
	    
	}
	
	public void put(String str) {
	    root = put(root, str, 0);
	}
	
	public Node put(Node node, String str, int index) {
	    
	    if (index == str.length())
	        return node;
	    
	    if (node == null)
	        node = new Node(str.charAt(index));
	    
	    char c = str.charAt(index);
	    
	    if (c < node.c) {
	        node.left = put(node.left, str, index);
	    } else if (c > node.c) {
	        node.right = put(node.right, str, index);
	    } else {
	        node.mid = put(node.mid, str, index + 1);
	        node.val += 1;
	    }
	    
	    return node;
	}
	
	class Node {
	    char c;
	    int val;
	    Node left, mid, right;
	    
	    public Node() {}
	    
	    public Node(char c) {
	        this.c = c;
	        this.val = 0;
	    }
	}
	
}
	    