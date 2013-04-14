/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class StudentMajor implements StudentVisitor
{
    private String major;
    @Override
    public void visit(Student stu)
    {
        if(stu.getMajor().equalsIgnoreCase(major))
        {
            System.out.println(stu);
        }
    }
    public String getMajor() 
    {
        return major;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }
}
