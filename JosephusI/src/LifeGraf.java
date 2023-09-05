import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 * Implementa o ambiente grafico para o Jogo da Vida
 */

public class LifeGraf extends Life implements MouseListener, 
ActionListener, MouseMotionListener {

	//Janela principal.
	JFrame _jframe = null; 

	Object b;
	ListaDuplamenteLigadaCircular a = new ListaDuplamenteLigadaCircular();
	IListaDuplamenteLigadaCircular fil = new ListaDuplamenteLigadaCircular();

	// Componentes para o ambiente
	Container _pAmbiente = null; // container do Ambiente (celulas)
	JLabel [][]_labels = null;  // matriz de labels 

	Color _corCelulas = null;
	Color _corFundo = null;
	Color _corBorda = null;
	Color _corDead = null;
	Color _corVivo = null;	

	// Componentes para os botoes
	Container _pBotoes = null;   // container dos botoes 
	JButton _jbExec = null;
	JButton _jbSair = null;
	JButton _jbConfig = null;

	JLabel _jlIntervalo = null;
	JLabel _jlIndividuos = null;

	JTextField _txfIndividuos = null;
	JTextField _txfIntervalo = null;

	// Componente para menu
	JMenuBar _menuBar;

	/**
	 * @return Returns the _corBorda.
	 */
	protected Color getCorBorda() {
		return _corBorda;
	}

	/**
	 * @param borda The _corBorda to set.
	 */
	protected void setCorBorda(Color borda) {
		_corBorda = borda;
	}

	/**
	 * @param green 
	 * @param green 
	 * @return Returns the _corCelulas.
	 */
	protected Color getCorCelulas(Color green) {
		return _corCelulas;
	}

	/**
	 * @param celulas The _corCelulas to set.
	 */
	protected void setCorCelulas(Color celulas) {
		_corCelulas = celulas;
	}

	/**
	 * @return Returns the _corFundo.
	 */
	protected Color getCorFundo() {
		return _corFundo;
	}

	/**
	 * @param fundo The _corFundo to set.
	 */
	protected void setCorFundo(Color fundo) {
		_corFundo = fundo;
	}

	/**
	 * @param red 
	 * @return Returns the _corDead.
	 */
	protected Color getCorDead(Color red) {
		return _corDead;
	}

	/**
	 * @param fundo The _corDead to set.
	 */
	protected void setCorDead(Color fundo) {
		_corDead = fundo;
	}

	/**
	 * @return Returns the _corVivo.
	 */
	protected Color getCorVivo() {
		return _corVivo;
	}

	/**
	 * @param celulas The _corVivo to set.
	 */
	protected void setCorVivo(Color celulas) {
		_corVivo = celulas;
	}

	/**
	 * Construtor - inicia o ambiente (matriz) para o jogo da vida
	 * @param linhas linhas para o ambiente
	 * @param colunas colunas para o ambiente
	 */
	LifeGraf (int linhas, int colunas) {

		// Ativa construtor pai e Cria o ambiente (matriz)
		super(linhas, colunas);

		_jframe = new JFrame("Jogo da Vida");
		_jframe.setSize(600, 435);
		_jframe.setResizable(false);
		_jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// painel de ambiente
		_pAmbiente = new JPanel(); // cria painel
		_pAmbiente.setLayout(new GridLayout(linhas, colunas)); // define layout
		_labels = new JLabel [linhas][colunas]; // cria array de jpanels
		setCorCelulas(Color.GREEN);
		setCorDead(Color.RED);
		setCorFundo(Color.WHITE);
		setCorBorda(Color.BLACK);
		setCorVivo(Color.GREEN);

		// painel de botoes
		_pBotoes = new JPanel();
		// Define layout dos botoes
		_pBotoes.setLayout (new FlowLayout ());

		// Menu bar
		_menuBar = new JMenuBar();
	}

	/**
	 * Adiciona os componentes na janela
     //* @param frame janela principal (JFrame)
	 */
	public void adicionaComponentes() {

		// Pega o container da janela principal
		Container pane = _jframe.getContentPane();

		// Insere painel de ambiente e as celulas(jlabels)
		inserePainelAmbiente(pane);

		// Insere painel de botoes e os botoes 
		inserePainelBotoes(pane);

		// Insere opcoes de menu
		//insereMenu();
	}

	public Object A(Object b){
		return b;
	}

	/**
	 * Trata evento mouse pressionado
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		Component c = e.getComponent();
		//  jose = new Josephus();
		// a = new ListaDuplamenteLigadaCircular();

		// Se for pressionado um JButton
		//        else
		if (c instanceof JButton) {
			JButton jb = (JButton)c;
			if(jb.getText().equals("Executar")) {
				_jbExec.setEnabled(false);
				_jbConfig.setEnabled(true);
				_txfIntervalo.setEnabled(false);
				_txfIndividuos.setEnabled(false);
				int count = 0;
				float pessoa = Float.parseFloat(_txfIndividuos.getText());
				float intervalo = Float.parseFloat(_txfIntervalo.getText());
				//setCorFundo(Color.GREEN);

				for (int i = 19; i >= 0; i--) {
					for (int j = 19; j >= 0; j--) {
						if (count < pessoa) {
							//a.inserirApos(i+1, b);
							_labels[i][j].setForeground(getCorCelulas(Color.GREEN));
							_labels[i][j].setBackground(getCorCelulas(Color.GREEN));
							//System.out.println(count);
							count++;

						}

						//if(count == pessoa) {
						//	break;
						//


						//setCorFundo(Color.BLACK);
					}


				}

				Fila(pessoa, intervalo);
				CircJosephus(pessoa, intervalo);

				//				for (int i = 0; i < 20; i++) {
				//					for (int j = 0; j < 20; j++) {
				//						//	if(jose.conteudo.vivo == false) {
				//						//_labels[i][j].setForeground(getCorDead(Color.RED));
				//						//_labels[i][j].setBackground(getCorDead(Color.RED));
				//						//}
				//					}
				//				}
				//calcularProximaGeracao();
				desenhaAmbiente();
			}
			else if(jb.getText().equals("Configurar")){
				_txfIntervalo.setEnabled(true);
				_txfIndividuos.setEnabled(true);
				_jbExec.setEnabled(true);
				_jbConfig.setEnabled(false);
			}
			else if(jb.getText().equals("Sair")){
				System.exit(0);
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * Trata eventos de opcoes de menu
	 * @param e comando correspondente a opcao
	 */
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Sair")) {
			System.exit(0);
		}
	}

	private void desenhaAmbiente(){
		for (int i = 0; i < getAmbiente().length; i++) {
			for (int j = 0; j < getAmbiente()[i].length; j++) {
				if (getAmbiente()[i][j].getValorCelula() == true) {
					_labels[i][j].setBackground(getCorCelulas(Color.GREEN));
					_labels[i][j].setForeground(getCorCelulas(Color.GREEN));
				}
				else {
					_labels[i][j].setBackground(getCorFundo());
					_labels[i][j].setForeground(getCorFundo());
				}
			}
		}
	}

	/**
	 * Mostra a interface com os componentes
	 */
	public void mostraAmbienteGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true); // Estilo Java (default)

		//Define a janela e adiciona os componentes.
		adicionaComponentes();

		//Mostra a janela.
		_jframe.setVisible(true);
	}

	private void inserePainelAmbiente(Container pane){
		// Cria e define os jlabels para o ambiente
		for (int i = 0; i < _labels.length; i++) {
			for (int j = 0; j < _labels[i].length; j++) {
				// Cria o jlabel de define os atributos
				_labels[i][j] =  new JLabel (""+ i +","+ j);
				_labels[i][j].setToolTipText("(" + (_labels[i].length-i) + "," + (_labels[i].length-j) + ")");
				_labels[i][j].setOpaque(true);
				_labels[i][j].setForeground(getCorFundo());
				_labels[i][j].setBorder(BorderFactory.createLineBorder(getCorBorda()));
				_labels[i][j].setBackground(getCorFundo());
				_labels[i][j].addMouseListener(this);
				_labels[i][j].addMouseMotionListener(this);

				// Adiciona o jlabel para o painel de ambiente
				_pAmbiente.add(_labels[i][j], 0);
			}
		}
		// Adiciona o painel de jlabels na posicao norte da janela principal 
		pane.add ("North", _pAmbiente);
	}

	private void inserePainelBotoes(Container pane){
		// Cria os Labels e TextFields
		_jlIntervalo = new JLabel("Intervalo ", JLabel.RIGHT);
		_jlIndividuos = new JLabel("Individuos ", JLabel.RIGHT);

		_txfIntervalo = new JTextField(2);
		_txfIntervalo.setEnabled(false);
		_txfIndividuos = new JTextField(2);
		_txfIndividuos.setEnabled(false);

		// adiciona os Labels e TextFields
		_pBotoes.add(_jlIndividuos);
		_pBotoes.add(_txfIndividuos);

		_pBotoes.add(_jlIntervalo);
		_pBotoes.add(_txfIntervalo);

		// Cria os botoes
		_jbExec = new JButton ("Executar");
		_jbExec.setToolTipText("Iniciar Simulacao");
		_jbExec.addMouseListener(this);
		_jbExec.setEnabled(false);

		_jbConfig = new JButton ("Configurar");
		_jbConfig.setToolTipText("Configuracao da Simulacao");
		_jbConfig.addMouseListener(this);

		_jbSair = new JButton ("Sair");
		_jbSair.setToolTipText("Termina programa");
		_jbSair.addMouseListener(this);

		// adiciona os botoes
		_pBotoes.add (_jbExec);
		_pBotoes.add (_jbConfig);
		_pBotoes.add (_jbSair);

		//adiciona o painel de botoes na posicao sul da janela principal
		pane.add ("Center", _pBotoes);

	}

	Object c;

	IListaDuplamenteLigadaCircular jose;
	No conteudo;
	ListaDuplamenteLigadaCircular d;

	Guerreiro guerra[][];

	void Fila(float a, float b){
		float pessoa = Float.parseFloat(_txfIndividuos.getText());	
		setFila(new Guerreiro[(int) a][(int) b]);
		criarFila(pessoa);
	}

	Object p = 3;

	public void criarFila(float pessoa) {
		int count = 0;
		for(int i = 0; i < getFila().length; i++) {
			for(int j = 0; j < getFila()[i].length; j++) {
				if(count < pessoa) {
					getFila()[i][j] = new Guerreiro();
					fil.inserirInicio(getFila()[i][j]);
				}
				count++;
			}
		}
	}

	public void setFila(Guerreiro [][]fila){
		guerra = fila;
	}


	public Guerreiro [][]getFila(){
		return this.guerra;
	}


	Object CircJosephus(float pessoa, float intervalo){
		float j = pessoa +1;
		float k;        
		k = intervalo;
		int i = 1;
		//float h;
		No atual = fil.getInicio();
		if(pessoa % 2 == 0) {
			while(j != 1){
				i = 1;

				while(i != k){
					if(atual.vivo == false && atual.proximo.vivo == true){
						atual = atual.proximo;
						//i++;
					} else {				
						atual = atual.proximo;
						i++;	
					} 

				}
				atual.vivo = false;
				j--;
				System.out.println(k);
				k = k + intervalo;
				k = k % (pessoa+1);

			}
		} else {
			while(j != 1){
				i = 1;
				while(i != k){
					if(atual.vivo == false && atual.proximo.vivo == true){
						atual = atual.proximo;

					} else {
						atual = atual.proximo;
						i++;
					}
				}
				atual.vivo = false;
				j--;
				System.out.println(k);
				k = k + intervalo;
				k = k % (pessoa);
				if (k == 0) {
					k = 5;
				}
			}


		}
		System.out.println("↑");
		//System.out.println("|");
		System.out.println(atual);

		return atual;
	}
}