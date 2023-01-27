package assessment;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        
        Data data=new Data();
        data.getData(data, args[0]);
        data.printTop10(data);

    }
}