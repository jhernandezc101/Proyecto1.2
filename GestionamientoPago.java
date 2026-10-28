/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canchapro.clasesdelsistema.gestionamiento;
import com.mycompany.canchapro.clasesdelsistema.Pago;
import com.mycompany.canchapro.clasesdelsistema.Reserva;
/**
 *
 * @author josue
 */
public class GestionamientoPago {
    private Pago[] pagos = new Pago[1000];
    private int cantidad = 0;
    
    public GestionamientoPago(){
    }
        public int BuscarPago(String codigopago){
            for(int i = 0; i < cantidad; i++){
            if(pagos[i].getCodigopago().equals(codigopago)){
                return i;    
        }    
    }
    System.out.println("No se encontro ningun pago");
    return -1;
}    
        public boolean RegistroPago(Pago pagonuevo, Reserva reserva){
        if(pagonuevo == null || reserva == null){
                return false;
        }
        if(cantidad >= pagos.length){
                return false;
        }
        if(BuscarPago(pagonuevo.getCodigopago()) != -1){
                return false;
        }
        boolean CodigosRepetidos = pagonuevo.getCodigoreserva().equals(String.valueOf(reserva.getCodigoreserva()));
        if(CodigosRepetidos == false){
            return false;
        }
        double SaldoActual = reserva.getSaldoPendiente();
        if(pagonuevo.getMonto() <= 0 || pagonuevo.getMonto() > SaldoActual){
            return false;
        }
        double SaldoNuevo = SaldoActual - pagonuevo.getMonto();
        reserva.setSaldoPendiente(SaldoNuevo);
        pagonuevo.setSaldopendiente(SaldoNuevo);
        if(SaldoNuevo == 0){
            pagonuevo.setEstado("PAGADO");
        }else{
            pagonuevo.setEstado("PENDIENTE");
        }
        pagos[cantidad] = pagonuevo;
        cantidad++;
        return true;
    }
    public void MostrarDatosPagos(){
        for(int i = 0; i < cantidad; i++){
        System.out.println("Codigo de Pago: " + pagos[i].getCodigopago());
        System.out.println("Codigo de Reserva: " + pagos[i].getCodigoreserva());
        System.out.println("Cliente: " + pagos[i].getCliente());
        System.out.println("Fecha de Pago: " + pagos[i].getFechapago());
        System.out.println("Hora de pago: " + pagos[i].getHorapago());
        System.out.println("Metodo de Pago: " + pagos[i].getMetodopago());
        System.out.println("Tipo de Pago: " + pagos[i].getTipopago());
        System.out.println("Monto: " + pagos[i].getMonto());
        System.out.println("Estado: " + pagos[i].getEstado());
        System.out.println("Saldo Pendiente: " + pagos[i].getSaldopendiente());
        System.out.println("--------------------------------------------------");
        }
    }
    public int getCantidad(){
        return cantidad;
    }    
}
