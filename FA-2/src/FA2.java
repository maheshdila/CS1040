
class MusicTrack {
    //this class defines music track objects
    String name;
    double duration;

    MusicTrack(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    MusicTrack(String name) {
        //this constructor is used when we only know the name of the song
        this.name = name;
    }
}

abstract class Performance {

    private MusicTrack[] trackList;
    // only has a setter i.e. read only

    public void setTrackList(MusicTrack[] trackList) {
        this.trackList = trackList;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void record();
    //since both live & studio performances should have record method with different implementation

    public mainArtist getMain_Artist() {
        return main_Artist;
    }

    public void setMain_Artist(mainArtist main_Artist) {
        this.main_Artist = main_Artist;
    }

    private mainArtist main_Artist;


    public backupSinger[] getBackup_singers() {
        return backup_singers;
    }

    public void setBackup_singers(backupSinger[] backup_singers) {
        this.backup_singers = backup_singers;
    }

    private backupSinger[] backup_singers;

    public BackupDancer[] getBackup_dancers() {
        return backup_dancers;
    }

    public void setBackup_dancers(BackupDancer[] backup_dancers) {
        this.backup_dancers = backup_dancers;
    }

    private BackupDancer[] backup_dancers;

}

class LivePerformance extends Performance {
    private void setYear(int year) {
        this.year = year;
    }

    private void setVenue(String venue) {
        this.venue = venue;
    }

    private int year;

    public int getYear() {
        return year;
    }

    private String venue;

    public String getVenue() {
        return venue;
    }


    LivePerformance(String performanceName,
                    String mainArtistName,
                    int year,
                    String venue,
                    BackupDancer[] backup_Dancers,
                    backupSinger[] backup_Singers,
                    MusicTrack[] tracklist) {
        //this is a parameterized constructor to set all the attributes at once
        this.setName(performanceName);
        this.setMain_Artist(new mainArtist(mainArtistName)); // initialises a main artist object
        //this.setYear(year);
        this.setVenue(venue);
        this.setBackup_dancers(backup_Dancers);
        this.setBackup_singers(backup_Singers);
        this.setTrackList(tracklist);

        System.out.println("Welcome to the Performance " + this.getName() + " by " + this.getMain_Artist().getName());
        System.out.println();
        //main artist singing
        this.getMain_Artist().sing();
        System.out.println();
        //backup singing
        for (int i=0;i<backup_Singers.length;i++){
            backup_Singers[i].backup();
            System.out.println();
        }
        //backup dancing
        for (int i=0;i<backup_Dancers.length;i++){
            backup_Dancers[i].backup();
            System.out.println();
        }
        System.out.println();

    }

    public void record() {
        System.out.println("This is the method " + "record" + " in the class " + "LivePerformance");
        System.out.println(this.getName() + " live performance is being  recording ");
    }

    public void audienceInteraction() {
        /*main artist can interfere with the audience only in a live performance
         * */

        System.out.println("This is the method " + "audienceInteraction" + " in the class " + "LivePerformance");
        System.out.println(this.getMain_Artist().getName() + " interacts with Audience ");
    }


}

class StudioPerformance extends Performance {
    private void setYear(int year) {
        //this setter is set to private to make the year read-only
        this.year = year;
    }

    private void setVenue(String venue) {
        //this setter is set to private to make the venue read-only
        this.venue = venue;
    }

    private int year;

    public int getYear() {
        return year;
    }

    private String venue;

    public String getVenue() {
        return venue;
    }


    StudioPerformance(String performanceName,
                      String mainArtistName,
                      int year,
                      String venue,
                      BackupDancer[] backup_Dancers,
                      backupSinger[] backup_Singers,
                      MusicTrack[] tracklist) {
        //this is a parameterized constructor to set all the attributes at once
        this.setName(performanceName);
        this.setMain_Artist(new mainArtist(mainArtistName)); // initialises a main artist object
        this.setYear(year);
        this.setVenue(venue);
        this.setBackup_dancers(backup_Dancers);
        this.setBackup_singers(backup_Singers);
        this.setTrackList(tracklist);

        System.out.println("Welcome to the Performance " + this.getName() + " by " + this.getMain_Artist().getName());

        System.out.println();
        //main artist singing
        this.getMain_Artist().sing();
        System.out.println();
        //backup singing
        for (int i=0;i<backup_Singers.length;i++){
            backup_Singers[i].backup();
            System.out.println();
        }
        //backkup dancing
        for (int i=0;i<backup_Dancers.length;i++){
            backup_Dancers[i].backup();
            System.out.println();
        }
        System.out.println();
    }

    public void record() {
        System.out.println("This is the method " + "record" + " in the class " + "StudioPerformance");
        System.out.println(this.getName() + " studio performance is being  recording ");
    }

    public void audioProcessing() {
        //unique method to studio performance
        System.out.println("This is the method " + "audioProcessing" + " in the class " + "StudioPerformance");

    }

}

interface IBackup {
    public void backup();
}

class Artist {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}

class Singer extends Artist {
    public void sing() {
        System.out.println("This is the method " + "sing" + " in the class Singer");
        System.out.print(this.getName()+" Sings ");
    }
}

class mainArtist extends Singer {
    public mainArtist(String artistName) {
        this.setName(artistName);
    }

    public void sing() {
        System.out.println("This is the method " + "sing" + " in the class " + "mainArtist");
        super.sing(); // we must call super class sing method , if we call this.sing() it will make a recursive call
        System.out.println();

    }
}

class backupSinger extends Singer implements IBackup {
    @Override
    public void backup() {
        //backup singers can only backup by singing
        System.out.println("This is the method " + "backup" + " in the class backupSinger");

        this.sing();
        System.out.println("to backup the main artist ");
    }

    backupSinger(String name) {
        this.setName(name);
    }
}

class BackupDancer extends Artist implements IBackup {
    @Override
    public void backup() {

        System.out.println("This is the method " + "backupDancer" + " in the class backupDancer");
        System.out.print(this.getName()+" is dancing ");;
        System.out.println("to backup the main artist ");
    }


    BackupDancer(String name) {
        this.setName(name);
    }
}


public class FA2 {


    public static void main(String[] args) {
        // For the specified performance that was mentioned in the Question

        String performanceName = "Eras Tour";
        String mainArtist = "Taylor Swift";
        int year = 2023;
        String venue = "Glendale";
        BackupDancer[] backup_Dancers = {new BackupDancer("Stephanie"), new BackupDancer("Jake")};
        backupSinger[] backup_Singers = {new backupSinger("Jeslyn"), new backupSinger("Melanie")};
        MusicTrack[] tracklist = new MusicTrack[]{new MusicTrack("Lavender Haze"),
                new MusicTrack(" All Too Well"),
                new MusicTrack("the lakes"),
                new MusicTrack("The Man"),
                new MusicTrack("Love Story")};


        LivePerformance p0 = new LivePerformance(performanceName, mainArtist, year, venue,
                backup_Dancers, backup_Singers, tracklist);
    }
}
