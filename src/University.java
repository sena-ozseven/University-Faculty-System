import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class University {

    // 1. These are called "FIELDS"
    private Long id;
    private final String name;  // 1.1 Final fields cannot have setter methods.
    private List<Faculty> faculties;


    // 2. Since 'name' is final, we must initialize it through a constructor.
    public University(Long id, String name) {
        this.id = id;

                // if (name == null || name.isBlank() || name.isEmpty()) {
                    //throw new IllegalArgumentException("Name cannot be null, empty or blank.");
                // }
                //--> this is against to the single responsibility principle.
                // Meaning, this is not a responsibility for the University class.
                //To make this control, we create a new java class named "Utility" or "Validator".

        this.name = name;
        // 2.1 Initialize faculties as an empty list to avoid null pointer issues later.
        this.faculties = new ArrayList<>(); //Defensive copy

    }
    //when we want to call this class, we have to give a name to the constructor
    // by writing "new University("bogazici")" on the main class.
    // after doing that, we can no longer write "new University()"
    // bc we do not have a constructor like this anymore.

    //1.5 -  2nd constructor -w/ OVERLOADING
    public University(Long id, String name, List<Faculty> faculties) {
        this(id, name);  //  Constructor chaining

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

    public Long getId() {
        return this.id;
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
    //     because this can add another faculties that are not belong to that universi ty
    //
    // 5.3 Safer alternatives:
    //     - Return an unmodifiable copy      --> e.g. Collections.unmodifiableList(this.faculties) -- read-only
    //     - Or return a deep copy if needed. --> e.g. return new ArrayList<>(this.faculties)

    //Thus, this is the best practice of the encapsulation: -- defensive copy
    public List<Faculty> getFaculties() {
        return Collections.unmodifiableList(this.faculties);
    }

    public void addFaculty(Faculty faculty) {
        if (faculty.getUniversity().equals(this)) {  //By this way, we can ONLY add faculties that are belong to the same university.
            this.faculties.add(faculty);
        }
    }

    public void removeFaculty(Faculty faculty) {
        this.faculties.remove(faculty);
    }

    @Override
    public String toString() {
        return "University name:  " + this.name;
    }

    @Override
    public boolean equals(Object obj) {                                                                             // this      ==    (obj)
        if (obj == this) { //if the coming obj's reference is equals to "this" (=this.university), return true. ==> workintech.equals(workintech)
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        University university = (University) obj; //--> DOWNCASTING
        return university.getId().equals(this.id ); //-------
    }                                                        //
    @Override                                               // these two must check the same fields -- in this case it is id.
    public int hashCode() {                                //
        return Objects.hash(this.id); //----------
    }

}
