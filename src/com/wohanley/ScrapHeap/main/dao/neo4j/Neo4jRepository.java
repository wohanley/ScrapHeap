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
        
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                db.shutdown();
            }
        });
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
