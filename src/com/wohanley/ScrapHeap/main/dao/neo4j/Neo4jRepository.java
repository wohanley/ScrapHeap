package com.wohanley.ScrapHeap.main.dao.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import com.wohanley.ScrapHeap.main.dao.ScrapRepository;
import com.wohanley.ScrapHeap.main.relationships.Relationship;
import com.wohanley.ScrapHeap.main.scraps.Scrap;

public class Neo4jRepository implements ScrapRepository
{
    private GraphDatabaseService db;
    private final String dbPath = "db"; // TODO some kind of settings junk
    
    public Neo4jRepository()
    {
        db = new GraphDatabaseFactory().newEmbeddedDatabase(dbPath);
        
        Runtime.getRuntime().addShutdownHook(new Neo4jShutdownHook(db));
    }
    
    @Override
    public void addScrap(Scrap scrap)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void addRelationship(Scrap from, Scrap to, Relationship relationship)
    {
        // TODO Auto-generated method stub

    }

}
