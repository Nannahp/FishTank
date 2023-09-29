package fishtank;

import java.util.ArrayList;
import java.util.Scanner;

public class RunProgram {
    ArrayList<FishTank> tanks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean runProgram = true;
    public static void main(String[] args) {
        new RunProgram().run();

    }

    private void run() {
        FishTank tank1 = new FishTank(1);
        tanks.add(tank1);

        Fish wogglie = new Fish("Wogglie", "Healthy", 'f');
        Fish swimmie = new Fish("Swimmie", "Healthy", 'f');

        tank1.addFish(wogglie);
        tank1.addFish(swimmie);

        /// Menu
        System.out.println("---WELCOME---");
        while(runProgram){
        startProgram();}

    }


    public void startProgram(){
        int count = 1;
        for (int i = 0; i < tanks.size(); i++) {
            count++;
            FishTank tank = tanks.get(i);
            System.out.println((i + 1) + ") Tank " + tank.getNumber());
        }
        System.out.println(count+") Add Tank");
        System.out.println((count+1)+") Quit program");
        int tankNumber = scanner.nextInt();
        if (tankNumber ==(count+1)) runProgram =false;
        else if (tankNumber ==(count)) addTank();
        else if ((tankNumber - 1) > tanks.size() - 1) {
            System.out.println("Tank doesn't exist, pleaser choose another tank");
        } else {
            FishTank tank = tanks.get(tankNumber - 1);
            enterTank(tank);
            int choice = scanner.nextInt();
            chooseNextOption(choice,tank);
    }}

    public void chooseNextOption(int choice, FishTank tank){
        switch (choice) {
            case 1:
                showTankChoices();
                int index = scanner.nextInt();
                makeTankChoice(index, tank);
                break;
            case 2:
                seeFish(tank);
                int index1 = scanner.nextInt();
                if (index1 <= tank.getFishList().size()) {
                    showFishChoices();
                    int index2 = scanner.nextInt();
                    Fish fish = tank.getFishList().get(index1 - 1);
                    makeFishChoice(index2, fish);
                }
                break;
            case 3:
                addFish(tank);
            default:
        }
    }

    //public void lookAtFish(Fish fish) {
      //  System.out.printf("Name: %s     Sex: %c%nLooks %s", fish.getName(), fish.getSex(), fish.getHealth());
    //}

    public void enterTank(FishTank tank) {
        System.out.println("--- Tank " + tank.getNumber() + " ---");
        System.out.println("1) Tank notes");
        System.out.println("2) Fish notes");
        System.out.println("3) Add fish");
        System.out.println("4) Return to Main Menu");

    }

    public void showFishChoices() {
        System.out.println("1) Make new note");
        System.out.println("2) See latest note");
        System.out.println("3) See all notes");
        System.out.println("4) Return to Main Menu");
    }
    public void showTankChoices() {
        System.out.println("1) Make new note");
        System.out.println("2) See latest note");
        System.out.println("3) See all notes");
        System.out.println("5) Return to Main Menu");
    }

    public void seeFish(FishTank tank) {
        for (int i = 0; i < tank.getFishList().size(); i++) {
            Fish fish = tank.getFishList().get(i);
            System.out.println((i + 1) + ") " + fish.getName());
        }
        System.out.println((tank.getFishList().size()+1)+") Return to Main Menu");
    }

    public void makeFishChoice(int index, Fish fish) {
        switch (index) {
            case 1 -> fish.addNote();
            case 2 -> fish.getLatestNote();
            case 3 -> fish.getNotebook();
            default -> {
            }
        }
    }

    public void makeTankChoice(int index, FishTank tank) {
        switch (index) {
            case 1 -> tank.addNote();
            case 2 -> tank.getLatestNote();
            case 3 -> tank.getTankNotes();
            default -> {
            }
        }
    }
    public  void addFish(FishTank tank){
        System.out.print("What is the name of the fish?");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("What is the health of the fish?");
        String health = scanner.nextLine();
        System.out.print("What is the sex of the fish? (m/f)");
        char sex = scanner.next().charAt(0);
        Fish newFish = new Fish(name, health,sex);
        tank.addFish(newFish);

    }
    public void addTank(){
        int tankNumber = (tanks.size() + 1);
        FishTank newTank = new FishTank(tankNumber);
        System.out.print("Tank " + tankNumber + " added\n" );
        tanks.add(newTank);
    }

}
