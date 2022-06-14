import os


def create(plik, dane):
    array = []
    if os.path.isfile(plik):
        with open(plik, 'r', encoding='utf-8') as f:
            for line in f:
                line = line.replace("\n", "")
                array.append(line.split(";"))
    else:
        print("Plik z danymi nie istnieje.")

    for j in range(len(array)):
        x = True
        for i in range(len(dane)):
            if dane[i][0] == array[j][0]:
                x = False
        if x:
            dane.append(array[j])

    return dane


def write(dane):
    array = []
    unique_number = input("\nWprowadz ID: ")
    for i in range(len(dane)):
        if dane[i][0] == unique_number:
            print("W bazie jest już podane ID.")
            return write(dane)
    array.append(unique_number)
    name = input("Wprowadz imie: ")
    array.append(name)
    surname = input("Wprowadz nazwisko: ")
    array.append(surname)
    pesel = input("Wprowadz pesel: ")
    array.append(pesel)
    dane.append(array)

    return dane


def read(dane):
    for i in range(len(dane)):
        print("Id:", dane[i][0], "Imię:", dane[i][1], "Nazwisko:", dane[i][2], "Pesel:", dane[i][3])
    print("")


def update(dane):
    unique_number = input("Wprowadz ID: ")
    for i in range(len(dane)):
        if dane[i][0] == unique_number:
            name = input("Wprowadz imie: ")
            dane[i][1] = name
            surname = input("Wprowadz nazwisko: ")
            dane[i][2] = surname
            pesel = input("Wprowadz pesel: ")
            dane[i][3] = pesel
            return dane

    print("W bazie nie ma podanego ID.")
    return update(dane)


def delete(dane):
    unique_number = input("Wprowadz ID: ")
    for i in range(len(dane)):
        if dane[i][0] == unique_number:
            del dane[i]
            return dane

    print("W bazie nie ma podanego ID.")
    return delete(dane)


def average(dane):
    age = 0
    for i in range(len(dane)):
        pesel = dane[i][3]
        if int(pesel[2:4]) > 12:
            age = age + (2021 - (2000+int(pesel[:2])))
        elif int(pesel[:2]) <= 99:
            age = age + (2021 - (1900+int(pesel[:2])))

    age = age/len(dane)
    return age


def count(dane):
    men = 0
    women = 0
    for i in range(len(dane)):
        pesel = dane[i][3]
        if int(pesel[9]) % 2 == 0:
            women += 1
        elif int(pesel[9]) % 2 != 0:
            men += 1
    print("Liczba kobiet:", women)
    print("Liczba mężczyzn:", men)
