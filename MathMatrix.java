/*
	Author: Tin Vo
*/
/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 *
 * @version Skeleton file for students
 */
public class MathMatrix
{
    // instance variables
    private int[][] mathMatrix;  
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        // check the precondition. rectangularMatrix is a private method at end of Matrix class
        if((mat == null) || (mat.length == 0) || (mat[0].length == 0)
                || !rectangularMatrix(mat)) 
            throw new IllegalArgumentException("Violation of precondition: " +
                    "int[][] Matrix constructor");
        mathMatrix = new int[mat.length][mat[0].length];
        for(int row = 0; row < mat.length; row++) {
            for(int col = 0; col < mat[0].length; col++) {
                mathMatrix[row][col] = mat[row][col];
            }
        }    
    }

    
    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        // check the precondition. numRows > 0, numCols > 0
        if(numRows <= 0 || numCols <= 0)
            throw new IllegalArgumentException("Violation of precondition! numRows and numCols have to be greater than 0"); 
        mathMatrix = new int[numRows][numCols];
        for(int row = 0; row < mathMatrix.length; row++){
            for(int col = 0; col < mathMatrix[0].length; col++) {
                mathMatrix[row][col] = initialVal;
            }
        }
    }


    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    public void changeElement(int row, int col, int newValue) {
        // check the precondition. 0 <= row < numRows(), 0 <= col < numCols()
        if( !(row >= 0 && row < numRows()) || !(col >= 0 && col < numCols()))
            throw new IllegalArgumentException("Violation of precondition! 0 <= row < numRows(), 0 <= col < numCols()");
        mathMatrix[row][col] = newValue;
    }


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows() {
        return mathMatrix.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols() {
        return mathMatrix[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        //check the precondition. row  0 <= row < numRows(), col  0 <= col < numCols()
        if(!(row >=0 && row < numRows()) || !(col >= 0 && col < numCols()))
            throw new IllegalArgumentException("Violation of Precondition of getVal method");
        return mathMatrix[row][col];
    }


    /**
    * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
    * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix add(MathMatrix rightHandSide) {
        // check the precondition. rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
        if((rightHandSide.numRows() != numRows()) || rightHandSide.numCols() != numCols())
            throw new IllegalArgumentException("Violation of Precondition of add method");
        MathMatrix addMatrix = new MathMatrix(numRows(), numCols(),-1);
        for(int row = 0; row < numRows(); row++) {
            for(int col = 0; col < numCols(); col++) {
                addMatrix.changeElement(row,col,mathMatrix[row][col] + rightHandSide.getVal(row,col)); 
            }
        }
        return addMatrix;
    }


    /**
    * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        // check the precondition. rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
        if((rightHandSide.numRows() != numRows()) || rightHandSide.numCols() != numCols())
            throw new IllegalArgumentException("Violation of Precondition of subtract method");
        MathMatrix subtractMatrix = new MathMatrix(numRows(), numCols(),-1);
        for(int row = 0; row < numRows(); row++) {
            for(int col = 0; col < numCols(); col++) {
                subtractMatrix.changeElement(row,col,mathMatrix[row][col] - rightHandSide.getVal(row,col)); 
            }
        }
        return subtractMatrix;
    }


    /**
    * implements matrix multiplication, (this MathMatrix) * rightHandSide.
    * <br>pre: rightHandSide.numRows() = numCols()
    * <br>post: This method should not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numCols()
    * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
    */
    public MathMatrix multiply(MathMatrix rightHandSide) {
        // check the precondition. rightHandSide.numRows() = numCols()
        if(rightHandSide.numRows() != numCols())
            throw new IllegalArgumentException("Violation of Precondition of multiply method");
        MathMatrix multiplyMatrix = new MathMatrix(numRows(), rightHandSide.numCols(), -1);
        for(int row = 0; row < numRows(); row++) {
            for(int col = 0; col < rightHandSide.numCols(); col++) {
                int temp = 0, sum = 0;
                while(temp < numCols()){
                    sum += mathMatrix[row][temp]*rightHandSide.getVal(temp,col);
                    temp++;
                }
                multiplyMatrix.changeElement(row,col,sum);
            }
        }
        return multiplyMatrix;
    } 


    /**
    * Multiply all elements of this MathMatrix by factor.
    * <br>pre: none
    * <br>post: all elements in this matrix have been multiplied by factor. 
    * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
    * for all valid r and c.
    * @param factor the value to multipy every cell in this Matrix by.
    */
    public void scale(int factor) {
        for(int row = 0; row < numRows(); row++) {
            for(int col = 0; col < numCols(); col++) {
                mathMatrix[row][col] *= factor;
            }
        }
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        MathMatrix transposeMatrix = new MathMatrix(numCols(), numRows(), -1);
        for(int row = 0 ; row < numRows(); row++) {
            for(int col = 0; col < numCols(); col++) {
                transposeMatrix.changeElement(col, row, mathMatrix[row][col]);
            }
        }
        return transposeMatrix;
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            MathMatrix otherMatrix = (MathMatrix)rightHandSide;            
            if(otherMatrix.numRows() != numRows() || otherMatrix.numCols() != numCols())
                return false;
            else{
                for(int row = 0; row < numRows(); row++) {
                    for(int col = 0 ; col < numCols(); col++) {
                        if(mathMatrix[row][col] != otherMatrix.getVal(row,col)) 
                            return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     * Each row stats and ends with a vertical bar: '|'
     */
    public String toString(){
        StringBuffer stringMatrix = new StringBuffer();
        int numSpace = 0, maxLength = 0;
        for(int row = 0; row < numRows(); row++){
            for(int col = 0; col < numCols(); col++){
                maxLength = ("" + mathMatrix[row][col]).length();
                if(maxLength >= numSpace) numSpace = maxLength + 1;
            }
        } 
        for(int row = 0; row < numRows(); row++){
            stringMatrix.append("|");
            for(int col = 0; col < numCols(); col++){               
                int elementLength = ("" + mathMatrix[row][col]).length();
                for(int i = 0; i < numSpace-elementLength; i++) 
                    stringMatrix.append(" ");
                stringMatrix.append(mathMatrix[row][col]);
            }
            stringMatrix.append("|");
            stringMatrix.append("\n");
        }
        return stringMatrix.toString(); 
    }
    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular() {
        //check the precondition. this is a square matrix. numRows() == numCols() 
        if(numRows() != numCols())
            throw new IllegalArgumentException("Violation of precondition of a square matrix");
        if(numRows() == 1) 
            return true;
        for(int row = 0; row < numRows(); row++) {
            for(int col = 0; col < numCols(); col++) {
                if(row > col && mathMatrix[row][col]!= 0) 
                    return false;
            }
        }
        return true;
    }
    
    // method to ensure mat is rectangular
    // pre: mat != null
    public static boolean rectangularMatrix(int[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null");
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length ) {
            isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }
        return isRectangular;
    }
}

/*TV*/