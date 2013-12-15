package com.wohanley.ScrapHeap;

import com.wohanley.ScrapHeap.relationships.Relationship;
import com.wohanley.ScrapHeap.scraps.Scrap;

public interface ScrapHeapModel
{
    void addScrap(Scrap scrap);
    
    void addRelationship(Scrap from, Scrap to, Relationship relationship);
}
