import io.FilePersistence;
import io.IOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println(persistence.write("Lucas1;Lucas@gmail.com;17/12/2006"));
        System.out.println(persistence.write("Lucas2;Lucas@gmail.com;17/12/2006"));
        System.out.println(persistence.write("Lucas3;Lucas@gmail.com;17/12/2006"));
        System.out.println("====================");
        System.out.println(persistence.findAll());
    }
}
