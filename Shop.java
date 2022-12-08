import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop extends Bank implements ITippable, IDiscountCard {
  private String Name;
  private int CustomersServed;
  private int TimesRobbed;
  public List<Product> Products;

  @Override
  public int ApplyDiscount(int prod_left) {
    return 50 / (prod_left == 0 ? 1 : prod_left);
  }

  @Override
  public void Tip(Bank bank) {
    int TipValue = Math.abs((int) (bank.GetMoney() * 0.05));

    if (TipValue > this.GetMoney()) {
      System.out.println("The shop can't tip. No money.");
      return;
    }
    System.out.println(
        "Shop " + this.GetName() + " has tipped " + TipValue + "$ for delivery/inspection");
    this.SetMoney(this.GetMoney() - TipValue);
    bank.SetMoney(bank.GetMoney() + TipValue);
  }

  public String GetName() {
    return Name;
  };

  public void SetName(String Name) {
    this.Name = Name;
  };

  public Product ServeCustomer(int Index) {
    Random rand = new Random();
    Product prod;
    int rand_product = -1;

    switch (Index) {
      case 0:
      case 1:
      case 2: {
        rand_product = rand.nextInt(3 - 0) + 0;
        break;
      }
      case 3:
      case 4:
      case 5: {
        rand_product = rand.nextInt(6 - 3) + 3;
        break;
      }
      case 6:
      case 7:
      case 8: {
        rand_product = rand.nextInt(9 - 6) + 6;
        break;
      }
    }
    if (rand_product > Products.size())
      ServeCustomer(Index);

    prod = Products.get(rand_product);

    Products.get(rand_product).Subtract();

    System.out.println("There are " + prod.GetQuantity() + " " + prod.GetName());

    return prod;
  };

  Shop(ConfigManager configManager) {
    Random rand = new Random();
    SetName("Chop-chop!");
    this.SetMoney(configManager.GetValue("ShopBank")); // EXPORT TO CFG
    CustomersServed = 0;
    TimesRobbed = 0;

    Products = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      Product _prod = new Product();
      Products.add(_prod);
    }
  }
}