/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ya.tarea.dao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author Yobany Abrego
 */
public class PersonaMod
{
    private Connection conexion = null;
    
    public PersonaMod()
    {
        conexion = Conexion.getConexion();
        
         String sqlCreateTable = "CREATE TABLE IF NOT EXISTS Persona"
            + " (Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + " Nombre TEXT NOT NULL,"
            + " Apellido TEXT NOT NULL,"
            + " Estatura DECIMAL(10,2),"
            + " Peso DECIMAL(10,2));";
         
        try
        {
            Statement comando = conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        }
        
        catch(Exception ex) 
        {
            System.err.println(ex.getMessage());
        }
    }
    
     public ArrayList<Persona> obtenerPersona () {
        try {
            ArrayList Persona = new ArrayList<Persona>();
            Statement comandoSQL = conexion.createStatement();
            ResultSet regisTab = comandoSQL.executeQuery("SELECT * FROM Persona;");
            while (regisTab.next()) {
                Persona PersonaA = new Persona();
                PersonaA.setId( regisTab.getInt("Id") );
                PersonaA.setNombre( regisTab.getString("Nombre"));
                PersonaA.setApellido(regisTab.getString("Apellido"));
                PersonaA.setEstatura(regisTab.getDouble("Estatura"));
                PersonaA.setPeso(regisTab.getDouble("Peso"));
                
                Persona.add(PersonaA);
            }
            return Persona;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<Persona>();
        }
    }
     
    public int AgregarPersona (Persona Personanew) 
    {
        try {
            String insertSql = "INSERT INTO Persona (Nombre, Apellido, Estatura, Peso) values (?, ?, ?, ?);";
            PreparedStatement comandoSQL = conexion.prepareStatement(insertSql);
            comandoSQL.setString(1, Personanew.getNombre());
            comandoSQL.setString(2, Personanew.getApellido());
            comandoSQL.setDouble(3, Personanew.getEstatura());
            comandoSQL.setDouble(4, Personanew.getPeso());

            
            int Registros  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return Registros;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
        
    }
         
   public int ActualizarPersona(Persona updatePersona)
    {
        try {
            String updateSql = "UPDATE Persona SET Nombre=?, Apellido=?, Estatura=?, Peso=? where Id =?;";
            PreparedStatement comandoSQL = conexion.prepareStatement(updateSql);
            comandoSQL.setString(1, updatePersona.getNombre());
            comandoSQL.setString(2, updatePersona.getApellido());
            comandoSQL.setDouble(3, updatePersona.getEstatura());
            comandoSQL.setDouble(4, updatePersona.getPeso());
            comandoSQL.setInt(5, updatePersona.getId());
            
            int Registro  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return Registro;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
   
     public Persona obtenerPersona (int Id) {
        try {
            PreparedStatement comandoSQL = conexion.prepareStatement("SELECT * FROM Persona where Id = ?;");
            comandoSQL.setInt(1, Id);
            ResultSet regisTab = comandoSQL.executeQuery();
            Persona PersonaA = new Persona();
            while (regisTab.next()) {
                PersonaA.setId(regisTab.getInt("Id") );
                PersonaA.setNombre(regisTab.getString("Nombre"));
                PersonaA.setApellido(regisTab.getString("Apellido"));
                PersonaA.setEstatura(regisTab.getDouble("Estatura"));
                PersonaA.setPeso(regisTab.getDouble("Peso"));
                break;
            }
            return PersonaA;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
     
    public int EliminarPersona (int Id) {
        try {
            String delSql = "DELETE FROM Persona where Id =?;";
            PreparedStatement cmdSQL = conexion.prepareStatement(delSql);
            cmdSQL.setInt(1,Id);
            
            int Registro  = cmdSQL.executeUpdate();
            cmdSQL.close();
            return Registro;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
