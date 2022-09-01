public class StudentService  extends ServiceManager {
    public static Student[] students;
    public  void process() {
        int studentMenu = InputUtility.askInt("Select operation: \n" +
                "1.Registration \n" +
                "2.Search \n" +
                "3.Delete \n" +
                "4.Update \n" +
                "5.Show List\n" );

        if(studentMenu==1){
            register();
        } else if (studentMenu==2) {
            search();
        } else if (studentMenu==3) {
            delete();
        } else if (studentMenu==4) {
            update();
        } else if (studentMenu==5) {
            showAll();
        }else {
            System.out.println("Wrong operation : ");
        }
    }

    public void register(){
        int registerCout = InputUtility.askInt("Enter the number of students: ");
        students = new Student[registerCout];

        for(int i =0;i<registerCout;i++){
            students[i] = prepareStudent();
        }
    }

    public void search(){
        String search = InputUtility.askStirng("Enter name or surname: ");
        for(int i = 0; i< students.length; i++){
            Student student = students[i];
            if (StringUtility.containsIgnoreCase(student.getName(),search) ||
            StringUtility.containsIgnoreCase(student.getSurname(),search)){
                System.out.println(i+"."+student);
            }
        }
    }

    public void delete(){
        search();

        int studentNumber = InputUtility.askInt("Enter name or surname: ");

        students[studentNumber] = null;
        Student[] newStudents = new Student[students.length-1];
        int j = 0;
        for (int i = 0;i<students.length;i++){
            if(students[i] != null){
                newStudents[j] = students[i];
                j++;
            }
        }
            students = newStudents;
    }

    public void update(){
        search();

        int studentNumber = InputUtility.askInt("Enter name or surname: ");

        Student student = students[studentNumber];

        while(true){
            String field = InputUtility.askStirng("What information do you want to update?");
            if(field.equalsIgnoreCase("name")){
                student.setName(InputUtility.askStirng("Enter student name: "));
            } else if (field.equalsIgnoreCase("surname")) {
                student.setSurname(InputUtility.askStirng("Enter student surname:  "));
            } else if (field.equalsIgnoreCase("age")) {
                student.setAge(InputUtility.askInt("enter age of student: "));
            } else if (field.equalsIgnoreCase("scholarship")) {
                student.setScholarship(InputUtility.askDouble("Enter scholarship of student: "));
            } else if (field.equalsIgnoreCase("university")) {
                University university = new University();
                university.setName(InputUtility.askStirng("Enter university of student:  "));
                student.setUniversity(university);
            }else if (field.equalsIgnoreCase("done"))  {
                break;
            }
        }

    }

    public void showAll(){
        for(int i =0;i< students.length;i++){
            System.out.println(i+"."+ students[i]);
        }
    }

    private static Student prepareStudent(){
        Student student = new Student();

        student.setName(InputUtility.askStirng("Enter student name: "));
        student.setSurname(InputUtility.askStirng("Enter student surname: "));
        student.setAge(InputUtility.askInt("Enter age of student: "));
        student.setScholarship(InputUtility.askDouble("Enter scholarship of student: "));

        University university = new University();
        university.setName(InputUtility.askStirng("Enter university of student:  "));

        student.setUniversity(university);
        return student;
    }
}
