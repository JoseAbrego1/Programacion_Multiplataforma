/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ya.tarea;

import java.util.Scanner;

/**
 *
 * @author Yobany Abrego
 */
public class Utilidades
{
    public static void separador(){
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }
     
    public static void print(String text){
        System.out.println(text);
    }
      
    public static void encabezado(String text) {
        separador();
        print(text);
        separador();
    }
    
        public static void menu (){
        String menu = "L Lista de datos\t | I Insertar\t | A Editar(Actualizar)\t | E Eliminar\t | S Salir";
        separador();
        print(menu);
    }
    
    public static String capturarCampo(Scanner entrada, String leyenda, String valorPredeterminado ) {
        print(leyenda + "(" + valorPredeterminado + ") :");
        String input = entrada.nextLine();
        if(input.isEmpty()) {
            return valorPredeterminado;
        }
        return input;
    }
    public static void printEncabezadoTabla () {
        separador();
        print(String.format("%s\t%s\t%s\t%s\t%s ","ID","NOMBRE","APELLIDO","ESTATURA","PESO"));
        separador();
    }
}
