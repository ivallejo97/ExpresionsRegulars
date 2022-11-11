import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionsRegulars {
    public static void main(String[] args) {
        String pareNoel = "\\*<]:-DOo";
        String rens = ">:o\\)";
        String follets = "<]:-D";

        try {
            FileReader file = new FileReader("C://Users//ivall//Documents//MP3//ExpresionsRegulars//src//santako");
            BufferedReader buff = new BufferedReader(file);
            boolean nextLine = false;
            while (!nextLine) {
                String line = buff.readLine();
                if (line == null) {
                    break;
                } else {
                    Pattern iniciarPareNoel = Pattern.compile(pareNoel);
                    Matcher buscarPareNoel = iniciarPareNoel.matcher(line);
                    int numPareNoel = 0;
                    while (buscarPareNoel.find()) {
                        numPareNoel++;
                    }

                    Pattern iniciarRens = Pattern.compile(rens);
                    Matcher buscarRens = iniciarRens.matcher(line);
                    int numRens = 0;
                    while (buscarRens.find()) {
                        numRens++;
                    }

                    Pattern iniciarFollet = Pattern.compile(follets);
                    Matcher buscarFollet = iniciarFollet.matcher(line);
                    int numFollets = 0;
                    while (buscarFollet.find()) {
                        numFollets++;
                    }
                    numFollets -= numPareNoel;


                    if (numPareNoel > 0) {
                        System.out.print("Pare Noel " + "(" + numPareNoel + ") ");
                    }

                    if (numRens > 0) {
                        System.out.print("Rens " + "(" + numRens + ")");
                    }

                    if (numFollets > 0) {
                        System.out.print("Follet " + "(" + numFollets + ")");
                    }
                    System.out.println();

                    nextLine = false;
                }
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
