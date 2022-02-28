package matrix;

/**
 * This abstract class partially implements the Matrix API.
 * Only the number of rows and columns are stored. A subclass
 * should create the data structure used to store matrix elements.
 *
 * @author tcolburn
 */
public abstract class AbstractMatrix implements Matrix {

    /**
     * Returns the number of rows in this matrix.
     *
     * @return the number of rows in this matrix.
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Returns the number of columns in this matrix.
     *
     * @return the number of columns in this matrix.
     */
    public int getNumColumns() {
        return numColumns;
    }

    /**
     * Sets the number of rows in this matrix.
     * @param numRows the number of rows in this matrix
     * @throws MatrixException if numRows is not positive
     */
    public void setNumRows(int numRows) {
        if (numRows <= 0) {
            throw new MatrixException(String.format("numRows (%s) must be positive", numRows));
        }
        this.numRows = numRows;
    }

    /**
     * Sets the number of columns in this matrix.
     * @param numColumns the number of columns in this matrix
     * @throws MatrixException if numColumns is not positive
     */
    public void setNumColumns(int numColumns) {
        if (numColumns <= 0) {
            throw new MatrixException(String.format("numColumns (%s) must be positive", numColumns));
        }
        this.numColumns = numColumns;
    }

    /**
     * Creates a visual representation of this matrix as a string. This method
     * can be used for debugging. This is a template method; it uses a method
     * (get) that must be implemented by a subclass. This method overrides a
     * method in the Object class.
     *
     * @return the string representation of this matrix.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < getNumRows(); r++) {
            for (int c = 0; c < getNumColumns(); c++) {
                builder.append(String.format("%6s", get(r, c)));
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Tests for equality of this matrix with another. Matrices are equal if
     * they have the same dimensions and all elements are equal by ==. This is a
     * template method; it uses a method (get) that must be implemented by a
     * subclass. This method overrides a method in the Object class, so it must
     * type check and cast its argument to the correct type.
     *
     * @param obj the other matrix to be tested for equality with this matrix
     * @return <b>true</b> if the other matrix is equal to this matrix,
     * <b>false</b> otherwise
     */
    @Override
    public boolean equals(Object obj) {
        Matrix other_object = (Matrix)obj; 
        if(this.numRows != other_object.getNumRows() || this.numColumns != other_object.getNumColumns()) {
            return false;
        } //end of if
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                if (this.get(i, j) != other_object.get(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Adds this matrix to another.
     * @param other the other matrix to add
     * @return a new matrix that is the sum of this matrix and other
     * @throws MatrixException if this matrix and the other matrix do not have
     * the same dimensions
     */
    @Override
    public Matrix add(Matrix other) {
        if (this.getNumRows() == other.getNumRows() && this.getNumColumns() == other.getNumColumns()) {
            Matrix newMatrix = Matrix.create(getNumRows(), getNumColumns());
            for (int i = 0; i < getNumRows(); i++) {
                for (int j = 0; j < getNumColumns(); j++) {
                    newMatrix.set(i, j, get(i,j) + other.get(i, j));
                }
            }
            return newMatrix;
        }
        else {
            throw new MatrixException(String.format("Matrix is not the same size"));
        }
    }

    /**
     * Multiplies this matrix by another.
     * @param other the other matrix to multiply
     * @return a new matrix that is the product of this matrix and other
     * @throws MatrixException if the number of columns in this matrix does not
     * match the number of rows in the other
     */
    @Override
    public Matrix multiply(Matrix other) {
        if (this.getNumColumns() == other.getNumRows()) {
            Matrix solution = Matrix.create(this.getNumRows(), other.getNumColumns());
            int sum = 0;
            for (int i = 0; i < other.getNumColumns(); i++) {
                for (int j = 0; j < this.getNumRows(); j++) {
                    solution.set(i, j, sum);
                    for (int p = 0; p < this.getNumColumns(); p++) {
                        solution.set(i, j, (solution.get(i,j)) + (this.get(i, p) * other.get(p, j)));
                    }
                }
            }
            
            return solution; 
        }
        else {
            throw new MatrixException(String.format("Cannot, multiply, the rows of matrix 1 is not equal to the columns of matrix 2"));
        }
    }
    
    /**
     * Private instance fields follow
     */

    private int numRows;
    private int numColumns;

}