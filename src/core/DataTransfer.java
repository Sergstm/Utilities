package core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataTransfer {

    public List<String> getData() {
        String path = "src/core/dataIn.txt";
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeData(List<Service> list, boolean appendType) {
        String path = "src/core/dataOut.txt";
        File file = new File(path);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, appendType))) {
            String string = list.stream()
                    .map(elem -> elem.getDate() +"\t\t"+ elem.getVolume() +"\t\t "+ elem.getSum())
                    .collect(Collectors.joining("\n"));
            writer.write(string);
            System.out.println("Data Writing Success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void serialData(VolumeCounter vol) {
        String path = "src/core/dataOut.txt";
        File file = new File(path);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(vol);
            System.out.println("Serialize Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeData() {
        String path = "src/core/dataOut.txt";
        File file = new File(path);

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println(inputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }






}
