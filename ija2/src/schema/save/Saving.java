package schema.save;

import schema.Schema;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Saving {

    public Saving() {}

    public void Save(int id, Schema schema) {
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
}
