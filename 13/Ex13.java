
/**
 * class Ex13 - Recursion
 *
 * @author Noga Matzliach
 * @version 01/12/20
 */
public class Ex13
{
    /**
     * digitDiffer method - a recursive method that receives 2 positive integers numbers and returns difference in the number of digits of the numbers
     *
     * @param  a  integer greater than zero
     * @param  b  integer greater than zero
     * @return    difference in the number of digits of the numbers.
     */
    public static int digitDiffer(int a,int b)
    {
        //Stop condition == base case
        if (a==0 && b==0)
            return 0;
        //Subtract digits from both numbers in the number of digits they share
        if(a >0 && b>0)
            return digitDiffer(a/10,b/10);
        //Lowering a digit from the largest number among them and increasing the numerator by 1
        return 1+digitDiffer(0,(Math.max(a,b))/10);
    }

    /**
     * numWaysToClimb method - a recursive method which returns the number of different ways to climb a ladder with n rungs.
     * each step can be 1 rung or 2 rung.
     * assumeing n is non-negative number.
     *
     * @param  n  the number of rungs in the ladder
     * @return    the number of different ways to climb the ladder
     */
    public static int numWaysToClimb(int n)
    {
        // simple case
        if (n==0 || n==1 || n==2)
            return n;

        // to the current rung it's possible to arrive from the last rung or the rung before the last rung 
        return numWaysToClimb(n-1)+numWaysToClimb(n-2);
    }

    /**
     * solutions method - A recursive static method that accepts as a parameter a positive integer num and returns the number of
     *                    solutions to the equation: x1 + x2 + x3 = num
     *                    assuming the three xs are integers and positive numbers between 1 and 10.
     *                    The method prints these solutions, each solution in a separate line.
     *
     * @param  num  a positive integer
     * @return    the number of solutions to the equation: x1 + x2 + x3 = num
     */
    public static int solutions(int num)
    {
        //num can't be greatar than 30 or less than 3 according to question condition
        if (num>30 || num<3)
            return 0;
        // overloading
        return solutions(1,1,num-2,num);
    }

    private static int solutions(int x1,int x2,int x3,int num)
    {
        // if x1,x2,x3 are solutions to the equation- print the solutions  
        if(x1!=0 && x2!=0 && x3!=0)
            if(x1+x2+x3==num)
                System.out.println(x1+" + "+x2+" + "+x3);

        //stop case
        if (x1==num-2 && x2==1 && x3==1)
            return 1;   
        else
        {                
            if (x3>1)
                return 1+solutions(x1, x2+1, x3-1, num);

            else if (x3==1)
                return 1+solutions(x1+1,1,num-(x1+1)-1, num);
            else
                return 0; 
        }
    }
}
