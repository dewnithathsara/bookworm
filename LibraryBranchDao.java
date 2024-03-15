package org.example.books.dao.custom;

import org.example.books.dao.SuperDao;
import org.example.books.entities.LibraryBranch;

public interface LibraryBranchDao extends SuperDao{

    boolean save(LibraryBranch branch);

    boolean delete(String name);

    LibraryBranch search(String name);

    boolean update(LibraryBranch branch);
    
}
