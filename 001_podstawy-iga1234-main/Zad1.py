for i in range(100, 1000):
    a = i % 10
    b = ((i - a)/10) % 10
    c = ((i-a-b*10)/100)
    if c < b and b < a:
        print(i)