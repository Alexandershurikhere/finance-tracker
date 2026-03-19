import java.util.HashMap;
import java.util.InputMismatchException;

import java.util.Scanner;

public class FinanceTracker {
   public static void main(String[] args){
       Scanner scanner=new Scanner(System.in);
      FinanceTracker financeTracker=new FinanceTracker();


       boolean flag=true;
       while (flag) {
           try {

               financeTracker.showMenu();
               int current=scanner.nextInt();
               scanner.nextLine();
               switch (current){
                   case 1:
                       System.out.println("Введите категорию:");
                       String cuurent = scanner.nextLine();

                       System.out.println("Введите сумму: ");
                       int money = scanner.nextInt();
                       scanner.nextLine();
                       financeTracker.saveExpense(cuurent, money);
                       break;

                   case 2:
                       financeTracker.printAllExpenses();
                       break;
                   case 3:
                       System.out.println("Вся сумма трат: "+ financeTracker.printAllSum());
                       break;
                   case 4:
                       flag=false;
                       break;
                   default:
                       System.out.println("Некоректный ввод");

               }







           } catch (InputMismatchException e) {
               System.out.println("Ошибка.Нужно,чтобы была цифра");
               scanner.nextLine();
           }

       }


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
        void showMenu(){
            System.out.println("\n--- Меню ---");
            System.out.println("1-Добавить трату");
            System.out.println("2-Показать все траты");
            System.out.println("3-Показать общую сумму");
            System.out.println("4-Выход");
        }

    }


