import java.util.Scanner;

public class CalculateDeposit {
    double calculateComplexPercent(double a, double b, int c) {
        double pay = a * Math.pow((1 + b / 12), 12 * c);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow
                (10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateIncome() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double income = 0;
        if (action == 1) income = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            income = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {

        new CalculateDeposit().calculateIncome();
    }


}
