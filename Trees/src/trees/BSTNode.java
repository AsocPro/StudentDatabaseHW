/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class BSTNode<E extends Comparable<E>>
{
    private BSTNode<E> parent;
    private BSTNode<E> leftChild;
    private BSTNode<E> rightChild;
    private E element;
    public BSTNode(E element)
    {
        parent = null;
        rightChild = null;
        leftChild = null;
        this.element = element;
    }
    public BSTNode(BSTNode parent, BSTNode rightChild, BSTNode leftChild, E element)
    {
        this.parent = parent;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
        this.element = element;
    }
    public E getElement() 
    {
        return element;
    }
    public void setElement(E element) 
    {
        this.element = element;
    }
    public BSTNode getParent() 
    {
        return parent;
    }
    public void setParent(BSTNode parent) 
    {
        this.parent = parent;
    }

    public BSTNode getLeftChild() 
    {
        return leftChild;
    }
    public void setLeftChild(BSTNode leftChild) 
    {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() 
    {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) 
    {
        this.rightChild = rightChild;
    }
    public int compareTo(E element)
    {
        return this.element.compareTo(element);
    }
}
