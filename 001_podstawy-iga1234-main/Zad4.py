daty = [
    {'dzien': 31, 'miesiac' : 2,'rok': 1994},
    {'dzien': 10, 'miesiac' : 10,'rok': 1987},
    {'dzien': 3, 'miesiac' : 12,'rok': 1959},
    {'dzien': 28, 'miesiac' : 2,'rok': 1994},
    {'dzien': 19, 'miesiac' : 5,'rok': 2020},
    {'dzien': 30, 'miesiac' : 8,'rok': 2005},
    {'dzien': 7, 'miesiac' : 1,'rok': 1991},
    {'dzien': 15, 'miesiac' : 3,'rok': 1987}
]
rok_max = 0
miesiac_max = 0
dzien_max = 0
n = len(daty)

for data in range(n):
    for rok in range(n-1):
        if daty[rok]['rok'] > daty[rok+1]['rok']:
            rok_max = daty[rok]
            daty[rok] = daty[rok + 1]
            daty[rok + 1] = rok_max

        elif daty[rok]['rok'] == daty[rok+1]['rok']:
            if daty[rok]['miesiac'] > daty[rok+1]['miesiac']:
                miesiac_max = daty[rok]
                daty[rok] = daty[rok + 1]
                daty[rok + 1] = miesiac_max

            elif daty[rok]['miesiac'] == daty[rok+1]['miesiac']:
                if daty[rok]['dzien'] > daty[rok + 1]['dzien']:
                    dzien_max = daty[rok]
                    daty[rok] = daty[rok + 1]
                    daty[rok + 1] = dzien_max

print(daty)




