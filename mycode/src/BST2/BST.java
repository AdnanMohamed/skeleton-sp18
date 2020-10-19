/** implements a binary search tree as discussed
 *  in lecture 10.2 at https://joshhug.gitbooks.io/hug61b
 *  Note: K must support '<', '>'
 * @author Adnan H. Mohamed
 */
package BST2;

public class BST<K> {
    private K _key;
    private BST _left;
    private BST _right;

    public BST(K key, BST left, BST right) {
        _key = key;
        _left = left;
        _right = right;
    }

    /** Creates a single-node BST. */
    public BST(K key) {
        _key = key;
    }

    /** Returns the BST which its root's key is KEY. */
//    static BST find(BST t, K key) {
//        if (t == null)
//            return null;
//        if (t._key < key) {
//            return find(t._right, key);
//        } else if(key < t._key) {
//            return find(t._left, key);
//        } else {
//            return t;
//        }
//    }
}
