package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQt;
    private Date checkIn;
    private Date checkOut;

    public Reserva(Integer numeroQt, Date checkIn, Date checkOut) {
        this.numeroQt = numeroQt;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //Formatando a data.
    final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getNumeroQt() {
        return numeroQt;
    }

    public void setNumeroQt(Integer numeroQt) {
        this.numeroQt = numeroQt;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //long pois, usando um macete para cálculo de datas e o retorno será long.
    public long duracao() {
        long diferenca = checkOut.getTime() - checkIn.getTime(); //Calculo para descobrir os mili-segundos.
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); //Convertendo mili-segundos em dias.
    }

    public String atualizarDatas(Date checkIn, Date checkOut) {

        Date agora = new Date();

        if (checkIn.before(agora) || checkOut.before(agora)) {
            return "Erro em sua reserva. O check-out precisa ser uma data futura.";
        }

        if (!checkOut.after(checkIn)) {
            return "Erro em sua reserva. A data de check-out precisa ser posterior ao check-in.";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    @Override
    public String toString() {
        return "Reserva: Quarto "
                + numeroQt
                + ", check-in: "
                + simpleDateFormat.format(checkIn) //data formatada.
                + ", check-out: "
                + simpleDateFormat.format(checkOut) //data formatada.
                + ", "
                + duracao()
                + " noites.";
    }
}
