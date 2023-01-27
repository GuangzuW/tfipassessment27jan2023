package assessment;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Data data=new Data();

        data.readData(data, args[0]);

        data.printTop10(data);

    }
}