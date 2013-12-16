package com.wohanley.ScrapHeap.main;

import com.wohanley.ScrapHeap.main.relationships.Relationship;
import com.wohanley.ScrapHeap.main.scraps.Scrap;

public interface ScrapHeapModel
{
    void addScrap(Scrap scrap);
    
    void addRelationship(Scrap from, Scrap to, Relationship relationship);
}
