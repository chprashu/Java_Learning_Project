package learn.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionInfo {

    /*
     * Exception: It is an event which disrupts the flow of execution in runtime.
     * Java allows to handle the exception using try and catch block.
     * try{
     * 
     * } catch(Exception(or any specific type of Exception) e){
     * handle exception here...
     * }
     * catch can be handled directly by mentioning Exception on behalf of all
     * type of exceptions, since Exception is the parent class of all exceptions.
     *
     */

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Integer[] numerators = { 10, null, 6, 3 };
        int[] denominators = { 2, 1, 0, 3 };
        for (int i = 0; i < numerators.length; i++) {
            /*
             * There are some exceptions which returns infinite in Arithmetic
             * java handle them by throwing ArithmeticException
             * like anything / 0 returns infinite.
             * This can be handled through try/catch
             *
             * catch can be nested if you want to handle
             * multiple exceptions
             *
             */
            try {
                System.out.println(numerators[i] / denominators[i]);
            } catch (ArithmeticException e) {
                System.out.println("An arithmetic exception thrown due to dividing " + numerators[i] + " / "
                        + denominators[i] + " : " + e);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }

        try {
            FileReader fileReader = new FileReader("data.txt");
            System.out.println(fileReader.getEncoding());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        try {
            demo("throw");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    /*
     * we can create custom Exception by
     * declaring which type of Exception it is.
     *
     * if we add throws in method declaration with Exception name which is
     * likely to be thrown by this method, java force you to
     * handle that Exceptions while invoking the method.
     */
    private static String demo(String val) throws CustomException {
        if (val.intern() == "throw") {
            throw new CustomException("Something went wrong");
        }
        return val;
    }
}
