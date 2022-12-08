import java.util.Random;

public class DeliveryGuy extends Customer {
  int delivery_quantity;

  public void TryDeliver(Shop shop) {
    Random rand = new Random();

    for (int i = 0; i < shop.Products.size(); ++i) {
      Product prod = shop.Products.get(i);

      if (prod.GetQuantity() < 1) {
        int price_to_pay =
            (int) (delivery_quantity * prod.GetPrice() / shop.ApplyDiscount(prod.GetQuantity()));
        prod.SetQuantity(delivery_quantity);

        if (shop.GetMoney() < price_to_pay) {
          System.out.println(("The shop couldn't order " + delivery_quantity + " " + prod.GetName()
              + " because they do not have money."));
          break;
        }
        shop.SetMoney(shop.GetMoney() - price_to_pay);

        System.out.println(
            GetName() + " has delivered " + delivery_quantity + " " + prod.GetName());
      }
    }

    return;
  }

  DeliveryGuy(ConfigManager configManager) {
    super();
    delivery_quantity = configManager.GetValue("DeliveryQuantity");
    SetMoney(new Random().nextInt(5500 - 2500) + 2500);
  }
}