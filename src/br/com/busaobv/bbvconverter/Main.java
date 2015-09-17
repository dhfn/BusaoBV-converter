package br.com.busaobv.bbvconverter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        /*
        * Endereço do arquivo no disco.
        * */
        String filePath = "C:\\Users\\Diego\\Documents\\BusaoBV\\horarios";
        String fileName = "horarios_formatados_old.xls";

        /*
        * Instanceando o arquivo para leitura.
        * */
        FileInputStream fileIS = new FileInputStream(new File(filePath+"\\"+fileName));
        POIFSFileSystem fs = new POIFSFileSystem(fileIS);

        /*
        * Transforma o arquivo em um documento, compatível com a bibiblioteca.
        * */
        HSSFWorkbook workbook = new HSSFWorkbook(fs);

        List<Linha> linhas = main.getLinhasFromWorkbook(workbook);

        main.imprimeLinhas(linhas);
        //main.listaRuas(workbook);
    }


    public List<Linha> getLinhasFromWorkbook(HSSFWorkbook workbook){
        List<Linha> linhas = new ArrayList<>();
        Main main = new Main();
        //  pega a quantidade de planilhas no documento.
        int qtdSheets = workbook.getNumberOfSheets();

        /*
        * 'for' que vai percorrer todas as planilhas do documento
        * */
        for(int i = 0; i < qtdSheets-1; i++){
            // Um objeto linha é instanceado a cada iteração para que seja adicionado a lista de linhas
            Linha linha = new Linha();

            // Instancia a planilha que será lida na iteração.
            HSSFSheet sheet = workbook.getSheetAt(i);

            // obtem a quantidade  de linhas que tem na planilha.
            int qtdRows = sheet.getPhysicalNumberOfRows();

            /*
            * Preenche os campos de nome e número do objeto linha.
            * */
            HSSFRow rowInfo = sheet.getRow(0);
            HSSFCell cellNumero = rowInfo.getCell(0);
            HSSFCell cellNome = rowInfo.getCell(1);
            linha.setNome(cellNome.getStringCellValue());
            linha.setNumero((int) cellNumero.getNumericCellValue());

            /*
            * Percorre todas as linhas a partir da primeira linha com informações que precisam ser lidas no
            * documento.
            * */
            for (int j = 4; j < qtdRows; j++){
                HSSFRow row = sheet.getRow(j);

                /*
                * A partir daqui, o programa lê linha por linha e adciona cada informação em suas listas de acordo com
                * o número de sua coluna.
                * As colunas no excel são representadas por letras, mas no programa, por número de 0 a 'n'.
                * Por exemplo, a coluna A, primeira coluna, na qual contém as informações do Horario de saida do bairro nos dias uteis
                * é representado aqui pelo numero 0 (zero).
                * */

                // Horários de saída do BAIRRO nos DIAS ÚTEIS.
                try {
                    Cell cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getHorariosSaidaBairroUtil().add(main.getHHMMFormat(cell.getNumericCellValue()));

                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Horários de saída do CENTRO nos DIAS ÚTEIS.
                try {
                    Cell cell = row.getCell(1, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getHorariosSaidaCentroUtil().add(main.getHHMMFormat(cell.getNumericCellValue()));
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Horários de saída do BAIRRO nos SABADOS.
                try {
                    Cell cell = row.getCell(2, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getHorariosSaidaBairroSabado().add(main.getHHMMFormat(cell.getNumericCellValue()));
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Horários de saída do CENTRO nos SABADOS.
                try {
                    Cell cell = row.getCell(3, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getHorariosSaidaCentroSabado().add(main.getHHMMFormat(cell.getNumericCellValue()));
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Horários de saída do BAIRRO nos DOMINGOS.
                try {
                    Cell cell = row.getCell(4, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getHorariosSaidaBairroDomingo().add(main.getHHMMFormat(cell.getNumericCellValue()));
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Horários de saída do BAIRRO nos DOMINGOS.
                try {
                    Cell cell = row.getCell(5, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getHorariosSaidaCentroDomingo().add(main.getHHMMFormat(cell.getNumericCellValue()));
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Itinerário de saída do BAIRRO.
                try {
                    Cell cell = row.getCell(6, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getItinerarioSaidaBairro().add(cell.getStringCellValue());
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }

                // Itinerário de saída do CENTRO.
                try {
                    Cell cell = row.getCell(7, Row.CREATE_NULL_AS_BLANK);

                    if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                        linha.getItinerarioSaidaCentro().add(cell.getStringCellValue());
                    }
                }catch (NullPointerException e){
                    System.out.println("Erro: "+ e.toString());
                }
            }

            /*
            * Aqui o objeto totalmente populado com as informações lidas da planilha é adicionado a lista.
            **/
            linhas.add(linha);
        }

        return linhas;
    }


    public void imprimeLinhas(List<Linha> linhas){
        for (Linha linha : linhas){

            int qtdRows = linha.getTamanhoLimite();
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println(String.format("|  %3d - %s ", linha.getNumero(), linha.getNome()));
            System.out.println("|-------|-------|-------|-------|-------|-------|------------------------------------------|------------------------------------------|");
            System.out.println("| SBDiU | SCDiU | SBSab | SCSab | SBDom | SCDom |                   ISC                    |                    ISB                   |");
            System.out.println("|-------|-------|-------|-------|-------|-------|------------------------------------------|------------------------------------------|");
            for(int j = 4; j < qtdRows; j++){
                int k = j-4;

                if (k < linha.getHorariosSaidaBairroUtil().size()) {
                    System.out.print("| "+linha.getHorariosSaidaBairroUtil().get(k));
                }else {
                    System.out.print("|      ");
                }
                if (k < linha.getHorariosSaidaCentroUtil().size()){
                    System.out.print(" | " + linha.getHorariosSaidaCentroUtil().get(k));
                }else{
                    System.out.print(" |      ");
                }

                if (k < linha.getHorariosSaidaBairroSabado().size()){
                    System.out.print(" | " + linha.getHorariosSaidaBairroSabado().get(k));
                }else{
                    System.out.print(" |      ");
                }

                if (k < linha.getHorariosSaidaCentroSabado().size()){
                    System.out.print(" | " + linha.getHorariosSaidaCentroSabado().get(k));
                }else{
                    System.out.print(" |      ");
                }

                if (k < linha.getHorariosSaidaBairroDomingo().size()){
                    System.out.print(" | " + linha.getHorariosSaidaBairroDomingo().get(k));
                }else{
                    System.out.print(" |      ");
                }

                if (k < linha.getHorariosSaidaCentroDomingo().size()){
                    System.out.print(" | " + linha.getHorariosSaidaCentroDomingo().get(k));
                }else{
                    System.out.print(" |      ");
                }

                if (k < linha.getItinerarioSaidaBairro().size()){
                    System.out.print(String.format(" | %40s", linha.getItinerarioSaidaBairro().get(k)));
                }else{
                    System.out.print(" |                                         ");
                }

                if (k < linha.getItinerarioSaidaCentro().size()){
                    System.out.println(String.format(" | %40s |", linha.getItinerarioSaidaCentro().get(k)));
                }else{
                    System.out.println(" |                                          |");
                }


            }
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println();
        }
    }


    public String getHHMMFormat(double value){
        double time = value * 24;
        int hours = (int) time;
        double auxMin = (time - hours) * 60;
        Long minutes = Math.round(auxMin);


        return String.format("%02d:%02d", hours, minutes);
    }

    public List<String> listaRuas(HSSFWorkbook workbook){
        List<String> ruas = new ArrayList<>();
        int qtdSheet = workbook.getNumberOfSheets();
        HSSFSheet sheet = workbook.getSheetAt(qtdSheet - 1);
        int qtdRows = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < qtdRows; i++) {
            HSSFRow row = sheet.getRow(i);
            Cell cell = null;

            try {
                cell = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
            }catch (NullPointerException e){
                System.out.println("Erro: "+ e.toString());
            }

            boolean verifica = true;
            for (String rua : ruas){
                if (rua.contains(cell.getStringCellValue())){
                    verifica = false;
                    System.out.println("Não add: "+rua+" - "+cell.getStringCellValue());
                }
            }

            if (verifica){
                ruas.add(cell.getStringCellValue());
                System.out.println("Add: "+cell.getStringCellValue());
            }
        }


        return ruas;
    }


}
