import java.util.Random;

public class Product {
  private String Name;
  private boolean ProdDate;
  private int Price;
  private int Quantity;

  public String GetName() {
    return Name;
  };
  public void SetName(String Name) {
    this.Name = Name;
  };

  public int GetPrice() {
    return Price;
  };
  public int GetQuantity() {
    return Quantity;
  };
  public void SetQuantity(int q) {
    Quantity = q;
    return;
  };
  public Boolean CanSell() {
    return Quantity > 0;
  };
  public void Subtract() {
    if (Quantity > 0)
      Quantity -= 1;
    return;
  }
  public boolean IsExpired() {
    return ProdDate;
  }

  Product() {
    Random rand = new Random();

    int rand_name_ind = rand.nextInt(Names.prod_names.length);
    Name = Names.prod_names[rand_name_ind];
    Quantity = rand.nextInt(5 - 1) + 1;
    Price = rand.nextInt(100 - 25) + 25;
    ProdDate = (rand.nextInt(50) % 2 == 0);
  }
}