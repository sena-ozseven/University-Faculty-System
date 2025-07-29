// Takes a String field and tells us if it is validated or not.
// There are 2 ways of doing this:
// 1 - It may return boolean.
// 2 - It may not return anything (void) and throw an error.

public class ValidationUtil  {

    // 1. way of doing this:
    public static boolean isValid(String field) {
        return field != null && !field.isBlank() ;  //return true if the field is not null, or it is not blank.
                                                    //note that "&& !field.isEmpty()" is redundant.
                                                    //BEST IF: "!field.isBlank()" is replaced with "!field.trim().isEmpty()";
    }

    // 2. way of doing this:
    public static void IsValid(String field, String message) {
        if (field == null || field.trim().isEmpty()) {
            throw new IllegalArgumentException(message);  //return to University.java class' constructor to see its application.
        }
    }

    //HOWEVER, those validations above raise a problem when the fields are different from each other. e.g.
    //in this case we only check the validity of the fields if and only if they are String.
    //but we know that our id is Long.
    //to make it inclusive, we use !!!!!JAVA GENERIC METHODS!!!!!
}
