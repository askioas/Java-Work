import java.util.ArrayList;
import java.util.Scanner;

// Declaring SongList Class to hold individual song objects
class SongList {
    String musicName;
    String musicArtist;
    int musicListens; 
// Constructor of SongList Class
public SongList(String musicName, String musicArtist, int musicListens) {
    this.musicName = musicName;
    this.musicArtist = musicArtist;
    this.musicListens = musicListens;}
// Getters for SongList Attributes
public String getMusicName() {return musicName;}
public String getMusicArtist() {return musicArtist;}
public int getMusicListens() {return musicListens;}
// Setters for SongList Attributes
public void setMusicName(String MusicName) {this.musicName = MusicName;}
public void setMusicArtist(String MusicArtist) {this.musicArtist = MusicArtist;}
public void setMusicListens(int MusicListens) {this.musicListens = MusicListens;}}

// Declaring MusicPlayer Class to hold methods regarding to MusicPlayer usage
class MusicPlayer {
    ArrayList<SongList> playlist;
// Constructor of MusicPlayer Class
public MusicPlayer() {
    playlist = new ArrayList<SongList>(); }
// Method to add songs to playlist
public void add(Scanner userInput) {
// Scanner system to detect user input to create a Song object
    System.out.println();
    System.out.print("Input the song's name: ");
    String userMusicName = userInput.nextLine();
    System.out.println();
    System.out.print("Input the song's artist: ");
    String userMusicArtist = userInput.nextLine();
    System.out.println();
    System.out.print("Input the song's global listens: ");
// Using replace to remove common inputting mistakes
    String userMusicListensCleaner = userInput.nextLine().replace(",", "").replace(".", "").replace(" ", "");
// Using try catch to catch any other invalid input
    try {
        int userMusicListens = Integer.parseInt(userMusicListensCleaner);
        playlist.add(new SongList(userMusicName, userMusicArtist, userMusicListens));
        System.out.println("Song [" + userMusicName +"] has been added to the playlist.");
    return;}
    catch (NumberFormatException e) {System.out.println("Invalid input. Please keep your input in a integer format (0-99999999)");}
    } 
// Method to remove songs from playlist
public void remove(Scanner userInput) {
    System.out.println();
    System.out.print("Input the name of the song to remove: ");
    String userSongRemove = userInput.nextLine();
    int songRemoveCount = 0;
    while (songRemoveCount < playlist.size()) {
        if (playlist.get(songRemoveCount).getMusicName().equals(userSongRemove)){
            playlist.remove(songRemoveCount);
            System.out.println("Song [" + userSongRemove + "] successfully removed from playlist.");
            return;}
        songRemoveCount++;}
        System.out.println("Invalid input. Unable to find song in playlist.");
return;}
// Method to display songs from playlist
public void display() {
    int displayCount = 0;
    while (displayCount < playlist.size()) {
        SongList song = playlist.get(displayCount);
        System.out.println("Song Name: " + song.getMusicName() + " | Artist: " + song.getMusicArtist() + " | Global Listens: " + String.format("%,d", song.getMusicListens()));
        displayCount++;}
        return;
    }
// Method to fully display songs from playlist over a specific number of listens
public void displayExclude(Scanner userInput){
    System.out.println();
    System.out.print("Input minimum global listens for songs to display: ");
    String userMusicListensCleaner = userInput.nextLine().replace(",", "").replace(".", "").replace(" ", "");
    try {
        int UserMusicListens = Integer.parseInt(userMusicListensCleaner);
        int displayExcludeCount = 0;
        while (displayExcludeCount < playlist.size()) {
            SongList song = playlist.get(displayExcludeCount);
            if (song.getMusicListens() >= UserMusicListens) {
            System.out.println("Song Name: " + song.getMusicName() + " | Artist: " + song.getMusicArtist() + " | Global Listens: " + String.format("%,d", song.getMusicListens()));}
            displayExcludeCount++;}}
    catch (NumberFormatException e) {System.out.println("Invalid input. Please keep your input in a integer format (0-99999999): ");}
    return;}
}

// Main method to set default music player and run methods
public class Playlist {
    public static void main(String[] args) {
        // Inputs hardcoded music entries
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playlist.add(new SongList("Unreal", "Bastetrak", 3339));
        musicPlayer.playlist.add(new SongList("Lovefield", "underscores", 2261414));
        musicPlayer.playlist.add(new SongList("changes", "lite", 8102));
        musicPlayer.playlist.add(new SongList("Do I keep you up", "kmoe", 1428748));
        musicPlayer.playlist.add(new SongList("Big Cat Judgement Day", "With Confidence", 13402301));
        musicPlayer.playlist.add(new SongList("Flesh without Blood", "Grimes", 78365743));
        musicPlayer.playlist.add(new SongList("crush", "kmoe", 1545712));
        musicPlayer.playlist.add(new SongList("ringtone", "100 gecs", 29100511));
        musicPlayer.playlist.add(new SongList("Ther", "Gavriel", 820876));
        musicPlayer.playlist.add(new SongList("seer", "8485", 1519270));
        musicPlayer.playlist.add(new SongList("4, 5, TETHER!", "corefish", 290432));
        System.out.println();
        musicPlayer.display();
        // Displays hardcoded menu alongside scanner for user input
        boolean activeMenu = true;
        Scanner UserMenuInput = new Scanner(System.in);
        while (activeMenu == true) {
        System.out.println();
        System.out.println("Music Player User Menu");
        System.out.println("--------------------------");
        System.out.println("1. Add a song to the playlist");
        System.out.println("2. Remove a song from the playlist");
        System.out.println("3. Display all songs in the playlist");
        System.out.println("4. Display songs with a minimum number of global listens");
        System.out.println("5. Exit");
        System.out.println("--------------------------");
        System.out.print("Input corresponding number to use a function: ");
        try {
            int userMenuChoice = Integer.parseInt(UserMenuInput.nextLine());
            if (userMenuChoice == 1) {musicPlayer.add(UserMenuInput);}
            else if (userMenuChoice == 2) {musicPlayer.remove(UserMenuInput);}
            else if (userMenuChoice == 3) {musicPlayer.display();}
            else if (userMenuChoice == 4) {musicPlayer.displayExclude(UserMenuInput);}
            else if (userMenuChoice == 5) {System.out.println("Exiting Music Player. Goodbye!");
                activeMenu = false;
            }
            else {System.out.println("Invalid input. Please input a number from the menu options (1-5).");}}
        catch (NumberFormatException e) {System.out.println("Invalid input. Please input a number from the menu options (1-5).");}
        }
    }
}




//System.out.println("Song Name: " + song.getMusicName() + " | Artist" + song.getMusicArtist() + " | Global Listens: " + song.getMusicListens());

// Music List below
// --------------------------------
// Song Name: Unreal | Artist: Bastetrak | Global Listens: 3,339
// Song Name: Lovefield | Artist: underscores | Global Listens: 2,261,414
// Song Name: changes | Artist: lite | Global Listens: 8,102
// Song Name: Do I keep you up | Artist: kmoe | Global Listens: 1,428,748
// Song Name: Big Cat Judgement Day | Artist: With Confidence | Global Listens: 13,402,301
// Song Name: Flesh without Blood | Artist: Grimes | Global Listens: 78,365,743
// Song Name: crush | Artist: kmoe | Global Listens: 1,545,712
// Song Name: ringtone | Artist: 100 gecs | Global Listens: 29,100,511
// Song Name: Ther | Artist: Gavriel | Global Listens: 820,876
// Song Name: seer | Artist: 8485 | Global Listens: 1,519,270
// Song Name: 4, 5, TETHER! | Artist: corefish | Global Listens: 290,432
// ADDED SONG IN PRESENTATION: Song Name: Second hand embarassment | Artist: underscores | Global Listens: 7,333,810
