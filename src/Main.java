public class Main {

    public static void main(String[] args) {

        while (true) {
            int menu = InputUtility.askInt("Select field: \n" +
                    "1.Teacher \n" +
                    "2.Student \n" +
                    "3.Exit ");


            ServiceManager service = null;
            if (menu == 1) {
                service = new TeacherService();
            } else if (menu == 2) {
                service = new StudentService();
            } else if (menu == 3) {
                System.exit(0);
            } else {
                System.out.println("Wrong operation");
            }

            if (menu == 1 || menu == 2) {
                service.process();
            }
        }
    }
}