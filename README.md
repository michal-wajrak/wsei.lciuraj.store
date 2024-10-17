# Projekt prezentujący model MVC.

### Pobranie projektu z GitHub:

* Otwórz terminal (Command Prompt lub PowerShell na Windowsie, terminal na macOS lub Linuxie).

* Upewnij się, że masz zainstalowanego Git’a, wpisując polecenie:

`` git --version ``

Jeśli Git nie jest zainstalowany, pobierz i zainstaluj go z oficjalnej strony.

* W terminalu przejdź do katalogu, w którym chcesz umieścić projekt:

`` cd /sciezka/do/katalogu ``

* Skopiuj projekt z GitHub, wpisując polecenie:

`` git clone https://github.com/lciuraj/store.git ``


### Budowanie projektu za pomocą Mavena

* Upewnij się, że masz zainstalowanego Maven’a, wpisując polecenie:

`` mvn -v ``


Jeśli Maven nie jest zainstalowany, pobierz i zainstaluj go z oficjalnej strony.

* Aby zbudować projekt, w terminalu wpisz:

`` mvn clean install ``

> clean usuwa wszystkie pliki wygenerowane w poprzednich kompilacjach.

> install buduje projekt i instaluje jego artefakty w lokalnym repozytorium Maven.


### Uruchamianie Tomcat

* Pobierz Apache Tomcat z oficjalnej strony (użyj najnowszej stabilnej wersji).

* Rozpakuj pobrany plik ZIP (lub TAR.GZ dla systemów Unix) do wybranego katalogu.

* Upewnij się, że JAVA_HOME jest ustawione i wskazuje na Twoją instalację JDK, ponieważ Tomcat wymaga Javy. Możesz to zrobić w następujący sposób:
  * Na Windows: ``set JAVA_HOME=C:\ścieżka\do\jdk``
  * Na macOS/Linux: ``export JAVA_HOME=/ścieżka/do/jdk``

* Skopiuj wygenerowany plik .war do katalogu webapps w katalogu instalacyjnym Tomcat. Na przykład:
  * Windows: ``copy target\nazwa_projektu.war C:\Tomcat\webapps\``
  * macOS/Linux: ``cp target/nazwa_projektu.war /opt/tomcat/webapps/``

* Aby uruchomić Tomcat:
  * Na Windows uruchom skrypt startup.bat znajdujący się w katalogu bin Tomcata: ``C:\Tomcat\bin\startup.bat``
  * Na macOS/Linux uruchom skrypt startup.sh w katalogu bin: ``/opt/tomcat/bin/startup.sh``

* Otwórz przeglądarkę i wpisz w pasku adresu: ``http://localhost:8080/store_war_exploded/``

* Jeśli chcesz zatrzymać Tomcat:
  * Na Windows: uruchom skrypt shutdown.bat: ``C:\Tomcat\bin\shutdown.bat``
  * Na macOS/Linux: uruchom skrypt shutdown.sh: ``/opt/tomcat/bin/shutdown.sh``


# ZADANIA DO SAMODZIELNEGO WYKONANIA

## Zadanie 1: Dodaj przycisk "Rozmyśliłem się"
1. **Cel:** Dodanie przycisku, który będzie działał analogicznie do przycisku "Powrót do strony głównej" na każdej stronie działu.
2. **Kroki:**
  - Do każdego pliku `*.jsp` dodaj nowy formularz (`<form>`), który będzie zawierał przycisk z akcją powrotu na stronę główną.

## Zadanie 2: Dodaj nowy produkt do koszyka
1. **Cel:** Dodanie nowego produktu, który będzie można dodać do koszyka w taki sam sposób, jak już istniejące produkty.
2. **Kroki:**
  - Utwórz odpowiedni servlet obsługujący dodawanie tego produktu.
  - Utwórz odpowiedni plik `*.jsp` z formularzem umożliwiającym dodanie nowego produktu do koszyka.

## Zadanie 3: Dodaj przycisk "Wyczyść koszyk"
1. **Cel:** Dodanie funkcjonalności wyczyszczenia koszyka.
2. **Kroki:**
  - Dodaj metodę `clearBasket` do klasy `BasketService`.
  - Utwórz klasę `ClearBasketServlet` z odpowiednią metodą `doPost`, która wywoła `clearBasket`.
  - Zmodyfikuj odpowiednio klasę `BasketServlet`, aby obsługiwała akcję wyczyszczenia koszyka.

## Zadanie 4: Modyfikacja funkcji dodawania produktów do koszyka
1. **Cel:** Dodanie możliwości wyboru ilości produktów podczas dodawania ich do koszyka.
2. **Kroki:**
  - Dodaj pole `quantity` do encji produktu.
  - Zmodyfikuj metodę `buyItem` w klasie `BasketService`, aby obsługiwała ilość dodawanych produktów.
  - Zmodyfikuj metodę `doPost` w servletcie `AddToBasketServlet`, aby obsługiwała pole `quantity`.
  - Dodaj dodatkowe pole `input` typu `number` w odpowiednich plikach `*.jsp`.

## Zadanie 5: Sumowanie ilości produktów w koszyku
1. **Cel:** Zmodyfikowanie funkcji dodawania produktów do koszyka tak, aby ilość produktów sumowała się zamiast dodawać kolejny rekord tego samego produktu.
2. **Kroki:**
  - Zmodyfikuj metodę `buyItem` w klasie `BasketService`, aby sumowała ilość produktów w koszyku zamiast dodawać nowy wpis.

## Zadanie 6: Dodaj funkcjonalność odejmowania produktów
1. **Cel:** Dodanie możliwości odejmowania produktów z koszyka.
2. **Kroki:**
  - Utwórz metodę `sellItem` w klasie `BasketService`.
  - Utwórz servlet `SellFromBasketServlet` z metodą `doPost`, która obsłuży odejmowanie produktów.
  - Dodaj do plików `*.jsp` nowy formularz (`<form>`), analogiczny do formularza dodawania produktów, ale realizujący funkcję odejmowania produktów z koszyka.