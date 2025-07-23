/**
 * class BigNumber - representing a linked list represnt very large numbers and defining some useful actions on the list.
 * We refer in this task to non-negative numbers only (i.e. positive and zero).
 * The linked list must be one-way.
 * @author (Noga Matzliach)
 * @version (10.01.2021)
 */
public class BigNumber
{
    // instance variable - a node that represents the head of the list
    private IntNode _head; 

    /**
     * BigNumber Constructor - empty constructor - initializes the list to contain one node that the node value is 0. 
     * 
     * Time complexity: O(1)
     * Place complexity: O(1)
     *
     */
    public BigNumber()
    {
        // initialise instance variable
        _head = new IntNode(0);
    }

    /**
     * BigNumber Constructor - A constructor that receives a number (long type) as a parameter and stores it in a list format.
     * In the list the number is stored from the end to the beginning.
     * 
     * n is the number of digits in the number
     * Time complexity: O(n) 
     * Place complexity: O(n)
     *
     * @param number The number that the method recived (long type) in order to stores it in a list format
     */
    public BigNumber(long number)
    {
        // initialise instance variables - the first node in the list contains the digit of the unity of the number
        int digit=(int)(number-((number/10)*10));
        _head = new IntNode(digit);
        number=number/10;
        IntNode ptr=_head;

        //Initialize the following nodes
        while(number>0)
        {   
            digit=(int)(number-((number/10)*10));
            ptr.setNext(new IntNode(digit));
            ptr=ptr.getNext(); 
            number=number/10;
        }
    }

    /**
     * BigNumber Constructor - copy constructor, recives a list and create new list with the same values
     *
     * n is the number of digits in the number
     * Time complexity: O(n)
     * Place complexity: O(n)
     *
     * @param other The original list (the list the method recived)
     */
    public BigNumber(BigNumber other)
    {
        if(other._head!=null) // if list is not empty
        {
            this._head=new IntNode(other._head.getValue());
            IntNode thsPtr=this._head;
            IntNode otrPtr=other._head;

            while(otrPtr.getNext()!=null) // As long as I have not finished going through the list received as a parameter
            {
                thsPtr.setNext(new IntNode(otrPtr.getNext().getValue()));
                thsPtr=thsPtr.getNext();
                otrPtr=otrPtr.getNext();
            }
        }
    }

    /**
     * Method toString- recursion method that returns as a string the number represented in the list (noraml way).
     * 
     * n is the number of digits in the number
     * Time complexity: O(n)
     * Place complexity: O(1)
     *
     * @return string that representes the number in the list
     */
    public String toString()
    {
        return toString(_head);
    }

    //overloading
    private String toString(IntNode n)
    {
        // end of the list
        if (n==null)
            return"";

        else
            return toString(n.getNext()) + n.getValue();   

    }

    /**
     * Method deletingLeadingZeros- the method delete from bignumber leading zeros 
     *
     * n is the number of digits in the number
     * Time complexity: O(n)
     * Place complexity: O(1)
     * 
     * @param thsPtr pointer to the head of the list
     */
    private void deletingLeadingZeros(IntNode thsPtr)
    {
        // pointer to the previous node
        IntNode thsprev=null;
        // pointer to the current node
        IntNode thscurr=thsPtr;

        //Promoting pointer til it reach the most significant node
        while (thscurr.getNext()!=null)
        {
            thsprev=thscurr;
            thscurr=thscurr.getNext();
        }

        // stop condition= there is no leading zeros left 
        if (thscurr.getValue()!=0)
            return ;
        /*thscurr.getValue()==0
        if the it's leading zero, the node will not be linked to the list any more*/
        else 
        {
            //verifying it's not the only node in the list
            if(thsprev!=null)
            {
                thsprev.setNext(null);
                deletingLeadingZeros(thsPtr);
            }
            //stop conditon- there is only one node in the list 
            else
                return;
        }
    }

    /**
     * Method compareTo - the method comparing two large numbers.
     * If the number on which the method is activated is smaller than the number obtained as a parameter, the value -1 is returned
     * If the number on which the method is applied is greater than the number obtained as a parameter, the Value 1 is returned
     * if the numbers are equal - the value 0 will be returned.
     *
     * Time complexity: O(n)
     * Place complexity: O(n)
     *
     * @param other A BigNumber object
     * @return 0/1/-1
     */
    public int compareTo (BigNumber other)
    {
        int thisLength=length(this);
        int otherLength=length(other);

        //if both numbers have the same length, it's needed to check who is greater By the value of the digits  
        if (thisLength==otherLength)
        {
            if (thisLength==0)
                return 0;
            else
                return compareToEqualNumOfDigits((new BigNumber(this)._head),(new BigNumber(other)._head));
        }
        /* If the number on which the method is activated has less digits so it's for sure smaller
        than the number obtained as a parameter, the value -1 is returned */
        else if(thisLength<otherLength)
            return -1;

        /* thisLength>otherLength
        If the number on which the method is applied has more digits so it's for sure greater
        than the number obtained as a parameter, the Value 1 is returned */
        else
            return 1;
    }

    /**
     * Method compareToEqualNumOfDigits - An auxiliary method that handles cases that  lists that have the same length.
     *
     * Time complexity: O(n)
     * Place complexity: O(1)
     *
     * @param thsPtr head of the first list
     * @param otrPtr head of the second list
     * @return 0/1/-1
     */
    private int compareToEqualNumOfDigits(IntNode thsPtr,IntNode otrPtr)
    {
        // pointers to the previous nodes
        IntNode thsprev=null,otrprev=null ;
        // pointers to the current nodes
        IntNode thscurr=thsPtr,otrcurr=otrPtr ;

        //Promoting pointers til they reach the most significant nodes
        while (thscurr.getNext()!=null && otrcurr.getNext()!=null)
        {
            thsprev=thscurr;
            otrprev=otrcurr;
            thscurr=thscurr.getNext();
            otrcurr=otrcurr.getNext();
        }

        //comparing significant nodes
        if (thscurr.getValue()<otrcurr.getValue())
            return -1;
        else if (thscurr.getValue()>otrcurr.getValue())
            return 1;
        //if the values of the nodes are equals and they are the last nodes
        else if((thscurr.getValue()==otrcurr.getValue()) && thsprev==null && otrprev==null) 
            return 0;
        /*thscurr.getValue()==otrcurr.getValue())
        if the values of the nodes are equals and they are not the last digits in the number It is necessary to continue checking*/
        else 
        {
            thsprev.setNext(null);
            otrprev.setNext(null);
            return compareToEqualNumOfDigits(thsPtr,otrPtr);
        }
    }

    /**
     * Method length - calculets the length of the list
     *
     * Time complexity: O(n)
     * Place complexity: O(n)
     *
     * @param number A BigNumber object
     * @return count The length of the list
     */
    private int length (BigNumber number)
    {
        BigNumber copy=new BigNumber(number);
        deletingLeadingZeros(copy._head);

        IntNode temp=copy._head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.getNext();
        }
        return count;
    }

    /**
     * Method addBigNumber -The method of addition two large numbers.
     * The addition returns BigNumber object that is the sum of the numbers .
     *
     * n is the number of digits in the large number
     * Time complexity: O(n)
     * Place complexity: O(n)
     *
     * @param other A BigNumber object
     * @return sum BigNumber object
     */
    public BigNumber addBigNumber (BigNumber other)
    {
        IntNode thsPtr=_head;
        IntNode otrPtr=other._head;

        BigNumber sum= new BigNumber();
        IntNode sumPtr=sum._head;

        int digitSum;
        int reminder=0;
        boolean isFirst=true;

        while( thsPtr != null && otrPtr != null )
        {
            digitSum= thsPtr.getValue()+otrPtr.getValue()+reminder;
            //each node needs to contain only one digit - this case hande it (digitSum has two digits) 
            if(digitSum>9)
            {
                //if this is the first node, it's necessery to override 0 from constructor
                if (isFirst)
                {
                    sumPtr.setValue(digitSum%10);
                    isFirst=false;
                }

                else
                {
                    sumPtr.setNext(new IntNode(digitSum%10));
                    sumPtr=sumPtr.getNext();
                }
                reminder=digitSum/10;
            }
            //digitSum has one digits
            else
            {
                //if this is the first node, it's necessery to override 0 from constructor
                if (isFirst)
                {
                    sumPtr.setValue(digitSum);
                    isFirst=false;
                }
                else
                {
                    sumPtr.setNext(new IntNode(digitSum));
                    sumPtr=sumPtr.getNext();
                }
                reminder=0;
            }
            thsPtr=thsPtr.getNext();
            otrPtr=otrPtr.getNext();
        }

        //If one of the numbers has more digits than the other, the program should keep running on the large number
        while (thsPtr != null)
        {
            sumPtr.setNext(new IntNode((thsPtr.getValue()+reminder)%10));
            reminder=(thsPtr.getValue()+reminder)/10;
            sumPtr=sumPtr.getNext();
            thsPtr=thsPtr.getNext();
        }

        while (otrPtr != null)
        {
            sumPtr.setNext(new IntNode((otrPtr.getValue()+reminder)%10));
            reminder=(otrPtr.getValue()+reminder)/10;
            sumPtr=sumPtr.getNext();
            otrPtr=otrPtr.getNext();
        }

        if(reminder!=0)
        {
            sumPtr.setNext(new IntNode(reminder));
            reminder=0;
        }
        deletingLeadingZeros(sum._head);
        return sum;
    }

    /**
     * Method addLong - This method add an object of type large number to another long number.
     * The addition returns as a result an new object of BigNumber.
     *
     * n is the number of digits in the number
     * Time complexity: O(n)
     * Place complexity: O(n)
     *
     * @param number to preform addition with 
     * @return sum (BigNumber type)
     */
    public BigNumber addLong (long num)
    {
        return addBigNumber(new BigNumber(num));
    }

    /**
     * Method subtractBigNumber - The subtraction method of two large numbers.
     * The subtraction is the larger number of the two less the smaller number.
     * Returns as a result a new object of type BigNumber.
     * 
     * n is the number of digits in the bigger number
     * Time complexity: O(n)
     * Place complexity: O(n)
     *
     * @param other A larger number
     * @return subtraction result
     */
    public BigNumber subtractBigNumber (BigNumber other)
    {
        BigNumber minuend= new BigNumber();
        BigNumber subtrahend= new BigNumber();
        BigNumber difference= new BigNumber();

        //minuend must be bigger than subtrahend so the differnce is non-negative.
        if (this.compareTo(other)==1)
        {
            minuend=this;
            subtrahend=other;
        }
        else if(this.compareTo(other)==-1)
        {
            minuend=other;
            subtrahend=this;
        }
        //numbers are equals, difference is 0
        else
        {
            return difference;
        }

        IntNode minuendPtr=minuend._head;
        IntNode subtrahendPtr=subtrahend._head;
        IntNode differencePtr=difference._head;

        int digitDifference;
        int reminder=0;
        boolean isFirst=true;

        while(minuendPtr != null && subtrahendPtr != null )
        {
            digitDifference= minuendPtr.getValue()-subtrahendPtr.getValue()+reminder;
            //digitDifference is negative, loan (of 10) is needed
            if(digitDifference<0)
            {
                //if this is the first node, it's necessery to override 0 from constructor
                if(isFirst)
                {
                    differencePtr.setValue(digitDifference+10);
                    isFirst=false;
                }
                else
                {
                    differencePtr.setNext(new IntNode(digitDifference+10));
                    differencePtr=differencePtr.getNext();
                }
                reminder=-1;
            }
            //digitDifference is  0 or positive,no loan is needed
            else
            {
                //if this is the first node, it's necessery to override 0 from constructor
                if(isFirst)
                {
                    differencePtr.setValue(digitDifference);
                    isFirst=false;
                }
                else
                {
                    differencePtr.setNext(new IntNode(digitDifference));
                    differencePtr=differencePtr.getNext();
                }
                reminder=0;
            }
            minuendPtr=minuendPtr.getNext();
            subtrahendPtr=subtrahendPtr.getNext();
        }

        //while I havent finshed to subtract from the rest of the minued
        while (minuendPtr != null && differencePtr!=null)
        {
            digitDifference=minuendPtr.getValue()+reminder;
            if(digitDifference>=0)
            {
                differencePtr.setNext(new IntNode(minuendPtr.getValue()+reminder));
                reminder=0;
                differencePtr=differencePtr.getNext();
                minuendPtr=minuendPtr.getNext();
            }
            //digitDifference<0
            else
            {
                differencePtr.setNext(new IntNode(minuendPtr.getValue()+reminder+10));
                reminder=-1;
                differencePtr=differencePtr.getNext();
                minuendPtr=minuendPtr.getNext();
            }
        }
        deletingLeadingZeros(difference._head);
        return difference;
    }

    /**
     * Method multBigNumber - The multiplication method of two large numbers.
     * The multiplier returns as a result a new BigNumber object.
     *
     * m is the number of digits in the bigger number
     * Time complexity: O(m^2)
     * Place complexity: O(m^2)
     *
     * @param other BigNumber object
     * @return The product of the two numbers (BigNumber object)
     */
    public BigNumber multBigNumber (BigNumber other)
    {
        IntNode smallerPtr; //small number
        IntNode largerPtr; // big number

        //verifying which number is bigger (in order to create less calls to sum function )
        if (this.compareTo(other)==1)
        {
            smallerPtr=other._head;
            largerPtr=_head;
        }

        else
        {
            smallerPtr=_head;
            largerPtr=other._head; 
        }

        IntNode largerPtrHead=largerPtr;
        BigNumber product= new BigNumber();
        BigNumber temp= new BigNumber(); // The temp result
        IntNode tempPtr=temp._head;

        int digitsProduct;
        int reminder=0;
        boolean isFirst=true; 

        int minLength=Math.min(length(this),length(other));

        for( int i=0;i<minLength;i++)
        {
            //Adding leading zeros in multiplication in each external for iteration
            // from 0 to i-1, because there is one zero from the constructor
            for(int j=0;j<i-1;j++)
            {
                tempPtr.setNext(new IntNode(0));
                tempPtr=tempPtr.getNext();   
            }

            // while large number isn't reached the end
            while(largerPtr != null)
            {
                digitsProduct= (smallerPtr.getValue()*largerPtr.getValue())+reminder;
                //digitProduct has two digits
                if(digitsProduct>9)
                {
                    //if this is the first node, it's necessery to override 0 from constructor
                    if (isFirst)
                    {
                        tempPtr.setValue(digitsProduct%10);
                        isFirst=false;
                    }
                    else
                    {
                        tempPtr.setNext(new IntNode(digitsProduct%10));
                        tempPtr=tempPtr.getNext();
                    }
                    reminder=digitsProduct/10;
                }
                //digitProduct has one digit
                else
                {
                    //if this is the first node, it's necessery to override 0 from constructor
                    if (isFirst)
                    {
                        tempPtr.setValue(digitsProduct);
                        isFirst=false;
                    }
                    else
                    {
                        tempPtr.setNext(new IntNode(digitsProduct));
                        tempPtr=tempPtr.getNext();
                    }
                    reminder=0;
                }
                largerPtr=largerPtr.getNext();
            } //WHILE
            //in case the last digit product had two digits, there is still reminder that needs to be added
            if (reminder!=0)
            {
                tempPtr.setNext(new IntNode(reminder));
                reminder=0;
            }

            smallerPtr=smallerPtr.getNext();
            largerPtr=largerPtrHead;
            //adding current sub-result to the final result
            product=product.addBigNumber(temp);
            //Resetting the temporary variables
            temp= new BigNumber();
            tempPtr=temp._head;
        } //FOR
        deletingLeadingZeros(product._head);
        return product;
    }
}