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
    public Position createPosition(int offset) throws BadLocationException
    {
        ScrapContentPosition position = new ScrapContentPosition(offset);
        observers.add(position);
        return position;
    }
    
    private class ScrapContentPosition implements Position, ContentChangeObserver
    {
        private int offset;
        
        public ScrapContentPosition(int offset) throws BadLocationException
        {
            if (offset < 0)
            {
                throw new BadLocationException("Offset must be non-negative.", offset);
            }
            
            this.offset = offset;
        }
        
        @Override
        public int getOffset()
        {
            return offset;
        }

        @Override
        public void stringInserted(UndoableEdit edit)
        {
            
        }

        @Override
        public void stringRemoved(UndoableEdit edit)
        {
            // TODO Auto-generated method stub
            
        }
    }

    @Override
    public void getChars(int arg0, int arg1, Segment arg2) throws BadLocationException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getString(int arg0, int arg1) throws BadLocationException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UndoableEdit insertString(int arg0, String arg1) throws BadLocationException
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

    @Override
    public UndoableEdit remove(int arg0, int arg1) throws BadLocationException
    {
        // TODO Auto-generated method stub
        return null;
    }
}
