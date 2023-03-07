package org.example.service.impl;

import org.apache.lucene.search.Query;
import org.example.core.StaticInit;
import org.example.pojo.Host;
import org.example.pojo.Network;
import org.example.pojo.VmInfo;
import org.example.service.IFullTextSearchService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.EntityContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
@Service
public class IFullTextSearchServiceImpl implements IFullTextSearchService {

    Logger log = LoggerFactory.getLogger(IFullTextSearchServiceImpl.class);

    @Autowired
    private EntityManager entityManager;

    private List<Class> indexEntities;


    @Transactional
    public List visit(String keyWord) {
        indexEntities = new ArrayList<>();
        indexEntities.add(VmInfo.class);
        indexEntities.add(Host.class);
        indexEntities.add(Network.class);
        FullTextEntityManager manager = Search.getFullTextEntityManager(entityManager);
        List result = new ArrayList();
        indexEntities.forEach(v -> {
            EntityContext context = manager.getSearchFactory().buildQueryBuilder()
                    .forEntity(v);
            QueryBuilder queryBuilder = context.get();
            Query luceneQuery = queryBuilder
                    .keyword()
                    .fuzzy()
                    .onFields("name")
                    .matching(keyWord)
                    .createQuery();
            FullTextQuery fullTextQuery = manager.createFullTextQuery(luceneQuery, v);
            List resultList = fullTextQuery.getResultList();
            result.add(resultList);
        });
        return result;
    }


    @PostConstruct
    public void init() {
        FullTextEntityManager manager = Search.getFullTextEntityManager(entityManager);
        try {
            manager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
