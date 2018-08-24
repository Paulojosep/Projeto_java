
import javax.swing.JFrame;


public class PesquisaTest {


    public static void main(String[] args) {
        Pesquisa objeto = new Pesquisa();
        objeto.setSize(380, 550);                         // Configura o tamanho do frame
        objeto.setVisible(true);                           // Exibe o frame
        objeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Com o método acima, o programa termina quando o usuário clicar no botão fechar da janela. 
        objeto.setLocationRelativeTo(null);    // Coloca o frame no centro da tela. 
        // objeto.setLocation (250, 400);               // Coloca o frame na coordenada ( largura, altura ).
    }
    
}
