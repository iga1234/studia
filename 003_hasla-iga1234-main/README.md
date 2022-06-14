# Zadanie nr 3 - Hasła

| Termin oddania | Punkty     |
|----------------|:-----------|
|    13.04.2021 23:00 |   10        |

--- 
Przekroczenie terminu o **n** zajęć wiąże się z karą:
- punkty uzyskania za realizację zadania są dzielone przez **2<sup>n</sup>**.

--- 
Na wejściu użytkownik ma do wyboru 3 opcje:
- ocena trudności hasła
- kodowanie hasła
- dekodowanie hasła

## Ocena trudności hasła [3 pkt]
Użytkownik proszony jest o wpisanie hasła do oceny. Funkcja oceniająca bierze pod uwagę długość i zróżnicowanie znaków (wielkość liter, użycie symboli specjalnych i cyfr). Po przetworzeniu hasła, funkcja zwraca jedną spośród czterech ocen:
- Słabe
- Średnie
- Dobre
- Silne

## Kodowanie hasła [4 pkt]
Przygotuj funkcję kodującą wpisane przez użytkownika hasło. Możesz użyć dobrze znanych metod takich jak [Szyfr Cezara](https://pl.wikipedia.org/wiki/Szyfr_Cezara) lub określić własną funkcję. Oprócz zakodowaneogo hasła, powinien być zwócony klucz tajny, który jest wymagany w przypadku chęci dekodowania hasła. 

## Dekodowanie hasła [3 pkt]
Napisz funkcję odwrotną do kodującej. Użytkownik wprowadza zakodowane hasło i klucz tajny, a zwraca mu się jawne hasło.

## Uwagi
1. Kluczem tajnym może być przesunięcie w przypadku Szyfru Cezara.
2. Dokładne parametry oceny trudności hasła ustal według własnego uznania.
3. Można korzystać z funkcji [ord()](https://www.w3schools.com/python/ref_func_ord.asp) oraz [chr()](https://www.w3schools.com/python/ref_func_chr.asp).
