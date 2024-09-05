package hcu.info.cne.isd_kadai2_g20138;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class User extends AppCompatActivity {

    public String userID;
    public String name;

    public ArrayList<String> Books;


    User(){
        userID = "No information.";
        name = "No information.";
        Books= new ArrayList<>();
    }

    public String toString(){
        return "ID: " + userID + " Name: " + name;
    }
}

