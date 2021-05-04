package controllers;
import entity.Product;
import entity.User;

import java.util.ArrayList;

public class Shop {

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<User> users = new ArrayList<User>();

    public String createUser(User newUser){
        users.add(newUser);
//        JOptionPane.showMessageDialog(null,"User " + newUser.getName() + " created successfully");
        return "\nUser " + newUser.getName() + " created successfully";
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public String createProduct(Product newProduct){
        products.add(newProduct);
        return "\nProduct " + newProduct.getName() + " created successfully";
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
    // add product could be here
    // return all product could be here

    public String buyProduct(String productName, String userEmail, Integer numOfProduct){
        Product productToSell = findProductByName(productName);
        if(productToSell == null){
            return "Product not found";
        }
        if (productToSell.getQuantity() < numOfProduct) {
            return "Not enough item to fulfill your order";
        }

        User buyer = findUserByEmail(userEmail);
        if(buyer == null){
            return "User not found";
        }

        float buyerBalance = buyer.getBalance();
        float totalCostOfPurchase = productToSell.getPrice() * numOfProduct;

        if (buyer.getBalance() < (productToSell.getPrice() * numOfProduct)) {
            return "Not enough money to buy products";
        }

        buyer.setBalance(buyerBalance - totalCostOfPurchase);

        productToSell.setQuantity(productToSell.getQuantity() - numOfProduct);

        //update info to the list

        updateUser(buyer);
        updateProduct(productToSell);
        return "Product purchase successful";
    }

    private Product findProductByName(String nameOfProduct) {
        for (Product currentProduct: this.products){
            if(currentProduct.getName().toLowerCase().equals(nameOfProduct.toLowerCase())){
                return currentProduct;
            }
        }
        return null;
    }

    private User findUserByEmail(String userEmail) {
        for (User currentUser: this.users){
            if(currentUser.getEmail().toLowerCase().equals(userEmail.toLowerCase())){
                return currentUser;
            }
        }
        return null;
    }

    private void updateUser(User userToUpdate){
        for (User currentUser: this.users){
            if(currentUser.getId().equals(userToUpdate.getId())){
                currentUser.setBalance(userToUpdate.getBalance());
                // its possible to update something more here
            }
        }
    }

    private void updateProduct(Product productToUpdate){
        for (Product currentProduct: this.products){
            if(currentProduct.getId().equals(productToUpdate.getId())){
                currentProduct.setQuantity(productToUpdate.getQuantity());
            }
        }
    }

    public String deleteUser(String userEmail) {
        try {
            users.remove(userEmail);
        } catch (Exception ex) {
            return "Unable to remove specified user";
        }
        return "User with email " + userEmail + " removed successfully";
    }

}
