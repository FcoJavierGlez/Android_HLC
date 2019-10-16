package com.example.proyecto1_marcadorbaloncesto;

import java.util.ArrayList;

/**
 * La clase marcador es una clase diseñada para gestionar el marcador de un partido de baloncesto.
 *
 * @author Francisco Javier González Sabariego
 * @since 15/10/2019
 */
public class Marcador {
    private static int puntosLocal=0;                               //Total de puntos acumulador por el equipo local
    private static int puntosVisitante=0;                           //Total de puntos acumulador por el equipo visitante
    private static ArrayList<String>acciones=new ArrayList<String>();    //Puntos acumulados por canastas


    /**
     * Suma puntos al marcador del equipo seleccionado (local, visitante).
     *
     * @param equipo Equipo seleccionado
     * @param puntos Total de puntos a sumar
     */
    public static void setPuntos(String equipo,int puntos) {
        if ((equipo.toLowerCase().equals("local")))
            setPuntosLocal(puntos);
        else
            setPuntosVisitante(puntos);
    }

    /**
     * Suma puntos en el marcador del equipo local.
     *
     * @param puntos Total de puntos a sumar
     */
    private static void setPuntosLocal(int puntos) {
        if(puntosLocal+puntos>999) {
            setAccion("l"+Integer.toString(puntosLocal-puntos));
            puntosLocal=999;
        } else {
            setAccion("l"+Integer.toString(puntos));
            puntosLocal+=puntos;
        }
    }

    /**
     * Suma puntos en el marcador del equipo visitante
     *
     * @param puntos Total de puntos a sumar
     */
    private static void setPuntosVisitante(int puntos) {
        if(puntosVisitante+puntos>999) {
            setAccion("v"+Integer.toString(puntosVisitante-puntos));
            puntosVisitante=999;
        } else {
            setAccion("v"+Integer.toString(puntos));
            puntosVisitante+=puntos;
        }
    }

    /**
     * Incremente el marcador del equipo seleccionado (local, visitante) en un punto
     *
     * @param equipo El equipo seleccionado (local, visitante)
     */
    public static void incrementaMarcador(String equipo) {
        if ((equipo.toLowerCase().equals("local")))
            incrementaLocal();
        else
            incrementaVisitante();
    }

    /**
     * Incrementa el marcador del equipo local en un punto
     */
    private static void incrementaLocal() {
        puntosLocal+=(puntosLocal==999) ? 0 : 1;
    }

    /**
     * Incremente el marcador del equipo visitante en un punto
     */
    private static void incrementaVisitante() {
        puntosVisitante+=(puntosVisitante==999) ? 0 : 1;
    }

    /**
     * Decrementa el marcador del equipo elegido (local,visitante) en un punto
     *
     * @param equipo El equipo seleccionado (local, visitante)
     */
    public static void decrementaMarcador(String equipo) {
        if ((equipo.toLowerCase().equals("local")))
            decrementaLocal();
        else
            decrementaVisitante();
    }

    /**
     * Decrementa el marcador del equipo local en un punto
     */
    private static void decrementaLocal() {
        puntosLocal-=(puntosLocal==0) ? 0 : 1;
    }

    /**
     * Decrementa el marcador del equipo visitante en un punto
     */
    private static void decrementaVisitante() {
        puntosVisitante-=(puntosVisitante==0) ? 0 : 1;
    }

    /**
     * Devuelve el valor actual del marcador del equipo local ajustado al formato de tres dígitos "000"
     *
     * @return  (String) Valor del marcador del equipo local
     */
    public static String getMarcadorLocal() {
        return ajustaDisplay(puntosLocal);
    }

    /**
     * Devuelve el valor actual del marcador del equipo visitante ajustado al formato de tres dígitos "000"
     *
     * @return  (String) Valor del marcador del equipo visitante
     */
    public static String getMarcadorVisitante() {
        return ajustaDisplay(puntosVisitante);
    }

    /**
     * Añade al arrayList de acciones la última anotación realizada (puntuación por canasta) con el formato
     * de la primera letra del equipo ("l" de local, "v" de visitante) y el valor de la anotación, tendría el
     * siguiente formato: l1, l2, l3 ó v1, v2, v3.
     *
     * @param accion (String) Última anotación registrada con la primera letra del equipo (local, visitante) y el punto ingresado.
     */
    public static void setAccion(String accion) {
        acciones.add(accion);
    }

    /**
     * Elimina la última posición del arraylist de acciones.
     */
    private static void borrarAccion() {
        acciones.remove(acciones.size()-1);
    }

    /**
     * Revierte los cambios del marcador de la última anotación registrada en el arrayList de acciones.
     */
    public static void deshacer() {
        if (acciones.size()==0)
            return;
        if ((acciones.get(acciones.size() - 1).substring(0, 1).equals("l")))
            puntosLocal-=(puntosLocal-Integer.parseInt(acciones.get(acciones.size() - 1).substring(1, 2))<0) ? puntosLocal : Integer.parseInt(acciones.get(acciones.size() - 1).substring(1, 2));
        else
            puntosVisitante-=(puntosVisitante-Integer.parseInt(acciones.get(acciones.size() - 1).substring(1, 2))<0) ? puntosVisitante : Integer.parseInt(acciones.get(acciones.size() - 1).substring(1, 2));
        borrarAccion();
    }

    /**
     * Resetea el marcador para iniciar un nuevo partido. Pone a cero los puntos de ambos equipo y
     * borra todas las anotaciones guardadas en el arrayList de acciones
     */
    public static  void reset() {
        resetearPuntos();
        acciones.clear();
    }

    /**
     * Pone a cero los puntos de ambos equipos.
     */
    private static void resetearPuntos() {
        puntosLocal=0;
        puntosVisitante=0;
    }

    /**
     * Ajusta el display del marcador de forma que siempre muestre un formato de tres dígitos "000".
     *
     * @param puntos Puntos del marcador cuyo display se quiere ajustar.
     * @return (String) El valor en formato '000' del display
     */
    private static String ajustaDisplay(int puntos) {
        return (puntos<10) ? "00"+Integer.toString(puntos) : (puntos<100) ? "0"+Integer.toString(puntos) : Integer.toString(puntos);
    }
}
