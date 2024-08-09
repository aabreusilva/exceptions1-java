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

    public void atualizarDatas(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
