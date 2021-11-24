package sample.data.jpa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sample.data.jpa.domain.Appointment;
import sample.data.jpa.service.AppointmentDAO;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentDAO appointmentDAO;

    /**
     * Endpoint to test the controller with a postman
     *
     * @return A {@link ResponseEntity} with status code 200 and a {@link String}
     */
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Slot controller is OK!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAll(){
        return ResponseEntity.ok(appointmentDAO.findAll());
    }

}
