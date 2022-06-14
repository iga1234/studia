tekst = input("Wpisz tekst: ")
tekst = tekst.lower()
tab_pl = ['ą', 'ś', 'ć', 'ż', 'ź', 'ń', 'ł', 'ó', 'ę']
tab_ang = ['a', 's', 'c', 'z', 'z', 'n', 'l', 'o', 'e']
n = 0
for i in tab_pl:
    tekst = tekst.replace(i,tab_ang[n])
    n += 1

print(tekst)

