package controllers;
import javax.swing.JOptionPane;
import entity.Product;
import entity.User;
import types.UserType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

    Scanner input;
    Shop shop;

    public Menu() {
        shop = new Shop();
        input = new Scanner(System.in);
        addDefaultUsers();
        addDefaultProduct();
    }


    public void showHomeScreen() {

        String option;
//        JOptionPane.showMessageDialog(null,
//                "\nWelcome to the SHOP!!!"
//                + "\n1. Add User \t\t4. Add Product"
//                + "\n2. View Users \t\t5. View Products"
//                + "\n3. Remove User \t\t6. Buy Product"
//                + "\n7. Exit shop");
        System.out.println("\nWelcome to the SHOP!!!"
                + "\n1. Add User \t\t4. Add Product"
                + "\n2. View Users \t\t5. View Products"
                + "\n3. Remove User \t\t6. Buy Product"
                + "\n7. Exit shop");

//        option = JOptionPane.showInputDialog("\nChoose Options: ");
        System.out.print("\nChoose Options: ");
        option = input.nextLine();

        switch (option) {
            case "1":
                collectUserInfoAndAddUser();
                break;
            case "2":
                showAllUsers();
                break;
            case "3":
                deleteUser();
                break;
            case "4":
                collectProductInfoAndAddProduct();
                break;
            case "5":
                showAllProducts();
                break;
            case "6":
                sellProductToUser();
                break;
            case "7":
                return;
            default:
                break;
        }
        this.showHomeScreen();// rekursija, kamer nebus ievadits 7

    }

    private void deleteUser() {
        System.out.print("Enter user email: ");
        String userEmail = input.nextLine();

        System.out.println(shop.deleteUser(userEmail) + "\n");

        showAllUsers();
    }

    public void addDefaultUsers() {
        shop.createUser(new User("Nastya", "n@n.lv",100.50f,UserType.OWNER,LocalDate.of(2020,3,11)));
        shop.createUser(new User("Gusts", "g@g.lv",345.50f,UserType.OWNER,LocalDate.of(2020,3,27)));
        shop.createUser(new User("Alex", "a@a.lv",-45.50f,UserType.BUYER,LocalDate.of(2020,7,7)));
        shop.createUser(new User("Lera", "l@l.lv",45.67f,UserType.BUYER,LocalDate.of(2020,12,30)));
        shop.createUser(new User("Sveta", "s@s.lv",2.45f,UserType.BUYER,LocalDate.of(2020,9,23)));

    }

    private void collectUserInfoAndAddUser() {

//        String name = JOptionPane.showInputDialog("Enter User Name: ");
        System.out.print("Enter User Name: ");
        String name = input.nextLine();

//        String email = JOptionPane.showInputDialog("Enter User email: ");
        System.out.print("Enter User email: ");
        String email = input.nextLine();

//        float balance = Float.parseFloat(JOptionPane.showInputDialog("Enter User Balance: "));
        System.out.print("Enter User Balance: ");
        float balance = Float.parseFloat(input.nextLine());

//        JOptionPane.showInputDialog("Enter User Type (Owner/Buyer): ");
//        UserType type =  (input.nextLine().trim().toUpperCase().equals("O")) ? UserType.OWNER : UserType.BUYER;
        System.out.print("Enter User Type (Owner/Buyer): ");
        UserType type = (input.nextLine().trim().toUpperCase().equals("O"))     // ja vairak neka ko salidzinat, tad iss pieraksts neder
                ? UserType.OWNER : UserType.BUYER;

        LocalDate createdAt = LocalDate.now();

        User user = new User(name, email, balance, type, createdAt);

//        JOptionPane.showMessageDialog(null,shop.createUser(user));
        System.out.println(shop.createUser(user));
    }

    private void showAllUsers() {

        ArrayList<User> users = shop.getUsers();
//        JOptionPane.showMessageDialog(null,"ALL AVAILABLE USERS");
        System.out.println("ALL AVAILABLE USERS");

        for (User currentUser: users) {
//            JOptionPane.showMessageDialog(null,currentUser.getName() +
//                    " | " + currentUser.getEmail() +
//                    " | " + currentUser.getBalance() +
//                    " | " + currentUser.getType() +
//                    " | " + currentUser.getCreatedAt());
            System.out.println(currentUser.getName() +
                    " | " + currentUser.getEmail() +
                    " | " + currentUser.getBalance() +
                    " | " + currentUser.getType() +
                    " | " + currentUser.getCreatedAt());
        }
    }

    public void addDefaultProduct() {

        Product milk = new Product();
        milk.setId(UUID.randomUUID());
        milk.setName("Milk");
        milk.setPrice(1.18f);
        milk.setQuantity(100);
        milk.setDiscount(10);
        shop.createProduct(milk);

//        Product water = new Product();
//        milk.setId(UUID.randomUUID());
//        milk.setName("Water");
//        milk.setPrice(2.2f);
//        milk.setQuantity(5);
//        milk.setDiscount(30);
//        shop.createProduct(water);

    }

    private void collectProductInfoAndAddProduct() {
        Product product = new Product();

        product.setId(UUID.randomUUID());

        System.out.print("Enter Product Name: ");
        product.setName(input.nextLine());

        System.out.print("Enter Product Price: ");
        product.setPrice(Float.parseFloat(input.nextLine()));

        System.out.print("Enter Product Quantity: ");
        product.setQuantity(Integer.parseInt(input.nextLine()));

        System.out.print("Enter Product Discount: ");
        product.setDiscount(Integer.parseInt(input.nextLine()));

        System.out.println(shop.createProduct(product));
    }

    private void showAllProducts() {
        ArrayList<Product> products = shop.getProducts();
        System.out.println("ALL AVAILABLE PRODUCTS");
        for (Product currentProduct: products) {
            System.out.println(//currentProduct.getId() +
                    " | " + currentProduct.getName() +
                    " | " + currentProduct.getPrice() +
                    " | " + currentProduct.getQuantity() +
                    " | " + currentProduct.getDiscount());
        }
    }

    private void sellProductToUser(){
        /*
         * Know who user is
         * what user is buying
         * How many copies user is buying
         * do we have enough product to sell
         * does user have enough balance
         * deduct users balance
         * deduct product from total available products
         * */
        System.out.println("Enter your registered email address: ");
        String userEmail = input.nextLine();

        System.out.println("Enter product name: ");
        String nameOfProduct = input.nextLine();

        System.out.println("How many items: ");
        Integer numOfItems = Integer.parseInt(input.nextLine());

        System.out.println(shop.buyProduct(userEmail, nameOfProduct, numOfItems));


    }
}

