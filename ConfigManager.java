import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ConfigManager {
  private class KeyPair {
    public String Key;
    public String Value;
    public KeyPair(String _Key, String _Value) {
      Key = _Key;
      Value = _Value;
      return;
    }
  }

  public ArrayList<KeyPair> KeyPairs = new ArrayList<KeyPair>();
  // area = "5"
  // pricepersqm = "5"

  public void AddKeyValue(String Key, String Value) {
    KeyPairs.add(new KeyPair(Key, Value));
  };

  public void Save() throws Exception {
    FileWriter writer = new FileWriter("vars.cfg");
    BufferedWriter buffer = new BufferedWriter(writer);

    String ToFile = "";
    for (int i = 0; i < KeyPairs.size(); ++i)
      ToFile += KeyPairs.get(i).Key + "=" + KeyPairs.get(i).Value + "\n";

    buffer.write(ToFile);
    buffer.close();

    System.out.println("Saved cfg to file");
  };

  public void Load() throws Exception {
    FileReader reader = new FileReader("vars.cfg");
    BufferedReader buffer = new BufferedReader(reader);

    String CurStr;
    while ((CurStr = buffer.readLine()) != null) {
      String Key, Value;
      Key = CurStr.split("=")[0];
      Value = CurStr.split("=")[1];
      KeyPairs.add(new KeyPair(Key, Value));
    }

    for (int i = 0; i < KeyPairs.size(); ++i)
      System.out.println(KeyPairs.get(i).Key + " = " + KeyPairs.get(i).Value);

    System.out.println("Loaded cfg from file");
  };

  public int GetValue(String Key) {
    for (int i = 0; i < KeyPairs.size(); ++i)
      if (KeyPairs.get(i).Key.equals(Key)) {
        return Integer.parseInt(KeyPairs.get(i).Value);
      }
    return -1;
  }
};
