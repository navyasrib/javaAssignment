import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;

public class MatrixTest {
	@Test
	public void should_insert_the_elements_in_to_a_matrix() {
	 	Matrix matrix = new Matrix(2,3);
	 	int[] allElements = {1,2,3,4,5,6};
	 	matrix.insertData(allElements);
	 	Matrix otherMatrix = new Matrix(2,3);
	 	otherMatrix.insertData(allElements);
	 	int[][] result = {{1,2,3},{4,5,6}};
	 	assertEquals(matrix, otherMatrix);
	}
	@Test
	public void add_should_add_a_martix_with_other_matrix_of_same_size() {
	 	Matrix matrix1 = new Matrix(2,3);
	 	Matrix matrix2 = new Matrix(2,3);
	 	int[] matrices1 = {1,2,3,4,5,6};
	 	int[] matrices2 = {1,2,3,4,5,6};
	 	matrix1.insertData(matrices1);
	 	matrix2.insertData(matrices2);
	 	Matrix sumMatrix = matrix1.add(matrix2);
	 	Matrix expected = new Matrix(2,3);
	 	int[] result = {2,4,6,8,10,12};
	 	expected.insertData(result);
	 	assertEquals(sumMatrix, expected);
	}
	@Test
	public void multiply_two_matrices_under_suitable_conditions() {
	 	Matrix matrix1 = new Matrix(2,3);
	 	Matrix matrix2 = new Matrix(3,2);
	 	int[] matrices1 = {1,2,3,4,5,6};
	 	int[] matrices2 = {1,2,3,4,5,6};
	 	matrix1.insertData(matrices1);
	 	matrix2.insertData(matrices2);
	 	int[] result = {22,28,49,64};
	 	Matrix productMatrix = matrix1.multiply(matrix2);
	 	Matrix expected = new Matrix(2,2);
	 	expected.insertData(result);
	 	assertEquals(productMatrix, expected);
	}
	@Test
	public void should_give_determinant_of_1_by_1_matrix(){
		Matrix matrix1 = new Matrix(1,1);
		int[] matrices1 = {3};
		matrix1.insertData(matrices1);
		assertEquals(matrix1.determinant(),3);
	}
	@Test
	public void should_give_determinant_of_2_by_2_matrix(){
		Matrix matrix1 = new Matrix(2,2);
		int[] matrices1 = {1,2,3,4};
		matrix1.insertData(matrices1);
		assertEquals(matrix1.determinant(),-2);
	}
	@Test
	public void should_give_coefficient_matrix_of_first_element_in_3_by_3_matrix(){
		Matrix matrix1 = new Matrix(3,3);
		int[] matrices1 = {1,2,1,2,1,2,1,1,1};
		matrix1.insertData(matrices1);
		Matrix matrix2 = new Matrix(2,2);
		int[] matrices2 = {1,2,1,1};
		matrix2.insertData(matrices2);
		int index = 0;
		Matrix coMatrix = matrix1.coefficient(matrix1,index);
		assertTrue(coMatrix.equals(matrix2));
	}
	@Test
	public void should_give_coefficient_matrix_of_second_element_in_3_by_3_matrix(){
		Matrix matrix1 = new Matrix(3,3);
		int[] matrices1 = {1,2,1,2,1,2,1,1,1};
		matrix1.insertData(matrices1);
		Matrix matrix2 = new Matrix(2,2);
		int[] matrices2 = {2,2,1,1};
		matrix2.insertData(matrices2);
		int index = 1;
		Matrix coMatrix = matrix1.coefficient(matrix1,index);
		assertEquals(matrix2,coMatrix);
	}
	@Test
	public void should_give_coefficient_matrix_of_third_element_in_3_by_3_matrix(){
		Matrix matrix1 = new Matrix(3,3);
		int[] matrices1 = {1,2,1,2,1,2,1,1,1};
		matrix1.insertData(matrices1);
		Matrix matrix2 = new Matrix(2,2);
		int[] matrices2 = {2,1,1,1};
		matrix2.insertData(matrices2);
		int index = 2;
		Matrix coMatrix = matrix1.coefficient(matrix1,index);
		assertEquals(matrix2,coMatrix);
	}
	@Test
	public void should_give_determinant_of_3_by_3_matrix(){
		Matrix matrix1 = new Matrix(3,3);
		int[] matrices1 = {1,2,1,2,1,2,1,1,1};
		matrix1.insertData(matrices1);
		assertEquals(0, matrix1.determinant());
	}
	// @Test
	// public void should_give_determinant_of_4_by_4_matrix(){
	// 	Matrix matrix1 = new Matrix(4,4);
	// 	int[] matrices1 = {1,2,1,2,1,2,1,1,1,6,5,4,3,2,1,2};
	// 	matrix1.insertData(matrices1);
	// 	assertEquals(-8, matrix1.determinant());
	// }
}