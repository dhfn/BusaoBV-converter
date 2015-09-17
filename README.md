# BusaoBV-converter

Aplicação feita para exportar as informações dos ônibus fornecidas em um arquivo XLS previamente formatado para a leitura e posteriormente enviar as informações para o servidor.

Formatação do arquivo XLS.

|----------|--------|----------------|-----------------|------------------------|\n
| [numero] | [nome] |	       	       | 		             |		                    |\n
|----------|--------|----------------|-----------------|------------------------|\n
|			       	                        dias                                      |\n
|-------------------|----------------|-----------------|------------------------|\n
|       uteis       |     sabado     |     domingo     |		                    |\n
|-------------------|----------------|-----------------|------------------------|\n
|   S.B.  |   S.C.  |  S.B.  |  S.C. |  S.B.  |  S.C.  | Itinerários	          |\n
|---------|---------|--------|-------|--------|--------|------------------------|\n
| [hora]  |  [hora] | [hora] |[hora] | [hora] | [hora] |        [rua]           |\n
| [...]   |  [...]  | [...]  | [...] |  [...] | [...]  |        [...]           |\n
|---------|---------|--------|-------|--------|--------|------------------------|\n

O arquivo XLS, deve estar com essa formatação, contando da célula A1.
As informações destacadas com "[" "]" (colchetes) devem ser substituidas pelos dados pertinentes.
As células sem colchetes podem ficar em branco, só servem para identificação na visualização.
