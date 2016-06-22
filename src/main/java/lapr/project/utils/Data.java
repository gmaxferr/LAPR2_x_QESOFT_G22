package lapr.project.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.exceptions.DiaInvalidoException;
import lapr.project.exceptions.MesInvalidoException;
import lapr.project.exceptions.TempoInvalidoException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Representa uma data através do dia, mês e ano.
 */
public class Data implements Comparable<Data>, Importable<Data>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "data";

    /**
     * O ano da data.
     */
    private int ano;

    /**
     * O mês da data.
     */
    private int mes;

    /**
     * O dia da data.
     */
    private int dia;

    /**
     * A hora.
     */
    private int hora;

    /**
     * O minuto.
     */
    private int minuto;

    /**
     * O segundo.
     */
    private int segundo;

    /**
     * Nomes dos dias da semana.
     */
    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
        "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};

    /**
     * Número de dias de cada mês do ano.
     */
    private static int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
        31, 30, 31};

    /**
     * Nomes dos meses do ano.
     */
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro",
        "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
        "Outubro", "Novembro", "Dezembro"};

    /**
     * Constrói uma instância de Data recebendo o ano, o mês e o dia.
     *
     * @param ano o ano da data.
     * @param mes o mês da data.
     * @param dia o dia da data.
     * @param hora a hora
     * @param minuto o minuto
     * @param segundo o segundo
     */
    public Data(int ano, int mes, int dia, int hora, int minuto, int segundo) {
        setData(ano, mes, dia, hora, minuto, segundo);
    }

    /**
     * Constrói uma instância de Data recebendo o ano, o mês e o dia.
     *
     * @param ano o ano da data.
     * @param mes o mês da data.
     * @param dia o dia da data.
     */
    public Data(int ano, int mes, int dia) {
        setData(ano, mes, dia, 0, 0, 0);
    }

    /**
     * Constrói uma instância de Data com a data atual
     */
    public Data() {
        Calendar dataAtual = Calendar.getInstance();
        ano = dataAtual.get(Calendar.YEAR);
        mes = dataAtual.get(Calendar.MONTH)+1;
        dia = dataAtual.get(Calendar.DATE);
    }

    /**
     * Constrói uma instância de Data com as mesmas caraterísticas da data
     * recebida por parâmetro.
     *
     * @param outraData a data com as características a copiar.
     */
    public Data(Data outraData) {
        ano = outraData.ano;
        mes = outraData.mes;
        dia = outraData.dia;
    }

    public Data(String data) {
        loadFromCompactString(data);
    }

    /**
     * Devolve o ano da data.
     *
     * @return ano da data
     */
    public int getAno() {
        return ano;
    }

    /**
     * Devolve o mês da data.
     *
     * @return mês da data.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Devolve o dia da data.
     *
     * @return dia da data.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Modifica o ano, o mês e o dia da data.
     *
     * @param ano o novo ano da data.
     * @param mes o novo mês da data.
     * @param dia o novo dia da data.
     */
    public final void setData(int ano, int mes, int dia) {
        setData(ano, mes, dia, 0, 0, 0);
    }

    /**
     * Modifica o ano, o mês, o dia e a hora da data.
     *
     * @param ano o novo ano da data.
     * @param mes o novo mês da data.
     * @param dia o novo dia da data.
     * @param hora a hora
     * @param minuto o minuto
     * @param segundo o segundo
     */
    public final void setData(int ano, int mes, int dia, int hora, int minuto, int segundo) {
        if (mes < 1 || mes > 12) {
            throw new MesInvalidoException("Mês " + mes + " é inválido!!");
        }
        if (dia < 1 || (mes == 2 && Data.isAnoBissexto(ano)
                ? dia > 29
                : dia > Data.diasPorMes[mes])) {
            throw new DiaInvalidoException("Dia " + ano + "/" + mes + "/" + dia
                    + " é inválido!!");
        }
        if (hora < 0 || hora > 23
                || minuto < 0 || minuto > 59
                || segundo < 0 || segundo > 59
                || (hora == 24 && minuto == 00 && segundo == 0)) {
            throw new TempoInvalidoException("Hora: " + hora + ":" + minuto + ":" + segundo + " é inválida.");
        }
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public void loadFromCompactString(String compactStringData) {
        String d[] = compactStringData.split("T");
        String date[] = d[0].split("-");
        String time[] = d[1].split(":");
        this.ano = Integer.parseInt(date[0]);
        this.mes = Integer.parseInt(date[1]);
        this.dia = Integer.parseInt(date[2]);
        this.hora = Integer.parseInt(time[0]);
        this.minuto = Integer.parseInt(time[0]);
        this.segundo = Integer.parseInt(time[0].split("Z")[0]);
    }

    public String toCompactString() {
        return String.format("%04d-%02d-%02dT%02d:%02d:%02dZ", ano, mes, dia, hora, minuto, segundo);
    }

    /**
     * Devolve a descrição textual da data no formato: diaDaSemana, dia de mês
     * de ano.
     *
     * @return caraterísticas da data.
     */
    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia,
                nomeMes[mes], ano);
    }

    /**
     * Devolve a data no formato:%04d/%02d/%02d.
     *
     * @return caraterísticas da data.
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes+1, dia);
    }

    /**
     * Compara a data com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com a data.
     * @return true se o objeto recebido representar uma data equivalente à
     * data. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Data outraData = (Data) outroObjeto;
        return ano == outraData.ano && mes == outraData.mes
                && dia == outraData.dia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.ano;
        hash = 29 * hash + this.mes;
        hash = 29 * hash + this.dia;
        return hash;
    }

    /**
     * Compara a data com a outra data recebida por parâmetro.
     *
     * @param outraData a data a ser comparada.
     * @return o valor 0 se a outraData recebida é igual à data; o valor -1 se a
     * outraData for posterior à data; o valor 1 se a outraData for anterior à
     * data.
     */
    @Override
    public int compareTo(Data outraData) {
        return (outraData.isMaior(this)) ? -1 : (isMaior(outraData)) ? 1 : 0;
    }

    /**
     * Devolve o dia da semana da data.
     *
     * @return dia da semana da data.
     */
    public String diaDaSemana() {
        int totalDias = contaDias();
        totalDias = totalDias % 7;

        return nomeDiaDaSemana[totalDias];
    }

    /**
     * Devolve true se a data for maior do que a data recebida por parâmetro. Se
     * a data for menor ou igual à data recebida por parâmetro, devolve false.
     *
     * @param outraData a outra data com a qual se compara a data.
     * @return true se a data for maior do que a data recebida por parâmetro,
     * caso contrário devolve false.
     */
    public boolean isMaior(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }

    /**
     * Devolve a diferença em número de dias entre a data e a data recebida por
     * parâmetro.
     *
     * @param outraData a outra data com a qual se compara a data para calcular
     * a diferença do número de dias.
     * @return diferença em número de dias entre a data e a data recebida por
     * parâmetro.
     */
    public int diferenca(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    /**
     * Devolve a diferença em número de dias entre a data e a data recebida por
     * parâmetro com ano, mês e dia.
     *
     * @param ano o ano da data com a qual se compara a data para calcular a
     * diferença do número de dias.
     * @param mes o mês da data com a qual se compara a data para calcular a
     * diferença do número de dias.
     * @param dia o dia da data com a qual se compara a data para calcular a
     * diferença do número de dias.
     * @return diferença em número de dias entre a data e a data recebida por
     * parâmetro com ano, mês e dia.
     */
    public int diferenca(int ano, int mes, int dia) {
        int totalDias = contaDias();
        Data outraData = new Data(ano, mes, dia, 0, 0, 0);
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    /**
     * Devolve true se o ano passado por parâmetro for bissexto. Se o ano
     * passado por parâmetro não for bissexto, devolve false.
     *
     * @param ano o ano a validar.
     * @return true se o ano passado por parâmetro for bissexto, caso contrário
     * devolve false.
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * Devolve a data atual do sistema.
     *
     * @return a data atual do sistema.
     */
    public static Data dataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        int hora = hoje.get(Calendar.HOUR_OF_DAY);
        int minuto = hoje.get(Calendar.MINUTE);
        int segundo = hoje.get(Calendar.SECOND);
        return new Data(ano, mes, dia, hora, minuto, segundo);
    }

    /**
     * Devolve o número de dias desde o dia 1/1/1 até à data.
     *
     * @return número de dias desde o dia 1/1/1 até à data.
     */
    private int contaDias() {
        int totalDias = 0;

        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (isAnoBissexto(ano) && mes > 2) ? 1 : 0;
        totalDias += dia;

        return totalDias;
    }

    /**
     * @return Retorna esta data em formato de Date (para compatibilidade com
     * outros métodos).
     */
    public Date toDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes-1, dia, hora, minuto, segundo);
        Date result = calendar.getTime();
        return result;
    }

    @Override
    public Data importContentFromXMLNode(Node node) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        document.appendChild(document.importNode(node, true));

        Node n = document.getChildNodes().item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            loadFromCompactString(elem.getTextContent());
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elemBase = document.createElement(ROOT_ELEMENT_NAME);
            elemBase.setTextContent(toCompactString());
            document.appendChild(elemBase);

            node = elemBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

}
