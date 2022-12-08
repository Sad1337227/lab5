import java.util.Random;
import java.util.Timer;

public class Rent {
  private int Area;
  private int PricePerSqM;

  public void Pay(Shop _shop) {
    System.out.println(Area * PricePerSqM / 10 + " has been payed");
    _shop.SetMoney(_shop.GetMoney() - (int) (Area * PricePerSqM / 1000));
    return;
  }

  Rent(ConfigManager configManager) {
    Random rand = new Random();

    Area = configManager.GetValue("Area"); // EXPORT TO CFG
    PricePerSqM = configManager.GetValue("PricePerSquareMeter"); // EXPORT TO CFG
  }
}