import java.util.ArrayList;
import java.util.Random;

public class Inspector extends Person {
  private int Defections;

  public int GetDefections() {
    return Defections;
  };

  public void IssueDefect(Shop _shop) {
    for (int i = 0; i < _shop.Products.size(); ++i)
      if (_shop.Products.get(i).IsExpired()) {
        _shop.Products.get(i).Subtract();
        Defections++;
      }
  }

  Inspector() {
    super();
    Defections = 0;
    SetMoney(new Random().nextInt(5500 - 2500) + 2500);
  }
}