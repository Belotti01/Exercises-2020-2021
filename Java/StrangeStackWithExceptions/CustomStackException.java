public class CustomStackException extends Exception {
	//Assegno valore di base <-1> per segnalare che il valore non è stato assegnato,
	//essendo che il valore di default del tipo int è <0> e potrebbe causare fraintendimenti
	private int stackSize = -1;

	public CustomStackException() {
		/* 
		Di base il messaggio delle Exception è null (ovvero non ha valore), 
		lanciandone quindi uno con il costruttore vuoto:
			throw new Exception();
		e stampando poi il valore del metodo <getMessage()> non si otterrebbe 
		nessun feedback utile. 
		Nella mia Exception personalizzata posso invece attribuire un valore String
		di base anche al costruttore vuoto:
		*/
		super("The Stack is empty and no value could be retrieved.");
	}

	public CustomStackException(String message) {
		//Lascio l'opzione di inserire un messaggio customizzato, costruttore che 
		//dovrebbe essere sempre disponibile nelle classi derivanti da Exception.
		super(message);
	}

	
	//Altri costruttori per dare dettagli più specifici della causa dell'eccezione,
	//con metodo di accesso a queste informazioni
	public CustomStackException(int stackSize) {
		this();	//Tengo il messaggio di base definito nel costruttore vuoto
		this.stackSize = stackSize;
	}

	public CustomStackException(String message, int stackSize) {
		this(message);
		this.stackSize = stackSize;
	}

	public int getStackSize() {
		return stackSize;
	}
}