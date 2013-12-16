package com.wohanley.ScrapHeap.main.dao.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;

/**
 * Cleanly shuts down the database when run. Set this as a JVM shutdown hook to
 * make sure the database is shut down.
 */
public class Neo4jShutdownHook extends Thread
{
    private GraphDatabaseService db;
    
    public Neo4jShutdownHook(GraphDatabaseService db)
    {
        super();
        
        this.db = db;
    }
    
    @Override
    public void run()
    {
        db.shutdown();
    }
}
