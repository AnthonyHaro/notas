package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Notas {
    JPanel ingre;
    private JTextField nombretext;
    private JTextField calitetxt;
    private JButton modifciarButton;
    private JButton ingresarButton;
    private JTextField matetext;

    public Notas() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= nombretext.getText();
                int nota= Integer.parseInt(calitetxt.getText());
                MongoClient mongoClient= MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("mydb2");
                MongoCollection<Document> collection = database.getCollection("Materias");
                Document document=new Document("Materia",matetext.getText())
                        .append("Nombre",nombre)
                        .append("Calificacion",nota);
                collection.insertOne(document);
                System.out.println("Clificacion ingresada");
                nombretext.setText("");
                calitetxt.setText("");
                matetext.setText("");
            }
        });
        modifciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Modificar");
                frame.setContentPane(new modifciar().modi);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400,300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
