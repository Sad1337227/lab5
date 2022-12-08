import java.util.Random;

public class RichCustomer extends Customer {
  RichCustomer() {
    SetMoney(new Random().nextInt(5500 - 2500) + 2500);
  }
}