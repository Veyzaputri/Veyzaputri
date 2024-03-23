import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.*;

class DataMahasiswa {

    private final String nim;
    private final String nama;
    private final double tugas;
    private final double kuis;
    private final String divisi;

    public DataMahasiswa(String nim, String nama, double tugas, double kuis, String divisi) {
        this.nim = nim;
        this.nama = nama;
        this.tugas = tugas;
        this.kuis = kuis;
        this.divisi = divisi;
    }

    public void hitungHasil() {
        double rataRata;
        if (divisi.equalsIgnoreCase("Kelas Praktikum")) {
            rataRata = (this.kuis * 0.7) + (this.tugas * 0.3);
        } else {
            rataRata = (this.kuis * 0.3) + (this.tugas * 0.7);
        }
        String hasil = (rataRata >= 85) ? "Lulus" : "Tidak Lulus";
        JOptionPane.showMessageDialog(null, "Hasil: " + hasil);
    }

    public void tampilkanInfo() {
        JOptionPane.showMessageDialog(null, "NIM: " + this.nim
                + "\nNama: " + this.nama
                + "\nDivisi: " + this.divisi
                + "\nNilai Tugas: " + this.tugas
                + "\nNilai Kuis: " + this.kuis);
    }
}

public class Login extends JPanel {
    private JTextField nimField, namaField, tugasField, kuisField;
    private JButton submitButton, exitButton;
    private JRadioButton praktikumRadio, teoriRadio;
private JTextArea resultArea;
    public Login() {
        initComponents();
    }

    private void initComponents() {
        JLabel nimLabel = new JLabel("NIM:");
        nimField = new JTextField(10);

        JLabel nameLabel = new JLabel("Nama:");
        namaField = new JTextField(10);

        JLabel tugasLabel = new JLabel("Nilai Tugas:");
        tugasField = new JTextField(10);

        JLabel kuisLabel = new JLabel("Nilai Kuis:");
        kuisField = new JTextField(10);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitData();
            }
        });
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        praktikumRadio = new JRadioButton("Kelas Praktikum");
        teoriRadio = new JRadioButton("Kelas Teori");

        ButtonGroup group = new ButtonGroup();
        group.add(praktikumRadio);
        group.add(teoriRadio);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nimLabel)
                        .addComponent(nameLabel)
                        .addComponent(tugasLabel)
                        .addComponent(kuisLabel)
                        .addComponent(praktikumRadio)
                        .addComponent(teoriRadio)
                        .addComponent(submitButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nimField)
                        .addComponent(namaField)
                        .addComponent(tugasField)
                        .addComponent(kuisField)
                        .addComponent(exitButton))
                        
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nimLabel)
                        .addComponent(nimField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(namaField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tugasLabel)
                        .addComponent(tugasField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(kuisLabel)
                        .addComponent(kuisField))
                .addComponent(praktikumRadio)
                .addComponent(teoriRadio)
                .addComponent(submitButton)
                .addComponent(exitButton)
        );
    }

    private void submitData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        double tugas = Double.parseDouble(tugasField.getText());
        double kuis = Double.parseDouble(kuisField.getText());
        String divisi = praktikumRadio.isSelected() ? "Kelas Praktikum" : "Kelas Teori";

        DataMahasiswa mhs = new DataMahasiswa(nim, nama, tugas, kuis, divisi);
        mhs.tampilkanInfo();
        mhs.hitungHasil();
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Data Mahasiswa");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.getContentPane().add(new Login());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
