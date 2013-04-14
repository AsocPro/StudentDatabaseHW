/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    private BSTNode<E> root;
    private int size;
    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }
    public BinarySearchTree(E element)
    {
        root = new BSTNode<>(element);
        size = 1;
    }
    public BSTNode<E> root()
    {
        return root;
    }
    public boolean add(E element)
    {
        if(this.size == 0)
        {
            root = new BSTNode<>(element);
            size++;
            return true;
        }
        return addInternal(root,element);
    }
    private boolean addInternal(BSTNode<E> temp, E element)
    {
        if(temp.compareTo(element) < 0)
        {
            if(temp.getRightChild() == null)
            {
                temp.setRightChild(new BSTNode<>(element));
                this.size++;
                return true;
            }
            temp = temp.getRightChild();
            return addInternal(temp, element);
        }
        else if(temp.compareTo(element) > 0)
        {
            if(temp.getLeftChild() == null)
            {
                temp.setLeftChild(new BSTNode<>(element));
                this.size++;
                return true;
            }
            temp = temp.getLeftChild();
            return addInternal(temp, element);
        }
        else
        {
            return false;
        }
    }
    public boolean remove(BSTNode<E> node)
    {
        if(this.size==0)
        {
            return false;
        }
        if(this.size == 1)
        {
            node.setLeftChild(null);
            node.setRightChild(null);
            node.setElement(null);
            size--;
            return true;
        }
        BSTNode<E> temp = node;
        temp = temp.getRightChild();
        while(temp.getLeftChild() != null)
        {
            temp = temp.getLeftChild();
        }
        if(temp.getRightChild() != null)
        {
            temp.getRightChild().setParent(temp.getParent());
        }
        temp.setLeftChild(node.getLeftChild());
        temp.setRightChild(node.getRightChild());
        temp.setParent(node.getParent());
        node.setParent(null);
        node.setLeftChild(null);
        node.setRightChild(null);
        return true;
    }
    public BSTNode<E> find(E element)
    {
        if(this.size==0)
        {
            return null;
        }
        BSTNode<E> found = null;
        if(root.getElement().equals(element))
        {
            return root;
        }
        found = internalFind(root.getLeftChild(), element);
        if(found != null)
        {
            return found;
        }
        found = internalFind(root.getRightChild(), element);
        return found;
    }
    private BSTNode<E> internalFind(BSTNode<E> node, E element)
    {
        BSTNode<E> found = null;
        if(node.getElement().equals(element))
        {
            return node;
        }
        found = internalFind(node.getLeftChild(), element);
        if(found != null)
        {
            return found;
        }
        found = internalFind(node.getRightChild(), element);
        return found;
    }
    public void traverseInOrder(StudentVisitor visitor)
    {
        if(this.size==0)
        {
            return;
        }
        E element = root.getElement();
        if(root.getLeftChild() != null)
        {
           internalTraverseInOrder(visitor, root.getLeftChild());
        }
        visitor.visit((Student)element);
        if(root.getRightChild() != null)
        {
            internalTraverseInOrder(visitor, root.getRightChild());
        }
    }
    private void internalTraverseInOrder(StudentVisitor visitor, BSTNode<E> node)
    {
        E element = node.getElement();
        if(node.getLeftChild() != null)
        {
            internalTraverseInOrder(visitor, node.getLeftChild());
        }
        visitor.visit((Student)element);
        if(node.getRightChild() != null)
        {
            internalTraverseInOrder(visitor, node.getRightChild());
        }
    }
}
