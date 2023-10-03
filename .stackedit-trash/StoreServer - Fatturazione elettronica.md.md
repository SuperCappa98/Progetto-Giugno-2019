
# StoreServer - Fatturazione elettronica
#### Manuale d'uso e attivazione

Il presente documento descrive i requisiti minimi, le configurazioni e le procedure necessarie all'attivazione ed utilizzo del modulo di fatturazione elettronica semplificata.
 
##### Data di creazione del documento: 18/07/2023
##### Ultima revisione documento: 28/07/2023
---
## Glossario
- **WebApp:** applicazione web che offre la possibilità di gestire in modo centralizzato le funzionalità disponibili nel StoreServer;
- **PoswareModule:** plug-in del StoreServer dedicato alla gestione del PPC;
- **SdI:** si tratta del Sistema di Interscambio. Gestito dall'Agenzia delle Entrate, è un sistema informatico in grado di ricevere e inoltrare le fatture ed effettuare controlli sui file ricevuti;
- **Cedente:** l'azienda che genera ed emette la fattura, anche chiamato a volte **Fornitore**;
- **Fornitore:** si intende sempre il **Cedente**, i termini sono intercambiabili ed usati entrambi nel documento per riferirsi alla stessa cosa;
- **Cessionario:** l'entità che riceve la fattura e che quindi di fatto effettua l'acquisto;
- **PA:** Pubblica Amministrazione;
- **AdE:** Agenzia delle Entrate; 

## Cenni preliminari
A far data del **18/07/2023**, il presente plug-in offre all'utente la possibilità di:
- **emettere fatture elettroniche** a partire dai documenti commerciali -vendite fiscali - e dalle vendite non fiscali emesse sotto forma di documenti gestionali;
- **stornare** le fatture emesse creando delle note di credito;
- **visualizzare** e **ricercare** le fatture e le note di credito emesse;
- **gestire** le anagrafiche di fatturazione - dati del cliente -;
- **personalizzare** le informazioni riguardanti il cedente.
  
Le funzioni descritte si trovano nella sezione ***Fattura elettronica*** della WebApp del **Posware StoreServer**.

### Versioni software
La versione minima dello **StoreServer** richiesta è la v. `1.0`.
La versione minima del **PoswareModule** richiesta è la v. `1.0`.

## Installazione
Il plug-in è incluso **out-of-the-box** nello *StoreServer*, non necessita di alcuna installazione aggiuntiva e all'avvio sarà automaticamente rilevato e caricato.

## Funzionalità

### Come accedere al modulo
All'apertura della WebApp verrà mostrata la schermata principale.
È possibile accedere alle varie schermate tramite la sidebar di sinistra: nella sezione *Moduli*, troveremo la voce *Fattura elettronica*.

Cliccando su questa si aprirà il menù sottostante. 
Appaiono le voci: 
 - *Dashboard*
 - *Clienti*
 - *Impostazioni*

![Sidebar - dashboard](http://localhost:8080/sidebar%20-%20dashboard.png)
### Dashboard
Questa schermata per l'utente rappresenta uno sguardo veloce e d'insieme a tutto ciò che serve per poter gestire in maniera semplificata la fatturazione elettronica.  È stata concepita in modo tale che sia:
- semplice: fornisce in breve i dettagli più importanti, come le fatture più recenti emesse;
- veloce: si hanno a portata di click tutte le principali funzioni, come quella per generare una fattura o quella per creare un nuovo cliente in anagrafica.

In generale avrà quest'aspetto:
![Dashboard](http://localhost:8080/dashboard.png "Dashboard")
Qui troviamo tutti gli widget che ci permetteranno la completa gestione della fatturazione elettronica.
In questa schermata si avranno le funzionalità per:
- Generazione fatture elettroniche;
- Gestione clienti di fatturazione;
- Consultazione dei documenti recenti emessi;
- Rigenerazione dei documenti emessi;
- Storno delle fatture (generazione delle note di credito).


#### Controllo integrato delle informazioni del cedente
Accedendo alla *Dashboard*, verrà effettuato un controllo delle informazioni del fornitore (cedente) memorizzate nel database. 

> Tale controllo viene effettuato ad **ogni accesso** per garantire la
> conformità del dato che verrà usato per generare le fatture
> elettroniche e ridurre eventuali rifiuti da parte dell'*AdE/Sdi*

In presenza di errori o difformità del dato presente, si verrà dirottati sulla schermata di editing dei dati fornitore (cedente).

Un avviso in alto indicherà che sono stati riscontrati errori:
![Supplier editor - alert](http://localhost:8080/supplier%20editor%20-%20alert.png)

Per poter utilizzare correttamente il modulo ed emettere delle fatture **è obbligatorio** impostare dei dati corretti in questa schermata.
Fino a che i dati non risulteranno corretti, il software continuerà a dirottarvi su questa schermata.

Per ulteriori approfondimenti consultare la sezione dedicata [`Personalizzare i dati del cedente`](#personalizzare-i-dati-del-cedente).

### Impostazioni
La schermata delle impostazioni permette di modificare le configurazioni per la funzionalità della fatturazione elettronica.

![Sidebar - impostazioni](http://localhost:8080/sidebar%20-%20impostazioni.png)
Selezionando `Impostazioni` avremo accesso alla seguente schermata:
![Impostazioni](http://localhost:8080/impostazioni.png)


### Gestione clienti di fatturazione

    //todo inserire la gestione dei clienti


### Generazione fatture elettroniche
Una fattura elettronica può essere generata a partire da un documento commerciale - fiscale - e da vendite non fiscali emesse sotto forma di documenti gestionali da stampante RT.
In questa funzionalità la generazione di una fattura elettronica è stata resa in maniera semplificata.

#### Workflow
Per accedere alla schermata di generazione di una fattura dobbiamo porre la nostra attenziona al widget *`Task veloci`* nella *`Dashboard`*. 
![Task veloci](http://localhost:8080/task%20veloci.png "Task veloci")
Cliccando sul primo (`Nuova fattura`) verremo reindirizzati ad una nuova schermata contenente lo wizard dedicato alla creazione di una nuova fattura.
Qui verrà effettuata nuovamente la validazione del cedente. Qualora risultasse non congruo per la generazione di una fattura elettronica verremo reindirizzati alla pagina di editing del cedente (crf.[`Personalizzare i dati del cedente`](#personalizzare-i-dati-del-cedente)). Nel caso in cui invece non risultasse nessun errore tra i dati validati, ci verrà dato accesso allo step numero 1 dello wizard.

##### Step 1 - Ricerca transazione/scontrino

Il primo step è indicare la transazione da fatturare attraverso i suoi estremi.

![Generazione fattura - Step 1](http://localhost:8080/generazione%20fattura%20-%20step%201.png "Generazione fattura")

È possibile ricercare la transazione in due modi:
- **via barcode**: sarà necessario scansionare o digitare il barcode associato allo scontrino;
- **inserendo i dati manualmente**: sarà necessario inserire gli estremi della transazione, quali:
	- data;
	- numero del terminale\cassa;
	- numero della transazione; [^1]
	- numero dello scontrino; [^1]

[^1] I campi numero transazione e numero scontrino sono pensati per essere indicati come alternativa l'uno dell'altro. Qualora si possedessero entrambi, è consigliabile inserire solo *numero transazione* per evitare di incorrere in errori di coerenza tra i due dati se imputati erroneamente.

> I metodi di ricerca tra loro sono mutuamente esclusivi. Selezionandone uno si esclude automaticamente l'altro

![Generazione fattura - Step 1 - Via barcode](http://localhost:8080/generazione%20fattura%20-%20step%201%20-%20via%20barcode.png "Via barcode")
![Generazione fattura - Step 1 - Via estremi transazione](http://localhost:8080/generazione%20fattura%20-%20step%201%20-%20via%20estremi%20transazione.png "Via estremi transazione")

Dopo l'inserimento dei dati per trovare la transazione, premere su `Continua` per procedere allo *Step 2*. 

> Nel caso in cui la transazione non venisse trovata, verrà mostrato il seguente messaggio di errore:
>
>![Messaggio di errore transazione non trovata](http://localhost:8080/generazione%20fattura%20-%20step%201%20-%20modal%20di%20errore.png "Transazione non trovata")

##### Step 2 - Seleziona la tipologia del cliente a cui fatturare
In questa schermata saranno presenti 3 pulsanti:
1. Partita IVA;
2. Pubblica amministrazione;
3. Privato / No-Profit;

![Step 2](http://localhost:8080/generazione%20fattura%20-%20step%202.png "Step 2")
La scelta di una delle 3 opzioni presentate in questo step influenzeranno la selezione del cliente nello step successivo. 
> - Selezionando il primo pulsante il cliente verrà ricercato solamente tra quelli in possesso di una partita IVA che non siano PA.
> - Selezionando il secondo verrà cercato tra le PA.
> - Scegliendo il terzo la ricerca verrà effettuata tra i clienti che non hanno partita IVA di cui è registrato solo il codice fiscale.

Dopo aver scelto, premendo `Continua`, andremo direttamente allo step successivo. 

##### Step 3 - Selezione cliente
Qui è possibile scrivere nella barra di ricerca. In base a ciò che verrà scritto, la ricerca verrà fatta sulla denominazione del cliente, sul codice della card fidelity, sulla partita IVA o sul codice fiscale.
![Step 3](http://localhost:8080/generazione%20fattura%20-%20step%203.png "Step 3")
Dopo aver scritto nella barra, premendo `Cerca` o `Invio`, verranno ricercati i clienti nell'anagrafica. Se ne trovasse, sotto alla barra comparirebbe una tabella contenente delle brevi descrizioni dei clienti trovati. 
![Tabella clienti trovati](http://localhost:8080/generazione%20fattura%20-%20step%203%20-%20tabella%20clienti.png "Tabella clienti trovati")
A questo punto sarà necessario selezionare uno dei clienti nella tabella prima di poter cliccare su `Continua`.

##### Step 4 - Dettagli fattura
In questo step sarà possibile scegliere se l'esegibilità dell'IVA della fattura sarà differita o immediata o se il versamento dell'imposta potrà avvenire tramite la scissione dei pagamenti (Split Payment). 
In tutti i casi d'uso l'esigibilità dell'IVA è sempre di default **IMMEDIATA** (nessuna opzione selezionata).
Per la spiegazione si rimanda alla [sezione dedicata](#impostazione-dellesegibilità-delliva).
![Step 4 - Generazione fattura verso privati](http://localhost:8080/generazione%20fattura%20-%20step%204%20%20-%20verso%20privati.png)
Se il cliente selezionato precedentemente fosse una Pubblica Amministrazione, in questa schermata sarebbero visibili anche dei campi che danno la possibilità all'utente di inserire i dati che riguardano l'ordine d'acquisto e il contratto come ID, codice CIG e codice CUP.
È **obbligatorio** inserire almeno uno tra ordine d'acquisto e contratto.
![Step 4 - Generazione fattura verso PA](http://localhost:8080/generazione%20fattura%20-%20step%204%20%20-%20verso%20PA.png)

##### Step 5 - Finalizzazione
A questo punto l'ultima cosa che si richiede all'utente è quella di selezionare la data di operazione della fattura.
![Step 5](http://localhost:8080/generazione%20fattura%20-%20step%205.png)
La data di operazione non potrà essere inferiore alla data dell'ultima fattura generata e qualora non ce ne fossero non può essere inferiore all'1 gennaio dell'anno corrente.
La data di operazione non può essere superiore alla data attuale.
Se non selezionata è impostata di default la data attuale.

A questo punto sarà possibile cliccare sul pulsante `Genera fattura`.
Se alla fine della generazione della fattura ci fossero degli errori verrebbe mostrata una modal simile a questa:
![Errori di validazione della fattura generata](http://localhost:8080/generazione%20fattura%20-%20step%205%20-%20modal%20di%20errore%20-%20validazione.png)
Gli errori in questione sono tutti quei errori che contravvengono le regole sintattiche e di forma descritte nella [sezione](#descrizione-del-file-xml-della-fattura-elettronica) che approfondisce la struttura del file XML di una fattura.
##### Step 6 - Completato
Se la creazione della fattura va a buon fine verranno riepilogati i dati del documento appena generato in questa schermata.
![Step 6](http://localhost:8080/generazione%20fattura%20-%20step%206.png)
A questo punto è possibile cliccare su `Nuova fattura` per poter tornare allo step 1 e ricominciare la creazione dal principio.

### Consultazione dei documenti recenti emessi
I documenti che sono stati generati di recente possono essere consultati nel widget all'interno della `Dashboard`.
![Widget consultazione fatture](http://localhost:8080/widget%20consultazione%20fatture.png)

Vengono visualizzati, se presenti, gli ultimi 10 documenti che sono stati creati.

Di ognuno vengono indicati in breve:
- il **tipo**;
- il **numero**;
- la **data di operazione**;
- il **cliente committente**;
- la **partita IVA** del committente.

Cliccando sul numero di riferimento della fattura si aprirà una modal con tutte le info in dettaglio riguardanti il documento selezionato.
![Modal di dettaglio](http://localhost:8080/widget%20consultazione%20fatture%20-%20modal%20di%20dettaglio.png)

In assenza di documenti emessi di recente, viene mostrato il messaggio "*Non sono presenti documenti da visualizzare*".
![Widget vuoto](http://localhost:8080/widget%20consultazione%20fatture%20-%20widget%20vuoto.png)

Oltre la consultazione è possibile effettuare delle ricerche per visualizzare documenti specifici. 

Cliccando sul pulsante `Ricerca` in alto a destra verrà aperta una modal dedicata:

![Modal di ricerca](http://localhost:8080/widget%20consultazione%20fatture%20-%20modal%20di%20ricerca.png)

Selezionando la prima opzione - *Via informazioni del documento* - appariranno due campi:
- *Numero documento*;
- *Data operazione*.

![Via informazioni del documento](http://localhost:8080/widget%20consultazione%20fatture%20-%20modal%20di%20ricerca%20-%20via%20informazioni%20del%20documento.png)

In questo caso possiamo decidere di usare questi due campi singolarmente o insieme.

*Esempi:* 
- *in ***Numero documento*** inserisco il numero "3" e clicco su `Conferma` -> mi verranno mostrate le fatture 3/A, 3/B, 3/FDG e le note di credito 3/A, 3/D, 3/VCF;*
- *in ***Data operazione*** inserisco "23/04/2022" -> mi vengono mostrati tutti i documenti generati in quel giorno;*
- *in ***Numero documento*** inserisco il numero "8" e in ***Data operazione*** inserisco il "27/03/2023" -> mi vengono mostrati tutti i documenti generati in quel giorno con il numero 8 come numero identificativo.*

Selezionando la seconda opzione (*Via estremi della transazione*) invece, sarà possibile cercare i documenti utilizzando gli estremi della transazione a cui i documenti voluti fanno riferimento.
![Via estremi della transazione](http://localhost:8080/widget%20consultazione%20fatture%20-%20modal%20di%20ricerca%20-%20via%20estremi%20della%20transazione.png)

In questo caso i campi presenti vanno riempiti **tutti e tre** per poter effettuare la ricerca.

*Esempio: nel DB sono presenti una fattura generata a partire dalla transazione numero 23 della cassa 2 del 12/05/2023 e la relativa nota di credito. Per ricercarle entrambe inserisco in ***Data transazione*** "12/05/2023", in ***Numero cassa*** inserisco "2" e in ***Numero transazione*** "23".*

Posso decidere di utilizzare anche **tutte e due le opzioni di ricerca insieme**. 

Effettuando la ricerca si noterà che il sottotitolo del widget avrà cambiato la dicitura da "*Vengono visualizzati gli ultimi 10 documenti emessi*" a "*Vengono visualizzati i risultati per la ricerca*" e sarà apparso anche un **tag**. Questo tag conterrà le informazioni sui filtri di ricerca applicati.
 È possibile resettare la ricerca e tornare alla visualizzazione degli ultimi 10 documenti creati più recentemente cliccando sulla `X` contenuta nel tag.
![Filtro di ricerca](http://localhost:8080/widget%20consultazione%20fatture%20-%20filtro%20di%20ricerca.png)

### Rigenerazione dei documenti emessi
Nel caso che alcune informazioni inserite in una fattura elettronica o in una nota di credito subiscano aggiornamenti o correzioni, oppure nel caso in cui il file XML del documento venga erroneamente cancellato o risulti danneggiato, è possibile rigenerare il documento in questione.
In riferimento al [paragrafo precedente](#consultazione-dei-documenti-recenti-emessi), si sarà notato che a fianco ad ogni documento è presente un pulsante.
Premendolo si aprirà un menu con le voci:
- *Rigenera documento*;
- *Genera nota di credito* (risulterà inattivo se il documento selezionato è una nota di credito).

![Rigenera documento](http://localhost:8080/rigenerazione%20dei%20documenti%20emessi%20-%20men%C3%B9.png)

#### Caso 1 - Nota di credito
Cliccando su *Rigenera documento* dopo aver aperto il menu selezionando una nota di credito la rigenerazione verrà direttamente avviata.
Se avrà successo si aprirà la seguente modal:
![Modal di successo](http://localhost:8080/rigenerazione%20dei%20documenti%20emessi%20-%20modal%20di%20successo%20-%20fattura%20singola.png)
Come possiamo vedere, nel messaggio ci verrà indicato anche il percorso di destinazione del file XML appena rigenerato.

Se invece ci saranno degli errori:
![Modal di errore](http://localhost:8080/rigenerazione%20dei%20documenti%20emessi%20-%20modal%20di%20errore.png)

#### Caso 2 - Fattura
Cliccando su *Rigenera documento*, dopo aver aperto il menu selezionando una fattura, prima di avviare la rigenerazione verra controllato se esistono dei documenti collegati a questa.
Se non esistessero la rigenerazione si avvierà direttamente come nel caso della [nota di credito](#caso-1---nota-di-credito).
Se invece esistessero, apparirà una modal con la seguente richiesta che ci aprirà 3 diverse opzioni:
![Modal di richiesta](http://localhost:8080/rigenerazione%20dei%20documenti%20emessi%20-%20modal%20di%20richesta.png)
1. `Annulla`: chiude la modal e non ha alcun effetto;
2. `No`: avvia la rigenerazione unicamente per la fattura selezionata;
3. `Sì`: avvia la rigenerazione per la fattura selezionata e per tutta le fatture a essa collegate.

Se è stato selezionato `No`, come nel primo caso, se avrà successo si aprirà la modal di successo mostrata precedentemente che ci conferma l'avvenuta rigenerazione del documento.

Se è stato selezionato `Si`, se avrà successo si aprirà la seguente modal che avrà un messaggio differente:
![Modal di successo - fatture collegate](http://localhost:8080/rigenerazione%20dei%20documenti%20emessi%20-%20modal%20di%20successo%20-%20fatture%20collegate.png)
Anche qui nel messaggio ci verrà indicato il percorso di destinazione del file XML appena rigenerato unicamente della fattura selezionata all'inizio.

Se invece ci saranno degli errori si aprirà la modal di errore mostrata precedentemente per la non avvenuta rigenerazione della nota credito.

### Annullamento delle fatture
Potrebbe capitare che per errore o per un determinato motivo si abbia bisogno di annullare la fattura generata. Per farlo è necessario generare una nota di credito a partire dalla fattura stessa.
Questa operazione è possibile eseguirla dal widget per la consultazione dei documenti descritto in precedenza.

Nel menù che si apre cliccando il pulsante a destra di ogni documento è presente (attiva solo per le fatture) la voce *Genera nota di credito*.
![Pulsante genera nota di credito](http://localhost:8080/annullamento%20delle%20fatture%20-%20men%C3%B9.png)

Cliccando su questo pulsante si aprirà la seguente modal:
![Modal di conferma](http://localhost:8080/annullamento%20delle%20fatture%20-%20modal%20di%20conferma.png)
Qui avremo 2 possibilità:
- `Annulla`: chiude la modal e non ha alcun effetto;
- `Conferma`: avvia la generazione della nota di credito. 

Se avrà successo si aprirà la seguente modal:
![Modal di successo](http://localhost:8080/annullamento%20delle%20fatture%20-%20modal%20di%20successo.png)
Come possiamo vedere, nel messaggio ci verrà indicato anche il percorso di destinazione del file XML appena generato.

Se invece ci saranno degli errori:
![Modal di errore](http://localhost:8080/annullamento%20delle%20fatture%20-%20modal%20di%20errore.png)

### Impostazioni personalizzate
Per attivare e rendere fruibile la funzionalità di fatturazione elettronica è necessario che alla base vi siano memorizzati dei dati coerenti e utili ad essere usati. Per questo motivo è possibile accedere alla schermata delle impostazioni. 
Come succede per la *Dashboard* anche qui troviamo la schermata suddivisa in diversi widget, ognuno con uno scopo diverso.

    //todo INSERIRE IMMAGINE IMPOSTAZIONI

#### Personalizzare i dati del cedente
Lo scopo di questo widget è rendere possibile la gestione dei dati del cedente memorizzati nel db.
I dati editabili per il cedente sono:
- Dati anagrafici:
	- Ragione sociale (obbligatorio): la stringa che la valorizza può contenere qualsiasi carattere, e la lunghezza massima è di 255 caratteri.
	- Regime fiscale (obbligatorio): i valori possibili per il regime fiscale sono tutti elencati nel menù a tendina che è presente nella schermata. Di ognuno è indicato codice e breve descrizione, per alcuni è indicato anche l'articolo legislativo che ne regola il comportamento.
	- Partita IVA (obbligatorio): l'unico tipo di partita IVA accettata da questa applicazione è quella italiana. Perciò il valore inserito dovrà sempre essere caratterizzato dal suffisso IT seguito da 11 cifre.
	- Codice fiscale: questo campo non è obbligatorio, tuttavia è fortemente consigliato valorizzarlo, perchè serve per fornire un elemento aggiuntivo di identificazione del
soggetto cedente/prestatore, spesso richiesto per il pagamento. Il valore deve essere una stringa numerica della lunghezza di 11 caratteri.
- Indirizzo (obbligatorio): i campi descritti qui di seguito servono a descrivere la sede legale dell'azienda fornitrice.
	- Città (obbligatorio): questo campo pò contenere una stringa con qualsiasi carattere e lunga non più di 60.
	- Provincia (obbligatorio): contiene la sigla della provincia che contiene il comune descritto sul campo precedente, quindi la stringa contenuta in questo campo deve essere costituita da 2 lettere (non ha importanza se maiuscole o minuscole, il sistema le convertirà sempre in maiuscole).
	- CAP (obbligatorio): il formato accettato del valore del CAP prevede che la stringa contenga 5 cifre 
	- Indirizzo (obbligatorio): non sono presenti particolari validatori per questo campo, tuttavia la stringa non può superare i 255 caratteri.
	- Numero civico (obbligatorio): può essere valorizzato con una stringa contenente qualsiasi tipo di carattere e lunga al massimo 50.
- Iscrizione REA: repertorio delle notizie economiche ed amministrative, è possibile scegliere se inserirlo o meno cliccando sul toggle `Inserisci iscrizione REA`. Attivandolo si aprirà la sezione contenente i campi da valorizzare:
	- Numero REA (obbligatorio): deve essere composto da 6 cifre;
	- Ufficio REA (obbligatorio): contiene il codice della provincia che ha assegnato il numero REA, quindi la stringa contenuta in questo campo deve essere costituita da 2 lettere (non ha importanza se maiuscole o minuscole, il sistema le convertirà sempre in maiuscole);
	- Capitale sociale: è valorizzabile con un numero di al massimo 13 cifre di cui 2 decimali;
	- Socio unico: nel caso di società di capitali, è possibile indicare se trattasi di "socio unico". Tuttavia è anche possibile non indicare nulla lasciando il menù a tendina con la voce `Scegli...` selezionata;
	- In liquidazione (obbligatorio): con il toggle è possibile indicare se la società è in liquidazione o meno.
- Contatti: in questa sezione nessun campo è obbligatorio:
	- Telefono: qui possono essere inseriti 12 caratteri di qualsiasi tipo;
	- Email: in questo campo è possibile indicare un indirizzo mail di contatto con l'azienda cedente. Deve essere nel formato mail standard;
	- PEC: in questo campo è possibile indicare un indirizzo di posta elettronica certificata. Deve essere nel formato mail standard.

Finchè tutti i campi non saranno compilati in modo corretto il tasto `Salva` non sarà attivo per impedire che vengano memorizzati nel db errori sintattici. 
Una volta che questo tasto è attivo è possibile cliccarlo per avviare il salvataggio dei dati.

##### Toggle "Usa dati aziendali differenti per la generazione delle fatture elettroniche"
Se attivo questo toggle permette di usare dei dati alternativi a quelli principali. I dati già memorizzati per il cedente non verranno modificati e ne verranno memorizzati dei nuovi da utilizzare per la fatturazione.
Attivando il toggle, si può notare che i campi dell'editor vengono tutti svuotati e in alto a destra appare il tasto `Ricopia i dati del punto vendita`. La pèressione di questo tasto ha due possibili effetti:
- se sono **già memorizzati dei dati alternativi** del cedente ricopia nei campi sottostanti questi ultimi valori;
- se invece **NON sono memorizzati dati alternativi** nei campi ricopia i valori dei dati principali del cedente già memorizzati nel db qualora ve ne fossero.

Il motivo della scelta di questo comportamento risiede nel fatto che i dati principali potrebbero essere usati anche per altri scopi oltre la fatturazione elettronica, per cui potrebbe essere necessario che abbiano i dati valorizzati in modo diverso.
(==Aggiungere esempio?==)

#### Widget per la gestione del suffisso
**Se ho impostato un suffisso nelle impostazioni del modulo fatture elettroniche, e voglio successivamente modificarlo o rimuoverlo, posso farlo solo a queste condizioni:**
1. Non c'è alcun documento già emesso o movimentato con un suffisso in quell'**anno solare corrente.**
2. Non è nemmeno possibile cambiare un suffisso da un valore ad una altro (esempio cambio da **A** a **B**) se per quell'anno solare un suffisso era presente e movimentato.
3. Tra anni diversi permettiamo di poter modificare il suffisso (o semplicemente rimuoverlo), sempre a condizione che non ci siano documenti movimentati nel momento in cui si sta tentando di eseguire la modifica.
4. Se il suffisso non era presente e si vuole inserirlo, sarà possibile farlo se e solo se in quell'anno corrente non è ancora presente alcun documento movimentato (quindi il progressivo è di fatto = 0)
5. La condizione di immutabilità del suffisso una volta movimentati i documenti rimane sempre valida anche se ho emesso annulli o note di credito per le fatture emesse. In breve se ho la fattura 1/A e la nota di credito 1/A (che la annulla) comunque non sarà possibile cambiare il suffisso nonostante apparentemente non ci siano progressivi movimentati perchè di fatto una movimentazione c'è stata.


## Ulteriori approfondimenti

### Descrizione del file XML della fattura elettronica
Il file XML che si vuole ottenere durante la creazione della fattura elettronica è caratterizzato da una struttura che possiamo suddividere fin da subito in:
- **Header**;
- **Body**.

In questo file saranno contenute informazioni minime e necessarie per l'accettazione della fattura da parte dell'SdI.
#### Header
Contiene le informazioni riguardanti il cedente, il cessionario e il canale di trasmissione della fattura. I campi principali di questa sezione sono:
- **DatiTrasmissione:** i dati all'interno di questo nodo identificano in modo univoco il soggetto che trasmette ed il formato di trasmissione. Inoltre è possibile indicare il canale utilizzato dal destinatario della fattura (_CodiceDestinatario_  o  _PECDestinatario_). Quando il cliente è una PA il campo  _CodiceDestinatario_  diventa obbligatorio;
	- _IdTrasmittente_ (obbligatorio): corrisponde all'identificativo del soggetto che trasmette la fattura. Nel caso di soggetti italiani corrisponde al codice fiscale preceduto da IT. In data attuale (19/07/2023) il soggetto trasmittente verrà in ogni caso considerato situato in Italia;
	- _ProgressivoInvio_ (obbligatorio): rappresenta il progressivo dell'invio effettuato dal soggetto che trasmette. Esso deve essere assegnato dal soggetto che trasmette il documento, secondo sue proprie regole. [Gestione del numero progressivo di invio](#gestione-del-numero-progressivo-di-invio)
	- _FormatoTrasmissione_ (obbligatorio): identifica il formato e la versione del documento trasmesso. I possibili valori sono:
		- **`PR12`**: identifica le fatture verso privati. La versione del modello di fattura è la 12;
		- **`PA12`**: identifica le fatture verso PA. La versione del modello di fattura è la 12;
	- _CodiceDestinatario_ (obbligatorio): identifica l'eventuale canale di trasmissione usato dal destinatario. Per i privati è costituito da 7 caratteri alfanumerici, invece per le PA 6. Nel nostro caso non è obbligatorio, anzi è sconsigliato indicare il codice destinatario per i privati. Per le PA invece è sempre obbligatorio;
	- _PECDestinatario_: la PEC a cui si fa riferminato in questo campo, non è semplicemente la PEC del cliente, ma deve essere la PEC che il cliente indica specificatamente per ricevere le fatture elettroniche. Questo campo non è obbligatorio.
- _**CedentePrestatore:**_ è il contenitore di diversi nodi dove vengono specificati i dati relativi al fornitore (cedente/prestatore), ovvero i dati fiscali ed i recapiti.
Il cedente verrà considerato sempre come azienda e verrà quindi esclusa l'ipotesi che possa essere una persona fisica.  
	- _DatiAnagrafici_ (obbligatorio)
		- _IdFiscaleIVA_ (obbligatorio): si tratta della partita IVA dell'azienda;
		- _Anagrafica_ (obbligatorio)
			- _Denominazione_ (in alternativa a  _Nome_ e  _Cognome_)  
			- _Nome_ (in alternativa a  _Denominazione_  insieme a  _Cognome)_  
			- _Cognome_ (in alternativa a  _Denominazione_  insieme a  _Nome)_  
		- _RegimeFiscale_ (obbligatorio) : si valorizza mediante un apposito codice `RF`;
	- _Sede_ (obbligatorio): nei figli di questo nodo è necessario valorizzare l'indirizzo del fornitore. Per le società l'indirizzo deve riportare la sede legale, mentre per le ditte individuali va specificato il domicilio fiscale;
	- _IscrizioneREA_: nei figli di questo nodo vi è la possibilità di inserire i riferimenti dell'iscrizione al REA (repertorio delle notizie economiche ed amministrative). 
Per tutti i soggetti iscritti al Registro imprese è obbligatoria l'iscrizione al REA, la quale deve essere indicata necessariamente in tutti gli atti e corrispondenza della società, quindi anche nella fattura elettronica (articolo 2250, comma 1, del codice civile).
Non sono obbligati all'iscrizione REA:
		- Il libero professionista la cui professione è regolamentata da uno specifico albo (avvocati, notai, commercialisti, ingegneri, architetti etc);
		- Le associazioni, fondazioni, comitati e altri enti non societari che esercitano un’attività commerciale o agricola, ma per i quali l’esercizio d’impresa non sia l’attività esclusiva o prevalente. Generalmente nel nome della ditta viene riportata tale tipologia (associazione, fondazione etc);
		- Le imprese con sede principale al di fuori del territorio nazionale che aprano un’unità locale in Italia;
	- _Contatti_: contenitore dei nodi volti a specificare i contatti del fornitore (telefono, email).

- _**CessionarioCommittente**_ (obbligatorio): contenitore di diversi nodi dove vengono rappresentati i dati relativi al cliente (cessionario / committente), ovvero i dati fiscali ed i recapiti.
	- _DatiAnagrafici_ (obbligatorio): contenitore di nodi dove vengono espressi i dati fiscali del cliente (cedente / prestatore) e quelli anagrafici:  
		- IdFiscaleIVA;
		- CodiceFiscale;

		**Almeno uno tra  *CodiceFiscale*  e  *IdFiscaleIVA*  deve essere valorizzato per non incorrere in un errore di scarto da parte del SdI.**  Se vengono valorizzati entrambi verrà effettuato un controllo di coerenza tra i due, quindi è preferibile valorizzarne uno solo. In data attuale (19/07/2023) nella funzionalità descritta non è possibile inserire sia codice fiscale che partita IVA del cessionario.
		- Anagrafica (obbligatorio): (come per il cedente);
	- Sede (obbligatorio): per le società l'indirizzo deve riportare la sede legale, mentre per le ditte individuali e lavoratori autonomi va specificato il domicilio fiscale.

#### Body
Può contenere dati di una o più fatture. In data attuale (19/07/2023), ogni documento generato da questo applicativo conterrà le informazioni riguardanti un unico scontrino:
- _**DatiGenerali**_ (obbligatorio): nei figli di questo nodo, troviamo informazioni generali sui dati identificativi del documento e riferimenti dello stesso.
	- _DatiGeneraliDocumento_ (obbligatorio): in questo nodo è necessario specificare alcuni dati identificativi del documento ed altre informazioni generali come:
		- *TipoDocumento* (obbligatorio): tramite specifico codice indica il tipo di documento contenuto nel XML, ad esempio se è una fattura (`TD01`) o una nota di credito (`TD04`);
		- *Data* (obbligatorio): si riferisce alla data del documento che nel caso di una fattura immediata coincide con la data dell'operazione;  
		- *Numero* (obbligatorio): si rimanda la spiegazione al paragrafo [Gestione della numerazione di un documento](#gestione-della-numerazione-di-un-documento);  
		- *Divisa* (obbligatorio): codice di 3 caratteri in formato ISO 4217 alpha-3:2001 per identificare la valuta da utilizzare per indicare gli importi. In questa funzionalità sarà sempre indicata come `EUR`;
		- *ImportoTotaleDocumento*: dovrebbe sempre coincidere con le somme di *DatiBeniServizi\DatiRiepilogo\ImponibileImporto* + *DatiBeniServizi\DatiRiepilogo\Imposta*, ad eccezione del caso in cui il nodo *DatiBeniServizi\DatiRiepilogo\Natura* viene valorizzato con codici `N2.1` o `N2.2`. In questo caso *DatiBeniServizi\DatiRiepilogo\ImponibileImporto* può non essere sommato;
		- *Arrotondamento*: è un arrotondamento più che altro destinato a far coincidere l'importo della fattura con quello relativo al pagamento (nodo *DatiPagamento\DettaglioPagamento\ImportoPagamento*);
		- *Art73*: vedi paragrafo [Gestione della numerazione di un documento](#gestione-della-numerazione-di-un-documento)
	- *DatiOrdineAcquisto*: nei figli di questo nodo possiamo inserire vari riferimenti che riguardano l'ordine acquisto del cliente. Se è necessario effettuare la fattura alla PA, verrano richiesti dalla UI esplicitamente durante il workflow i campi:
		- IdDocumento (obbligatorio): identificativo del documento attraverso il quale è maturato l'ordine acquisto;
		- CodiceCUP: (Codice Unitario Progetto) caratterizza ogni progetto di investimento pubblico, quindi da utlizzare nel caso il cliente sia una PA;
        - CodiceCIG: (Codice Identificativo della Gara ) va utilizzato quando il nostro cliente è una PA;

		Se il cliente finale che richiede la fattura non possiede un ordine di acquisto, supportiamo la possibilità di imputare i dati del contratto. Vedi paragrafo seguente.

	- *DatiContratto*: nei figli di questo nodo possiamo specificare i riferimenti ad un'eventuale contratto che ha maturato la fornitura. Se è necessario effettuare la fattura alla PA, verrano richiesti dalla UI esplicitamente durante il workflow i campi:
		- *IdDocumento* (obbligatorio): identificativo del contratto attraverso il quale si è perfezionata la fornitura;
		- *CodiceCUP*: (Codice Unitario Progetto) caratterizza ogni progetto di investimento pubblico, quindi da utlizzare nel caso il cliente sia una PA;
		- *CodiceCIG*: (Codice Identificativo della Gara ) va utilizzato quando il nostro cliente è una PA.

		Se il cliente ha sia i dati del contratto che quelli dell'ordine di acquisto, può inserirli tutti.
		Il codice cig e cup possono anche essere uguali in entrambi i casi (sia per l'id contratto che per l'id ordine acquisto).
		Se il cliente inserisce SOLO CIG e CUP (OPPURE UNO DEI DUE) dovrà per forza indicare o un Id Contratto oppure un Id Documento Acquisto.
		**Non supportiamo altri tipi di dati** per CIG/CUP.

	- *DatiFattureCollegate*: nei figli di questo nodo potremo specificare durante la generazione di una nota di credito i riferimenti alla fattura da annullare. 
		- *IdDocumento*: identificativo della fattura da annullare. È costituito da numero progressivo + suffisso;
		- *Data*: è la data di operazione della fattura da annullare.

- ***DatiBeniServizi*** (obbligatorio): nei figli di questo nodo possiamo inserire i dati che identificano natura, qualità, quantità dei servizi o beni ceduti.
	- *DettaglioLinee*: corrisponde ad una riga della fattura dove noi descriviamo e valorizziamo uno o più prodotti/servizi contenuti nello scontrino in questione. I dati che possiamo inserire sono:
		- *NumeroLinea* (obbligatorio): numero della linea corrispondente dello scontrino;
		- *CodiceArticolo*: il codice articolo è utile al cliente per meglio identificare il bene o servizio. Questo nodo conterrà quindi il barcode dell'articolo;  
		- *Descrizione* (obbligatorio): contiene una breve descrizione dell'articolo;  
		- *Quantita*: quantità di prodotto;
		- *UnitaMisura*: unità di misura del prodotto (`PZ`, `KG`, `LT`);
		- *PrezzoUnitario* (obbligatorio): si intende il prezzo unitario del prodotto al netto dell'IVA;  
		- *ScontoMaggiorazione*: eventuale sconto o maggiorazione da calcolare sul prezzo unitario senza IVA;  
		- *PrezzoTotale* (obbligatorio): è il prezzo totale della riga, calcolato dal prezzo unitario per le quantità sottratti eventuali sconti;  
		- *AliquotaIVA* (obbligatorio): aliquota IVA in percentuale da applicare al bene o servizio;  
		- *Natura*: se l'aliquota IVA non è valorizzata o uguale a zero, va qui indicata, tramite appropriato codice, la motivazione;  
		- AltriDatiGestionali: nei discendenti di questo nodo possiamo aggiungere ulteriori elementi da riferirsi alla linea di dettaglio del prodotto o servizio. Se la fattura che generiamo viene creata a partire da una transazione fiscale, allora inseriremo in questo nodo dei dati che descrivono tipo, codice identificativo e data della transazione in questione;
	- *DatiRiepilogo* (obbligatorio): contenitore di diversi nodi che riepilogano gruppi di righe di dettaglio con la stessa aliquota IVA, natura ed esigibilità. Questo nodo è ripetibile per supportare più aliquote IVA distinte. I dati che possiamo inserire sono:
		- *AliquotaIVA* (obbligatorio): aliquota IVA in percentuale;
		- *Natura*: come sopra;
		- *Arrotondamento*: eventuale arrotondamento applicato sul raggruppamento delle righe di dettaglio per il fine di riportarle arrotondate al centesimo di Euro;  
		- *ImponibileImporto* (obbligatorio): viene formulato sommando i valori dei prezzi totali delle righe con la stessa aliquota IVA e l'arrotondamento indicato nel nodo subito precedente a questo;
		- *Imposta* (obbligatorio): IVA calcolata sulla somma dei prezzi delle linee a cui questo nodo fa riferimento;
		- *EsigibilitaIVA*: Tramite relativo codice si specifica il regime di esigibilità IVA (differita o immediata) o la modalità di versamento dell'imposta (scissione pagamenti). Di default l'esegibilità è di tipo *immediato*;
		- *RiferimentoNormativo*: deve essere riportata la norma di riferimento nei casi in cui il nodo _Natura_  è valorizzato;  

- ***DatiPagamento***: nei figli di questo nodo sono descritte le condizioni di pagamento per la fornitura in oggetto.  
	- *CondizioniPagamento* (obbligatorio): tramite relativo codice che inizia con `TP` viene specificato se il pagamento è a rate, o in un unica soluzione, oppure è anticipato. Essendo la fattura generata a partire da uno scontrino, il pagamento sarà in genere in unica soluzione. In data 20/07/2023 viene contemplato solo quest'ultimo caso e il valore è `TP02`.
	- *DettaglioPagamento* (obbligatorio)
		- *ModalitaPagamento* (obbligatorio): tramite relativo codice che inizia con `MP` viene espressa la modalità del pagamento;
		- *ImportoPagamento* (obbligatorio): importo di cui si richiede il pagamento.

#### Ricezione della fattura da parte del cliente
- Aziende/Associazioni o liberi professionisti - **con partita IVA**:
In questo caso se il cliente comunica una PEC (***Header>DatiTrasmissione>PECDestinatario***) o un codice destinatario (***Header>DatiTrasmissione>CodiceDestinatario***) riceverà direttamente la fattura.
**In caso contrario** o se il SdI dovesse comunicare tramite l’apposita ricevuta di “**impossibilità di recapito**” che la fattura non è stata recapitata, il fornitore sarà **tenuto ad avvisare il cliente** che la fattura è stata depositata nel cassetto fiscale o a **recapitare** in formato analogico o digitale la **fattura**.

- Associazioni o consumatori - **senza partita IVA**:
In questo caso il fornitore sarà **tenuto ad avvisare il cliente** che la fattura è stata depositata nel cassetto fiscale o a **recapitare** in formato analogico o digitale la **fattura**.

#### Impostazione dell'esegibilità dell'IVA
In tutti i casi d'uso l'esigibilità dell'IVA è sempre di default **IMMEDIATA**.
Tuttavia l'esigibilità dell'IVA può essere cambiata a **differita** se al momento dell'emissione dello scontrino il pagamento scelto è di tipo RT pagamento **"Non riscosso" + Segue fattura**.   
Lo **split payment**, invece si può applicare solo a fatture che non nascono da documento commerciale RT, ma solo da documento gestionale. Il documento gestionale, non essendo proprio una vendita, fa si che la fattura elettronica diventi la vendita vera e propria, quindi in questo caso si può anche optare per lo split payment.
Se viene scelta l'IVA con split payment **nessun articolo all'interno del documento deve avere l'IVA con reverse charge** (natura iva N6).

## Troubleshooting per i tecnici

### Verifica del caricamento del plug-in
Il plug-in è incluso **out-of-the-box** nello *StoreServer*.
All'avvio sarà automaticamente rilevato e caricato.

E' possibile verificare l'avvenuto caricamento del plug-in consultando il log dello StoreServer.
Se la riga `YYYY-MM-DD HH:mm:ss.ffff|Posware.Services.Dmo.Modules.Handlers.IModulesHandler|INFO|Successfully loaded module: Posware.Services.Dmo.Posware, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null`
è presente nel file di log, il plug-in è stato rilevato e caricato.

### Errori nella validazione del documento generato
Durante la generazione di un documento elettronico è possibile incappare in alcuni errori di validazione che non permettono di procedere. Questi errori sono caratterizzati da un codice di errore e un messaggio che ne descrive brevemente il significato.
È possibile visualizzare questi errori nel file di log del StoreServer oppure nelle risposte con status code 500 che si ricevono dal StoreServer durante la compilazione dello wizard per la generazione di una fattura elettronica o cliccando su `Genera nota di credito`.
|Codice errore|Significato|Risoluzione|
|--|--|--|
|**1**| La transazione che è stata selezionata per la compilazione del documento elettronico non esiste. |Verificare che gli estremi inseriti per la ricerca della transazione siano corretti.|
|**20**| Il pagamento differito dell'IVA da parte del committente non può avvenire se al momento dell'emissione dello scontrino il pagamento scelto non è di tipo RT pagamento **"Non riscosso" + Segue fattura**.|
|**21**|Lo split payment non può essere applicato, in quanto si applica solo a fatture che non nascono da documento commerciale RT ma solo da documento gestionale (cfr. [Impostazione dell'esegibilità dell'IVA](#impostazione-dellesegibilità-delliva)).|
|**22**|Questo errore si manifesta quando la fattura che include la transazione selezionata è già stata generata e non è annullata da nessuna nota credito successiva.|Valutare se è il caso di generare prima una nota di credito per annullare la fattura già esistente.|
|**23**|Nel messaggio di errore include la lista di tutti i possibili errori di validazione del documento dopo che è stato generato.|Per capire come compilare correttamente una fattura elettronica si rimanda alla [sezione di approfondimento](#descrizione-del-file-xml-della-fattura-elettronica) che descrive il contenuto del file XML.|
|**24**|La data di operazione selezionata per la generazione del documento è successiva alla data odierna.|Lo wizard di creazione della fattura impedisce a priori questo tipo di errore, quindi se dovesse verificarsi vorrebbe dire l'orologio del client e quello del server non sono sincronizzati. È necessario innanzitutto **verificare che la data dello StoreServer sia corretta** e nel caso correggerla, dopodichè si dovrà fare in modo, se già non lo fosse, di **sincronizzare il client**.|
|**25**|La data di operazione non risulta essere stata definita in fase di generazione.|
|**26**|Questo errore può verificarsi per due motivi: 1) la data di operazione impostata è precedente all'1 gennaio dell'anno corrente, 2) la data di operazione è precedente alla data di operazione dell'ultimo documento generato. Per capire meglio questo secondo punto leggere [qui](#approfondimenti-sullerrore-26).|
|**27**|L'ID del cliente selezionato per la generazione della fattura non è stato trovato in memoria. Questo errore potrebbe avvenire se capitasse che i dati rigaurdanti il cliente selezionato vengono modificati o eliminati da qualcun altro mentre si sta compilando lo wizard per la creazione della fattura o se sono stati eliminato o modificati prima di generare una nota di credito.|
|**28**|I dati del fornitore non sono stati impostati o sono stati eliminati durante la generazione del documento.|
|**29**|Durante le generazione di una nota di credito la fattura selezionata per l'annullamento non è stata trovata.|
|**30**|Durante le generazione di una nota di credito gli estremi della transazione memorizzati nella fattura selezionata non corrispondono ad una transazione che risulti essere stata fatturata. |Verificare la correttezza dei dati della fattura selezionata.|
|**31**|Non è possibile annullare la fattura selezionata, poichè questa non è stata generata nell'anno corrente.|
|**32**|Durante la rigenerazione di un documento questo non è stato trovato in memoria.|

#### Approfondimenti sull'errore 26
Per capire questo errore c'è da fare una precisazione sulla generazione della fattura. Nell'interfaccia utente è possibile selezionare la data di operazione, ma non l'orario. L'orario viene impostato dallo StoreServer settando quello attuale. 
*Per esempio: se la data e orario attuali sono 12/07/2022, 14:32:45 e dall'interfaccia seleziono 02/07/2022, la data e l'orario che il sistema imposterà per la fattura saranno -> 02/07/2022, 14:32:45*.
Quindi potrebbe capitare che ci siano degli errori di questo tipo: se la data di operazione dell'**ultima fattura** è **23/06/2023 alle 15:32:56** e la data **attuale** è **01/07/2023, 10:12:23**, generando una fattura e selezionando la data del **23/06/2023** verrebbe impostata la data **23/06/2023, 10:12:23** che risulterebbe essere **precedente** alla data di operazione dell'ultimo documento generato.

### Errori nella validazione del cedente durante il salvataggio
Nelle impostazioni è possibile inserire o modificare le informazioni riguardanti il cede/fornitore. Perciò potrebbe capitare di incappare in una serie di errori dovuti all'inserimento nella chiamata di salvataggio del cedente nel db di dati difformi dalle regole descritte in precedenza.
Questi errori possono essere:
- Ragione sociale non indicata;
- Partita IVA nel formato sbagliato (`IT` + 11 cifre) o assente;
- Codice fiscale nel formato sbagliato (11 cifre);
- Regime fiscale non indicato;
- Indirizzo non indicato;
- Numero civico non indicato;
- Provincia non indicata o nel formato sbagliato (2 lettere);
- CAP non indicato o nel formato sbagliato (5 cifre);
- Città non indicata;
- Quando presente la registrazione REA:
	- Numero REA non indicato o nel formato sbagliato (6 cifre);
	- Ufficio REA non indicato o nel formato sbagliato (2 lettere);
	- L'informazione che descrive il fatto che l'azienda è in liquidazione o meno che non è indicata;
	- Capitale sociale che non rispetta la precisione (13) o la scala (2);
- Email nel formato sbagliato;
- PEC nel formato sbagliato;
- Numero di telefono più lungo di 12 caratteri;

### Gestione del numero progressivo di invio
Nel nostro caso, il numero progressivo di invio verrà valorizzato utilizzando i dati che identificano il documento, ovvero:
1.  l'**anno fiscale** in cui viene generata la fattura: viene sempre valorizzato con l'anno corrente. Vengono usate le ultime due cifre significative, es: 2023 -> 23;
2.  il codice che definisce il **tipo** di documento: nel nostro caso le fatture verso privati sono identificate dal numero 0, le fatture verso PA dal numero 1 e  le note di credito dal numero 2. Per la composizione del progressivo sono state riservate a questo campo due cifre. 
_Esempio: fattura (privati) -> 00, fattura (PA) -> 01, nota credito -> 02_;
3.  il **numero** progressivo associato al documento: a questo campo sono state riservate 6 cifre.

**La chiave in chiaro sarà composta così: anno fiscale (2) | tipo documento (2) | numero fattura (6).**
Costituita da 10 cifre decimali, verrà poi convertita in una stringa esadecimale. 
**_Esempio: Fattura verso privati (codice tipo 0) numero 2345 del 2022 -> 22|00|002345 -> 83215F29_;**

### Gestione della numerazione di un documento
Ogni documento ha un identificativo composto da un numero progressivo e un eventuale suffisso (*es: 1/ABC, 3/B, 56/DF*).
Ogni progressivo e suffisso sono legati sempre all'anno solare di creazione dei documenti. [*Note sull'identificativo del documento*](#note-sullidentificativo-del-documento)
Una volta impostato un suffisso, per l'anno in corso, non sarà più possibile rimuoverlo o modificarlo se quel suffisso è stato già movimentato da un documento (fattura o nota di credito).
La nota di credito e le fatture hanno numerazioni tra di loro differenti CONDIVIDENDO PERO' lo stesso suffisso, questo perchè l'AdE differenzia le numerazioni dei documenti a prescindere anche in base al campo tipo documento della fattura elettronica (che sarà `TD01` per le fatture e `TD04` per le note credito). [*Note sull'identificativo del documento*](#note-sullidentificativo-del-documento)
La regola di identificazione univoca ha valenza nell’ambito dell’anno solare (per esempio 2022), passato il quale le numerazioni dei documenti verranno “resettate” e si ricomincia da 1.

Avendo scelto di usare una numerazione diversa per tipologia di documento + anno solare, il che può comportare che lo stesso numero sia presente più volte nello stesso anno solare, (*es.: fattura 1 del 2023 e nota credito 1 del 2023*) è requisito mandatorio valorizzare nel file XML del documento elettronico, il nodo *DatiGenerali\DatiGeneraliDocumenti\\**Art73*** a `SI`. In caso contrario ci saranno degli scarti da parte del SdI.

### Note sull'identificativo del documento
Se ho impostato un suffisso nelle impostazioni del modulo fatture elettroniche, tale suffisso viene condiviso da tutte le numerazioni di tutti i tipi di documento. Assumendo il suffiso 'A' , si avrà:
 - Numerazione fatture **1/A , 2/A, 3/A ecc...** 
 - Numerazione nota di credito **1/A, 2/A, 3/A ecc... Non sarà possibile 1/B oppure
   semplicemente 1, 2, 3.**

### Note e specifiche sul suffisso
Alla data del 20/07/2023, per la versione 4.3 del StoreServer, il suffisso è liberamente imputabile dall'operatore con caratteri alfanumerici di **lunghezza massima di 5**.
**I caratteri inseriti verranno sempre convertiti in maiuscolo.**

È considerato prassi e pratica consolidata l'uso del maiuscolo nelle soluzioni fiscali di mercato e riportato nella nostra soluzione **by design**.

### Meccanismi della generazione di un nuovo progressivo:  
Per l'anno corrente ed il tipo documento, viene preso l'ultimo numero emesso a parità di suffisso  
-   Se questo numero è presente, il progressivo da usare è l'ultimo progressivo del documento emesso + 1
-   Se NON è presente, il progressivo da usare è **1 . Progressivo a zero non è mai ammesso.**

### Verifica della correttezza dei dati di un documento
Quando un documento viene generato o rigenerato viene salvato un record nella tabella *einvoice* del database dello *StoreServer*. 
Le informazioni presenti in questo record sono:
- Numero, suffisso, anno fiscale e tipo del documento;
- Contenuto del file XML del documento in formato JSON: all'interno è presente anche un **codice hash** che garantisce l'integrità del JSON stesso;
- Data di operazione: la stessa informazione è contenuta anche nel file XML (FatturaElettronicaBody>DatiGenerali>DatiGeneraliDocumento>Data);
- Data di creazione e data di aggiornamento del record: questi dati sono generati automaticamente dal database al momento appunto della creazione e dell'aggiornamento del dato;
- Estremi di riferimento della transazione inclusa (ID della cassa, ID della transazione, ID del punto vendita, data della transazione): è possibile quindi verificare tramite questi se i dati della transazione collegata sono presenti nella tabella *log*;
- ID del cliente: conoscendo questo dato è possibile verificare che le informazioni riguardanti il cliente incluse nel file XML (vedi il contenuto in formato JSON presente in questo record) siano coerenti con quelle che è possibile vedere dalla tabella *billing_customers*;
- Nome del file XML generato;
- Estremi di riferimento di un documento collegato, qualora il documento nel record sia una nota di credito.

### F.A.Q.
##### Perché non posso applicare lo split payment alla fattura che sto generando?
Come descritto [qui](#impostazione-dellesegibilità-delliva), lo split payment si può applicare solo a fatture che non nascono da documento commerciale RT, ma solo da documento gestionale.

##### Perché non posso applicare l'esegibilità differita dell'IVA?
L'esigibilità dell'IVA può essere impostata a differita se al momento dell'emissione dello scontrino il pagamento scelto è di tipo RT pagamento **"Non riscosso" + Segue fattura**.

##### Perchè la data di operazione che ho selezionato tra le disponibili non è valida?
Può capitare che durante la generazione di una nuova fattura, selezionando la data minore tra le disponibili, la chiamata torni con un errore. Questo errore è dato dal fatto che l'orario della data di operazione impostato dallo StoreServer è basato sull'orario della chiamata, quindi è possibile che si generi una fattura - anche se con stessa data - con orario precedente a quello dell'ultimo documento generato. Si può trovare un esempio e la spiegazione dettagliata di questo errore in [questo paragrafo](#approfondimenti-sullerrore-26).

##### Perchè appare il messaggio di errore "*Si è verificato un problema di comunicazione con il server. Controlla la connessione e riprova.*"?
Quando viene visualizzato questo messaggio vuol dire che la WebApp per qualche ragione non riesce a comunicare con lo StoreServer. 
Per capire nello specifico quale potrebbe essere la ragione è necessario verificare che lo StoreServer sia attivo e funzionante e che la WebApp possa comunicare con esso.

##### Perchè appare il messaggio di errore "*Si è verificato un problema non identificato. Riprova più tardi.*"?
Questo è un messaggio di default di errore che risulterebbe qualora si verificasse un errore non identificato durante la chiamata che è stata fatta allo StoreServer.
Per capire di che errore si tratta è necessario consultare il file di log.

#### Messaggi di errore durante la procedura di generazione di una fattura elettronica
#### Step 1 - Ricerca e validazione di uno scontrino
##### Perchè appare il messaggio di errore "*La transazione selezionata è già stata fatturata.*"?
**Causa**:  di tutti i documenti generati a partire dalla transazione in questione, l'ultimo in termini di data di operazione che è stato generato è una fattura elettronica. Ricordiamo che la fattura elettronica in questa sede può essere effettuata unicamente per la totalità dello scontrino, quindi se risulta che l'ultimo documento è una fattura vuol dire che essa è stata generata per la transazione, completa di ogni prodotto, contenuta in essa. 
**Soluzione**:  
- controllare che gli estremi inseriti siano corretti e riprovare;
- stornare l'ultima fattura generando una nota di credito (è possibile eseguire questa operazione seguendo le indicazioni descritte [qui](#annullamento-delle-fatture)) e riprovare a generare la fattura elettronica.

##### Perchè appare il messaggio di errore "*La transazione selezionata non risulta fatturabile.*"?
**Causa**: la transazione selezionata per la generazione della fattura risulta:
-  una nota di credito;
-  sospesa;
-  non completata con successo - lo scontrino è stato annullato;
-  essere l'annullo di una transazione precedente;
-  un'operazione di prelievo;
-  un'operazione di fondo cassa o deposito generico.

Potrebbe esserci stato un errore durante la battuta dello scontrino.
**Soluzione**: si consiglia di verificare la correttezza dello scontrino in questione. Nel caso qualcosa non fosse corretto è necessario annullarlo e ripetere la battuta.

##### Perchè appare il messaggio di errore "*Non è stata trovata nessuna transazione corrispondente ai dati inseriti.*"?
**Causa**: con gli estremi della transazione inseriti nello wizard non si riesce a trovare riscontro nel database. 
**Soluzione**: verificare che gli estremi inseriti siano esatti e nel caso fossero errati ripetere l'operazione correggendo i dati inseriti.

##### Perchè appare il messaggio di errore "*Non è possibile verificare la transazione indicata a causa di un errore non specificato.*"?
**Causa**: durante l'operazione di ricerca da parte dello StoreServer si solleva un'eccezione non codificata. Questo errore non è dovuto alla validazione dei dati inseriti o generati, ma ad una qualche operazione interna al server.
**Soluzione**: è necessario controllare i file di log dello StoreServer per capire la natura dell'errore.

#### Step 5
##### Perchè appare il messaggio di errore "*La transazione selezionata non risulta fatturabile.*"?
**Causa**: la transazione selezionata per la generazione della fattura risulta al momento della generazione:
-  una nota di credito;
-  sospesa;
-  non completata con successo - lo scontrino è stato annullato;
-  essere l'annullo di una transazione precedente;
-  un'operazione di prelievo;
-  un'operazione di fondo cassa o deposito generico.

Premettendo che allo step 1 di questo wizard c'è la stessa operazione di validazione, l'unica cosa che può essere successa a questo punto è che i dati riguardanti la transazione sono stati modificati da qualche agente esterno mentre l'utente si trovava ad inserire informazioni tra lo step 2 e lo step 5.
**Soluzione**: verificare la correttezza dei dati presenti nel database e riprovare l'operazione.

##### Perchè appare il messaggio di errore "*Il pagamento differito non può essere applicato.*"?
**Causa**: il pagamento selezionato al momento della battuta dello scontrino non è del tipo RT  "Non riscosso" + Segue fattura. Di conseguenza l'esegibiltà differita dell'IVA non è applicabile alla fattura che si sta tentando di generare.
**Soluzione**: tornare allo step 4 e deselezionare l'esegibilità differita e riprovare. Si ricorda che in tutti i casi d'uso l'esigibilità dell'IVA è sempre di default **IMMEDIATA** (nessuna opzione selezionata).

##### Perchè appare il messaggio di errore "*Lo split payment non può essere applicato ad un documento fiscale.*"?
**Causa**: lo split payment non può essere applicato, in quanto si applica solo a fatture che non nascono da documento commerciale RT ma solo da documento gestionale (cfr. [Impostazione dell'esegibilità dell'IVA](#impostazione-dellesegibilità-delliva)).
**Soluzione**: tornare allo step 4 e deselezionare lo split payment e riprovare.

##### Perchè appare il messaggio di errore "*La transazione selezionata è già stata fatturata.*"?
**Causa**: la transazione selezionata per la generazione della fattura risulta al momento della generazione già  utilizzata per effettuare una fatturazione elettronica.
Premettendo che allo step 1 di questo wizard c'è la stessa operazione di validazione, l'unica cosa che può essere successa a questo punto è che la transazione selezionata è stata fatturata elettronicamente da qualcun altro mentre l'utente si trovava ad inserire informazioni tra lo step 2 e lo step 5.
**Soluzione**: verificare la presenza di una fattura elettronica generata a partire dalla transazione che si è cercato di fatturare. Valutare se è il caso di fare lo storno e se necessario ripetere la fatturazione. 
Si ricorda che non è possibile eliminare le fatture generate, ma solo stornarle generando una nota di credito.

##### Perchè appare il messaggio di errore "*Sono stati riscontrati uno o più errori nella generazione della fattura.*"?
**Causa**: sono stati riscontrati degli errori di validazione e di forma - sintassi - nella fattura elettronica che è stata generata.
**Soluzione**: leggere i dettagli contenuti nella modal di errore per capire di quali errori si tratta.

##### Perchè appare il messaggio di errore "*La data di operazione della fattura non può essere successiva alla data odierna.*"?
**Causa**: la data di operazione selezionata nello step 5 dello wizard è successiva a quella attuale. Per esempio è il 04/08/2023 e viene selezionato lo 05/08/2023.
Questo può succedere se l'orologio del dispositivo in cui viene aperta la WebApp non è sincronizzato con quello dello StoreServer.
**Soluzione**: 
1. verificare che la data dello StoreServer sia corretta e che sia impostata la giusta TimeZone;
2. correggere qualora ci fossero errori;
3. verficare l'orario del client e sincronizzarlo con il server;
4. riprovare a generare la fattura.

##### Perchè appare il messaggio di errore "*È necessario indicare una data di operazione valida.*"?
**Causa**: la generazione della fattura è stata avviata senza che sia stata indicata una data di operazione. 
Ciò non dovrebbe essere possibile usando lo wizard della WebApp.
**Soluzione**: riprovare la generazione della fattura assicurandosi di indicare una data di operazione che sia valida.

##### Perchè appare il messaggio di errore "*La data di operazione deve essere successiva o contemporanea rispetto la data dell'ultimo documento emesso o della transazione selezionata per la fatturazione.*"?
**Causa**: la data di operazione indicata è precedente a quella dell'ultimo documento emesso o della transazione che è stata selezionata nello step 1.
**Soluzione**: indicare una data successiva a quelle descritte.

##### Perchè appare il messaggio di errore "*Il cessionario selezionato non è stato trovato.*"?
**Causa**: i dati del cessionario al momento dell'avvio della generazione della fattura non sono stati trovati nel db.
**Soluzione**: riavviare la WebApp e riprovare l'operazione. 
All'apertura della *Dashboard* della fatturazione elettronica verrà verificato dalla WebApp stessa la presenza e correttezza dei dati del cessionario. Se non dovesse avere esito positivo questo controllo, verrà mostrata a schermo la schermata di editing del cessionario. 

##### Perchè appare il messaggio di errore "*I dati del punto vendita non sono stati trovati o non sono corretti.*"?
**Causa**: i dati del cedente - punto vendita - al momento dell'avvio della generazione della fattura non sono stati trovati nel db.
**Soluzione**: riavviare la WebApp e riprovare l'operazione. 
All'apertura della *Dashboard* della fatturazione elettronica verrà verificato dalla WebApp stessa la presenza e correttezza dei dati del cedente - punto vendita. Se non dovesse avere esito positivo questo controllo, verrà mostrata a schermo un'apposita [schermata di editing](#personalizzare-i-dati-del-cedente). 

##### Perchè appare il messaggio di errore "*Non è stato possibile generare la fattura.*"?
**Causa**: questo è un messaggio generico di errore che risulterebbe qualora si verificasse un errore **di validazione** durante la generazione della fattura elettronica.
**Soluzione**: per capire di che errore si tratta è necessario consultare il file di log.

##### Perchè appare il messaggio di errore "*Si è verificato un errore nel server. Non è stato possibile generare la fattura*"?
**Causa**: questo è un messaggio generico di errore che risulterebbe qualora si verificasse un errore **non identificato** durante la generazione della fattura elettronica.
**Soluzione**: per capire di che errore si tratta è necessario consultare il file di log.

#### Generazione nota credito
##### Perchè appare il messaggio di errore "*Sono stati riscontrati uno o più errori nella generazione della nota di credito.*"?
**Causa**: può essere dovuto al fatto che i dati utilizzati per generare la fattura selezionata per la generazione della nota di credito sono corrotti o sono stati modificati. 
**Soluzione**: occorre controllare il file di log dello StoreServer per avere dettagli su questi errori di validazione.

##### Perchè appare il messaggio di errore "*La fattura selezionata per lo storno, non è stata trovata.*"?
**Causa**: la fattura selezionata dalla UI non viene trovata nel database. 
I motivi per cui potrebbe sembrare che la fattura non esiste più sono:
- la fattura è stata eliminata da un agente esterno dal database;
- i dati contenuti nel database si sono corrotti.

**Soluzione**: verificare la coerenza dei dati contenuti nel database.


##### Perchè appare il messaggio di errore "*La fattura selezionata non può essere stornata.*"?
**Causa**: i motivi per cui una fattura non può essere più stornata sono principalmente 2: 
1. la fattura è già stata stornata.
2. la fattura selezionata non esiste più nel database: se questo dovesse avvenire vorrebbe dire che il database è stato corrotto o manipolato da un agente esterno allo StoreServer. 

**Soluzione**: verificare la presenza della fattura elettronica all'interno del database dello StoreServer.

##### Perchè appare il messaggio di errore "*La fattura selezionata per lo storno non è dell'anno fiscale corrente. Lo storno non è effettuabile.*"?
**Causa**: si è cercato di generare una nota credito di una fattura che è stata emessa in un anno fiscale diverso da quello corrente.
**Soluzione**: non c'è soluzione, semplicemente non è possibile stornare una fattura che faccia parte di un anno fiscale passato.

##### Perchè appare il messaggio di errore "*Non è stato possibile generare la nota di credito.*"?
**Causa**: questo è un messaggio generico di errore che risulterebbe qualora si verificasse un errore **di validazione** della nota di credito non codificato.
**Soluzione**: per capire di che errore si tratta è necessario consultare il file di log.

##### Perchè appare il messaggio di errore "*Si è verificato un errore nel server. Non è stato possibile generare la nota di credito.*"?
**Causa**: questo è un messaggio generico di errore che risulterebbe qualora si verificasse un errore **non identificato** durante la generazione della nota di credito.
**Soluzione**: per capire di che errore si tratta è necessario consultare il file di log.

#### Rigenerazione documento
##### Perchè appare il messaggio di errore "*La transazione contenuta nel documento selezionato non è stata trovata in memoria.*"?
**Causa**: per qualche ragione con gli estremi della transazione contenuti nel documento selezionato non si riesce a trovare riscontro nel database. 
Le ragioni potrebbero essere:
1. gli estremi (e quindi i dati della fattura elettronica di partenza memorizzati nel database) sono stati corrotti in qualche maniera,
2. la transazione in questione non è più presente nel database. 

**Soluzione**: verificare la coerenza dei dati contenuti nel database.

##### Perchè appare il messaggio di errore "*La transazione contenuta nel documento non risulta fatturabile.*"?
**Causa**: gli estremi contenuti nel documento che si sta cercando di rigenerare puntano ad una transazione che:
-  è una nota di credito;
-  è stata sospesa;
-  non è stata completata con successo - lo scontrino è stato annullato;
-  è l'annullo di una transazione precedente;
-  è un operazione di prelievo;
-  è un operazione di fondo cassa o deposito generico.

Probabilmente i dati nel database si sono corrotti o sono stati modificati.
**Soluzione**: verificare la coerenza dei dati contenuti nel database.


##### Perchè appare il messaggio di errore "*Il pagamento differito non può essere applicato in questo documento. La rigenerazione non può essere effettuata. Controllare la correttezza dei dati contenuti in questo documento.*"?
**Causa**: per qualche ragione risulta che il pagamento dello scontrino usato per la fattura  non è del tipo RT “Non riscosso” + Segue fattura. Questo evento non dovrebbe mai accadere.  
**Soluzione**: analizzare i dati contenuti nella fattura selezionata e verificare che la transazione contenuta non sia del tipo descritto.

##### Perchè appare il messaggio di errore "*Lo split payment non può essere applicato ad un documento fiscale. La rigenerazione non può essere effettuata. Controllare la correttezza dei dati contenuti in questo documento.*"?
**Causa**: per qualche ragione risulta che lo split payment è stato applicato alla fattura anche s e documento commerciale RT ma solo da documento gestionale (cfr. [Impostazione dell’esegibilità dell’IVA](https://stackedit.io/app#impostazione-dellesegibilit%C3%A0-delliva)).  
**Soluzione**: analizzare i dati contenuti nella fattura selezionata e verificare che la transazione contenuta non sia del tipo descritto.

##### Perchè appare il messaggio di errore "*Sono stati riscontrati uno o più errori di validazione del documento rigenerato. La rigenerazione è stata annullata.*"?
**Causa**: il documento rigenerato presenta degli errori di forma che possono essere dovuti al fatto che alcuni dati contenuti in esso sono stati modificati prima della rigenerazione.
**Soluzione**: leggere il file di log dello StoreServer per conoscere i dettagli dell'errore.

##### Perchè appare il messaggio di errore "*La data di operazione del documento non è valida.*"?
**Causa**: il messaggio vuole dire che la data di operazione che è stata memorizzata è successiva alla data odierna oppure non è presente.
**Soluzione**: verificare la coerenza dei dati riguardanti il documento selezionato per la rigenerazione.

##### Perchè appare il messaggio di errore "*Il cliente destinatario del documento selezionato non è stato trovato in memoria.*"?
**Causa**: con l'ID del cliente memorizzato nel documento selezionato non è stato trovato riscontro nel database. Il motivo principale per cui può succedere questa cosa è che l'anagrafica del cliente è stata modificata o eliminata.
**Soluzione**: verificare l'esistenza dell'anagrafica del cliente nel database e se è stato modificato.

##### Perchè appare il messaggio di errore "*I dati del cedente non sono stati trovati o non sono corretti.*"?
**Causa**: i dati del cedente - punto vendita - al momento dell'avvio della rigenerazione della fattura non sono stati trovati nel db.
**Soluzione**: riavviare la WebApp e riprovare l'operazione. 
All'apertura della *Dashboard* della fatturazione elettronica verrà verificato dalla WebApp stessa la presenza e correttezza dei dati del cedente - punto vendita. Se non dovesse avere esito positivo questo controllo, verrà mostrata a schermo un'apposita [schermata di editing](#personalizzare-i-dati-del-cedente). 

##### Perchè appare il messaggio di errore "*La fattura stornata nella nota di credito selezionata per la rigenerazione non è stata trovata.*"?
**Causa**: la nota di credito contiene al suo interno i dati riguardanti la fattura che storna. Se a partire da questi dati di riferimento la fattura non viene trovata, le cause possono essere:
- la fattura è stata eliminata;
- il record nel database riguardante la nota di credito è stato modificato.

**Soluzione**: verificare la correttezza della nota di credito memorizzata nel db.

##### Perchè appare il messaggio di errore "*Il documento selezionato non è stato trovato.*"?
**Causa**: il documento selezionato non è stato trovato nel database. Il motivo per cui possa succedere una cosa del genere è che il record del docuemnto è stato eliminato.
**Soluzione**: verificare l'effettiva esistenza del documento nel database.

##### Perchè appare il messaggio di errore "*Non è stato possibile rigenerare il documento selezionato.*"?
**Causa**: questo è un messaggio generico di errore che risulterebbe qualora si verificasse un errore **di validazione** del documento rigenerato non codificato.
**Soluzione**: per capire di che errore si tratta è necessario consultare il file di log.
<!--stackedit_data:
eyJoaXN0b3J5IjpbMzcxOTcxMzAzXX0=
-->