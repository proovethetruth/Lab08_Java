public class UsualMatrix {
    int matrix[][];
    int length = 0;
    int width = 0;

    UsualMatrix() {
        length = 1;
        width = 1;
        matrix = new int[length][width];
    }

    public UsualMatrix(int a, int b) throws MatrixExeption {
        length = a;
        width = b;
        if(width <= 0 || length <= 0)
            throw new MatrixExeption("Incorrect input. Width and length must be bigger than zero");
        matrix = new int[width][length];
    }

    public UsualMatrix(UsualMatrix a) {
        length = a.getLength();
        width = a.getWidth();
        if(width <= 0 || length <= 0)
            throw new MatrixExeption("Incorrect input. Width and length must be bigger than zero");
        matrix = new int[width][length];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < length; j++) {
                matrix[i][j] = a.getElement(i, j);
            }
        }
    }

    final public boolean equals(UsualMatrix input) {
        if((width != input.getWidth()) || (length != input.getLength()))
            return false;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                if(this.getElement(i, j) != input.getElement(i, j))
                    return false;
            }
        }
        return true;
    }
    
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void fillWithRnd() {
        for(int i = 0; i < width; i++) {
            matrix[i][rnd(0, length - 1)] = rnd(1, 9);
        }
    }

    public static int rnd(int min, int max) {
	    max -= min;
	    return (int) (Math.random() * ++max) + min;
    }

    public void setElement(int row, int column, int value) throws MatrixExeption {
        if((row < 0) || (column < 0))
            throw new MatrixExeption("Incorrect input. Row and column must be bigger of equal to zero");
        matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        if((row < 0) || (column < 0))
            throw new MatrixExeption("Incorrect input. Row and column must be bigger of equal to zero");
        return matrix[row][column];
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < length; j++) {
                str.append(matrix[i][j]);
                str.append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public UsualMatrix product(UsualMatrix input) {
        if(input.getWidth() != length)
            throw new MatrixExeption("Incorrect arguments. Length of the first matrix must be equal to width of the second matrix");
            UsualMatrix result = new UsualMatrix(input.getLength(), width);
        int tmp = 0;
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < input.getLength(); j++) {
                for(int k = 0; k < length; k++)
                    tmp += this.getElement(i, k) * input.getElement(k, j);
                result.setElement(i, j, tmp);
                tmp = 0;
            }
        }
        return result;
    }
}
