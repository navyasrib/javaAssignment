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

	public Matrix coefficient(Matrix sample, int position) {
		int rows = sample.row-1;
		int columns = sample.column-1;
		Matrix coMatrix = new Matrix(rows, columns);
		int[] data = new int[rows * columns];
		int count = 0;
		for (int i=1; i<sample.row; i++) {
			for (int j=0; j<sample.column; j++) {
				if(j!=position){
					data[count] = sample.elements[i][j];
					count++;
				}
			}
		}
		coMatrix.insertData(data);
		return coMatrix;
	}

	private int getSign(int index) {
		return (index%2 == 0)? 1 : -1;
	}
	public int determinant() {
		int det = 0, sign;
		Matrix coMatrix;
		if(this.row == 1 && this.column == 1)
			return this.elements[0][0];
		if(this.column == 2 && this.row == 2)
			return (this.elements[0][0]*this.elements[1][1]) - (this.elements[1][0]*this.elements[0][1]);
		for (int i=0; i<this.row; i++) {
			sign = this.getSign(i);
			coMatrix = this.coefficient(this, i);
			det += sign * coMatrix.determinant();
		}
		return det;
	}

	public boolean equals(Object other){
		if(!(other instanceof Matrix)) return false;
		Matrix matrix = (Matrix) other;
		return this.equals(matrix);
	}

	public boolean equals(Matrix other){
		if(this.row!=other.row || this.column!=other.column) return false;
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.column; j++) {
				if(other.elements[i][j] != this.elements[i][j])
					return false;
			}
		}
		return true;
	}

	public String toString() {
		String data = "";
		for (int i=0; i<this.row; i++) {
			for (int j=0; j<this.column; j++) {
				data += this.elements[i][j];
			}
		}
		return data;
	}
}

