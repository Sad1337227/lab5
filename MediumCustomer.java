import java.util.Random;

public class MediumCustomer extends Customer {
  MediumCustomer() {
    SetMoney(new Random().nextInt(1500 - 500) + 500);
  }
}