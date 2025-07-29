import java.util.List;
import java.util.Set;

public class University {

    // those are called as "FIELDS"
    private final String name;  //final fields cannot have a setter method.
    private Set<Faculty> faculties;


    //after making the name field final, we have to make a constructor aligning with the
    //...permanency of the name field. thus we are writing a constructor:
    public University(String name) {
        this.name = name;
    }
    //when we want to call this class, we have to give a name to the constructor
    //by writing "new University("Bogazici University") on the main class.
    //after doing that, we can no longer write "new University()"
    // bc we do not have a constructor like this anymore.

    //2nd constructor - OVERLOADING (..the first constructor)
    public University(String name, List<Faculty> faculties) {
        this(name); //--> calls the "this.name = name" line on the first constructor.
        //we do NOT want to write:
        //this.faculties = faculties

    }

    //OOP - ENCAPSULATION -->
    // Making the private fields accessible to other classes...
    // ...by providing public setter and getter methods.
    public String getName() {
        return this.name;
    }



}
