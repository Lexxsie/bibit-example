package database;

import models.User;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserDataStore {
    private static final String FILE_NAME = "users.json";

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("users.json tidak ditemukan, membuat file baru.");
            saveUsers(users); // buat file kosong []
            return users;
        }

        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<User>>() {}.getType();
            users = new Gson().fromJson(reader, listType);
            if (users == null) {
                users = new ArrayList<>(); // kalau parsing null, buat list baru
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca users.json: " + e.getMessage());
        } catch (com.google.gson.JsonSyntaxException e) {
            System.out.println("Format users.json rusak, reset ke kosong.");
            users = new ArrayList<>();
            saveUsers(users); // reset ke []
        }
        return users;
    }

    public static void saveUsers(List<User> users) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            new Gson().toJson(users, writer);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan users.json: " + e.getMessage());
        }
    }
}
