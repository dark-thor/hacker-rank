import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Node {

  int low; int high; Node left; Node right;
  Node(int low, int high) {
    this.low = low;
    this.high = high;
    this.left=null;
    this.right=null;
  }
  static Node insert(int low, int high, Node root) {
    if (root == null)
      return new Node(low, high);
    // lies within root interval, do nothing
    if (root.low <= low && root.high>=high)
      return root;
    // lies to right, no intersection
    if (root.high <= low) {
      root.left = insert(low, high, root.left);
      return root;
    }
    // lies to left, no intersection
    if (root.low >= high) {
      root.right = insert(low, high, root.right);
      return root;
    }
    // intersect with left boundary
    if (root.low > low) {
      root.left = insert(low, root.low, root.left);
    }
    // intersect with right boundary
    if (root.high < high) {
      root.right = insert(root.high, high, root.right);
    }
    return root;
  }

  static int count(Node root) {
      if (root == null) return 0;
      return root.high - root.low + count(root.left) + count(root.right);
  }

  public static void main(String args[]){
      Node root = null;
      root = insert(1,4, root);
      root = insert(2,10, root);
      root = insert(1,7, root);
      System.out.println(count(root));
  }
}

