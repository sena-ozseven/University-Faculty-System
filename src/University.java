import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {

    // 1. These are called "FIELDS"
    private final String name;  // 1.1 Final fields cannot have setter methods.
    private List<Faculty> faculties;


    // 2. Since 'name' is final, we must initialize it through a constructor.
    public University(String name) {
        this.name = name;
        // 2.1 Initialize faculties as an empty list to avoid null pointer issues later.
        this.faculties = new ArrayList<>();

    }
    //when we want to call this class, we have to give a name to the constructor
    // by writing "new University("bogazici")" on the main class.
    // after doing that, we can no longer write "new University()"
    // bc we do not have a constructor like this anymore.

    //1.5 -  2nd constructor -w/ OVERLOADING
    public University(String name, List<Faculty> faculties) {
        this(name);  // 3.1 Calls the other constructor to set the 'name'.

        //we do NOT want to write:
        //this.faculties = faculties
        //      BECAUSE it holds the reference of the faculties that are sent to it from the outer source.
        //      that means, if the outcoming list is changed, then our list will change eventually, and we do not want that.
        //      THUS, instead of referencing the passed list directly...
        //      (which could be modified from outside and affect internal data),
        //      we create a new list with the same contents.
        //INSTEAD, we write:
        this.faculties = new ArrayList<>(faculties);
        //      by doing that, we are creating a new MEMORY ADDRESS
        //      we are converting the outcoming list into an arraylist.

    }

    //4. OOP Principle - ENCAPSULATION -->
    // 4.1 Provide a public getter method to access the private 'name' field.

    public String getName() {
        return this.name;
    }

    // 5. Important Note: Avoid exposing mutable lists directly via getter.
    // 5.1 For example, this would allow external modification:
    //
    //     public List<Faculty> getFaculties() {
    //         return this.faculties;
    //     }
    //
    // 5.2 This would allow:
    //     university.getFaculties().add(...); // Not safe!
    //
    // 5.3 Safer alternatives:
    //     - Return an unmodifiable copy      --> e.g. Collections.unmodifiableList(this.faculties) -- read-only
    //     - Or return a deep copy if needed. --> e.g. return new ArrayList<>(this.faculties)

    public List<Faculty> getFaculties() {
        return Collections.unmodifiableList(this.faculties);
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }
    public void removeFaculty(Faculty faculty) {
        this.faculties.remove(faculty);
    }

}
