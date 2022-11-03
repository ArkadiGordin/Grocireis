/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import entity.History;
import entity.Product;
import java.util.GregorianCalendar;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class HistoryManager {
    private final Scanner scanner;

    public HistoryManager() {
        scanner = new Scanner(System.in);
    }
    
    public History purchase(Product[] products, Customer[] customers){
        System.out.println("Список читателей: ");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(i+1+". "+customers[i].getFirstname()+" "+customers[i].getLastname());
        }
        System.out.print("Выбери читателя: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список книг: ");
        for (int i = 0; i < products.length; i++) {
            System.out.print(i+1+". "+products[i].getBookName()+". ");
            for (int j = 0; j < products[i].getAuthors().length; j++) {
                System.out.printf("%s %s %d", 
                        products[i].getname(),
                        products[i].getname(),
                        products[i].getPrice());

            }
            System.out.println();
        }
        System.out.print("Выбери номер продукта: ");
        int numberBook = scanner.nextInt();scanner.nextLine();
        History history = new History();
        history.setProduct(products[numberBook - 1]);
        history.setCustomer(customers[numberReader-1]);
        history.setPurchase(new GregorianCalendar().getTime());
        return history;
    }
    
    public void printReadingBooks(History[] histories){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getReturnBook() == null){
                System.out.print(i+1+". "+histories[i].getBook().getProductName()+". ");
                for (int j = 0; j < histories[i].getBook().getCustomers().length; j++) {
                    System.out.printf("%s %s %d", 
                            histories[i].getProduct().getCustomers()[j].getFirstname(),
                            histories[i].getProduct().getCustomers()[j].getLastname(),
                            histories[i].getProduct().getCustomers()[j].getMoney()
                    );
                }
                System.out.println();
            }
        }
    }

    public History[] returnProduct(History[] histories) {
        //выбрать номер истории с возвращаемой книгой
        //вставить текущую дату в поле returnBook
        System.out.println("Список выданных книг: ");
        this.printReadingBooks(histories);
        History[] histiries = null;
        return histiries;
        }
    
    
}
