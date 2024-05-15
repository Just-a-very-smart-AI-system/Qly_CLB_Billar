package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.Entity.Booking;
import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.Table_Data;
import com.example.Qly_CLB_Bilar.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public Iterable<Booking> FindByCustomer(Customer customer){
        return bookingRepository.findByCustomer(customer);
    }
    public Iterable<Booking> FindByStaff(Staff staff){
        return bookingRepository.findByStaff(staff);
    }
    public Iterable<Booking> FindByTable(Table_Data tableData){
        return bookingRepository.findByTableData(tableData);
    }
    public Iterable<Booking> FindByDate(LocalDate date){
        return bookingRepository.findByDate(date);
    }
    public Iterable<Booking> FindByTime(LocalDate date, LocalTime start, LocalTime end){
        return bookingRepository.findByTime(date, start, end);
    }
    public Iterable<Booking> FindBySlot(Integer slot){
        return bookingRepository.findBySlot(slot);
    }
}
