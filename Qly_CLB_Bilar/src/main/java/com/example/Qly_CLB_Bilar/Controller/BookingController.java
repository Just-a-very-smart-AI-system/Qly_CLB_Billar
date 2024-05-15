package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Booking;
import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.Table_Data;
import com.example.Qly_CLB_Bilar.Repository.BookingRepository;
import com.example.Qly_CLB_Bilar.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/getall")
    public Iterable<Booking> GetAll(){
        return bookingRepository.findAll();
    }
    @GetMapping("/findId/{Id}")
    public Booking FindId(@PathVariable("Id") String Id){
        return bookingRepository.findById(Id).orElseThrow(() -> new RuntimeException("Không tìm thấy ID:" + Id));
    }
    @GetMapping("/findcustomer/{Id}")
    public Iterable<Booking> FindByCustomer(@PathVariable("Id")Customer customerId){
        return bookingService.FindByCustomer(customerId);
    }
    @GetMapping("/findstaff/{Id}")
    public Iterable<Booking> FindByStaff(@PathVariable("Id")Staff staff){
        return bookingService.FindByStaff(staff);
    }
    @GetMapping("/findstable/{Id}")
    public Iterable<Booking> FindByTable(@PathVariable("Id")Table_Data tableData){
        return bookingService.FindByTable(tableData);
    }
    @GetMapping("/finddate")
    public Iterable<Booking> FindByDate(@RequestParam LocalDate date){
        return bookingService.FindByDate(date);
    }
    @GetMapping("/findslot")
    public Iterable<Booking> FindBySlot(@RequestParam Integer slot){
        return bookingService.FindBySlot(slot);
    }
    @GetMapping("/findtime")
    public Iterable<Booking> FindByTime(@RequestParam LocalDate date, @RequestParam LocalTime start, @RequestParam LocalTime end){
        return bookingService.FindByTime(date, start, end);
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
