package schema.save;

import schema.FullSchema;
import schema.Schema;

import java.io.*;

public class Saving {

    public Saving() {}

    public void Save(int id, FullSchema schema) {
        String filename = "schema" + id + ".ser";

        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(schema);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Download(String name) {
        Schema schema = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {

            fis = new FileInputStream(name);
            in = new ObjectInputStream(fis);
            schema = (Schema) in.readObject();
            in.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}
