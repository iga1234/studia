import random


def nowa_plansza():
    plansza = [[' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']]
    for i in range(1, 9):
        plansza.append([])
        for j in range(0, 8):
            if j == 0:
                plansza[i].append(i)
            plansza[i].append(" ")
    return plansza


def generuj_plansza(plansza):
    for i in plansza:
        for j in i:
            print(" ", j, "|", end="")
        print("\n---------------------------------------------")


def losuj_pionek(plansza):
    a = random.randint(1, 8)
    b = random.randint(1, 8)
    pionek = [a, b]
    plansza[a][b] = 'P'
    return pionek


def losuj_hetman(plansza, ilosc):
    for i in range(0, ilosc):
        c = random.randint(1, 8)
        d = random.randint(1, 8)
        while plansza[c][d] != " ":
            c = random.randint(1, 8)
            d = random.randint(1, 8)
        plansza[c][d] = 'K'


def pozycja(pionek, plansza):
    x = 0
    n = 1
    while pionek[0]-n > 0:
        if plansza[pionek[0]-n][pionek[1]] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]], pionek[0]-n)
            break
        n += 1
    n = 0
    while pionek[0] + n < 9:
        if plansza[pionek[0]+n][pionek[1]] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]], pionek[0] + n)
            break
        n += 1
    n = 0

    while pionek[1] - n > 0:
        if plansza[pionek[0]][pionek[1]-n] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]-n], pionek[0])
            break
        n += 1
    n = 0
    while pionek[1] + n < 9:
        if plansza[pionek[0]][pionek[1]+n] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]+n], pionek[0])
            break
        n += 1
    n = 0

    while pionek[0]-n > 0 and pionek[1]-n > 0:
        if plansza[pionek[0]-n][pionek[1]-n] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]-n], pionek[0]-n)
            break
        n += 1
    n = 0
    while pionek[0]+n < 9 and pionek[1]+n < 9:
        if plansza[pionek[0]+n][pionek[1]+n] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]+n], pionek[0]+n)
            break
        n += 1
    n = 0
    while pionek[0]-n > 0 and pionek[1]+n < 9:
        if plansza[pionek[0]-n][pionek[1]+n] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]+n], pionek[0]-n)
            break
        n += 1
    n = 0
    while pionek[0]+n < 9 and pionek[1]-n > 0:
        if plansza[pionek[0]+n][pionek[1]-n] == 'K':
            x += 1
            print("Hetman: ", plansza[0][pionek[1]-n], pionek[0]+n)
            break
        n += 1
    if x != 0:
        print("Ilość hetmanów mogących zbić pionka: ", x)
    else:
        print("Żaden hetman nie może zbić pionka.")


def usun(figura, plansza):
    plansza[figura[0]][figura[1]] = " "
    return plansza


def main():
    plansza = nowa_plansza()
    pionek = losuj_pionek(plansza)
    losuj_hetman(plansza, random.randint(1, 5))
    generuj_plansza(plansza)
    pozycja(pionek, plansza)
    wybor = ''
    while wybor != '4':
        wybor = input("\nCo chcesz zrobić? \n\n"
                              "1 - Wylosować nową pozycję dla pionka \n"
                              "2 - Usunąć dowolnego hetmana \n"
                              "3 - Ponownie sprawdź bicia \n"
                              "4 - Koniec \n\n"
                              "Wybierz cyfrę: ")

        if wybor == '1':
            usun(pionek, plansza)
            pionek = losuj_pionek(plansza)
            print("Zmieniliśmy pozycję pionka.\n")
            generuj_plansza(plansza)

        if wybor == '2':
            hetman = [0,0]
            liczby = [0, 1, 2, 3, 4, 5, 6, 7, 8]

            while plansza[hetman[0]][hetman[1]] != 'K':
                hetman.clear()
                lista = input("Podaj pozycję hetmana do usunięcia: ")
                lista = lista.upper()
                lista = lista.replace(' ', '')
                for i in range(len(plansza[0])):
                    if lista[0] == plansza[0][i]:
                        hetman.append(int(lista[1]))
                        hetman.append(liczby[i])
            usun(hetman, plansza)
            print("Usunęliśmy wskazanego hetmana.")
            generuj_plansza(plansza)


        if wybor == '3':
            generuj_plansza(plansza)
            pozycja(pionek, plansza)


main()