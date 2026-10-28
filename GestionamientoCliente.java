/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canchapro.clasesdelsistema.gestionamiento;
import com.mycompany.canchapro.clasesdelsistema.Clientes;
import javax.swing.JOptionPane;
/**
 *
 * @author josue
 */
public class GestionamientoCliente {
    
    private Clientes[] Clientes = new Clientes[25];
    private int cantidad = 0;
    
    public boolean RegistrarCliente(Clientes clientes){
        
        boolean Encontrado = BuscarCliente(clientes.getCodigo()); 
        if(Encontrado == true){
            return false;
        }
        if(cantidad < Clientes.length){
            Clientes[cantidad] = clientes;
            cantidad ++;
            return true;
        }
        return false;
    }
    
    public boolean BuscarCliente(int buscacliente){
        boolean Encontrado = false;
        int num = 0;
        
        while((num < cantidad) && (Encontrado == false)){
            if(Clientes[num].getCodigo() == buscacliente){
                Encontrado = true;
        }
        num ++;    
        }
        return Encontrado;
    }
    
    public void ModificarCliente(){
        int posicion = 0;
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo a modidicar: "));
        while(posicion < cantidad && Clientes[posicion].getCodigo() != codigo){ 
            posicion++;
        } 
        if(posicion  >= cantidad){
            JOptionPane.showMessageDialog(null, "Esa posicion no existe");
        }else{
            String NuevoNombre = JOptionPane.showInputDialog("Nuevo Nombre: ");
            int NuevoCodigo = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Codigo: "));
            String Nuevotelefono = JOptionPane.showInputDialog("Nuevo Telefono: ");
            String NuevoCorreo = JOptionPane.showInputDialog("Nuevo Correo: ");
            
            Clientes[posicion].setNombre(NuevoNombre);
            Clientes[posicion].setCodigo(NuevoCodigo);
            Clientes[posicion].setTelefono(Nuevotelefono);
            Clientes[posicion].setCorreo(NuevoCorreo);
            
             JOptionPane.showMessageDialog(null, "Cliente modificado con exito");
            
        }
    }
    public void EliminarCliente(){
        int posicion = 0;
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo a eliminar: "));
        while(posicion < cantidad && Clientes[posicion].getCodigo() != codigo){ 
            posicion++;
        }       
        if( posicion  >= cantidad){
            JOptionPane.showMessageDialog(null, "No se encontro al cliente");
        }else{
           for(int i = posicion; i < cantidad - 1; i++){
           Clientes[i] = Clientes[i + 1]; 
        }
            
            Clientes[cantidad - 1] = null;
            cantidad--;
            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
            
        }
    }
}
