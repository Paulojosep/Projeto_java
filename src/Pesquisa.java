
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Pesquisa extends JFrame {
    
    private JLabel lbRa;
    private JLabel lbComentario;
    private JLabel lbPergunta2;
    private JLabel lbTitulo;
    private JLabel lbImgProfessor;
    private JLabel lbPergunta;
    private String professores[] = {"Barbosa", "Santana", "Rodolfo", "Chiquinho"};
    private Icon icons[] = {new ImageIcon(getClass().getResource("boneco1.png")),
        new ImageIcon(getClass().getResource("boneco2.png")),
        new ImageIcon(getClass().getResource("boneco3.png")),
        new ImageIcon(getClass().getResource("boneco4.png"))};
    private JComboBox cbProfessores;
    private JRadioButton  rdRuim;
    private JRadioButton  rdMediano;  
    private JRadioButton  rdBom;
    private ButtonGroup bg1;
    private JList ltPergunta;
    private final String respostas[] ={"Constantemente","As vezes","Muito difícil","Não"};
    private JCheckBox chLivro;
    private JCheckBox chProjetor;
    private JCheckBox chComputador;
    private JCheckBox chNda;
    private JTextField txComentario;
    private JPasswordField pwRa;
    private JButton btEnviar;
    
    
    
    
    public Pesquisa() {
        super("Pesquisa de Satisfação");
        setLayout(null);

        lbTitulo = new JLabel("Pesquisa de satisfação");
        lbTitulo.setBounds(100, 10, 150, 20);
        add(lbTitulo);

        cbProfessores = new JComboBox(professores);
        cbProfessores.setBounds(60, 40, 90, 20);
        cbProfessores.setMaximumRowCount(3);
        add(cbProfessores);

        lbImgProfessor = new JLabel();
        lbImgProfessor.setBounds(150, 40, 121, 122);
        add(lbImgProfessor);
        
        rdRuim = new JRadioButton("Professor ruim");
        rdRuim.setBounds(5, 160, 115, 20);
        add(rdRuim);
        
        rdMediano = new JRadioButton("Professor mediano");
        rdMediano.setBounds(120, 160, 135, 20);
        add(rdMediano);
        
        rdBom = new JRadioButton("Professor bom");
        rdBom.setBounds(250, 160, 150, 20);
        add(rdBom);
        
        lbPergunta = new JLabel("O professor falta as aulas?");
        lbPergunta.setBounds(10, 185, 250, 20);
        add(lbPergunta);
        
        ltPergunta = new JList(respostas);
        ltPergunta.setVisibleRowCount(4);
        ltPergunta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ltPergunta.setBounds(10, 210, 125, 72);
        add(ltPergunta);
        
        lbPergunta2 = new JLabel("Quais desses elementos o professor utiliza em aula:");
        lbPergunta2.setBounds(10, 300, 320, 20);
        add(lbPergunta2);
        
        chLivro = new JCheckBox("Livro");
        chLivro.setBounds(10, 325, 80, 20);
        add(chLivro);
        
        chProjetor = new JCheckBox("Projetor");
        chProjetor.setBounds(115, 325, 80, 20);
        add(chProjetor);
        
        chComputador = new JCheckBox("Computador");
        chComputador.setBounds(10, 350, 100, 20);
        add(chComputador);
        
        chNda = new JCheckBox("Nenhuma das alternativas");
        chNda.setBounds(115, 350, 180, 20);
        add(chNda);
        
        lbComentario = new JLabel("Adicione um comentario sobre o professor");
        lbComentario.setBounds(10, 380, 280, 20);
        add(lbComentario);
        
        txComentario = new JTextField();
        txComentario.setBounds(10, 400, 280, 20);
        txComentario.setToolTipText("Adicione um comentário sobre o que você acha do professor");
        add(txComentario);
        
        lbRa = new JLabel("Digite o seu RA");
        lbRa.setBounds(10, 425, 120, 20);
        add(lbRa);
        
        pwRa = new JPasswordField();
        pwRa.setBounds(10,450,120,20);
        pwRa.setToolTipText("Campo para você digitar o seu RA");
        add(pwRa);
        
        btEnviar = new JButton("Enviar");
        btEnviar.setBounds(145, 480, 80, 30);
        add(btEnviar);
        
        bg1 = new ButtonGroup();
        bg1.add(rdRuim);
        bg1.add(rdMediano);
        bg1.add(rdBom);
        
        PesquisaHandler handler = new PesquisaHandler();
        cbProfessores.addItemListener(handler);
        chLivro.addItemListener(handler);
        chProjetor.addItemListener(handler);
        chComputador.addItemListener(handler);
        chNda.addItemListener(handler);
        btEnviar.addActionListener(handler);

    }

    private class PesquisaHandler implements ItemListener, ActionListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int indSelecionado = cbProfessores.getSelectedIndex();

                lbImgProfessor.setIcon(icons[indSelecionado]);

            }
            
            if(chNda.isSelected()){
                chLivro.setSelected(false);
                chProjetor.setSelected(false);
                chComputador.setSelected(false);
            }
            
          
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btEnviar){
                
                    JOptionPane.showMessageDialog(null, String.format("Enviado com sucesso!"));
                
            }
        }
    }
}
