
package PILIHAN;
import DATA.popupPD;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksiSPK;

public class pemilihan extends javax.swing.JPanel {
private Connection conn = new koneksiSPK().connect();
private DefaultTableModel tabmode;

public double[] bakat,hobi,tk,minat,pengalaman,hasilRank = new double[3];
public double[] bobotK;
public int[] noR = new int[3];
ArrayList<Double> bobotKriteria = new ArrayList<>();
public String getNamPD;
public String[]SKPilihanE= new String[3];
public String[]SKPilihanM= new String[3];
public String[]SKPilihanP= new String[3];
public String SKPilihanB;
public String SKPilihanH;
public String SKPilihanT;

    public pemilihan() {
        initComponents();
        setEkskul();
        noUrut();
        datatableHasil();
    }

    protected void kosong(){
        noUrut();
        namaPD.setText("");
        skB.setSelectedIndex(-1);
        skH.setSelectedIndex(-1);
    }
    public void itemTerpilihPD(){
        popupPD puPD = new popupPD();
        puPD.pPD = this;
        namaPD.setText(getNamPD);
    }
    public void setEkskul(){    
        try {
            String sql = "SELECT namaE FROM e order by namaE asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            
            // Mengambil data dari ResultSet dan memasukkannya ke dalam ArrayList
            ArrayList<String> dataList = new ArrayList<>();
            while (hasil.next()) {
                String data = hasil.getString("namaE");
                dataList.add(data);
            }
            
            for (String item : dataList) {
                skE1.addItem(item);
                skE2.addItem(item);
                skE3.addItem(item);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    
    }
    public void getSKPilihanE(){
        SKPilihanE[0] = (String) skE1.getSelectedItem();
        SKPilihanE[1] = (String) skE2.getSelectedItem();
        SKPilihanE[2] = (String) skE3.getSelectedItem();
        System.out.println(Arrays.toString(SKPilihanE));
    }
    
    public void getSKPilihanM(){
        SKPilihanM[0] = (String) skM1.getSelectedItem();
        SKPilihanM[1] = (String) skM2.getSelectedItem();
        SKPilihanM[2] = (String) skM3.getSelectedItem();
        System.out.println(Arrays.toString(SKPilihanM));
    }
    public void getSKPilihanP(){
        SKPilihanP[0] = (String) skP1.getSelectedItem();
        SKPilihanP[1] = (String) skP2.getSelectedItem();
        SKPilihanP[2] = (String) skP3.getSelectedItem();
        System.out.println(Arrays.toString(SKPilihanP));
    }
    public void getSKPilihanB(){
        SKPilihanB = (String) skB.getSelectedItem();
        System.out.println((SKPilihanB));
    }
    public void getSKPilihanH(){
        SKPilihanH = (String) skH.getSelectedItem();
        System.out.println(SKPilihanH);
    }
    public void getSKPilihanT(){
        SKPilihanT = (String) skT.getSelectedItem();
        System.out.println(SKPilihanT);
    }
    
    public void getBobotBakat() {
    // Initialize the bakat array with the correct size
    bakat = new double[3];
    
    try {           
        for (int i = 0; i < 3; i++) {
            // Query SQL
            String sql = "SELECT bobotSK FROM sk WHERE namaK='Bakat' AND "
                    + "namaSK=? AND ekskul=? order by bobotSK desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, SKPilihanB);
            stmt.setString(2, SKPilihanE[i]);
            ResultSet hasil = stmt.executeQuery();
            if (hasil.next()) {
                bakat[i] = hasil.getDouble("bobotSK");
            } else {bakat[i] = 0.0;}
        }                
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e);
        System.out.println(e);
    }
    System.out.println(Arrays.toString(bakat));
}
    public void getBobotHobi() {
    hobi = new double[3];
    
    try {            
        for (int i = 0; i < 3; i++) {
            // Query SQL
            String sql = "SELECT bobotSK FROM sk WHERE namaK='Hobi' AND "
                    + "namaSK=? AND ekskul=? order by bobotSK desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, SKPilihanH);
            stmt.setString(2, SKPilihanE[i]);
            // Execute query
            ResultSet hasil = stmt.executeQuery();
            
            if (hasil.next()) {
                hobi[i] = hasil.getDouble("bobotSK");
            } else {
                hobi[i] = 0.0; // Handle case where no data is found
            }
        
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e);
        System.out.print(e);
    }
    System.out.println(Arrays.toString(hobi));
}   
    public void getBobotTempat() {
    tk = new double[3];
    
    try {            
        for (int i = 0; i < 3; i++) {
            // Query SQL
            String sql = "SELECT bobotSK FROM sk WHERE namaK='Tempat Kegiatan' "
                    + "AND namaSK=? AND ekskul=? order by bobotSK desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, SKPilihanT);
            stmt.setString(2, SKPilihanE[i]);
            // Execute query
            ResultSet hasil = stmt.executeQuery();
            
            if (hasil.next()) {
                tk[i] = hasil.getDouble("bobotSK");
            } else {
                tk[i] = 0.0; // Handle case where no data is found
            }
        
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e);
        System.out.print(e);
    }
    System.out.println(Arrays.toString(tk));
}
    public void getBobotMinat() {
    minat = new double[3];
    
        try {
        for (int i = 0; i < SKPilihanE.length; i++) {
                // Query SQL
                String sql = "SELECT bobotSK FROM sk WHERE namaK='Minat' AND "
                        + "namaSK=? AND ekskul=? order by bobotSK desc";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, SKPilihanM[i]);
                stmt.setString(2, SKPilihanE[i]);
                // Eksekusi query
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    minat[i] = resultSet.getDouble("bobotSK");
                    }
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            System.out.print(e);
        }

            System.out.println(Arrays.toString(minat));
    }
    public void getBobotPengalaman() {
    pengalaman = new double[3];
    
        try {
        for (int i = 0; i < SKPilihanE.length; i++) {
                // Query SQL
                String sql = "SELECT bobotSK FROM sk WHERE namaK='Pengalaman' "
                        + "AND namaSK=? AND ekskul=? order by bobotSK desc";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, SKPilihanP[i]);
                stmt.setString(2, SKPilihanE[i]);
                // Eksekusi query
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    pengalaman[i] = resultSet.getDouble("bobotSK");
                    }
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            System.out.print(e);
        }

            System.out.println(Arrays.toString(pengalaman));
    }
    
    public void getBobotKriteria(){
    
        try {
                String sql = "SELECT bobotPK FROM k";
                Statement stmt = conn.createStatement();
                // Eksekusi query
                ResultSet hasil = stmt.executeQuery(sql);
                while(hasil.next()) {
                    bobotKriteria.add(hasil.getDouble("bobotPK"));
                }
                bobotK = bobotKriteria.stream().mapToDouble(i -> i).toArray();
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            System.out.print(e);
        }           
        System.out.println(Arrays.toString(bobotK));
    }
    public void RANKING(){
         // Hitung hasil ranking
        Integer[] noRank = new Integer[bakat.length];
        
        for (int i = 0; i < bakat.length; i++) {
            double bakatVal = minat[i] * bobotK[0];
            double minatVal = bakat[i] * bobotK[1];
            double hobiVal = hobi[i] * bobotK[2];
            double pengalamanVal = pengalaman[i] * bobotK[3];
            double tkVal = tk[i] * bobotK[4];

            double rankVal = bakatVal + minatVal + hobiVal + pengalamanVal + tkVal;
            hasilRank[i] = Math.round(rankVal * 100.0) / 100.0;
            noRank[i]=i;
            
            // Tampilkan detail perhitungan untuk setiap item
            System.out.println("Detail perhitungan untuk index " + SKPilihanE[i] + ":");
            System.out.println("Minat     : " + minat[i] + " * " + bobotK[0] + " = " + bakatVal);
            System.out.println("Bakat     : " + bakat[i] + " * " + bobotK[1] + " = " + minatVal);
            System.out.println("Hobi      : " + hobi[i] + " * " + bobotK[2] + " = " + hobiVal);
            System.out.println("Pengalaman: " + pengalaman[i] + " * " + bobotK[3] + " = " + pengalamanVal);
            System.out.println("TK        : " + tk[i] + " * " + bobotK[4] + " = " + tkVal);
            System.out.println("Hasil Rank: " + hasilRank[i]);
            System.out.println();
        }

        // Tampilkan hasil ranking akhir
        System.out.println("Hasil Ranking Akhir:");
        for (int i = 0; i < hasilRank.length; i++) {
            System.out.println("Rank[" + i + "] = " + hasilRank[i]);
        }
        
        // Urutkan berdasarkan hasilRank secara menurun
        Arrays.sort(noRank, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Double.compare(hasilRank[i2], hasilRank[i1]);
            }
        });
        for (int rank = 0; rank < hasilRank.length; rank++) {
            int i = noRank[rank];
            int urut=rank+1;
            noR[i]=urut;
            double valRank = hasilRank[i];
            System.out.println("Hasil Rank: "+urut+" = " + hasilRank[i]);
            System.out.print(noR[i]);
        }
    }
        
   public void noUrut(){
        try {
            // 2. Ambil Nomor Urutan Terakhir
            String query = "SELECT noidPE FROM pe ORDER BY noidPE DESC LIMIT 1";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            String lastUrutan = "";
            if (resultSet.next()) {
                lastUrutan = resultSet.getString("noidPE");
            }
            
            // 3. Parse dan Tingkatkan Nomor Urutan
            String newUrutan = generateNextUrutan(lastUrutan);
            noidPE.setText(newUrutan);
            
            // 4. Tampilkan Nomor Urutan Baru
            System.out.println("Nomor Urutan Berikutnya: " + newUrutan);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static String generateNextUrutan(String lastUrutan) {
        if (lastUrutan == null || lastUrutan.isEmpty()) {
            return "PE0001";
        }

        String prefix = lastUrutan.substring(0, 2);
        String numberPart = lastUrutan.substring(2);

        // Mengatasi format nomor urutan dengan 4 digit
        int number = Integer.parseInt(numberPart);
        number++;

        // Mengembalikan nomor urutan dengan 4 digit
        return prefix + String.format("%04d", number);
    }
    
    protected void datatableRank(){
    Object[] Baris ={"No. ID","Rank","Nama","Ekstrakurikuler","Hasil Perhitungan"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=namaPD.getText();

        try {
            String sql = "SELECT * FROM pe where noidPE='"+noidPE.getText()+"' order by rank asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidPE");
            String b=hasil.getString("rank");
            String c=hasil.getString("namaPD");
            String d=hasil.getString("ekskul");
            String e=hasil.getString("hasilBobot");

        String[] data={a,b,c,d,e};
        tabmode.addRow(data);
        }
        tabelRank.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }
    protected void datatableHasil(){
    Object[] Baris ={"No. ID","Nama","Ekstrakurikuler","Hasil Perhitungan"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=cariDP.getText();

        try {
            String sql = "SELECT * FROM epd order by noidPE asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidPE");
            String b=hasil.getString("namaPD");
            String c=hasil.getString("ekskul");
            String d=hasil.getString("hasilAkhir");

        String[] data={a,b,c,d};
        tabmode.addRow(data);
        }
        tabelET.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        namaPD = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        cariDP = new javax.swing.JTextField();
        hapus = new javax.swing.JButton();
        hitung = new javax.swing.JButton();
        noidPE = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        skE2 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        skE3 = new javax.swing.JComboBox<>();
        skH = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        skT = new javax.swing.JComboBox<>();
        skE1 = new javax.swing.JComboBox<>();
        skM1 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        skM2 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        skM3 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelET = new javax.swing.JTable();
        skB = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelRank = new javax.swing.JTable();
        skP1 = new javax.swing.JComboBox<>();
        skP2 = new javax.swing.JComboBox<>();
        skP3 = new javax.swing.JComboBox<>();
        btnCariPD = new javax.swing.JButton();
        cariPD = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        namaPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namaPDMouseClicked(evt);
            }
        });
        namaPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPDnamEActionPerformed(evt);
            }
        });

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caricariSKActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpansimpanActionPerformed(evt);
            }
        });

        cariDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariDPcariSKEActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapushapusActionPerformed(evt);
            }
        });

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitunghitungActionPerformed(evt);
            }
        });

        noidPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noidPEnamE1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("No.ID");

        skE2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        skE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skE2SK3ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Pilihan 2");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Pilihan 3");

        skE3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        skE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skE3SK4ActionPerformed(evt);
            }
        });

        skH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- KATEGORI --", "Olahraga/Ativitas Fisik", "Studi dan Pengetahuan", "Seni dan Kreativitas" }));
        skH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skHSK1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Tempat Kegiatan Pilihan");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Bakat");

        skT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Ruang Terbuka", "Ruang Tertutup", "Keduanya" }));
        skT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skTSK5ActionPerformed(evt);
            }
        });

        skE1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        skE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skE1SK2ActionPerformed(evt);
            }
        });

        skM1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minat", "Sangat berminat", "Berminat", "Cukup berminat" }));
        skM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skM1SK6ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("Ekstrakurikuler Pilihan");

        skM2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minat", "Sangat berminat", "Berminat", "Cukup berminat" }));
        skM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skM2SK7ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Hobi");

        skM3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minat", "Sangat berminat", "Berminat", "Cukup berminat" }));
        skM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skM3SK8ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Pilihan 1");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("PEMILIHAN EKSTRAKURIKULER");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Nama Peserta Didik");

        tabelET.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelETtabelSK1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelET);

        skB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- BAKAT --", "Olahraga", "Akademis", "Seni dan Karya" }));
        skB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skBkriteriaActionPerformed(evt);
            }
        });

        tabelRank.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRanktabelSKMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelRank);

        skP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengalaman", "2 Tahun", "1 Tahun", "Tidak ada" }));
        skP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skP1SK6ActionPerformed(evt);
            }
        });

        skP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengalaman", "2 Tahun", "1 Tahun", "Tidak ada" }));
        skP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skP2SK6ActionPerformed(evt);
            }
        });

        skP3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengalaman", "2 Tahun", "1 Tahun", "Tidak ada" }));
        skP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skP3SK6ActionPerformed(evt);
            }
        });

        btnCariPD.setText("Cari");
        btnCariPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPDcariSKActionPerformed(evt);
            }
        });

        cariPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPDcariSKEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(332, 332, 332))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel38))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(skH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(skB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(namaPD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(noidPE))
                                    .addComponent(jLabel41))
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(304, 304, 304))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel33)
                                                    .addComponent(jLabel39))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(skE2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(skE3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(skE1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel35))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(skM2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)
                                            .addComponent(skM1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(skM3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(skP2, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                            .addComponent(skP1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(skP3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(skT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cariPD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCariPD))
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cariDP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(skE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(skM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(skP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(skE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(skM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(skP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(skE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(skM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(skP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(skT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cariPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCariPD)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(hapus)
                            .addComponent(hitung)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noidPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(skB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(skH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void skP3SK6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skP3SK6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skP3SK6ActionPerformed

    private void skP2SK6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skP2SK6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skP2SK6ActionPerformed

    private void skP1SK6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skP1SK6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skP1SK6ActionPerformed

    private void tabelRanktabelSKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRanktabelSKMouseClicked

        int bar = tabelRank.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String c = tabmode.getValueAt(bar, 2).toString();

        noidPE.setText(a);
        namaPD.setText(c);
    }//GEN-LAST:event_tabelRanktabelSKMouseClicked

    private void skBkriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skBkriteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skBkriteriaActionPerformed

    private void tabelETtabelSK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelETtabelSK1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelETtabelSK1MouseClicked

    private void skM3SK8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skM3SK8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skM3SK8ActionPerformed

    private void skM2SK7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skM2SK7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skM2SK7ActionPerformed

    private void skM1SK6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skM1SK6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skM1SK6ActionPerformed

    private void skE1SK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skE1SK2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skE1SK2ActionPerformed

    private void skTSK5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skTSK5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skTSK5ActionPerformed

    private void skHSK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skHSK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skHSK1ActionPerformed

    private void skE3SK4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skE3SK4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skE3SK4ActionPerformed

    private void skE2SK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skE2SK3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skE2SK3ActionPerformed

    private void noidPEnamE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noidPEnamE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noidPEnamE1ActionPerformed

    private void hitunghitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitunghitungActionPerformed
        getSKPilihanE();
        getSKPilihanB();getBobotBakat();
        getSKPilihanH();getBobotHobi();
        getSKPilihanM();getBobotMinat();
        getSKPilihanP(); getBobotPengalaman();
        getSKPilihanT();getBobotTempat();
        getBobotKriteria();RANKING();
        
    // SQL untuk memasukkan data
    String insertSql = "INSERT INTO pe VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement pstmt = conn.prepareStatement(insertSql);

        for (int i = 0; i < SKPilihanE.length; i++) {
            // Jika data belum ada, masukkan ke database
            pstmt.setString(1, noidPE.getText());
            pstmt.setInt(2, noR[i]);
            pstmt.setString(3, namaPD.getText()); 
            pstmt.setString(4, SKPilihanE[i]); 
            pstmt.setDouble(5, hasilRank[i]); 
            pstmt.addBatch();
        }
            // Eksekusi batch hanya jika tidak ada duplikasi
            pstmt.executeBatch();
            System.out.println("Data berhasil dimasukkan");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data gagal dimasukkan: " + e);
        e.printStackTrace();
    }
        datatableRank();
    }//GEN-LAST:event_hitunghitungActionPerformed

    private void hapushapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapushapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasidialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from pe where noidPE ='"+noidPE.getText()+"'";
            String sql1 = "delete from epd where noidPE ='"+noidPE.getText()+"'";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            PreparedStatement stat1 = conn.prepareStatement(sql1);
            stat1.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            kosong();
            namaPD.requestFocus();
        }
        catch (SQLException e){
        JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }
        }
        datatableRank();
        datatableHasil();
    }//GEN-LAST:event_hapushapusActionPerformed

    private void cariDPcariSKEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariDPcariSKEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariDPcariSKEActionPerformed

    private void simpansimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpansimpanActionPerformed
        String getHasil = "SELECT * FROM pe WHERE rank LIKE '1' AND noidPE LIKE '%" + noidPE.getText() + "%'";
        String insertSql = "INSERT INTO epd VALUES (?, ?, ?, ?)";
        
        String updateEkskul = "UPDATE pd SET ekskul=? WHERE nama=?";
        
        String selectPD = "SELECT * FROM pd WHERE nama=?";
        String selectE = "SELECT * FROM e WHERE namaE=?";
        String insertAE = "INSERT INTO anggotae VALUES (?, ?, ?, ?, ?)";

        try {
            // Mengambil data dari tabel pe
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(getHasil);

            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            PreparedStatement updateStmt = conn.prepareStatement(updateEkskul);

            // Memproses semua baris hasil query
            while (rs.next()) {
                // Menyimpan data ke tabel epd
                insertStmt.setString(1, rs.getString("noidPE"));
                insertStmt.setString(2, rs.getString("namaPD"));
                insertStmt.setString(3, rs.getString("ekskul"));
                insertStmt.setString(4, rs.getString("hasilBobot"));
                insertStmt.executeUpdate();

                // Memperbarui data di tabel pd
                updateStmt.setString(1, rs.getString("ekskul"));
                updateStmt.setString(2, rs.getString("namaPD"));
                updateStmt.executeUpdate();
                
                // Query data tambahan dengan PreparedStatement
                PreparedStatement selectStmtPD = conn.prepareStatement(selectPD);
                selectStmtPD.setString(1, rs.getString("namaPD"));
                ResultSet rsPD = selectStmtPD.executeQuery();

                if (rsPD.next()) {
                    PreparedStatement selectStmtE = conn.prepareStatement(selectE);
                    selectStmtE.setString(1, rs.getString("ekskul"));  // Ganti parameter sesuai kebutuhan
                    ResultSet rsE = selectStmtE.executeQuery();

                    if (rsE.next()) {
                        PreparedStatement insertStmtAE = conn.prepareStatement(insertAE);
                        insertStmtAE.setString(1, rsPD.getString("nis"));
                        insertStmtAE.setString(2, rsPD.getString("nama"));
                        insertStmtAE.setString(3, rsPD.getString("kelas"));
                        insertStmtAE.setString(4, rsE.getString("noidE"));
                        insertStmtAE.setString(5, rsE.getString("namaE"));
                        insertStmtAE.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal dimasukkan: " + e);
            e.printStackTrace();
        }

        kosong();
        datatableHasil();

   
    }//GEN-LAST:event_simpansimpanActionPerformed

    private void caricariSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricariSKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caricariSKActionPerformed

    private void namaPDnamEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPDnamEActionPerformed

    }//GEN-LAST:event_namaPDnamEActionPerformed

    private void namaPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namaPDMouseClicked
        popupPD puPD = new popupPD();
        puPD.pPD = this;
        puPD.setVisible(true);
        puPD.setResizable(false);
    }//GEN-LAST:event_namaPDMouseClicked

    private void btnCariPDcariSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPDcariSKActionPerformed
    Object[] Baris ={"No. ID","Rank","Nama","Ekstrakurikuler","Hasil Perhitungan"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem=cariPD.getText();

        try {
            String sql = "SELECT * FROM pe WHERE namaPD = '" + cariPD.getText() +
             "' OR noidPE = '" + cariPD.getText() + "' ORDER BY rank ASC";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()){
            String a=hasil.getString("noidPE");
            String b=hasil.getString("rank");
            String c=hasil.getString("namaPD");
            String d=hasil.getString("ekskul");
            String e=hasil.getString("hasilBobot");

        String[] data={a,b,c,d,e};
        tabmode.addRow(data);
        }
        tabelRank.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
            System.out.print(e);}
    }//GEN-LAST:event_btnCariPDcariSKActionPerformed

    private void cariPDcariSKEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPDcariSKEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariPDcariSKEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariPD;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariDP;
    private javax.swing.JTextField cariPD;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField namaPD;
    private javax.swing.JTextField noidPE;
    private javax.swing.JButton simpan;
    private javax.swing.JComboBox<String> skB;
    private javax.swing.JComboBox<String> skE1;
    private javax.swing.JComboBox<String> skE2;
    private javax.swing.JComboBox<String> skE3;
    private javax.swing.JComboBox<String> skH;
    private javax.swing.JComboBox<String> skM1;
    private javax.swing.JComboBox<String> skM2;
    private javax.swing.JComboBox<String> skM3;
    private javax.swing.JComboBox<String> skP1;
    private javax.swing.JComboBox<String> skP2;
    private javax.swing.JComboBox<String> skP3;
    private javax.swing.JComboBox<String> skT;
    private javax.swing.JTable tabelET;
    private javax.swing.JTable tabelRank;
    // End of variables declaration//GEN-END:variables
}
