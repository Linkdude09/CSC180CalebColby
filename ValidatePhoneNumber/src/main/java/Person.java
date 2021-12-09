import java.util.regex.*;

public class Person {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!GoodNumber(phoneNumber)){
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phoneNumber;
    }

    private boolean GoodNumber(String phoneNumber) {
        Pattern ptrn = Pattern.compile("[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]");
        Matcher match = ptrn.matcher(phoneNumber);
        return (match.find() && match.group().equals(phoneNumber));
    }


}
