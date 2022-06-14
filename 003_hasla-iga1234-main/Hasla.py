import random


def rate(password):
    length = len(password)
    number = False
    big_letter = False
    small_letter = False
    other = False
    score = 0

    for i in password:
        if 47 < ord(i) < 58 and not number:
            number = True
            score += 1
        elif 64 < ord(i) < 90 and not big_letter:
            big_letter = True
            score += 1
        elif 96 < ord(i) < 123 and not small_letter:
            small_letter = True
            score += 1
        elif not i.isalnum() and not other:
            other = True
            score += 1

    if length > 11:
        score += 3
    elif 8 < length < 12:
        score += 2
    elif 5 < length < 9:
        score += 1

    return score


def szyfr_cezara(password):
    new = ''
    key = random.randint(1, 20)
    for i in password:
        i = ord(i) + key
        if i > 126:
            i = i - 94
        new = new + chr(i)
    return [new, key]


def decoding(password, key):
    old = ''
    for i in password:
        i = ord(i) - key
        if i < 33:
            i = i + 94
        old = old + chr(i)
    return old


def main():
    choice = ''
    while choice != '4':
        choice = input("\nWybierz co chesz zrobić: \n"
                   
                       "1 - ocena trudnosci hasla \n"
                       "2 - kodowanie hasla \n"
                       "3 - dekodowanie hasla \n"
                       "4 - koniec \n\n"
                       
                       "Wpisz cyfrę: ")

        if choice == '1':
            password = input("Wpisz haslo: ")
            score = rate(password)
            if score == 7:
                print("Silne")
            elif 7 > score > 4:
                print("Dobre")
            elif 5 > score > 2:
                print("Srednie")
            else:
                print("Słabe")

        if choice == '2':
            password = input("Wpisz haslo: ")
            new_password = szyfr_cezara(password)
            print("Nowe haslo:", new_password[0], "\nKlucz:", new_password[1])

        if choice == '3':
            key = ''
            password = input("Wpisz haslo: ")
            while not key.isdigit():
                key = input("Wpisz tajny klucz (liczba): ")
            old_password = decoding(password, int(key))
            print(old_password)


main()
