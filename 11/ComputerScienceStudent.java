
/**
 * class ComputerScienceStudent - represents a computer science student.
 *
 * @author Noga Matzliach
 * @version 30/10/2020
 */
public class ComputerScienceStudent extends Student
{
    // instance variables
    private String _programmingLanguage;
    private final String DEFAULT_PROGRAMMING_LANGUAGE="Java";

    /**
     * Constructor for objects of class ComputerScienceStudent
     * @param firstName The first name of this CS student
     * @param lastName The last name of this CS student
     * @param id The id of this CS student
     */
    public ComputerScienceStudent(String firstName, String lastName,long id)
    {
        // initialise instance variables
        super(firstName,lastName,id);
        _programmingLanguage=DEFAULT_PROGRAMMING_LANGUAGE;
    }

  /**
     * Constructor for objects of class ComputerScienceStudent
     * @param firstName The first name of this CS student
     * @param lastName The last name of this CS student
     * @param id The id of this CS student
     * @param courses An array of of courses 
     * @param grades An array of of grades 
     * @param programmingLanguage The programming Language of the student 
     */
    public ComputerScienceStudent(String firstName, String lastName,long id, String[] courses,double[] grades, String programmingLanguage)
    {
        // initialise instance variables
        super(firstName,lastName,id,courses,grades);
        _programmingLanguage=programmingLanguage;
    }

    /**
     * Returns the programming Language of the CS student
     * @return  the programming Language of the CS student
     */
    public String getProgrammingLanguage()
    {
        return _programmingLanguage;
    }
    
    /**
     * The method changes the programming Language of the CS student
     * @param  programmingLanguage  The new programming Language of the CS student
     */
    public void setProgrammingLanguage(String programmingLanguage)
    {
        _programmingLanguage=programmingLanguage;
    }
    
    /**
     * The method returns a string representation of the CS student in a specific format
     * @return string representation of the CS student
     */
    public String toString()
    {
        String s= new String(super.toString());
        
        s+=("Programming Language is: "+ _programmingLanguage+"\n");
        return s;
    }
    
    
}
