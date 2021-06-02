package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IBranchService;
import com.sep.SepJavaServer.service.IUserService;
import com.sep.model.Branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    IBranchService branchService;

    @GetMapping("/all")
    public String getAllBranches() throws IOException {
         String branches = branchService.getAllBranches();
        return branches;
    }
    @GetMapping("/id")
    public Branch getBranch(int id) throws IOException {
        Branch  branch = branchService.getBranch(id);
        return branch;
    }
    @PostMapping("/add")
    public String AddBranch(@RequestBody String jsonBody) throws IOException {
        String s = branchService.addBranch(jsonBody);
        return s;

    }
    @DeleteMapping("/remove")
    public String RemoveBranch(int id) throws IOException {
        return branchService.removeBranch(id);
    }
}
