
package tampilan;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.koneksi;

/**
 *
 * @author Rudini
 */
public class InventarisMasuk extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    public String kdbrg, nmbrg, kategbrg, mrk, uk;
    public String kdlok, nmlok;
    private DefaultTableModel tabmode;
    /**
     * Creates new form InventarisMasuk
     */
    public InventarisMasuk() {
        initComponents();
        String KD = UserID.getUserLogin();
        iduser.setText(KD);        
        kosong();
        aktif();
        autonumber();
        nama();
        datatable();
        
        nmTextField.setEditable(false);
        kdTextField.setEditable(false);
        mrkTextField.setEditable(false);
        ukTextField.setEditable(false);
        kdlokTextField.setEditable(false);
        nmlokTextField.setEditable(false);
    }
    
    protected void nama() {
        try {
            String sql = "SELECT * FROM tb_user WHERE id_user='" + iduser.getText() + "'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                nmuser.setText(hasil.getString("nama"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil " + e);
        }
    }

    protected void aktif() {
        kdTextField.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl, "yyyy/MM/dd"));
//        Object[] baris = {"KD Barang", "Nama", "Harga Beli", "Harga Jual", "Qty", "Total"};
//        tabmode = new DefaultTableModel(null, baris);
//        tableinvmsk.setModel(tabmode);
    }

    protected void kosong() {
        kdTextField.setText("");
        nmTextField.setText("");
        ktgTextField.setText("");
        mrkTextField.setText("");
        ukTextField.setText("");
        jmlTextField.setText("");
        nilTextField.setText("");
        kdlokTextField.setText("");
        nmlokTextField.setText("");
    }

    protected void autonumber() {
        try {
            String sql = "SELECT kd_inventaris_masuk FROM tb_inventaris_masuk ORDER BY kd_inventaris_masuk DESC LIMIT 1";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            idinvTextField.setText("IN0001");
            while (hasil.next()) {
                System.out.println(hasil.getString("kd_inventaris_masuk").substring(2));
                String id_inventori = hasil.getString("kd_inventaris_masuk").substring(2);
                int AN = Integer.parseInt(id_inventori) + 1;
                String Nol = "";

                if (AN < 10) {
                    Nol = "000";
                } else if (AN < 100) {
                    Nol = "00";
                } else if (AN < 1000) {
                    Nol = "0";
                } else if (AN < 10000) {
                    Nol = "";
                }

                idinvTextField.setText("IN" + Nol + AN);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto number gagal " + e);
        }
    }
    
    public void itemTerpilih() {
        PopupBarang pp = new PopupBarang();
        pp.brg = this;
        kdTextField.setText(kdbrg);
        nmTextField.setText(nmbrg);
        ktgTextField.setText(kategbrg);
        mrkTextField.setText(mrk);
        ukTextField.setText(uk);
    }
    
    public void lokasiTerpilih() {
        PopupLokasi pp = new PopupLokasi();
        pp.lks = this;
        kdlokTextField.setText(kdlok);
        nmlokTextField.setText(nmlok);
    }
    
    protected void datatable(){
        Object[] Baris = {"ID Inventaris Masuk", "Kode Barang", "Jumlah", "Nilai","Tanggal Masuk","ID User","Kode Lokasi"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = cariTextField.getText();            
        try{
            String sql = "SELECT * FROM tb_inventaris_masuk WHERE kd_inventaris_masuk like '%"+cariitem+"%' or kd_barang like '%"+cariitem+"%' order by kd_inventaris_masuk asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7)
                });
            }
            tableinvmsk.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di panggil"+e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idinvTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jmlTextField = new javax.swing.JTextField();
        ktgTextField = new javax.swing.JTextField();
        nmTextField = new javax.swing.JTextField();
        kdTextField = new javax.swing.JTextField();
        caribrgButtom = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        nilTextField = new javax.swing.JTextField();
        ukTextField = new javax.swing.JTextField();
        mrkTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kdlokTextField = new javax.swing.JTextField();
        carilokButtom = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nmlokTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableinvmsk = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cariButtom = new javax.swing.JButton();
        cariTextField = new javax.swing.JTextField();
        keluarButtom = new javax.swing.JButton();
        batalButtom = new javax.swing.JButton();
        hapusButtom = new javax.swing.JButton();
        ubahButtom = new javax.swing.JButton();
        simpanButtom = new javax.swing.JButton();
        iduser = new javax.swing.JLabel();
        nmuser = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INVENTARIS MASUK");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ID User");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ID Inventaris Maasuk");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Nama User");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tanggal Masuk");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        jPanel2.setBackground(new java.awt.Color(102, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama Barang");

        jLabel5.setText("Kategori Barang");

        jLabel7.setText("Jumlah");

        jmlTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmlTextFieldActionPerformed(evt);
            }
        });

        kdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdTextFieldActionPerformed(evt);
            }
        });

        caribrgButtom.setBackground(new java.awt.Color(0, 0, 0));
        caribrgButtom.setForeground(new java.awt.Color(255, 255, 255));
        caribrgButtom.setText("Cari");
        caribrgButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribrgButtomActionPerformed(evt);
            }
        });

        jLabel12.setText("Nilai Barang");

        jLabel11.setText("Merek");

        jLabel14.setText("Ukuran");

        kdlokTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdlokTextFieldActionPerformed(evt);
            }
        });

        carilokButtom.setBackground(new java.awt.Color(0, 0, 0));
        carilokButtom.setForeground(new java.awt.Color(255, 255, 255));
        carilokButtom.setText("Cari");
        carilokButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carilokButtomActionPerformed(evt);
            }
        });

        jLabel6.setText("Kode Lokasi");

        jLabel15.setText("Nama Lokasi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(80, 80, 80))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(103, 103, 103)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ktgTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(nmTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(kdlokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carilokButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)))
                    .addComponent(nilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(kdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caribrgButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jmlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mrkTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(ukTextField)
                    .addComponent(nmlokTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(caribrgButtom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(mrkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ukTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ktgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kdlokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carilokButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(nmlokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(29, 29, 29))
        );

        jPanel3.setBackground(new java.awt.Color(102, 255, 204));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        tableinvmsk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableinvmsk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableinvmskMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableinvmsk);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel13.setText("List Data Inventaris Masuk :");

        cariButtom.setBackground(new java.awt.Color(0, 0, 0));
        cariButtom.setForeground(new java.awt.Color(255, 255, 255));
        cariButtom.setText("Cari");
        cariButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtomActionPerformed(evt);
            }
        });

        cariTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTextFieldActionPerformed(evt);
            }
        });
        cariTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariButtom))
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        keluarButtom.setBackground(new java.awt.Color(102, 255, 102));
        keluarButtom.setText("Keluar");
        keluarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarButtomActionPerformed(evt);
            }
        });

        batalButtom.setBackground(new java.awt.Color(255, 255, 102));
        batalButtom.setText("Batal");
        batalButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtomActionPerformed(evt);
            }
        });

        hapusButtom.setBackground(new java.awt.Color(255, 102, 102));
        hapusButtom.setText("Hapus");
        hapusButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtomActionPerformed(evt);
            }
        });

        ubahButtom.setBackground(new java.awt.Color(255, 102, 255));
        ubahButtom.setText("Ubah");
        ubahButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahButtomActionPerformed(evt);
            }
        });

        simpanButtom.setBackground(new java.awt.Color(102, 102, 255));
        simpanButtom.setText("Simpan");
        simpanButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtomActionPerformed(evt);
            }
        });

        iduser.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        iduser.setText("ID User");

        nmuser.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        nmuser.setText("Nama User");

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpanButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubahButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapusButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batalButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(keluarButtom))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iduser)
                            .addComponent(idinvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmuser)
                            .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(iduser)
                    .addComponent(nmuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idinvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubahButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keluarButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kdTextFieldActionPerformed

    private void caribrgButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribrgButtomActionPerformed
        PopupBarang pp = new PopupBarang();
        pp.brg = this;
        pp.setVisible(true);
        pp.setResizable(false);
    }//GEN-LAST:event_caribrgButtomActionPerformed

    private void tableinvmskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableinvmskMouseClicked
        int bar = tableinvmsk.getSelectedRow();
        String id_inv = tabmode.getValueAt(bar, 0).toString();
        String kd_brg = tabmode.getValueAt(bar, 1).toString();
        String jml = tabmode.getValueAt(bar, 2).toString();
        String nil = tabmode.getValueAt(bar, 3).toString();
//        String tgl = tabmode.getValueAt(bar, 4).toString();
        String kd_lok = tabmode.getValueAt(bar, 6).toString();
        try{
            String sql = "SELECT * FROM tb_barang WHERE kd_barang='"+kd_brg+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                nmTextField.setText(hasil.getString("nama_barang"));
                ktgTextField.setText(hasil.getString("kategori_barang"));
                mrkTextField.setText(hasil.getString("merek"));
                ukTextField.setText(hasil.getString("ukuran"));
            }    
            String sql2 = "SELECT * FROM tb_lokasi WHERE kd_lokasi='"+kd_lok+"'";
            Statement stat2 = conn.createStatement();
            ResultSet hasil2 = stat2.executeQuery(sql2);
            if (hasil2.next()) {
                kdlokTextField.setText(hasil2.getString("kd_lokasi"));
                nmlokTextField.setText(hasil2.getString("nama_lokasi"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil " + e);
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        String fd = sdf.format(jtgl.setValue(tgl));
        kdTextField.setText(kd_brg);
        jmlTextField.setText(jml);
        nilTextField.setText(nil);
//        jtgl.setV(tgl);
        kdlokTextField.setText(kd_lok);
    }//GEN-LAST:event_tableinvmskMouseClicked

    private void keluarButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarButtomActionPerformed
        dispose();
    }//GEN-LAST:event_keluarButtomActionPerformed

    private void batalButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtomActionPerformed
        kosong();
        datatable();
    }//GEN-LAST:event_batalButtomActionPerformed

    private void hapusButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtomActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin menghapus data ini?", "konfirm dialog", JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "DELETE FROM tb_inventaris_masuk WHERE kd_inventaris_masuk='"+idinvTextField.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
                kosong();
                kdTextField.requestFocus();
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal di hapus"+e);
            }
            datatable();
        }
    }//GEN-LAST:event_hapusButtomActionPerformed

    private void ubahButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtomActionPerformed
        String sql = "UPDATE tb_inventaris_masuk SET kd_barang=?,jumlah=?,nilai_barang=?,tanggal_masuk=?,kd_lokasi=? WHERE kd_inventaris_masuk='"+idinvTextField.getText()+"'";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fd = sdf.format(jtgl.getValue());
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kdTextField.getText());
            stat.setString(2, jmlTextField.getText());
            stat.setString(3, nilTextField.getText());
            stat.setString(4, fd);
            stat.setString(5, kdlokTextField.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            kosong();
            kdTextField.requestFocus();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di ubah"+e);
        }
        datatable();
    }//GEN-LAST:event_ubahButtomActionPerformed

    private void simpanButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtomActionPerformed
        String sql = "INSERT INTO tb_inventaris_masuk VALUES (?,?,?,?,?,?,?)";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fd = sdf.format(jtgl.getValue());
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idinvTextField.getText());
            stat.setString(2, kdTextField.getText());
            stat.setString(3, jmlTextField.getText());
            stat.setString(4, nilTextField.getText());
            stat.setString(5, fd);
            stat.setString(6, iduser.getText());
            stat.setString(7, kdlokTextField.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil di simpan");
            kosong();
            kdTextField.requestFocus();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di simapan"+e);
        }
        datatable();
    }//GEN-LAST:event_simpanButtomActionPerformed

    private void cariButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtomActionPerformed
        datatable();
    }//GEN-LAST:event_cariButtomActionPerformed

    private void cariTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariTextFieldActionPerformed

    private void cariTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTextFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatable();
        }
    }//GEN-LAST:event_cariTextFieldKeyPressed

    private void jmlTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmlTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmlTextFieldActionPerformed

    private void kdlokTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdlokTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kdlokTextFieldActionPerformed

    private void carilokButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carilokButtomActionPerformed
        PopupLokasi pp = new PopupLokasi();
        pp.lks = this;
        pp.setVisible(true);
        pp.setResizable(false);
    }//GEN-LAST:event_carilokButtomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventarisMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarisMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarisMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarisMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarisMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButtom;
    private javax.swing.JButton cariButtom;
    private javax.swing.JTextField cariTextField;
    private javax.swing.JButton caribrgButtom;
    private javax.swing.JButton carilokButtom;
    private javax.swing.JButton hapusButtom;
    private javax.swing.JTextField idinvTextField;
    private javax.swing.JLabel iduser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jmlTextField;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTextField kdTextField;
    private javax.swing.JTextField kdlokTextField;
    private javax.swing.JButton keluarButtom;
    private javax.swing.JTextField ktgTextField;
    private javax.swing.JTextField mrkTextField;
    private javax.swing.JTextField nilTextField;
    private javax.swing.JTextField nmTextField;
    private javax.swing.JTextField nmlokTextField;
    private javax.swing.JLabel nmuser;
    private javax.swing.JButton simpanButtom;
    private javax.swing.JTable tableinvmsk;
    private javax.swing.JButton ubahButtom;
    private javax.swing.JTextField ukTextField;
    // End of variables declaration//GEN-END:variables
}
