package br.com.busaobv.bbvconverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 03/08/2015.
 */
public class Linha {
    private int numero;
    private String nome;
    private List<String> horariosSaidaBairroUtil;
    private List<String> horariosSaidaCentroUtil;
    private List<String> horariosSaidaBairroSabado;
    private List<String> horariosSaidaCentroSabado;
    private List<String> horarioSaidaBairroDomingo;
    private List<String> horariosSaidaCentroDomingo;
    private List<String> itinerarioSaidaBairro;
    private List<String> itinerarioSaidaCentro;
    private String obs;

    public Linha(){
        horariosSaidaBairroUtil = new ArrayList<>();
        horariosSaidaCentroUtil = new ArrayList<>();
        horariosSaidaBairroSabado = new ArrayList<>();
        horariosSaidaCentroSabado = new ArrayList<>();
        horarioSaidaBairroDomingo = new ArrayList<>();
        horariosSaidaCentroDomingo = new ArrayList<>();
        itinerarioSaidaBairro = new ArrayList<>();
        itinerarioSaidaCentro = new ArrayList<>();

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getHorariosSaidaBairroUtil() {
        return horariosSaidaBairroUtil;
    }

    public void setHorariosSaidaBairroUtil(List<String> horarioSaidaBairroUtil) {
        this.horariosSaidaBairroUtil = horarioSaidaBairroUtil;
    }

    public List<String> getHorariosSaidaCentroUtil() {
        return horariosSaidaCentroUtil;
    }

    public void setHorariosSaidaCentroUtil(List<String> horariosSaidaCentroUtil) {
        this.horariosSaidaCentroUtil = horariosSaidaCentroUtil;
    }

    public List<String> getHorariosSaidaBairroSabado() {
        return horariosSaidaBairroSabado;
    }

    public void setHorariosSaidaBairroSabado(List<String> horarioSaidaBairroSabado) {
        this.horariosSaidaBairroSabado = horarioSaidaBairroSabado;
    }

    public List<String> getHorariosSaidaCentroSabado() {
        return horariosSaidaCentroSabado;
    }

    public void setHorariosSaidaCentroSabado(List<String> horariosSaidaCentroSabado) {
        this.horariosSaidaCentroSabado = horariosSaidaCentroSabado;
    }

    public List<String> getHorariosSaidaBairroDomingo() {
        return horarioSaidaBairroDomingo;
    }

    public void setHorariosSaidaBairroDomingo(List<String> horarioSaidaBairroDomingo) {
        this.horarioSaidaBairroDomingo = horarioSaidaBairroDomingo;
    }

    public List<String> getHorariosSaidaCentroDomingo() {
        return horariosSaidaCentroDomingo;
    }

    public void setHorariosSaidaCentroDomingo(List<String> horariosSaidaCentroDomingo) {
        this.horariosSaidaCentroDomingo = horariosSaidaCentroDomingo;
    }

    public List<String> getItinerarioSaidaBairro() {
        return itinerarioSaidaBairro;
    }

    public void setItinerarioSaidaBairro(List<String> itinerarioSaidaBairro) {
        this.itinerarioSaidaBairro = itinerarioSaidaBairro;
    }

    public List<String> getItinerarioSaidaCentro() {
        return itinerarioSaidaCentro;
    }

    public void setItinerarioSaidaCentro(List<String> itinerarioSaidaCentro) {
        this.itinerarioSaidaCentro = itinerarioSaidaCentro;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getTamanhoLimite(){
        int maior = 0;
        int tamanhos[] = {this.horariosSaidaBairroUtil.size(), this.horariosSaidaCentroUtil.size(),
                          this.horariosSaidaBairroSabado.size(), this.horariosSaidaCentroSabado.size(),
                          this.horarioSaidaBairroDomingo.size(), this.horariosSaidaCentroDomingo.size(),
                          this.itinerarioSaidaBairro.size(), this.itinerarioSaidaCentro.size()};

        for (int i = 0; i < tamanhos.length; i++){
            if (tamanhos[i] > maior){
                maior = tamanhos[i];
            }
        }
        return maior;
    }
}