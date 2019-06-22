# Progetto Giugno 2019
>Burini Lisa: S1081527 <br>
>Cappanera Simone: S1081623

## Che cosa fa questo progetto?

Il seguente progetto seguendo le specifiche assegnate dai professori e partendo dal seguente indirizzo fornito tramite mail:
> https://www.dati.gov.it/api/3/action/package_show?id=e706b4f6-b6ee-42eb-a90c-eac4448e8c82

effettua il download del data-set che contiene dati in formato CSV dopo aver effettuato un'opportuna decodifica del JSON che contiene l'URL utile per scaricare il file gestendo anche il caso in cui il file sia già presente. In tal caso infatti il file non verrà riscaricato. 
Fatto ciò, effettua il parsing e la serializzazione dei dati e in aggiunta effettua lo stesse procedure anche per i metadati. 

>Nota bene: Durante il parsing dei dati si è reso necessario usare come delimitatore la virgola racchiusa tra virgolette (guardare il codice). Questo perchè erano presenti nel CSV dati numerici con la virgola al posto del punto e quindi questo portava a un errore quando si andava a fare il parse di quei dati.

L'applicazione Spring si occupa infine di implementare le risposte alle richieste dell'utente restituendo i metadati, i dati e le statistiche con eventuali filtri applicati.

## Istruzioni per l'uso

Una volta scaricato il progetto da GitHub ed averlo aperto con il proprio IDE Java (quello utilizzato per sviluppare il progetto è stato Eclipse) ed essersi assicurato che si abbiano installate tutte le librerie necessarie (in particolare nel nostro caso era stata indispensabile importare la libreria json-simple-1.1.1.jar), l'utente dovrà far partire l'applicazione come Spring Boot App e aprire il proprio Browser Web o un programma come Postman, che permette di testare le varie funzionalità API REST. Le richieste verranno scritte come URL con la seguente sintassi:

> http://localhost:8080/"tipologiaRichiesta"

All'interno della query string, la stringa *tipologiaRichiesta* indica il tipo di informazione che si vuole richiedere scegliendo tra queste tre possibilità:

 - **metadata** : Restituisce i metadati in formato JSON relativi agli attributi;
 - **data** : Restituisce i dati in formato JSON che sono contenuti all'interno del data-set;
 - **statistics** : Restistuisce le statistiche in formato JSON relative a un determinato attributo specificato;

Per ricevere i dati o le statistiche relative ad un attributo bisognerà richiederlo con la seguente sintassi:

> http://localhost:8080/"tipologiaRichiesta"?attribute="nomeAttributo"

dove nomeAttributo è appunto il nome dell'attributo richiesto.
Facciamo due piccoli esempi:

> http://localhost:8080/statistics?attribute=comune <br>
> http://localhost:8080/data?attribute=codiceIstat

Come già accennato, per i dati e le statistiche è possibile applicare dei particolari filtri che restituiranno i dati filtrati secondo le eventuali richieste. I tipi di filtri (3 di tipo logico e 3 di tipo condizionale) sono elencati di seguito:

 - **$eq** : questo filtro permette di selezionare tutti gli oggetti con valore dell' attributo specificato uguale a quello richiesto;
 - **$not** : questo filtro permette di selezionare tutti gli oggetti con valore dell'attributo specificato diverso da quello richiesto;
 - **$or** : questo filtro permette di selezionare tutti gli oggetti che hanno un valore uguale ad almeno uno dei due valori dell'attributo specificato;
 - **$gt** : questo filtro permette di selezionare tutti gli oggetti con valore dell'attributo numerico specificato strettamente maggiore di quello richiesto;
 - **$lt** : questo filtro permette di selezionare tutti 

<!--stackedit_data:
eyJoaXN0b3J5IjpbNzY4MzE2NDQ3LC0xMTI1ODYzMTM0LDg5OT
U5MDE1NSw2NDY4NzA3NDIsNjQ2ODY4OTkxLDU0MjEyNTM5Niw1
MjI3MTQ5NjUsLTE0MzEzMTIzMzAsLTE4NTE1NTQ0NzAsLTE4NT
E1NTQ0NzBdfQ==
-->