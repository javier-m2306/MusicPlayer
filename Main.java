import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main{
    public static void main(String[] args) {
        
        
        String filePath = "friday im in love!.wav";
        File file = new File(filePath);


        //can use try-with-resources if an object implements AutoClosable interface
        try( Scanner scnr = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip(); //clip is music or sound player
            clip.open(audioStream); //open audiostream



            String response = "";

            System.out.println("--------------------------------------");
            System.out.println(" Welcome to javier's song of the day!");
            System.out.println("--------------------------------------");

            while(!response.equals("QUIT")){
                System.out.println("Song ---> Displays Song Details");
                System.out.println("Play ---> Plays Song");
                System.out.println("Stop ---> Stops Song");
                System.out.println("Reset ---> Resets Song");
                System.out.println("Quit ---> Quits Song");
                System.out.println("--------------------------------------");
                System.out.print("Enter your choice: ");

                response = scnr.next().toUpperCase();
                System.out.println();

                switch(response){
                    case "SONG" -> {
                        System.out.println();
                        System.out.println("friday im in love! - sung by Robert Smith + Olivia Rodrigo");
                        System.out.println();
                    }
                    case "PLAY" -> clip.start(); //LEARNING LAMBDA!!!!!!
                    case "STOP" -> clip.stop();
                    case "RESET" -> clip.setMicrosecondPosition(0);
                    case "QUIT" -> clip.close();
                    default -> System.out.println("Invalid Choice :3");
                }

            }
        } 
        catch(FileNotFoundException e){
            System.out.println("Could not locate file.");

        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Audio file not supported");

        }
        catch(LineUnavailableException e){
            System.out.println("Unable to access audio resource.");

        }
        catch (IOException e) {
            System.out.println("Something went wrong.");
        }
        finally{
            System.out.println("bye");
            //scnr.close();
        }
    }
}