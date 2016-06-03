package classesModelERegistoDeESOFT;

/**
 * Representação da User Interface do caso de uso - Registar Utilizador
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistarUtilizadorUI {

    RegistarUtilizadorController controller = new RegistarUtilizadorController();

    public void UI() {
        controller.getRegistoUtilizadores();
        controller.novoUtilizador();
        controller.setDados("nomeIntroduzidoPeloUtilizador", "emailIntroduzidoPeloUtilizador", "passwordIntroduzidoPeloUtilizador");
        controller.addUtilizador();
    }
}
