package com.br.api.dados;

import com.br.api.banco.jdbc.Usuario;
import com.br.api.banco.jdbc.controller.EspecificacaoMaquinaController;
import com.br.api.banco.jdbc.controller.UsuarioController;
import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class LoginCli {

    public static void main(String[] args) throws InterruptedException, IOException {
        UsuarioController usuarioDAO = new UsuarioController();
        EspecificacaoMaquinaController emDAO = new EspecificacaoMaquinaController();
        Looca looca = new Looca();
        Logger log = new Logger("logAnalyx.txt");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Email:");
        String email = sc1.nextLine();
        System.out.println("Senha:");
        String senha = sc2.nextLine();
        try {
            Usuario user = usuarioDAO.entrarAzure(email, senha);
            System.out.println("""
                              ````````````````11111111```000000`````````````````
                               ``````11000`1100000000000000111100````````````````
                               ````1000000000011111111111011010100```````````````
                               ```001100011111111111111111100``110```````````````
                               ``10110```01111111111110111110``100```````````````
                               ``10100``1111111111111111111110111````````````````
                               ```00100011111111111111111111100``````````````````
                               ````0000111111111111111111111110``````````````````
                               ``````001111111111110011111110101`````````````````
                               ``````101111111111110011111100`00`````````````````
                               ```````01111111111110011000011101`````````````````
                               ```````1011111111101`````000``00``````````````````
                               ````````00111111110``1`11101``00``````````````````
                               `````````00001111101````1```100```````````````````
                               ```````0011100000110001111000100``````````````````
                               ``````001111111111111100001111101`````````````````
                               `````1011111111111111111111111100`````````````````
                               `````00111111111111111111111111100````````````````
                               `````01011111001111111111111111110001```1111``````
                               `````00011111001111111111111111110010000000000````
                               `````0011111100111111111111111111101100001``100```
                               `````001111110111111111111001111110100101`11`101``
                               ````001111111011111111111111111111010100`1111`01``
                               ```0011111111011111111111111111110000`01`1111`01``
                               ``1011111111001111111111111111110011110`11111`01``
                               ```001111110011111111111111000000111111`1111`10```
                               ````00010000`111100001110000110011111111111``01```
                               `````110011001111111110010`````101110000111101````
                               ````````````10111111100101``11``0``````110001`````
                               `````````````101111110110`1111``01````````````````
                               ```````````````0011110100`1111`101````````````````
                               ````````````````101110110`1111`10`````````````````
                               ``````````````````0011011`111`101`````````````````
                               ```````````````````1000111111101``````````````````
                               """);
            
            System.out.println("Bem vindo de volta!");
            String hostName = looca.getRede().getParametros().getHostName();
            emDAO.cadastroDaMaquina(hostName, user.getFuncionario());
            //emDAO.cadastroDaMaquinaLocal(hostName);
            log.logInfo("Login efetuado user: " + email + " Maquina: " + emDAO.getEspecificacaoMaquinaPorHostNameAzure(hostName));
            ApiCli apiCli = new ApiCli();
            apiCli.startApp();
        } catch (Exception e) {
            log.logWarning("Informações de login incorretas, user: " + email);
            System.out.println("erro ->" + e.getMessage());
            e.printStackTrace();
        }
        log.close();

    }
}
