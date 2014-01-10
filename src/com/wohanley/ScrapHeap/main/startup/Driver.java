package com.wohanley.ScrapHeap.main.startup;

import javax.swing.SwingUtilities;

import com.wohanley.ScrapHeap.main.dao.ScrapRepository;
import com.wohanley.ScrapHeap.main.dao.neo4j.Neo4jRepository;
import com.wohanley.ScrapHeap.main.gui.MainWindow;

public class Driver
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {    
            @Override
            public void run()
            {
                MainWindow frame = new MainWindow(new Neo4jRepository());
            }
        });
    }
}
