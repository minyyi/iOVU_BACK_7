package com.iovu.iovuback.controller;

import com.iovu.iovuback.domain.Dashboard;
import com.iovu.iovuback.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// import java.util.List;

@RestController
public class DashboardController {
    private DashboardService dashBoardService;

    public DashboardController(DashboardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    @GetMapping("/reports/{reportId}/dashboard")
    //List로 수정(kim)
    public List<Dashboard> getDashboard(@PathVariable Long reportId) {
        List<Dashboard> result =  dashBoardService.getDashboard(reportId);
        if(result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found");
        }
        return result;
    }
}
