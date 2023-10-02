public class ContactProfile implements java.io.Serializable{
    private String name, email;
    private int phoneNumber;

    public ContactProfile(String name, String email, int phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber =phoneNumber;
    }
    public  String toString(){
        return "Contact Name: "+ name +"\nEmail: "+ email +"\nPhone Number: "+ phoneNumber;
    }
}