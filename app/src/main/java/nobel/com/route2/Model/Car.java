package nobel.com.route2.Model;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class Car {
    String name;
    String date;
    int carImage;
    int carLogo;


    public Car(String name, String date, int carImage, int carLogo) {
        this.name = name;
        this.date = date;
        this.carImage = carImage;
        this.carLogo = carLogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    public int getCarLogo() {
        return carLogo;
    }

    public void setCarLogo(int carLogo) {
        this.carLogo = carLogo;
    }
}
