package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Id;

@Data
@Entity
public class Order {

    String balloonColor;
    String balloonSize;
    String clientName;
    String clientAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    //empty const
    public Order(){
    }

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
    }
}
