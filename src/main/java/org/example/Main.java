package org.example;
import javax.swing.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ingreso");
        frame.setContentPane(new Notas().ingre);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}