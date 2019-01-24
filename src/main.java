import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class main {
    public static void main(String[] abc) throws IOException {

        System.out.println("Write first character of tree");
        String first = askString();
        System.out.println("Write second character of tree");
        String second = askString();
        System.out.println("Write high  of tree");
        int a = askInteger();
        tree(first, second, a - 3);
        creatFile();
        treeToFile( first, second, a - 3);

    }

    /**method for tree
     */
    public static void tree( String first, String second, int a) {
         String isEvenOrOdd="";

        System.out.println("I");

        for (int i = 0; i <= a; i++) {

            isEvenOrOdd = i % 2 == 0 ? (isEvenOrOdd+first) :  isEvenOrOdd+second;
            System.out.println(isEvenOrOdd);
        }
        System.out.println("M");
    }

    /**Creat a file
     * @throws IOException
     * check if is exist or not
     */
    public static void creatFile() throws IOException {
        // creat a file
        File file = new File(getRelativPathAdr("tree.txt"));

        if (!file.exists()) {
            System.out.println("There is no file");
            file.createNewFile();
            System.out.println("file created");

        }

    }
    /**Write tree to file
     * @throws IOException
    */
    public  static void treeToFile( String first, String second, int a) throws IOException {
        String isEvenOrOdd="";

        FileWriter fw = new FileWriter( getRelativPathAdr("tree.txt"));
        BufferedWriter fileoutput = new BufferedWriter(fw);
        fileoutput.write("I"+"\n" );
        for (int i = 0; i <=a; i++) {

            isEvenOrOdd = i % 2 == 0 ? (isEvenOrOdd+first) :  isEvenOrOdd+second;
            fileoutput.write( isEvenOrOdd);
            fileoutput.newLine();
        }
        fileoutput.write("M");
        fileoutput.close();
        fw.close();
    }

    /**Creat a relativ path adress
     */
    public static String getRelativPathAdr(String pathName){

        return new File(pathName).getAbsolutePath();
    }


    public static String askString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static Integer askInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

}
