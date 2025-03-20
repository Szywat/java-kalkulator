package kalkulator;

public class Calculator {
	private int state = 0; // Wartość
	private boolean err = false; // Błąd
	private int memory = 0; // Pamięć

	public int getState() { // Zwraca wartość
		return state;
	}

	public void setState(int state) { // Ustanawianie wartości
		this.state = state;
	}

	public void add(int value){ // Dodawanie
		state += value;
	}

	public void mult(int value){ // Mnożenie
		state *= value;
	}

	public void sub(int value){ // Odejmowanie
		state -= value;
	}

	public void div(int value){ // Dzielenie z uwzględnieniem błedu
		if (value == 0) {
			err = true;
		} else {
			state /= value;
		}
	}

	public void saveMem(){ // Ustawia pamięć na aktualną wartość
		memory = state;
	}

	public void useMem(){ // Dodaje zawartość pamięci do obecnej wartości
		state += memory;
	}

	public void addMem(){ // Dodaje wartość do pamięci
		memory += state;
	}

	public void subMem(){ // Odejmuje wartość od pamięci
		memory -= state;
	}

	public int getMem(){ // Zwraca pamięć
		return memory;
	}

}
