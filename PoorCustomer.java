import java.util.Random;

public class PoorCustomer extends Customer {
  PoorCustomer() {
    SetMoney(new Random().nextInt(500 - 250) + 250);
  }
}