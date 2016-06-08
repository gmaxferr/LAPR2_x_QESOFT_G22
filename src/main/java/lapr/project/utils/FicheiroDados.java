package lapr.project.utils;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Classe que permite a leitura de ficheiros.
 *
 * @author Ana Leite e Ricardo Osório
 */
public class FicheiroDados {

    /**
     * Nome do ficheiro binário que vai ser criado automaticamente na paste do
     * projecto quando o utilizador fecha o programa
     */
    public static final String NOME_FICHEIRO_BINARIO_PREDEFINICAO = "CentroExposicoesAuto.bin";

    /**
     * Nome do ficheiro de texto responsável por ter a informação relativa ao
     * utilizadores
     */
    private static final String NOME_FICHEIRO_TEXTO_UTILIZADORES_PREDEFINICAO = "Utilizadores.txt";

    /**
     * Nome do ficheiro de texto responsável por ter a informação relativa às
     * exposições
     */
    private static final String NOME_FICHEIRO_TEXTO_EXPOSICOES_PREDEFINICAO = "Exposicoes.txt";

    /**
     * Nome do ficheiro de texto responsável por ter a informação relativa às
     * demonstrações
     */
    private static final String NOME_FICHEIRO_TEXTO_DEMONSTRACOES_PREDEFINICAO = "Demonstracoes.txt";

    /**
     * Nome do ficheiro de texto responsável por ter a informação relativa aos
     * recursos a serem criados no centro de exposições
     */
    private static final String NOME_FICHEIRO_TEXTO_RECURSOS_PREDEFINICAO = "Recursos.txt";

    /**
     * Número de linhas a serem lidas do ficheiro Utilizador.txt (nome por
     * predefinição) e a serem colocados como FAE da exposição a ser
     * instanciada. Ter em atenção o número de linhas do ficheiro para que sejam
     * suficientes para todas as instancias
     */
    private static final int NUMERO_FAE_POR_EXPOSICAO = 3;

    /**
     * Número de linhas a serem lidas do ficheiro Organizadores.txt (nome por
     * predefinição) e a serem colocados como Organizadores da exposição a ser
     * instanciada. Ter em atenção o número de linhas do ficheiro para que sejam
     * suficientes para todas as instancias
     */
    private static final int NUMERO_ORGANIZADORES_POR_EXPOSICAO = 2;

    /**
     * Número de linhas a serem lidas do ficheiro Demonstracoes.txt (nome por
     * predefinição) e a serem colocadas como Demonstrações da exposição a ser
     * instanciada. Ter em atenção o número de linhas do ficheiro para que sejam
     * suficientes para todas as instancias
     */
    private static final int NUMERO_DEMONSTRACOES_POR_EXPOSICAO = 2;

    /**
     * Contrutor de objectos do tupo FicheiroDados. Não inicia nenhum parametro,
     * apenas para manter a organização do código e facilitar fututas
     * alterações. Ter em atenção o número de linhas do ficheiro para que sejam
     * suficientes para todas as instancias
     */
    public FicheiroDados() {
    }

    /**
     * Lê o ficheiro binário (se passar por uma mini validação da extenção) e
     * devolve um objecto CentroExposicoes instanciado a partir do ficheiro
     *
     * @param nomeFicheiro nome do ficheiro binário
     * @return objecto CentroExposicoes com toda a informação do ficheiro
     * binário
     */
    public CentroExposicoes lerFicheiroBinario(String nomeFicheiro) {
        CentroExposicoes centroExposicoes;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            try {
                centroExposicoes = (CentroExposicoes) in.readObject();
            } finally {
                in.close();
            }
            return centroExposicoes;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    /**
     * Guarda num ficheiro binário uma instância de CentroExposições contento
     * todas as instância que o constituem
     *
     * @param nomeFicheiro nome do ficheiro binário pretendido
     * @param centroExposicoes Objecto CentroExposições a ser guardado no
     * ficheiro
     * @return tru se for guardado com sucesso, false se não for possível
     * guarda-lo por alguma razão
     */
    public boolean guardarFicheiroBinario(String nomeFicheiro, CentroExposicoes centroExposicoes) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            try {
                out.writeObject(centroExposicoes);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * Lê e instância um objecto CentroExposições a partir de vários ficheiros
     * de texto separados, cada um contento informação relativa a um tipo de
     * dados que contituem o centro de exposições (Utilizadores, Recursos,
     * Demonstrações, Exposições). Este processo é feito por passos intercalados
     * para diminuir linhas de código. Não são feitas validações e os nomes dos
     * ficheiro são pré definidos
     *
     * @param centroExposicoes Objeto CentroExposicoes instanciado a partir da
     * leitura dos ficheiros de texto
     */
    public void lerDadosFicheiroTexto(CentroExposicoes centroExposicoes) {
        Scanner inputExpos;
        Scanner inputUtilizadores;
        Scanner inputDemos;
        Scanner inputRecursos;
        Utilizador utilizador;
        String linhaLidaVetor[];
        String linhaLida;
        Demonstracao demo;
        RegistoUtilizadores ru;
        RegistoExposicoes re;
        RegistoRecursos rr;
        Exposicao exposicao = null;
        RegistoDemonstracoes rd;
        ru = centroExposicoes.getRegistoUtilizadores();
        int cont = 0;
        try {
            inputUtilizadores = new Scanner(new File(NOME_FICHEIRO_TEXTO_UTILIZADORES_PREDEFINICAO));
            inputRecursos = new Scanner(new File(NOME_FICHEIRO_TEXTO_RECURSOS_PREDEFINICAO));
            rr = centroExposicoes.getRegistoRecursos();
            while (inputRecursos.hasNextLine()) {
                linhaLida = inputRecursos.nextLine();
                rr.criarRecurso(linhaLida);
            }
            inputDemos = new Scanner(new File(NOME_FICHEIRO_TEXTO_DEMONSTRACOES_PREDEFINICAO));
            inputExpos = new Scanner(new File(NOME_FICHEIRO_TEXTO_EXPOSICOES_PREDEFINICAO));
            re = centroExposicoes.getRegistoExposicoes();
            while (inputExpos.hasNextLine()) {
                linhaLidaVetor = inputExpos.nextLine().split(";");
//                exposicao = new Exposicao(linhaLidaVetor[0], linhaLidaVetor[1], new Data(linhaLidaVetor[2]), new Data(linhaLidaVetor[3]), new Local(linhaLidaVetor[4]), centroExposicoes);

                //add organizadores
                for (int i = 0; i < NUMERO_ORGANIZADORES_POR_EXPOSICAO; i++) {
                    linhaLidaVetor = inputUtilizadores.nextLine().split(";");
                    utilizador = new Utilizador(linhaLidaVetor[0], linhaLidaVetor[1], linhaLidaVetor[2].toCharArray(), linhaLidaVetor[3]);
                    ru.addUtilizador(utilizador);
                    utilizador.setUtilizadorRegistado();
                    exposicao.addOrganizador(utilizador);
                }

                //add fae
                for (int i = 0; i < NUMERO_FAE_POR_EXPOSICAO; i++) {
                    linhaLidaVetor = inputUtilizadores.nextLine().split(";");
                    utilizador = new Utilizador(linhaLidaVetor[0], linhaLidaVetor[1], linhaLidaVetor[2].toCharArray(), linhaLidaVetor[3]);
                    ru.addUtilizador(utilizador);
                    utilizador.setUtilizadorRegistado();
                    exposicao.addFAE(utilizador);//, Integer.parseInt(linhaLidaVetor[4]));  -> experiência
                }

                //add demos
                rd = exposicao.getRegistoDemonstracoes();
                for (int i = 0; i < NUMERO_DEMONSTRACOES_POR_EXPOSICAO; i++) {
                    linhaLida = inputDemos.nextLine();
                    demo = new Demonstracao(linhaLida);
                    rr = demo.getListaRecursosNecessarios();
                    rr.setRecurso(centroExposicoes.getRegistoRecursos().getListaDeRecursos().get(cont));
                    cont++;
                    rd.adicionaDemonstracao(demo);
                }
                re.registaExposicao(exposicao);
            }

            //Expositores (lê os restantes utilizadores do ficheiro)
            while (inputUtilizadores.hasNextLine()) {
                linhaLidaVetor = inputUtilizadores.nextLine().split(";");
                utilizador = new Utilizador(linhaLidaVetor[0], linhaLidaVetor[1], linhaLidaVetor[2].toCharArray(), linhaLidaVetor[3]);
                ru.addUtilizador(utilizador);
                utilizador.setUtilizadorRegistado();
                centroExposicoes.getRegistoExpositores().addExpositor(utilizador);
            }

            inputExpos.close();
            inputDemos.close();
            inputRecursos.close();
            inputUtilizadores.close();

            RegistoMecanismos rm = centroExposicoes.getRegistoMecanismos();
            rm.addMecanismo(new MecanismoPredefinidoA());
            rm.addMecanismo(new MecanismoPredefinidoB());
            rm.addMecanismo(new MecanismoPredefinidoC());
        } catch (FileNotFoundException e) {
            //apenas se os ficheiros ainda não tiverem sido colocados na pasta
            JOptionPane.showMessageDialog(null, "Os ficheiros de texto necessários para carregar os dados não se encontram na pasta do projeto!\nDevem de ser colocado na pasta do projecto em MeusDocumentos.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
}
