# Progetto Giugno 2019
>Burini Lisa: S1081527
>Cappanera Simone: S1081623

## Che cosa fa questo progetto?

Il seguente progetto seguendo le specifiche assegnate dai professori e partendo dal seguente indirizzo fornito tramite mail:
> https://www.dati.gov.it/api/3/action/package_show?id=e706b4f6-b6ee-42eb-a90c-eac4448e8c82

effettua il download del data-set che contiene dati in formato CSV dopo aver effettuato un'opportuna decodifica del JSON che contiene l'URL utile per scaricare il file gestendo anche il caso in cui il file sia già presente. In tal caso infatti il file non verrà riscaricato. 
Fatto ciò, effettua il parsing e la serializzazione dei dati e in aggiunta effettua lo stesse procedure anche per i metadati. 

>Nota bene: Durante il parsing dei dati si è reso necessario usare come delimitatore la virgola racchiusa tra virgolette (guardare il codice). Questo perchè erano presenti nel CSV dati numerici con la virgola al posto del punto e quindi questo portava a un errore quando si andava a fare il parse di quei dati.

L'applicazione Spring si occupa infine di implementare le risposte alle richieste dell'utente ritornando i metadati, i dati e le statistiche con eventuali filtri.

## Istruzioni per l'uso

Una volta scaricato il progetto da GitHub ed averlo aperto con il proprio IDE Java (quello utilizzato per sviluppare il progetto è stato Eclipse) ed essersi assicurato che si abbiano installate tutte le librerie necessarie (in particolare nel nostro caso era stata indispensabile importare la libreria json-simple-1.1.1.jar), l'utente dovrà 
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE0NDUxNjUzMTMsODk5NTkwMTU1LDY0Nj
g3MDc0Miw2NDY4Njg5OTEsNTQyMTI1Mzk2LDUyMjcxNDk2NSwt
MTQzMTMxMjMzMCwtMTg1MTU1NDQ3MCwtMTg1MTU1NDQ3MF19
-->