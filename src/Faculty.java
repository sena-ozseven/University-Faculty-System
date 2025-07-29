public class Faculty {
    private String name;
    private University university;

    public  Faculty(String name, University university) {
        this.name = name;
        this.university = university;
        this.university.addFaculty(this); //Trick: add the faculty to the university that is sent.
                                         //note that this may not be the desired thing to do for all cases.
    }

    public University getUniversity() {
        return university;
    }

    public String getName() {
        return name;
    }
}
