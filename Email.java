import java.util.*;
public class Email {
    //Email class variables
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int passLength = 10;
    private String company = "company.com";
    private int emailCapacity = 50;
    private String altEmail = "";
    private String email;

    //Constructor method
    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(passLength);
        this.email = this.firstName + this.lastName + "@" + this.department + company;
    }

    //Sets department choice based on user choice
    private String setDepartment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Departments\n1 Sales\n2 Development\n3 Accounting\n0 None \nEnter department: ");
        int choice = input.nextInt();
        if (choice == 1) {
            return "sales";
        } else if (choice == 2) {
            return "development";
        } else if (choice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    //Generates random password for user email
    private String randomPassword(int length){
        String password = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%&*";
        char[] pass = new char[length];
        for (int i = 0; i < length; i++){
            int random = (int) (Math.random() * password.length());
            pass[i] = password.charAt(random);
        }
        return new String(pass);
    }

    //Displays user profile information
    public String info(){
        String information = "Name: " + this.firstName + " " + this.lastName + "\nEmail: " + this.email + "\nPassword: "
                             + getPassword() + "\nEmail capacity: " + getEmailCapacity() + "\nALternate Email: " + getAlternateEmail() + "\n";
        return information;
    }

    //Set methods that updates respective class variables
    public void setPassword(String pass){
        this.password= pass;
        System.out.println("Password updated");
    }
    public void setAlternateEmail(String newEmail){this.altEmail = newEmail;}
    public void setEmailCapacity(int length){this.emailCapacity = length;}

    //Get methods that displays respective class variable values
    public int getEmailCapacity(){return this.emailCapacity;}
    public String getPassword(){return this.password;}
    public String getAlternateEmail(){return this.altEmail;}
    public String getName(){return this.firstName + " " + this.lastName;}
}
