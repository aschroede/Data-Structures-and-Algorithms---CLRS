package GraphAlgorithms;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GraphTester {

    public static void main(String[] args) throws IOException {

        WeightedGraph graph = new WeightedGraph(true);

        String filePath = SelectGraphFile();
        graph.BuildGraph(filePath);
        Dijkstra.Dijkstra(graph, 0);
    }

    private static String SelectGraphFile() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        final JFrame iFRAME = new JFrame();
        iFRAME.setAlwaysOnTop(true);    // ****
        iFRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iFRAME.setLocationRelativeTo(null);
        iFRAME.requestFocus();

        JFileChooser jfc = new JFileChooser("C:\\Git\\Data-Structures-and-Algorithms---CLRS\\Resources");
        int returnValue = jfc.showOpenDialog(iFRAME);
        iFRAME.dispose();
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            // Display selected file in console
            return selectedFile.getAbsolutePath();
        }
        else {
            System.out.println("No File Selected!");
            return null;
        }
    }
}


