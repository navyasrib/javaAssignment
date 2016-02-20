class Matrix {
	private int row;
	private int column;
	private int[][] elements;
	
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

	public Matrix add(Matrix operandMatrix) {
		int[][] operands = operandMatrix.elements;
		Matrix result = new Matrix(this.row, this.column);
		int[] sum = new int[this.row * this.column];
		int count = 0;
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.column; j++) {
				sum[count] = this.elements[i][j] + operands[i][j];
				count++;
			}
		}
		result.insertData(sum);
		return result;
	}

	public Matrix multiply(Matrix operandMatrix) {
		int sum = 0;
		int[][] operands = operandMatrix.elements;
		Matrix result = new Matrix(this.row, this.row);
		int[] data = new int[this.row * this.row];
		int count = 0;
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.row; j++) {
				for (int k=0; k<this.column ;k++ ) {
					sum += this.elements[i][k] * operands[k][j];
				}
				data[count] = sum;
				count++;
				sum = 0;
			}
		}
		result.insertData(data);
		return result;
	}

	public int determinant() {
		int det = 0;
		if(this.row == 1 && this.column == 1)
			det = this.elements[0][0];
		if(this.column == 2 && this.row == 2)
			det = (this.elements[0][0]*this.elements[1][1]) - (this.elements[1][0]*this.elements[0][1]);
		return det;
	}


	public boolean equals(Object other){
		if(!(other instanceof Matrix)) return false;
		Matrix matrix = (Matrix) other;
		if(this.row!=matrix.row || this.column!=matrix.column) return false;
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.column; j++) {
				if(matrix.elements[i][j] != this.elements[i][j])
					return false;
			}
		}
		return true;
	}
}

