package database;

import models.User;
import models.Product;
import models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Transaction> transactions = new ArrayList<>();
}
