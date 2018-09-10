/* Autor: Douglas Onofre
 * Data: 09/09/2018
 * Versão:1.0
 */
package jackpreta;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dougl
 */
public class JackPreta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Adicionando teclado
        Scanner tec = new Scanner(System.in);
        System.out.println("Quer jogar?(S/N)");
        //Iniciando variáveis de decisão e acumuladores
        String resp1; String resp2;
        int soma = 0;
        //LEIA(RESP1)
        resp1 = tec.nextLine();
        //Que comecem os jogos
        while("S".equals(resp1) ){
            System.out.println("Bem vindo ao 21!");
            //Criando um objeto que gera números aleatórios
            Random rand = new Random();
            /*Criando uma variável que receba o número aleatório de 13 posições
            *mas como ele deve variar entre 1 e 13(A a K)
            *Eu tenho que pegar esse valor e acrescentar 1
            *Se eu não fizesse isso, ele geraria um número
            de 0 a 12.
            */
            int carta = rand.nextInt(13) + 1;
            System.out.println("Você tirou "+carta);
            soma = soma + carta;
            //Lógica do jogo ( Se estiver maior que 22, o jogo acaba na hora)
            while(soma < 22 ){
                //Se você pegou a carta e a soma continuou menor que 21, o jogo rola )
                while(soma < 21){
                    //Pegando carta... Você já sabe.
                    carta = rand.nextInt(13) + 1;
                    soma = soma + carta;
                    System.out.println("Seu adversário tirou "+carta);
                    System.out.println("Jogo atual:"+soma);
                    //Analisador de condição de vitória
                    if (soma == 21 ){
                        System.out.println("Seu adversário ganhou.");
                        soma = 0;
                    } else if(soma > 21) {
                        System.out.println("Você ganhou!");
                        soma = 0;
                    }
                    //Lembre-se de resetar a flag, senão o loop relacional
                    //nunca vai acabar
                    //-----
                    //Opa! O adversário não ganhou? Então é sua vez!
                    if (soma<20){
                        System.out.println("Sua vez. Sacar novamente(SN) ou parar?(P)");
                        //Decisão da sua jogada
                        resp2 = tec.nextLine();
                        if ("SN".equals(resp2)){            
                            carta = rand.nextInt(13) + 1;
                            soma = soma + carta;
                            System.out.println("Você tirou "+carta);
                            System.out.println("Esse é o jogo atual: "+soma);
                        }
                        if (soma == 21){
                            System.out.println("Você ganhou!");
                            soma = 0;
                        } else if (soma > 21){
                            System.out.println("Seu adversário ganhou.");
                            soma = 0;
                        }
                    }    
                }
            }
            //Aquele famoso "Try Again?"
            System.out.println("Jogar novamente?(S/N)");
            resp1 = tec.nextLine();
            
        }    
    }
}
    
    

