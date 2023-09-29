package fishtank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Fish {
    private char sex;
    private String name;
    private String health;
    private ArrayList notebook = new ArrayList();

public Fish(String name, String health, char sex){
    setName(name);
    setHealth(health);
    this.sex = sex;
}

    private void setHealth(String health) {
    this.health = health;
}
    private void setName(String name) {
    this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getHealth() {
        return health;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void addNote(){
    String date = String.valueOf(LocalDateTime.now());

    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEnter note");
    String entry = scanner.nextLine();
        if (entry.length() <= 30) {
            notebook.add(date + "\n" + entry);
        } else {
            System.out.println("Note is too long (more than 30 characters).");
        }

    }
    public void getNotebook(){
        for(int i =0; i < notebook.size(); i++){
            System.out.println(notebook.get(i)+"\n");
    }}

    public void getLatestNote(){
        if(notebook.size() == 0) System.out.println("No entries");
        else System.out.println("\n"+notebook.get(notebook.size()-1));
    }


    public Fish makeNewFish(String name, String health, char sex) {
        return new Fish(name, health, sex);
    }
}
