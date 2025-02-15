arr = list(map(int, input().split()))
a = arr[0]
b = arr[1]
n = 1
arr_2 = [[0 for _ in range(b)] for _ in range(a)]

for i in range(a):
    for j in range(b):
        arr_2[i][j] = n
        n += 1

for i in arr_2:
    for num in i:
        print(num, end=' ')
    print()