/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ya.tarea;

import com.ya.tarea.dao.Persona;
import com.ya.tarea.dao.PersonaMod;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yobany Abrego
 */
public class Main
{
    private static Scanner entrada = new Scanner (System.in);
    private static PersonaMod mod = new PersonaMod();
    
    public static void main(String[] args)
    {
        
        String Option= "L";
                while (!Option.contentEquals("S")){
            switch (Option) {
                case "L":
                    Utilidades.print("Lista de Personas");
                    obtenerPersona();
                    break;
                case "I":
                     Utilidades.print("Insertar Datos a Persona");
                     InsertarPersona();
                    break;
                case "A":
                    Utilidades.print("Actualizar Datos a Persona");
                    ActualizarPersona();
                    break;
                case "E":
                    EliminarPersona();
                    break;
                default:
                    Utilidades.print("Opción no encontrada :( ");
            }
            Utilidades.menu();
            Option = entrada.nextLine().toUpperCase();
        }
               
    }
 
    private static void obtenerPersona()
    {
        Utilidades.printEncabezadoTabla();
        ArrayList<Persona> Per = mod.obtenerPersona();
        for(int i = 0; i< Per.size(); i++){
            Utilidades.print(Per.get(i).getRow());
            Utilidades.separador();
        }
        

        
    }
    
    private static void InsertarPersona()
    {
        Persona PersonaN = new Persona();
        Utilidades.printEncabezadoTabla();
        PersonaN.setId(Integer.parseInt(Utilidades.capturarCampo(entrada, "Id", "1")));
        PersonaN.setNombre(Utilidades.capturarCampo(entrada, "Nombre", "Jose"));
        PersonaN.setApellido(Utilidades.capturarCampo(entrada, "Apellido", "Lopez"));
        PersonaN.setEstatura(Double.parseDouble(Utilidades.capturarCampo(entrada, "Estatura", "1.70")));
        PersonaN.setPeso(Double.parseDouble(Utilidades.capturarCampo(entrada, "Peso", "140 lbs")));
        
        int RegistroInsertar = mod.AgregarPersona(PersonaN);
        
        if(RegistroInsertar>0)
        {
            System.out.println("Persona Insertada Correctamente :) ");
        }
        
    }
    
        private static void ActualizarPersona()
    {
        Persona updatePersona = new Persona();
        int Id;
        Utilidades.encabezado("Persona a Actualizar");
        updatePersona.setId(Integer.parseInt(Utilidades.capturarCampo(entrada, "Id", "1"))); 
        updatePersona = mod.obtenerPersona(updatePersona.getId());
        updatePersona.setNombre(Utilidades.capturarCampo(entrada, "Nombre",updatePersona.getNombre()));
        updatePersona.setApellido(Utilidades.capturarCampo(entrada, "Apellido",updatePersona.getApellido()));
        updatePersona.setEstatura(Double.parseDouble(Utilidades.capturarCampo(entrada, 
                "Estatura", Double.toString(updatePersona.getEstatura()))));
        updatePersona.setPeso(Double.parseDouble(Utilidades.capturarCampo(entrada, 
                "Peso", Double.toString(updatePersona.getPeso()))));

            int update = mod.ActualizarPersona(updatePersona);
            if (update > 0) {
                Utilidades.print("Persona Actualizada Satisfactoriamente!");
            }
            Utilidades.separador();
    }
    
    private static void EliminarPersona()
    {
                  
        Persona Id = new Persona();
        int setId;
        Utilidades.encabezado("Ingrese el codigo de la persona a eliminar");
        Id.setId(Integer.parseInt(Utilidades.capturarCampo(entrada, "Id", "")));
        
        Utilidades.print("Realmente desea eliminar Esta Persona?\n S\tSI  |  N \tNo");
        String option = entrada.nextLine().toUpperCase();
        if(option.equals("S")){
                int Delete = mod.EliminarPersona(Id.getId());
                if(Delete > 0){
                    Utilidades.print("Alumno eliminado exitosamente!");
                }else{
                    Utilidades.print("Alumno no encontrado");
                } 
            }

        Utilidades.separador();
    }
     
}
