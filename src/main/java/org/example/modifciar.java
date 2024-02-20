package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modifciar {
    JPanel modi;
    private JTextField textField1;
    private JTextField cali;
    private JButton modificarButton;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public modifciar() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("mydb2");
        collection = database.getCollection("Materias");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrebus = textField1.getText();
                int calif = Integer.parseInt(cali.getText());
                Document document = collection.findOneAndUpdate(Filters.eq("Nombre", nombrebus), Updates.set("Calificacion", calif));
                if (document != null) {
                    System.out.println("Calificación modificada");
                } else {
                    System.out.println("Estudiante no encontrado");
                }
            }
        });
    }
}