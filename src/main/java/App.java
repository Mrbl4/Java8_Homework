import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    List<Person> persons = new ArrayList<>();

    public void readPersons(){

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/in.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(", ");
//                for (int i = 0; i < info.length; i++) {
//                    System.out.println(info[i]);
//                }
                persons.add(new Person(info));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listPersons(){
//        try (FileOutputStream fos = new FileOutputStream("src/main/resources/out.txt");
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos)){
//                    for(Person p: persons) {
//                    objectOutputStream.writeBytes(p.getFirstName() + " " + p.getLastName());
//                    //objectOutputStream.writeObject(p);}
            try{
               PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/out.txt"));
               for (Person p: persons){
                   //System.out.println(p.getFirstName() + " " + p.getLastName());
                    out.write(p.getFirstName() + " " + p.getLastName());
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
    }

