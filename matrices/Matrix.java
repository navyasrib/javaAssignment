class Matrix {
	int row;
	int column;
	int[][] elements;
	public Matrix(int rows, int columns) {
		row = rows;
		column = columns;
	}

	public void insertData(int[] data) {
		elements = new int[row][column];
		int count = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				elements[i][j] = data[count];
				count++;
			}
		}
	}

	public boolean isSameOrder(Matrix operandMatrix){
		return (this.row == operandMatrix.row) && (this.column == operandMatrix.column);
	}

	public int[][] add(Matrix operandMatrix) {
		if(isSameOrder){
			int[][] operands = operandMatrix.populateData();
			int[][] result = new int[this.row][this.column];
			for (int i=0; i<this.row; i++) {
				for (int j=0; j<this.column; j++) {
					result[i][j] = this.elements[i][j] + operands[i][j];
				}
			}
			return result;
		}	
	}

	public int[][] multiply(Matrix operandMatrix) {
		int sum = 0;
		int[][] operands = operandMatrix.populateData();
		int[][] result = new int[this.row][this.row];
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.row; j++) {
				for (int k=0; k<this.column ;k++ ) {
					sum += this.elements[i][k] * operands[k][j];
				}
				result[i][j] = sum;
				sum = 0;
			}
		}
		return result;
	}

	public int[][] populateData() {
		return elements;
	}
}

