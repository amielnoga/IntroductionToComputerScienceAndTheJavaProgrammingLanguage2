
/**
 * class Person - describes a general person
 *
 * @author Noga Matzliach
 * @version 30/10/20
 */
public class Person
{
    // instance variables
    protected String _firstName;
    protected String _lastName;
    protected long _id;
    public static final String NO_NAME="";

    /**
     * Constructor for objects of class Person
     * @param firstName The first name of this person
     * @param lastName The last name of this person
     * @param id The id of this person
     */
    public Person(String firstName, String lastName, long id)
    {
        // initialise instance variables
        _firstName= new String(firstName);
        _lastName=new String(lastName);
        _id=id;
    }

    /**
     * Copy Constructor for Person
     * Constructs and initializes a person with the same name and id as other person
     * @param p The person object from whice to construct the new person
     */
    public Person(Person p)
    {
        // initialise instance variables
        if (p!=null)
        {
        _firstName=new String(p._firstName);
        _lastName=new String(p._lastName);
        _id=p._id;
        }
        
        else
        {
        _firstName=new String(NO_NAME);
        _lastName=new String(NO_NAME);
        _id=000000000;
        }
    }
    
    /**
     * Returns the first name of the person 
     * @return the person first name
     */
    public String getFirstName()
    {
        return new String(_firstName);
    }
    
    /**
     * Returns the id of the person 
     * @return the person id
     */
    public long getId()
    {
        return _id;
    }
    
    /**
     * Returns the last name of the person 
     * @return the person last name
     */
    public String getLastName()
    {
        return new String(_lastName);
    }
    
    /**
     * The method changes the first name of the person 
     * @param  firstName  The new first name
     */
    public void setFirstName(String firstName)
    {
        if (firstName!=null)
            _firstName=new String(firstName);
    }
    
    /**
     * The method changes the last name of the person 
     * @param  lastName  The new last name
     */
    public void setLastName(String lastName)
    {
        if(lastName!=null)
            _lastName=new String (lastName);
    }
    
    /**
     * The method changes the id of the person 
     * @param  id  The new id
     */
    public void setId(long id)
    { 
        _id=id;
    }
    
    /**
     * The method returns a string representation of the person in a specific format
     * @return string representation of the person
     */
    public String toString()
    {
        return ("Last Name: "+_lastName+", First Name: "+_firstName+", ID: "+_id+"\n");
    }
}
