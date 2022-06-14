import CRUD1


def main():
    data = []
    choice = ''
    while choice != '8':
        choice = input("\nWybierz co chcesz zrobić:\n"
                       "1 - Wczytaj bazę danych z pliku\n"
                       "2 - Wpisz dane do bazy w konsoli\n"
                       "3 - Odczytaj dane\n"
                       "4 - Zmień dane\n"
                       "5 - Usuń rekord\n"
                       "6 - Oblicz średni wiek osób w bazie\n"
                       "7 - Oblicz liczbę kobiet i mężczyzn w bazie\n"
                       "8 - Zakończ\n"
                       "Wprowadź numer: ")
        print("")
        if choice == '1':
            plik = input("Wprowadź nazwę pliku z rozszerzeniem: ")
            data = CRUD1.create(plik, data)
        if choice == '2':
            data = CRUD1.write(data)
        if choice == '3':
            CRUD1.read(data)
        if choice == '4':
            data = CRUD1.update(data)
        if choice == '5':
            data = CRUD1.delete(data)
        if choice == '6':
            print("Średnia wieku: ", CRUD1.average(data))
        if choice == '7':
            CRUD1.count(data)


main()
