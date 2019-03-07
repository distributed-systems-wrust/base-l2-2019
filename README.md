# Task List 2 -2019

## Java RMI


Komendy:

```
#windows
mvnw.cmd package
#linux
./mvnw package


java -jar server/target/list2-2019-server-1.0-SNAPSHOT-jar-with-dependencies.jar

java -jar client/target/list2-2019-client-1.0-SNAPSHOT-jar-with-dependencies.jar

```

### [Docs](https://docs.oracle.com/javase/tutorial/rmi/index.html)


### Co się dzieje w kodzie (celowo nie jako komentarze w kodzie):

Server: 

	1. tworzy rejestr RMI na porcie 8080
	2. eksportuje implementację serwisu
	3. Binduje implementację pod daną nazwą

Klient:

	1. Pobiera rejestr
	2. Tworzy implementację callbacka
	3. Eksportuje callbacka tak aby była obiektem zdalnym
	4. Pobiera pieniek serwisu (wystawionego przez serwer)
	5. Wywołuje metodę w pieńku serwisu przekazując dane i zdalny callback


### Jak wygląda komunikacja:

1. Klient wywołuje metodę w pieńku serwera, przekazując swój callback jako zdalny obiekt
2. Serwer odbiera wywołanie klienta, w odpowiedzi wywołuje metodę przekazanego zdalnego callback
3. Implementacją callback odbiera wywołanie z serwera


### Zadania:

0. Przeczytaj wszystko zanim cokolwiek zrobisz żeby wiedzieć gdzie co implementować
1. Zaimplementuj metodę sprawdzającą czy dana liczba jest pierwsza
2. Zaimplementuj komunikację dwukierunkową klient/server:
	- wykorzystaj observer pattern
	- masz implementację komunikacji dwukierunkowej w kodzie
	Flow:
		- klient pobiera pieniek servera
		- wykorzystując odpowiednią metodą rejestruje się w nim
		- server może wykonać odpowiednie metody wykorzystując listę posiadanych klientów
3. Zaimplementuj rozproszone sprawdzanie która z danych liczb jest pierwsza:
	- istnieje implementacja klienta (workera) który potrafi sprawdzić czy dana liczba jest pierwsza
	- klienci sprawdzający rejestrują się w serwerze (masterze)
	- serwer (master) może przyjąć tablicę/listę liczb, dla których ma sprawdzić które liczby są pierwsze, wykorzystuje do tego posiadaną listę klientów sprawdzających
	

4. Powinny istnieć 3 projekty (moduły maven, nazwy przykładowe): 
	- worker_check - sprawdza czy dana liczba jest pierwsza, rejestruje się w masterze
	- master - posiada rejestr workerów, przyjmuje zapytanie o sprawdzenie która z liczb jest pierwsza, odpytuje workerów o poszczególne liczby
	- client - przekazuje zadanie sprawdzenia listy pod kątem tego która z liczb jest pierwsza do mastera i drukuje wynik
