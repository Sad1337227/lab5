import java.util.Random;

abstract public class Bank {
  private int Money;

  public int GetMoney() {
    return Money;
  };

  public void SetMoney(int _Money) {
    Money = _Money;
    return;
  }

  Bank() {
    super();
    Money = 0;
  }
}