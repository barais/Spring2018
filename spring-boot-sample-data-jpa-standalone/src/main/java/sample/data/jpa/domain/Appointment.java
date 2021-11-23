package sample.data.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.REMOVE)
    private Slot slot;

    public Appointment(){}

    public Appointment(User user, Slot slot) {
        this.user = user;
        this.slot = slot;
        this.user.addAppointment(this);
        this.slot.setAppointment(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) { this.user = user; }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) { this.slot = slot; }

    public Long getId() {
        return id;
    }



}
