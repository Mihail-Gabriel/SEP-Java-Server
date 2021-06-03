package com.sep.SepJavaServer.service;

import com.sep.SepDataClient.DatabaseClient;
import com.sep.model.Branch;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class BranchService implements IBranchService{
    @Override
    public String getAllBranches() throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.getAllBranchesFromDB();
    }

    @Override
    public Branch getBranch(int id) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.getBranchFromDB(id);
    }

    @Override
    public String addBranch(String jsonBody) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.addBranchToDB(jsonBody);
    }

    @Override
    public String removeBranch(int id) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.removeBranchFromDB(id);
    }
}
