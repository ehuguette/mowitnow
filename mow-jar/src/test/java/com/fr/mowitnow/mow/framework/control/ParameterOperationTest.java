package com.fr.mowitnow.mow.framework.control;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.DataGenerator;
import com.fr.mowitnow.mow.framework.constant.Constant;
import com.fr.mowitnow.mow.framework.constant.EnumAction;
import com.fr.mowitnow.mow.framework.constant.EnumDirection;
import com.fr.mowitnow.mow.framework.context.Actions;
import com.fr.mowitnow.mow.framework.context.Coordinates;
import com.fr.mowitnow.mow.framework.context.MowField;
import com.fr.mowitnow.mow.framework.context.MowParameters;
import com.fr.mowitnow.mow.framework.context.MowsParameters;
import com.fr.mowitnow.mow.framework.exception.ClientMowException;

/**
 * {@link ParameterOperation} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class ParameterOperationTest {

	/** The ParameterOperation tested class. */
	private ParameterOperation parameterOperation;

	/**
	 * Set up before test.
	 */
	@Before
	public final void setUp() {
		parameterOperation = new ParameterOperation();
	}

	/**
	 * Test for method {@link ParameterOperation#getParamaters(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testGetParamaters() throws ClientMowException {
		String move = "5 5\n1 0 N\nD\n";

		// Field
		MowField resultField = DataGenerator.generateDefaultMowField(5, 5);

		// Mower
		MowsParameters resultsPositions = new MowsParameters();
		MowParameters resultParameters = new MowParameters(1, 0,
				EnumDirection.N);
		Actions actions = new Actions();
		actions.getList().add(EnumAction.D);
		resultParameters.setMowField(resultField);
		resultParameters.setActions(actions);

		resultsPositions.getList().add(resultParameters);

		MowsParameters parameters = parameterOperation.getParamaters(move);
		Assert.assertEquals(resultsPositions, parameters);
	}

	/**
	 * Test for method {@link ParameterOperation#checkParametersFormat(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testCheckFormatOk() throws ClientMowException {
		String move = "5 5\n1 0 N\nD\n";
		boolean chekFormat = parameterOperation.checkParametersFormat(move);
		Assert.assertEquals(Boolean.TRUE, chekFormat);
	}

	/**
	 * Test for method {@link ParameterOperation#checkParametersFormat(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testCheckFormatForTwoMowOk() throws ClientMowException {
		String move = "5 5\n1 0 N\nD\n5 0 S\nD\n";
		boolean chekFormat = parameterOperation.checkParametersFormat(move);
		Assert.assertEquals(Boolean.TRUE, chekFormat);
	}

	/**
	 * Test for method {@link ParameterOperation#checkParametersFormat(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testCheckFormatKo() throws ClientMowException {
		String move = "5 5\n1 0 N\n\nD\n";
		boolean chekFormat = parameterOperation.checkParametersFormat(move);
		Assert.assertEquals(Boolean.FALSE, chekFormat);
	}

	/**
	 * Test for method {@link ParameterOperation#checkParametersFormat(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testCheckFormatWithoutActionKo() throws ClientMowException {
		String move = "5 5\n1 0 N\n\n";
		boolean chekFormat = parameterOperation.checkParametersFormat(move);
		Assert.assertEquals(Boolean.FALSE, chekFormat);
	}

	/**
	 * Test for method {@link ParameterOperation#checkParametersFormat(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testCheckFormatWithLimitFieldOnlyKo()
			throws ClientMowException {
		String move = "5 5\n";
		boolean chekFormat = parameterOperation.checkParametersFormat(move);
		Assert.assertEquals(Boolean.FALSE, chekFormat);
	}

	/**
	 * Test for method {@link ParameterOperation#checkParametersFormat(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test(expected = NullPointerException.class)
	public void testCheckNPE() throws ClientMowException {
		String move = null;
		parameterOperation.checkParametersFormat(move);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractLimitTopRightCoordinates(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testExtractLimitTopRightCoordinatesOk()
			throws ClientMowException {
		Coordinates resultCoordinates = new Coordinates(5, 5);
		String moveMessage = "5 5\n1 0 N\n\n";
		Coordinates extractCoordinates = parameterOperation
				.extractLimitTopRightCoordinates(moveMessage);
		Assert.assertEquals(resultCoordinates, extractCoordinates);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractLimitTopRightCoordinates(String)}.
	 * 
	 * @throws ClientMowException
	 */
	@Test(expected = ClientMowException.class)
	public void testExtractLimitTopRightCoordinatesKo()
			throws ClientMowException {

		String moveMessage = "5 \n1 0 N\n\n";
		parameterOperation.extractLimitTopRightCoordinates(moveMessage);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractMowsParameters(String, String, MowField)}
	 * .
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testExtractMowsParametersOk() throws ClientMowException {

		final MowField resultField = DataGenerator.generateDefaultMowField(5,
				5);
		final MowsParameters resultMowsParameters = new MowsParameters();
		final MowParameters resultMowParameters1 = new MowParameters(1, 0,
				EnumDirection.N);
		final Actions actions1 = new Actions();
		actions1.getList().add(EnumAction.D);
		actions1.getList().add(EnumAction.A);
		resultMowParameters1.setMowField(resultField);
		resultMowParameters1.setActions(actions1);
		final MowParameters resultMowParameters2 = new MowParameters(5, 0,
				EnumDirection.S);
		final Actions actions2 = new Actions();
		actions2.getList().add(EnumAction.G);
		actions2.getList().add(EnumAction.A);
		resultMowParameters2.setMowField(resultField);
		resultMowParameters2.setActions(actions2);

		resultMowsParameters.getList().add(resultMowParameters1);
		resultMowsParameters.getList().add(resultMowParameters2);

		final String moveMessage = "5 5\n1 0 N\nDA\n5 0 S\nGA\n";
		MowsParameters mowParameters = parameterOperation.extractMowsParameters(
				moveMessage, DataGenerator.generateDefaultMowField(5, 5));
		Assert.assertEquals(resultMowsParameters, mowParameters);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractMowParameters(String, String, MowField)}
	 * .
	 * 
	 * @throws ClientMowException
	 */
	@Test
	public void testExtractMowParametersOk() {
		final MowParameters resultParameters = new MowParameters(1, 0,
				EnumDirection.N);
		final Actions actions = new Actions();
		actions.getList().add(EnumAction.D);
		resultParameters.setActions(actions);
		resultParameters
				.setMowField(DataGenerator.generateDefaultMowField(5, 5));

		final String mowPosition = "1 0 N";
		final String mowAction = "D";
		final MowParameters mowParameters = parameterOperation
				.extractMowParameters(mowPosition, mowAction,
						DataGenerator.generateDefaultMowField(5, 5));
		Assert.assertEquals(resultParameters, mowParameters);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractMowsParameters(String, String, MowField)}
	 * .
	 * 
	 * @throws ClientMowException
	 */
	@Test(expected = ClientMowException.class)
	public void testExtractMowsParametersWithoutPositionKo()
			throws ClientMowException {

		final String moveMessage = "1 0 \nD\n";
		parameterOperation.extractMowsParameters(moveMessage,
				DataGenerator.generateDefaultMowField(5, 5));
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractMowsParameters(String, String, MowField)}
	 * .
	 * 
	 * @throws ClientMowException
	 */
	@Test(expected = ClientMowException.class)
	public void testExtractMowsParametersWithoutActionKo()
			throws ClientMowException {

		final String moveMessage = "1 0 N\n\n";
		parameterOperation.extractMowsParameters(moveMessage,
				DataGenerator.generateDefaultMowField(5, 5));
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractMowsParameters(String, String, MowField)}
	 * .
	 * 
	 * @throws ClientMowException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExtractMowsParametersWithoutFieldKo()
			throws ClientMowException {

		final String moveMessage = "1 0 N\nD\n";
		parameterOperation.extractMowsParameters(moveMessage, null);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractPatternMatcher(String, String)}.
	 */
	@Test
	public void testExtractPatternMatcherFieldOk() {
		final List<String> resultParams = new ArrayList<>();
		resultParams.add("5 5");

		final String moveMessage = "5 5\n1 0 N\n\n";
		final List<String> extractParams = parameterOperation
				.extractPatternMatcher(moveMessage,
						Constant.MSG_LIMIT_FIELD_REGEX);
		Assert.assertEquals(resultParams, extractParams);
	}

	/**
	 * Test for method
	 * {@link ParameterOperation#extractPatternMatcher(String, String)}.
	 */
	@Test
	public void testExtractPatternMatcherMowOk() {
		final List<String> resultParams = new ArrayList<>();
		resultParams.add("1 0 N\nD\n");

		final String moveMessage = "5 5\n1 0 N\nD\n";
		final List<String> extractParams = parameterOperation
				.extractPatternMatcher(moveMessage,
						Constant.MSG_MOW_PARAMS_REGEX);
		Assert.assertEquals(resultParams, extractParams);
	}

}
