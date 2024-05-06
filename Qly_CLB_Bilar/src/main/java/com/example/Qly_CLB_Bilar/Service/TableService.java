package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Entity.Enum.TableStatus;
import com.example.Qly_CLB_Bilar.Entity.Table_Data;
import com.example.Qly_CLB_Bilar.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public Iterable<Table_Data> GetAll(){
        return tableRepository.findAll();
    }
    public Table_Data FindId(String Id){
        return tableRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID:" + Id));
    }
    public void Delete(String Id){
        if(tableRepository.existsById(Id)){
            tableRepository.deleteById(Id);
        }
        else{
            throw new IllegalArgumentException("Không tìm thấy ID:" + Id);
        }
    }
    public Table_Data Create(Table_Data tableData){
        return tableRepository.save(tableData);
    }

    public Table_Data Update(Table_Data newTableData, String Id) {
        Table_Data tableData = FindId(Id);
        tableData.setTableId(newTableData.getTableId());
        tableData.setArea(newTableData.getArea());
        tableData.setNote(newTableData.getNote());
        tableData.setStatus(newTableData.getStatus());
        tableData.setSeats(newTableData.getSeats());
        return tableRepository.save(tableData);
    }
    public Iterable<Table_Data> GetArea(String area){
        Iterable<Table_Data> tb = GetAll();
        List<Table_Data> ans = new ArrayList<>();
        for(Table_Data x : tb){
            if(x.getArea().equals(area)){
                ans.add(x);
            }
        }
        return ans;
    }
    public Iterable<Table_Data> GetStatus(TableStatus status){
        Iterable<Table_Data> tb = GetAll();
        List<Table_Data> ans = new ArrayList<>();
        for(Table_Data x : tb){
            if(x.getStatus().equals(status)){
                ans.add(x);
            }
        }
        return ans;
    }
}
