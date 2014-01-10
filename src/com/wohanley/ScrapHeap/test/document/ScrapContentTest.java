package com.wohanley.ScrapHeap.test.document;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.wohanley.ScrapHeap.main.document.ScrapContent;
import com.wohanley.ScrapHeap.main.scraps.Clause;

@RunWith(JMockit.class)
public class ScrapContentTest
{   
    @Test
    public void lengthCountsCharactersInClauses(@Mocked final Clause clause1,
        @Mocked final Clause clause2)
    {
        List<Clause> clauses = new ArrayList<Clause>();
        clauses.add(clause1);
        clauses.add(clause2);
        
        new Expectations() {{
            clause1.getText(); result = "This is the first clause, and "; times = 1;
            clause2.getText(); result = "this is the second."; times = 1;
        }};
        
        Content content = new ScrapContent(clauses);
        
        assertEquals(49, content.length());
    }
    
    @Test
    public void emptyClauseListHasLengthZero()
    {
        List<Clause> clauses = new ArrayList<Clause>();
        
        Content content = new ScrapContent(clauses);
        
        assertEquals(0, content.length());
    }
    
    @Test
    public void nullClauseListHasLengthZero()
    {
        Content content = new ScrapContent(null);
        
        assertEquals(0, content.length());
    }
}
