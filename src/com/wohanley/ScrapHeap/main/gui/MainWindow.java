package com.wohanley.ScrapHeap.main.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.wohanley.ScrapHeap.main.dao.ScrapRepository;

public class MainWindow extends JFrame
{
    private ScrapRepository repo;
    
    public MainWindow(ScrapRepository repo)
    {
        super();
        this.repo = repo;
        
        this.setPreferredSize(new Dimension(300, 300));
        this.setVisible(true);
        this.pack();
    }
}
