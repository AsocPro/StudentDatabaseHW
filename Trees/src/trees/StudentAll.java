/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentAll implements StudentVisitor
{
    @Override
    public void visit(Student stu)
    {
        System.out.println(stu);
    }
}
