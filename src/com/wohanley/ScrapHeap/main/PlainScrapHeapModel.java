package com.wohanley.ScrapHeap.main;

import java.util.Vector;

import com.wohanley.ScrapHeap.main.relationships.Relationship;
import com.wohanley.ScrapHeap.main.scraps.Scrap;

public class PlainScrapHeapModel implements ScrapHeapModel
{
	private Vector<Scrap> scraps;
	private Vector<Relationship> relationships;
	
	public PlainScrapHeapModel()
	{
		scraps = new Vector<Scrap>();
		relationships = new Vector<Relationship>();
	}
	
    public void addScrap(Scrap scrap)
    {
    	
    }

    public void addRelationship(Scrap from, Scrap to, Relationship relationship)
    {
        
    }
}
