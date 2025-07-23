
/**
 * class Student - describes a Student
 *
 * @author Noga Matzliach
 * @version 30/10/2020
 */
public class Student extends Person 
{
    // instance variables
    protected double _averageGrade;
    protected int _numOfCourses;
    protected String[] _courses;
    protected double[] _grades;
    protected final int MAX_NUM_OF_COURSES=10;

    /**
     * Constructor for objects of class Student
     * @param firstName The first name of this student
     * @param lastName The last name of this student
     * @param id The id of this student
     */
    public Student(String firstName, String lastName,long id)
    {
        // initialise instance variables
        super(firstName,lastName,id);
        _averageGrade=0.0;
        _numOfCourses=0;
        _courses= new String[MAX_NUM_OF_COURSES];
        _grades= new double[MAX_NUM_OF_COURSES];
    }
    
    /**
     * Constructor for objects of class Student
     * @param firstName The first name of this student
     * @param lastName The last name of this student
     * @param id The id of this student
     * @param courses An array of of courses 
     * @param grades An array of of grades 
     */
    public Student(String firstName, String lastName,long id, String[] courses, double[] grades)
    {
        // initialise instance variables
        super(firstName,lastName,id);
        _numOfCourses=courses.length;
        _courses= new String [MAX_NUM_OF_COURSES];
        for (int i=0;i<courses.length;i++)
            _courses[i]=new String(courses[i]);
        _grades=new double[MAX_NUM_OF_COURSES];
        for (int i=0;i<grades.length;i++)
            _grades[i]=grades[i];
        
        _averageGrade=calculateAverageGrade();    
    }

    /**
     * Returns the number of courses of the student
     * @return the number of courses of the student
     */
    public int getNumOfCourses()
    {
        return _numOfCourses;
    }
    
    /**
     * Returns the average grade of the student
     * @return the average grade of the student
     */
    public double getAverageGrade()
    {
        return _averageGrade;
    }
    
    /**
     * The method changes the number of course of the student
     * @param  numOfCourses  The new number of courses of the studen
     */
    public void setNumOfCourses(int numOfCourses)
    {
        if (numOfCourses<=MAX_NUM_OF_COURSES)
        _numOfCourses=numOfCourses;
    }
    
    /**
     * The method calculate the average of the grades of the student
     * @return the average grade of the student
     */
    public double calculateAverageGrade()
    {
        double sum=0,average;
        
        for (int i=0;i<_numOfCourses;i++)
        {
            sum+=_grades[i];
        }
        
        if(_numOfCourses!=0)
            average=(sum/_numOfCourses);   
        else
            average=0;
        
        return average;
    }
    
    /**
     * The method gets the name of the course and is grade and insert them to the arrays
     * In addition the method update the average
     * @param  courseName  The name of the course
     * @param  courseGrade  The grade of the course
     * @return true/false   true if it succedd, false otherwise
     */
    public boolean addCourse(String courseName, double courseGrade)
    {
       if (MAX_NUM_OF_COURSES==_numOfCourses)
        return false;
        
       else
       {
           _courses[_numOfCourses]=new String(courseName);
           _grades[_numOfCourses]=courseGrade;
           _numOfCourses++;
           _averageGrade=calculateAverageGrade();
           return true;
       }
    }
    
    /**
     * The method returns a string representation of the student in a specific format
     * @return string representation of the student
     */
    public String toString()
    {
        String s= new String(super.toString());
        
        s+="Courses:\n\t";
        for(int i=0;i<_numOfCourses;i++)
            s+=(_courses[i]+":\t"+_grades[i]+"\n\t");
        return s;
    }
    
}
