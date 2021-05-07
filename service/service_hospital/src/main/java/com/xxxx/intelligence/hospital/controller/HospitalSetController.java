package com.xxxx.intelligence.hospital.controller;

import com.xxxx.intelligence.enums.ResponseEnum;
import com.xxxx.intelligence.hospital.service.HospitalSetService;
import com.xxxx.intelligence.model.hosp.HospitalSet;
import com.xxxx.intelligence.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hospital/hospitalSet")
@Api(tags = "HospitalSetController", value = "医院设置")
@Slf4j
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;


    @GetMapping("")
    @ApiOperation(value = "获取所有医院设置")
    public ResponseVO getAll() {
        List<HospitalSet> list = hospitalSetService.list();
        return ResponseVO.success(ResponseEnum.SUCCESS, list);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除指定医院设置（ID）")
    public ResponseVO deleteById(@PathVariable("id") Integer id) {
        boolean result = hospitalSetService.removeById(id);
        if (result) {
            return ResponseVO.success(ResponseEnum.SUCCESS);
        }
        return ResponseVO.error(ResponseEnum.ERROR);
    }



}
