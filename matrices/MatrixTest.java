import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Arrays;

public class MatrixTest {
	@Test
	public void shouldInsertTheElementsInToAMatrix() {
	 	Matrix matrix = new Matrix(2,3);
	 	int[] allElements = {1,2,3,4,5,6};
	 	matrix.insertData(allElements);
	 	int[][] result = {{1,2,3},{4,5,6}};
	 	assertTrue(matrix.isEqual(result));
	}
	@Test
	public void shouldAddAMartixWithOtherMatrixOfSameSize() {
	 	Matrix matrix1 = new Matrix(2,3);
	 	Matrix matrix2 = new Matrix(2,3);
	 	int[] matrices1 = {1,2,3,4,5,6};
	 	int[] matrices2 = {1,2,3,4,5,6};
	 	matrix1.insertData(matrices1);
	 	matrix2.insertData(matrices2);
	 	int[][] result = {{2,4,6},{8,10,12}};
	 	assertTrue(matrix1.add(matrix2).isEqual(result));
	}
	@Test
	public void multiplyTwoMatricesUnderSuitableConditions() {
	 	Matrix matrix1 = new Matrix(2,3);
	 	Matrix matrix2 = new Matrix(3,2);
	 	int[] matrices1 = {1,2,3,4,5,6};
	 	int[] matrices2 = {1,2,3,4,5,6};
	 	matrix1.insertData(matrices1);
	 	matrix2.insertData(matrices2);
	 	int[][] result = {{22,28},{49,64}};
	 	assertTrue(matrix1.multiply(matrix2).isEqual(result));
	}
}