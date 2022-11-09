package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloonList = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init() {
        Manufacturer manufacturer = new Manufacturer("NAME 1", "USA", "address 1");
        manufacturers.add(manufacturer);
        balloonList.add(new Balloon("Red", "Large"));

        manufacturer = new Manufacturer("NAME 2", "MKD", "address 2");
        manufacturers.add(manufacturer);
        balloonList.add(new Balloon("Blue", "Small"));

        manufacturer = new Manufacturer("NAME 3", "SLOVENIA", "address 3");
        manufacturers.add(manufacturer);
        balloonList.add(new Balloon("Green", "Large"));

        manufacturer = new Manufacturer("NAME 4", "SERBIA", "address 4");
        manufacturers.add(manufacturer);
        balloonList.add(new Balloon("Yellow", "Medium"));
    }

}
