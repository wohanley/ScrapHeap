package com.wohanley.ScrapHeap.main.document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.undo.UndoableEdit;

import com.wohanley.ScrapHeap.main.scraps.Clause;

public class ScrapContent implements Content
{
    private List<Clause> clauses;
    private Set<ContentChangeObserver> observers;
    
    public ScrapContent(List<Clause> clauses)
    {
        this.clauses = clauses;
        
        observers = new HashSet<ContentChangeObserver>();
    }
    
    @Override
    public Position createPosition(final int offset) throws BadLocationException
    {
        ScrapContentPosition position = new ScrapContentPosition(offset);
        observers.add(position); // TODO: use weak references?
        return position;
    }
    
    private class ScrapContentPosition implements Position, ContentChangeObserver
    {
        private int offset;
        
        public ScrapContentPosition(final int offset) throws BadLocationException
        {
            checkContentBounds(offset);
            
            this.offset = offset;
        }
        
        @Override
        public int getOffset()
        {
            return offset;
        }

        @Override
        public void stringInserted(final UndoableEdit edit)
        {
            
        }

        @Override
        public void stringRemoved(final UndoableEdit edit)
        {
            // TODO Auto-generated method stub
            
        }
    }
    
    /**
     * Translate a position in the content into a position in a clause. If
     * the content is empty (contains no clauses), null is returned.
     * 
     * @param offset the position to find
     * @return the Clause containing the position
     * @throws BadLocationException if the content doesn't contain the specified position
     */
    private ClausePosition getClausePosition(final int offset) throws BadLocationException
    {
        checkContentBounds(offset);
        
        if (clauses.isEmpty())
        {
            return null;
        }
        
        Clause clause = clauses.get(0);
        int currentPosition = 0;
        
        while (currentPosition + clause.getText().length() < offset)
        {
            currentPosition += clause.getText().length();
            clause = clause.next();
        }
        
        return new ClausePosition(clause, offset - currentPosition);
    }

    @Override
    public void getChars(final int offset, final int length, final Segment out) throws BadLocationException
    {
        // I'm not 100% on this - Segment's Javadoc says to treat it as immutable,
        // but this method is meant to copy new content into one?
        out.array = getString(offset, length).toCharArray();
    }

    @Override
    public String getString(final int offset, final int length) throws BadLocationException
    {
        checkContentBounds(offset, length);
        
        ClausePosition cp = getClausePosition(offset);
        
        StringBuilder found = new StringBuilder(length);
        
        while (found.length() < length)
        {
            String text = cp.getClause().getText().substring(cp.getOffset());
            
            if (found.length() + text.length() < length)
            {
                found.append(text);
                cp = new ClausePosition(cp.getClause().next(), 0);
            }
            else
            {
                int charsNeeded = length - found.length();
                found.append(text.substring(0, charsNeeded));
            }
        }
        
        return found.toString();
    }

    @Override
    public UndoableEdit insertString(final int offset, final String insert) throws BadLocationException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UndoableEdit remove(final int offset, final int length) throws BadLocationException
    {
        // TODO Auto-generated method stub
        return null;
    }
    

    @Override
    public int length()
    {
        if (clauses == null)
        {
            return 0;
        }
        
        int length = 0;
        
        for (Clause clause : clauses)
        {
            length += clause.getText().length();
        }
        
        return length;
    }
    
    // Utility
    private void checkContentBounds(int location) throws BadLocationException
    {
        if (location < 0)
        {
            throw new BadLocationException("Offset cannot be negative.", location);
        }
    }
    
    private void checkContentBounds(int offset, int length) throws BadLocationException
    {
        checkContentBounds(offset);

        if (offset + length > length())
        {
            throw new BadLocationException("Requested string passes end of document.", offset);
        }
    }
}
