import java.beans.Customizer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
  public static void print_int(String message, int sz) {
    System.out.println(message + sz);
    return;
  }
  public static void main(String[] args) throws Exception {
    ConfigManager configManager = new ConfigManager();

    configManager.Load();
    
    ArrayList<PoorCustomer> customers_p = new ArrayList<PoorCustomer>();
    ArrayList<MediumCustomer> customers_m = new ArrayList<MediumCustomer>();
    ArrayList<RichCustomer> customers_r = new ArrayList<RichCustomer>();
    ArrayList<Robber> robbers = new ArrayList<Robber>();
    DeliveryGuy delivery_guy = new DeliveryGuy(configManager);
    Inspector inspector = new Inspector();
    Rent rent = new Rent(configManager);
    Shop shop = new Shop(configManager);
    Random rand = new Random();

    for (int i = 0; i < 15; ++i) {
      customers_p.add(new PoorCustomer());
      customers_m.add(new MediumCustomer());
      customers_r.add(new RichCustomer());
      robbers.add(new Robber(configManager));
    }

    new java.util.Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        rent.Pay(shop);
      }
    }, 1, 3000 * 10);

    new java.util.Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        if (robbers.size() < 1)
          return;
        Random Rand = new Random();
        int rand_rob = Rand.nextInt(robbers.size());
        robbers.get(rand_rob).TryRob();
      }
    }, 1, 6000 * 10);

    while (true) {
      int rand_ind = -1;
      int rand_list = rand.nextInt(3);

      Product prod = shop.ServeCustomer(rand_list);

      switch (rand_list) {
        case 0: {
          if (customers_p.size() < 1)
            break;
          rand_ind = rand.nextInt(customers_p.size());
          Customer cust = customers_p.get(rand_ind);
          shop.SetMoney(shop.GetMoney() + cust.Buy(prod));
          cust.Tip(shop);
          break;
        }
        case 1: {
          if (customers_m.size() < 1)
            break;
          rand_ind = rand.nextInt(customers_m.size());
          Customer cust = customers_m.get(rand_ind);
          shop.SetMoney(shop.GetMoney() + cust.Buy(prod));
          cust.Tip(shop);
          break;
        }
        case 2: {
          if (customers_r.size() < 1)
            break;
          rand_ind = rand.nextInt(customers_r.size());
          Customer cust = customers_r.get(rand_ind);
          shop.SetMoney(shop.GetMoney() + cust.Buy(prod));
          cust.Tip(shop);
          break;
        }
      }

      delivery_guy.TryDeliver(shop);
      shop.Tip(delivery_guy);
      inspector.IssueDefect(shop);
      // shop.Tip(inspector);

      try {
        Thread.sleep(1000);
      } catch (Exception e) {
      }
    }
  }
}