package org.example.config;

import org.example.pojo.VmInfo;
import org.hibernate.search.annotations.Factory;
import org.hibernate.search.cfg.SearchMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSearchMappingFactory {

    Logger log = LoggerFactory.getLogger(CustomSearchMappingFactory.class);

    public CustomSearchMappingFactory() {

    }

    @Factory
    public SearchMapping getSearchMapping() {
        log.info("init factory ................");
        SearchMapping searchMapping = new SearchMapping();
        searchMapping.entity(VmInfo.class).indexed();
        return searchMapping;
    }
}
