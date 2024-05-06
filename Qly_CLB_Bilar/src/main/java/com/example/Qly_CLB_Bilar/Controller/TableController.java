package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Enum.TableStatus;
import com.example.Qly_CLB_Bilar.Entity.Table_Data;
import com.example.Qly_CLB_Bilar.Repository.TableRepository;
import com.example.Qly_CLB_Bilar.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService tableService;
    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/getall")
    public Iterable<Table_Data> GetAll(){
        return tableService.GetAll();
    }

    @GetMapping("/findid/{Id}")
    public Table_Data FindId(@PathVariable("Id") String Id){
        return tableService.FindId(Id);
    }
    @GetMapping("/findarae/{area}")
    public Iterable<Table_Data> FindArea(@PathVariable("area") String area){
        return tableService.GetArea(area);
    }
    @GetMapping("/findstatus/{status}")
    public Iterable<Table_Data> FindStatus(@PathVariable("status") TableStatus status){
        return tableService.GetStatus(status);
    }
    @PostMapping("/create")
    public Table_Data Create(@RequestBody Table_Data tableData){
        return tableService.Create(tableData);
    }
    @PutMapping("/update/{Id}")
    public Table_Data Update(@RequestBody Table_Data tableData, @PathVariable("Id") String Id) {
        return tableService.Update(tableData, Id);
    }

    @DeleteMapping("/delete/{Id}")
    public void Delete(@PathVariable("Id") String Id){
        tableService.Delete(Id);
    }
}
