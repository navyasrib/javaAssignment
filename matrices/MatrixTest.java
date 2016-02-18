import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Arrays;

public class MatrixTest {
	@Test
	public void shouldInsertTheElementsInToAMatrix() {
	 	Matrix matrix = new Matrix(2,3);
	 	int[] allElements = {1,2,3,4,5,6};
	 	matrix.insertData(allElements);
	 	int[] result = {{1,2,3},
	 					  {4,5,6}};
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
	 	int[][] result = matrix1.add(matrix2);
	 	assertEquals(result[0][0], 2);
	 	assertEquals(result[0][1], 4);
	 	assertEquals(result[0][2], 6);
	 	assertEquals(result[1][0], 8);
	 	assertEquals(result[1][1], 10);
	 	assertEquals(result[1][2], 12);
	}
}