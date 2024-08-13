import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Número do quarto: ");
            int numero = scanner.nextInt();

            System.out.print("Informe a data do check-in (dd/MM/yyyy): ");
            Date checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Agora a data de check-out (dd/MM/yyyy): ");
            Date checkOut = simpleDateFormat.parse(scanner.next());

            //Minha data de reserva não pode ser instanciada se minha data de checkout não for posterior a data de checkin.
            //Construtor.
            Reserva reserva = new Reserva(numero, checkIn, checkOut);

            System.out.println(reserva);

            System.out.println("----------");

            System.out.println("Informe os dados para atualizar a reserva: ");

            System.out.print("Data do check-in: ");
            checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Agora a data do checkOut: ");
            checkOut = simpleDateFormat.parse(scanner.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println(reserva);

        }
        catch (ParseException e) {

            System.out.println("Formato da data invalido!");

        }
        catch (DomainException e) {

            System.out.println(e.getMessage());

        }
        //Criando um catch com uma exceção genérica para ser feito o upcast para RunTimeException e mostrar a mensagem de erro inesperado.
        //Exceção também possui uma estrutura de herança e upcast.
        catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }

        scanner.close();

    }
}