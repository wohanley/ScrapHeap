package com.wohanley.ScrapHeap.main.dao.neo4j;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.*;

import com.wohanley.ScrapHeap.main.scraps.Clause;

@NodeEntity
public class Neo4jBackedClause implements Clause
{
    @GraphId
    private long id;
    
    private String text;
    
    @RelatedTo(type = "NEXT", direction = Direction.OUTGOING)
    private Clause next;
    
    @RelatedTo(type = "NEXT", direction = Direction.INCOMING)
    private Clause previous;
    
    @Override
    public String getText()
    {
        return text;
    }
}
