import java.util.Iterator;

public class Scanner2Iterable implements Iterable<String> {

    private AdapterScanner s;
    private int i;

    public Scanner2Iterable(AdapterScanner s,int i){
        this.s=s;
        this.i=i;

    }



    public static void afficheIterable(Scanner2Iterable it) {
        for (var x : it)
            System.out.println(x);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < i && s.hasNext();
            }

            @Override
            public String next() {
                count++;
                return s.next();
            }
        };
    }
}
