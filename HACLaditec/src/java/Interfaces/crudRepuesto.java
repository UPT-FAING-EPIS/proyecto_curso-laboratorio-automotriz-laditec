/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Repuesto;
import java.util.List;


public interface crudRepuesto {
    public List listar();
    public Repuesto list(int id);
    public boolean add(Repuesto rep);
    public boolean edit(Repuesto rep);
}
