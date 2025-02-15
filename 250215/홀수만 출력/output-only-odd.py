arr = list(map(int,input().split()))
a = arr[0]
b = arr[1]
if a % 2 == 1:
    for i in range(a,b+1,2):
        print(i, end=' ')
else :
    for i in range(a+1, b+1,2):
        print(i, end=' ')