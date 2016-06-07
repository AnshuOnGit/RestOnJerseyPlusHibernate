package org.june.hackathon;

import javax.persistence.*;

/**
 * Created by anshu on 7/6/16.
 */

@Entity
@Table(name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vehicle_seq")
    @SequenceGenerator(
            name="vehicle_seq",
            sequenceName="user_sequence",
            allocationSize=20
    )
    @Column(name = "id")
    private Integer vehicleId;
    @Column(name = "vehicle_no")
    private String vehicleNumber;
    @Column(name = "message")
    private String message;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

}
