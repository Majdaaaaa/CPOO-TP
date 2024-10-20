import java.util.Iterator;
import java.util.Scanner;

public class AdapterScanner implements Iterator<String> {


    private Scanner scan;

    public AdapterScanner(Scanner scan) {
        this.scan = scan;
    }

    // @Override
    // public Iterator<String> iterator() {
    //     return new Iterator<String>() {

    //         @Override
    //         public boolean hasNext() {
    //             return scan.hasNext();
    //         }

    //         @Override
    //         public String next() {
    //             return scan.nextLine();
    //         }
            
    //     };
    // }


    @Override
    public boolean hasNext() {
        System.out.print("> ");
        return scan.hasNext();
    }

    @Override
    public String next() {
        return scan.nextLine();
    }

    public void close(){
        scan.close();
    }



}
