package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Booking;
import com.example.Qly_CLB_Bilar.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    public  BookingRepository bookingRepository;

    @GetMapping("/getall")
    public Iterable<Booking> GetAll(){
        return bookingRepository.findAll();
    }
    @GetMapping("/findId/{Id}")
    public Booking FindId(@PathVariable("Id") String Id){
        return bookingRepository.findById(Id).orElseThrow(() -> new RuntimeException("Không tìm thấy ID:" + Id));
    }
    @PostMapping("/create")
    public Booking Create(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }
    @PutMapping("/update/{Id}")
    public Booking Update(@PathVariable("Id") String Id, @RequestBody Booking booking){
        Booking newBooking = FindId(Id);
        newBooking.setNote(booking.getNote());
        newBooking.setCustomer(booking.getCustomer());
        newBooking.setTimeArrive(booking.getTimeArrive());
        newBooking.setSlot(booking.getSlot());
        newBooking.setNote(booking.getNote());
        newBooking.setTable(booking.getTable());
        newBooking.setStaff(booking.getStaff());
        newBooking.setTimePlay(booking.getTimePlay());
        return bookingRepository.save(newBooking);
    }

}
