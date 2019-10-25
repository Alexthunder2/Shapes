package code;

import code.class_jerarchi.Cilindre;
import code.class_jerarchi.Cube;
import code.class_jerarchi.Sphere;
import code.containers.Backpack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    private JFrame myFrame;
    private JButton push;
    private JButton delete;
    private JTextArea pano;
    private JLabel label1;
    private JLabel label2;
    private JPanel left;
    private JPanel center;
    private JPanel right;
    private JList<String> list;
    private JLabel radius;
    private JLabel height;
    private JTextField f1;
    private JTextField f2;
    private JButton ok;
    private JLabel last;
    private JPanel pan3;
    private JButton minus;
    private JButton plus;
    private JTextField index;
    private JButton ok2;
    private Backpack pack;
    private String element;


    public View() {
        Prepare();
    }

    public void Prepare() {
        pack = new Backpack(10000);
        myFrame = new JFrame("Backpack project");
        myFrame.setSize(700, 500);
        myFrame.setLayout(new GridLayout(1, 3));

        left = new JPanel();
        left.setLayout(new GridLayout(2, 1));
        label1 = new JLabel("   Backpack contains:");
        left.add(label1);
        pano = new JTextArea();
        //pano.setText("ugh,kzr\nr.jng.");
        left.add(pano);

        center = new JPanel();
        center.setLayout(new GridLayout(8, 1));
        push = new JButton("PUSH");
        // push.setMargin();
        push.setMaximumSize(new Dimension(50, 50));
        push.setPreferredSize(new Dimension(50, 50));
        //push.setSize(50, 50);
        center.add(push);
        label2 = new JLabel("   Choose a figure");
        center.add(label2);
        list = new JList<String>();
        list.setListData(new String[]{"Cube", "Cilinder", "Sphere"});
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        center.add(list);
        radius = new JLabel("radius:");
        center.add(radius);
        f1 = new JTextField();
        center.add(f1);
        height = new JLabel("height:");
        center.add(height);
        f2 = new JTextField();
        center.add(f2);
        ok = new JButton("OK");
        center.add(ok);

        right = new JPanel();
        right.setLayout(new GridLayout(4, 1));
        delete = new JButton("DELETE");
        right.add(delete);
        last = new JLabel("Choose index to delete");
        right.add(last);
        pan3 = new JPanel();
        pan3.setLayout(new GridLayout(1, 3));
        minus = new JButton("-");
        pan3.add(minus);
        index = new JTextField();
        index.setText("1");
        pan3.add(index);
        plus = new JButton("+");
        pan3.add(plus);
        right.add(pan3);
        ok2 = new JButton("OK");
        right.add(ok2);

        myFrame.add(left);
        myFrame.add(center);
        myFrame.add(right);

        pano.setEditable(false);
        label2.setVisible(false);
        ok.setVisible(false);
        ok2.setVisible(false);
        plus.setVisible(false);
        minus.setVisible(false);
        radius.setVisible(false);
        height.setVisible(false);
        index.setVisible(false);
        f1.setVisible(false);
        f2.setVisible(false);
        list.setVisible(false);
        last.setVisible(false);

        push.addActionListener(new ButtonClickListener());
        push.setActionCommand("push");
        delete.addActionListener(new ButtonClickListener());
        delete.setActionCommand("delete");
        ok.addActionListener(new ButtonClickListener());
        ok.setActionCommand("ok");
        ok2.addActionListener(new ButtonClickListener());
        ok2.setActionCommand("ok2");
        plus.addActionListener(new ButtonClickListener());
        plus.setActionCommand("plus");
        minus.addActionListener(new ButtonClickListener());
        minus.setActionCommand("minus");
        list.addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        element = list.getSelectedValue();
                        if (element == "Cube") {
                            radius.setText("edge:");
                            radius.setVisible(true);
                            f1.setVisible(true);
                            height.setVisible(false);
                            f2.setVisible(false);
                        }
                        if (element == "Cilinder") {
                            radius.setText("radius:");
                            radius.setVisible(true);
                            f1.setVisible(true);
                            height.setVisible(true);
                            f2.setVisible(true);
                        }
                        if (element == "Sphere") {
                            radius.setText("radius:");
                            radius.setVisible(true);
                            f1.setVisible(true);
                            height.setVisible(false);
                            f2.setVisible(false);
                        }
                        ok.setVisible(true);
                    }
                });
    }

    public void Show() {
        myFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("push")) {
                label2.setVisible(true);
                list.setVisible(true);
            }
            if (command.equals("delete")) {
                if (pack.getSize() > 0) {
                    last.setVisible(true);
                    plus.setVisible(true);
                    minus.setVisible(true);
                    ok2.setVisible(true);
                    index.setVisible(true);
                }
            }
            if (command.equals("ok")) {
                int wasadded = 0;
                if ((element.equals("Cube")) && (!f1.getText().equals(""))) {
                    double x = Double.parseDouble(f1.getText());
                    Cube cube = new Cube(x);
                    pack.add(cube);
                    wasadded = 1;
                }
                if ((element.equals("Sphere")) && (!f1.getText().equals(""))) {
                    double x = Double.parseDouble(f1.getText());
                    Sphere sphere = new Sphere(x);
                    pack.add(sphere);
                    wasadded = 1;
                }
                if ((element.equals("Cilinder")) && (!f1.getText().equals("")) && (!f2.getText().equals(""))) {
                    double x = Double.parseDouble(f1.getText());
                    double y = Double.parseDouble(f2.getText());
                    Cilindre cili = new Cilindre(x, y);
                    pack.add(cili);
                    wasadded = 1;
                }

                if (wasadded == 1) {
                    label2.setVisible(false);
                    list.setVisible(false);
                    ok.setVisible(false);
                    height.setVisible(false);
                    radius.setVisible(false);
                    index.setVisible(false);
                    f1.setVisible(false);
                    f2.setVisible(false);
                    PrintBP();
                }
            }
            if (command.equals("ok2")) {
                pack.delete(Integer.parseInt(index.getText()) - 1);
                PrintBP();
                last.setVisible(false);
                plus.setVisible(false);
                minus.setVisible(false);
                ok2.setVisible(false);
                index.setText("1");
                index.setVisible(false);
            }
            if (command.equals("plus")) {
                int in = Integer.parseInt(index.getText());
                if (in < pack.getSize()) {
                    index.setText(Integer.toString(in + 1));
                }
            }
            if (command.equals("minus")) {
                int in = Integer.parseInt(index.getText());
                if (in > 1) {
                    index.setText(Integer.toString(in - 1));
                }
            }
        }
    }

    public void PrintBP() {
        pano.setText("");
        java.util.List<String> names = pack.getNames();
        java.util.List<Double> volumes = pack.getVolumes();
        for (int i = 0; i < pack.getSize(); i++) {
            pano.setText(pano.getText() + "  " + names.get(i) + " with volume " + Double.toString(volumes.get(i)) + "\n");
        }
    }
}
