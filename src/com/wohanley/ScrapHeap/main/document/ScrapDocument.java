package com.wohanley.ScrapHeap.main.document;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;

import com.wohanley.ScrapHeap.main.dao.neo4j.Neo4jBackedClause;

public class ScrapDocument extends AbstractDocument
{
    protected ScrapDocument(Content data)
    {
        super(data);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Element getDefaultRootElement()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Element getParagraphElement(int pos)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
