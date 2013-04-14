/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentGPALower implements StudentVisitor
{
    private double threshhold;
    @Override
    public void visit(Student stu)
    {
        if(stu.getGpa() <= threshhold)
        {
            System.out.println(stu);
        }
    }
    public void setThreshhold(double threshhold)
    {
        this.threshhold = threshhold;
    }
    public double getThreshhold()
    {
        return threshhold;
    }
}
