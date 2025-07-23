
/**
 * class Driver
 *
 * @author Noga Matzliach
 * @version 30/10/2020
 */
public class Driver
{
    public static void main (String []args)
    {
        ComputerScienceStudent css[]=new ComputerScienceStudent[10];
         
        String[] courses1= {"Calculus I","Algebra I","Medicine"};
        double[] grades1={100,100.0,100.0,100.0};
        String[] courses2= {"Calculus I","Algebra I","Statistics"};
        double[] grades2={40.0,90.0,95.0,80.0};
        String[] courses3= {"Math I","Math 2","Statistics"};
        double[] grades3={40.0,90.0,95.0,80.0};
        
       
        css[0]=new ComputerScienceStudent("Eden","Amir",123456788,courses1,grades1,"Python");
        css[1]=new ComputerScienceStudent("Shlomo","Israeli",222456788,courses2,grades1,"Java");
        css[2]=new ComputerScienceStudent("Dan","Dan",111111111,courses3,grades3,"Java");
        int numOFStudents= 3;
        
        for (int i=0;i<numOFStudents;i++)
        {
            System.out.println(css[i]);
        }
        
        double higestAverage=0;
        int indexOfBestStudent=-1;
        for (int i=0;i<numOFStudents;i++)
        {
            if(css[i].getAverageGrade()>higestAverage)
            {
                indexOfBestStudent=i;
                higestAverage=css[i].getAverageGrade();
            }
        }
        
        System.out.println("The student with the highest average is "+ css[indexOfBestStudent]);
        
        System.out.println("\n------------------Tester------------------\n");
       
        System.out.println("------------Tester for Person------------\n");
        System.out.println("Testing constructor:\n");
        Person p1=new Person("Lilach","Swisa",234674980);
        System.out.println(p1);
        System.out.println("Testing copy constructor:\n");        
        Person p2=new Person(p1);
        System.out.println(p2);
        System.out.println("Testing copy constructor while person is null:\n");    
        Person p4= new Person(null);
        Person p3=new Person(p4);
        System.out.println(p3);
        System.out.println("Testing getters:\n");
        System.out.println(p1.getFirstName());
        System.out.println(p1.getId()); 
        System.out.println(p1.getLastName());
        System.out.println("\nTesting setters: \nA person berfore the change "+ p1);
        p1.setFirstName("Mayaan");
        p1.setLastName("Levi");
        p1.setId(010101012);
        System.out.println("The person after the change "+ p1);
        
        System.out.println("\n------------Tester for Student------------\n");
        System.out.println("Testing constructor 1:\n");
        Student s1=new Student("Noa","Nechmia",345453456);
        System.out.println(s1);
        System.out.println("Testing constructor 2:\n");
        Student s2=new Student("Nama","Nis",987767909, courses1, grades1);
        System.out.println(s2);
        System.out.println("Testing getters:");
        System.out.println("Number of courses is "+ s2.getNumOfCourses());
        System.out.println("Average grage is "+s2.getAverageGrade());
        System.out.println("\nTesting setters: \n A student berfore the change "+ s2);
        s2.setNumOfCourses(11);
        System.out.println("A student after trying to update number of courses to be bigger than the maximum the change "+ s2);
        s2.addCourse("Spanish",78);
        System.out.println("A student after allowed change "+ s2);
        System.out.println("The new average is "+s2.calculateAverageGrade());
        String[] courses7= {};
        double[] grades7={};
        Student s7=new Student("Avi","Ben-David",00000111,courses7,grades7);
        System.out.println("/nTesting average for stuent without courses "+ s7);
        System.out.println("The average is "+s7.calculateAverageGrade());
        
        System.out.println("\n------------Tester for CS Student------------\n");
        System.out.println("Testing constructor 1:\n");
        ComputerScienceStudent css1=new ComputerScienceStudent("Eli","Cohen",367489106);
        System.out.println(css1);
        ComputerScienceStudent css2=new ComputerScienceStudent("Sara","Son",23657891,courses3,grades3, "C");
        System.out.println(css2);
        System.out.println("Testing getters:\n");
        System.out.println("Programming language is "+css2.getProgrammingLanguage());
        System.out.println("\nTesting setters:\n");
        css2.setProgrammingLanguage("C++");
        System.out.println(css2);
    }
}
