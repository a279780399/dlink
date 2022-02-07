package com.dlink.executor;

import com.dlink.result.SqlExplainResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.runtime.jobgraph.JobGraph;
import org.apache.flink.runtime.rest.messages.JobPlanInfo;
import org.apache.flink.streaming.api.graph.StreamGraph;
import org.apache.flink.table.api.*;
import org.apache.flink.table.catalog.Catalog;
import org.apache.flink.table.catalog.CatalogManager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * CustomTableEnvironment
 *
 * @author wenmo
 * @since 2022/2/5 10:35
 */
public interface CustomTableEnvironment {

    TableConfig getConfig();

    CatalogManager getCatalogManager();

    void registerCatalog(String catalogName, Catalog catalog);

    String[] listCatalogs();

    Optional<Catalog> getCatalog(String catalogName);

    TableResult executeSql(String statement);

    Table sqlQuery(String statement);

    void registerTable(String name,Table table);

    String explainSql(String statement, ExplainDetail... extraDetails);

    ObjectNode getStreamGraph(String statement);

    JobPlanInfo getJobPlanInfo(List<String> statements);

    StreamGraph getStreamGraphFromInserts(List<String> statements);

    JobGraph getJobGraphFromInserts(List<String> statements);

    SqlExplainResult explainSqlRecord(String statement, ExplainDetail... extraDetails);

    boolean parseAndLoadConfiguration(String statement, ExecutionConfig config, Map<String,Object> setMap);

    StatementSet createStatementSet();
}
