import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setPhoneNumber() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                Person TPer = new Person();
                TPer.setPhoneNumber("801-555-7709");
            }
        });


        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Person TPer = new Person();
                TPer.setPhoneNumber("Lorem Ipsum");
            }
        });

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Person TPer = new Person();
                TPer.setPhoneNumber("901-678-987n");
            }
        });
    }
}