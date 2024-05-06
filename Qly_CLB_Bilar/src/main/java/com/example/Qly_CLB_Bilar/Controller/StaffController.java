package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Repository.StaffRepository;
import com.example.Qly_CLB_Bilar.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private StaffService staffService;

    @GetMapping("/getall")
    public Iterable<Staff> GetAll(){
        return staffRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public Staff FindId(@PathVariable("Id") String Id){
        return staffRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID:" + Id));
    }
    @PostMapping("/create")
    public Staff Create(@RequestBody Staff staff){
        return staffRepository.save(staff);
    }
    @PutMapping("/update/{Id}")
    public Staff Update(@PathVariable("Id") String Id, @RequestBody Staff newStaff){
        Staff staff = FindId(Id);
        staff.setAddress(newStaff.getAddress());
        staff.setBirthday(newStaff.getBirthday());
        staff.setName(newStaff.getName());
        staff.setGender(newStaff.getGender());
        staff.setSdt(newStaff.getSdt());
        staff.setDateStart(newStaff.getDateStart());
        staff.setTimeWorking(newStaff.getTimeWorking());
        staff.setPosition(newStaff.getPosition());

        return staffRepository.save(staff);
    }
}
