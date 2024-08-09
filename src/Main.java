import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();

        System.out.print("Informe a data do check-in (dd/MM/yyyy): ");
        Date checkIn = simpleDateFormat.parse(scanner.next());

        System.out.print("Agora a data de check-out (dd/MM/yyyy): ");
        Date checkOut = simpleDateFormat.parse(scanner.next());

        //Minha data de reserva não pode ser instanciada se minha data de checkout não for posterior a data de checkin.

        if (!checkOut.after(checkIn)) {

            System.out.println("Erro em sua reserva. A data de check-out precisa ser posterior ao check-in.");

        } else {

            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println(reserva);

            System.out.println("----------");

            System.out.println("Informe os dados para atualizar a reserva: ");

            System.out.print("Data do check-in: ");
            checkIn = simpleDateFormat.parse(scanner.next());

            System.out.print("Agora a data do checkOut: ");
            checkOut = simpleDateFormat.parse(scanner.next());

            String error = reserva.atualizarDatas(checkIn, checkOut);

            if (error != null) {
                System.out.println("Erro em sua reserva: " + error);
            } else {
                System.out.println(reserva);
            }
        }
        scanner.close();
    }
}