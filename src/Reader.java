import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader implements Medium {
    private File file = new File("C:\\Users\\windows 10\\IdeaProjects\\untitled3\\baza.txt");


    @Override
    public void write(String user, long dataId, String data) throws Exception {
        String content =  dataId + "/" + user + "/"  + data + "\n";


        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException:", e);
        }

    }

    @Override
    public String read(String user, long dataId) throws Exception {

        File file = new File("baza.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            String[] transaction=string.split("/");

            if(transaction[1].equals(dataId) ){
                return string;
            }

            System.out.println(sc.nextLine());
        }

        return "";
    }

    @Override
    public List<String> read(String user) throws Exception {
        File file = new File("baza.txt");
        Scanner sc = new Scanner(file);
        List<String> transactions = new ArrayList<>();

        while (sc.hasNextLine()){
            String string = sc.nextLine();
            String[] transaction = string.split("/");

            if(transaction[0].equals(user)){
                transactions.add(string);
            }
        }


        return transactions;
    }

}