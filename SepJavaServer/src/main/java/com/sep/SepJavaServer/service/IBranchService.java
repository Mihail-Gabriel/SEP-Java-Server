package com.sep.SepJavaServer.service;

import com.sep.model.Branch;

import java.io.IOException;
import java.util.List;

public interface IBranchService {

    String getAllBranches() throws IOException;

    Branch getBranch(int id) throws IOException;

    String addBranch(String jsonBody) throws IOException;

    String removeBranch(int id) throws IOException;
}
