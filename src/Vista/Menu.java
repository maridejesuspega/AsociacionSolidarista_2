package Vista;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import Modelo.Asociado;
import Controlador.AsociadoC;
import Modelo.Programa;
import Controlador.ProgramaC;
import Modelo.InscripcionPrograma;
import Controlador.InscripcionProgramaC;
import Modelo.ComunicacionMiembro;
import Controlador.ComunicacionMiembroC;
import Controlador.DividendoC;
import Modelo.ParticipacionPrograma;
import Controlador.ParticipacionProgramaC;
import Controlador.PrestamoC;
import Controlador.TransaccionFinancieraC;
import Modelo.Dividendo;
import Modelo.Prestamo;
import Modelo.TransaccionFinanciera;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Menu extends javax.swing.JFrame {

    Asociado asociado = new Asociado();
    AsociadoC asociadoC = new AsociadoC();
    Programa programa = new Programa();
    ProgramaC programaC = new ProgramaC();
    InscripcionPrograma ip = new InscripcionPrograma();
    InscripcionProgramaC ipC = new InscripcionProgramaC();
    ParticipacionPrograma pp = new ParticipacionPrograma();
    ParticipacionProgramaC ppC = new ParticipacionProgramaC();
    ComunicacionMiembro cm = new ComunicacionMiembro();
    ComunicacionMiembroC cmC = new ComunicacionMiembroC();
    TransaccionFinanciera tf = new TransaccionFinanciera();
    TransaccionFinancieraC tfc = new TransaccionFinancieraC();
    Prestamo ptm = new Prestamo();
    PrestamoC ptmc = new PrestamoC();
    Dividendo dvd = new Dividendo();
    DividendoC dvdc = new DividendoC();
    DefaultTableModel model = new DefaultTableModel();

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        asociadoC.llenarComboBoxAsociados(boxIDAsociadoP, boxIDAsociadoTran, boxIDAsociadoPrestamo, boxIDAsociadoDividendo, boxIDAsocComunicacion);
        programaC.llenarComboBoxProgramas(boxIDPrograma);
        ipC.llenarComboBoxNumerosInscripcion(btnNumeroInscripcionP);
        ppC.llenarComboBoxEstados(boxIDEstadoP);
        cmC.LlenarComboBoxIdsTipoComunicacion(boxIDTipoComunicacion);
        tfc.llenarComboBoxTipoTransaccion(boxTipoTran);
        tfc.llenarComboBoxCuentasBancarias(boxCuentaBancaria);
        tfc.llenarComboBoxMetodoPago(boxMetodoPago);
        tfc.llenarComboBoxTransacciones(boxIDTranPrestamo);
        tfc.llenarComboBoxTransacciones(boxIDTranDividendo);
        ptmc.llenarComboBoxEstadoPrestamo(boxEstadoPrestamo);
        
        // Agregar validación numérica a campos de ID
        agregarValidacionNumerica();

    }
    
    /**
     * Agrega validación para que los campos de ID solo acepten números
     * Muestra un mensaje visible cuando se intenta escribir letras
     */
    private void agregarValidacionNumerica() {
        // Campos de ID de Programa
        txtIDPrograma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                // Permitir dígitos, backspace y delete
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume(); // Evita que se escriba el carácter
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        txtIDCalendarizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Campos de ID de Asociado
        txtIDAsociado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        txtCedAsociado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        txtCodigoPostalAsociado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Campos de Inscripción
        txtNumeroInscripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Campos de Transacción
        txtIDTransaccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Campos de Préstamo
        txtIDPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Campos de Dividendo
        txtIDDividendo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Campos de Comunicación
        txtIDComunicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No se permiten letras. Solo se pueden escribir números en este campo.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public void ListaAsociado() {
        model.setRowCount(0);

        //Validar este 
        List<Asociado> listaAs = asociadoC.ListaAsociados();
        model = (DefaultTableModel) tableAsociados.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < listaAs.size(); i++) {
            ob[0] = listaAs.get(i).getIdAsociado();
            ob[1] = listaAs.get(i).getCedulaAsociado();
            ob[2] = listaAs.get(i).getNombreAsociado();
            ob[3] = listaAs.get(i).getApellidoAsociado();
            ob[4] = listaAs.get(i).getCorreoAsociado();
            ob[5] = listaAs.get(i).getFechaIngreso();
            ob[6] = listaAs.get(i).getCodigoPostal();
            model.addRow(ob);
        }
        tableAsociados.setModel(model);

    }

    public void ListaPrograma() {
        model.setRowCount(0);
        // Usar ListaProgramasValidados para mostrar solo programas que cumplen con las validaciones
        List<Programa> listaPrg = programaC.ListaProgramasValidados();
        model = (DefaultTableModel) tableProgramas.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < listaPrg.size(); i++) {
            ob[0] = listaPrg.get(i).getIdPrograma();
            ob[1] = listaPrg.get(i).getIdcalendarizacion();
            ob[2] = listaPrg.get(i).getNombrePrograma();
            ob[3] = listaPrg.get(i).getDescripcionPrograma();
            model.addRow(ob);
        }
        tableProgramas.setModel(model);

    }

    public void ListaInscripciones() {
        model.setRowCount(0);
        List<InscripcionPrograma> listaInscrip = ipC.ListaInscripcionesPrograma();
        model = (DefaultTableModel) tableInscripProgramas.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < listaInscrip.size(); i++) {
            ob[0] = listaInscrip.get(i).getNumeroInscripcion();
            ob[1] = listaInscrip.get(i).getFechaInscripcion();
            ob[2] = listaInscrip.get(i).getIdPrograma();
            model.addRow(ob);
        }
        tableInscripProgramas.setModel(model);

    }

    public void ListaParticipacionPrograma() {
        model.setRowCount(0);
        List<ParticipacionPrograma> listaPartP = ppC.ListaParticipacionPrograma();
        model = (DefaultTableModel) tableParProgramas.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < listaPartP.size(); i++) {
            ob[0] = listaPartP.get(i).getNumeroInscripcion();
            ob[1] = listaPartP.get(i).getIdAsociado();
            ob[2] = listaPartP.get(i).getIdEstado();
            model.addRow(ob);
        }
        tableParProgramas.setModel(model);

    }

    public void ListaComunicacion() {
        model.setRowCount(0);
        List<ComunicacionMiembro> listacm = cmC.ListaComunicacionMiembro();
        model = (DefaultTableModel) tableComunicacion.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < listacm.size(); i++) {
            ob[0] = listacm.get(i).getIdComunicacion();
            ob[1] = listacm.get(i).getIdAsociado();
            ob[2] = listacm.get(i).getIdTipoComunicacion();
            ob[3] = listacm.get(i).getFechaComunicacion();
            ob[4] = listacm.get(i).getNotas();
            model.addRow(ob);
        }
        tableComunicacion.setModel(model);

    }

    public void ListaTransaccion() {
        model.setRowCount(0);
        List<TransaccionFinanciera> listatfc = tfc.ListaTransaccionesFinancieras();
        model = (DefaultTableModel) tableTransac.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < listatfc.size(); i++) {
            ob[0] = listatfc.get(i).getIdTransaccion();
            ob[1] = listatfc.get(i).getIdAsociado();
            ob[2] = listatfc.get(i).getTipoTransaccion();
            ob[3] = listatfc.get(i).getIdCuentaBancaria();
            ob[4] = listatfc.get(i).getMonto();
            ob[5] = listatfc.get(i).getFechaTransaccion();
            ob[6] = listatfc.get(i).getDetalleTransaccion();
            ob[7] = listatfc.get(i).getIdMetodoPago();

            model.addRow(ob);
        }
        tableTransac.setModel(model);

    }

    public void ListaPrestamos() {
        model.setRowCount(0);
        List<Prestamo> listaptm = ptmc.ListaPrestamos();
        model = (DefaultTableModel) tablePrestamos.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < listaptm.size(); i++) {
            ob[0] = listaptm.get(i).getIdPrestamo();
            ob[1] = listaptm.get(i).getIdAsociado();
            ob[2] = listaptm.get(i).getMonto();
            ob[3] = listaptm.get(i).getFechaDesembolso();
            ob[4] = listaptm.get(i).getFechaVencimiento();
            ob[5] = listaptm.get(i).getTasaInteres();
            ob[6] = listaptm.get(i).getIdEstadoPrestamo();
            ob[7] = listaptm.get(i).getIdTransaccion();
            model.addRow(ob);
        }
        tablePrestamos.setModel(model);

    }

    public void ListaDividendos() {
        model.setRowCount(0);
        List<Dividendo> listadvd = dvdc.ListaDividendos();
        model = (DefaultTableModel) tableDividendo.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < listadvd.size(); i++) {
            ob[0] = listadvd.get(i).getIdDividendo();
            ob[1] = listadvd.get(i).getIdAsociado();
            ob[2] = listadvd.get(i).getMonto();
            ob[3] = listadvd.get(i).getFechaPago();
            ob[4] = listadvd.get(i).getIdTransaccion();
            model.addRow(ob);
        }
        tableDividendo.setModel(model);

    }

    public void LimpiarTabla() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }
    }

    public void Salir() {

        dispose();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCedAsociado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombAsociado = new javax.swing.JTextField();
        txtEmailAsociado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFechaIngAsociado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAsociados = new javax.swing.JTable();
        btnLimpiarAsociado = new javax.swing.JButton();
        btnEliminarAsociado = new javax.swing.JButton();
        btnActualizarAsociado = new javax.swing.JButton();
        btnGuardarAsociado = new javax.swing.JButton();
        txtIDAsociado = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtApellidoAsociado = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoPostalAsociado = new javax.swing.JTextField();
        btnListaAsociados = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDCalendarizacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDescripPrograma = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProgramas = new javax.swing.JTable();
        txtIDPrograma = new javax.swing.JTextField();
        btnLimpiarPrograma = new javax.swing.JButton();
        btnActualizarPrograma = new javax.swing.JButton();
        btnEliminarPrograma = new javax.swing.JButton();
        btnGuardarPrograma = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtNombrePrograma = new javax.swing.JTextField();
        btnListaProgramas = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableInscripProgramas = new javax.swing.JTable();
        txtFechaInscripcion = new javax.swing.JTextField();
        btnLimpiarInscripcionPrograma = new javax.swing.JButton();
        btnActualizarInscripcionPrograma = new javax.swing.JButton();
        btnEliminarInscripcionPrograma = new javax.swing.JButton();
        btnGuardarInscripcionPrograma = new javax.swing.JButton();
        txtNumeroInscripcion = new javax.swing.JTextField();
        boxIDPrograma = new javax.swing.JComboBox<>();
        btnListaInscripcion = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableComunicacion = new javax.swing.JTable();
        txtIDComunicacion = new javax.swing.JTextField();
        txtFechaComunicacion = new javax.swing.JTextField();
        txtNotasComunicacion = new javax.swing.JTextField();
        btnLimpiarComunicacion = new javax.swing.JButton();
        btnActualizarComunicacion = new javax.swing.JButton();
        btnEliminarComunicacion = new javax.swing.JButton();
        btnGuardarComunicacion = new javax.swing.JButton();
        boxIDAsocComunicacion = new javax.swing.JComboBox<>();
        boxIDTipoComunicacion = new javax.swing.JComboBox<>();
        btnListaComunicacion = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableParProgramas = new javax.swing.JTable();
        btnLimpiarPartPrograma = new javax.swing.JButton();
        btnActualizarParPrograma = new javax.swing.JButton();
        btnEliminarParPrograma = new javax.swing.JButton();
        btnGuardarParPrograma = new javax.swing.JButton();
        boxIDAsociadoP = new javax.swing.JComboBox<>();
        btnNumeroInscripcionP = new javax.swing.JComboBox<>();
        boxIDEstadoP = new javax.swing.JComboBox<>();
        btnListaParticipacion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableTransac = new javax.swing.JTable();
        btnLimpiarTransac = new javax.swing.JButton();
        btnActualizarTransac = new javax.swing.JButton();
        btnEliminarTransac = new javax.swing.JButton();
        btnGuardarTransac = new javax.swing.JButton();
        txtIDTransaccion = new javax.swing.JTextField();
        boxIDAsociadoTran = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtMontoTran = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtFechaTran = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        boxTipoTran = new javax.swing.JComboBox<>();
        txtDetalleTran = new javax.swing.JTextField();
        boxCuentaBancaria = new javax.swing.JComboBox<>();
        boxMetodoPago = new javax.swing.JComboBox<>();
        btnListaTransaccion = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablePrestamos = new javax.swing.JTable();
        txtMontoPrestamo = new javax.swing.JTextField();
        btnLimpiarPrestamo = new javax.swing.JButton();
        btnActualizarPrestamo = new javax.swing.JButton();
        btnEliminarPrestamo = new javax.swing.JButton();
        btnGuardarPrestamo = new javax.swing.JButton();
        boxIDAsociadoPrestamo = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        txtFechaDesemPrestamo = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        txtFechaVencPrestamo = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txtTasaInteres = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtIDPrestamo = new javax.swing.JTextField();
        boxEstadoPrestamo = new javax.swing.JComboBox<>();
        boxIDTranPrestamo = new javax.swing.JComboBox<>();
        btnListaPrestamo = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableDividendo = new javax.swing.JTable();
        txtMontoDividendo = new javax.swing.JTextField();
        btnLimpiarDividendo = new javax.swing.JButton();
        btnActualizarDividendo = new javax.swing.JButton();
        btnEliminarDividendo = new javax.swing.JButton();
        btnGuardarDividendo = new javax.swing.JButton();
        txtIDDividendo = new javax.swing.JTextField();
        boxIDAsociadoDividendo = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        txtFechaDividendo = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        boxIDTranDividendo = new javax.swing.JComboBox<>();
        btnListaDividendo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAsociados = new javax.swing.JButton();
        btnProgramas = new javax.swing.JButton();
        btnInscripcionProgramas = new javax.swing.JButton();
        btnComunicación = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 3, 76));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 167, -1, 13));
        jPanel1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 16, 388, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ASOCIACION SOLIDARISTA EMPRESARIAL (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 490, 150));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 0, 102));
        jLabel33.setText("Asociados");

        jLabel4.setText("Cédula Física-Jurídica:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Correo Electrónico:");

        jLabel7.setText("Fecha Ingreso:");

        tableAsociados.setForeground(new java.awt.Color(102, 0, 102));
        tableAsociados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cédula", "Nombre", "Apellidos", "Correo Electrónico", "Fecha Ingreso", "Direccion"
            }
        ));
        tableAsociados.setGridColor(new java.awt.Color(255, 255, 255));
        tableAsociados.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableAsociados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAsociadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAsociados);

        btnLimpiarAsociado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarAsociado.setText("Limpiar");
        btnLimpiarAsociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAsociadoActionPerformed(evt);
            }
        });

        btnEliminarAsociado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarAsociado.setText("Eliminar");
        btnEliminarAsociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsociadoActionPerformed(evt);
            }
        });

        btnActualizarAsociado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarAsociado.setText("Actualizar");
        btnActualizarAsociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAsociadoActionPerformed(evt);
            }
        });

        btnGuardarAsociado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarAsociado.setText("Guardar");
        btnGuardarAsociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsociadoActionPerformed(evt);
            }
        });

        jLabel26.setText("Apellidos:");

        jLabel58.setText("ID Asociado:");

        jLabel8.setText("Codigo Postal:");

        btnListaAsociados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaAsociados.setText("Ver Lista");
        btnListaAsociados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAsociadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFechaIngAsociado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(txtEmailAsociado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedAsociado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombAsociado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoPostalAsociado))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                    .addComponent(txtApellidoAsociado)
                                    .addComponent(btnListaAsociados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel33))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel33)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCedAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(txtApellidoAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmailAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListaAsociados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFechaIngAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoPostalAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnLimpiarAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Asociados", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 0, 102));
        jLabel34.setText("Programas");

        jLabel10.setText("ID Programa");

        jLabel11.setText("ID Calendarización:");

        jLabel12.setText("Descripción");

        tableProgramas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Programa", "ID Calendarizacion", "Nombre Programa", "Descripción"
            }
        ));
        tableProgramas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProgramasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProgramas);

        btnLimpiarPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarPrograma.setText("Limpiar");
        btnLimpiarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProgramaActionPerformed(evt);
            }
        });

        btnActualizarPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarPrograma.setText("Actualizar");
        btnActualizarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProgramaActionPerformed(evt);
            }
        });

        btnEliminarPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarPrograma.setText("Eliminar");
        btnEliminarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProgramaActionPerformed(evt);
            }
        });

        btnGuardarPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarPrograma.setText("Guardar");
        btnGuardarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProgramaActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre Programa:");

        btnListaProgramas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaProgramas.setText("Ver Lista");
        btnListaProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaProgramasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIDCalendarizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                        .addComponent(txtIDPrograma, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNombrePrograma, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                                    .addComponent(txtDescripPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnListaProgramas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(241, 241, 241)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarPrograma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel34)
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnLimpiarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtIDPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtIDCalendarizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtDescripPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListaProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(821, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Programas", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 0, 102));
        jLabel38.setText("Inscripción Programas");

        jLabel16.setText("Número Inscripción:");

        jLabel35.setText("Fecha Inscripción:");

        jLabel36.setText("ID Programa:");

        tableInscripProgramas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Inscripción", "Fecha Inscripcion", "ID Programa"
            }
        ));
        tableInscripProgramas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInscripProgramasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableInscripProgramas);

        btnLimpiarInscripcionPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarInscripcionPrograma.setText("Limpiar");

        btnActualizarInscripcionPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarInscripcionPrograma.setText("Actualizar");
        btnActualizarInscripcionPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarInscripcionProgramaActionPerformed(evt);
            }
        });

        btnEliminarInscripcionPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarInscripcionPrograma.setText("Eliminar");
        btnEliminarInscripcionPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInscripcionProgramaActionPerformed(evt);
            }
        });

        btnGuardarInscripcionPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarInscripcionPrograma.setText("Guardar");
        btnGuardarInscripcionPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInscripcionProgramaActionPerformed(evt);
            }
        });

        btnListaInscripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaInscripcion.setText("Ver Lista");
        btnListaInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaInscripcion)
                            .addComponent(txtNumeroInscripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxIDPrograma, javax.swing.GroupLayout.Alignment.TRAILING, 0, 462, Short.MAX_VALUE)
                            .addComponent(btnListaInscripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarInscripcionPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarInscripcionPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarInscripcionPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarInscripcionPrograma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel38)
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnLimpiarInscripcionPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarInscripcionPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarInscripcionPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarInscripcionPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtNumeroInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtFechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(boxIDPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnListaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(825, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inscripcion Programas", jPanel8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 0, 102));
        jLabel41.setText("Comunicación");

        jLabel42.setText("ID Comunicación:");

        jLabel43.setText("ID Asociado:");

        jLabel44.setText("ID Tipo Comunicación:");

        jLabel45.setText("Fecha Comunicación:");

        jLabel46.setText("Notas:");

        tableComunicacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Comunicación", "ID Asociado", "ID Tipo Comunicacion", "Fecha Comunicacion", "Notas"
            }
        ));
        tableComunicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableComunicacionMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableComunicacion);

        btnLimpiarComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarComunicacion.setText("Limpiar");
        btnLimpiarComunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarComunicacionActionPerformed(evt);
            }
        });

        btnActualizarComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarComunicacion.setText("Actualizar");
        btnActualizarComunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarComunicacionActionPerformed(evt);
            }
        });

        btnEliminarComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarComunicacion.setText("Eliminar");
        btnEliminarComunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarComunicacionActionPerformed(evt);
            }
        });

        btnGuardarComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarComunicacion.setText("Guardar");
        btnGuardarComunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComunicacionActionPerformed(evt);
            }
        });

        btnListaComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaComunicacion.setText("Ver Lista");
        btnListaComunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaComunicacionActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 0, 102));
        jLabel17.setText("Tipos de Comunicación*");

        jLabel18.setText("1- Correo Electrónico");

        jLabel19.setText("2- Teléfono");

        jLabel20.setText("3- Mensaje de Texto");

        jLabel21.setText("4- Carta");

        jLabel22.setText("5- Reunión Presencial");

        jLabel23.setText("6- Notificación ");

        jLabel24.setText("7- Anuncio");

        jLabel25.setText("8- Boletín Informativo");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtFechaComunicacion)
                                            .addComponent(txtNotasComunicacion)
                                            .addComponent(txtIDComunicacion)
                                            .addComponent(boxIDAsocComunicacion, 0, 462, Short.MAX_VALUE)
                                            .addComponent(boxIDTipoComunicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnListaComunicacion))))
                            .addComponent(jLabel17))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarComunicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarComunicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarComunicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarComunicacion, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel41)
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnLimpiarComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListaComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtIDComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(boxIDAsocComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(boxIDTipoComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtFechaComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(txtNotasComunicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel23))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel25))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(463, 463, 463))
        );

        jTabbedPane1.addTab("Comunicación", jPanel10);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 0, 102));
        jLabel59.setText("Participación Programas");

        jLabel60.setText("Número Inscripción:");

        jLabel61.setText("ID Asociado:");

        jLabel62.setText("ID Estado:");

        tableParProgramas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Inscripción", "ID Asociado", "ID Estado"
            }
        ));
        tableParProgramas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableParProgramasMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableParProgramas);

        btnLimpiarPartPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarPartPrograma.setText("Limpiar");
        btnLimpiarPartPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPartProgramaActionPerformed(evt);
            }
        });

        btnActualizarParPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarParPrograma.setText("Actualizar");
        btnActualizarParPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarParProgramaActionPerformed(evt);
            }
        });

        btnEliminarParPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarParPrograma.setText("Eliminar");
        btnEliminarParPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarParProgramaActionPerformed(evt);
            }
        });

        btnGuardarParPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarParPrograma.setText("Guardar");
        btnGuardarParPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarParProgramaActionPerformed(evt);
            }
        });

        btnNumeroInscripcionP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumeroInscripcionPActionPerformed(evt);
            }
        });

        btnListaParticipacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaParticipacion.setText("Ver Lista");
        btnListaParticipacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaParticipacionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Información Estado*");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("1-Activo");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("2-Inactivo");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("3- Suspendido");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel60)
                                        .addComponent(jLabel61)
                                        .addComponent(jLabel62))
                                    .addGap(44, 44, 44)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(boxIDAsociadoP, 0, 462, Short.MAX_VALUE)
                                        .addComponent(btnNumeroInscripcionP, 0, 462, Short.MAX_VALUE)
                                        .addComponent(boxIDEstadoP, 0, 462, Short.MAX_VALUE)))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addGap(352, 352, 352)
                                    .addComponent(btnListaParticipacion)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addComponent(jLabel14))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarPartPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarParPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarParPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarParPrograma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel59)
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnLimpiarPartPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarParPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarParPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarParPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(btnNumeroInscripcionP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(boxIDAsociadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(boxIDEstadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnListaParticipacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(828, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Participación Programas", jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(102, 0, 102));
        jLabel63.setText("Transacciones Financieras");

        jLabel64.setText("ID Transacción:");

        jLabel65.setText("ID Asociado:");

        jLabel66.setText("Tipo Transacción:");

        tableTransac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaccion", "ID Asociado", "Tipo Transaccion", "Cuenta Bancaria", "Monto", "Fecha Transacción", "Detalle", "Método de Pago"
            }
        ));
        tableTransac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransacMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableTransac);

        btnLimpiarTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarTransac.setText("Limpiar");
        btnLimpiarTransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTransacActionPerformed(evt);
            }
        });

        btnActualizarTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarTransac.setText("Actualizar");
        btnActualizarTransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTransacActionPerformed(evt);
            }
        });

        btnEliminarTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarTransac.setText("Eliminar");
        btnEliminarTransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTransacActionPerformed(evt);
            }
        });

        btnGuardarTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarTransac.setText("Guardar");
        btnGuardarTransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTransacActionPerformed(evt);
            }
        });

        jLabel75.setText("ID Cuenta Bancaria:");

        jLabel76.setText("Monto:");

        jLabel77.setText("Fecha Transaccion:");

        jLabel78.setText("Detalle:");

        jLabel79.setText("ID Método de Pago:");

        btnListaTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaTransaccion.setText("Ver Lista");
        btnListaTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaTransaccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDTransaccion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxIDAsociadoTran, 0, 462, Short.MAX_VALUE)
                            .addComponent(txtMontoTran)
                            .addComponent(txtFechaTran)
                            .addComponent(boxTipoTran, 0, 462, Short.MAX_VALUE)
                            .addComponent(txtDetalleTran)
                            .addComponent(boxCuentaBancaria, 0, 462, Short.MAX_VALUE)
                            .addComponent(boxMetodoPago, 0, 462, Short.MAX_VALUE))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarTransac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarTransac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarTransac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarTransac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListaTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel63)
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnLimpiarTransac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarTransac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarTransac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarTransac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListaTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(txtIDTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(boxIDAsociadoTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(boxTipoTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(boxCuentaBancaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(txtDetalleTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(boxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(715, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transacciones Financieras", jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(102, 0, 102));
        jLabel67.setText("Prestámos");

        jLabel68.setText("ID Préstamo:");

        jLabel69.setText("ID Asociado:");

        jLabel70.setText("Monto:");

        tablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Préstamo", "ID Asociado", "Monto", "Fecha Desembolso", "Fecha Vencimiento", "Tasa de Interés", "Estado Préstamo", "ID Transaccion"
            }
        ));
        tablePrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrestamosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablePrestamos);

        btnLimpiarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarPrestamo.setText("Limpiar");
        btnLimpiarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPrestamoActionPerformed(evt);
            }
        });

        btnActualizarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarPrestamo.setText("Actualizar");
        btnActualizarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPrestamoActionPerformed(evt);
            }
        });

        btnEliminarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarPrestamo.setText("Eliminar");
        btnEliminarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPrestamoActionPerformed(evt);
            }
        });

        btnGuardarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarPrestamo.setText("Guardar");
        btnGuardarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrestamoActionPerformed(evt);
            }
        });

        boxIDAsociadoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxIDAsociadoPrestamoActionPerformed(evt);
            }
        });

        jLabel80.setText("Fecha Desembolso:");

        jLabel81.setText("Fecha Vencimiento:");

        jLabel82.setText("Tasa de Interés:");

        jLabel83.setText("ID Estado Préstamo:");

        jLabel84.setText("ID  Transacción:");

        boxEstadoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEstadoPrestamoActionPerformed(evt);
            }
        });

        boxIDTranPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxIDTranPrestamoActionPerformed(evt);
            }
        });

        btnListaPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaPrestamo.setText("Ver Lista");
        btnListaPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPrestamoActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 0, 102));
        jLabel27.setText("Información Estado*");

        jLabel28.setText("1- Activo");

        jLabel29.setText("2- Inactivo");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70)
                            .addComponent(jLabel80)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84)
                            .addComponent(jLabel27)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMontoPrestamo)
                            .addComponent(boxIDAsociadoPrestamo, 0, 462, Short.MAX_VALUE)
                            .addComponent(txtFechaDesemPrestamo)
                            .addComponent(txtFechaVencPrestamo)
                            .addComponent(txtTasaInteres)
                            .addComponent(txtIDPrestamo)
                            .addComponent(boxEstadoPrestamo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 462, Short.MAX_VALUE)
                            .addComponent(boxIDTranPrestamo, 0, 462, Short.MAX_VALUE))
                        .addGap(165, 165, 165)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarPrestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListaPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel67)
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnLimpiarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(txtIDPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(boxIDAsociadoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(txtMontoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(txtFechaDesemPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(txtFechaVencPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(txtTasaInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(boxEstadoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(boxIDTranPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(722, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prestámos", jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(102, 0, 102));
        jLabel71.setText("Dividendos");

        jLabel72.setText("ID Dividendo:");

        jLabel73.setText("ID Asociado:");

        jLabel74.setText("Monto:");

        tableDividendo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Dividendo", "ID Asociado", "Monto", "Fecha", "ID Transacción"
            }
        ));
        tableDividendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDividendoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableDividendo);

        btnLimpiarDividendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btnLimpiarDividendo.setText("Limpiar");
        btnLimpiarDividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDividendoActionPerformed(evt);
            }
        });

        btnActualizarDividendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        btnActualizarDividendo.setText("Actualizar");
        btnActualizarDividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDividendoActionPerformed(evt);
            }
        });

        btnEliminarDividendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarDividendo.setText("Eliminar");
        btnEliminarDividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDividendoActionPerformed(evt);
            }
        });

        btnGuardarDividendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnGuardarDividendo.setText("Guardar");
        btnGuardarDividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDividendoActionPerformed(evt);
            }
        });

        jLabel85.setText("Fecha:");

        jLabel86.setText("ID Transaccion:");

        btnListaDividendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnListaDividendo.setText("Ver Lista");
        btnListaDividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDividendoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73)
                            .addComponent(jLabel74)
                            .addComponent(jLabel85)
                            .addComponent(jLabel86))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMontoDividendo)
                            .addComponent(txtIDDividendo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxIDAsociadoDividendo, 0, 462, Short.MAX_VALUE)
                            .addComponent(txtFechaDividendo)
                            .addComponent(boxIDTranDividendo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 462, Short.MAX_VALUE)
                            .addComponent(btnListaDividendo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(156, 156, 156)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarDividendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarDividendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarDividendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarDividendo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel71)
                .addGap(30, 30, 30)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(btnLimpiarDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(txtIDDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(boxIDAsociadoDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(txtMontoDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(txtFechaDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(boxIDTranDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnListaDividendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(793, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dividendos", jPanel15);

        btnAsociados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        btnAsociados.setText("Asociados");
        btnAsociados.setBorder(null);
        btnAsociados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsociadosActionPerformed(evt);
            }
        });

        btnProgramas.setText("Programas");
        btnProgramas.setBorder(null);
        btnProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramasActionPerformed(evt);
            }
        });

        btnInscripcionProgramas.setText("Inscripciones");
        btnInscripcionProgramas.setBorder(null);
        btnInscripcionProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionProgramasActionPerformed(evt);
            }
        });

        btnComunicación.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        btnComunicación.setText("Comunicacion");
        btnComunicación.setBorder(null);
        btnComunicación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComunicaciónActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir_1.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAsociados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInscripcionProgramas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComunicación, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProgramas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnAsociados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInscripcionProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnComunicación, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(590, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsociadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsociadosActionPerformed

        ListaAsociado();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnAsociadosActionPerformed

    private void btnProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramasActionPerformed

        ListaPrograma();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnProgramasActionPerformed

    private void btnInscripcionProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscripcionProgramasActionPerformed

        ListaInscripciones();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnInscripcionProgramasActionPerformed

    private void btnComunicaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComunicaciónActionPerformed

        LimpiarComunicacion();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnComunicaciónActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarParProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarParProgramaActionPerformed
        if (!"".equals(btnNumeroInscripcionP.getSelectedItem()) || !"".equals(boxIDAsociadoP.getSelectedItem())
                || !"".equals(boxIDEstadoP.getSelectedItem())) {

            pp.setNumeroInscripcion(Integer.parseInt(btnNumeroInscripcionP.getSelectedItem().toString()));
            pp.setIdEstado(Integer.parseInt(boxIDEstadoP.getSelectedItem().toString()));
            pp.setIdAsociado(Integer.parseInt(boxIDAsociadoP.getSelectedItem().toString()));
            ppC.RegistrarParticipacionPrograma(pp);

            LimpiarParticipacion();
            ListaParticipacionPrograma();

            JOptionPane.showMessageDialog(null, "Participación de Programa Registrada");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");

        }
    }//GEN-LAST:event_btnGuardarParProgramaActionPerformed

    private void btnEliminarParProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParProgramaActionPerformed
        if (!"".equals(btnNumeroInscripcionP.getSelectedItem())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?");
            if (pregunta == 0) {
                int numeroInscripcion = Integer.parseInt(btnNumeroInscripcionP.getSelectedItem().toString());
                boolean eliminado = ppC.EliminarParticipacionPrograma(numeroInscripcion);
                if (eliminado) {
                    LimpiarTabla();
                    LimpiarParticipacion();
                    ListaParticipacionPrograma();
                    JOptionPane.showMessageDialog(null, "Participación eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la participación.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }

    }//GEN-LAST:event_btnEliminarParProgramaActionPerformed

    private void btnActualizarParProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarParProgramaActionPerformed
        if (!"".equals(btnNumeroInscripcionP.getSelectedItem()) || !"".equals(boxIDAsociadoP.getSelectedItem())
                || !"".equals(boxIDEstadoP.getSelectedItem())) {

            pp.setNumeroInscripcion(Integer.parseInt(btnNumeroInscripcionP.getSelectedItem().toString()));
            pp.setIdEstado(Integer.parseInt(boxIDEstadoP.getSelectedItem().toString()));
            pp.setIdAsociado(Integer.parseInt(boxIDAsociadoP.getSelectedItem().toString()));
            ppC.ActualizarParticipacionPrograma(pp);

            LimpiarParticipacion();
            ListaParticipacionPrograma();

            JOptionPane.showMessageDialog(null, "Participación de Programa Actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");

        }
    }//GEN-LAST:event_btnActualizarParProgramaActionPerformed

    private void btnLimpiarPartProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPartProgramaActionPerformed
        LimpiarParticipacion();
    }//GEN-LAST:event_btnLimpiarPartProgramaActionPerformed

    private void tableParProgramasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableParProgramasMouseClicked
        int fila = tableParProgramas.rowAtPoint(evt.getPoint());
        btnNumeroInscripcionP.setSelectedItem(tableParProgramas.getValueAt(fila, 0).toString());
        boxIDAsociadoP.setSelectedItem(tableParProgramas.getValueAt(fila, 1).toString());
        boxIDEstadoP.setSelectedItem(tableParProgramas.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_tableParProgramasMouseClicked

    private void btnGuardarComunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComunicacionActionPerformed
        if (!"".equals(txtIDComunicacion.getText()) || !"".equals(boxIDAsocComunicacion.getSelectedItem())
                || !"".equals(boxIDTipoComunicacion.getSelectedItem()) || !"".equals(txtFechaComunicacion.getText())
                || !"".equals(txtNotasComunicacion.getText())) {

            cm.setIdComunicacion(Integer.parseInt(txtIDComunicacion.getText()));
            cm.setIdAsociado(Integer.parseInt(boxIDAsocComunicacion.getSelectedItem().toString()));
            cm.setIdTipoComunicacion(Integer.parseInt(boxIDTipoComunicacion.getSelectedItem().toString()));
            cm.setNotas(txtNotasComunicacion.getText());

            // Validar longitud mínima de notas (mínimo 10 caracteres)
            String notas = txtNotasComunicacion.getText().trim();
            if (notas.length() < 10) {
                JOptionPane.showMessageDialog(null, 
                    "El campo Notas debe contener al menos 10 caracteres. Actualmente tiene " + notas.length() + " caracteres.", 
                    "Error de Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Validar formato y que la fecha sea futura o actual
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaComunicacion.getText());
                java.sql.Date fechaComunicacion = new java.sql.Date(fecha.getTime());
                
                // Validar que la fecha sea >= hoy (comparar solo la fecha, sin hora)
                java.util.Calendar calHoy = java.util.Calendar.getInstance();
                calHoy.set(java.util.Calendar.HOUR_OF_DAY, 0);
                calHoy.set(java.util.Calendar.MINUTE, 0);
                calHoy.set(java.util.Calendar.SECOND, 0);
                calHoy.set(java.util.Calendar.MILLISECOND, 0);
                java.sql.Date hoy = new java.sql.Date(calHoy.getTimeInMillis());
                
                // Comparar solo las fechas sin hora
                if (fechaComunicacion.before(hoy)) {
                    JOptionPane.showMessageDialog(null, 
                        "La fecha de comunicación no puede ser anterior a hoy.", 
                        "Error de Validación", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                cm.setFechaComunicacion(fechaComunicacion);
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            cmC.RegistrarComunicacionMiembro(cm);

            LimpiarComunicacion();
            ListaComunicacion();

            
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");

        }
    }//GEN-LAST:event_btnGuardarComunicacionActionPerformed

    private void btnEliminarComunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarComunicacionActionPerformed
        if (!"".equals(txtIDComunicacion.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIDComunicacion.getText());
                cmC.EliminarComunicacionMiembro(id);
                LimpiarTabla();
                LimpiarComunicacion();
                ListaComunicacion();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarComunicacionActionPerformed

    private void btnActualizarComunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarComunicacionActionPerformed
        if (!"".equals(txtIDComunicacion.getText()) || !"".equals(boxIDAsocComunicacion.getSelectedItem())
                || !"".equals(boxIDTipoComunicacion.getSelectedItem()) || !"".equals(txtFechaComunicacion.getText())
                || !"".equals(txtNotasComunicacion.getText())) {

            cm.setIdComunicacion(Integer.parseInt(txtIDComunicacion.getText()));
            cm.setIdAsociado(Integer.parseInt(boxIDAsocComunicacion.getSelectedItem().toString()));
            cm.setIdTipoComunicacion(Integer.parseInt(boxIDTipoComunicacion.getSelectedItem().toString()));
            cm.setNotas(txtNotasComunicacion.getText());

            // Validar longitud mínima de notas (mínimo 10 caracteres)
            String notas = txtNotasComunicacion.getText().trim();
            if (notas.length() < 10) {
                JOptionPane.showMessageDialog(null, 
                    "El campo Notas debe contener al menos 10 caracteres. Actualmente tiene " + notas.length() + " caracteres.", 
                    "Error de Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Validar formato y que la fecha sea futura o actual
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaComunicacion.getText());
                java.sql.Date fechaComunicacion = new java.sql.Date(fecha.getTime());
                
                // Validar que la fecha sea >= hoy (comparar solo la fecha, sin hora)
                java.util.Calendar calHoy = java.util.Calendar.getInstance();
                calHoy.set(java.util.Calendar.HOUR_OF_DAY, 0);
                calHoy.set(java.util.Calendar.MINUTE, 0);
                calHoy.set(java.util.Calendar.SECOND, 0);
                calHoy.set(java.util.Calendar.MILLISECOND, 0);
                java.sql.Date hoy = new java.sql.Date(calHoy.getTimeInMillis());
                
                // Comparar solo las fechas sin hora
                if (fechaComunicacion.before(hoy)) {
                    JOptionPane.showMessageDialog(null, 
                        "La fecha de comunicación no puede ser anterior a hoy.", 
                        "Error de Validación", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                cm.setFechaComunicacion(fechaComunicacion);
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            cmC.ActualizarComunicacionMiembro(cm);

            LimpiarComunicacion();
            ListaComunicacion();

            JOptionPane.showMessageDialog(null, "Comunicacion Actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");

        }
    }//GEN-LAST:event_btnActualizarComunicacionActionPerformed

    private void btnLimpiarComunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarComunicacionActionPerformed
        LimpiarComunicacion();
    }//GEN-LAST:event_btnLimpiarComunicacionActionPerformed

    private void btnGuardarInscripcionProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInscripcionProgramaActionPerformed
        if (!"".equals(txtNumeroInscripcion.getText()) || !"".equals(txtFechaInscripcion.getText()) || !"".equals(txtFechaInscripcion.getText()) || !"".equals(boxIDPrograma.getSelectedItem())) {

            ip.setNumeroInscripcion(Integer.parseInt(txtNumeroInscripcion.getText()));
            ip.setIdPrograma(Integer.parseInt(boxIDPrograma.getSelectedItem().toString()));

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaInscripcion.getText());
                ip.setFechaInscripcion(new java.sql.Date(fecha.getTime()));
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            ipC.RegistrarInscripcionProgramaValidada(ip);

            LimpiarInscripciones();
            ListaInscripciones();

            JOptionPane.showMessageDialog(null, "Inscripción Registrada");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");

        }
    }//GEN-LAST:event_btnGuardarInscripcionProgramaActionPerformed

    private void btnEliminarInscripcionProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInscripcionProgramaActionPerformed
        if (!"".equals(txtNumeroInscripcion.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtNumeroInscripcion.getText());
                ipC.EliminarInscripcionPrograma(id);
                JOptionPane.showMessageDialog(null, "Inscripción Eliminada Correctamente");
                LimpiarTabla();
                LimpiarInscripciones();
                ListaInscripciones();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarInscripcionProgramaActionPerformed

    private void btnActualizarInscripcionProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarInscripcionProgramaActionPerformed
        if ("".equals(txtNumeroInscripcion.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione la fila que desea actualizar");
        } else {

            if (!"".equals(txtNumeroInscripcion.getText()) || !"".equals(txtFechaInscripcion) || !"".equals(boxIDPrograma.getSelectedItem())) {
                ip.setNumeroInscripcion(Integer.parseInt(txtNumeroInscripcion.getText()));
                ip.setIdPrograma(Integer.parseInt(boxIDPrograma.getSelectedItem().toString()));

                try {
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fecha = sdf.parse(txtFechaInscripcion.getText());
                    ip.setFechaInscripcion(new java.sql.Date(fecha.getTime()));
                } catch (java.text.ParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                    return;
                }
                ipC.ActualizarInscripcionProgramaValidada(ip);
                JOptionPane.showMessageDialog(null, "Inscripcion Actualizada");

                LimpiarInscripciones();
                ListaInscripciones();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
            }
        }
    }//GEN-LAST:event_btnActualizarInscripcionProgramaActionPerformed

    private void tableInscripProgramasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInscripProgramasMouseClicked
        int fila = tableInscripProgramas.rowAtPoint(evt.getPoint());
        txtNumeroInscripcion.setText(tableInscripProgramas.getValueAt(fila, 0).toString());
        txtFechaInscripcion.setText(tableInscripProgramas.getValueAt(fila, 1).toString());
        boxIDPrograma.setSelectedItem(tableInscripProgramas.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_tableInscripProgramasMouseClicked

    private void btnGuardarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProgramaActionPerformed
        if (!"".equals(txtIDPrograma.getText()) || !"".equals(txtIDCalendarizacion.getText()) || !"".equals(txtNombrePrograma.getText()) || !"".equals(txtDescripPrograma.getText())) {
            programa.setIdPrograma(Integer.parseInt(txtIDPrograma.getText()));
            programa.setIdcalendarizacion(Integer.parseInt(txtIDCalendarizacion.getText()));
            programa.setNombrePrograma(txtNombrePrograma.getText());
            programa.setDescripcionPrograma(txtDescripPrograma.getText());
            programaC.RegistrarProgramaValidado(programa);

            LimpiarPrograma();
            ListaPrograma();

            JOptionPane.showMessageDialog(null, "Programa Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnGuardarProgramaActionPerformed

    private void btnEliminarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProgramaActionPerformed
        if (!"".equals(txtIDPrograma.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIDPrograma.getText());
                programaC.EliminarPrograma(id);
                JOptionPane.showMessageDialog(null, "Programa Eliminado Correctamente");
                LimpiarTabla();
                LimpiarPrograma();
                ListaPrograma();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarProgramaActionPerformed

    private void btnActualizarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProgramaActionPerformed
        if ("".equals(txtIDPrograma.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione la fila que desea actualizar");
        } else {

            if (!"".equals(txtIDCalendarizacion.getText()) || !"".equals(txtNombrePrograma.getText()) || !"".equals(txtDescripPrograma.getText()) || !"".equals(txtIDPrograma)) {

                programa.setNombrePrograma(txtNombrePrograma.getText());
                programa.setIdcalendarizacion(Integer.parseInt(txtIDCalendarizacion.getText()));
                programa.setDescripcionPrograma(txtDescripPrograma.getText());
                programa.setIdPrograma(Integer.parseInt(txtIDPrograma.getText()));
                programaC.ActualizarProgramaValidado(programa);
                JOptionPane.showMessageDialog(null, "Programa Actualizado");

                LimpiarPrograma();
                ListaPrograma();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
            }
        }
    }//GEN-LAST:event_btnActualizarProgramaActionPerformed

    private void btnLimpiarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProgramaActionPerformed
        LimpiarPrograma();
    }//GEN-LAST:event_btnLimpiarProgramaActionPerformed

    private void tableProgramasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProgramasMouseClicked
        int fila = tableProgramas.rowAtPoint(evt.getPoint());
        txtIDPrograma.setText(tableProgramas.getValueAt(fila, 0).toString());
        txtIDCalendarizacion.setText(tableProgramas.getValueAt(fila, 1).toString());
        txtNombrePrograma.setText(tableProgramas.getValueAt(fila, 2).toString());
        txtDescripPrograma.setText(tableProgramas.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tableProgramasMouseClicked

    private void btnGuardarAsociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsociadoActionPerformed

        // Validación: Todos los campos deben estar llenos
        if (txtCedAsociado.getText().isEmpty()
                || txtNombAsociado.getText().isEmpty()
                || txtApellidoAsociado.getText().isEmpty()
                || txtEmailAsociado.getText().isEmpty()
                || txtFechaIngAsociado.getText().isEmpty()
                || txtCodigoPostalAsociado.getText().isEmpty()
                || txtIDAsociado.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        // Llenar el objeto
        asociado.setCedulaAsociado(Integer.parseInt(txtCedAsociado.getText()));
        asociado.setNombreAsociado(txtNombAsociado.getText());
        asociado.setApellidoAsociado(txtApellidoAsociado.getText());
        asociado.setCorreoAsociado(txtEmailAsociado.getText());
        asociado.setCodigoPostal(Integer.parseInt(txtCodigoPostalAsociado.getText()));
        asociado.setIdAsociado(Integer.parseInt(txtIDAsociado.getText())); 

        // Convertir fecha
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha = sdf.parse(txtFechaIngAsociado.getText());
            asociado.setFechaIngreso(new java.sql.Date(fecha.getTime()));
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use yyyy-MM-dd.");
            return;
        }

        // Guardar DB
        
        //Aca es el cambio de agregar/registrar uno nuevo
        if (asociadoC.RegistrarAsociadoValidado(asociado)) {
            JOptionPane.showMessageDialog(null, "Asociado Registrado");
            LimpiarAsociado();
            ListaAsociado();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el Asociado");
        }
    }//GEN-LAST:event_btnGuardarAsociadoActionPerformed

    private void btnActualizarAsociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAsociadoActionPerformed
        if ("".equals(txtIDAsociado.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione la fila que desea actualizar");
        } else {

            if (!"".equals(txtCedAsociado.getText()) || !"".equals(txtNombAsociado.getText())
                    || !"".equals(txtEmailAsociado.getText()) || !"".equals(txtFechaIngAsociado)
                    || !"".equals(txtApellidoAsociado.getText()) || !"".equals(txtCodigoPostalAsociado.getText())) {

                asociado.setCedulaAsociado(Integer.parseInt(txtCedAsociado.getText()));
                asociado.setNombreAsociado(txtNombAsociado.getText());
                asociado.setApellidoAsociado(txtApellidoAsociado.getText());
                asociado.setCorreoAsociado(txtEmailAsociado.getText());
                asociado.setCodigoPostal(Integer.parseInt(txtCodigoPostalAsociado.getText()));
                try {
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fecha = sdf.parse(txtFechaIngAsociado.getText());
                    asociado.setFechaIngreso(new java.sql.Date(fecha.getTime()));
                } catch (java.text.ParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                    return;
                }
                asociado.setIdAsociado(Integer.parseInt(txtIDAsociado.getText()));
                //Cambio para actualizar un asociado validado
                asociadoC.ActualizarAsociadoValidado(asociado);
                

                LimpiarAsociado();
                ListaAsociado();

            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
            }
        }
    }//GEN-LAST:event_btnActualizarAsociadoActionPerformed

    private void btnEliminarAsociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsociadoActionPerformed
        if (!"".equals(txtIDAsociado.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIDAsociado.getText());
                asociadoC.EliminarAsociado(id);
                JOptionPane.showMessageDialog(null, "Asociado Eliminado");
                LimpiarTabla();
                LimpiarAsociado();
                ListaAsociado();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarAsociadoActionPerformed

    private void btnLimpiarAsociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAsociadoActionPerformed
        LimpiarAsociado();
    }//GEN-LAST:event_btnLimpiarAsociadoActionPerformed

    private void tableAsociadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAsociadosMouseClicked
        int fila = tableAsociados.rowAtPoint(evt.getPoint());
        txtIDAsociado.setText(tableAsociados.getValueAt(fila, 0).toString());
        txtCedAsociado.setText(tableAsociados.getValueAt(fila, 1).toString());
        txtNombAsociado.setText(tableAsociados.getValueAt(fila, 2).toString());
        txtApellidoAsociado.setText(tableAsociados.getValueAt(fila, 3).toString());
        txtEmailAsociado.setText(tableAsociados.getValueAt(fila, 4).toString());
        txtFechaIngAsociado.setText(tableAsociados.getValueAt(fila, 5).toString());
        txtCodigoPostalAsociado.setText(tableAsociados.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_tableAsociadosMouseClicked

    private void tableTransacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransacMouseClicked
        int fila = tableTransac.rowAtPoint(evt.getPoint());
        txtIDTransaccion.setText(tableTransac.getValueAt(fila, 0).toString());
        boxIDAsociadoTran.setSelectedItem(tableTransac.getValueAt(fila, 1).toString());
        boxTipoTran.setSelectedItem(tableTransac.getValueAt(fila, 2).toString());
        boxCuentaBancaria.setSelectedItem(tableTransac.getValueAt(fila, 3).toString());
        txtMontoTran.setText(tableTransac.getValueAt(fila, 4).toString());
        txtFechaTran.setText(tableTransac.getValueAt(fila, 5).toString());
        txtDetalleTran.setText(tableTransac.getValueAt(fila, 6).toString());
        boxMetodoPago.setSelectedItem(tableTransac.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tableTransacMouseClicked

    private void btnLimpiarTransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTransacActionPerformed
        LimpiarTransaccion();
    }//GEN-LAST:event_btnLimpiarTransacActionPerformed

    private void btnActualizarTransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTransacActionPerformed
        if (!"".equals(txtIDTransaccion.getText()) || !"".equals(boxIDAsociadoTran.getSelectedItem()) || !"".equals(boxTipoTran.getSelectedItem()) || !"".
                equals(boxCuentaBancaria.getSelectedItem()) || !"".equals(txtMontoTran.getText())
                || !"".equals(txtFechaTran.getText()) || !"".equals(txtDetalleTran.getText()) || !"".equals(boxMetodoPago.getSelectedItem())) {

            tf.setIdTransaccion(Integer.parseInt(txtIDTransaccion.getText()));
            tf.setIdAsociado(Integer.parseInt(boxIDAsociadoTran.getSelectedItem().toString()));
            tf.setTipoTransaccion(Integer.parseInt(boxTipoTran.getSelectedItem().toString()));
            tf.setIdCuentaBancaria(Integer.parseInt(boxCuentaBancaria.getSelectedItem().toString()));
            tf.setMonto(BigDecimal.valueOf(Float.parseFloat(txtMontoTran.getText())));
            tf.setDetalleTransaccion(txtDetalleTran.getText());
            tf.setIdMetodoPago(Integer.parseInt(boxMetodoPago.getSelectedItem().toString()));

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaTran.getText());
                tf.setFechaTransaccion(new java.sql.Date(fecha.getTime()));
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            tfc.ActualizarTransaccionFinancieraValidada(tf);

            LimpiarTransaccion();
            ListaTransaccion();

            
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnActualizarTransacActionPerformed

    private void btnEliminarTransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTransacActionPerformed
        if (!"".equals(txtIDTransaccion.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIDTransaccion.getText());
                tfc.EliminarTransaccionFinanciera(id);
                JOptionPane.showMessageDialog(null, "Transaccion Eliminada");
                LimpiarTabla();
                LimpiarTransaccion();
                ListaTransaccion();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarTransacActionPerformed

    private void btnGuardarTransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTransacActionPerformed
        if (!"".equals(txtIDTransaccion.getText()) || !"".equals(boxIDAsociadoTran.getSelectedItem()) || !"".equals(boxTipoTran.getSelectedItem()) || !"".
                equals(boxCuentaBancaria.getSelectedItem()) || !"".equals(txtMontoTran.getText())
                || !"".equals(txtFechaTran.getText()) || !"".equals(txtDetalleTran.getText()) || !"".equals(boxMetodoPago.getSelectedItem())) {

            tf.setIdTransaccion(Integer.parseInt(txtIDTransaccion.getText()));
            tf.setIdAsociado(Integer.parseInt(boxIDAsociadoTran.getSelectedItem().toString()));
            tf.setTipoTransaccion(Integer.parseInt(boxTipoTran.getSelectedItem().toString()));
            tf.setIdCuentaBancaria(Integer.parseInt(boxCuentaBancaria.getSelectedItem().toString()));
            tf.setMonto(BigDecimal.valueOf(Float.parseFloat(txtMontoTran.getText())));
            tf.setDetalleTransaccion(txtDetalleTran.getText());
            tf.setIdMetodoPago(Integer.parseInt(boxMetodoPago.getSelectedItem().toString()));

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaTran.getText());
                tf.setFechaTransaccion(new java.sql.Date(fecha.getTime()));
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            tfc.RegistrarTransaccionFinancieraValidada(tf);

            LimpiarTransaccion();
            ListaTransaccion();

            
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnGuardarTransacActionPerformed

    private void tablePrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrestamosMouseClicked
        int fila = tablePrestamos.rowAtPoint(evt.getPoint());
        txtIDPrestamo.setText(tablePrestamos.getValueAt(fila, 0).toString());
        boxIDAsociadoPrestamo.setSelectedItem(tablePrestamos.getValueAt(fila, 1).toString());
        txtMontoPrestamo.setText(tablePrestamos.getValueAt(fila, 2).toString());
        txtFechaDesemPrestamo.setText(tablePrestamos.getValueAt(fila, 3).toString());
        txtFechaVencPrestamo.setText(tablePrestamos.getValueAt(fila, 4).toString());
        txtTasaInteres.setText(tablePrestamos.getValueAt(fila, 5).toString());
        boxEstadoPrestamo.setSelectedItem(tablePrestamos.getValueAt(fila, 6).toString());
        boxIDTranPrestamo.setSelectedItem(tablePrestamos.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablePrestamosMouseClicked

    private void btnLimpiarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPrestamoActionPerformed
        LimpiarPrestamo();
    }//GEN-LAST:event_btnLimpiarPrestamoActionPerformed

    private void btnActualizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPrestamoActionPerformed
        if (!"".equals(txtIDPrestamo.getText()) || !"".equals(boxIDAsociadoPrestamo.getSelectedItem()) || !"".equals(txtMontoPrestamo.getText()) || !"".
                equals(txtFechaDesemPrestamo.getText()) || !"".equals(txtFechaVencPrestamo.getText())
                || !"".equals(txtTasaInteres.getText()) || !"".equals(boxEstadoPrestamo.getSelectedItem()) || !"".equals(boxIDTranPrestamo.getSelectedItem())) {

            // Validar monto: límite de 18 dígitos antes del punto decimal
            String montoTexto = txtMontoPrestamo.getText().trim();
            // Separar parte entera y decimal
            String parteEntera = montoTexto;
            if (montoTexto.contains(".")) {
                parteEntera = montoTexto.substring(0, montoTexto.indexOf("."));
            }
            // Validar que la parte entera no exceda 18 dígitos
            if (parteEntera.length() > 18) {
                JOptionPane.showMessageDialog(null, 
                    "El monto no puede tener más de 18 dígitos antes del punto decimal.\n" +
                    "Usted ingresó " + parteEntera.length() + " dígitos.\n" +
                    "Ejemplo válido: 999999999999999999.99 (máximo 18 dígitos, 2 decimales)", 
                    "Error de Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            double monto = Double.parseDouble(montoTexto);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Validar tasa de interés (0-100)
            double tasaInteres = Double.parseDouble(txtTasaInteres.getText());
            if (tasaInteres < 0 || tasaInteres > 100) {
                JOptionPane.showMessageDialog(null, "La tasa de interés debe estar entre 0 y 100.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            ptm.setIdPrestamo(Integer.parseInt(txtIDPrestamo.getText()));
            ptm.setIdAsociado(Integer.parseInt(boxIDAsociadoPrestamo.getSelectedItem().toString()));
            ptm.setMonto(monto);
            ptm.setTasaInteres(tasaInteres);
            ptm.setIdEstadoPrestamo(Integer.parseInt(boxEstadoPrestamo.getSelectedItem().toString()));
            ptm.setIdTransaccion(Integer.parseInt(boxIDTranPrestamo.getSelectedItem().toString()));

            // Validar formato de fechas y relación entre ellas
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaD = sdf.parse(txtFechaDesemPrestamo.getText());
                java.util.Date fechaV = sdf.parse(txtFechaVencPrestamo.getText());
                java.sql.Date fechaDesembolso = new java.sql.Date(fechaD.getTime());
                java.sql.Date fechaVencimiento = new java.sql.Date(fechaV.getTime());
                
                // Validar que fecha vencimiento > fecha desembolso
                if (!fechaVencimiento.after(fechaDesembolso)) {
                    JOptionPane.showMessageDialog(null, 
                        "La fecha de vencimiento debe ser posterior a la fecha de desembolso.", 
                        "Error de Validación", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                ptm.setFechaDesembolso(fechaDesembolso);
                ptm.setFechaVencimiento(fechaVencimiento);
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            
            if (ptmc.ActualizarPrestamoValidado(ptm)) {
                LimpiarPrestamo();
                ListaPrestamos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnActualizarPrestamoActionPerformed

    private void btnEliminarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPrestamoActionPerformed
        if (!"".equals(txtIDPrestamo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIDPrestamo.getText());
                if (ptmc.EliminarPrestamoValidado(id)) {
                    LimpiarTabla();
                    LimpiarPrestamo();
                    ListaPrestamos();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarPrestamoActionPerformed

    private void btnGuardarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrestamoActionPerformed
        if (!"".equals(txtIDPrestamo.getText()) || !"".equals(boxIDAsociadoPrestamo.getSelectedItem()) || !"".equals(txtMontoPrestamo.getText()) || !"".
                equals(txtFechaDesemPrestamo.getText()) || !"".equals(txtFechaVencPrestamo.getText())
                || !"".equals(txtTasaInteres.getText()) || !"".equals(boxEstadoPrestamo.getSelectedItem()) || !"".equals(boxIDTranPrestamo.getSelectedItem())) {

            // Validar monto: límite de 18 dígitos antes del punto decimal
            String montoTexto = txtMontoPrestamo.getText().trim();
            // Separar parte entera y decimal
            String parteEntera = montoTexto;
            if (montoTexto.contains(".")) {
                parteEntera = montoTexto.substring(0, montoTexto.indexOf("."));
            }
            // Validar que la parte entera no exceda 18 dígitos
            if (parteEntera.length() > 18) {
                JOptionPane.showMessageDialog(null, 
                    "El monto no puede tener más de 18 dígitos antes del punto decimal.\n" +
                    "Usted ingresó " + parteEntera.length() + " dígitos.\n" +
                    "Ejemplo válido: 999999999999999999.99 (máximo 18 dígitos, 2 decimales)", 
                    "Error de Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            double monto = Double.parseDouble(montoTexto);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Validar tasa de interés (0-100)
            double tasaInteres = Double.parseDouble(txtTasaInteres.getText());
            if (tasaInteres < 0 || tasaInteres > 100) {
                JOptionPane.showMessageDialog(null, "La tasa de interés debe estar entre 0 y 100.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            ptm.setIdPrestamo(Integer.parseInt(txtIDPrestamo.getText()));
            ptm.setIdAsociado(Integer.parseInt(boxIDAsociadoPrestamo.getSelectedItem().toString()));
            ptm.setMonto(monto);
            ptm.setTasaInteres(tasaInteres);
            ptm.setIdEstadoPrestamo(Integer.parseInt(boxEstadoPrestamo.getSelectedItem().toString()));
            ptm.setIdTransaccion(Integer.parseInt(boxIDTranPrestamo.getSelectedItem().toString()));

            // Validar formato de fechas y relación entre ellas
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaD = sdf.parse(txtFechaDesemPrestamo.getText());
                java.util.Date fechaV = sdf.parse(txtFechaVencPrestamo.getText());
                java.sql.Date fechaDesembolso = new java.sql.Date(fechaD.getTime());
                java.sql.Date fechaVencimiento = new java.sql.Date(fechaV.getTime());
                
                // Validar que fecha vencimiento > fecha desembolso
                if (!fechaVencimiento.after(fechaDesembolso)) {
                    JOptionPane.showMessageDialog(null, 
                        "La fecha de vencimiento debe ser posterior a la fecha de desembolso.", 
                        "Error de Validación", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                ptm.setFechaDesembolso(fechaDesembolso);
                ptm.setFechaVencimiento(fechaVencimiento);
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            
            if (ptmc.RegistrarPrestamoValidado(ptm)) {
                LimpiarPrestamo();
                ListaPrestamos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnGuardarPrestamoActionPerformed

    private void tableDividendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDividendoMouseClicked
        int fila = tableDividendo.rowAtPoint(evt.getPoint());
        txtIDDividendo.setText(tableDividendo.getValueAt(fila, 0).toString());
        boxIDAsociadoDividendo.setSelectedItem(tableDividendo.getValueAt(fila, 1).toString());
        txtMontoDividendo.setText(tableDividendo.getValueAt(fila, 2).toString());
        txtFechaDividendo.setText(tableDividendo.getValueAt(fila, 3).toString());
        boxIDTranDividendo.setSelectedItem(tableDividendo.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tableDividendoMouseClicked

    private void btnLimpiarDividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDividendoActionPerformed
        LimpiarDividendo();
    }//GEN-LAST:event_btnLimpiarDividendoActionPerformed

    private void btnActualizarDividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDividendoActionPerformed
        if (!"".equals(txtIDDividendo.getText()) || !"".equals(boxIDAsociadoDividendo.getSelectedItem()) || !"".equals(txtMontoDividendo.getText()) || !"".
                equals(txtFechaDividendo.getText()) || !"".equals(boxIDTranDividendo.getSelectedItem())) {

            dvd.setIdDividendo(Integer.parseInt(txtIDDividendo.getText()));
            dvd.setIdAsociado(Integer.parseInt(boxIDAsociadoDividendo.getSelectedItem().toString()));
            dvd.setMonto(Double.parseDouble(txtMontoDividendo.getText()));
            dvd.setIdTransaccion(Integer.parseInt(boxIDTranDividendo.getSelectedItem().toString()));

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaDividendo.getText());
                dvd.setFechaPago(new java.sql.Date(fecha.getTime()));

            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            dvdc.ActualizarDividendoValidado(dvd);

            LimpiarDividendo();
            ListaDividendos();

            
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnActualizarDividendoActionPerformed

    private void btnEliminarDividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDividendoActionPerformed
        if (!"".equals(txtIDDividendo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIDDividendo.getText());
                dvdc.EliminarDividendo(id);
                JOptionPane.showMessageDialog(null, "Dividendo Eliminado");
                LimpiarTabla();
                LimpiarDividendo();
                ListaDividendos();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarDividendoActionPerformed

    private void btnGuardarDividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDividendoActionPerformed
        if (!"".equals(txtIDDividendo.getText()) || !"".equals(boxIDAsociadoDividendo.getSelectedItem()) || !"".equals(txtMontoDividendo.getText()) || !"".
                equals(txtFechaDividendo.getText()) || !"".equals(boxIDTranDividendo.getSelectedItem())) {

            dvd.setIdDividendo(Integer.parseInt(txtIDDividendo.getText()));
            dvd.setIdAsociado(Integer.parseInt(boxIDAsociadoDividendo.getSelectedItem().toString()));
            dvd.setMonto(Double.parseDouble(txtMontoDividendo.getText()));
            dvd.setIdTransaccion(Integer.parseInt(boxIDTranDividendo.getSelectedItem().toString()));

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(txtFechaDividendo.getText());
                dvd.setFechaPago(new java.sql.Date(fecha.getTime()));

            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                return;
            }
            dvdc.RegistrarDividendoValidado(dvd);

            LimpiarDividendo();
            ListaDividendos();

            
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacíos");
        }
    }//GEN-LAST:event_btnGuardarDividendoActionPerformed

    private void boxIDAsociadoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxIDAsociadoPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxIDAsociadoPrestamoActionPerformed

    private void btnListaAsociadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAsociadosActionPerformed
        ListaAsociado();
    }//GEN-LAST:event_btnListaAsociadosActionPerformed

    private void btnListaProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaProgramasActionPerformed
        ListaPrograma();
    }//GEN-LAST:event_btnListaProgramasActionPerformed

    private void btnNumeroInscripcionPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumeroInscripcionPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumeroInscripcionPActionPerformed

    private void btnListaParticipacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaParticipacionActionPerformed
        ListaParticipacionPrograma();
    }//GEN-LAST:event_btnListaParticipacionActionPerformed

    private void btnListaComunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaComunicacionActionPerformed
        ListaComunicacion();
    }//GEN-LAST:event_btnListaComunicacionActionPerformed

    private void tableComunicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableComunicacionMouseClicked
        int fila = tableComunicacion.rowAtPoint(evt.getPoint());
        txtIDComunicacion.setText(tableComunicacion.getValueAt(fila, 0).toString());
        boxIDAsocComunicacion.setSelectedItem(tableComunicacion.getValueAt(fila, 1).toString());
        boxIDTipoComunicacion.setSelectedItem(tableComunicacion.getValueAt(fila, 2).toString());
        txtFechaComunicacion.setText(tableComunicacion.getValueAt(fila, 3).toString());
        txtNotasComunicacion.setText(tableComunicacion.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tableComunicacionMouseClicked

    private void btnListaInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaInscripcionActionPerformed
        ListaInscripciones();
    }//GEN-LAST:event_btnListaInscripcionActionPerformed

    private void btnListaTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaTransaccionActionPerformed
        ListaTransaccion();
    }//GEN-LAST:event_btnListaTransaccionActionPerformed

    private void boxEstadoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstadoPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxEstadoPrestamoActionPerformed

    private void boxIDTranPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxIDTranPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxIDTranPrestamoActionPerformed

    private void btnListaPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPrestamoActionPerformed
        ListaPrestamos();
    }//GEN-LAST:event_btnListaPrestamoActionPerformed

    private void btnListaDividendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDividendoActionPerformed
        ListaDividendos();
    }//GEN-LAST:event_btnListaDividendoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCuentaBancaria;
    private javax.swing.JComboBox<String> boxEstadoPrestamo;
    private javax.swing.JComboBox<String> boxIDAsocComunicacion;
    private javax.swing.JComboBox<String> boxIDAsociadoDividendo;
    private javax.swing.JComboBox<String> boxIDAsociadoP;
    private javax.swing.JComboBox<String> boxIDAsociadoPrestamo;
    private javax.swing.JComboBox<String> boxIDAsociadoTran;
    private javax.swing.JComboBox<String> boxIDEstadoP;
    private javax.swing.JComboBox<String> boxIDPrograma;
    private javax.swing.JComboBox<String> boxIDTipoComunicacion;
    private javax.swing.JComboBox<String> boxIDTranDividendo;
    private javax.swing.JComboBox<String> boxIDTranPrestamo;
    private javax.swing.JComboBox<String> boxMetodoPago;
    private javax.swing.JComboBox<String> boxTipoTran;
    private javax.swing.JButton btnActualizarAsociado;
    private javax.swing.JButton btnActualizarComunicacion;
    private javax.swing.JButton btnActualizarDividendo;
    private javax.swing.JButton btnActualizarInscripcionPrograma;
    private javax.swing.JButton btnActualizarParPrograma;
    private javax.swing.JButton btnActualizarPrestamo;
    private javax.swing.JButton btnActualizarPrograma;
    private javax.swing.JButton btnActualizarTransac;
    private javax.swing.JButton btnAsociados;
    private javax.swing.JButton btnComunicación;
    private javax.swing.JButton btnEliminarAsociado;
    private javax.swing.JButton btnEliminarComunicacion;
    private javax.swing.JButton btnEliminarDividendo;
    private javax.swing.JButton btnEliminarInscripcionPrograma;
    private javax.swing.JButton btnEliminarParPrograma;
    private javax.swing.JButton btnEliminarPrestamo;
    private javax.swing.JButton btnEliminarPrograma;
    private javax.swing.JButton btnEliminarTransac;
    private javax.swing.JButton btnGuardarAsociado;
    private javax.swing.JButton btnGuardarComunicacion;
    private javax.swing.JButton btnGuardarDividendo;
    private javax.swing.JButton btnGuardarInscripcionPrograma;
    private javax.swing.JButton btnGuardarParPrograma;
    private javax.swing.JButton btnGuardarPrestamo;
    private javax.swing.JButton btnGuardarPrograma;
    private javax.swing.JButton btnGuardarTransac;
    private javax.swing.JButton btnInscripcionProgramas;
    private javax.swing.JButton btnLimpiarAsociado;
    private javax.swing.JButton btnLimpiarComunicacion;
    private javax.swing.JButton btnLimpiarDividendo;
    private javax.swing.JButton btnLimpiarInscripcionPrograma;
    private javax.swing.JButton btnLimpiarPartPrograma;
    private javax.swing.JButton btnLimpiarPrestamo;
    private javax.swing.JButton btnLimpiarPrograma;
    private javax.swing.JButton btnLimpiarTransac;
    private javax.swing.JButton btnListaAsociados;
    private javax.swing.JButton btnListaComunicacion;
    private javax.swing.JButton btnListaDividendo;
    private javax.swing.JButton btnListaInscripcion;
    private javax.swing.JButton btnListaParticipacion;
    private javax.swing.JButton btnListaPrestamo;
    private javax.swing.JButton btnListaProgramas;
    private javax.swing.JButton btnListaTransaccion;
    private javax.swing.JComboBox<String> btnNumeroInscripcionP;
    private javax.swing.JButton btnProgramas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableAsociados;
    private javax.swing.JTable tableComunicacion;
    private javax.swing.JTable tableDividendo;
    private javax.swing.JTable tableInscripProgramas;
    private javax.swing.JTable tableParProgramas;
    private javax.swing.JTable tablePrestamos;
    private javax.swing.JTable tableProgramas;
    private javax.swing.JTable tableTransac;
    private javax.swing.JTextField txtApellidoAsociado;
    private javax.swing.JTextField txtCedAsociado;
    private javax.swing.JTextField txtCodigoPostalAsociado;
    private javax.swing.JTextField txtDescripPrograma;
    private javax.swing.JTextField txtDetalleTran;
    private javax.swing.JTextField txtEmailAsociado;
    private javax.swing.JTextField txtFechaComunicacion;
    private javax.swing.JTextField txtFechaDesemPrestamo;
    private javax.swing.JTextField txtFechaDividendo;
    private javax.swing.JTextField txtFechaIngAsociado;
    private javax.swing.JTextField txtFechaInscripcion;
    private javax.swing.JTextField txtFechaTran;
    private javax.swing.JTextField txtFechaVencPrestamo;
    private javax.swing.JTextField txtIDAsociado;
    private javax.swing.JTextField txtIDCalendarizacion;
    private javax.swing.JTextField txtIDComunicacion;
    private javax.swing.JTextField txtIDDividendo;
    private javax.swing.JTextField txtIDPrestamo;
    private javax.swing.JTextField txtIDPrograma;
    private javax.swing.JTextField txtIDTransaccion;
    private javax.swing.JTextField txtMontoDividendo;
    private javax.swing.JTextField txtMontoPrestamo;
    private javax.swing.JTextField txtMontoTran;
    private javax.swing.JTextField txtNombAsociado;
    private javax.swing.JTextField txtNombrePrograma;
    private javax.swing.JTextField txtNotasComunicacion;
    private javax.swing.JTextField txtNumeroInscripcion;
    private javax.swing.JTextField txtTasaInteres;
    // End of variables declaration//GEN-END:variables
private void LimpiarAsociado() {
        txtIDAsociado.setText("");
        txtCedAsociado.setText("");
        txtApellidoAsociado.setText("");
        txtNombAsociado.setText("");
        txtEmailAsociado.setText("");
        txtFechaIngAsociado.setText("");
        txtCodigoPostalAsociado.setText("");

    }

    private void LimpiarPrograma() {
        txtIDPrograma.setText("");
        txtIDCalendarizacion.setText("");
        txtNombrePrograma.setText("");
        txtDescripPrograma.setText("");

    }

    private void LimpiarInscripciones() {
        txtNumeroInscripcion.setText("");
        txtFechaInscripcion.setText("");
        boxIDPrograma.setSelectedItem(null);
    }

    private void LimpiarComunicacion() {
        txtIDComunicacion.setText("");
        boxIDAsocComunicacion.setSelectedItem(null);
        boxIDTipoComunicacion.setSelectedItem(null);
        txtFechaComunicacion.setText("");
        txtNotasComunicacion.setText("");

    }

    private void LimpiarParticipacion() {
        btnNumeroInscripcionP.setSelectedItem(null);
        boxIDEstadoP.setSelectedItem(null);
        boxIDAsociadoP.setSelectedItem(null);

    }

    private void LimpiarTransaccion() {
        txtIDTransaccion.setText("");
        boxIDAsociadoTran.setSelectedItem(null);
        boxTipoTran.setSelectedItem(null);
        boxCuentaBancaria.setSelectedItem(null);
        txtMontoTran.setText("");
        txtFechaTran.setText("");
        txtDetalleTran.setText("");
        boxMetodoPago.setSelectedItem(null);

    }

    private void LimpiarPrestamo() {
        txtIDPrestamo.setText("");
        boxIDAsociadoPrestamo.setSelectedItem(null);
        txtMontoPrestamo.setText("");
        txtFechaDesemPrestamo.setText("");
        txtFechaVencPrestamo.setText("");
        txtTasaInteres.setText("");
        boxEstadoPrestamo.setSelectedItem(null);
        boxIDTranPrestamo.setSelectedItem(null);

    }

    private void LimpiarDividendo() {
        txtIDDividendo.setText("");
        boxIDAsociadoDividendo.setSelectedItem(null);
        txtMontoDividendo.setText("");
        txtFechaDividendo.setText("");
        boxIDTranDividendo.setSelectedItem(null);

    }

}
