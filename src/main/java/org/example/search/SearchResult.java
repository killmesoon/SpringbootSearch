package org.example.search;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 查询结果类
 */
@Data
public class SearchResult {
    private List<Map<String, List>> resultList;
}
