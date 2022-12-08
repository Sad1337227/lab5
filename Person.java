import java.util.Random;

abstract public class Person extends Bank {
  private String Name;

  public String GetName() {
    return Name;
  };
  public void SetName(String Name) {
    this.Name = Name;
  };

  Person() {
    Random rand = new Random();

    int rand_name_ind = rand.nextInt(Names.cust_names.length);
    SetName(Names.cust_names[rand_name_ind]);
  }
}