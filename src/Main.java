import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    ArrayList<ProcessBuilder> listaBuilder = new ArrayList<>();
    listaBuilder.add(new ProcessBuilder("cat","file.txt"));
    listaBuilder.add(new ProcessBuilder("wc", "-l"));

    try{
        List<Process> listaProcess = ProcessBuilder.startPipeline(listaBuilder);
        Process ultimoProcess = listaProcess.get(listaProcess.size()-1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(ultimoProcess.getInputStream()));
        String out="";
        String line;
        line = reader.readLine();
        while(line != null){
            out = out + line;
            line = reader.readLine();
        }

        System.out.println("numero de lineas: " + out);
    }catch (IOException e){
        System.out.println("Error");
    }


    }
}