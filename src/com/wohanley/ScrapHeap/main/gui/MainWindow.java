package com.wohanley.ScrapHeap.main.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;

import com.wohanley.ScrapHeap.main.dao.ScrapRepository;

public class MainWindow extends JFrame
{
    private ScrapRepository repo;
    
    private JTextPane textPane;
    private AbstractDocument doc;
    private String newline = "\n";
    private HashMap<Object, Action> actions;

    //undo helpers
    //protected UndoAction undoAction;
    //protected RedoAction redoAction;
    protected UndoManager undo = new UndoManager();
    
    public MainWindow(ScrapRepository repo)
    {
        super("ScrapHeap");
        
        this.repo = repo;
        
        initEditorPane();
        
        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        
        StyledDocument styledDoc = textPane.getStyledDocument();
        
        if (styledDoc instanceof AbstractDocument) {
            doc = (AbstractDocument)styledDoc;
            doc.addDocumentListener(new ClauseDetectionListener());
        } else {
            System.err.println("Text pane's document isn't an AbstractDocument!");
            System.exit(-1);
        }
        
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        setVisible(true);
        pack();
    }
    
    private void initEditorPane()
    {
        
    }
}
