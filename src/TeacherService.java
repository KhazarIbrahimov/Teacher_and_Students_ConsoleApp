public class TeacherService extends ServiceManager {

    public static Teacher[] teachers ;
    public void process() {
        int teacherMenu = InputUtility.askInt("Select operation: \n" +
                "1.Registration \n" +
                "2.Search \n" +
                "3.Delete \n" +
                "4.Update \n" +
                "5.Show list \n" );

        if(teacherMenu==1){
            register();
        } else if (teacherMenu==2) {
            search();
        } else if (teacherMenu==3) {
            delete();
        } else if (teacherMenu==4) {
            update();
        } else if (teacherMenu==5) {
            showAll();
        }else {
            System.out.println("Wrong operation : ");

        }
    }

    public void register(){
        int registerCout = InputUtility.askInt("Enter the number of teachers: ");
        teachers = new Teacher[registerCout];

        for(int i =0;i<teachers.length;i++){
            teachers[i] = prepareTeacher();
        }
    }
    public void search(){
        String search = InputUtility.askStirng("Enter name or surname: ");
        for(int i = 0; i< teachers.length; i++){
            Teacher teacher = teachers[i];
            if (StringUtility.containsIgnoreCase(teacher.getName(),search) ||
                    StringUtility.containsIgnoreCase(teacher.getSurname(),search)){
                System.out.println(i+"."+teacher);
            }
        }
    }

    public void delete(){
        search();

        int teacherNumber = InputUtility.askInt("Enter name or surname: ");

        teachers[teacherNumber] = null;
        Teacher[] newTeachers = new Teacher[teachers.length-1];
        int j = 0;
        for (int i = 0;i<teachers.length;i++){
            if(teachers[i] != null){
                newTeachers[j] = teachers[i];
                j++;
            }
        }
        teachers = newTeachers;
    }

    public void update(){
        search();

        int teacherNumber = InputUtility.askInt("Enter name or surname: ");

        Teacher teacher = teachers[teacherNumber];

        while(true){
            String field = InputUtility.askStirng("What information do you want to update?");
            if(field.equalsIgnoreCase("name")){
                teacher.setName(InputUtility.askStirng("Enter teacher name: "));
            } else if (field.equalsIgnoreCase("surname")) {
                teacher.setSurname(InputUtility.askStirng("Enter teacher surname:  "));
            } else if (field.equalsIgnoreCase("age")) {
                teacher.setAge(InputUtility.askInt("Enter age of teacher: "));
            } else if (field.equalsIgnoreCase("salary")) {
                teacher.setSalary(InputUtility.askDouble("Enter salary of teacher: "));
            } else if (field.equalsIgnoreCase("university")) {
                University university = new University();
                university.setName(InputUtility.askStirng("Enter university of techer: "));
                teacher.setUniversity(university);
            } else if (field.equalsIgnoreCase("done"))  {
                break;
            }
        }
    }

    public void showAll(){
        for(int i =0;i< teachers.length;i++){
            System.out.println(i+"."+teachers[i]);
        }
    }

    private static Teacher prepareTeacher(){
        Teacher teacher = new Teacher();

        teacher.setName(InputUtility.askStirng("Enter teacher name: "));
        teacher.setSurname(InputUtility.askStirng("Enter teacher surname:  "));
        teacher.setAge(InputUtility.askInt("Enter age of teacher: "));
        teacher.setSalary(InputUtility.askDouble("Enter salary of teacher: "));

        University university = new University();
        university.setName(InputUtility.askStirng("Enter university of techer:"));

        teacher.setUniversity(university);
        return teacher;
    }
}
