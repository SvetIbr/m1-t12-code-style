import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.getResultOfDeposit();
    }
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double resultOfDeposit = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(resultOfDeposit, 2);
    }
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }
    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    void getResultOfDeposit() {
        int period;
        int action;
        double resultOfDeposit = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада: 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            resultOfDeposit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            resultOfDeposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultOfDeposit);
    }
}
