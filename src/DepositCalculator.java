import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double coefficient, int period) {
        // переменную coefficient лучше назвать yearRate потому что это по сути годовая ставка 6%
        // *как в методе calculateSimplePercent;
       double pay = amount * Math.pow ((1 + coefficient / 12), 12 * period); // над 4 пробела при отступе;

       return getScale(pay, 2); // 4 пробела
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         return getScale(amount + amount * yearRate * depositPeriod, 2); // 4 пробела;
    }

    double getScale(double value, int places) {
        // метод стоит назвать типа round (от англ. to round - округлять) потому что он округляет значение
        // до 2 знаков после запятой. getScale не совсем отражает суть действия...
       double scale = Math.pow (10, places); // 4 пробела

       return Math.round (value * scale) / scale; // 4 пробела
    }

    void setDeposit() {
      int period;// 4 пробела
      int action;// 4 пробела

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
      int amount = scanner.nextInt();// 4 пробела

      System.out.println("Введите срок вклада в годах:") ; // 4 пробела
        period = scanner.nextInt();

      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:"); // 4 пробела
        action = scanner.nextInt();

        double variable = 0;

        if (action == 1) {
            variable = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            variable = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + variable);
    }
    public static void main(String[] args) {

        new DepositCalculator().setDeposit();
    }
}
