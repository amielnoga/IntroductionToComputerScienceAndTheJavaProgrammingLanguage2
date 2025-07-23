
/**
 * class Ex14- Recursion in arrays (without loops at all)
 *
 * @author Noga Matzliach
 * @version 19.12.2020
 */
public class Ex14
{
    /**
     * howManySorted method - A recursive method that receives the size of an array and a number, and returns the number of
     * options to fill the array with numbers from the range 1 to that number so that they are not arranged in descending order
     *
     * @param  n  the length of the array
     * @param  max  positive integer value
     * @return  the number of options to fill the array according to the condition
     */
    public static int howManySorted(int n, int max)
    {
        //array length must be positive number
        if (n<=0)
            return 0;

        //creating an array and initializing the elements to be 1 (initial value)
        int[] arr=new int[n];
        arrayInitializing(arr,0);

        //overloading
        return howManySorted(n, max,arr);
    }

    //overloading
    private static int howManySorted(int n, int max, int[]arr)
    {
        //stop condition-last ascending order array
        if(arr[0]==max)
            return 1;

        //while last cell in the array is not the maximun number, incresing the value of the cell in 1 
        if(arr[arr.length-1]!=max)
        {
            arr[arr.length-1]+=1;
            return 1+howManySorted(n, max,arr);
        }
        /* arr[arr.length-1]==max -while last cell in the array is the maximun number, incresing/decresing previous cell/s, 
        and changing last cell respectively */
        else
        {  
            //counting how many times max is displayed in the array
            int maxCount=countingMax(arr,max,0);
            //upadating the last cell in the array
            arr[arr.length-1]=arr[arr.length-1-maxCount]+1;
            //upadating the rest of the cells in the array
            updateArray(arr,maxCount,1);
            return 1+howManySorted(n, max,arr);
        }
    }

    /**
     * Method arrayInitializing - recursive method that receives an array and initializing any element to be the value 1
     * Auxiliary method
     * @param arr an array
     * @param i an index 
     */
    private static void arrayInitializing(int []arr, int i)
    {
        //As long as the function not reach the end of the array
        if (i<arr.length)
        {
            //Initialize the element to be the value 1
            arr[i]=1;
            //Promoting recursion by increasing the index
            arrayInitializing(arr, i+1);
        }
    }

    /**
     * Method countingMax- recursive method that receives an array and a number aka max, and counting how many times it dislayed in the array
     * Auxiliary method
     * @param arr the array
     * @param max the maximum number that can be displayed in the array
     * @param index An index
     * @return counter of how many times max dislayed in the array
     */
    private static int countingMax( int []arr, int max, int index)
    {
        //As long as the function not reach the end of the array
        if(index<arr.length)
            if(arr[index]==max)
                return 1+countingMax(arr,max,index+1);
            else
                return 0+countingMax(arr,max,index+1);
        else 
            return 0;
    }

    /**
     * Method updateArray- recursive method , any time last cell=max, the function receives an array 
     * and the maximun counter in the current array and update the array respectively
     * Auxiliary method
     * @param arr An array
     * @param maxCount counter of how many times max is displayed in the array
     * @param j An index
     */
    private static void updateArray( int []arr, int maxCount,int j)
    {
        //while index is small/equal to the number of times max is displayed in the array
        if (j<=maxCount)
        {
            //updating all the cells that needs update (except the last cell that already updated)
            arr[arr.length-1-j]=arr[arr.length-1];
            updateArray(arr, maxCount,++j);
        }
    }

    /**
     * Method cntTrueReg - A recursive method that accepts as a parameter a boolean square matrix and returns how many
     * different true regions exist in the matrix. If no true zones exist 0 will be returned.
     * true region consists of at least one cell.
     *
     * @param mat A square matrix
     * @return The number of true regions exist in the matrix
     */
    public static int cntTrueReg (boolean[][]mat)
    {
        //if the matrix is 0X0, there is no true regions
        if(mat.length==0 )
            return 0;
        //changing matrix from boolean to integers so it will be possible to track on areas that already counted as true regions
        int[][]integerMatrix=new int[mat.length][mat.length];
        changeArray(mat,integerMatrix,0,0);
        //overloading- needed for the indexes(it's impossible to use loops), starting from left upper cell
        return cntTrueReg(integerMatrix,0,0);
    }

    //overloading
    private static int cntTrueReg (int[][]integerMatrix,int i,int j)
    {
        //Reset of the variable that tells whether this is a new truth area
        int isToCount=0;

        //stop condition - if the recursion arrived to the last cell (right-down)
        if(i==integerMatrix.length-1 && j==integerMatrix.length-1)
            if(integerMatrix[i][j]==1)
                return 1;
            else
                return 0;

        //the cell itself is part from *new* true region
        if(integerMatrix[i][j]==1)
        {
            //counting the region as new true region exist in the matrix
            isToCount=1; 
            //makes the cell and all his true neighbours to be 2 in order to avoid double counting
            checkigNeighbors(integerMatrix, i, j);
        }

        //recursion promotion on column
        if(j+1<integerMatrix.length)
            return isToCount+cntTrueReg(integerMatrix, i, j+1);
        //recursion promotion on row
        else if(i+1<integerMatrix.length)
            return isToCount+cntTrueReg(integerMatrix,i+1,0);

        return 0;
    }

    /**
     * checkigNeighbors method - The recursion checks whether the neighboring cells of the cell are part of the truth region
     * and marks them to avoid double counting
     * Auxiliary method
     * @param  integerMatrix  an integer matrix
     */
    private static void checkigNeighbors(int[][]integerMatrix,int i,int j)
    {
        //marking current cell
        integerMatrix[i][j]=2;

        //checking the lower neighbor
        if(isCellInTheArray(integerMatrix,i+1,j)==true && integerMatrix[i+1][j]==1)
            checkigNeighbors(integerMatrix,i+1,j);

        //checking the top neighbor
        if(isCellInTheArray(integerMatrix,i-1,j)==true && integerMatrix[i-1][j]==1)
            checkigNeighbors(integerMatrix,i-1,j);

        //checking the right neighbor
        if(isCellInTheArray(integerMatrix,i,j+1)==true && integerMatrix[i][j+1]==1)
            checkigNeighbors(integerMatrix,i,j+1);

        //checking the left neighbor
        if(isCellInTheArray(integerMatrix,i,j-1)==true && integerMatrix[i][j-1]==1)
            checkigNeighbors(integerMatrix,i+1,j-1);
    }

    /**
     * Method isCellInTheArray -The method verifies if the cell is in the array boundries.
     * Auxiliary method
     * @param integerMatrix an integer matrix
     * @param i matrix index
     * @param j matrix index
     * @return true/false if the cell is in the array boundries
     */
    private static boolean isCellInTheArray(int[][]integerMatrix, int i, int j)
    {
        if (i>=0 &&integerMatrix.length>i && j>=0 && integerMatrix.length>j)
            return true;
        else 
            return false;        
    }

    /**
     * Method changeArray- The method recives boolean matrix and integer matrix and copying the boolean matrix to the integer matrix
     * from true to 1 and from false to 2
     * Auxiliary method
     * @param mat a booelean matrix
     * @param integerMatrix a integer matrix 
     * @param i an index
     * @param j an index
     */
    private static void changeArray (boolean[][]mat,int[][]integerMatrix,int i,int j)
    {
        if(mat[i][j]==true)
            integerMatrix[i][j]=1;
        else
            integerMatrix[i][j]=0;

        //recursion promotion 
        if(j+1<mat.length)
            changeArray (mat,integerMatrix,i,j+1);

        if(i+1<mat.length)
            changeArray (mat,integerMatrix,i+1,0);
    }
}