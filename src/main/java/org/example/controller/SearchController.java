package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.VmInfo;
import org.example.service.IFullTextSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private IFullTextSearchService service;

    @GetMapping("/search/{keyword}")
    public List getResult(@PathVariable String keyword) {
        return service.visit(keyword);
    }

    @GetMapping("/search/init")
    public void initIndex() {
        log.info("index init ........");
        service.init();
    }
}
