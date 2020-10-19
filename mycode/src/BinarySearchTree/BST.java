/** Implementing a Binary Search Tree.
 *
 * @source the skeleton for the code is taken
 * from Princeton's University Algorithm book.
 *
 * @author Adnan H. Mohamed
 */

package BinarySearchTree;
import java.util.Queue;
import java.util.ArrayDeque;

public class BST<K extends Comparable<K>, V> {
    private Node root;    // root of BST

    private class Node {
        private K _key;
        private V _value;
        private Node _left, _right;   // left and right subtrees
        private int N;                // # nodes in subtree rooted here.

        public Node(K key, V val, int N) {
            _key = key;
            _value = val;
            this.N = N;
        }
    }

    public int size() {return size(root);}

    /** helper for size(). */
    private int size(Node n) {
        if (n == null) {
            return 0;
        }
        return n.N;
    }

    /** Returns the value associated with
     * the given KEY. */
    public V get(K key) {
        return get(root, key);
    }

    /** Helper for get(K key). */
    private V get(Node n, K key) {
        int cmp = key.compareTo(n._key);
        if (cmp < 0) {
            return get(n._left, key);
        } else if (cmp > 0) {
            return get(n._right, key);
        } else {
            return n._value;
        }
    }

    /** inserts elements in the BST. */
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node n, K key, V val) {
        if (n == null) {return new Node(key, val, 1);}

        int cmp = key.compareTo(n._key);
        if (cmp < 0) {
            n.N += 1;
            n._left = put(n._left, key, val);
        } else if (cmp > 0) {
            n.N += 1;
            n._right = put(n._right, key, val);
        } else {
            n._value = val;
        }
        return n;
    }

    /** Returns the minimum key in the bst.
     * If the bst is empty, null is returned. */
    public K min() {
        if (root == null)
            return null;
        return min(root)._key;
    }
    /** Helper function for min(). */
    private Node min(Node n) {
        if(n._left == null)
            return n;
        else
            return min(n._left);
    }

    /** Returns the maximum key in the bst.
     * Null is returned for empty bst. */
    public K max() {
        if (root == null)
            return null;
        return max(root)._key;
    }

    /** Helper for max().
     * Returns the node with maximum key.
     * Precondition: the bst is NOT empty. */
    private Node max(Node n) {
        if(n._right == null)
            return n;
        return max(n._right);
    }

    /** Removes the node with the smallest key. */
    public void deleteMin() {
        root = deleteMin(root);
    }

    /** Helper for deleteMin(). */
    public Node deleteMin(Node n) {
        if (n._left == null) {
            return n._right;
        } else {
            n._left = deleteMin(n._left);
            n.N -= 1;
            return n;
        }
    }

    /** Removes the node with the max key. */
    public void deleteMax() {
        root = deleteMax(root);
    }

    /** Helper for deleteMax(). */
    private Node deleteMax(Node n) {
        if (n._right == null)
            return n._left;
        n._right = deleteMax(n._right);
        n.N -= 1;
        return n;
    }

    /** Removes the node with the given KEY. */
    public void delete(K key) {
        root = delete(root, key);
    }

    /** Helper for delete(K key). */
    private Node delete(Node n, K key) {

        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(n._key);
        if (cmp < 0) {
            n._left = delete(n._left, key);
            return n;
        }
        else if (cmp > 0) {
            n._right = delete(n._right, key);
            return n;
        }
        else {
            /** here we know that this is the node to be removed. */
            if(is_leaf(n)) {
                return null;
            }
            else if (n._left == null) {
                return n._right;
            }
            else if (n._right == null) {
                return n._left;
            }
            else {
                Node predecessor = max(n._left);
                deleteMax(n._left);
                n._key = predecessor._key;
                n._value = predecessor._value;
                predecessor = null;
                n.N -= 1;
                return n;
            }
        }
    }

    /** Returns the largest key less than or equal to KEY. */
    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x._key;
    }

    /** Helper for floor(K key). */
    private Node floor(Node n, K key) {
        if (n._left == null)
            return n;
        int cmp = key.compareTo(n._key);
        if (cmp < 0) {
            return floor(n._left, key);
        }
        else if(cmp > 0){
            Node node = floor(n._right, key);
            if (node == null)
                return n;
            return node;
        }
        else {
            return n;
        }
    }

    /** Returns the key where precisely RANK other keys in
     *  the bst are smaller.
     */
    public K select(int rank) {
        return select(root, rank)._key;
    }

    /** Helper for select(int rank). */
    private Node select(Node n, int rank) {
        if (n == null)
            return null;
        int x = size(n._left);
        if (rank < x) {
            return select(n._left, rank);
        } else if (x < rank) {
            return select(n._right, rank);
        } else {
            return n;
        }
    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K low, K hi) {
        Queue<K> queue = new ArrayDeque<>();
        keys(root, queue, low, hi);
        return queue;
    }

    private void keys(Node n, Queue<K> queue, K low, K hi) {
        if (n == null)
            return;
        int cmplo = low.compareTo(n._key);
        int cmphi = hi.compareTo(n._key);
        if(cmplo < 0) {
            keys(n._left, queue, low, hi);
        }
        if(cmplo <= 0 && cmphi >= 0) {
            /** this node is within the range. */
            queue.add(n._key);
        }
        if (cmphi > 0){
           keys(n._right, queue, low, hi);
        }
    }

    /** Returns true iff N does not have any child.
     * Precondition: n is not null. */
    private boolean is_leaf(Node n) {
        return n._left == null && n._right == null;
    }
}
