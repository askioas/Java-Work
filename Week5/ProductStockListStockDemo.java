package Week5;
import java.util.ArrayList;

//Declaration of Product Class
class Product {
    int productID;
    String productName;
    int productQuantity;
// Constructor of Product Class
public Product(int productID, String productName, int productQuantity) {
    this.productID = productID;
    this.productName = productName;
    this.productQuantity = productQuantity;}
// Getters for Product ID, Name and Quantity
public int getProductID() {return productID;}
public String getProductName() {return productName;}
public int getProductQuantity() {return productQuantity;}
// Setters for Product ID, Name and Quantity
public void setID(int productID) {this.productID = productID;}
public void setName(String productName) {this.productName = productName;}
public void setQuantity(int productQuantity) {this.productQuantity = productQuantity;}
// Print method for Product Class
public void print() {
    System.out.println("Product ID: " + productID + " | Product Name: " + productName + " | Product Quantity: " + productQuantity);

}}

//Declaration of StockList Class
class StockList {
    ArrayList<Product> stockProductList;
// Add Method for Stocklist Class
public void add(Product product) {stockProductList.add(product);}
// Remove Method for Stocklist Class
public void remove(Product product) {stockProductList.remove(product);}
// Find Method for Stocklist Class
public Product find(String productName) {
    int findCount = 0;
    while (findCount < stockProductList.size()) {if (stockProductList.get(findCount).getProductName().equals(productName)) {return stockProductList.get(findCount);}
    findCount++;
    }
    return null;
}
// Constructor of StockList Class
public StockList() {
    stockProductList = new ArrayList<Product>();
}}

// Declaration of StockDemo Class
class StockDemo {
    StockList stockList;
    // Constructor of StockDemo Class
    public StockDemo() {
            stockList = new StockList();
        stockList.add(new Product(1, "Blackberry", 30));
        stockList.add(new Product(2, "Elderberry", 50));
        stockList.add(new Product(3, "Strawberry", 16));
        System.out.println("New products added to Stock List.");}
// Test method for StockDemo Class to display products in Stock List
public void StockDemoPrintTest() {
    int testCount = 0;
    while (testCount < stockList.stockProductList.size()){
        stockList.stockProductList.get(testCount).print();
        testCount++;}}
// Test method for StockDemo Class to find product in Stock List
public void StockDemoFindTest(){
    Product foundProduct = stockList.find("Strawberry");
    if (foundProduct != null) {foundProduct.print();}
    else {System.out.println("Unable to find product in Stock List.");}}
// Test method for StockDemo Class to remove product from Stock List
public void StockDemoRemoveTest() {
    Product foundProduct = stockList.find("Elderberry");
    if (foundProduct != null) {stockList.remove(foundProduct);
    System.out.println("Product removed from Stock List.");}}
// Test Method to run the Print, Find and Remove tests from StockDemo Class
public void Run() {
    System.out.println("");
    System.out.println("Printing all products...");
    StockDemoPrintTest();
        System.out.println("");
    System.out.println("Finding specific attribute...");
    StockDemoFindTest();
        System.out.println("");
    System.out.println("Removing specific product...");
    StockDemoRemoveTest();}}
    
// Main code to run StockDemoTestRun
class Main {
    public static void main(String[] args){
        StockDemo stockDemo = new StockDemo();
        stockDemo.Run();
}}


