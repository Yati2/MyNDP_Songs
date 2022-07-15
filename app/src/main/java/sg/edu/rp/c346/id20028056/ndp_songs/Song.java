package sg.edu.rp.c346.id20028056.ndp_songs;
import java.io.Serializable;

public class Song implements Serializable{
    private int id,year,stars;
    private String title,singers;

    public Song(int id,String title, String singers,int year, int stars) {
        this.id=id;
        this.title = title;
        this.singers=singers;
        this.stars=stars;
        this.year=year;
    }

    public int get_id() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStar() {
        return stars;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
    public void updateDetails(String title,String singers, int year, int stars)
    {
        this.id=id;
        this.title = title;
        this.singers=singers;
        this.stars=stars;
        this.year=year;
    }
    public String toString() { return "ID: " + id + ",\nTitle: " + title +",\nSingers: "+singers+",\nYear: "+ year+
            " ,\nStars: "+displayStars(stars);  }

    public String displayStars(int stars)
    {
        String display="";

        switch (stars)
        {
            case R.id.rb1:
                display="*";
                break;
            case  R.id.rb2:
                display="**";
                break;
            case  R.id.rb3:
                display="***";
                break;
            case  R.id.rb4:
                display="****";
                break;
            case  R.id.rb5:
                display="*****";
                break;

        }
        return display;
    }
}
