package org.example;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCowsGame {
    private static final int NUMBER_LENGTH = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path for creating game history file: ");
        String dirPath = scanner.nextLine();
        String generatedNumber = generatedNumber();
        System.out.println("Created number from 4 digits, try to guess! \nTo stop a game enter 0000");
        int moveCount = 0;
        List<String> gameHistory = new ArrayList<>();
        while(true){
            System.out.println("Enter number from 4 digits: ");
            String userNumber = scanner.nextLine();

            boolean correct = true;
            if(userNumber.length() < NUMBER_LENGTH || userNumber.length() > NUMBER_LENGTH || Integer.parseInt(userNumber)<0){
                correct = false;
                System.out.println("Not correct number");
                moveCount++;
                gameHistory.add("Not correct number: " + userNumber);
            }

            if(userNumber.equals("0000")){
                System.out.println("Game stopped");
                break;
            }
            if(correct) {
                int cows = cowsCount(generatedNumber, userNumber);
                int bulls = bullsCount(generatedNumber, userNumber);
                String res = userNumber + "(" + cows + " cows, " + bulls + " bulls)";
                System.out.println(res);
                gameHistory.add(res);
                if (bulls == NUMBER_LENGTH) {
                    System.out.println("You won!");
                    break;
                }
                moveCount++;

            }
        }
        saveGameHistory(dirPath,gameHistory,moveCount);

    }
    private static void saveGameHistory(String dirPath, List<String> gameHistory, int moveCount){
        LocalDateTime now = LocalDateTime.now();
        now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss"));
        String fileName = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss")) + "(" + moveCount + ")";
        try {
            FileWriter writer = new FileWriter(dirPath + "/" + fileName);
            for( String move : gameHistory){
                writer.write(move + "\n");
            }
            writer.close();
            System.out.println("Game history saved in the file: " + fileName + " path of the directory: " + dirPath);
        }catch (Exception e){
            System.out.println("Game history file creating error");
            e.printStackTrace();
        }
    }
    private static int cowsCount (String generatedNumber, String userNumber){
        int cows = 0;
        for(int i = 0; i< NUMBER_LENGTH; i++){
            if(generatedNumber.contains(String.valueOf(userNumber.charAt(i)))){
                cows++;
            }
        }
        return cows;
    }
    private static int bullsCount (String generatedNumber, String userNumber){
        int bulls = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++){
            if(generatedNumber.charAt(i)== userNumber.charAt(i)){
                bulls++;
            }
        }
        return bulls;
    }
    private static String generatedNumber(){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add(i);
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < NUMBER_LENGTH; i++){
            int randIndex = random.nextInt(numbers.size());
            sb.append(numbers.remove(randIndex));
        }
        return sb.toString();
    }
}
