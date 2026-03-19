import java.util.HashMap;
import java.util.InputMismatchException;

import java.util.Scanner;

public class FinanceTracker {
   public static void main(String[] args){
       Scanner scanner=new Scanner(System.in);
      FinanceTracker financeTracker=new FinanceTracker();



       while (true) {
           try {
               System.out.println("Введите категорию (введите exit для выхода):");
               String cuurent = scanner.nextLine();
               if (cuurent.equalsIgnoreCase("exit")) {
                   System.out.println("До свидания");
                   break;
               }

               if (cuurent.isEmpty()) {
                   System.out.println("Строка не дожна быть пустой");
                   continue;
               }
               System.out.println("Введите сумму: ");
               int money = scanner.nextInt();
               scanner.nextLine();
               financeTracker.saveExpense(cuurent, money);
               financeTracker.printAllExpenses();
               System.out.println("Вся сумма трат: "+ financeTracker.printAllSum());



           } catch (InputMismatchException e) {
               System.out.println("Ошибка.Нужно,чтобы была цифра");
               scanner.nextLine();
           }

       }
       scanner.close();

   }

       private HashMap<String,Integer> expenses=new HashMap<>();

        void saveExpense(String category,int money){
            int amount=expenses.getOrDefault(category,0);
            expenses.put(category,amount+money);


        }
        void printAllExpenses(){
            for(String key: expenses.keySet()){
                System.out.println(key+": "+ expenses.get(key)+" руб.");
            }
        }
        int printAllSum(){
            int total=0;
            for(int amount:expenses.values()){
                total=total+amount;
            }
            return total;
        }

    }

