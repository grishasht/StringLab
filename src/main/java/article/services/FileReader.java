package article.services;

import java.io.*;

public class FileReader {
    /*Class which helps to read data from file in more convenient way*/
    public BufferedReader buffReader;

    /*Singleton pattern.
    * Was made for that case you want be sure that you open exactly
    * file you wanted and cursor wouldn't be reseted*/
    public static FileReader getInstance() {
        return FileReader.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final FileReader INSTANCE = new FileReader();
        private SingletonHolder() {
        }
    }

    public void openFile (String filePath) {
        try {
            buffReader = new BufferedReader(new java.io.FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("No such file!!!");
            e.printStackTrace();
        }
    }

    public String readFromFile () {
        String buff = null;
        try {
            buff = this.buffReader.readLine();
        } catch (IOException e) {
            System.out.println("No such file!!!");
            e.printStackTrace();
        }
        return buff != null ? buff : "";
    }

    public void closeFile (){
        try {
            buffReader.close();
        } catch (IOException e) {
            System.out.println("No such file!!!");
            e.printStackTrace();
        }
    }
}
