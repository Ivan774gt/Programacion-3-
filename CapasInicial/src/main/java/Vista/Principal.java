/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Codigo update
        EmpresaDAO empresadao = new EmpresaDAO();
        Empresa empresa = new Empresa();
        empresa.setCodigoEmpresa(1);
        empresa.setNombreEmpresa("Universidad Galileo");
        int x;
        x = empresadao.update(empresa);
        //empresadao.insert(empresa);
        System.out.println(empresa.toString());
        
        
        
        
        
        
    }
    
    
}
