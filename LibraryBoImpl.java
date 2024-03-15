package org.example.books.bo.impl;

import org.example.books.bo.custom.LibraryBranchBo;
import org.example.books.dao.DaoFactory;
import org.example.books.dao.custom.LibraryBranchDao;
import org.example.books.dto.LibraryBranchDto;
//import org.example.books.entities.Admin;
import org.example.books.entities.LibraryBranch;

public class LibraryBoImpl implements LibraryBranchBo {
    LibraryBranchDao dao=(LibraryBranchDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.LIBRARY_BRANCH);

    @Override
    public boolean saveBranch(String name) {
        
        LibraryBranch branch=new LibraryBranch();
        branch.setBranchName(name);
      
        
       return dao.save(branch);

    }

    @Override
    public boolean delete(String name) {
        return dao.delete(name);
    }

    @Override
    public LibraryBranchDto search(String name) {
       LibraryBranch branch=dao.search(name);
       return new LibraryBranchDto(branch.getBranchName(),branch.getBranchDetails());
    }

    @Override
    public boolean update(String name) {
        
        LibraryBranch branch=new LibraryBranch();
        branch.setBranchName(name);
      
        
       return dao.update(branch);
    }
}
