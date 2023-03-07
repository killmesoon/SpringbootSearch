package org.example.service;

import org.example.pojo.VmInfo;

import java.util.List;

public interface IFullTextSearchService {
    List<VmInfo> visit(String keyWord);

    void init();
}
