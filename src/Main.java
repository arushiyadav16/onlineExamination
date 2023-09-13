import java.util.*;
class onlineExam{
    private String username;
    private String password;
    private String fullName;
    private String email;

    public onlineExam(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public static void startExam() {
        return;
    }

    public String getUsername() {
        return username;
    }
    public void updatePassword(String newPassword) {
        password = newPassword;
    }
    public String getPassword() {

        return password;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    // Constructor
    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    public String getQuestionText() {
        return questionText;
    }
    public List<String> getOptions() {
        return options;
    }
    public boolean isCorrectOption(int selectedOption) {
        return selectedOption == correctOption;
    }
}
class Exam {
    private List<Question> questions;
    private int durationInMinutes;

    // Constructor
    public Exam(List<Question> questions, int durationInMinutes) {
        this.questions = questions;
        this.durationInMinutes = durationInMinutes;
    }

    // Method to start the exam
    public void startExam() {
        Scanner scanner = new Scanner(System.in);
        int totalMarks = 0;

        System.out.println("Welcome to the exam!");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());

            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Select your answer (1-" + options.size() + "): ");
            int selectedOption = scanner.nextInt();

            if (question.isCorrectOption(selectedOption)) {
                totalMarks++;
            }
        }

        System.out.println("Exam completed!");
        System.out.println("Total Marks: " + totalMarks);
    }
}

 class OnlineExamSystem {
    public static void main(String[] args) {

        // Sample user and questions
        onlineExam onlineExamination = new onlineExam("oasis", "Infobyte", "Oasis Infobyte","oasisinfobyte15@gmail.com");
        List<Question> questions = new ArrayList<>();
        System.out.println("Login");
        System.out.print("Username: ");

        String enteredUsername = new Scanner(System.in).nextLine();
        System.out.print("Password: ");
        String enteredPassword = new Scanner(System.in).nextLine();

        if (enteredUsername.equals(onlineExamination.getUsername()) && enteredPassword.equals(onlineExamination.getPassword())) {
            System.out.println("Login successful!");

            // Profile Update
            System.out.println("1. Update Profile");
            System.out.println("2. Start Exam");
            System.out.print("Select an option: ");
            int option = new Scanner(System.in).nextInt();

            if (option == 1) {
                System.out.print("Enter new full name: ");
                String newFullName = new Scanner(System.in).nextLine();
                onlineExamination.setFullName(newFullName);

                System.out.print("Enter new email: ");
                String newEmail = new Scanner(System.in).nextLine();
                onlineExamination.setEmail(newEmail);

                System.out.println("Profile updated successfully!");
            } else if (option == 2) {
                onlineExam.startExam();
            }
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }


        questions.add(new Question("Were you a bird, you ______________ in the sky.?\n", Arrays.asList("would fly", "shall fly", "should fly", "shall have flown"), 1));
        questions.add(new Question("The Central Rice Research Station is situated in?", Arrays.asList("Chennai", "Cuttack", "Bangalore", "Quilon"), 2));

        // Create an exam
        Exam exam = new Exam(questions, 15); // 15 minutes duration

        // Simulate user login
        // In a real system, you would authenticate user credentials
        System.out.println("Login");
        System.out.print("Username: ");
        enteredUsername = new Scanner(System.in).nextLine();
        System.out.print("Password: ");
        enteredPassword = new Scanner(System.in).nextLine();

        if (enteredUsername.equals(onlineExamination.getUsername()) && enteredPassword.equals(onlineExamination.getPassword())) {
            System.out.println("Login Successful!");
            exam.startExam();
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}
