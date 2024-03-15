package org.example.books.bo.custom;

import org.example.books.bo.SuperBo;
import org.example.books.dto.LibraryBranchDto;

public interface LibraryBranchBo extends SuperBo{

    boolean saveBranch(String name);

    boolean delete(String name);

    LibraryBranchDto search(String name);

    boolean update(String name);
    
}
