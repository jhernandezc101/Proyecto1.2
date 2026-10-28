/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canchapro.clasesdelsistema.gestionamiento;
import com.mycompany.canchapro.clasesdelsistema.Cancha;
import javax.swing.JOptionPane;
/**
 *
 * @author josue
 */
public class GestionamientoCancha {
    
    private Cancha[] Canchas = new Cancha[3];
    private int cantidad = 0;
    
    public boolean GuardarDatosCancha(Cancha canchas){
        boolean Encontrado = BuscarDatosCancha(canchas.getCodigo()); 
        if(Encontrado == true){
            return false;
        }
        if(cantidad < Canchas.length){
            Canchas[cantidad] = canchas;
            cantidad ++;
            return true;
        }
        return false;
    }
    public boolean BuscarDatosCancha(int BuscarCancha){
        boolean Encontrado = false;
        int num = 0;
        
        while((num < cantidad) && (Encontrado == false)){
            if(Canchas[num].getCodigo() == BuscarCancha){
                Encontrado = true;
        }
        num ++;    
        }
        return Encontrado;
    }
    public void ModificarDatosCancha(){
        int posicion = 0;
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo a modidicar: "));
        while(posicion < cantidad && Canchas[posicion].getCodigo() != codigo){ 
            posicion++;
        } 
        if(posicion  >= cantidad){
            JOptionPane.showMessageDialog(null, "La cancha no esta registrada no existe");
        }else{
            String NuevoNombre = JOptionPane.showInputDialog("Nuevo Nombre: ");
            int NuevoCodigo = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Codigo: "));
            String Nuevotipo = JOptionPane.showInputDialog("Nuevo Tipo: ");
            int NuevoCapacidad = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Capacidad: "));
            String NuevoEstado = JOptionPane.showInputDialog("Nuevo zEstado: ");
            
            Canchas[posicion].setNombre(NuevoNombre);
            Canchas[posicion].setCodigo(NuevoCodigo);
            Canchas[posicion].setTipo(Nuevotipo);
            Canchas[posicion].setCapacidad(NuevoCapacidad);
            Canchas[posicion].setEstado(NuevoEstado);
            
             JOptionPane.showMessageDialog(null, "Cancha modificada con exito");
            
        }
    }
    public void EliminarDatosCancha(){
        int posicion = 0;
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo a eliminar: "));
        while(posicion < cantidad && Canchas[posicion].getCodigo() != codigo){ 
            posicion++;
        }       
        if( posicion  >= cantidad){
            JOptionPane.showMessageDialog(null, "No se encontro la cancha");
        }else{
           for(int i = posicion; i < cantidad - 1; i++){
           Canchas[i] = Canchas[i + 1]; 
        }
            
            Canchas[cantidad - 1] = null;
            cantidad--;
            JOptionPane.showMessageDialog(null, "Cancha eliminada con exito");
            
        }
    }
    public void MostrarDatosCancha(){
        for(int i = 0; i < cantidad; i++){
        System.out.println("Nombre: " + Canchas[i].getNombre());
        System.out.println("Codigo: " + Canchas[i].getCodigo());
        System.out.println("Tipo: " + Canchas[i].getTipo());
        System.out.println("Capacidad: " + Canchas[i].getCapacidad());
        System.out.println("Estado: " + Canchas[i].getEstado());
        }
    }
}

