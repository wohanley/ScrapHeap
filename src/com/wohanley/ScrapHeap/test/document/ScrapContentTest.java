package com.wohanley.ScrapHeap.test.document;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.BadLocationException;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.wohanley.ScrapHeap.main.document.ScrapContent;
import com.wohanley.ScrapHeap.main.scraps.Clause;

@RunWith(JMockit.class)
public class ScrapContentTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void getStringThrowsExceptionForNegativeOffset(@Mocked final Clause clause1) throws BadLocationException
    {
        new Expectations() {{
            clause1.getText(); times = 0;
        }};
        
        Content content = contentify(clause1);
        
        exception.expect(BadLocationException.class);
        content.getString(-1, 5);
    }
    
    @Test
    public void getStringThrowsExceptionForOutOfRange(@Mocked final Clause clause1) throws BadLocationException
    {
        new Expectations() {{
            clause1.getText(); result = "Hi there!"; times = 1;
        }};
        
        Content content = contentify(clause1);
        
        exception.expect(BadLocationException.class);
        content.getString(5, 100);
    }
    
    @Test
    public void getStringThrowsExceptionForOffsetOutOfRange(@Mocked final Clause clause1) throws BadLocationException
    {
        new Expectations() {{
            clause1.getText(); result = "Hi!"; times = 1;
        }};
        
        Content content = contentify(clause1);
        
        exception.expect(BadLocationException.class);
        content.getString(5, 100);
    }
    
    @Test
    public void getStringFromSingleClause(@Mocked final Clause clause1,
        @Mocked final Clause clause2) throws BadLocationException
    {
        new NonStrictExpectations() {{
            clause1.getText(); result = "First, ";
            clause1.next(); result = clause2;
            clause2.getText(); result = "second";
        }};
        
        assertEquals("eco", contentify(clause1, clause2).getString(8, 3));
    }
    
    @Test
    public void getStringAcrossClauses(@Mocked final Clause clause1,
        @Mocked final Clause clause2) throws BadLocationException
    {
        new NonStrictExpectations() {{
            clause1.getText(); result = "First, ";
            clause1.next(); result = clause2;
            clause2.getText(); result = "second";
        }};
        
        assertEquals(", s", contentify(clause1, clause2).getString(5, 3));
    }
    
    @Test
    public void getStringFromBeginningOfContent(@Mocked final Clause clause1,
        @Mocked final Clause clause2) throws BadLocationException
    {
        new NonStrictExpectations() {{
            clause1.getText(); result = "First clause";
            clause2.getText(); result = "Whatever";
        }};
        
        assertEquals("First ", contentify(clause1, clause2).getString(0, 6));
    }
    
    @Test
    public void getStringFromBeginningOfContentAcrossClauses(@Mocked final Clause clause1,
        @Mocked final Clause clause2) throws BadLocationException
    {
        new NonStrictExpectations() {{
            clause1.getText(); result = "First, ";
            clause1.next(); result = clause2;
            clause2.getText(); result = "second";
        }};
        
        assertEquals("First, sec", contentify(clause1, clause2).getString(0, 10));
    }
    
    @Test
    public void getStringToEndOfContent(@Mocked final Clause clause1,
        @Mocked final Clause clause2) throws BadLocationException
    {
        new NonStrictExpectations() {{
            clause1.getText(); result = "First, ";
            clause1.next(); result = clause2;
            clause2.getText(); result = "second";
        }};
        
        assertEquals("st, second", contentify(clause1, clause2).getString(3, 10));
    }
    
    @Test
    public void getStringFromEntireContent(@Mocked final Clause clause1,
        @Mocked final Clause clause2) throws BadLocationException
    {
        new NonStrictExpectations() {{
            clause1.getText(); result = "First, ";
            clause1.next(); result = clause2;
            clause2.getText(); result = "second";
        }};
        
        assertEquals("First, second", contentify(clause1, clause2).getString(0, 13));
    }
    
    @Test
    public void lengthCountsCharactersInClauses(@Mocked final Clause clause1,
        @Mocked final Clause clause2)
    {   
        new Expectations() {{
            clause1.getText(); result = "This is the first clause, and "; times = 1;
            clause2.getText(); result = "this is the second."; times = 1;
        }};
        
        Content content = contentify(clause1, clause2);
        
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
    
    // Utility
    private Content contentify(Clause... clauses)
    {
        List<Clause> out = new ArrayList<Clause>();
        
        for (Clause clause : clauses)
        {
            out.add(clause);
        }
        
        return new ScrapContent(out);
    }
}
