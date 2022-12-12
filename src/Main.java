import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final String EXIT_PROGRAM = "4";
        int earning = 0;    // доходы
        int spending = 0;   // расходы
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                printDelim();
                String input = scanner.nextLine();
                int operation = Integer.parseInt(input);
                if (input.equals(EXIT_PROGRAM)) {
                    break;
                }
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr1 = scanner.nextLine();
                        earning += Integer.parseInt(moneyStr1);
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        String moneyStr2 = scanner.nextLine();
                        spending += Integer.parseInt(moneyStr2);
                        break;
                    case 3:
                        taxPayment(earning, spending);
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода, вы ввели не число\n" +
                        "Выберете категорию");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static void printDelim() {
        System.out.println("-------------------------------\n" +
                "Выберите операцию и введите её номер:\n" +
                "1. Добавить новый доход\n" +
                "2. Добавить новый расход\n" +
                "3. Выбрать ситему налогооблажения\n" +
                "4. Выход\n" +
                "-------------------------------");
    }

    public static int taxEarningAndSpending(int earning, int spending) {
        int tax15 = (earning - spending) * 15 / 100; // Доходы - расходы * 15 /100
        return Math.max(tax15, 0);
    }

    public static int taxEarningOnly(int earnings) {
        int tax6 = (earnings) * 6 / 100; // Доходы * 6 /100
        return Math.max(tax6, 0);
    }

    public static void taxPayment(int earning, int spending) {
        int tax6 = taxEarningOnly(earning);
        int tax15 = taxEarningAndSpending(earning, spending);
        System.out.println("Всего доход: " + earning + "\n" +
                "Всего расход: " + spending);
        if (tax6 < tax15) {
            System.out.println("Мы советуем Вам УСН доходы\n" +
                    "Ваш налог сотавит: " + tax6 + " рублей\n" +
                    "Налог в другой системе: " + tax15 + " рублей\n" +
                    "Экономия: " + (tax15 - tax6) + " рублей");
        } else {
            System.out.println("Мы советуем Вам УСН доходы минус расходы\n" +
                    "Ваш налог сотавит: " + tax15 + " рублей\n" +
                    "Налог в другой системе: " + tax6 + " рублей\n" +
                    "Экономия: " + (tax6 - tax15) + " рублей");
        }
    }
}
