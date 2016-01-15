package com.goeuro.test.common.helper;

/**
 * Helper class for utility methods required by the application. The class will
 * contain only static methods. Hence, the class is declared as final with a
 * private constructor.
 * 
 * @author Ayushi
 *
 */
public final class Helper {

	private Helper() {
	};

	/**
	 * Accepts the error message. Displays the error message and then makes a
	 * call to System.exit(0), to exit the application.
	 * 
	 * @param errorMessage
	 *            : The error message to be displayed to the user.
	 */
	public static void displayErrorMessageAndExit(String errorMessage) {
		System.out.println(errorMessage);
		System.exit(0);
	}

}
