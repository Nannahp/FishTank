package fishtank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FishTank {
    private int number;
    private WaterStatus status;
    private ArrayList tankNotes = new ArrayList();
    private ArrayList<Fish> fishList = new ArrayList();

public FishTank(int number){
    setNumber(number);
}

    private void setNumber(int number) {
    this.number = number;}

    public int getNumber() {
        return number;
    }

    public void setStatus(String status) {
    switch (status.toLowerCase()){
        case "p":
            this.status = WaterStatus.PERFECT;
            break;
        case "g":
            this.status = WaterStatus.GOOD;
            break;
        case "o":
            this.status = WaterStatus.OKAY;
            break;
        case "b":
            this.status = WaterStatus.BAD;
            break;
        default:
            System.out.println("Not an option, please make a new note");
    }
    }

    public WaterStatus getStatus() {
        return status;
    }

    public void getTankNotes() {
        for(int i =0; i < tankNotes.size(); i++){
            System.out.println(tankNotes.get(i)+"\n");
    }}

    public ArrayList<Fish> getFishList() {
        return fishList;
    }

    public void addFish(Fish fish) {
        fishList.add(fish);
    }

    public void addNote() {
        Scanner scanner = new Scanner(System.in);
        String date = String.valueOf(LocalDateTime.now());
        System.out.println("Enter Water Status: \nPerfect(p), Good(g), Okay(o), Bad(b)");
        String waterStatus = scanner.nextLine();
        setStatus(waterStatus);
        System.out.println("Enter note:");
        String note = scanner.nextLine();
        if(note.length()>60) {
            System.out.println("Entry bigger than 60 characters, please make a new entry");
        } else tankNotes.add(date + "\nWater Status: " + String.valueOf(status) +"\n" + note);

    }
    public void getLatestNote(){
    if (tankNotes.size() ==0) System.out.println("No entries");
      else  System.out.println("\n"+tankNotes.get(tankNotes.size()-1));
    }
}
