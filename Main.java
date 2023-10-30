import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ExpenseType;
import model.User;
import model.expense.ExpenseData;
import model.split.EqualSplit;
import model.split.ExactSplit;
import model.split.Split;
import repository.ExpenseRepository;
import service.SplitWiseService;
import service.UserService;
import model.Type;

public class Main {
     public static void main(String[] args) {
        // Input Sample Users
        User user1 = new User(1, "A","ash@gmail.com","9891098911");
        User user2 = new User(2, "B","mansha@gmail.com","9486733009");
        User user3 = new User(3, "C","rimjhim@gmail.com","9891919199");
        User user4 = new User(4, "D","bhvah@gmail.com","6579933712");

        // Adding Expenses
        ExpenseRepository expenseRepository = new ExpenseRepository();
        UserService userService = new UserService(expenseRepository);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        SplitWiseService service = new SplitWiseService(expenseRepository);

        while (true) {
            Scanner scan = new Scanner(System.in);
            String[] commands = scan.nextLine().split(" ");
            Type type = Type.of(commands[0]);
            switch (type){
                case EXPENSE:
                    String userName = commands[1];
                    double amountSpend = Double.parseDouble(commands[2]);
                    int totalMembers = Integer.parseInt(commands[3]);
                    List<Split> splits = new ArrayList<>();
                    int expenseIndex = 3 + totalMembers + 1;
                    ExpenseType expense = ExpenseType.of(commands[expenseIndex]);
                    switch (expense){
                        case EQUAL:
                            for (int i = 0; i < totalMembers; i++) {
                                splits.add(new EqualSplit(userService.getUser(commands[4+i])));
                            }
                            service.addExpense(
                                    ExpenseType.EQUAL, amountSpend, userName, splits, new ExpenseData("GoaFlight")
                            );
                            break;
                        case EXACT:
                            for (int i = 0; i < totalMembers; i++) {
                                splits.add(
                                        new ExactSplit(
                                                userService.getUser(commands[4+i]),
                                                Double.parseDouble(commands[expenseIndex+i+1]))
                                );
                            }
                            service.addExpense(
                                    ExpenseType.EXACT, amountSpend, userName, splits, new ExpenseData("CabTickets")
                            );

                            break;

                    }
                    break;
                case SHOW:
                    if(commands.length == 1)
                        service.showBalances();
                    else
                        service.showBalance(commands[1]);
                    break;
                case QUIT:
                     System.out.println("Quiting...");
                     return;
                default:
                    System.out.println("No Expected Argument Found");
                    break;
            }

        }
    }
}
