package com.todo.demo.controller;

import com.todo.demo.entity.AdmissionRecord;
import com.todo.demo.service.AdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admission")
@RequiredArgsConstructor
public class AdmissionController {

    private final AdmissionService admissionService;


    @PostMapping
    public AdmissionRecord createNewAdmission(@RequestBody AdmissionRecord admissionRecord){
        return admissionService.createNewAdmission(admissionRecord);
    }


    @GetMapping("/{studentId}")
    public AdmissionRecord getAdmissionRecordByStudentId(@PathVariable Long studentId){
        return admissionService.getAdmissionRecordByStudentId(studentId);
    }

    @DeleteMapping("/{admissionId}")
    public void deleteByAdmissionId(@PathVariable Long admissionId){
        admissionService.deleteByAdmissionId(admissionId);
    }

    @PatchMapping("/{admissionId}")
    public AdmissionRecord updateInAdmissionRecord(@PathVariable Long admissionId , @RequestBody Map<String,Object> updates){
        return admissionService.updateInAdmissionRecord(admissionId,updates);
    }

    @PostMapping("/{admissionId}/student/{studentId}")
    public AdmissionRecord assingStudentToAdmissionRecord(@PathVariable Long admissionId , @PathVariable Long studentId){
        return admissionService.assingStudentToAdmissionRecord(admissionId,studentId);
    }

}
