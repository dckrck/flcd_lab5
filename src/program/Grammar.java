package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Grammar {
    private Set<String> N = new HashSet<>();
    private Set<String> E = new HashSet<>();
    private HashMap<String, Set<List<String>>> P = new HashMap<>();
    private String S = "";

    public Grammar(String file) {
        readFile(file);
    }

    public void readFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // first line (N)
            String currentLine = reader.readLine();
            String nonterminals[] = currentLine.split("=")[1].strip()
                    .replaceAll("\\{", "")
                    .replaceAll("}", "").strip().split(" ");

            this.N = new HashSet<>(Arrays.asList(nonterminals));

            /*
            Iterator itr = this.N.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }*/

            // second line
            currentLine = reader.readLine();
            String terminals[] = currentLine.split("=")[1].strip()
                    .replaceAll("\\{", "")
                    .replaceAll("}", "").strip().split(" ");

            this.E = new HashSet<>(Arrays.asList(terminals));

            /*
            itr = this.E.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }*/

            currentLine = reader.readLine();
            this.S = currentLine.split("=")[1].strip();

            //System.out.print(S);

            currentLine = reader.readLine();


            /*
            while(currentLine != null && currentLine != "}") {
                String tokens[] = currentLine.split("->");
                String lhs = tokens[0];
                String rhs[] = tokens[1].split("\\|");

                if(!P.containsKey(lhs)) {
                    P.put(lhs, new HashSet<>());
                }

                currentLine = reader.readLine();
            }
            */


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String printNonTerminals() {
        StringBuilder builder = new StringBuilder("N = { ");
        for(String nt : this.N)
            builder.append(nt).append(" ");
        builder.append(" }");
        return builder.toString();
    }

    public String printTerminals() {
        StringBuilder builder = new StringBuilder("E = { ");
        for(String e : this.E)
            builder.append(e).append(" ");
        builder.append(" }");
        return builder.toString();
    }

    public String getS() {
        return this.S;
    }

    public Set<String> getN() {
        return this.N;
    }

    public Set<String> getE() {
        return this.E;
    }

    public HashMap<String, Set<List<String>>> getP() {
        return this.P;
    }

}
